package com.zhoubo.service;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
@Service("downloadImp")
public class DownLoadFileServiceImp implements FileService {

	//返回商品信息模板表
	@Override
	public void getProductInformationFile(HttpServletResponse response) {
		String path = "F:\\GitRe\\shop\\src\\main\\resources\\file\\商品信息模板.xlsx";
		//当文件名不是英文时，最好使用url解码器去解码
		File file = new File(path);
		FileInputStream fis =null;
		OutputStream os = null;
		try {
			path = URLEncoder.encode(path,"UTF-8");
			response.setCharacterEncoding("UTF-8");
			//contentType 内容格式,告诉浏览器返回的内容是什么
			 //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型   
	       // response.setContentType("multipart/form-data"); 
			String filename = "商品信息模板.xlsx";
			response.setContentType("application/vnd.ms-excel");
			//设置返回文件的名字 以下的格式能被浏览器解析
			response.setHeader("content-disposition", "attachment;filename=" + 
					URLEncoder.encode(filename, "UTF-8"));
			fis = new FileInputStream(file);
			os = response.getOutputStream();
			byte buffer[] = new byte[1024];
			int len = 0;
			while((len = fis.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			};
			} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(null != os) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			};
			if(null != fis) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			};
		}
		
	}

	/* (non-Javadoc)
	 * @商品信息表上传
	 */
	@Override
	public void uploadFile(HttpServletRequest request) {
		String fileName = "";
		
	}
	
}
