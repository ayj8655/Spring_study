package com.ssafy.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.study.dto.ProductDTO;
import com.ssafy.study.repository.ProductRepository;

@Service("ProductServiceImpl")
public class ProductServiceImpl implements ProductService {

	@Autowired
	@Qualifier("ProductMybatisRepositoryImpl")
	ProductRepository repo;
	
	@Override
	@Transactional
	public int insert(String pid, String pname, int pprice) {
		
		return repo.insert(new ProductDTO(pid, pname, pprice));
		
	}

	@Override
	@Transactional
	public int update(String pid, String pname, int pprice) {
		
		return repo.update(new ProductDTO(pid, pname, pprice));
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public int delete(String pid) {
		
		return repo.delete(pid);
		
	}

	@Override
	public ProductDTO selectOne(String pid) {
		
		ProductDTO pro = repo.selectOne(pid);
		return pro;
	}

	@Override
	public List<ProductDTO> selectList() {
		
		List<ProductDTO> list = repo.selectList();
		return list;
	}

}
