package com.demo.smart;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 批量打包下载
 * */
public class BatchSmartDownloadServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("application/x-msdownload");
		resp.setHeader("Content-Disposition", "attachment;filename=batch.zip");
		String[] filenames = req.getParameterValues("filename");
		String path = getServletContext().getRealPath("/")+"/files/";
		ZipOutputStream zos = new ZipOutputStream(resp.getOutputStream());
		for(String name: filenames) {
			File file = new File(path+name);
			zos.putNextEntry(new ZipEntry(name));
			FileInputStream fis = new FileInputStream(file);
			byte[] buff = new byte[1024];
			int a ;
			while((a=fis.read(buff, 0, buff.length))!=-1){
				zos.write(buff, 0, a);
				zos.flush();
			}
			fis.close();
		}
		zos.setComment("批量下载说明");
		zos.close();
		
	}

	
}
