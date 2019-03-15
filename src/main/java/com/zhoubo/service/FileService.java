package com.zhoubo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FileService {
	void getProductInformationFile(HttpServletResponse response);
	void uploadFile(HttpServletRequest request);
}
