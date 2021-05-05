package com.ssafy.study.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileUploadController {
	@RequestMapping("/uploadform")
	public String uploadJsp(){
		return "uploadForm";
	}
	
	@RequestMapping(value="fileUpload", method=RequestMethod.POST)
	public String fileUpload(HttpServletRequest request, HttpServletResponse response) {
		String path = "c://aaa";
		List<Map> resultList = new ArrayList();
		try {
			
			MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
			Iterator<String> iter = mhsr.getFileNames();

			MultipartFile mfile = null;
			String fieldName = "";
			
			File dir = new File(path);
			if (!dir.isDirectory()) {
				dir.mkdirs();
			}

			while (iter.hasNext()) {
				fieldName = iter.next();
				mfile = mhsr.getFile(fieldName);
				String oriName = null;

				oriName = new String(mfile.getOriginalFilename().getBytes("8859_1"), "UTF-8");

				if ("".equals(oriName)) {
					continue;
				}

				File serverFile = new File(path+File.separator+oriName);
				mfile.transferTo(serverFile);
				
				Map<String, Object> file = new HashMap();
				file.put("oriName", oriName);
				file.put("sfile", serverFile);
				resultList.add(file);
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("msg", "oriFileName:"+resultList.get(0).get("oriName")+
				", saveFileName:"+resultList.get(0).get("sfile"));
		return "index";
	}
}
