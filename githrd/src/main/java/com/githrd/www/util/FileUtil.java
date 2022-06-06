package com.githrd.www.util;

import java.io.*;
import java.util.*;

import javax.servlet.http.*;

import com.githrd.www.vo.*;
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

/**
 * 이 클래스는 파일 업로드에 필요한 기능을 처리하고
 * 업로드 파일의 정보를 만들어주는 기능의 유틸리티적인 클래스
 * @author	이용현
 * @since	2022.05.23
 * 			
 * 			작업이력 ]
 * 				2022.05.23	- 담당자 : 이용현
 							- 클래스 제작
 */								
public class FileUtil {
	private ArrayList<FileVO> list;
	private HttpServletRequest req;
	private MultipartRequest multi;
	private String dir, path, bPath;
	
	public FileUtil() {}
	public FileUtil(HttpServletRequest req, String dir) {
		this.req = req;
		this.dir = dir;
		setMulti();
		setList();
	}
	
	// MultipartRequest 세팅함수
	public void setMulti() {
		path = this.getClass().getResource("/").getPath();
		//System.out.println("#####FileUtil path : " + path);
		path = path.substring(0, path.lastIndexOf("/WEB-INF")) + dir;
		//System.out.println("#####FileUtil path1 : " + path);
		/*
			path 경로
				==> 첨부하는 파일을 이 프로젝트에서 서비스 하는 경우에는
				
					req.getSession().gerServeltContext().getRealPath("upload");
		 */
		
		try {
			multi = new MultipartRequest(req, path, 1024 * 1024 * 10, "UTF-8", new FileRenamePolicy() {

				@Override
				public File rename(File file) {
					// 업로드하는 파일이 겹칠경우 호출되는 함수
					// 우리의 규칙  : 파일이름_숫자.확장자
					String filename = file.getName(); // 파일이름 추출함수
					String newname = filename;
					String name = filename.substring(0, filename.lastIndexOf("."));
					String ext = filename.substring(filename.lastIndexOf("."));
					int count = 0;
					File f = new File(path, newname); // 기존 파일 존재여부 확인
					// ==> 새로운 이름의 파일이 존재하는지 검사하고
					// 		존재하면 카운트를 증가시킨 새로운 이름으로 파일을 다시 만들어서
					//		그 파일이 존재하는지 검사
					while(f.exists()) {
						// 이 경우는 이미 파일이 있는 경우이므로
						// 카운트를 증가시켜서 파일을 다시 만든다.
						++count;
						newname = name + "_" + count + ext;
						
						f = new File(path, newname);
					}
					return f;
				}
				
			});
			/*
				MultipartRequest 생성자
					
					MultipartRequest(HttpServletRequest req, 저장경로, 업로드가능크기, 파일이름인코딩방식, 파일리네임정책);
			 */
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 파일정보 리스트 세팅함수
	public void setList() {
		list = new ArrayList<FileVO>();
		
		// 전송된 파일데이터의 키값만 뽑아본다.
		Enumeration en = multi.getFileNames(); // 전송된 파일들의 키값들만 추출
		while(en.hasMoreElements()) {
			String key = (String) en.nextElement();
			String oriname = multi.getOriginalFileName(key); // 업로드한 원래 이름
			if(oriname == null) {
				continue;
			}
			String savename = multi.getFilesystemName(key); // 업로드 된 저장 이름
			File file = multi.getFile(key);			// 파일 추출
			long len = file.length();				// 파일 사이즈
			
			// VO 만들고
			FileVO fVO = new FileVO();
			fVO.setId((String) req.getSession().getAttribute("SID"));
			fVO.setOriname(oriname);
			fVO.setSavename(savename);
			fVO.setDir(dir);
			fVO.setLen(len);
			
			list.add(fVO);
			
			saveBackup(file);
			
		}
		
	}
	
	// 업로드파일 작업폴더로 저장해주는 함수
	public void saveBackup(File file) {
		// 작업 경로를 만든다.
		
		// 수업내용
		//bPath = this.getClass().getResource("/").getPath();
		//System.out.println("#####FileUtil oribPath : " + bPath);
		//bPath = bPath.substring(0, bPath.indexOf("/source")) + "/git/jennie/jennie/src/main/webapp/resources/upload";
		//bPath = bPath.replaceAll("/", "\\");
		
		// 내컴퓨터에 맞게 세팅
		bPath = this.getClass().getResource("/").getPath();
	//	System.out.println("#####FileUtil oribPath : " + bPath);
		bPath = bPath.substring(0, bPath.indexOf("/class")) + "\\Users\\1\\git\\jennie\\jennie\\src\\main\\webapp\\resources\\upload";
		
		
		
		
		//bPath = "C:\\Users\\1\\git\\jennie\\jennie\\src\\main\\webapp\\resources\\upload"; // 절대경로
		
		
	//	System.out.println("#####FileUtil bPath : " + bPath);
		File devFile = new File(bPath, file.getName());
		FileInputStream fin = null;
		PrintStream ps = null;
		try {
			byte[] buff = new byte[10240];
			fin = new FileInputStream(file);
			ps = new PrintStream(devFile);
			
			while(true) {
				int len = fin.read(buff);
				if(len == -1) break; // 읽은 데이터가 없는 경우
				ps.write(buff, 0, len);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<FileVO> getList() {
		return list;
	}
	public void setList(ArrayList<FileVO> list) {
		this.list = list;
	}
	public HttpServletRequest getReq() {
		return req;
	}
	public void setReq(HttpServletRequest req) {
		this.req = req;
	}
	public MultipartRequest getMulti() {
		return multi;
	}
	public void setMulti(MultipartRequest multi) {
		this.multi = multi;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getbPath() {
		return bPath;
	}
	public void setbPath(String bPath) {
		this.bPath = bPath;
	}
	
}
