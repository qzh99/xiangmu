<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<script type="text/javascript">
	function submitForm(){
		var pwd= $.trim($("#pwd").val());
		var rpwd= $.trim($("#rpwd").val());
		
		if(pwd==""||rpwd==""){
			document.getElementById("nul").style.display="";
			return;
		}
		
		if(pwd==rpwd){
			if(pwd.length<6){
				document.getElementById("short").style.display="";
				return;
			}else{
				$.post("../teacherChangePwd",{newPwd:rpwd},function(data){
					data = parseInt($.trim(data));
					if(data==1){
						var tabs=$('#index_content_info');	//获取选项卡对象//获取选项卡对象
						tabs.tabs('close', "修改密码");
						$.messager.alert('提示','密码修改成功！','info');
					}else if(data==2){
						document.getElementById("like").style.display="";
					}else {
						alert("抱歉系统发生错误请重试！");
						return ;
					}
				});
			}
			
		}else{
			document.getElementById("check").style.display="";
		}
	}
</script>
<div>
	<div style="text-align: center; padding: 5px">
		<form id="ff" method="post" style="width: 232px; margin: 0 auto">

			<table cellpadding="5">
				<tr>
					<td>新的密码:</td>
					<td><input id="pwd" type="password" class="easyui-textbox"  data-options="required:true"></input></td>
				</tr>

				<tr>
					<td>确认密码:</td>
					<td><input id="rpwd" type="password" class="easyui-textbox"  data-options="required:true"></input></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="check" style="text-align: center; color: red; display: none;" ><p>两次输入的密码不一致，请检查后重新输入！</p></div>
	<div id="nul" style="text-align: center; color: red; display: none;" ><p>密码不能为空！</p></div>
	<div id="like" style="text-align: center; color: red; display: none;" ><p>新密码不能与旧密码相同！</p></div>
	<div id="short" style="text-align: center; color: red; display: none;" ><p>密码长度不能小于6位数！</p></div>
	
	<div style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">确定</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="document.getElementById('ff').reset()">重置</a>
	</div>
</div>