package br.com.sesc.virtualtrainersesc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.sesc.virtualtrainersesc.dao.impl.AlunoDao;
import br.com.sesc.virtualtrainersesc.dao.impl.ExercicioDao;
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
	
	@Autowired
	ExercicioDao exercicioDao;
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/admin", method={RequestMethod.GET, RequestMethod.POST})
	public String showAdminPage(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("alunos", alunoDao.findAll());
		
		return "admin";
	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/about", method={RequestMethod.GET, RequestMethod.POST})
	public String showAbout(HttpServletRequest request,HttpServletResponse response){
		
		return "about";
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
	public String treinoSave(@ModelAttribute("treinoForm") Treino treino, 
							 @PathVariable("matricula") Integer matricula, HttpServletRequest request) throws Exception{
		Aluno aluno = alunoDao.findByMatricula(matricula);
		
		treino.setAluno(aluno);
		
		treinoDao.save(treino);
		
		aluno = alunoDao.findByMatricula(matricula);
		aluno.getTreinos().size();
		
		request.setAttribute("aluno", aluno);
		
		return "treinosList";
	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/admin/{matricula}/treinos/{treinoId}", method=RequestMethod.GET)
	public String showExerciciosPage(@PathVariable("matricula") Integer matricula, 
									 @PathVariable("treinoId") Integer treinoId, 
									 HttpServletRequest request) {
		Treino treino = treinoDao.findById(treinoId);
		List<Exercicio> exercicios = treino.getExercicios();
		exercicios.size();
		
		request.setAttribute("exercicios", exercicios);
		request.setAttribute("treino", treino);
		
		return "exerciciosList";
	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/admin/{matricula}/treinos/{treinoId}/add", method=RequestMethod.GET)
	public String showExerciciosAddPage(@PathVariable("matricula") Integer matricula, 
										@PathVariable("treinoId") Integer treinoId, 
										Model model, HttpServletRequest request, HttpSession session) {
		
		Treino treino = treinoDao.findById(treinoId);
		
		Exercicio exercicio = new Exercicio();
		exercicio.setTreino(treino);
		
		model.addAttribute("exercicioForm", exercicio);
		model.addAttribute("treino", treino);
		
		return "exercicioAdd";
	}
	
	@Transactional
	@RequestMapping(value="/admin/{matricula}/treinos/{treinoId}/add/save", method=RequestMethod.POST)
	public String exercicioSave(@ModelAttribute("exercicioForm") Exercicio exercicio, 
								@PathVariable("matricula") Integer matricula, 
								@PathVariable("treinoId") Integer treinoId, 
								HttpServletRequest request) throws Exception{
		
		exercicio.setTreino(treinoDao.findById(treinoId));
		exercicioDao.save(exercicio);
		
		Treino treino = treinoDao.findById(treinoId);
		treino.getExercicios().size();
		
		request.setAttribute("exercicios", treino.getExercicios());
		request.setAttribute("treino", treino);
		
		return "exerciciosList";
		
	}
}
