package com.jhta.delivery.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

/*
 * 커스텀뷰 만들기 -> 사용자가 직접 만든 뷰
 * AbstractView를 상속받아 만든다.
 */

public class DownloadView extends AbstractView{
	//다운로드창으로 응답하기
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//1. 다운로드창으로 응답하기
		super.setContentType("application/octet-stream"); //8비트로 되어있는 데이터타입이라는 뜻
		File f=(File)model.get("file");
		String filename=(String)model.get("filename");
		long fileSize=(Long)model.get("filesize");
		response.setContentType(getContentType());
		response.setContentLength((int)fileSize);
		//다운로드창에 파일명이 한글인 경우 한글이 깨지지 않도록 인코딩 설정
		filename=URLEncoder.encode(filename,"utf-8"); //utf-8은 자바 과제.hwp와 같이 공백이 있을경우 공백자리에 +로붙음
		filename=filename.replace("\\+", "%20");
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		//2. 실제로 다운로드 하기(클라이언트 컴퓨터에 파일 복사하기)
		OutputStream os=response.getOutputStream(); //클라이언트 브라우저에 전송
		FileInputStream fis=new FileInputStream(f);
		FileCopyUtils.copy(fis,os);
		fis.close();
		os.close();
	}
}
