package com.threeguys.users.delegators.repository;

import com.threeguys.users.models.User;



public interface IUserRepository {

	public  String createUser(User UserDetails);
	public  boolean updateUser(User UserDetails);
	public  boolean deleteUser(String  UserID);
	public  User  fetchUser(String  UserID);
	
}
