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

import com.ssafy.study.dto.MemDTO;
import com.ssafy.study.service.MemberService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins={"*"}, maxAge=6000)
@RestController
@RequestMapping(value="/api")
public class RestMemberController {
	
	@Autowired
	@Qualifier("MemberServiceImpl")
	MemberService ser;
	
//	@RequestMapping(value = "/meminsert", method = {RequestMethod.POST})
	@PostMapping("/meminsert")
	@ApiOperation(value="member 등록 서비스")
	public ResponseEntity<Map<String, Object>> insetMember(@RequestBody MemDTO dto) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			int insert = ser.insert(dto.getNum(), dto.getPw(), dto.getName(), dto.getTel());
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
	@PutMapping("/memupdate")
	@ApiOperation(value="MemDTO를 받아 member 수정 서비스")
	public ResponseEntity<Map<String, Object>> updateMember(@RequestBody MemDTO mem) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			int update = ser.update(mem.getNum(), mem.getPw(), mem.getName(), mem.getTel());
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
	@DeleteMapping("/memdelete/{num}")
	@ApiOperation(value="num을 받아 member 삭제 서비스")
	public ResponseEntity<Map<String, Object>> deleteMember(@PathVariable("num") String num) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		try {
			int delete = ser.delete(num);
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
	@GetMapping("/memview/{num}")
	@ApiOperation(value="num을 받아 member 조회 서비스", response=MemDTO.class)
	public @ResponseBody ResponseEntity<Map<String, Object>> viewMember(@PathVariable("num") String num) {
		ResponseEntity<Map<String, Object>> resEntity = null;
		MemDTO mem = null;
		try {
			mem = ser.selectOne(num);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resmsg", "조회 성공");
			map.put("resValue", mem);
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
	@GetMapping("/memlist")
	@ApiOperation(value="member 조회 서비스", response=List.class)
	public @ResponseBody ResponseEntity<Map<String, Object>> listMember() {
		ResponseEntity<Map<String, Object>> resEntity = null;
		List<MemDTO> list = null;
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
