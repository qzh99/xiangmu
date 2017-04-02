$(function() {
	$.post("../getLoginInfo", function(data) {
		if (data == 1) {
			window.location = "../login.html";
		}
	});
	$('#index_content_info').tabs('add', {
		title : '欢迎你',
		closable : true,
		fit : true,
		href : "welcome.html"
	});

	var scoreData;
	$.get("../classes/teacherSelcetClass", {}, function(data1) {
		scoreData = data1;
	})
	
	var scoreStatus=0;
	var tabld = "";
	$("#index_menu_tree").tree({
		onClick : function(node) {
			var tabs = $('#index_content_info'); // 获取选项卡对象
			var title = "";
			var href = "welcome.html";
			
			if (node.id == "score") {
				if (tabs.tabs("exists", "")) {
					tabs.tabs("select", "");
					return;
				} else {
					var selected = $('#index_menu_tree').tree('getSelected');
					if (scoreStatus == 0) {
						$('#index_menu_tree').tree('append', {
							parent : selected.target,
							data : scoreData
						});
						scoreStatus++;
					}
				}
			} else if (node.id != "" && node.id != undefined) {
				if (tabs.tabs("exists", node.text)) {
					tabs.tabs("select", node.text);
					return;
				} else {
					if (tabld != "") {
						var tempTabArr = tabld.split(",");
						for (var i = 0; i < tempTabArr.length - 1; i++) {
							if (tabs.tabs("exists", tempTabArr[i])) {
								tabs.tabs('close', tempTabArr[i]);
							}
						}
					}
					tabld += node.text + ",";
					title = node.text;
					href = "score.jsp?id=" + node.id;
				}
			}else{
				return ;
			}
			tabs.tabs("add", {
				title : title,
				closable : true,
				fit : true,
				href : href
			});
		}
	})
})