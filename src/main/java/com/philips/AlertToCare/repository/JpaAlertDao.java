package com.philips.AlertToCare.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.philips.AlertToCare.entities.Alert;
import com.philips.AlertToCare.utils.GenericUtils;

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