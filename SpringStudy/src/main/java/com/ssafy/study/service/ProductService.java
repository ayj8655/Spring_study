package com.ssafy.study.service;

import java.util.List;

import com.ssafy.study.dto.ProductDTO;

public interface ProductService {
	public int insert(String pid, String pname, int pprice);
	public int update(String pid, String pname, int pprice);
	public int delete(String pid);
	public ProductDTO selectOne(String pid);
	public List<ProductDTO> selectList();
}
