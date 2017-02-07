package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AutomateDAO;
import com.models.Automate;

@Service
public class AutomateServiceImplHome implements AutomateService {
	private AutomateDAO automateHome;

	@Autowired
	public void setAutomateHome(AutomateDAO automateHome){
		this.automateHome = automateHome;
	}
	
	@Transactional
	public List<Automate> listAutomates() {
		return this.automateHome.listAutomates();
	}

	@Override
	public void persistAutomate(Automate automate) {
		this.automateHome.persistAutomate(automate);
	}

	@Override
	public void updateAutomate(Automate automate) {
		this.automateHome.updateAutomate(automate);
	}
	@Override
	public Automate getAutomateByNum(Integer num) {
		return this.automateHome.getAutomateByNum(num);
	}
	@Override
	public void deleteAutomateByNum(Integer num) {
		this.automateHome.deleteAutomateByNum(num);
	}
}
