package com.sky.biz.sseries.usm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.biz.sseries.usm.repositories.PrivilegeRepository;
import com.sky.biz.sseries.usm.repositories.RolePrivilegeRepository;
import com.sky.biz.sseries.usm.repositories.RoleRepository;
import com.sky.biz.sseries.usm.repositories.UserAccountRepository;
import com.sky.biz.sseries.usm.repositories.UserAccountRoleRepository;

@Service
public class UsmService {
	
	@Autowired
	protected UserAccountRepository userAccountRepository;
	@Autowired
	protected RoleRepository roleRepository;
	@Autowired
	protected UserAccountRoleRepository userAccountRoleRepository;
	@Autowired
	protected PrivilegeRepository privilegeRepository;
	@Autowired
	protected RolePrivilegeRepository rolePrivilegeRepository;

}
