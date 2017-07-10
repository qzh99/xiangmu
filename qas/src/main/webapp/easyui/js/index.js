$(function(){
	$.post("../getLoginInfo",function(data){
		if(data==1){
			window.location="../login.html";
		}
	});
	
	$('#index_content_info').tabs('add',{   
	    title:'欢迎你',   	    
	    closable:true,   
	    fit:true,
	    href:"welcome.html"
	});  
	
	var status=0;
	
	var appraiseData;
	$.get("../classes/selcetAllClass",{},function(data1){
		appraiseData=data1;
	})
	
	var tabld ="";
	//当点击菜单的时候，自动创建一个选项卡
	$("#index_menu_tree").tree({
		onClick:function(node){
			var tabs=$('#index_content_info');	//获取选项卡对象
			var title="";
			var href="welcome.html";
			
			if(node.id=="change_pwd"){
				if(tabs.tabs("exists","修改密码")){
					tabs.tabs("select","修改密码");
					return;
				}else{
				    title="修改密码";
				    href="studentChangePwd.jsp";
				}
			}else if(node.id=="studentAppraise"){
				if(tabs.tabs("exists","量化考核成绩")){
					tabs.tabs("select","量化考核成绩");
					return;
				}else{
					title="量化考核成绩";
					href="studentAppraise.jsp";
				}
			}else if(node.id=="studentScore"){
				if(tabs.tabs("exists","学科成绩")){
					tabs.tabs("select","学科成绩");
					return;
				}else{
					title="学科成绩";
					href="studentScore.jsp";
				}
			}else if(node.id=="finalRank"){
				if(tabs.tabs("exists","最终排名")){
					tabs.tabs("select","最终排名");
					return;
				}else{
					title="最终排名";
					href="finalRank.jsp";
				}
			}else if(node.id=="stuunionchangepwd"){
				if(tabs.tabs("exists","修改密码")){
					tabs.tabs("select","修改密码");
					return;
				}else{
					title="修改密码";
					href="studentUnionChangePwd.jsp";
				}
			}else if(node.id=="lists"){
				if(tabs.tabs("exists","考核条例管理")){
					tabs.tabs("select","考核条例管理");
					return;
				}else{
					title="考核条例管理";
					href="managertLists.jsp";
				}
			}else if (node.id == "studentSelectCourse") {
				if (tabs.tabs("exists", "学生选课")) {
					tabs.tabs("select", "学生选课");
					return;
				} else {
					title = "学生选课";
					href = "studentSelectCourse.jsp";
				}
			}else if(node.id=="appraise"){
				if(tabs.tabs("exists","")){
					tabs.tabs("select","");
					return;
				}else{
					var selected = $('#index_menu_tree').tree('getSelected');
					if(status==0){
						$('#index_menu_tree').tree('append', {
							parent: selected.target,
							data: appraiseData
						});
						status++;
					}
				}
			}else if(node.id=="admin_change_pwd"){
				if(tabs.tabs("exists","修改密码")){
					tabs.tabs("select","修改密码");
					return;
				}else {
					title = "修改密码";
					href = "adminChangePwd.jsp";
				}
			}else if(node.id=="manageStudent"){
				if(tabs.tabs("exists","管理学生")){
					tabs.tabs("select","管理学生");
					return;
				}else {
					title = "管理学生";
					href = "manageStudent.jsp";
				}
			}else if(node.id=="magageTeacher"){
				if(tabs.tabs("exists","管理教师")){
					tabs.tabs("select","管理教师");
					return;
				}else {
					title = "管理教师";
					href = "magageTeacher.jsp";
				}
			}else if(node.id=="manageStudentUnion"){
				if(tabs.tabs("exists","管理学生会成员")){
					tabs.tabs("select","管理学生会成员");
					return;
				}else {
					title = "管理学生会成员";
					href = "manageStudentUnion.jsp";
				}
			}else if(node.id!=""&&node.id!=undefined){
				if(tabs.tabs("exists",node.text)){
					tabs.tabs("select",node.text);
					return;
				}else{
					if(tabld!=""){
						var tempTabArr=tabld.split(",");
						for(var i=0;i<tempTabArr.length-1;i++){
							if(tabs.tabs("exists",tempTabArr[i])){
								 tabs.tabs('close',tempTabArr[i]);
							}
						}
					}
					tabld+=node.text+",";
					title=node.text;
					href="appraise.jsp?id="+node.id;
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
function getDate(strDate) {
	 
    var date = eval('new Date(' + strDate.replace(/\d+(?=-[^-]+$)/,

     function (a) { return parseInt(a, 10) - 1; }).match(/\d+/g) + ')');

    return formatDate(date);

}
function formatDate(date) {  
    var y = date.getFullYear();  
    var m = date.getMonth() + 1;  
    m = m < 10 ? '0' + m : m;  
    var d = date.getDate();  
    d = d < 10 ? ('0' + d) : d; 
   var h=date.getHours();
   var mi=date.getMinutes();
   var s=date.getSeconds();
    return y + '-' + m + '-' + d+" "+h+":"+mi+":"+s;  
}; 
