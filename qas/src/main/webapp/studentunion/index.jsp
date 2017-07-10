<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>学生量化考核系统</title>
	<link rel="stylesheet" type="text/css" href="../easyui/css/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/css/icon.css">
	<link rel="stylesheet" type="text/css" href="../easyui/css/demo.css">
	
	<style>
		#body{
			background-color: B3DFDA;
		}
		.copyright{
			text-align:center;
			font-size:16px;
			font-weight:bold;
			color:#D44C0A !important;
			height:40px;
			line-height:40px;
			padding:0px;
			margin:0px;
		}
		
		.copyright span{
			background:url("../images/yclogo.png") no-repeat left center;
			padding-left:30px;
			font-size:16px;
			font-weight:bold;
		}
		
		.navy_header{
			float:right;
			margin-right:20px;
		}
		
		.navy_header div,.navy_header img{
			float:left;
			margin-left:10px;
		}
		
		.navy_header img{
			border-radius:100px;
		}
		.navy_head div p,.navy_header div p span{
			font-size:15px;
			font-weight:bold;
			text-align:center;
			color:#D44C0A !important;
		}
	</style>
	
	<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="../easyui/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../easyui/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="../easyui/js/index.js"></script>
	<script type="text/javascript">
    	function exit(){
    		$.messager.confirm('提示', '你确定要退出系统吗?', function(r){
    			if (r){
    				location='out.jsp';
    			}
    		});
    	}
    </script>
</head>
<body id="body"  class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:100px;background:#B3DFDA;">
		<img src="../images/logo.jpg" height=100px/>
		<div class="navy_header">
			<div>
			<input id="adminName" type="hidden" value='${sessionScope.currentuser.suName}'/>
				<p>当前用户: <span id="index_loginuser">${sessionScope.currentuser.suName}</span></p>
				<a onclick="exit()"  class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">退出</a> 
			</div>
		</div>
	</div>
	<div data-options="region:'west',split:true,title:'菜单'" style="width:200px;padding:10px;">
		<ul id="index_menu_tree" class="easyui-tree">  
		    <li>  
		        <span>主菜单</span>  
		        <ul>  
		            <li id="stuunionchangepwd">修改密码</li>  
		            <li id="lists">  
				                考核条例管理 
				  	</li>
				  	<li id="appraise" data-options="state:'closed'">
						量化考核
				  	</li>
		        </ul>  
		    </li>  
		</ul>  
		
	</div>
	<div data-options="region:'east',split:true,collapsed:true,title:'帮助'" style="width:200px;padding:10px;"></div>
	<div data-options="region:'south',border:false" style="height:40px;background:#A9FACD;padding:0px;">
		<p class="copyright"> &copy;<span> 版权所有</span></p>
	</div>
	<div data-options="region:'center',title:'内容',tools:[{
		iconCls:'icon-full',
		handler:function(){full();}
	},{
		iconCls:'icon-unfull',
		handler:function(){unFull();}
	}]">
		<div id="index_content_info" class="easyui-tabs" data-options="fit:true">  
		     
		</div>  
		
	</div>

</body>
</html>