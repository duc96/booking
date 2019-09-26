package src.main.Model;

import java.io.Serializable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAOModel <T extends Serializable> {
	private Class<T> entityClass;
	  
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session currentSession = null;
  
    /**
     * Inject entity class
     * @param entityClass
     */
    public void setClazz(Class< T > entityClass){
       this.entityClass = entityClass;
    }
  
    /**
     * Find one method
     * @param id
     * @return Entity Object
     */
    public T findOne(long id){
      return (T) currentSession.get(entityClass, id);
    }
 
    /**
     * Find All
     * @return List Entity Object
     */
    public Criteria find() {
    	Criteria cr = currentSession.createCriteria(entityClass);
    	return cr;
    }
    
    /**
     * Create query
     */
    public CriteriaQuery<T> createQuery()
    {
    	CriteriaBuilder builder = currentSession.getCriteriaBuilder();
    	CriteriaQuery<T> query = builder.createQuery(entityClass);
    	Root<T> root = query.from(entityClass);
    	query.select(root);
    	return query;
    }
    
    /**
     * Insert Row
     * @param entity
     * @return
     */
    public T create(T entity) {
    	Transaction tx = null;
    	Session session = currentSession;
    	try {
            tx = session.beginTransaction();
            session.save(entity);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        
        return entity;
    }
 
    /**
     * Update Row
     * @param entity
     * @return
     */
    @SuppressWarnings("unchecked")
	public T update(T entity) {
        return (T) currentSession.merge(entity);
    }
 
    /**
     * Delete Row
     * @param entity
     */
    public void delete(T entity) {
    	currentSession.delete(entity);
    }
 
    /**
     * Delete Row by ID
     * @param entityId
     */
    public void deleteById(long entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }
 
    @Autowired
    protected void getCurrentSession() {
    	try {
    		currentSession = sessionFactory.getCurrentSession();
    	}catch(HibernateException e) {
    		currentSession = sessionFactory.openSession();
    	}
    }

}
