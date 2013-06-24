package br.com.sesc.virtualtrainersesc.dao.impl;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.sesc.virtualtrainersesc.model.Treino;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springconfiguration-test.xml"})
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true)
@Transactional
public class TreinoDaoTest {

	@Autowired
	TreinoDao treinoDao;
	
	@Test
	@Ignore
	public void testFindById() {
		Treino treino = treinoDao.findById(1);
		
		System.out.println(treino.getExercicios());
	}

	@Test
	public void testFindByAlunoMatricula() {
		List<Treino> treinos = treinoDao.findByAlunoMatricula(1);
		
		System.out.println(treinos);
	}
}
