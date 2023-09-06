package com.prashanthIt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prashanthIt.entity.Role;
import com.prashanthIt.service.RoleService;

@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;

	@PostMapping(value = "/role/addRoles", consumes = "application/json")
	public ResponseEntity<String> saveRoleDetails(@RequestBody Role role) {
		boolean addRole = roleService.addRole(role);
		if (addRole) {
			return new ResponseEntity<String>("Role details added", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Failed to save role details", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value="/role/getRoleList")
	public ResponseEntity<List<Role>> retrieveAllRoles(){
		List<Role> allRoles = roleService.getAllRoles();
		return new ResponseEntity<List<Role>>(allRoles, HttpStatus.OK);
	}
}
