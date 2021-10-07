/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.sap.commerce.support.fixcustomerinterceptor.setup;

import static com.sap.commerce.support.fixcustomerinterceptor.constants.FixCustomerInterceptorConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.sap.commerce.support.fixcustomerinterceptor.constants.FixCustomerInterceptorConstants;
import com.sap.commerce.support.fixcustomerinterceptor.service.FixCustomerInterceptorService;


@SystemSetup(extension = FixCustomerInterceptorConstants.EXTENSIONNAME)
public class FixCustomerInterceptorSystemSetup
{
	private final FixCustomerInterceptorService fixCustomerInterceptorService;

	public FixCustomerInterceptorSystemSetup(final FixCustomerInterceptorService fixCustomerInterceptorService)
	{
		this.fixCustomerInterceptorService = fixCustomerInterceptorService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		fixCustomerInterceptorService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return FixCustomerInterceptorSystemSetup.class.getResourceAsStream("/fixCustomerInterceptor/sap-hybris-platform.png");
	}
}
