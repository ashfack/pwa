package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AutomateDAO;
import com.models.Automate;

@Service
public class AutomateServiceImpl implements AutomateService {
	private AutomateDAO automateDAO;

	@Autowired
	public void setAutomateDAO(AutomateDAO automateDAO){
		this.automateDAO = automateDAO;
	}
	
	@Transactional
	public List<Automate> listAutomates() {
		return this.automateDAO.listAutomates();
	}

	@Override
	public void persistAutomate(Automate automate) {
		this.automateDAO.persistAutomate(automate);
	}

	@Override
	public void updateAutomate(Automate automate) {
		this.automateDAO.updateAutomate(automate);
	}
	@Override
	public Automate getAutomateByNum(Integer num) {
		return this.automateDAO.getAutomateByNum(num);
	}
	@Override
	public void deleteAutomateByNum(Integer num) {
		this.automateDAO.deleteAutomateByNum(num);
	}
}
