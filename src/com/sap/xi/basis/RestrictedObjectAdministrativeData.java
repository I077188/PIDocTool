
package com.sap.xi.basis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * ObjectAdministrativeData
 * 
 * <p>Java class for RestrictedObjectAdministrativeData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RestrictedObjectAdministrativeData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResponsibleUserAccountID" type="{http://sap.com/xi/BASIS}UserID" minOccurs="0"/>
 *         &lt;element name="FolderPathID" type="{http://sap.com/xi/BASIS}LANGUAGEINDEPENDENT_Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RestrictedObjectAdministrativeData", propOrder = {
    "responsibleUserAccountID",
    "folderPathID"
})
public class RestrictedObjectAdministrativeData {

    @XmlElement(name = "ResponsibleUserAccountID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String responsibleUserAccountID;
    @XmlElement(name = "FolderPathID")
    protected String folderPathID;

    /**
     * Gets the value of the responsibleUserAccountID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponsibleUserAccountID() {
        return responsibleUserAccountID;
    }

    /**
     * Sets the value of the responsibleUserAccountID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponsibleUserAccountID(String value) {
        this.responsibleUserAccountID = value;
    }

    /**
     * Gets the value of the folderPathID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFolderPathID() {
        return folderPathID;
    }

    /**
     * Sets the value of the folderPathID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFolderPathID(String value) {
        this.folderPathID = value;
    }

}
