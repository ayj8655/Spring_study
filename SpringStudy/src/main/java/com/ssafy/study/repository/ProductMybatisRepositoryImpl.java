package com.ssafy.study.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.study.dto.ProductDTO;


@Repository("ProductMybatisRepositoryImpl")
public class ProductMybatisRepositoryImpl implements ProductRepository {

	@Autowired
	private SqlSession session;
	
	@Override
	public int insert(ProductDTO p) {
		
		return session.insert("ssafy.product.insert", p);
	}

	@Override
	public int update(ProductDTO p) {
		
		return session.update("ssafy.product.update", p);
	}

	@Override
	public int delete(String pid) {
		
		return session.delete("ssafy.product.delete", pid);
	}

	@Override
	public ProductDTO selectOne(String pid) {
		
		ProductDTO dto = session.selectOne("ssafy.product.selectOne", pid);
		return dto;
	}

	@Override
	public List<ProductDTO> selectList() {
		
		List<ProductDTO> list = session.selectList("ssafy.product.selectList");
		return list;
	}

}
