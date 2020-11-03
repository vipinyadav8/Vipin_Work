package com.facebookweb.dao;

import java.util.ArrayList;

import com.facebookweb.entity.facebookWebUser;

public interface facebookwebDAOinterface {
	public int createProfile(facebookWebUser i);
	public int editProfile(facebookWebUser i);
	public int deleteProfile(facebookWebUser i);
	public facebookWebUser viewProfile(facebookWebUser i);
	public ArrayList<facebookWebUser> viewAllProfile();
	public boolean loginProfileDAO(facebookWebUser i);

}
