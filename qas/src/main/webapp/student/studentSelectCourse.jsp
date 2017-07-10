<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="easyui-layout" data-options="fit:true">
	<div id="studentDoCourseToolbar" style="height: 30px">
		<a onclick="studentAddCourse()" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" style="float: left">选择新的课程</a>
		<a onclick="studentDeleteCourse()" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel',plain:true" style="float: left">删除已选课程</a>
	</div>
	<div data-options="region:'center',title:'已选课程'">
		<table id="studentCheckedCourse"></table>
	</div>

	<div id="studentAddCourseButton" class="easyui-dialog" title="添加课程"
		style="width: 600px; height: 400px" data-options="closed:true">
		<div id="studentSaveCourseToolbar" style="height: 30px">
			<a onclick="studentSaveCourse()" class="easyui-linkbutton"
				data-options="iconCls:'icon-add',plain:true" style="float: left">保存</a>
		</div>
		<table id="addCourseTable" style="height: 100"></table>
	</div>

</div>
<script type="text/javascript">
	var sNo = $("#studentSno").val();
	$('#studentCheckedCourse').datagrid({
		url : '../studentSelectCourse',
		queryParams : {
			sNo : sNo
		},
		method : 'get',
		fit : true,
		pagination : true,
		pageNumber : 1,
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50 ],
		columns : [ [ {
			field : 'ck',
			checkbox : true
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
		} ] ],
		toolbar : '#studentDoCourseToolbar'

	});
	function studentAddCourse() {
		var count = 0;
		$("#studentAddCourseButton").dialog("open");
		if (count == 0) {
			$('#addCourseTable').datagrid({
				url : '../selectAllTimetable',
				method : 'get',
				striped : true,//交替背景颜色显示行
				pagination : true,
				pageNumber : 1,
				fit : true,
				rownumbers : true,
				pageSize : 10,
				pageList : [ 10, 20, 30, 40, 50 ],
				columns : [ [ {
					field : 'ck',
					checkbox : true
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
				} ] ],
				toolbar : '#studentSaveCourseToolbar'
			});

			count++;
		}
	}
	function studentSaveCourse() {
		var checked = $("#addCourseTable").datagrid("getChecked");
		if (checked == null || checked == "") {
			$.messager.alert('提示', '请选择要操作的行!', 'info');
			return;
		}
		var length = checked.length;
		var timId = "";
		for (var i = 0; i < length - 1; i++) {
			timId += checked[i].timId + ","
		}
		timId += checked[length - 1].timId;
		$.post("../studnetAddScore", {
			sNo : sNo,
			timId : timId
		}, function(data) {
			if (data == 2) {
				$("#studentAddCourseButton").dialog("close");
				$("#studentCheckedCourse").datagrid('reload');
				$.messager.show({
					title : '提示',
					msg : '选课成功',
					timeout : 5000,
					showType : 'slide'
				});
			} else {
				$.messager.alert('提示', '该课程已经存在！', 'info');
				return;
			}
		});
	}
	function studentDeleteCourse() {
		var checked = $("#studentCheckedCourse").datagrid("getChecked");
		if (checked == null || checked == "") {
			$.messager.alert('提示', '请选择要操作的行!', 'info');
			return;
		}
		var length = checked.length;
		var timId = "";
		for (var i = 0; i < length - 1; i++) {
			timId += checked[i].timId + ","
		}
		timId += checked[length - 1].timId;
		$.post("../studnetDeleteScore", {
			sNo : sNo,
			timId : timId
		}, function(data) {
			if (data == 2) {
				$("#studentAddCourseButton").dialog("close");
				$("#studentCheckedCourse").datagrid('reload');
				$.messager.show({
					title : '提示',
					msg : '课程退选成功',
					timeout : 5000,
					showType : 'slide'
				});
			} else {
				$.messager.alert('提示', '系统开小差，请重试！', 'info');
				return;
			}
		});

	}
</script>