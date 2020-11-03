package com.facebookweb.Service;

import java.util.ArrayList;

import com.facebookweb.dao.facebookwebDAO;
import com.facebookweb.dao.facebookwebDAOinterface;
import com.facebookweb.entity.facebookWebUser;

public class facebookwebService implements facebookwebServiceInterface {
	private facebookwebService() {
			
		}
	
	public static facebookwebServiceInterface createObject() {
		return new facebookwebService();
	}

	public int createProfile(facebookWebUser i) {
		// TODO Auto-generated method stub
		facebookwebDAOinterface id1 = facebookwebDAO.createObject();
		return id1.createProfile(i);
	}

	public int editProfile(facebookWebUser i) {
		// TODO Auto-generated method stub
		facebookwebDAOinterface id1 = facebookwebDAO.createObject();
		return id1.editProfile(i);
		
	}

	public void searchProfile() {
		// TODO Auto-generated method stub
		
	}

	public int deleteProfile(facebookWebUser i) {
		// TODO Auto-generated method stub
		facebookwebDAOinterface id1 = facebookwebDAO.createObject();
		return id1.deleteProfile(i);
		
	}
	
	public facebookWebUser viewProfile(facebookWebUser i) {
		// TODO Auto-generated method stub
		facebookwebDAOinterface id1 = facebookwebDAO.createObject();
		return id1.viewProfile(i);
		
	}
	
	public ArrayList<facebookWebUser> viewAllProfile() {
		// TODO Auto-generated method stub
		facebookwebDAOinterface id1 = facebookwebDAO.createObject();
		return id1.viewAllProfile();
		
	}

	public boolean loginProfile(facebookWebUser i) {
		// TODO Auto-generated method stub
		facebookwebDAOinterface fd =  facebookwebDAO.createObject();
		return fd.loginProfileDAO(i);
	}

}
