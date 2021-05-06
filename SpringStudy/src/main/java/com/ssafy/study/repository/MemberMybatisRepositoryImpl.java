package com.ssafy.study.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.study.dto.MemDTO;


@Repository("MemberMybatisRepositoryImpl")
public class MemberMybatisRepositoryImpl implements MemberRepository {

	@Autowired
	private SqlSession session;
	
	@Override
	public boolean login(String num, String pw) {
		boolean res = false;
		Map<String, String> map = new HashMap<String, String>();
		map.put("num", num);
		map.put("pw", pw);
		MemDTO dto = session.selectOne("ssafy.member.login", map);
		if(dto != null) {
			res = true;
		}
		return res;
	}

	@Override
	public int insert(MemDTO m) {
		
		return session.insert("ssafy.member.insert", m);
		
	}

	@Override
	public int update(MemDTO m) {
		
		return session.update("ssafy.member.update", m);
		
	}

	@Override
	public int delete(String num) {
		
		return session.delete("ssafy.member.delete", num);
		
	}

	@Override
	public MemDTO selectOne(String num) {
		
		MemDTO dto = session.selectOne("ssafy.member.selectOne", num);
		return dto;
	}

	@Override
	public List<MemDTO> selectList() {
		
		List<MemDTO> list = session.selectList("ssafy.member.selectList");
		return list;
	}


}
