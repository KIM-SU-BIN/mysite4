package com.javaex.vo;

import org.springframework.web.multipart.MultipartFile;

public class GalleryVo {

	private int no;
	private int userNo;
	private String name;
	private String content;
	private String filePath;
	private String orgName;
	private String saveName;
	private long fileSize;

	// 생성자
	public GalleryVo() {

	}

	public GalleryVo(int userNo, String name, String content, String filePath, String orgName, String saveName,
			long fileSize) {
		this.userNo = userNo;
		this.name = name;
		this.content = content;
		this.filePath = filePath;
		this.orgName = orgName;
		this.saveName = saveName;
		this.fileSize = fileSize;
	}

	public GalleryVo(int no, int userNo, String name, String content, String filePath, String orgName, String saveName,
			long fileSize) {
		this.no = no;
		this.userNo = userNo;
		this.name = name;
		this.content = content;
		this.filePath = filePath;
		this.orgName = orgName;
		this.saveName = saveName;
		this.fileSize = fileSize;
	}
	
	//메소드
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	//메소드 일반
	@Override
	public String toString() {
		return "GalleryVo [no=" + no + ", userNo=" + userNo + ", name=" + name + ", content=" + content + ", filePath="
				+ filePath + ", orgName=" + orgName + ", saveName=" + saveName + ", fileSize=" + fileSize + "]";
	}

}
