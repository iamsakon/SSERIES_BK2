package com.sky.biz.sseries.bpn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.biz.sseries.bpn.repositories.*;

@Service
public class BpnService {

	@Autowired
	protected BusinessPartnerGroupRepository businessPartnerGroupRepository;
	@Autowired
	protected PartnerCategoryRepository partnerCategoryRepository;
	@Autowired
	protected CorporateTypeRepository corporateTypeRepository;
	@Autowired
	protected PartnerGroupRepository partnerGroupRepository;
	@Autowired
	protected AddressTypeRepository addressTypeRepository;
	@Autowired
	protected TitleNameRepository titleNameRepository;
	
	
} 
