package com.hotels.peregrine.other;

public class ClassifiedFile {
	
	private String fileOriginName;
	private String fileStoreName;
	private Long fileSize;
	private String fileSizes;
	
	public String getFileSizes() {
		return fileSizes;
	}
	public void setFileSizes(String fileSizes) {
		this.fileSizes = fileSizes;
	}
	public String getFileOriginName() {
		return fileOriginName;
	}
	public ClassifiedFile setFileOriginName(String fileOriginName) {
		this.fileOriginName = fileOriginName;
		return this;
	}
	public String getFileStoreName() {
		return fileStoreName;
	}
	public ClassifiedFile setFileStoreName(String fileStoreName) {
		this.fileStoreName = fileStoreName;
		return this;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public ClassifiedFile setFileSize(Long fileSize) {
		this.fileSize = fileSize;
		return this;
	}
	
	
}
