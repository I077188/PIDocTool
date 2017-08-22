
package com.sap.xi.basis;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sap.xi.basis package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CommunicationPartyReadRequest_QNAME = new QName("http://sap.com/xi/BASIS", "CommunicationPartyReadRequest");
    private final static QName _CommunicationPartyOpenForEditResponse_QNAME = new QName("http://sap.com/xi/BASIS", "CommunicationPartyOpenForEditResponse");
    private final static QName _CommunicationPartyQueryResponse_QNAME = new QName("http://sap.com/xi/BASIS", "CommunicationPartyQueryResponse");
    private final static QName _CommunicationPartyCreateRequest_QNAME = new QName("http://sap.com/xi/BASIS", "CommunicationPartyCreateRequest");
    private final static QName _CommunicationPartyChangeRequest_QNAME = new QName("http://sap.com/xi/BASIS", "CommunicationPartyChangeRequest");
    private final static QName _CommunicationPartyReadResponse_QNAME = new QName("http://sap.com/xi/BASIS", "CommunicationPartyReadResponse");
    private final static QName _CommunicationPartyOpenForEditRequest_QNAME = new QName("http://sap.com/xi/BASIS", "CommunicationPartyOpenForEditRequest");
    private final static QName _CommunicationPartyCheckRequest_QNAME = new QName("http://sap.com/xi/BASIS", "CommunicationPartyCheckRequest");
    private final static QName _ConfigurationObjectModifyResponse_QNAME = new QName("http://sap.com/xi/BASIS", "ConfigurationObjectModifyResponse");
    private final static QName _CommunicationPartyRevertRequest_QNAME = new QName("http://sap.com/xi/BASIS", "CommunicationPartyRevertRequest");
    private final static QName _LogMessageCollection_QNAME = new QName("http://sap.com/xi/BASIS", "LogMessageCollection");
    private final static QName _CommunicationPartyDeleteRequest_QNAME = new QName("http://sap.com/xi/BASIS", "CommunicationPartyDeleteRequest");
    private final static QName _CommunicationPartyQueryRequest_QNAME = new QName("http://sap.com/xi/BASIS", "CommunicationPartyQueryRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sap.xi.basis
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CommunicationPartyReadIn }
     * 
     */
    public CommunicationPartyReadIn createCommunicationPartyReadIn() {
        return new CommunicationPartyReadIn();
    }

    /**
     * Create an instance of {@link CommunicationPartyOpenForEditOut }
     * 
     */
    public CommunicationPartyOpenForEditOut createCommunicationPartyOpenForEditOut() {
        return new CommunicationPartyOpenForEditOut();
    }

    /**
     * Create an instance of {@link CommunicationPartyQueryOut }
     * 
     */
    public CommunicationPartyQueryOut createCommunicationPartyQueryOut() {
        return new CommunicationPartyQueryOut();
    }

    /**
     * Create an instance of {@link CommunicationPartyCreateChangeIn }
     * 
     */
    public CommunicationPartyCreateChangeIn createCommunicationPartyCreateChangeIn() {
        return new CommunicationPartyCreateChangeIn();
    }

    /**
     * Create an instance of {@link CommunicationPartyReadOut }
     * 
     */
    public CommunicationPartyReadOut createCommunicationPartyReadOut() {
        return new CommunicationPartyReadOut();
    }

    /**
     * Create an instance of {@link CommunicationPartyDeleteOpenForEditIn }
     * 
     */
    public CommunicationPartyDeleteOpenForEditIn createCommunicationPartyDeleteOpenForEditIn() {
        return new CommunicationPartyDeleteOpenForEditIn();
    }

    /**
     * Create an instance of {@link CommunicationPartyIdentifierCollection }
     * 
     */
    public CommunicationPartyIdentifierCollection createCommunicationPartyIdentifierCollection() {
        return new CommunicationPartyIdentifierCollection();
    }

    /**
     * Create an instance of {@link LogMessageCollection }
     * 
     */
    public LogMessageCollection createLogMessageCollection() {
        return new LogMessageCollection();
    }

    /**
     * Create an instance of {@link ConfigurationObjectModifyOut }
     * 
     */
    public ConfigurationObjectModifyOut createConfigurationObjectModifyOut() {
        return new ConfigurationObjectModifyOut();
    }

    /**
     * Create an instance of {@link CommunicationPartyQueryIn }
     * 
     */
    public CommunicationPartyQueryIn createCommunicationPartyQueryIn() {
        return new CommunicationPartyQueryIn();
    }

    /**
     * Create an instance of {@link LogMessageCommunicationParty }
     * 
     */
    public LogMessageCommunicationParty createLogMessageCommunicationParty() {
        return new LogMessageCommunicationParty();
    }

    /**
     * Create an instance of {@link RestrictedCommunicationParty }
     * 
     */
    public RestrictedCommunicationParty createRestrictedCommunicationParty() {
        return new RestrictedCommunicationParty();
    }

    /**
     * Create an instance of {@link LogMessageCommunicationChannel }
     * 
     */
    public LogMessageCommunicationChannel createLogMessageCommunicationChannel() {
        return new LogMessageCommunicationChannel();
    }

    /**
     * Create an instance of {@link LogMessageMessageHeader }
     * 
     */
    public LogMessageMessageHeader createLogMessageMessageHeader() {
        return new LogMessageMessageHeader();
    }

    /**
     * Create an instance of {@link LogMessageCommunicationComponent }
     * 
     */
    public LogMessageCommunicationComponent createLogMessageCommunicationComponent() {
        return new LogMessageCommunicationComponent();
    }

    /**
     * Create an instance of {@link LogMessageItem }
     * 
     */
    public LogMessageItem createLogMessageItem() {
        return new LogMessageItem();
    }

    /**
     * Create an instance of {@link LogMessageReceiverRule }
     * 
     */
    public LogMessageReceiverRule createLogMessageReceiverRule() {
        return new LogMessageReceiverRule();
    }

    /**
     * Create an instance of {@link CommunicationPartyAdditionalIdentifier }
     * 
     */
    public CommunicationPartyAdditionalIdentifier createCommunicationPartyAdditionalIdentifier() {
        return new CommunicationPartyAdditionalIdentifier();
    }

    /**
     * Create an instance of {@link MessageHeaderID }
     * 
     */
    public MessageHeaderID createMessageHeaderID() {
        return new MessageHeaderID();
    }

    /**
     * Create an instance of {@link LogMessageProcessComponent }
     * 
     */
    public LogMessageProcessComponent createLogMessageProcessComponent() {
        return new LogMessageProcessComponent();
    }

    /**
     * Create an instance of {@link ChangeListID }
     * 
     */
    public ChangeListID createChangeListID() {
        return new ChangeListID();
    }

    /**
     * Create an instance of {@link LogMessageChangeList }
     * 
     */
    public LogMessageChangeList createLogMessageChangeList() {
        return new LogMessageChangeList();
    }

    /**
     * Create an instance of {@link ObjectAdministrativeData }
     * 
     */
    public ObjectAdministrativeData createObjectAdministrativeData() {
        return new ObjectAdministrativeData();
    }

    /**
     * Create an instance of {@link CommunicationComponentID }
     * 
     */
    public CommunicationComponentID createCommunicationComponentID() {
        return new CommunicationComponentID();
    }

    /**
     * Create an instance of {@link CommunicationChannelID }
     * 
     */
    public CommunicationChannelID createCommunicationChannelID() {
        return new CommunicationChannelID();
    }

    /**
     * Create an instance of {@link LogMessageValueMapping }
     * 
     */
    public LogMessageValueMapping createLogMessageValueMapping() {
        return new LogMessageValueMapping();
    }

    /**
     * Create an instance of {@link RestrictedObjectAdministrativeData }
     * 
     */
    public RestrictedObjectAdministrativeData createRestrictedObjectAdministrativeData() {
        return new RestrictedObjectAdministrativeData();
    }

    /**
     * Create an instance of {@link CommunicationParty }
     * 
     */
    public CommunicationParty createCommunicationParty() {
        return new CommunicationParty();
    }

    /**
     * Create an instance of {@link LogMessage }
     * 
     */
    public LogMessage createLogMessage() {
        return new LogMessage();
    }

    /**
     * Create an instance of {@link LogMessageConfigurationScenario }
     * 
     */
    public LogMessageConfigurationScenario createLogMessageConfigurationScenario() {
        return new LogMessageConfigurationScenario();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationPartyReadIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "CommunicationPartyReadRequest")
    public JAXBElement<CommunicationPartyReadIn> createCommunicationPartyReadRequest(CommunicationPartyReadIn value) {
        return new JAXBElement<CommunicationPartyReadIn>(_CommunicationPartyReadRequest_QNAME, CommunicationPartyReadIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationPartyOpenForEditOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "CommunicationPartyOpenForEditResponse")
    public JAXBElement<CommunicationPartyOpenForEditOut> createCommunicationPartyOpenForEditResponse(CommunicationPartyOpenForEditOut value) {
        return new JAXBElement<CommunicationPartyOpenForEditOut>(_CommunicationPartyOpenForEditResponse_QNAME, CommunicationPartyOpenForEditOut.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationPartyQueryOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "CommunicationPartyQueryResponse")
    public JAXBElement<CommunicationPartyQueryOut> createCommunicationPartyQueryResponse(CommunicationPartyQueryOut value) {
        return new JAXBElement<CommunicationPartyQueryOut>(_CommunicationPartyQueryResponse_QNAME, CommunicationPartyQueryOut.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationPartyCreateChangeIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "CommunicationPartyCreateRequest")
    public JAXBElement<CommunicationPartyCreateChangeIn> createCommunicationPartyCreateRequest(CommunicationPartyCreateChangeIn value) {
        return new JAXBElement<CommunicationPartyCreateChangeIn>(_CommunicationPartyCreateRequest_QNAME, CommunicationPartyCreateChangeIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationPartyCreateChangeIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "CommunicationPartyChangeRequest")
    public JAXBElement<CommunicationPartyCreateChangeIn> createCommunicationPartyChangeRequest(CommunicationPartyCreateChangeIn value) {
        return new JAXBElement<CommunicationPartyCreateChangeIn>(_CommunicationPartyChangeRequest_QNAME, CommunicationPartyCreateChangeIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationPartyReadOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "CommunicationPartyReadResponse")
    public JAXBElement<CommunicationPartyReadOut> createCommunicationPartyReadResponse(CommunicationPartyReadOut value) {
        return new JAXBElement<CommunicationPartyReadOut>(_CommunicationPartyReadResponse_QNAME, CommunicationPartyReadOut.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationPartyDeleteOpenForEditIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "CommunicationPartyOpenForEditRequest")
    public JAXBElement<CommunicationPartyDeleteOpenForEditIn> createCommunicationPartyOpenForEditRequest(CommunicationPartyDeleteOpenForEditIn value) {
        return new JAXBElement<CommunicationPartyDeleteOpenForEditIn>(_CommunicationPartyOpenForEditRequest_QNAME, CommunicationPartyDeleteOpenForEditIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationPartyIdentifierCollection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "CommunicationPartyCheckRequest")
    public JAXBElement<CommunicationPartyIdentifierCollection> createCommunicationPartyCheckRequest(CommunicationPartyIdentifierCollection value) {
        return new JAXBElement<CommunicationPartyIdentifierCollection>(_CommunicationPartyCheckRequest_QNAME, CommunicationPartyIdentifierCollection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfigurationObjectModifyOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "ConfigurationObjectModifyResponse")
    public JAXBElement<ConfigurationObjectModifyOut> createConfigurationObjectModifyResponse(ConfigurationObjectModifyOut value) {
        return new JAXBElement<ConfigurationObjectModifyOut>(_ConfigurationObjectModifyResponse_QNAME, ConfigurationObjectModifyOut.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationPartyIdentifierCollection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "CommunicationPartyRevertRequest")
    public JAXBElement<CommunicationPartyIdentifierCollection> createCommunicationPartyRevertRequest(CommunicationPartyIdentifierCollection value) {
        return new JAXBElement<CommunicationPartyIdentifierCollection>(_CommunicationPartyRevertRequest_QNAME, CommunicationPartyIdentifierCollection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogMessageCollection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "LogMessageCollection")
    public JAXBElement<LogMessageCollection> createLogMessageCollection(LogMessageCollection value) {
        return new JAXBElement<LogMessageCollection>(_LogMessageCollection_QNAME, LogMessageCollection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationPartyDeleteOpenForEditIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "CommunicationPartyDeleteRequest")
    public JAXBElement<CommunicationPartyDeleteOpenForEditIn> createCommunicationPartyDeleteRequest(CommunicationPartyDeleteOpenForEditIn value) {
        return new JAXBElement<CommunicationPartyDeleteOpenForEditIn>(_CommunicationPartyDeleteRequest_QNAME, CommunicationPartyDeleteOpenForEditIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationPartyQueryIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "CommunicationPartyQueryRequest")
    public JAXBElement<CommunicationPartyQueryIn> createCommunicationPartyQueryRequest(CommunicationPartyQueryIn value) {
        return new JAXBElement<CommunicationPartyQueryIn>(_CommunicationPartyQueryRequest_QNAME, CommunicationPartyQueryIn.class, null, value);
    }

}
