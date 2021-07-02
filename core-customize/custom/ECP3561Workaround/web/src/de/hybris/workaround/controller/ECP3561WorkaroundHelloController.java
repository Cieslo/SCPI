/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.workaround.controller;

import static de.hybris.workaround.constants.ECP3561WorkaroundConstants.PLATFORM_LOGO_CODE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.hybris.workaround.service.ECP3561WorkaroundService;


@Controller
public class ECP3561WorkaroundHelloController
{
	@Autowired
	private ECP3561WorkaroundService ECP3561WorkaroundService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(final ModelMap model)
	{
		model.addAttribute("logoUrl", ECP3561WorkaroundService.getHybrisLogoUrl(PLATFORM_LOGO_CODE));
		return "welcome";
	}
}
