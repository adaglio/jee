package com.wps.msk.core.services;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class CrudComplexService {

	/**
	 * Interface used to interact with the persistence context. A persistence
	 * context is a set of entity instances in which for any persistent entity
	 * identity there is a unique entity instance. The set of entities that can be
	 * managed by a given EntityManager instance is defined by a persistence unit.
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * Getter method for the current persistence context.
	 * 
	 * @return the persistence context used for all CRUD operations performed by
	 *         this class instance
	 */
	public EntityManager getEntityManager() {
		return em;
	}

	/**
	 * 
	 * Always creates a new entity and never updates an entity (always causes INSERT
	 * SQL operation). Otherwise, the method throws an exception as a consequence of
	 * primary key uniqueness violation.
	 * 
	 * Takes an entity instance, adds it to the context and makes that instance
	 * managed (ie future updates to the entity will be tracked).
	 * 
	 * @param t
	 *             entity to be persisted
	 * @return the instance filled with all the new values stored in the database
	 */
	public <T> T create(T t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;

	}

	

	/**
	 * 
	 * Look for an entity of the specified class and primary key. If the entity
	 * instance is contained in the persistence context, it is returned from there.
	 * 
	 * The search is carried out inside a new independent transaction.
	 * 
	 * @param id
	 *            primary key
	 * @param type
	 *            entity class
	 * @return the found entity instance or null if the entity does not exist
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public <T> T findDetachByPk(Object id, Class<T> type) {
		return (T) this.em.find(type, id);
	}

	/**
	 * 
	 * Look for an entity of the specified class and primary key. If the entity
	 * instance is contained in the persistence context, it is returned from there.
	 * 
	 * It must run inside a previously open transaction because all its
	 * relationships are LAZY so, once this method returns, a later attempt to
	 * navigate a lazy collection must also run inside the same transaction (to
	 * avoid "org.hibernate.LazyInitializationException")
	 * 
	 * @param id
	 *            primary key
	 * @param type
	 *            entity class
	 * @return the found entity instance or null if the entity does not exist
	 */
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public <T> T findByPk(Object id, Class<T> type) {
		return (T) this.em.find(type, id);
	}

	/**
	 * 
	 * Remove the  entity instance.
	 * 
	 * @param clazz
	 *            entity class
	 * @param t
	 *            primary key
	 */
	public <T> void delete(Class<T> clazz, Object t) {
		Object ref = this.em.getReference(clazz, t);
		this.em.remove(ref);
	}

	/**
	 * 
	 * Update a  entity.
	 * 
	 * Creates a new instance of your entity, copies the state from the supplied
	 * entity, and makes the new copy managed. The instance you pass in will not be
	 * managed (any changes you make will not be part of the transaction - unless
	 * you call merge again).
	 * 
	 * @param t
	 *             entity
	 * @return the instance filled with all the new values stored in the database
	 */
	public <T> T update(T t) {
		return (T) this.em.merge(t);
	}

	/**
	 * Execute a SELECT query and return the query results as an untyped List.
	 * 
	 * @param namedQuery
	 *            the name of a query defined in metadata
	 * @return a list of the results
	 */
	public <T> List<T> findByNamedQuery(Class<T> clazz, String namedQuery) {
		return (List<T>) this.em.createNamedQuery(namedQuery).getResultList();
	}

	/**
	 * Execute a SELECT query and return the query results as an untyped List.
	 * 
	 * @param queryName
	 *            the name of a query defined in metadata
	 * @param resultLimit
	 *            limit in the results count
	 * @return a list of the results
	 */
	public <T> List<T> findByNamedQuery(Class<T> clazz, String queryName, int resultLimit) {
		return (List<T>) this.em.createNamedQuery(queryName).setMaxResults(resultLimit).getResultList();
	}

	/**
	 * Execute a SELECT query and return the query results as an untyped List.
	 * 
	 * @param namedQuery
	 *            the name of a query defined in metadata
	 * @param parameters
	 *            set of parameter values to use in the query
	 * @return a list of the results
	 */
	public <T> List<T> findByNamedQuery(Class<T> clazz, String namedQuery, Map<String, Object> parameters) {
		return findByNamedQuery(clazz, namedQuery, parameters, 0);
	}

	/**
	 * Execute a SELECT query and return the query results as an untyped List.
	 * 
	 * @param namedQuery
	 *            the name of a query defined in metadata
	 * @param parameters
	 *            set of parameter values to use in the query
	 * @param resultLimit
	 *            maximum number of results to retrieve
	 * @return a list of the results
	 */
	public <T> List<T> findByNamedQuery(Class<T> clazz, String namedQueryName, Map<String, Object> parameters,
			int resultLimit) {

		Set<Entry<String, Object>> rawParameters = parameters.entrySet();

		Query query = this.em.createNamedQuery(namedQueryName);

		if (resultLimit > 0) {
			query.setMaxResults(resultLimit);
		}

		for (Entry<String, Object> entry : rawParameters) {

			query.setParameter(entry.getKey(), entry.getValue());

		}

		return (List<T>) query.getResultList();

	}

	/**
	 * Selects, using the Criteria API, all the values of a given entity and return
	 * them as an untyped List
	 * 
	 * @param type
	 *            entity class
	 * @return a list of the results
	 */
	public <T> List<T> findAll(Class<T> type) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> q = cb.createQuery(type);
		Root<T> r = q.from(type);
		return em.createQuery(q).getResultList();
	}

	

}
