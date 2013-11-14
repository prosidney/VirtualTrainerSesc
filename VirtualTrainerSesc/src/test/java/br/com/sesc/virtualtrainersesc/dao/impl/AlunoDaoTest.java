package br.com.sesc.virtualtrainersesc.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.sesc.virtualtrainersesc.model.Aluno;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springconfiguration-test.xml"})
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
@Transactional
public class AlunoDaoTest {
	
	@Autowired
	AlunoDao alunoDao;

	@Test
	public void testSave() {
		Aluno aluno = new Aluno();
		
		aluno.setIdade(20);
		aluno.setMatricula(000001);
		aluno.setNome("Sidney");
		aluno.setPeso(new BigDecimal("85"));
		aluno.setSenha("ak47colt");
		
		alunoDao.save(aluno);
	}
	
	@Test
	public void testFindAll() {
		List<Aluno> findAll = alunoDao.findAll();
		
		System.out.println(findAll.size());
		
		for (Aluno aluno : findAll) {
			System.out.println(aluno);
		}
	}

}
