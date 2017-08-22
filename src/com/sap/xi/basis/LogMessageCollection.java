
package com.sap.xi.basis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LogMessageCollection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LogMessageCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LogMessage" type="{http://sap.com/xi/BASIS}LogMessage" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LogMessageChangeList" type="{http://sap.com/xi/BASIS}LogMessageChangeList" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LogMessageParty" type="{http://sap.com/xi/BASIS}LogMessageCommunicationParty" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LogMessageProcessComponent" type="{http://sap.com/xi/BASIS}LogMessageProcessComponent" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LogMessageBusinessSystem" type="{http://sap.com/xi/BASIS}LogMessageCommunicationComponent" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LogMessageBusinessComponent" type="{http://sap.com/xi/BASIS}LogMessageCommunicationComponent" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LogMessageIntegrationProcess" type="{http://sap.com/xi/BASIS}LogMessageCommunicationComponent" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LogMessageCommunicationChannel" type="{http://sap.com/xi/BASIS}LogMessageCommunicationChannel" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LogMessageSenderAgreement" type="{http://sap.com/xi/BASIS}LogMessageMessageHeader" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LogMessageReceiverAgreement" type="{http://sap.com/xi/BASIS}LogMessageMessageHeader" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LogMessageDirectConnection" type="{http://sap.com/xi/BASIS}LogMessageMessageHeader" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LogMessageIntegratedConfiguration" type="{http://sap.com/xi/BASIS}LogMessageMessageHeader" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LogMessageReceiverDetermination" type="{http://sap.com/xi/BASIS}LogMessageMessageHeader" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LogMessageReceiverRule" type="{http://sap.com/xi/BASIS}LogMessageReceiverRule" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LogMessageInterfaceDetermination" type="{http://sap.com/xi/BASIS}LogMessageMessageHeader" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LogMessageValueMapping" type="{http://sap.com/xi/BASIS}LogMessageValueMapping" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LogMessageConfigurationScenario" type="{http://sap.com/xi/BASIS}LogMessageConfigurationScenario" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogMessageCollection", propOrder = {
    "logMessage",
    "logMessageChangeList",
    "logMessageParty",
    "logMessageProcessComponent",
    "logMessageBusinessSystem",
    "logMessageBusinessComponent",
    "logMessageIntegrationProcess",
    "logMessageCommunicationChannel",
    "logMessageSenderAgreement",
    "logMessageReceiverAgreement",
    "logMessageDirectConnection",
    "logMessageIntegratedConfiguration",
    "logMessageReceiverDetermination",
    "logMessageReceiverRule",
    "logMessageInterfaceDetermination",
    "logMessageValueMapping",
    "logMessageConfigurationScenario"
})
public class LogMessageCollection {

    @XmlElement(name = "LogMessage")
    protected List<LogMessage> logMessage;
    @XmlElement(name = "LogMessageChangeList")
    protected List<LogMessageChangeList> logMessageChangeList;
    @XmlElement(name = "LogMessageParty")
    protected List<LogMessageCommunicationParty> logMessageParty;
    @XmlElement(name = "LogMessageProcessComponent")
    protected List<LogMessageProcessComponent> logMessageProcessComponent;
    @XmlElement(name = "LogMessageBusinessSystem")
    protected List<LogMessageCommunicationComponent> logMessageBusinessSystem;
    @XmlElement(name = "LogMessageBusinessComponent")
    protected List<LogMessageCommunicationComponent> logMessageBusinessComponent;
    @XmlElement(name = "LogMessageIntegrationProcess")
    protected List<LogMessageCommunicationComponent> logMessageIntegrationProcess;
    @XmlElement(name = "LogMessageCommunicationChannel")
    protected List<LogMessageCommunicationChannel> logMessageCommunicationChannel;
    @XmlElement(name = "LogMessageSenderAgreement")
    protected List<LogMessageMessageHeader> logMessageSenderAgreement;
    @XmlElement(name = "LogMessageReceiverAgreement")
    protected List<LogMessageMessageHeader> logMessageReceiverAgreement;
    @XmlElement(name = "LogMessageDirectConnection")
    protected List<LogMessageMessageHeader> logMessageDirectConnection;
    @XmlElement(name = "LogMessageIntegratedConfiguration")
    protected List<LogMessageMessageHeader> logMessageIntegratedConfiguration;
    @XmlElement(name = "LogMessageReceiverDetermination")
    protected List<LogMessageMessageHeader> logMessageReceiverDetermination;
    @XmlElement(name = "LogMessageReceiverRule")
    protected List<LogMessageReceiverRule> logMessageReceiverRule;
    @XmlElement(name = "LogMessageInterfaceDetermination")
    protected List<LogMessageMessageHeader> logMessageInterfaceDetermination;
    @XmlElement(name = "LogMessageValueMapping")
    protected List<LogMessageValueMapping> logMessageValueMapping;
    @XmlElement(name = "LogMessageConfigurationScenario")
    protected List<LogMessageConfigurationScenario> logMessageConfigurationScenario;

    /**
     * Gets the value of the logMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogMessage }
     * 
     * 
     */
    public List<LogMessage> getLogMessage() {
        if (logMessage == null) {
            logMessage = new ArrayList<LogMessage>();
        }
        return this.logMessage;
    }

    /**
     * Gets the value of the logMessageChangeList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logMessageChangeList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogMessageChangeList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogMessageChangeList }
     * 
     * 
     */
    public List<LogMessageChangeList> getLogMessageChangeList() {
        if (logMessageChangeList == null) {
            logMessageChangeList = new ArrayList<LogMessageChangeList>();
        }
        return this.logMessageChangeList;
    }

    /**
     * Gets the value of the logMessageParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logMessageParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogMessageParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogMessageCommunicationParty }
     * 
     * 
     */
    public List<LogMessageCommunicationParty> getLogMessageParty() {
        if (logMessageParty == null) {
            logMessageParty = new ArrayList<LogMessageCommunicationParty>();
        }
        return this.logMessageParty;
    }

    /**
     * Gets the value of the logMessageProcessComponent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logMessageProcessComponent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogMessageProcessComponent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogMessageProcessComponent }
     * 
     * 
     */
    public List<LogMessageProcessComponent> getLogMessageProcessComponent() {
        if (logMessageProcessComponent == null) {
            logMessageProcessComponent = new ArrayList<LogMessageProcessComponent>();
        }
        return this.logMessageProcessComponent;
    }

    /**
     * Gets the value of the logMessageBusinessSystem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logMessageBusinessSystem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogMessageBusinessSystem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogMessageCommunicationComponent }
     * 
     * 
     */
    public List<LogMessageCommunicationComponent> getLogMessageBusinessSystem() {
        if (logMessageBusinessSystem == null) {
            logMessageBusinessSystem = new ArrayList<LogMessageCommunicationComponent>();
        }
        return this.logMessageBusinessSystem;
    }

    /**
     * Gets the value of the logMessageBusinessComponent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logMessageBusinessComponent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogMessageBusinessComponent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogMessageCommunicationComponent }
     * 
     * 
     */
    public List<LogMessageCommunicationComponent> getLogMessageBusinessComponent() {
        if (logMessageBusinessComponent == null) {
            logMessageBusinessComponent = new ArrayList<LogMessageCommunicationComponent>();
        }
        return this.logMessageBusinessComponent;
    }

    /**
     * Gets the value of the logMessageIntegrationProcess property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logMessageIntegrationProcess property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogMessageIntegrationProcess().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogMessageCommunicationComponent }
     * 
     * 
     */
    public List<LogMessageCommunicationComponent> getLogMessageIntegrationProcess() {
        if (logMessageIntegrationProcess == null) {
            logMessageIntegrationProcess = new ArrayList<LogMessageCommunicationComponent>();
        }
        return this.logMessageIntegrationProcess;
    }

    /**
     * Gets the value of the logMessageCommunicationChannel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logMessageCommunicationChannel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogMessageCommunicationChannel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogMessageCommunicationChannel }
     * 
     * 
     */
    public List<LogMessageCommunicationChannel> getLogMessageCommunicationChannel() {
        if (logMessageCommunicationChannel == null) {
            logMessageCommunicationChannel = new ArrayList<LogMessageCommunicationChannel>();
        }
        return this.logMessageCommunicationChannel;
    }

    /**
     * Gets the value of the logMessageSenderAgreement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logMessageSenderAgreement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogMessageSenderAgreement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogMessageMessageHeader }
     * 
     * 
     */
    public List<LogMessageMessageHeader> getLogMessageSenderAgreement() {
        if (logMessageSenderAgreement == null) {
            logMessageSenderAgreement = new ArrayList<LogMessageMessageHeader>();
        }
        return this.logMessageSenderAgreement;
    }

    /**
     * Gets the value of the logMessageReceiverAgreement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logMessageReceiverAgreement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogMessageReceiverAgreement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogMessageMessageHeader }
     * 
     * 
     */
    public List<LogMessageMessageHeader> getLogMessageReceiverAgreement() {
        if (logMessageReceiverAgreement == null) {
            logMessageReceiverAgreement = new ArrayList<LogMessageMessageHeader>();
        }
        return this.logMessageReceiverAgreement;
    }

    /**
     * Gets the value of the logMessageDirectConnection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logMessageDirectConnection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogMessageDirectConnection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogMessageMessageHeader }
     * 
     * 
     */
    public List<LogMessageMessageHeader> getLogMessageDirectConnection() {
        if (logMessageDirectConnection == null) {
            logMessageDirectConnection = new ArrayList<LogMessageMessageHeader>();
        }
        return this.logMessageDirectConnection;
    }

    /**
     * Gets the value of the logMessageIntegratedConfiguration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logMessageIntegratedConfiguration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogMessageIntegratedConfiguration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogMessageMessageHeader }
     * 
     * 
     */
    public List<LogMessageMessageHeader> getLogMessageIntegratedConfiguration() {
        if (logMessageIntegratedConfiguration == null) {
            logMessageIntegratedConfiguration = new ArrayList<LogMessageMessageHeader>();
        }
        return this.logMessageIntegratedConfiguration;
    }

    /**
     * Gets the value of the logMessageReceiverDetermination property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logMessageReceiverDetermination property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogMessageReceiverDetermination().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogMessageMessageHeader }
     * 
     * 
     */
    public List<LogMessageMessageHeader> getLogMessageReceiverDetermination() {
        if (logMessageReceiverDetermination == null) {
            logMessageReceiverDetermination = new ArrayList<LogMessageMessageHeader>();
        }
        return this.logMessageReceiverDetermination;
    }

    /**
     * Gets the value of the logMessageReceiverRule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logMessageReceiverRule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogMessageReceiverRule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogMessageReceiverRule }
     * 
     * 
     */
    public List<LogMessageReceiverRule> getLogMessageReceiverRule() {
        if (logMessageReceiverRule == null) {
            logMessageReceiverRule = new ArrayList<LogMessageReceiverRule>();
        }
        return this.logMessageReceiverRule;
    }

    /**
     * Gets the value of the logMessageInterfaceDetermination property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logMessageInterfaceDetermination property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogMessageInterfaceDetermination().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogMessageMessageHeader }
     * 
     * 
     */
    public List<LogMessageMessageHeader> getLogMessageInterfaceDetermination() {
        if (logMessageInterfaceDetermination == null) {
            logMessageInterfaceDetermination = new ArrayList<LogMessageMessageHeader>();
        }
        return this.logMessageInterfaceDetermination;
    }

    /**
     * Gets the value of the logMessageValueMapping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logMessageValueMapping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogMessageValueMapping().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogMessageValueMapping }
     * 
     * 
     */
    public List<LogMessageValueMapping> getLogMessageValueMapping() {
        if (logMessageValueMapping == null) {
            logMessageValueMapping = new ArrayList<LogMessageValueMapping>();
        }
        return this.logMessageValueMapping;
    }

    /**
     * Gets the value of the logMessageConfigurationScenario property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logMessageConfigurationScenario property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogMessageConfigurationScenario().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogMessageConfigurationScenario }
     * 
     * 
     */
    public List<LogMessageConfigurationScenario> getLogMessageConfigurationScenario() {
        if (logMessageConfigurationScenario == null) {
            logMessageConfigurationScenario = new ArrayList<LogMessageConfigurationScenario>();
        }
        return this.logMessageConfigurationScenario;
    }

}
