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
package de.hybris.workaround.setup;

import static de.hybris.workaround.constants.ECP3561WorkaroundConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import de.hybris.workaround.constants.ECP3561WorkaroundConstants;
import de.hybris.workaround.service.ECP3561WorkaroundService;


@SystemSetup(extension = ECP3561WorkaroundConstants.EXTENSIONNAME)
public class ECP3561WorkaroundSystemSetup
{
	private final ECP3561WorkaroundService ECP3561WorkaroundService;

	public ECP3561WorkaroundSystemSetup(final ECP3561WorkaroundService ECP3561WorkaroundService)
	{
		this.ECP3561WorkaroundService = ECP3561WorkaroundService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		ECP3561WorkaroundService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return ECP3561WorkaroundSystemSetup.class.getResourceAsStream("/ECP3561Workaround/sap-hybris-platform.png");
	}
}
