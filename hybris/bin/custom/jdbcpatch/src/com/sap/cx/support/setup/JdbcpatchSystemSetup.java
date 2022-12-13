/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.sap.cx.support.setup;

import static com.sap.cx.support.constants.JdbcpatchConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.sap.cx.support.constants.JdbcpatchConstants;
import com.sap.cx.support.service.JdbcpatchService;


@SystemSetup(extension = JdbcpatchConstants.EXTENSIONNAME)
public class JdbcpatchSystemSetup
{
	private final JdbcpatchService jdbcpatchService;

	public JdbcpatchSystemSetup(final JdbcpatchService jdbcpatchService)
	{
		this.jdbcpatchService = jdbcpatchService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		jdbcpatchService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return JdbcpatchSystemSetup.class.getResourceAsStream("/jdbcpatch/sap-hybris-platform.png");
	}
}
