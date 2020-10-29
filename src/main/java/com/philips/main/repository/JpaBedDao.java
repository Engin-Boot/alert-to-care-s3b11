package com.philips.main.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.philips.main.entities.Bed;
import com.philips.main.utils.GenericUtils;

@Transactional
@Repository
public class JpaBedDao {

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