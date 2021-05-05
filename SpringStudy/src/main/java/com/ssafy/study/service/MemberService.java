package com.ssafy.study.service;

import java.util.List;

import com.ssafy.study.dto.MemDTO;

public interface MemberService {
	public boolean login(String num, String pw);
	public int insert(String num, String pw, String name, String tel);
	public int update(String num, String pw, String name, String tel);
	public int delete(String num);
	public MemDTO selectOne(String num);
	public List<MemDTO> selectList();
}
