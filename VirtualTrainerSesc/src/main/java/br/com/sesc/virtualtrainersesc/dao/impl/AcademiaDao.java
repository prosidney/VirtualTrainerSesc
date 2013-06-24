package br.com.sesc.virtualtrainersesc.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import br.com.sesc.virtualtrainersesc.dao.AbstractDao;
import br.com.sesc.virtualtrainersesc.dao.GenericDao;
import br.com.sesc.virtualtrainersesc.model.Academia;

@Repository("academiaDao")
public class AcademiaDao extends AbstractDao<Academia> implements GenericDao<Academia> {

	public AcademiaDao() {
		super(Academia.class);
	}

	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public Academia findById(Integer id) {
		return (Academia) sessionFactory.getCurrentSession()
										.getNamedQuery("Aparelho.findById")
										.setParameter("id", id).uniqueResult();
	}
}
