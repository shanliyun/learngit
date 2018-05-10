package com.poi.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poi.service.RdxbdmService;

@Controller

public class RdxbdmController {
	@Autowired
	private RdxbdmService rdxbdmService;
	@RequestMapping("poi")
	public void poi(){
		
		rdxbdmService.insertDb();	

	}
}
