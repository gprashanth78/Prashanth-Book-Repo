package com.prashanthIt.service;

import java.util.List;

import com.prashanthIt.entity.Role;

public interface RoleService {

	public boolean addRole(Role role);
	
	public List<Role> getAllRoles();
	
	public Role getRoleById(Integer roleId);
	
	public boolean deleteRoleById(Integer roleId);
}
