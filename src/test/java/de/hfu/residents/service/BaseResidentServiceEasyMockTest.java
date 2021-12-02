package de.hfu.residents.service;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.easymock.EasyMock.*;

import java.util.Arrays;
import java.util.Date;

import org.easymock.EasyMock.*;
import org.junit.Test;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.repository.ResidentRepositoryStub;
public class BaseResidentServiceEasyMockTest {
	
	@Test
	public void testContainsWildcards() throws ResidentServiceException {
	Resident r1 = new Resident("Test", "Testfam", "Teststraße", "Furtwangen", new Date());
	ResidentRepository repo = createMock(ResidentRepository.class);
	expect(repo.getResidents()).andReturn(Arrays.asList(r1));
	replay(repo);
	
	BaseResidentService service = new BaseResidentService();
	service.setResidentRepository(repo);
	
	Resident result = service.getUniqueResident(r1);
	
	assertEquals(result, r1);
	}

}
