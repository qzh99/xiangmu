<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="easyui-layout" data-options="fit:true">
	<div data-options="region:'center'">
		<table id="finalRank"></table>
	</div>
</div>

<script type="text/javascript">
	var studentSno = $("#studentSno").val();
	$("#finalRank").datagrid({
		url : '../studentFinalRank',
		method : 'get',
		queryParams : {
			studentSno : studentSno
		},
		sortName:'totals',
		sortOrder:'desc',
		fit : true,
		pagination : true,
		pageNumber : 1,
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50 ],
		columns : [ [ {
			field : 'sNo',
			title : '学号',
			width : 150,
			align : 'center'
		}, {
			field : 'sName',
			title : '姓名',
			width : 150,
			align : 'center'
		}, {
			field : 'stuAppraise',
			title : '综合测评分',
			width : 150,
			align : 'center'
		}, {
			field : 'stuScore',
			title : '学习成绩(平均绩)',
			width : 150,
			align : 'center'
		}, {
			field : 'totals',
			title : '总成绩',
			width : 150,
			align : 'center'
		}, {
			field : 'rank',
			title : '排名',
			width : 150,
			align : 'center',
			formatter : function(value, row, index) {
				var options=$("#finalRank").datagrid('getPager').data("pagination").options;
				return (options.pageNumber-1)*(options.pageSize)+(index+1);
			}

		} ] ]
	});
</script>