package com.demo.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class FileUpLoadServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//获取上传的流
		InputStream is = req.getInputStream();
		File file = new File("f:/uploadfile");
		
		FileOutputStream fos = new FileOutputStream(file);
		
		byte[] buff = new byte[1024];
		int len ;
		while((len = is.read(buff, 0, buff.length))!=-1){
			fos.write(buff, 0, len);
			fos.flush();
		}
		fos.close();
		is.close();
		System.out.println("上传成功！");
		
		//读取临时文件  获取文件名
		String filename = null;
		RandomAccessFile reader = new RandomAccessFile(file, "r");
		reader.seek(0);
		System.out.println(reader.readLine());
		Pattern p = Pattern.compile("filename=\".*\"");
		String secondLine = reader.readLine();
		System.out.println(secondLine);
		Matcher m = p.matcher(secondLine);
		//正则匹配成功
		if(m.find()){
			filename = m.group();
			System.out.println("匹配成功"+filename);
		}else{
			System.out.println("没有找到文件名");
		}
		
		//设置保存上传文件的路径
//		String realPath = getServletContext().getRealPath("/")+"files";
//		System.out.println(realPath);
//		File f2 = new File(realPath,filename);
//		
//		BufferedReader br = new BufferedReader(
//				new InputStreamReader(new FileInputStream(file)));
//		BufferedWriter bw = new BufferedWriter(
//				new OutputStreamWriter(new FileOutputStream(f2)));
//		br.readLine();
//		br.readLine();
//		br.readLine();
//		String line = null;
//		while((line=br.readLine())!=null){
//			bw.write(line);
//			bw.newLine();
//			bw.flush();
//			if(line.startsWith("------")){
//				break;
//			}
//		}
//		
//		bw.close();
//		br.close();
	}
	

}
