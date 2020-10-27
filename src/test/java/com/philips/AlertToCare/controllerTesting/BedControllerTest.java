package com.philips.AlertToCare.controllerTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.philips.AlertToCare.controller.BedController;
import com.philips.AlertToCare.entities.Bed;
import com.philips.AlertToCare.entities.Icu;
import com.philips.AlertToCare.service.BedService;

public class BedControllerTest {

	@Test
	public void getAllBeds() {
		List<Bed> beds = new ArrayList<>();
		beds.add(new Bed());
		BedService bs = Mockito.mock(BedService.class);
		Mockito.when(bs.getAllBeds()).thenReturn(beds);
		BedController bc = new BedController();
		bc.setBedService(bs);

		ResponseEntity<List<Bed>> response = bc.getAllBeds();
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertTrue(response.getBody().containsAll(beds));
	}

	@Test
	public void getBedById() {
		BedService bs = Mockito.mock(BedService.class);
		Bed bed = new Bed();
		Mockito.when(bs.getBedById(bed.getBedId())).thenReturn(bed);
		BedController bc = new BedController();
		bc.setBedService(bs);

		ResponseEntity<Bed> response = bc.getBedByBedId(bed.getBedId());
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(bed, response.getBody());
	}

	@Test
	public void getBedByAvailability() {
		BedService bs = Mockito.mock(BedService.class);
		Bed bed = new Bed();
		Icu icu = new Icu();
		Mockito.when(bs.getBedByIcuNumber(icu.getIcuId())).thenReturn((List<Bed>) bed);
		BedController bc = new BedController();
		bc.setBedService(bs);

		ResponseEntity<List<Bed>> response = bc.viewByAvailability(icu.getIcuId());
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(bed, response.getBody());
	}

}
