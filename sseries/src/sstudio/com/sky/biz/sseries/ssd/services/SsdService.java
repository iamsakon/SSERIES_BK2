package com.sky.biz.sseries.ssd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.biz.sseries.ssd.repositories.*;

@Service
public class SsdService {
	@Autowired
	protected ProductRepository productRepository;
	@Autowired
	protected ModuleRepository moduleRepository;
}
