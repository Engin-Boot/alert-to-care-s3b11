package com.philips.AlertToCare.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.philips.AlertToCare.entities.Icu;
import com.philips.AlertToCare.utils.GenericUtils;

@Transactional
@Repository
public class JpaIcuDao {
	
	@PersistenceContext
    EntityManager eManager;
	
	public List<Icu> findAll(){
		return GenericUtils.castList(Icu.class, eManager.createQuery("SELECT i FROM Icu i").getResultList());
	}

}
