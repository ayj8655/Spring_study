package com.ssafy.study.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.study.dto.ProductDTO;
import com.ssafy.study.service.ProductService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins={"*"}, maxAge=6000)
@RestController
@RequestMapping(value="/api")
public class RestProductController {
	
	@Autowired
	@Qualifier("ProductServiceImpl")
	ProductService ser;
	
//	@RequestMapping(value = "/meminsert", method = {RequestMethod.POST})
	@PostMapping("/proinsert")
	@ApiOperation(value="product 등록 서비스")
	public ResponseEntity<Map<String, Object>> insetProduct(@RequestBody ProductDTO dto) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			int insert = ser.insert(dto.getPid(), dto.getPname(), dto.getPprice());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "입력 성공");
			map.put("resValue", insert);
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		} catch(RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "입력 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}
	
//	@RequestMapping(value = "/memupdate", method = {RequestMethod.PUT})
	@PutMapping("/proupdate")
	@ApiOperation(value="ProductDTO를 받아 product 수정 서비스")
	public ResponseEntity<Map<String, Object>> updateProduct(@RequestBody ProductDTO dto) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			int update = ser.update(dto.getPid(), dto.getPname(), dto.getPprice());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "수정 성공");
			map.put("resValue", update);
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		} catch(RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "수정 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}
	
//	@RequestMapping(value = "/memdelete/{num}", method = {RequestMethod.DELETE})
	@DeleteMapping("/prodelete/{pid}")
	@ApiOperation(value="pid를 받아 product 삭제 서비스")
	public ResponseEntity<Map<String, Object>> deleteProduct(@PathVariable("pid") String pid) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			int delete = ser.delete(pid);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "삭제 성공");
			map.put("resValue", delete);
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		}catch(RuntimeException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "삭제 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}
	
//	@RequestMapping(value = "/memview/{num}", method = {RequestMethod.GET})
	@GetMapping("/proview/{pid}")
	@ApiOperation(value="pid를 받아 product 조회 서비스", response=ProductDTO.class)
	public @ResponseBody ResponseEntity<Map<String, Object>> viewProduct(@PathVariable("pid") String pid) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		ProductDTO pro = null;
		try {
			pro = ser.selectOne(pid);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "조회 성공");
			map.put("resValue", pro);
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			// TODO: handle exception
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "조회 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		}
		
		return resEntity;
	}
	
//	@RequestMapping(value = "/memlist", method = {RequestMethod.GET})
	@GetMapping("/prolist")
	@ApiOperation(value="product 조회 서비스", response=List.class)
	public @ResponseBody ResponseEntity<Map<String, Object>> listProduct() {
		ResponseEntity<Map<String, Object>> resEntity = null;
		List<ProductDTO> list = null;
		try {
			list = ser.selectList();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "조회 성공");
			map.put("resValue", list);
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		} catch (RuntimeException e) {
			// TODO: handle exception
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "조회 실패");
			resEntity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		}
		return resEntity;
	}
}
