
package com.sap.xi.basis;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CommunicationPartyIn", targetNamespace = "http://sap.com/xi/BASIS")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    com.sap.xi.basis.ObjectFactory.class,
    com.sap.xi.basis.global.ObjectFactory.class
})
public interface CommunicationPartyIn {


    /**
     * 
     * @param communicationPartyCheckRequest
     * @return
     *     returns com.sap.xi.basis.LogMessageCollection
     */
    @WebMethod(operationName = "Check", action = "http://sap.com/xi/WebService/soap1.1")
    @WebResult(name = "LogMessageCollection", targetNamespace = "http://sap.com/xi/BASIS", partName = "LogMessageCollection")
    public LogMessageCollection check(
        @WebParam(name = "CommunicationPartyCheckRequest", targetNamespace = "http://sap.com/xi/BASIS", partName = "CommunicationPartyCheckRequest")
        CommunicationPartyIdentifierCollection communicationPartyCheckRequest);

    /**
     * 
     * @param communicationPartyQueryRequest
     * @return
     *     returns com.sap.xi.basis.CommunicationPartyQueryOut
     */
    @WebMethod(operationName = "Query", action = "http://sap.com/xi/WebService/soap1.1")
    @WebResult(name = "CommunicationPartyQueryResponse", targetNamespace = "http://sap.com/xi/BASIS", partName = "CommunicationPartyQueryResponse")
    public CommunicationPartyQueryOut query(
        @WebParam(name = "CommunicationPartyQueryRequest", targetNamespace = "http://sap.com/xi/BASIS", partName = "CommunicationPartyQueryRequest")
        CommunicationPartyQueryIn communicationPartyQueryRequest);

    /**
     * 
     * @param communicationPartyRevertRequest
     * @return
     *     returns com.sap.xi.basis.LogMessageCollection
     */
    @WebMethod(operationName = "Revert", action = "http://sap.com/xi/WebService/soap1.1")
    @WebResult(name = "LogMessageCollection", targetNamespace = "http://sap.com/xi/BASIS", partName = "LogMessageCollection")
    public LogMessageCollection revert(
        @WebParam(name = "CommunicationPartyRevertRequest", targetNamespace = "http://sap.com/xi/BASIS", partName = "CommunicationPartyRevertRequest")
        CommunicationPartyIdentifierCollection communicationPartyRevertRequest);

    /**
     * 
     * @param communicationPartyCreateRequest
     * @return
     *     returns com.sap.xi.basis.ConfigurationObjectModifyOut
     */
    @WebMethod(operationName = "Create", action = "http://sap.com/xi/WebService/soap1.1")
    @WebResult(name = "ConfigurationObjectModifyResponse", targetNamespace = "http://sap.com/xi/BASIS", partName = "ConfigurationObjectModifyResponse")
    public ConfigurationObjectModifyOut create(
        @WebParam(name = "CommunicationPartyCreateRequest", targetNamespace = "http://sap.com/xi/BASIS", partName = "CommunicationPartyCreateRequest")
        CommunicationPartyCreateChangeIn communicationPartyCreateRequest);

    /**
     * 
     * @param communicationPartyChangeRequest
     * @return
     *     returns com.sap.xi.basis.ConfigurationObjectModifyOut
     */
    @WebMethod(operationName = "Change", action = "http://sap.com/xi/WebService/soap1.1")
    @WebResult(name = "ConfigurationObjectModifyResponse", targetNamespace = "http://sap.com/xi/BASIS", partName = "ConfigurationObjectModifyResponse")
    public ConfigurationObjectModifyOut change(
        @WebParam(name = "CommunicationPartyChangeRequest", targetNamespace = "http://sap.com/xi/BASIS", partName = "CommunicationPartyChangeRequest")
        CommunicationPartyCreateChangeIn communicationPartyChangeRequest);

    /**
     * 
     * @param communicationPartyOpenForEditRequest
     * @return
     *     returns com.sap.xi.basis.CommunicationPartyOpenForEditOut
     */
    @WebMethod(operationName = "OpenForEdit", action = "http://sap.com/xi/WebService/soap1.1")
    @WebResult(name = "CommunicationPartyOpenForEditResponse", targetNamespace = "http://sap.com/xi/BASIS", partName = "CommunicationPartyOpenForEditResponse")
    public CommunicationPartyOpenForEditOut openForEdit(
        @WebParam(name = "CommunicationPartyOpenForEditRequest", targetNamespace = "http://sap.com/xi/BASIS", partName = "CommunicationPartyOpenForEditRequest")
        CommunicationPartyDeleteOpenForEditIn communicationPartyOpenForEditRequest);

    /**
     * 
     * @param communicationPartyReadRequest
     * @return
     *     returns com.sap.xi.basis.CommunicationPartyReadOut
     */
    @WebMethod(operationName = "Read", action = "http://sap.com/xi/WebService/soap1.1")
    @WebResult(name = "CommunicationPartyReadResponse", targetNamespace = "http://sap.com/xi/BASIS", partName = "CommunicationPartyReadResponse")
    public CommunicationPartyReadOut read(
        @WebParam(name = "CommunicationPartyReadRequest", targetNamespace = "http://sap.com/xi/BASIS", partName = "CommunicationPartyReadRequest")
        CommunicationPartyReadIn communicationPartyReadRequest);

    /**
     * 
     * @param communicationPartyDeleteRequest
     * @return
     *     returns com.sap.xi.basis.ConfigurationObjectModifyOut
     */
    @WebMethod(operationName = "Delete", action = "http://sap.com/xi/WebService/soap1.1")
    @WebResult(name = "ConfigurationObjectModifyResponse", targetNamespace = "http://sap.com/xi/BASIS", partName = "ConfigurationObjectModifyResponse")
    public ConfigurationObjectModifyOut delete(
        @WebParam(name = "CommunicationPartyDeleteRequest", targetNamespace = "http://sap.com/xi/BASIS", partName = "CommunicationPartyDeleteRequest")
        CommunicationPartyDeleteOpenForEditIn communicationPartyDeleteRequest);

}
