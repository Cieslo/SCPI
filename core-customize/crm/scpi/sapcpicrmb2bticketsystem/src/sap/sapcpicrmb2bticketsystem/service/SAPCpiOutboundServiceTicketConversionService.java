/**
 *
 */
package sap.sapcpicrmb2bticketsystem.service;

import de.hybris.platform.ticket.model.CsTicketModel;

import sap.sapcpicrmticketingsystem.model.SAPCpiOutboundServiceTicketModel;


/**
 * @author I503006
 *
 */
public interface SAPCpiOutboundServiceTicketConversionService
{
	SAPCpiOutboundServiceTicketModel convertSrvTicketToSapCpiSrvTkt(CsTicketModel pServiceTicket);
}
