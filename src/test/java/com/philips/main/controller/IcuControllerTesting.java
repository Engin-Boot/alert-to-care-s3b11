package com.philips.main.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.philips.main.controller.IcuController;
import com.philips.main.entities.Icu;
import com.philips.main.service.IcuService;

public class IcuControllerTesting {

	@Test
    public void getAllIcus() {
        IcuService is = Mockito.mock(IcuService.class);
        Mockito.when(is.getAllIcus()).thenReturn(null);
        IcuController ic = new IcuController();
        ic.setIcuService(is);

        ResponseEntity<List<Icu>> response = ic.getAllIcus();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(0, response.getBody().size());
    }

}
