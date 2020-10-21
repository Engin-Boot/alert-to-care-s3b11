package com.philips.AlertToCare.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.philips.AlertToCare.entities.Bed;
import com.philips.AlertToCare.utils.GenericUtils;

@Transactional
@Repository
public class BedRepository {

	@PersistenceContext
	private EntityManager em;

	public List<Bed> findAllBeds() {

		return GenericUtils.castList(Bed.class, em.createQuery("SELECT b FROM Bed b").getResultList());
	}
	
	public Bed findBedById(int bedId) {
		
		return em.find(Bed.class, bedId);
	}
	
	public List<Bed> findBedsByIcuNumber(int icuId){
		
		return GenericUtils.castList(Bed.class,em.createQuery("select b from Bed b where b.icu.icuId = :paramId").setParameter("paramId", icuId).getResultList());
	}

}