package de.hfu.residents.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepositoryStub;

public class BaseResidentServiceTest {
	
	@Test
	public void testGetUniqueResident() throws ResidentServiceException {
	Resident r1 = new Resident("Test", "Testfam", "Teststraße", "Furtwangen", new Date());
	Resident r2 = new Resident("Test2", "Testfam2", "Teststraße3", "Furtwangen", new Date());
	
	ResidentRepositoryStub stub = new ResidentRepositoryStub();
	stub.createResidents(r1);
	stub.createResidents(r2);
	
	BaseResidentService service = new BaseResidentService();
	service.setResidentRepository(stub);
	
	Resident result = service.getUniqueResident(r2);
	
	assertEquals(result, r2);
	}
	@Test(expected=ResidentServiceException.class,timeout=1000)
	public void testGetUniqueResidentException() throws ResidentServiceException {
	Resident r1 = new Resident("Test", "Testfam", "Teststraße", "Furtwangen", new Date());

	
	ResidentRepositoryStub stub = new ResidentRepositoryStub();
	stub.createResidents(r1);
	stub.createResidents(r1);
	
	BaseResidentService service = new BaseResidentService();
	service.setResidentRepository(stub);
	
    service.getUniqueResident(r1);
	
	}
	@Test(expected=ResidentServiceException.class,timeout=1000)
	public void testGetUniqueResidentWithWildcard() throws ResidentServiceException {
	Resident r1 = new Resident("Test*", "Testfam", "Teststraße", "Furtwangen", new Date());
	Resident r2 = new Resident("Test2", "Testfam2", "Teststraße3", "Furtwangen", new Date());
	
	ResidentRepositoryStub stub = new ResidentRepositoryStub();
	stub.createResidents(r1);
	stub.createResidents(r2);
	
	BaseResidentService service = new BaseResidentService();
	service.setResidentRepository(stub);
	
    service.getUniqueResident(r1);
	
	}
	
	@Test
	public void testGetFilteredResidentsList() {
		Resident r1 = new Resident("Test", "Testfam", "Teststraße", "Furtwangen", new Date());
		Resident r2 = new Resident("Test2", "Testfam2", "Teststraße3", "Furtwangen", new Date());
		
		ResidentRepositoryStub stub = new ResidentRepositoryStub();
		stub.createResidents(r1);
		stub.createResidents(r2);
		
		BaseResidentService service = new BaseResidentService();
		service.setResidentRepository(stub);
		
	    List<Resident> resident = service.getFilteredResidentsList(r1);
	    assertEquals(resident.get(0), r1);
	}
	@Test
	public void testGetFilteredResidentsListWithNoMatch() {
		Resident r1 = new Resident("Test", "Testfam", "Teststraße", "Furtwangen", new Date());
		Resident r2 = new Resident("Test2", "Testfam2", "Teststraße3", "Furtwangen", new Date());
		Resident r3 = new Resident("tester", "fame2", "straßetest", "Berlin", new Date());
		
		ResidentRepositoryStub stub = new ResidentRepositoryStub();
		stub.createResidents(r1);
		stub.createResidents(r2);
		
		BaseResidentService service = new BaseResidentService();
		service.setResidentRepository(stub);
		
	    List<Resident> resident = service.getFilteredResidentsList(r3);
	    assertTrue(resident.isEmpty());
	}	
	@Test
	public void testGetFilteredResidentsListWithSameResidents() {
		Resident r1 = new Resident("Test", "Testfam", "Teststraße", "Furtwangen", new Date());
		
		ResidentRepositoryStub stub = new ResidentRepositoryStub();
		stub.createResidents(r1);
		stub.createResidents(r1);
		
		BaseResidentService service = new BaseResidentService();
		service.setResidentRepository(stub);
		
	    List<Resident> resident = service.getFilteredResidentsList(r1);
	    assertTrue(resident.size()==2);
	}
}