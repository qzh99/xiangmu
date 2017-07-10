<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="easyui-layout" data-options="fit:true">
	<div data-options="region:'center'">
		<table id="studentAppraise"></table>
	</div>
</div>

<script type="text/javascript">
	var studentSno = $("#studentSno").val();
	$("#studentAppraise").datagrid({
		url : '../studentSelectAllAppraise',
		method : 'get',
		queryParams : {
			studentSno : studentSno
		},
		fit : true,
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
			field : 'qName',
			title : '考核项目名',
			width : 200,
			align : 'center'
		}, {
			field : 'qScore',
			title : '分值',
			width : 100,
			align : 'center'
		}, {
			field : 'author',
			title : '操作者',
			width : 100,
			align : 'center'
		}, {
			field : 'aTime',
			title : '操作时间',
			width : 150,
			align : 'center',
			formatter : function(value, row, index) {
				if(row.aTime==null||row.aTime==""){
					return null;
				}else{
					return getDate(row.aTime.toString());
				}
			}
		} ] ]
	});
</script>