<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
	<span>文件上传</span>
	<form action="smartup.do" method="post" enctype="multipart/form-data">
		<input type="file" name="file1" style="width:200px;height:22px;"><br>
		<input type="file" name="file2" style="width:200px;height:22px;"><br>
		<input type="file" name="file3" style="width:200px;height:22px;"><br>
		<input type="submit" value="点击提交" name="btn1">${msg}
	</form>
	<br>
	<div>
		下载<a href="download.do?filename=svn.txt" name="afile" >svn.txt</a>文件<br>
	</div>
	<div>
		<h2>批量下载</h2>
		<form action="batchDownloadServlet.do">
	  	 	<input type="checkbox"  name="filename" value="img1.jpg">Image1
	  	 	<input type="checkbox"  name="filename" value="img2.jpg">Image2
	  	 	<input type="checkbox"  name="filename" value="img3.jpg">Image3
	  	 	<input type="submit" value="下载">
	  	 </form> 
	</div>
</body>
</html>