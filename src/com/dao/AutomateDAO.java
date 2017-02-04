package com.dao;

import java.util.List;

import com.models.Automate;

public interface AutomateDAO 
{
	public List<Automate> listAutomates();
	public void persistAutomate(Automate automate);
	public void updateAutomate(Automate automate);
	public void deleteAutomateByNum(Integer num);
	public Automate getAutomateByNum(Integer num);
	
}
