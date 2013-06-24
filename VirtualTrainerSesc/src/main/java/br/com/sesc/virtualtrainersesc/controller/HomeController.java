package br.com.sesc.virtualtrainersesc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.sesc.virtualtrainersesc.dao.impl.AcademiaDao;
import br.com.sesc.virtualtrainersesc.model.Academia;

@Controller
public class HomeController {

	@Autowired
	AcademiaDao academiaDao;
	
	@Transactional(readOnly=true)
	@RequestMapping(value="ola.do", method=RequestMethod.GET)
	public String showIndex(HttpServletRequest request,HttpServletResponse response){	
		
		List<Academia> all = academiaDao.findAll();
		
		for (Academia academia : all) {
			System.out.println(academia);
		}
		
		return "ola";
	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="olaJson.do", method=RequestMethod.GET)
	public @ResponseBody Academia showIndexJson(HttpServletRequest request,HttpServletResponse response) throws Exception{	
		
		List<Academia> all = academiaDao.findAll();
		
		for (Academia academia : all) {
			System.out.println(academia);
			
			return academia;
		}
		
		throw new Exception();
	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="olaJson1.do", method=RequestMethod.GET)
	public @ResponseBody List<Academia> showIndexJson1(HttpServletRequest request,HttpServletResponse response) throws Exception{	
		
		List<Academia> findAll = academiaDao.findAll();
		
		return findAll;
	}	
}
