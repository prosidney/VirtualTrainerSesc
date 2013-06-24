package br.com.sesc.virtualtrainersesc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.sesc.virtualtrainersesc.dao.impl.AlunoDao;
import br.com.sesc.virtualtrainersesc.dao.impl.TreinoDao;
import br.com.sesc.virtualtrainersesc.model.Aluno;
import br.com.sesc.virtualtrainersesc.model.Exercicio;
import br.com.sesc.virtualtrainersesc.model.Treino;

@Controller
public class AdminController {

	@Autowired
	AlunoDao alunoDao;
	
	@Autowired
	TreinoDao treinoDao;
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String showAdminPage(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("alunos", alunoDao.findAll());
		
		return "admin";
	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/admin/{matricula}/treinos", method=RequestMethod.GET)
	public String showTreinosPage(@PathVariable("matricula") Integer matricula,  /*Model model, */HttpServletRequest request) {
		Aluno aluno = alunoDao.findByMatricula(matricula);
		aluno.getTreinos().size();
		
		request.setAttribute("aluno", aluno);
		
		return "treinosList";
	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/admin/{matricula}/treinos/{treinoId}", method=RequestMethod.GET)
	public String showExerciciosPage(@PathVariable("matricula") Integer matricula, @PathVariable("treinoId") Integer treinoId, HttpServletRequest request) {
		List<Exercicio> exercicios = treinoDao.findById(treinoId).getExercicios();
		exercicios.size();
		
		request.setAttribute("exercicios", exercicios);
		
		return "exerciciosList";
	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/admin/{matricula}/treinos/add", method=RequestMethod.GET)
	public String showTreinosAddPage(@PathVariable("matricula") Integer matricula, Model model, HttpServletRequest request, HttpSession session) {
		Aluno aluno = alunoDao.findByMatricula(matricula);
		
		Treino treino = new Treino();
		treino.setAluno(aluno);
		
		model.addAttribute("treinoForm", treino);
		model.addAttribute("aluno", aluno);
		
		return "treinoAdd";
	}
	
	@Transactional
	@RequestMapping(value="/admin/{matricula}/treinos/add/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("treinoForm") Treino treino, @PathVariable("matricula") Integer matricula, HttpServletRequest request) throws Exception{
		Aluno aluno = alunoDao.findByMatricula(matricula);
		
		treino.setAluno(aluno);
		
		treinoDao.save(treino);
		
		aluno = alunoDao.findByMatricula(matricula);
		aluno.getTreinos().size();
		
		request.setAttribute("aluno", aluno);
		
		return "treinosList";
	}
}
