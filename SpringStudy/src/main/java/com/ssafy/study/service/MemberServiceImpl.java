package com.ssafy.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.study.dto.MemDTO;
import com.ssafy.study.repository.MemberRepository;

@Service("MemberServiceImpl")
public class MemberServiceImpl implements MemberService{

	@Autowired
	@Qualifier("MemberMybatisRepositoryImpl")
	MemberRepository repo;

	
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,	//트랜젝션 처리
					rollbackFor=Exception.class,
					value="transactionManager")
	public int insert(String num, String pw, String name, String tel) {
		
//		트랜젝션 처리
//		repo.insert(new MemDTO(num, pw, name, tel));
//		repo.insert(new MemDTO(num, pw, name, tel));
		return  repo.insert(new MemDTO(num, pw, name, tel));
	}

	@Override
	@Transactional
	public int update(String num, String pw, String name, String tel) {
		
		return repo.update(new MemDTO(num, pw, name, tel));
	}

	@Override
	@Transactional
	public int delete(String num) {
		
		return repo.delete(num);
	}

	@Override
	public MemDTO selectOne(String num) {
		
		MemDTO m = repo.selectOne(num);
		return m;
	}

	@Override
	public List<MemDTO> selectList() {
		
		List<MemDTO> list = repo.selectList();
		return list;
	}

	@Override
	public boolean login(String num, String pw) {
		
		boolean res = repo.login(num, pw);
		
		return res;
	}
}
