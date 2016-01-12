package com.demo.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownLoadServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req,resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		File file = new File("f:/test.txt");
		//设置相关类型的application/octet-stream
		resp.setContentType("application/x-msdownload");
		//设置头信息
		resp.setHeader("Content-Disposition", "attachment;filename=test.txt");
		ServletOutputStream sos = resp.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		byte[] a = new byte[1024];
		int len;
		while((len=fis.read(a, 0, a.length))!=-1){
			sos.write(a, 0, len);
			sos.flush();
		}
		fis.close();
		sos.close();
	}
	
	

}
