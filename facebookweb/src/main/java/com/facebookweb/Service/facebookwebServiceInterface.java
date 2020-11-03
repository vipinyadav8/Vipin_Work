package com.facebookweb.Service;

import java.util.ArrayList;

import com.facebookweb.entity.facebookWebUser;

public interface facebookwebServiceInterface {
	public int createProfile(facebookWebUser i);
	public int editProfile(facebookWebUser i);
	public void searchProfile();
	public int deleteProfile(facebookWebUser i);
	public facebookWebUser viewProfile(facebookWebUser i);
	public ArrayList<facebookWebUser> viewAllProfile();
	public boolean loginProfile(facebookWebUser i);

}
