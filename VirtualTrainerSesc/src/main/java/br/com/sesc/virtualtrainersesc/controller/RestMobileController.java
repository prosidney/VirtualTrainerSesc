package br.com.sesc.virtualtrainersesc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.sesc.virtualtrainersesc.dao.impl.AcademiaDao;
import br.com.sesc.virtualtrainersesc.dao.impl.AlunoDao;
import br.com.sesc.virtualtrainersesc.dao.impl.ExercicioDao;
import br.com.sesc.virtualtrainersesc.dao.impl.TreinoDao;
import br.com.sesc.virtualtrainersesc.model.Academia;
import br.com.sesc.virtualtrainersesc.model.Aluno;
import br.com.sesc.virtualtrainersesc.model.Exercicio;
import br.com.sesc.virtualtrainersesc.model.Treino;
import br.com.sesc.virtualtrainersesc.util.JsonReturn;

@Controller
public class RestMobileController {

	@Autowired
	AcademiaDao academiaDao;
	
	@Autowired
	TreinoDao treinoDao;	
	
	@Autowired
	ExercicioDao exercicioDao;
	
	@Autowired
	AlunoDao alunoDao;
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/rest/{name}", method = RequestMethod.GET)
	public @ResponseBody Academia getShopInJSON(@PathVariable String name) throws Exception {
		
		List<Academia> all = academiaDao.findAll();
		
		for (Academia academia : all) {
			System.out.println(academia);
			
			return academia;
		}
		
		throw new Exception("Não deveria chegar aqui");
	}
	
	@RequestMapping(value="/mobile/{ownerId}/{ownerPi}", method=RequestMethod.GET)
	public String findOwner(@PathVariable("ownerId") String theOwner, @PathVariable("ownerPi") String ownerPi, Model model) {
		System.out.println("["+theOwner+","+ownerPi+"]");
		
		return "ola";
	}

	@Transactional(readOnly=true)
	@RequestMapping(value="/mobile/exercicios/{treinoId}", method=RequestMethod.GET)
	public @ResponseBody JsonReturn findExercicios(@PathVariable("treinoId") Integer treinoId, Model model) {
		
		List<Exercicio> exerciciosBase = treinoDao.findById(treinoId).getExercicios();
		
		List<Object> exerciciosReturn = new ArrayList<Object>();
		
		for (Exercicio exercicio : exerciciosBase) {
			Exercicio exeClone = new Exercicio();
			
			exeClone.setId(exercicio.getId());
			exeClone.setExecucao(exercicio.getExecucao());
			exeClone.setEquipamento(exercicio.getEquipamento());
			exeClone.setMusculatura(exercicio.getMusculatura());
			exeClone.setQualidade(exercicio.getQualidade());
			
			exerciciosReturn.add(exeClone);
		}
		
		JsonReturn jsonReturn = new JsonReturn();
		jsonReturn.setListData(exerciciosReturn);
		
		return jsonReturn;
	}
	
	@Transactional
	@RequestMapping(value="/mobile/exercicios/{treinoId}/checkin", method=RequestMethod.GET)
	public @ResponseBody String checkInTreino(@PathVariable("treinoId") Integer treinoId, Model model) {
		
		Treino treino = treinoDao.findById(treinoId);
		
		if(treino.getQtde() < treino.getQtdeTotal()){
			treino.setQtde(treino.getQtde()+1);
			
			return "Checkin realizado com sucesso";
		}

		return "Nao e possivel fazer checkin, objetivo concluido, procure seu treinador para maiores detalhes.";
	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/mobile/treinos/{matricula}", method=RequestMethod.GET)
	public @ResponseBody JsonReturn findTreinos(@PathVariable("matricula") Integer matricula, Model model) {
		
		List<Treino> treinosBase = treinoDao.findByAlunoMatricula(matricula);
		
		List<Object> treinosReturn = new ArrayList<Object>();
		
		for (Treino treino : treinosBase) {
			Treino treinoClone = new Treino();
			
			treinoClone.setId(treino.getId());
			treinoClone.setNome(treino.getNome());
			treinoClone.setQtde(treino.getQtde());
			
			treinosReturn.add(treinoClone);
		}
		
		JsonReturn jsonReturn = new JsonReturn();
		jsonReturn.setListData(treinosReturn);
		
		return jsonReturn;
	}	
	
	@Transactional
	@RequestMapping(value="/mobile/login/{matricula}/{senha}", method=RequestMethod.GET)
	public @ResponseBody JsonReturn login(@PathVariable("matricula") Integer treinoId, @PathVariable("senha") String senha, Model model) {
		Aluno aluno = alunoDao.find(treinoId, senha);
		JsonReturn retorno = new JsonReturn();
		
		if(aluno == null){
			retorno.setData("Usuario e ou senha invalidos");
		} else {
			retorno.setData("OK");
		}
		
		return retorno;
	}
}
