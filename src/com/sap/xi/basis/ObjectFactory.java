
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

    private final static QName _IntegratedConfigurationCheckRequest_QNAME = new QName("http://sap.com/xi/BASIS", "IntegratedConfigurationCheckRequest");
    private final static QName _IntegratedConfigurationOpenForEditRequest_QNAME = new QName("http://sap.com/xi/BASIS", "IntegratedConfigurationOpenForEditRequest");
    private final static QName _IntegratedConfigurationOpenForEditResponse_QNAME = new QName("http://sap.com/xi/BASIS", "IntegratedConfigurationOpenForEditResponse");
    private final static QName _IntegratedConfigurationCreateRequest_QNAME = new QName("http://sap.com/xi/BASIS", "IntegratedConfigurationCreateRequest");
    private final static QName _IntegratedConfigurationReadRequest_QNAME = new QName("http://sap.com/xi/BASIS", "IntegratedConfigurationReadRequest");
    private final static QName _IntegratedConfigurationChangeRequest_QNAME = new QName("http://sap.com/xi/BASIS", "IntegratedConfigurationChangeRequest");
    private final static QName _IntegratedConfigurationRevertRequest_QNAME = new QName("http://sap.com/xi/BASIS", "IntegratedConfigurationRevertRequest");
    private final static QName _ConfigurationObjectModifyResponse_QNAME = new QName("http://sap.com/xi/BASIS", "ConfigurationObjectModifyResponse");
    private final static QName _IntegratedConfigurationReadResponse_QNAME = new QName("http://sap.com/xi/BASIS", "IntegratedConfigurationReadResponse");
    private final static QName _LogMessageCollection_QNAME = new QName("http://sap.com/xi/BASIS", "LogMessageCollection");
    private final static QName _IntegratedConfigurationQueryResponse_QNAME = new QName("http://sap.com/xi/BASIS", "IntegratedConfigurationQueryResponse");
    private final static QName _IntegratedConfigurationDeleteRequest_QNAME = new QName("http://sap.com/xi/BASIS", "IntegratedConfigurationDeleteRequest");
    private final static QName _IntegratedConfigurationQueryRequest_QNAME = new QName("http://sap.com/xi/BASIS", "IntegratedConfigurationQueryRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sap.xi.basis
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IntegratedConfigurationIdentifierCollection }
     * 
     */
    public IntegratedConfigurationIdentifierCollection createIntegratedConfigurationIdentifierCollection() {
        return new IntegratedConfigurationIdentifierCollection();
    }

    /**
     * Create an instance of {@link IntegratedConfigurationOpenForEditOut }
     * 
     */
    public IntegratedConfigurationOpenForEditOut createIntegratedConfigurationOpenForEditOut() {
        return new IntegratedConfigurationOpenForEditOut();
    }

    /**
     * Create an instance of {@link IntegratedConfigurationDeleteOpenForEditIn }
     * 
     */
    public IntegratedConfigurationDeleteOpenForEditIn createIntegratedConfigurationDeleteOpenForEditIn() {
        return new IntegratedConfigurationDeleteOpenForEditIn();
    }

    /**
     * Create an instance of {@link IntegratedConfigurationReadIn }
     * 
     */
    public IntegratedConfigurationReadIn createIntegratedConfigurationReadIn() {
        return new IntegratedConfigurationReadIn();
    }

    /**
     * Create an instance of {@link IntegratedConfigurationCreateChangeIn }
     * 
     */
    public IntegratedConfigurationCreateChangeIn createIntegratedConfigurationCreateChangeIn() {
        return new IntegratedConfigurationCreateChangeIn();
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
     * Create an instance of {@link IntegratedConfigurationReadOut }
     * 
     */
    public IntegratedConfigurationReadOut createIntegratedConfigurationReadOut() {
        return new IntegratedConfigurationReadOut();
    }

    /**
     * Create an instance of {@link IntegratedConfigurationQueryOut }
     * 
     */
    public IntegratedConfigurationQueryOut createIntegratedConfigurationQueryOut() {
        return new IntegratedConfigurationQueryOut();
    }

    /**
     * Create an instance of {@link IntegratedConfigurationQueryIn }
     * 
     */
    public IntegratedConfigurationQueryIn createIntegratedConfigurationQueryIn() {
        return new IntegratedConfigurationQueryIn();
    }

    /**
     * Create an instance of {@link IntegratedConfiguration }
     * 
     */
    public IntegratedConfiguration createIntegratedConfiguration() {
        return new IntegratedConfiguration();
    }

    /**
     * Create an instance of {@link InboundProcessing }
     * 
     */
    public InboundProcessing createInboundProcessing() {
        return new InboundProcessing();
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
     * Create an instance of {@link IntegratedConfigurationReceiverInterfaceRule }
     * 
     */
    public IntegratedConfigurationReceiverInterfaceRule createIntegratedConfigurationReceiverInterfaceRule() {
        return new IntegratedConfigurationReceiverInterfaceRule();
    }

    /**
     * Create an instance of {@link ChangeListID }
     * 
     */
    public ChangeListID createChangeListID() {
        return new ChangeListID();
    }

    /**
     * Create an instance of {@link ReceiverDeterminationInclude }
     * 
     */
    public ReceiverDeterminationInclude createReceiverDeterminationInclude() {
        return new ReceiverDeterminationInclude();
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
     * Create an instance of {@link IntegratedConfigurationReceiverRule }
     * 
     */
    public IntegratedConfigurationReceiverRule createIntegratedConfigurationReceiverRule() {
        return new IntegratedConfigurationReceiverRule();
    }

    /**
     * Create an instance of {@link MappingParameters }
     * 
     */
    public MappingParameters createMappingParameters() {
        return new MappingParameters();
    }

    /**
     * Create an instance of {@link ChannelProperty }
     * 
     */
    public ChannelProperty createChannelProperty() {
        return new ChannelProperty();
    }

    /**
     * Create an instance of {@link ReceiverDeterminationMapping }
     * 
     */
    public ReceiverDeterminationMapping createReceiverDeterminationMapping() {
        return new ReceiverDeterminationMapping();
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
     * Create an instance of {@link AtomicConditionBlock }
     * 
     */
    public AtomicConditionBlock createAtomicConditionBlock() {
        return new AtomicConditionBlock();
    }

    /**
     * Create an instance of {@link OutboundProcessing }
     * 
     */
    public OutboundProcessing createOutboundProcessing() {
        return new OutboundProcessing();
    }

    /**
     * Create an instance of {@link PrefixNamespaceMapping }
     * 
     */
    public PrefixNamespaceMapping createPrefixNamespaceMapping() {
        return new PrefixNamespaceMapping();
    }

    /**
     * Create an instance of {@link LogMessageCommunicationParty }
     * 
     */
    public LogMessageCommunicationParty createLogMessageCommunicationParty() {
        return new LogMessageCommunicationParty();
    }

    /**
     * Create an instance of {@link GenericPropertyTable }
     * 
     */
    public GenericPropertyTable createGenericPropertyTable() {
        return new GenericPropertyTable();
    }

    /**
     * Create an instance of {@link ReceiverInterfaces }
     * 
     */
    public ReceiverInterfaces createReceiverInterfaces() {
        return new ReceiverInterfaces();
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
     * Create an instance of {@link HeaderMapping }
     * 
     */
    public HeaderMapping createHeaderMapping() {
        return new HeaderMapping();
    }

    /**
     * Create an instance of {@link LogMessageProcessComponent }
     * 
     */
    public LogMessageProcessComponent createLogMessageProcessComponent() {
        return new LogMessageProcessComponent();
    }

    /**
     * Create an instance of {@link Extractor }
     * 
     */
    public Extractor createExtractor() {
        return new Extractor();
    }

    /**
     * Create an instance of {@link CommunicationPartnerExtractor }
     * 
     */
    public CommunicationPartnerExtractor createCommunicationPartnerExtractor() {
        return new CommunicationPartnerExtractor();
    }

    /**
     * Create an instance of {@link Condition }
     * 
     */
    public Condition createCondition() {
        return new Condition();
    }

    /**
     * Create an instance of {@link IntegerProperty }
     * 
     */
    public IntegerProperty createIntegerProperty() {
        return new IntegerProperty();
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
     * Create an instance of {@link Receivers }
     * 
     */
    public Receivers createReceivers() {
        return new Receivers();
    }

    /**
     * Create an instance of {@link AtomicCondition }
     * 
     */
    public AtomicCondition createAtomicCondition() {
        return new AtomicCondition();
    }

    /**
     * Create an instance of {@link LogMessageValueMapping }
     * 
     */
    public LogMessageValueMapping createLogMessageValueMapping() {
        return new LogMessageValueMapping();
    }

    /**
     * Create an instance of {@link RestrictedIntegratedConfiguration }
     * 
     */
    public RestrictedIntegratedConfiguration createRestrictedIntegratedConfiguration() {
        return new RestrictedIntegratedConfiguration();
    }

    /**
     * Create an instance of {@link RestrictedObjectAdministrativeData }
     * 
     */
    public RestrictedObjectAdministrativeData createRestrictedObjectAdministrativeData() {
        return new RestrictedObjectAdministrativeData();
    }

    /**
     * Create an instance of {@link DesignObjectID }
     * 
     */
    public DesignObjectID createDesignObjectID() {
        return new DesignObjectID();
    }

    /**
     * Create an instance of {@link AdvancedSettings }
     * 
     */
    public AdvancedSettings createAdvancedSettings() {
        return new AdvancedSettings();
    }

    /**
     * Create an instance of {@link LogMessage }
     * 
     */
    public LogMessage createLogMessage() {
        return new LogMessage();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link IntegratedConfigurationIdentifierCollection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "IntegratedConfigurationCheckRequest")
    public JAXBElement<IntegratedConfigurationIdentifierCollection> createIntegratedConfigurationCheckRequest(IntegratedConfigurationIdentifierCollection value) {
        return new JAXBElement<IntegratedConfigurationIdentifierCollection>(_IntegratedConfigurationCheckRequest_QNAME, IntegratedConfigurationIdentifierCollection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IntegratedConfigurationDeleteOpenForEditIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "IntegratedConfigurationOpenForEditRequest")
    public JAXBElement<IntegratedConfigurationDeleteOpenForEditIn> createIntegratedConfigurationOpenForEditRequest(IntegratedConfigurationDeleteOpenForEditIn value) {
        return new JAXBElement<IntegratedConfigurationDeleteOpenForEditIn>(_IntegratedConfigurationOpenForEditRequest_QNAME, IntegratedConfigurationDeleteOpenForEditIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IntegratedConfigurationOpenForEditOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "IntegratedConfigurationOpenForEditResponse")
    public JAXBElement<IntegratedConfigurationOpenForEditOut> createIntegratedConfigurationOpenForEditResponse(IntegratedConfigurationOpenForEditOut value) {
        return new JAXBElement<IntegratedConfigurationOpenForEditOut>(_IntegratedConfigurationOpenForEditResponse_QNAME, IntegratedConfigurationOpenForEditOut.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IntegratedConfigurationCreateChangeIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "IntegratedConfigurationCreateRequest")
    public JAXBElement<IntegratedConfigurationCreateChangeIn> createIntegratedConfigurationCreateRequest(IntegratedConfigurationCreateChangeIn value) {
        return new JAXBElement<IntegratedConfigurationCreateChangeIn>(_IntegratedConfigurationCreateRequest_QNAME, IntegratedConfigurationCreateChangeIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IntegratedConfigurationReadIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "IntegratedConfigurationReadRequest")
    public JAXBElement<IntegratedConfigurationReadIn> createIntegratedConfigurationReadRequest(IntegratedConfigurationReadIn value) {
        return new JAXBElement<IntegratedConfigurationReadIn>(_IntegratedConfigurationReadRequest_QNAME, IntegratedConfigurationReadIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IntegratedConfigurationCreateChangeIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "IntegratedConfigurationChangeRequest")
    public JAXBElement<IntegratedConfigurationCreateChangeIn> createIntegratedConfigurationChangeRequest(IntegratedConfigurationCreateChangeIn value) {
        return new JAXBElement<IntegratedConfigurationCreateChangeIn>(_IntegratedConfigurationChangeRequest_QNAME, IntegratedConfigurationCreateChangeIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IntegratedConfigurationIdentifierCollection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "IntegratedConfigurationRevertRequest")
    public JAXBElement<IntegratedConfigurationIdentifierCollection> createIntegratedConfigurationRevertRequest(IntegratedConfigurationIdentifierCollection value) {
        return new JAXBElement<IntegratedConfigurationIdentifierCollection>(_IntegratedConfigurationRevertRequest_QNAME, IntegratedConfigurationIdentifierCollection.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link IntegratedConfigurationReadOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "IntegratedConfigurationReadResponse")
    public JAXBElement<IntegratedConfigurationReadOut> createIntegratedConfigurationReadResponse(IntegratedConfigurationReadOut value) {
        return new JAXBElement<IntegratedConfigurationReadOut>(_IntegratedConfigurationReadResponse_QNAME, IntegratedConfigurationReadOut.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link IntegratedConfigurationQueryOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "IntegratedConfigurationQueryResponse")
    public JAXBElement<IntegratedConfigurationQueryOut> createIntegratedConfigurationQueryResponse(IntegratedConfigurationQueryOut value) {
        return new JAXBElement<IntegratedConfigurationQueryOut>(_IntegratedConfigurationQueryResponse_QNAME, IntegratedConfigurationQueryOut.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IntegratedConfigurationDeleteOpenForEditIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "IntegratedConfigurationDeleteRequest")
    public JAXBElement<IntegratedConfigurationDeleteOpenForEditIn> createIntegratedConfigurationDeleteRequest(IntegratedConfigurationDeleteOpenForEditIn value) {
        return new JAXBElement<IntegratedConfigurationDeleteOpenForEditIn>(_IntegratedConfigurationDeleteRequest_QNAME, IntegratedConfigurationDeleteOpenForEditIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IntegratedConfigurationQueryIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sap.com/xi/BASIS", name = "IntegratedConfigurationQueryRequest")
    public JAXBElement<IntegratedConfigurationQueryIn> createIntegratedConfigurationQueryRequest(IntegratedConfigurationQueryIn value) {
        return new JAXBElement<IntegratedConfigurationQueryIn>(_IntegratedConfigurationQueryRequest_QNAME, IntegratedConfigurationQueryIn.class, null, value);
    }

}
