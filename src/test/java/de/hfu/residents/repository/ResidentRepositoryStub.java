package de.hfu.residents.repository;

import java.util.Arrays;
import java.util.List;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;

public class ResidentRepositoryStub implements ResidentRepository{
	
	private Resident resident1;
	private Resident resident2;
	
	public void createResidents(Resident resident) {
		if(resident1==null) {resident1=resident;}
		else {resident2=resident;}
	}

	@Override
	public List<Resident> getResidents() {
		
		return Arrays.asList(resident1,resident2);
	}

}
