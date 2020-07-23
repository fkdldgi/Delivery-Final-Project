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
 * Ŀ���Һ� ����� -> ����ڰ� ���� ���� ��
 * AbstractView�� ��ӹ޾� �����.
 */

public class DownloadView extends AbstractView{
	//�ٿ�ε�â���� �����ϱ�
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//1. �ٿ�ε�â���� �����ϱ�
		super.setContentType("application/octet-stream"); //8��Ʈ�� �Ǿ��ִ� ������Ÿ���̶�� ��
		File f=(File)model.get("file");
		String filename=(String)model.get("filename");
		long fileSize=(Long)model.get("filesize");
		response.setContentType(getContentType());
		response.setContentLength((int)fileSize);
		//�ٿ�ε�â�� ���ϸ��� �ѱ��� ��� �ѱ��� ������ �ʵ��� ���ڵ� ����
		filename=URLEncoder.encode(filename,"utf-8"); //utf-8�� �ڹ� ����.hwp�� ���� ������ ������� �����ڸ��� +�κ���
		filename=filename.replace("\\+", "%20");
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		//2. ������ �ٿ�ε� �ϱ�(Ŭ���̾�Ʈ ��ǻ�Ϳ� ���� �����ϱ�)
		OutputStream os=response.getOutputStream(); //Ŭ���̾�Ʈ �������� ����
		FileInputStream fis=new FileInputStream(f);
		FileCopyUtils.copy(fis,os);
		fis.close();
		os.close();
	}
}
