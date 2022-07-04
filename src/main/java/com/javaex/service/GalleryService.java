package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.GalleryDao;
import com.javaex.vo.GalleryVo;

@Service
public class GalleryService {

	// 필드
	@Autowired
	GalleryDao galleryDao;

	// 생성자

	// 메소드

	// 메소드 일반

	// **이미지 등록**
	public void upload(GalleryVo galleryVo, MultipartFile file) {
		System.out.println("GalleryService>upload()");

		// 저장된 드라이버 주소
		String saveDir = "C:\\javaStudy\\upload";

		// 오리지널 파일명
		String orgName = file.getOriginalFilename();

		// 확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));

		// 저장파일명
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;

		// 파일 경로(디렉토리+저장파일명)
		String filePath = saveDir + "\\" + saveName;

		// 파일사이즈
		long fileSize = file.getSize();

		// Vo로 묶기
		galleryVo.setOrgName(orgName);
		galleryVo.setSaveName(saveName);
		galleryVo.setFilePath(filePath);
		galleryVo.setFileSize(fileSize);

		System.out.println(galleryVo);

		// db 저장
		galleryDao.galleryInsert(galleryVo);

		// **파일 저장**
		try {
			byte[] fileData = file.getBytes();
			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);

			bos.write(fileData);
			bos.close();
		} catch (Exception e) {
		}

	};

	// 이미지 1개 정보 가져오기
	public GalleryVo getImg(int no) {
		System.out.println("GalleryService->getImg()");

		return galleryDao.getImg(no);
	}

	// 전체 가져오기
	public List<GalleryVo> getGallery() {
		System.out.println("GalleryService>getGallery");

		List<GalleryVo> galleryList = galleryDao.getGallery();

		return galleryList;
		// return galleryDao.getGallery();

	}

}
