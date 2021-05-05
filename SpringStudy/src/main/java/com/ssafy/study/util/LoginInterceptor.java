package com.ssafy.study.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.study.controller.HomeController;
import com.ssafy.study.service.MemberService;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Autowired
	MemberService mSer;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String servletPath = request.getServletPath();
		//System.out.println("interceptor........................");
		if(servletPath.endsWith("loginpage") || servletPath.endsWith("mem/regpage")
				|| servletPath.endsWith("/")
				|| servletPath.endsWith("mem/meminsert")
				|| servletPath.endsWith("mem/memlogin")
				|| servletPath.contains("/api")) {
			return true;
		}
		if(request.getSession().getAttribute("currentId")==null) {

			request.setAttribute("msg", "로그인 해주세요");
			request.getRequestDispatcher("/").forward(request, response);
			return false;
		}
		return true;
	}
	
	@Override	// controller의 handler가 끝나면 처리됨
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
	
	@Override	// view까지 처리가 끝난 후에 처리됨
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
}
