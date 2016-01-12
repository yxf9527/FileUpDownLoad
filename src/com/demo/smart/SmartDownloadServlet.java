package com.demo.smart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class SmartDownloadServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String filename = req.getParameter("filename");
		
		SmartUpload su = new SmartUpload();
		su.initialize(getServletConfig(), req, resp);
		//设置下载说明
		su.setContentDisposition(null);
	
		try {
			/**
			 * 尼玛注意这里不是下载的路径是你要下载文件的路径  
			 * 试问要下载的文件都不存在你下载个毛
			 * 日了 狗了
			 * */
			su.downloadFile(getServletContext().getRealPath("/")+"/files/"+filename);
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
