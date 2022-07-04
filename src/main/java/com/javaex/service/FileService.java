package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.FileDao;
import com.javaex.vo.FileVo;

@Service
public class FileService {
	
	@Autowired
	private FileDao fileDao;

	// 파일 하드디스크 저장, 파일 정보(db저장) 추출 저장
	public String save(MultipartFile file) {
		System.out.println("FileService>save");

		String saveDir = "C:\\javaStudy\\upload";

		// 1. 파일 정보(db저장) 추출저장
		
		// 오리지널 파일명
		String orgName = file.getOriginalFilename();

		// 확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));

		// 저장파일명
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;

		// 파일경로(디렉토리+저장파일명)
		String filePath = saveDir + "\\" + saveName;

		// 파일사이즈
		long fileSize = file.getSize();

		// Vo로 묶기
		FileVo fileVo = new FileVo(orgName, saveName, filePath, fileSize);
		System.out.println(fileVo);

		// db 사진 저장 -> 과제
		fileDao.fileInsert(fileVo);
		
		
		// 2. 파일 저장
		try {
				byte[] fileData = file.getBytes();
	
				OutputStream os = new FileOutputStream(filePath);
	
				BufferedOutputStream bos = new BufferedOutputStream(os);
	
				bos.write(fileData);
				bos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return saveName;

	}

}
