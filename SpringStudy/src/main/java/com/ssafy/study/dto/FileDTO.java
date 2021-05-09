package com.ssafy.study.dto;

public class FileDTO {
	private String fid;
	private String name;
	private String path;
	
	public FileDTO() {
		super();
	}
	public FileDTO(String fid, String name, String path) {
		super();
		this.fid = fid;
		this.name = name;
		this.path = path;
	}
	public FileDTO(String name, String path) {
		
		this.name = name;
		this.path = path;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "FileDTO [fid=" + fid + ", name=" + name + ", path=" + path + "]";
	}
	
}
