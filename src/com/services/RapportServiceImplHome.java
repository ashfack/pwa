package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.dao.RapportHome;
import com.models.Rapport;

@Service
public class RapportServiceImplHome implements RapportService {
	private RapportHome rapportHome;

	@Autowired
	public void setRapportHome(RapportHome rapportHome){
		this.rapportHome = rapportHome;
	}
	
	@Transactional
	public List<Rapport> listRapports() {
		return this.rapportHome.listRapports();
	}

	@Override
	public void persistRapport(Rapport rapport) {
		this.rapportHome.persist(rapport);
	}

	@Override
	public void updateRapport(Rapport rapport) {
		this.rapportHome.update(rapport);
	}
	
}
