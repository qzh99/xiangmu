<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="easyui-layout" data-options="fit:true">
	<div data-options="region:'center',title:'成绩信息'">
		<table id="scoreId"></table>
	</div>
</div>
<div id="saveScore" style="height: 30px">
	<a onclick="teacherAddScore()" class="easyui-linkbutton"
		data-options="iconCls:'icon-save',plain:true" style="float: left;">保存</a>
</div>
<script type="text/javascript">
	var editIndex = undefined;
	$('#scoreId').datagrid(
			{
				url : '../selcetStuByClassId?id='
						+ $('#index_menu_tree').tree('getSelected').id,
				method : 'get',
				fit : true,
				onClickCell : onClickCell,
				pagination : true,
				pageNumber : 1,
				pageSize : 10,
				pageList : [ 10, 20, 30, 40, 50 ],
				columns : [ [ {
					field : 'sNo',
					title : '学号',
					width : 100,
					align : 'center'
				}, {
					field : 'sName',
					title : '姓名',
					width : 100,
					align : 'center'
				}, {
					field : 'timId',
					title : '课程号',
					width : 100,
					align : 'center'
				}, {
					field : 'timName',
					title : '课程名',
					width : 200,
					align : 'center'
				}, {
					field : 'sGrade',
					title : '成绩',
					width : 100,
					editor : 'text',
					align : 'center'
				} ] ],
				toolbar : '#saveScore'
			});
	function teacherAddScore() {
		$('#scoreId').datagrid('endEdit', editIndex);//结束正在被编辑的行数据
		$.post("../teacherAddScore", {
			scores: JSON.stringify($('#scoreId').datagrid("getChanges"))
		}, function(data) {
			if (data > 0) {
				$.messager.show({
					title : '提示',
					msg : '打分成功',
					timeout : 5000,
					showType : 'slide'
				});
			}
			$('#scoreId').datagrid('reload');
		});
	}

	$.extend($.fn.datagrid.methods, {
		editCell : function(jq, param) {
			return jq.each(function() {
				var opts = $(this).datagrid('options');
				var fields = $(this).datagrid('getColumnFields', true).concat(
						$(this).datagrid('getColumnFields'));
				for (var i = 0; i < fields.length; i++) {
					var col = $(this).datagrid('getColumnOption', fields[i]);
					col.editor1 = col.editor;
					if (fields[i] != param.field) {
						col.editor = null;
					}
				}
				$(this).datagrid('beginEdit', param.index);
				for (var i = 0; i < fields.length; i++) {
					var col = $(this).datagrid('getColumnOption', fields[i]);
					col.editor = col.editor1;
				}
			});
		}
	});

	function endEditing() {
		if (editIndex == undefined) {
			return true
		}
		if ($('#scoreId').datagrid('validateRow', editIndex)) {
			$('#scoreId').datagrid('endEdit', editIndex);
			editIndex = undefined;
			return true;
		} else {
			return false;
		}
	}
	function onClickCell(index, field) {
		if (endEditing()) {
			$('#scoreId').datagrid('selectRow', index).datagrid('editCell', {
				index : index,
				field : field
			});
			editIndex = index;
		}
	}
</script>

