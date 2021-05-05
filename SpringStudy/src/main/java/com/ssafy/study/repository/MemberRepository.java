package com.ssafy.study.repository;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.study.dto.MemDTO;

//@Mapper
public interface MemberRepository {
	public boolean login(String num, String pw);
	public int insert(MemDTO m);
	public int update(MemDTO m);
	public int delete(String num);
	public MemDTO selectOne(String num);
	public List<MemDTO> selectList();
}
