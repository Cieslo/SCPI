/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.sap.commerce.support.fixcustomerinterceptor.service;

public interface FixCustomerInterceptorService
{
	String getHybrisLogoUrl(String logoCode);

	void createLogo(String logoCode);
}
