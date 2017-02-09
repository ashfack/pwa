package com.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.models.Rapport;

@Service
public interface RapportService {
	public List<Rapport> listRapports();
	public List<Rapport> listRapportsDuJour();
	public void persistRapport(Rapport rapport);
	public void updateRapport(Rapport rapport);
	
}