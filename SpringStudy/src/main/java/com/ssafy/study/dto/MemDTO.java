package com.ssafy.study.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="MemDTO : 회원정보",description="회원 num pw, name, tel")
public class MemDTO implements Serializable{
	@ApiModelProperty(value="num")
	private String num;
	@ApiModelProperty(value="pw")
	private String pw;
	@ApiModelProperty(value="name")
	private String name;
	@ApiModelProperty(value="tel")
	private String tel;
	
	public MemDTO() {
		
	}
	
	public MemDTO(String num, String pw, String name, String tel) {
		this.num = num;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
	}
	
	

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}
	
	
}
