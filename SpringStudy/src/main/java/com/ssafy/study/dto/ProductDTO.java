package com.ssafy.study.dto;

public class ProductDTO {
	private String pid;
	private String pname;
	private int pprice;
	
	public ProductDTO() {
		super();
	}

	public ProductDTO(String pid, String pname, int pprice) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	@Override
	public String toString() {
		return "ProductDTO [pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + "]";
	}
	
	
}
