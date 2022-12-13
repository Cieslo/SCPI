/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.sap.cx.support.controller;

import static com.sap.cx.support.constants.JdbcpatchConstants.PLATFORM_LOGO_CODE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sap.cx.support.service.JdbcpatchService;


@Controller
public class JdbcpatchHelloController
{
	@Autowired
	private JdbcpatchService jdbcpatchService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(final ModelMap model)
	{
		model.addAttribute("logoUrl", jdbcpatchService.getHybrisLogoUrl(PLATFORM_LOGO_CODE));
		return "welcome";
	}
}
