package com.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.models.Automate;

@Service
public interface AutomateService {
	public List<Automate> listAutomates();
	public void persistAutomate(Automate automate);
	public void updateAutomate(Automate automate);
	public void deleteAutomateByNum(Integer num);
	public Automate getAutomateByNum(Integer num);
	
}