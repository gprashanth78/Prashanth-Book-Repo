package com.prashanthIt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prashanthIt.entity.Role;
import com.prashanthIt.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public boolean addRole(Role role) {
		Role save = roleRepository.save(role);
		return save.getRoleId() != null;
	}

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Role getRoleById(Integer roleId) {
		Optional<Role> findById = roleRepository.findById(roleId);
		if (findById.isPresent()) {
			Role role = findById.get();
			return role;
		}
		return null;
	}

	@Override
	public boolean deleteRoleById(Integer roleId) {
		roleRepository.deleteById(roleId);
		return true;
	}

}
