package br.com.sesc.virtualtrainersesc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.sesc.virtualtrainersesc.dao.impl.AlunoDao;
import br.com.sesc.virtualtrainersesc.model.Aluno;

@Controller
public class ClientController {
	
	@Autowired
	AlunoDao alunoDao;
	
	@RequestMapping(value="addClient.do", method=RequestMethod.GET)
	public String showClientAddPage(HttpServletRequest request, HttpServletResponse response, Model model){	
		model.addAttribute("alunoForm", new Aluno());
		
		return "clientAdd";
	}
	
	@Transactional
	@RequestMapping(value="saveClient.do", method=RequestMethod.POST)
	public String saveClient(@ModelAttribute("alunoForm") Aluno aluno, HttpServletRequest request){
		alunoDao.save(aluno);
		request.setAttribute("alunos", alunoDao.findAll());
		
		return "admin";
	}

}
