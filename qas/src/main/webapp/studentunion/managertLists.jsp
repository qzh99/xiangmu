<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<table id="managerLists"></table>

<div id="list_1" style="height: 30px">
	<a onclick="addMessages()" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" style="float: left">添加</a>
	<div class="datagrid-btn-separator"></div>
	<a href="javascript:deleteMessage()" class="easyui-linkbutton"
		data-options="iconCls:'icon-cancel',plain:true" style="float: left">删除</a>
	<div class="datagrid-btn-separator"></div>
	<a href="javascript:saveMessages()" class="easyui-linkbutton"
		data-options="iconCls:'icon-save',plain:true" style="float: left">保存</a>
</div>

<div id="addMessages" class="easyui-dialog" title="添加条例"
	style="width: 400px; padding: 30px 60px" data-options="closed:true">
	<form>
		<table cellpadding="5">
			<tr>
				<td>量化条例名:</td>
				<td><input id="name1" type="text" class="easyui-textbox"
					data-options="required:true"></input></td>
			</tr>

			<tr>
				<td>分值:</td>
				<td><input id="score1" type="text" class="easyui-textbox"
					data-options="required:true"></input></td>
			</tr>
		</table>
			
	</form>
	<div style="text-align: center; padding: 5px">
		<a onclick="addMessage()" class="easyui-linkbutton"
				data-options="iconCls:'icon-add'">添加</a>
	</div>
</div>


<script type="text/javascript">
	var editIndex = undefined;
	$('#managerLists').datagrid({
		url : '../selectLists',
		method : 'get',
		striped : true,//交替背景颜色显示行
		pagination : true,
		pageNumber : 1,
		fit : true,
		rownumbers : true,
		pageSize : 18,
		onClickCell : onClickCell,
		pageList : [ 18, 36, 54, 72, 90 ],
		columns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			field : 'qId',
			title : '编号',
			width : 100,
			align : 'center'
		}, {
			field : 'qName',
			title : '量化条例名称',
			width : 200,
			align : 'center',
			editor : 'text'
		}, {
			field : 'qScore',
			title : '分值',
			width : 100,
			align : 'center',
			editor : 'text'
		} ] ],
		toolbar : "#list_1"

	});
	
	function addMessages() {
		document.getElementById('name1').value ="";
		document.getElementById('score1').value ="";
		$("#addMessages").dialog("open");
	}
	
	function addMessage(){
		var name=$.trim($("#name1").val());
		var score=$.trim($("#score1").val());
		
		if(name==""||score==""){
			$.messager.alert('提示','请输入信息!','info');
			return;
		}
		
		$.post("../insertQuantization",{name:name,score:score},function(data){
			if(data>0){
				$("#addMessages").dialog("close");
				$.messager.show({
					title : '提示',
					msg : '添加成功',
					timeout : 5000,
					showType : 'slide'
				});
			}
			$('#managerLists').datagrid('reload');
		});
		
	}

	function deleteMessage() {
		var checked = $('#managerLists').datagrid('getSelections');
		var lengh = checked.length;
		if (lengh == 0) {
			$.messager.alert('提示', '请选择要删除的行!', 'info');
			return;
		}

		var qids = "";
		for (var i = 0; i < lengh - 1; i++) {
			qids += checked[i].qId + ","
		}
		qids += checked[lengh - 1].qId;

		$.post("../deleteQuantization", {
			list : qids
		}, function(data) {
			if (data > 0) {
				$.messager.show({
					title : '提示',
					msg : '删除成功',
					timeout : 5000,
					showType : 'slide'
				});
			}
			$('#managerLists').datagrid('reload');
		});
	}
	function saveMessages() {
		$('#managerLists').datagrid('endEdit', editIndex);//结束正在被编辑的行数据

		$.post("../updateQuantization", {
			list : JSON.stringify($('#managerLists').datagrid("getChanges"))
		}, function(data) {
			if (data > 0) {
				$.messager.show({
					title : '提示',
					msg : '修改成功',
					timeout : 5000,
					showType : 'slide'
				});
			}
			$('#managerLists').datagrid('reload');
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
		if ($('#managerLists').datagrid('validateRow', editIndex)) {
			$('#managerLists').datagrid('endEdit', editIndex);
			editIndex = undefined;
			return true;
		} else {
			return false;
		}
	}
	function onClickCell(index, field) {
		if (endEditing()) {
			$('#managerLists').datagrid('selectRow', index).datagrid(
					'editCell', {
						index : index,
						field : field
					});
			editIndex = index;
		}
	}
</script>
