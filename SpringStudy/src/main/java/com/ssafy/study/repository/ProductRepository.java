package com.ssafy.study.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.study.dto.MemDTO;
import com.ssafy.study.dto.ProductDTO;

//@Mapper
public interface ProductRepository {
	public int insert(ProductDTO p);
	public int update(ProductDTO p);
	public int delete(String pid);
	public ProductDTO selectOne(String pid);
	public List<ProductDTO> selectList();
}
