$(function(){
	//console.info(11);
//	$.post("../../adminInfoServlet",{op:"getLoginInfo"},function(data){
//		if(data==""||data==null){
//			window.location="../login.html";
//		}else{
//			$("#index_loginuser").text(data.aname);
//			$("#index_loginphoto").attr("src","../../"+data.photos);
//		}	
//	},"json");
	
	$('#index_content_info').tabs('add',{   
	    title:'源辰信息',   	    
	    closable:true,   
	    fit:true,
	    href:"yc.html"
	});  

	//当点击菜单的时候，自动创建一个选项卡
	$("#index_menu_tree").tree({
		onClick:function(node){
			var tabs=$('#index_content_info');	//获取选项卡对象
			var title="源辰信息";
			var href="yc.html";
			if(node.id=="index_role"){
				if(tabs.tabs("exists","角色管理")){
					tabs.tabs("select","角色管理");
					return;
				}else{
				    title="角色管理";
				    href="roles.html";
				}
			}else if(node.id=="index_admin"){
				if(tabs.tabs("exists","管理员信息")){
					tabs.tabs("select","管理员信息");
					return;
				}else{
					title="管理员信息";
					href="admin.html";
				}
			}else if(node.id=="index_user"){
				if(tabs.tabs("exists","会员信息")){
					tabs.tabs("select","会员信息");
					return;
				}else{
					title="会员信息";
					href="user.html";
				}
			}else if(node.id=="index_types"){
				if(tabs.tabs("exists","商品类型信息")){
					tabs.tabs("select","商品类型信息");
					return;
				}else{
					title="商品类型信息";
					href="goodsType.html";
				}
			}else if(node.id=="index_shopping2"){
				if(tabs.tabs("exists","管理店铺信息")){
					tabs.tabs("select","管理店铺信息");
					return;
				}else{
					title="管理店铺信息";
					href="ManagerShopping.html";
				}
			}else if(node.id=="index_shopping3"){
				if(tabs.tabs("exists","添加店铺信息")){
					tabs.tabs("select","添加店铺信息");
					return;
				}else{
					title="添加店铺信息";
					href="addShopping.html";
				}
			}else if(node.id=="index_goods2"){
				if(tabs.tabs("exists","管理商品信息")){
					tabs.tabs("select","管理商品信息");
					return;
				}else{
					title="管理商品信息";
					href="goods.html";
				}
			}else if(node.id=="index_order"){
				if(tabs.tabs("exists","订单管理")){
					tabs.tabs("select","订单管理");
					return;
				}else{
					title="订单管理";
					href="orders.html";
				}
			}else{
				return ;
			}
			
			tabs.tabs("add",{
				title:title,
				closable:true,
				fit:true,
				href:href
			});
		}
	});
});