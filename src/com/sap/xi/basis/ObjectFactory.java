
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

    private final static QName _CommunicationChannelReadResponse_QNAME = new QName("http://sap.com/xi/BASIS", "CommunicationChannelReadResponse");
    private final static QName _CommunicationChannelOpenForEditResponse_QNAME = new QName("http://sap.com/xi/BASIS", "CommunicationChannelOpenForEditResponse");
    private final static QName _CommunicationChannelOpenForEditRequest_QNAME = new QName("http://sap.com/xi/BASIS", "CommunicationChannelOpenForEditRequest");
    private final static QName _CommunicationChannelDeleteRequest_QNAME = new QName("http://sap.com/xi/BASIS", "CommunicationChannelDeleteRequest");
    private final static QName _CommunicationChannelCreateRequest_QNAME = new QName("http://sap.com/xi/BASIS", "CommunicationChannelCreateRequest");
    private final static QName _CommunicationChannelCheckRequest_QNAME = new QName("http://sap.com/xi/BASIS", "CommunicationChannelCheckRequest");
    private final static QName _CommunicationChannelQueryResponse_QNAME = new QName("http://sap.com/xi/BASIS", "CommunicationChannelQueryResponse");
    private final static QName _CommunicationChannelRevertRequest_QNAME = new QName("http://sap.com/xi/BASIS", "CommunicationChannelRevertRequest");
    private final static QName _CommunicationChannelReadRequest_QNAME = new QName("http://sap.com/xi/BASIS", "CommunicationChannelReadRequest");
    private final static QName _CommunicationChannelQueryRequest_QNAME = new QName("http://sap.com/xi/BASIS", "CommunicationChannelQueryRequest");
    private final static QName _ConfigurationObjectModifyResponse_QNAME = new QName("http://sap.com/xi/BASIS", "ConfigurationObjectModifyResponse");
    private final static QName _LogMessageCollection_QNAME = new QName("http://sap.com/xi/BASIS", "LogMessageCollection");
    private final static QName _CommunicationChannelCreateFromTemplateRequest_QNAME = new QName("http://sap.com/xi/BASIS", "CommunicationChannelCreateFromTemplateRequest");
    private final static QName _CommunicationChannelChangeRequest_QNAME = new QName("http://sap.com/xi/BASIS", "CommunicationChannelChangeRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sap.xi.basis
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CommunicationChannelOpenForEditOut }
     * 
     */
    public CommunicationChannelOpenForEditOut createCommunicationChannelOpenForEditOut() {
        return new CommunicationChannelOpenForEditOut();
    }

    /**
     * Create an instance of {@link CommunicationChannelReadOut }
     * 
     */
    public CommunicationChannelReadOut createCommunicationChannelReadOut() {
        return new CommunicationChannelReadOut();
    }

    /**
     * Create an instance of {@link CommunicationChannelDeleteOpenForEditIn }
     * 
     */
    public CommunicationChannelDeleteOpenForEditIn createCommunicationChannelDeleteOpenForEditIn() {
        return new CommunicationChannelDeleteOpenForEditIn();
    }

    /**
     * Create an instance of {@link CommunicationChannelCreateChangeIn }
     * 
     */
    public CommunicationChannelCreateChangeIn createCommunicationChannelCreateChangeIn() {
        return new CommunicationChannelCreateChangeIn();
    }

    /**
     * Create an instance of {@link CommunicationChannelIdentifierCollection }
     * 
     */
    public CommunicationChannelIdentifierCollection createCommunicationChannelIdentifierCollection() {
        return new CommunicationChannelIdentifierCollection();
    }

    /**
     * Create an instance of {@link CommunicationChannelQueryOut }
     * 
     */
    public CommunicationChannelQueryOut createCommunicationChannelQueryOut() {
        return new CommunicationChannelQueryOut();
    }

    /**
     * Create an instance of {@link CommunicationChannelReadIn }
     * 
     */
    public CommunicationChannelReadIn createCommunicationChannelReadIn() {
        return new CommunicationChannelReadIn();
    }

    /**
     * Create an instance of {@link CommunicationChannelQueryIn }
     * 
     */
    public CommunicationChannelQueryIn createCommunicationChannelQueryIn() {
        return new CommunicationChannelQueryIn();
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
     * Create an instance of {@link CommunicationChannelCreateFromTemplateIn }
     * 
     */
    public CommunicationChannelCreateFromTemplateIn createCommunicationChannelCreateFromTemplateIn() {
        return new CommunicationChannelCreateFromTemplateIn();
    }

    /**
     * Create an instance of {@link GenericTableRowTableCell }
     * 
     */
    public GenericTableRowTableCell createGenericTableRowTableCell() {
        return new GenericTableRowTableCell();
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
     * Create an instance of {@link ModuleProcess }
     * 
     */
    public ModuleProcess createModuleProcess() {
        return new ModuleProcess();
    }

    /**
     * Create an instance of {@link TemplateBasedCommunicationChannel }
     * 
     */
    public TemplateBasedCommunicationChannel createTemplateBasedCommunicationChannel() {
        return new TemplateBasedCommunicationChannel();
    }

    /**
     * Create an instance of {@link ChangeListID }
     * 
     */
    public ChangeListID createChangeListID() {
        return new ChangeListID();
    }

    /**
     * Create an instance of {@link RestrictedGenericProperty }
     * 
     */
    public RestrictedGenericProperty createRestrictedGenericProperty() {
        return new RestrictedGenericProperty();
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
     * Create an instance of {@link GenericTableRow }
     * 
     */
    public GenericTableRow createGenericTableRow() {
        return new GenericTableRow();
    }

    /**
     * Create an instance of {@link ChannelAdditionalIdentifier }
     * 
     */
    public ChannelAdditionalIdentifier createChannelAdditionalIdentifier() {
        return new ChannelAdditionalIdentifier();
    }

    /**
     * Create an instance of {@link LogMessageCommunicationParty }
     * 
     */
    public LogMessageCommunicationParty createLogMessageCommunicationParty() {
        return new LogMessageCommunicationParty();
    }

    /**
     * Create an instance of {@link ProcessStep }
     * 
     */
    public ProcessStep createProcessStep() {
        return new ProcessStep();
    }

    /**
     * Create an instance of {@link GenericPropertyTable }
     * 
     */
    public GenericPropertyTable createGenericPropertyTable() {
        return new GenericPropertyTable();
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
     * Create an instance of {@link RestrictedCommunicationChannel }
     * 
     */
    public RestrictedCommunicationChannel createRestrictedCommunicationChannel() {
        return new RestrictedCommunicationChannel();
    }

    /**
     * Create an instance of {@link LogMessageReceiverRule }
     * 
     */
    public LogMessageReceiverRule createLogMessageReceiverRule() {
        return new LogMessageReceiverRule();
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
     * Create an instance of {@link CommunicationChannel }
     * 
     */
    public CommunicationChannel createCommunicationChannel() {
        return new CommunicationChannel();
    }

    /**
     * Create an instance of {@link DesignObjectID }
     * 
     */
    public DesignObjectID createDesignObjectID() {
        return new DesignObjectID();
    }

    /**
     * Create an instance of {@link LogMessage }
     * 
     */
    public LogMessage createLogMessage() {
        return new LogMessage();
    }

    /**
     * Create an instance of {@link ParameterGroup }
     * 
     */
    public ParameterGroup createParameterGroup() {
        return new ParameterGroup();
    }

    /**
     * Create an instance of {@link GenericProperty }
     * 
     */
    public GenericProperty createGenericProperty() {
        return new GenericProperty();
    }

    /**
     * Create an instance of {@link LogMessageConfigurationScenario }
     * 
     */
    public LogMessageConfigurationScenario createLogMessageConfigurationScenario() {
        return new LogMessageConfigurationScenario();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationChannelReadOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "CommunicationChannelReadResponse")
    public JAXBElement<CommunicationChannelReadOut> createCommunicationChannelReadResponse(CommunicationChannelReadOut value) {
        return new JAXBElement<CommunicationChannelReadOut>(_CommunicationChannelReadResponse_QNAME, CommunicationChannelReadOut.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationChannelOpenForEditOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "CommunicationChannelOpenForEditResponse")
    public JAXBElement<CommunicationChannelOpenForEditOut> createCommunicationChannelOpenForEditResponse(CommunicationChannelOpenForEditOut value) {
        return new JAXBElement<CommunicationChannelOpenForEditOut>(_CommunicationChannelOpenForEditResponse_QNAME, CommunicationChannelOpenForEditOut.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationChannelDeleteOpenForEditIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "CommunicationChannelOpenForEditRequest")
    public JAXBElement<CommunicationChannelDeleteOpenForEditIn> createCommunicationChannelOpenForEditRequest(CommunicationChannelDeleteOpenForEditIn value) {
        return new JAXBElement<CommunicationChannelDeleteOpenForEditIn>(_CommunicationChannelOpenForEditRequest_QNAME, CommunicationChannelDeleteOpenForEditIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationChannelDeleteOpenForEditIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "CommunicationChannelDeleteRequest")
    public JAXBElement<CommunicationChannelDeleteOpenForEditIn> createCommunicationChannelDeleteRequest(CommunicationChannelDeleteOpenForEditIn value) {
        return new JAXBElement<CommunicationChannelDeleteOpenForEditIn>(_CommunicationChannelDeleteRequest_QNAME, CommunicationChannelDeleteOpenForEditIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationChannelCreateChangeIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "CommunicationChannelCreateRequest")
    public JAXBElement<CommunicationChannelCreateChangeIn> createCommunicationChannelCreateRequest(CommunicationChannelCreateChangeIn value) {
        return new JAXBElement<CommunicationChannelCreateChangeIn>(_CommunicationChannelCreateRequest_QNAME, CommunicationChannelCreateChangeIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationChannelIdentifierCollection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "CommunicationChannelCheckRequest")
    public JAXBElement<CommunicationChannelIdentifierCollection> createCommunicationChannelCheckRequest(CommunicationChannelIdentifierCollection value) {
        return new JAXBElement<CommunicationChannelIdentifierCollection>(_CommunicationChannelCheckRequest_QNAME, CommunicationChannelIdentifierCollection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationChannelQueryOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "CommunicationChannelQueryResponse")
    public JAXBElement<CommunicationChannelQueryOut> createCommunicationChannelQueryResponse(CommunicationChannelQueryOut value) {
        return new JAXBElement<CommunicationChannelQueryOut>(_CommunicationChannelQueryResponse_QNAME, CommunicationChannelQueryOut.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationChannelIdentifierCollection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "CommunicationChannelRevertRequest")
    public JAXBElement<CommunicationChannelIdentifierCollection> createCommunicationChannelRevertRequest(CommunicationChannelIdentifierCollection value) {
        return new JAXBElement<CommunicationChannelIdentifierCollection>(_CommunicationChannelRevertRequest_QNAME, CommunicationChannelIdentifierCollection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationChannelReadIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "CommunicationChannelReadRequest")
    public JAXBElement<CommunicationChannelReadIn> createCommunicationChannelReadRequest(CommunicationChannelReadIn value) {
        return new JAXBElement<CommunicationChannelReadIn>(_CommunicationChannelReadRequest_QNAME, CommunicationChannelReadIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationChannelQueryIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "CommunicationChannelQueryRequest")
    public JAXBElement<CommunicationChannelQueryIn> createCommunicationChannelQueryRequest(CommunicationChannelQueryIn value) {
        return new JAXBElement<CommunicationChannelQueryIn>(_CommunicationChannelQueryRequest_QNAME, CommunicationChannelQueryIn.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link LogMessageCollection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "LogMessageCollection")
    public JAXBElement<LogMessageCollection> createLogMessageCollection(LogMessageCollection value) {
        return new JAXBElement<LogMessageCollection>(_LogMessageCollection_QNAME, LogMessageCollection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationChannelCreateFromTemplateIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "CommunicationChannelCreateFromTemplateRequest")
    public JAXBElement<CommunicationChannelCreateFromTemplateIn> createCommunicationChannelCreateFromTemplateRequest(CommunicationChannelCreateFromTemplateIn value) {
        return new JAXBElement<CommunicationChannelCreateFromTemplateIn>(_CommunicationChannelCreateFromTemplateRequest_QNAME, CommunicationChannelCreateFromTemplateIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationChannelCreateChangeIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "CommunicationChannelChangeRequest")
    public JAXBElement<CommunicationChannelCreateChangeIn> createCommunicationChannelChangeRequest(CommunicationChannelCreateChangeIn value) {
        return new JAXBElement<CommunicationChannelCreateChangeIn>(_CommunicationChannelChangeRequest_QNAME, CommunicationChannelCreateChangeIn.class, null, value);
    }

}
