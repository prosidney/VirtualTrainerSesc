package br.com.sesc.virtualtrainersesc.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import br.com.sesc.virtualtrainersesc.dao.AbstractDao;
import br.com.sesc.virtualtrainersesc.dao.GenericDao;
import br.com.sesc.virtualtrainersesc.model.Aluno;

@Repository("alunoDao")
public class AlunoDao extends AbstractDao<Aluno> implements GenericDao<Aluno> {

	public AlunoDao() {
		super(Aluno.class);
	}

	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public Aluno findByMatricula(Integer matricula) {
		return (Aluno) sessionFactory.getCurrentSession()
									 .getNamedQuery("Aluno.findByMatricula")
									 .setParameter("matricula", matricula).uniqueResult();
	}

	public Aluno find(Integer matricula, String senha) {
		return (Aluno) sessionFactory.getCurrentSession()
									 .getNamedQuery("Aluno.findByMatriculaSenha")
									 .setParameter("matricula", matricula)
									 .setParameter("senha", senha).uniqueResult();
}

}
