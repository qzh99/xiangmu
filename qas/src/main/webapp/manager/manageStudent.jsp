<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<div style="text-align: center; padding: 50px">
		<form id="ff" method="post" style="margin: 0 auto">
			<table id="addStudnet" border="1" bordercolor="black" cellspacing="0" style="width: 800px; margin: 0 auto">
				<tr>
					<td width="200px">学号</td>
					<td width="200px">姓名</td>
					<td width="100px">班级号</td>
				</tr>
				<tr>
					<td contentEditable="true" width="200px" height="18px" id="sNo"></td>
					<td contentEditable="true" width="200px" height="18px" id="sName"></td>
					<td contentEditable="true" width="200px" height="18px" id="clessId"></td>
				</tr>
			</table>
		</form>
	</div>
	<div style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="submitForm()">确定</a>
	</div>
</div>
<script type="text/javascript">
	function submitForm() {
		var x = document.getElementById("addStudnet").rows[1].cells;
		var sno=$.trim(x[0].innerHTML.replace("<br>",""));
		var sname=$.trim(x[1].innerHTML.replace("<br>",""));
		var classid=$.trim(x[2].innerHTML.replace("<br>",""));
		
		$.post("../managerAddStudent",{sNo:sno,sName:sname,classesId:classid},function(data){
			data = parseInt($.trim(data));
			if(data>0){
				x[0].innerHTML="";
				x[1].innerHTML="";
				x[2].innerHTML="";
				$.messager.show({
					title : '提示',
					msg : '添加学生成功',
					timeout : 5000,
					showType : 'slide'
				});
			}else {
				$.messager.alert('提示','添加学生失败！','info');
			}
		});
	}
</script>
