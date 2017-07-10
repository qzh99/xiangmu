<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<div style="text-align: center; padding: 50px">
		<form id="teacherForm" method="post" style="margin: 0 auto">
			<table id="addTeacher" border="1" bordercolor="black" cellspacing="0" style="width: 400px; margin: 0 auto">
				<tr>
					<td width="200px">姓名</td>
				</tr>
				<tr>
					<td contentEditable="true" width="200px"  height="18px" id="tName"></td>
				</tr>
			</table>
		</form>
	</div>
	<div style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="submitFormTeacher()">确定</a>
	</div>
</div>
<script type="text/javascript">
	function submitFormTeacher() {
		var x = document.getElementById("addTeacher").rows[1].cells;
		var tname=$.trim(x[0].innerHTML.replace("<br>",""));
		$.post("../managerAddTeacher",{tname:tname},function(data){
			data = parseInt($.trim(data));
			if(data>0){
				x[0].innerHTML="";
				$.messager.show({
					title : '提示',
					msg : '添加教师成功',
					timeout : 5000,
					showType : 'slide'
				});
			}else {
				$.messager.alert('提示','添加教师失败！','info');
			}
		});
	}
</script>
