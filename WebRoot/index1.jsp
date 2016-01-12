<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body style="margin:0px;padding:0px">
	<div style="margin-left:20px;margin-top:20px;">
		<form action="saveFile.do" method="POST" enctype="multipart/form-data">
			<input type="file" name="selectFile" />
			<br>
			<input type="submit" name="btn1" value="点击提交">
		</form>
		<br>
		<div>
			<a href="download.do" >点击下载</a>
		</div>
	</div>
</body>
</html>