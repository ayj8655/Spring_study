package com.ssafy.study.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.study.dto.MemDTO;
import com.ssafy.study.dto.ProductDTO;
import com.ssafy.study.service.ProductService;

@Controller
@RequestMapping("/pro")
public class ProductController {
	
	@Autowired
	@Qualifier("ProductServiceImpl")
	ProductService ser;
	
	@RequestMapping(value = "/regpage", method = {RequestMethod.GET, RequestMethod.POST})
	public String regPage() {
		return "/product/proreg";
	}
	
	@RequestMapping(value = "/proinsert", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView insetProduct(HttpServletRequest req,  ModelAndView mv) {
		String pid = req.getParameter("pid");
		String pname = req.getParameter("pname");
		int pprice = Integer.parseInt(req.getParameter("pprice"));
		ser.insert(pid, pname, pprice);
		
		mv.setViewName("redirect:/pro/prolist");
		return mv;
	}
	
	@RequestMapping(value = "/proupdate", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView updateProduct(ProductDTO pro, ModelAndView mv) {
		ser.update(pro.getPid(), pro.getPname(), pro.getPprice());
		
		mv.setViewName("redirect:/pro/prolist");
		return mv;
	}
	
	@RequestMapping(value = "/prodelete", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteProduct(@RequestParam("pid") String pid,  ModelAndView mv) {
		ser.delete(pid);
		
		mv.setViewName("redirect:/pro/prolist");
		return mv;
	}
	
	@RequestMapping(value = "/proview", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView viewProduct(HttpServletRequest req,  ModelAndView mv) {
		String pid = req.getParameter("pid");
		ProductDTO pro = ser.selectOne(pid);
		
		mv.addObject("pro", pro);
		mv.setViewName("/product/proview");
		return mv;
	}
	
	@RequestMapping(value = "/prolist", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listProduct(ModelAndView mv) {
		List<ProductDTO> list = ser.selectList();
		mv.addObject("pros", list);
		mv.setViewName("/product/proList");
		return mv;
	}
}
