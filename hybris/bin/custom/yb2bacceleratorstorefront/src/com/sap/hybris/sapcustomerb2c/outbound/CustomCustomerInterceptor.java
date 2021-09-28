package com.sap.hybris.sapcustomerb2c.outbound;

import java.lang.Thread;

public class CustomCustomerInterceptor extends DefaultCustomerInterceptor{

	private static final Logger LOGGER = Logger.getLogger(DefaultCustomerInterceptor.class)
			
	  @Override
	  public void onValidate(final CustomerModel customerModel, final InterceptorContext ctx) throws InterceptorException {

	    if (!getCustomerExportService().isCustomerReplicationEnabled()) {
	      if (LOGGER.isDebugEnabled()) {
	        LOGGER.debug("'Replicate Registered Users' flag in 'SAP Global Configuration' is set to 'false'.");
	        LOGGER.debug("Customer with customer ID " + customerModel.getCustomerID() + " was not sent to Data Hub.");
	      }
	      return;
	    }

	    if (!getCustomerExportService().isClassCustomerModel(customerModel)) {
	      return;
	    }

	    if (customerModel.getSapContactID() == null) {
	      return;
	    }

	    LOGGER.debug(Thread.currentThread().getStackTrace());
	    
	    if (getCustomerAddressReplicationUtilityService().isCustomerReplicationRequired(customerModel, getMonitoredAttributes(), ctx)) {

	      final String baseStoreUid = baseStoreService.getCurrentBaseStore() != null
	              ? baseStoreService.getCurrentBaseStore().getUid() : null;
	      final String sessionLanguage = getStoreSessionFacade().getCurrentLanguage() != null
	              ? getStoreSessionFacade().getCurrentLanguage().getIsocode() : null;
	      getCustomerExportService().sendCustomerData(customerModel, baseStoreUid, sessionLanguage,
	              getCustomerAddressReplicationUtilityService().findDefaultAddress(customerModel, customerModel.getDefaultShipmentAddress()));

	    }

	  }

}
