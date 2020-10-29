package com.philips.main.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.philips.main.entities.Alert;
import com.philips.main.utils.GenericUtils;

@Transactional
@Repository
public class JpaAlertDao {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public Alert addNewAlert(Alert alert) {
		em.persist(alert);
		return alert;
	}
	
	public List<Alert> findAllAlerts(int bedId) {
		
		return GenericUtils.castList(Alert.class, em.createQuery("SELECT a FROM Alert a where a.bed.bedId = :paramId").setParameter("paramId", bedId).getResultList());
	}
}