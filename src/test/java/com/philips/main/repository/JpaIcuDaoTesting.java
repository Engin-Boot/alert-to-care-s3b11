package com.philips.main.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.philips.main.entities.Icu;
import com.philips.main.repository.JpaIcuDao;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(value = { JpaIcuDao.class })

public class JpaIcuDaoTesting {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private JpaIcuDao icuDao;
	
	@Test
	public void testFindAllIcus() {
		List<Icu> allIcus = new ArrayList<>();
		
		Icu firstIcu = getFirstIcu();
		Icu secondIcu = getSecondIcu();
		
		Icu saveFirstIcu = entityManager.persist(firstIcu);
		Icu saveSecondIcu = entityManager.persist(secondIcu);
		
		allIcus = icuDao.findAll();
		
		assertThat(allIcus.get(0)).isEqualTo(saveFirstIcu);
		assertThat(allIcus.get(1)).isEqualTo(saveSecondIcu);
		assertThat(allIcus.get(0).getIcuId()).isEqualTo(1);
		assertThat(allIcus.get(1).getIcuId()).isEqualTo(2);
	}
	
	private Icu getFirstIcu() {
		Icu icu = new Icu();
		icu.setIcuId(1);
		icu.setIcuMaximumCapacity(8);
		entityManager.persist(icu);
		return icu;
	}
	
	private Icu getSecondIcu() {
		Icu icu = new Icu();
		icu.setIcuId(2);
		icu.setIcuMaximumCapacity(8);
		entityManager.persist(icu);
		return icu;
	}
}
