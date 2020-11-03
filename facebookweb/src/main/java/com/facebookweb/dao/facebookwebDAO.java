package com.facebookweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.facebookweb.entity.facebookWebUser;

public class facebookwebDAO implements facebookwebDAOinterface {
	private facebookwebDAO() {
			
		}
	
	public static facebookwebDAOinterface createObject() {
		return new facebookwebDAO();
	}

	public int createProfile(facebookWebUser i) {
		int j=0;
		Connection con=null;
		try {
			// TODO Auto-generated method stub
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			
			//Step 2 - Connection
			con = DriverManager.getConnection("jdbc:derby:d:/firstdb2;create=true","vipin","vipin123");
			
			//Step 3 - Create query
			PreparedStatement ps = con.prepareStatement("insert into instagramuser values(?,?,?,?)");
			ps.setString(1, i.getUserename());
			ps.setString(2, i.getPassword());
			ps.setString(3, i.getEmail());
			ps.setString(4, i.getAddress());
			
			//Step 4- Execute query
			j = ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return j;
	}
	
	public int editProfile(facebookWebUser i){
		Connection con = null;
		int j=0;
		try {
			// TODO Auto-generated method stub
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			
			//Step 2 - Connection
			con = DriverManager.getConnection("jdbc:derby:d:/firstdb2;create=true","vipin","vipin123");
			
			//Step 3 - Create query
			PreparedStatement ps = con.prepareStatement("update instagramuser set name=?,password=?,address=? where email=?");
			ps.setString(1, i.getUserename());
			ps.setString(2, i.getPassword());
			ps.setString(3, i.getAddress());
			ps.setString(4, i.getEmail());
			
			//Step 4- Execute query
			j = ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return j;
	}
	
	public int deleteProfile(facebookWebUser i)  {
		Connection con=null;
		int j=0;
		try {
			// TODO Auto-generated method stub
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			
			//Step 2 - Connection
			con = DriverManager.getConnection("jdbc:derby:d:/firstdb2;create=true","vipin","vipin123");
			
			//Step 3 - Create query
			PreparedStatement ps = con.prepareStatement("delete from instagramuser where name=? and password=?");
			ps.setString(1, i.getUserename());
			ps.setString(1, i.getPassword());
			
			//Step 4- Execute query
			j = ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return j;
	}
	
	public facebookWebUser viewProfile(facebookWebUser i){
		Connection con=null;
		boolean hasRows =false;
		try {
			// TODO Auto-generated method stub
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			
			//Step 2 - Connection
			con = DriverManager.getConnection("jdbc:derby:d:/firstdb2;create=true","vipin","vipin123");
			
			//Step 3 - Create query
			PreparedStatement ps = con.prepareStatement("select * from instagramuser where email=?");
			ps.setString(1, i.getEmail());
			
			//Step 4- Execute query
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				hasRows=true;
				String name = rs.getString("name");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String address = rs.getString("address");
				
				i.setUserename(name);
				i.setPassword(password);
				i.setEmail(email);
				i.setAddress(address);;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(hasRows) return i;
		return null;
		
	}
	
	public ArrayList<facebookWebUser> viewAllProfile() {
		Connection con=null;
		ArrayList<facebookWebUser> il = new ArrayList<facebookWebUser>();
		try {
			// TODO Auto-generated method stub
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			
			//Step 2 - Connection
			con = DriverManager.getConnection("jdbc:derby:d:/firstdb2;create=true","vipin","vipin123");
			
			//Step 3 - Create query
			PreparedStatement ps = con.prepareStatement("select * from instagramuser");
			
			//Step 4 - Execute Query
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String address = rs.getString("address");
				
				facebookWebUser iu = new facebookWebUser();
				iu.setUserename(name);
				iu.setPassword(password);
				iu.setEmail(email);
				iu.setAddress(address);
				
				il.add(iu);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return il;
		
		
	}

	

	public boolean loginProfileDAO(facebookWebUser i) {
		boolean b=false;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			
			//Step 2 - Connection
			Connection con = DriverManager.getConnection("jdbc:derby:d:/firstdb2;create=true","vipin","vipin123");
			
			//Step 3 - Create query
			PreparedStatement ps = con.prepareStatement("select * from instagramuser where name=? and password=?");
			ps.setString(1, i.getUserename());
			ps.setString(2, i.getPassword());
			
			
			//Step 4- Execute query
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				b=true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

}
