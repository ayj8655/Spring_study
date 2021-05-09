package com.ssafy.study.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.study.dto.FileDTO;


@Controller
public class FileUploadController {
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	SqlSession session;
	
	
	@RequestMapping("/fileform")
	public String uploadJsp() {
		System.out.println("11111");
		return "fileform";
	}
	
	@RequestMapping(value = "/filedownload", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView fileOne(HttpServletRequest req,  ModelAndView mv) {
		String fid = req.getParameter("fid");
		FileDTO dto = session.selectOne("com.ssafy.repository.files.fileone", fid);
		System.out.println(dto);
		// 여기 파일다운로드 구현
		
		 File file = new File(dto.getPath());

		
		mv.addObject("downloadFile", file);
		mv.setViewName("download");
		return mv;
	}
	
	@RequestMapping(value = "/filelist", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listMember(ModelAndView mv) {
		List<FileDTO> filelist = session.selectList("edu.ssafy.repository.files.filelist");
		mv.addObject("files", filelist);
		mv.setViewName("/fileform");
		return mv;
	}
	
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public String write(@RequestParam("upfile") MultipartFile[] files, Model model, HttpServletRequest request)
			throws IllegalStateException, IOException {
		String realPath = servletContext.getRealPath("/upload");
		String today = new SimpleDateFormat("yyMMdd").format(new Date());
		String saveFolder = realPath + File.separator + today;
		System.out.println(saveFolder);
		File folder = new File(saveFolder);
		if (!folder.exists())
			folder.mkdirs();
		ArrayList<String> list = new ArrayList();
		for (MultipartFile mfile : files) {
			String originalFileName = mfile.getOriginalFilename();
			if (!originalFileName.isEmpty()) {
				
				System.out.println("originalFileName..................."+originalFileName);
				list.add(mfile.getOriginalFilename() + "   " + originalFileName);
				
				session.insert("edu.ssafy.repository.files.fileinsert",
						new FileDTO(originalFileName, folder.toString()+"/"+originalFileName));
				mfile.transferTo(new File(folder, originalFileName));
			}
		}
		
		return "redirect:/filelist";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="fileUpload2", method=RequestMethod.POST)
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
