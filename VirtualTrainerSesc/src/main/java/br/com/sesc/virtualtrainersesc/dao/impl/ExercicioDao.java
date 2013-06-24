package br.com.sesc.virtualtrainersesc.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import br.com.sesc.virtualtrainersesc.dao.AbstractDao;
import br.com.sesc.virtualtrainersesc.dao.GenericDao;
import br.com.sesc.virtualtrainersesc.model.Exercicio;

@Repository("exercicioDao")
public class ExercicioDao extends AbstractDao<Exercicio> implements GenericDao<Exercicio>{

	public ExercicioDao() {
		super(Exercicio.class);
	}

	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
}
