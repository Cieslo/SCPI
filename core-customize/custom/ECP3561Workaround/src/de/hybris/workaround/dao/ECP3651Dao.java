/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2021 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 */
package de.hybris.workaround.dao;

import de.hybris.platform.ruleengine.dao.impl.DefaultEngineRuleDao;
import de.hybris.platform.ruleengine.model.AbstractRuleEngineRuleModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.util.Config;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.base.Preconditions;
import java.util.Map;




public class ECP3651Dao extends DefaultEngineRuleDao
{

	@Override
	public <T extends AbstractRuleEngineRuleModel> Collection<T> getRulesByUuids(Collection<String> ruleUuids)
	{
		if(ruleUuids.size()>2000 && Config.isSQLServerUsed())
		{
			StringBuilder sb = new StringBuilder();
			for( String uuid : ruleUuids)
			{
				if( uuid.contains("'"))
				{
					throw new IllegalArgumentException("Invalid UUID - SQL injeciton attempt!!!");				
				}
				sb.append('\'').append(uuid).append('\'').append(',');
			}
			String valuesInlined = sb.substring(0, sb.length()-1);
System.out.println(valuesInlined);

			String queryWithValuesInlined = GET_RULES_BY_MULTIPLE_UUID.replace("?uuids", valuesInlined);

System.out.println(queryWithValuesInlined);

			final FlexibleSearchQuery query = new FlexibleSearchQuery(queryWithValuesInlined);
			final SearchResult<T> search = getFlexibleSearchService().search(query);
			return search.getResult();

		}
		else
		{
			return super.getRulesByUuids(ruleUuids);
		}
	}
}