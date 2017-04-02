<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="easyui-layout" data-options="fit:true">

	<div id="addListToolbar" style="height: 30px">
		<a onclick="studentUnionAddMessages()" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" style="float: left">添加记录</a>
			<a onclick="studentUnionDeleteMessages()" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel',plain:true" style="float: left">删除记录</a>
	</div>

	<div data-options="region:'west',split:true,title:'学号选择'"
		style="width: 130px; padding: 10px;">
		<ul id="classTree" class="easyui-tree"
			data-options="
				url: '../selcetSIdByClassId?id='+$('#index_menu_tree').tree('getSelected').id,//在班级下查询学生
				method: 'get',
				animate: true,
				onClick: function(node){
						$('#scoreGrid').datagrid({   
					    url:'../appraiseAndStudent/selectStudnetAppraiseBySno',//查询某学生的量化情况
					    queryParams:{sNo:node.text},
					    method:'get',
					    fit:true,
					    pagination:true,
					    pageNumber:1,
					    pageSize:10,
					    pageList:[10,20,30,40,50],
					    columns:[[ 
					    	{field : 'ck',checkbox : true}  ,
					        {field:'sName',title:'姓名',width:100,align:'center'},  
					        {field:'qId',title:'考核项目ID',width:100,align:'center'},
					        {field:'qName',title:'考核项目',width:300,align:'center'}, 
					        {field:'sum',title:'成绩',width:100,align:'center'},
					        {field:'author',title:'操作者',width:100,align:'center'}, 
					        {field:'aTime',title:'操作时间',width:150,align:'center',
					        formatter: function(value,row,index){
										return getDate(row.aTime.toString());
							}
					        }  ,
					    ]] , 
					    toolbar: '#addListToolbar'
					});  
					$('#scoreGrid').datagrid('reload');
					}
				
			"></ul>
	</div>


	<div data-options="region:'center',title:'考核记录'">
		<table id="scoreGrid"></table>
	</div>

	<div id="addMessagesForStudnet" class="easyui-dialog" title="添加条例"
		style="width: 600px; height: 400px" data-options="closed:true">
		<table id="addMessagesTable" style="height: 100"></table>
	</div>
	<div id="list_tool" style="height: 30px">
		<a onclick="addMessagesForStudent()" class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true" style="float: left;">保存</a>
	</div>

</div>


<script type="text/javascript">
	var count = 0;
	function studentUnionAddMessages() {
		$("#addMessagesForStudnet").dialog("open");

		if (count == 0) {
			$('#addMessagesTable').datagrid({
				url : '../selectLists',
				method : 'get',
				striped : true,//交替背景颜色显示行
				pagination : true,
				pageNumber : 1,
				fit : true,
				rownumbers : true,
				pageSize : 18,
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
				toolbar : "#list_tool"
				
			});

			count++;
		}

	}

	function addMessagesForStudent() {
		var sNo=$('#classTree').tree('getSelected').text;//取到当前被操作的学生的学号
		var checked = $("#addMessagesTable").datagrid("getChecked");//getChecked取到所有checkbox被选中的行的数据,返回元素记录的数组数据。
		var name = $("#adminName").val(); 
		
		if (checked == null||checked=="") {
			$.messager.alert('提示', '请选择要操作的行!', 'info');
			return;
		}
		var length = checked.length;
		var qid = "";
		for (var i = 0; i < length - 1; i++) {
			qid += checked[i].qId + ","
		}
		qid += checked[length - 1].qId;

		$.post("../addMessagesForStudent", {
			sNo : sNo,
			author : name,
			qids : qid
		}, function(data) {
			if (data== 2) {
				$("#addMessagesForStudnet").dialog("close");
				$("#scoreGrid").datagrid('reload');
				$.messager.show({
					title : '提示',
					msg : '添加成功',
					timeout : 5000,
					showType : 'slide'
				});
			} else {
				$.messager.alert('提示','该考核记录或已存在！','info');
			}
		});
	}
	
	//删除记录
	function studentUnionDeleteMessages(){
		var sNo=$('#classTree').tree('getSelected').text;//取到当前被操作的学生的学号
		var checked = $("#scoreGrid").datagrid("getChecked");
		
		if (checked == null||checked=="") {
			$.messager.alert('提示', '请选择要操作的行!', 'info');
			return;
		}
		var length = checked.length;
		var qid = "";
		for (var i = 0; i < length - 1; i++) {
			qid += checked[i].qId + ","
		}
		qid += checked[length - 1].qId;
		$.post("../studentUnionDeleteMessages",{sNo:sNo,qids:qid},function(data){
			if(data==2){
				$("#scoreGrid").datagrid('reload');
				$.messager.show({
					title : '提示',
					msg : '删除成功',
					timeout : 5000,
					showType : 'slide'
				});
			}else{
				$.messager.alert('提示','系统错误请重试！','info');	
			}
		});
	}
</script>
