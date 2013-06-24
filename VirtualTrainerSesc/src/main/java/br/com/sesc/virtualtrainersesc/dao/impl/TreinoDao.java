package br.com.sesc.virtualtrainersesc.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import br.com.sesc.virtualtrainersesc.dao.AbstractDao;
import br.com.sesc.virtualtrainersesc.dao.GenericDao;
import br.com.sesc.virtualtrainersesc.model.Treino;

@Repository("treinoDao")
public class TreinoDao extends AbstractDao<Treino> implements GenericDao<Treino> {

	public TreinoDao() {
		super(Treino.class);
	}

	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public Treino findById(Integer treinoId) {
		return (Treino) sessionFactory.getCurrentSession()
									  .getNamedQuery("Treino.findById")
									  .setParameter("id", treinoId).uniqueResult();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Treino> findByAlunoMatricula(Integer matricula) {
		return sessionFactory.getCurrentSession()
							 .getNamedQuery("Treino.findByAlunoMatricula")
							 .setParameter("matricula", matricula).list();
		
	}

}
