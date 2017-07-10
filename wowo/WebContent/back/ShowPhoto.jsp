<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div>
    	<video id="video" width="640px" height="480px" autoplay></video>
        <button id="openVideo">OpenVideo</button>
        <button id="paiPhoto">Snap Photo</button>
        <canvas width="800px" height="1000px" id="canvas"></canvas>
    </div>
   
</body>
	<script>
		var openVideo=document.getElementById("openVideo");
		var paiPhoto=document.getElementById("paiPhoto");
		var canvas=document.getElementById("canvas");
		//获取画笔
		var context=canvas.getContext("2d");
		///getContext方法创建一个在画布上绘图的环境，他里面的参数指定了你要绘制的图形类型
		
		var video=document.getElementById("video");
		
		openVideo.addEventListener("click",function(){
			//获取浏览器
			navigator.getMedia=(navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia ||  navigator.msGetUserMedia);
			
			//constraints 这个参数描述了被 LocalMediaStream对象所支持的媒体类型
			navigator.getMedia(
				{
					video:true,
					audio:false	
				},
				//successCallback  调用successCallback 并传入LocalMediaStream 对象，这个对象包含媒体流。
				//回调函数
				function(localMediaStream){
						video.src=window.URL.createObjectURL(localMediaStream);//视频流给video/标签
						
							
				},
				//errorCallback
				function(err){
					console.log(err);	
				}
			); 
		});
		paiPhoto.addEventListener("click",function(){
			context.drawImage(video,0,0,800,1000);	
		});
		
		
		
		
		
	</script> 
</html>