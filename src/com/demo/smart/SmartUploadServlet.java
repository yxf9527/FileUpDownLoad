package com.demo.smart;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;

public class SmartUploadServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	/**
	 * 将上传的文件保存到files下
	 * */
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String path = getServletContext().getRealPath("/")+"files";
		File file = new File(path);
		if(!file.exists()){
			file.mkdir();
		}
		
		String msg = "上传成功！";
		
		SmartUpload su = new SmartUpload();
		//初始化对象
		su.initialize(getServletConfig(), req, resp);
		//设置上传文件大小  2M
		su.setMaxFileSize(1024*1024*2);
		//设置所有文件的总大小 10M
		su.setTotalMaxFileSize(1024*1024*10);
		//设置允许上传文件的大小
		su.setAllowedFilesList("txt,jpg,gif");
		
		try {
			//设置禁止上传的文件类型
			su.setDeniedFilesList("doc");
			//开始上传文件
			su.upload();
			//保存上传文件  返回成功上传的文件数
			int a = su.save(path);
			System.out.println("成功上传"+a+"个文件！");
		} catch (Exception e) {
			msg = "上传失败！";
			e.printStackTrace();
		} 
		
		for(int i=0;i<su.getFiles().getCount();i++){
			com.jspsmart.upload.File tempFile = su.getFiles().getFile(i);
			System.out.println("------------------------");
			System.out.println("表单当中name属性值：" + tempFile.getFieldName());
			System.out.println("上传文件名：" + tempFile.getFieldName());
			System.out.println("上传文件长度:" + tempFile.getSize());
			System.out.println("上传文件的拓展名：" + tempFile.getFileExt());
			System.out.println("上传文件的全名：" + tempFile.getFilePathName());
			System.out.println("------------------------");
		}
		
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("/smart.jsp").forward(req,resp);
	}

}
