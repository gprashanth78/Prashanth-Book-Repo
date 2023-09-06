package com.prashanthIt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="USER_ROLES_DTLS_TBL")
public class Role {

	@Id
	@GeneratedValue
	@Column(name="ROLE_ID")
	private Integer roleId;
	@Column(name="ROLE_NAME")
	private String roleName;
	@Column(name="ROLE_DESCRIPTION")
	private String roleDescription;
}
