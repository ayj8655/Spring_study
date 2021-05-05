package com.ssafy.study.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.study.dto.MemDTO;
import com.ssafy.study.service.MemberService;

@Controller
@RequestMapping(value="/mem")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@ExceptionHandler(Exception.class)
	public String allException(Exception e, Model m) {
		String message = e.getMessage();
		m.addAttribute("message", message);
		return "allErrorPage";
	}
	
	@Autowired
	@Qualifier("MemberServiceImpl")
	MemberService ser;
	
	@RequestMapping(value = "/loginpage", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginPage() {
		logger.debug("loginPage");
		return "login";
	}
	
	@RequestMapping(value = "/memlogout", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView logoutMember(HttpServletRequest req, ModelAndView mv) {
		HttpSession session = req.getSession();
		session.invalidate();
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@RequestMapping(value = "/memlogin", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView loginMember(HttpServletRequest req, ModelAndView mv) {
		String num = req.getParameter("num");
		String pw = req.getParameter("pw");
		boolean res = ser.login(num, pw);
		if(res) {
			HttpSession session = req.getSession();
			session.setAttribute("currentId", num);
		}
		mv.setViewName("redirect:/mem/memlist");
		return mv;
	}
	
	@RequestMapping(value = "/regpage", method = {RequestMethod.GET, RequestMethod.POST})
	public String regPage() {
		return "/member/memreg";
	}
	
	@RequestMapping(value = "/meminsert", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView insetMember(HttpServletRequest req,  ModelAndView mv) {
		String num = req.getParameter("num");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		
		try {
			int insert = ser.insert(num, pw, name, tel);
			mv.setViewName("redirect:/mem/memlist");
		} catch(RuntimeException e) {
			mv.addObject("exception", e.getMessage());
			mv.setViewName("allErrorPage");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/memupdate", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView updateMember(MemDTO mem, ModelAndView mv) {
		try {
			int update = ser.update(mem.getNum(), mem.getPw(), mem.getName(), mem.getTel());
			mv.addObject("cnt", update);
			mv.setViewName("redirect:/mem/memlist");
		} catch(RuntimeException e) {
			mv.addObject("exception", e.getMessage());
			mv.setViewName("allErrorPage");
		}
		return mv;
	}
	
	@RequestMapping(value = "/memdelete", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteMember(@RequestParam("num") String num,  ModelAndView mv) {
		try {
			int delete = ser.delete(num);
			mv.addObject("cnt", delete);
			mv.setViewName("redirect:/mem/memlist");
		}catch(RuntimeException e) {
			mv.addObject("exception", e.getMessage());
			mv.setViewName("allErrorPage");
		}
		return mv;
	}
	
	@RequestMapping(value = "/memview", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView viewMember(HttpServletRequest req,  ModelAndView mv) {
		String num = req.getParameter("num");
		MemDTO mem = ser.selectOne(num);
		
		mv.addObject("mem", mem);
		mv.setViewName("/member/memview");
		return mv;
	}
	
	@RequestMapping(value = "/memlist", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listMember(ModelAndView mv) {
		
		List<MemDTO> list = ser.selectList();
		mv.addObject("mems", list);
		mv.setViewName("/member/memList");
		return mv;
	}
	
}
