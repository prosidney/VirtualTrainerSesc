package br.com.sesc.virtualtrainersesc.dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<T> implements GenericDao<T>{
	protected static final Logger log =  Logger.getLogger(AbstractDao.class.getName()); 
	
	@SuppressWarnings("rawtypes")
	private final Class typeClass;
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		log.info("finding all " + typeClass.getName() + " instances");
		return sessionFactory.getCurrentSession().createCriteria(typeClass).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}
	
	/** 
	 * @param argClass 
	 */  
	@SuppressWarnings("rawtypes")
	public AbstractDao(Class argClass) {  
		typeClass = argClass;  
	} 	

	public T save(T instance){
		log.info("inserindo dados na tabela " + typeClass.getName());
		sessionFactory.getCurrentSession().merge(instance);
		return instance;		
	}

	public void delete(T instance){
		log.info("Deletando dados na tabela " + typeClass.getName());
		sessionFactory.getCurrentSession().delete(instance);
	}
}
