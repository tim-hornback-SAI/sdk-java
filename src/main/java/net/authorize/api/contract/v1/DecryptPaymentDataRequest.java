//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.25 at 03:55:04 PM IST 
//


package net.authorize.api.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}ANetApiRequest">
 *       &lt;sequence>
 *         &lt;element name="opaqueData" type="{AnetApi/xml/v1/schema/AnetApiSchema.xsd}opaqueDataType"/>
 *         &lt;element name="callId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "opaqueData",
    "callId"
})
@XmlRootElement(name = "decryptPaymentDataRequest")
public class DecryptPaymentDataRequest
    extends ANetApiRequest
{

    @XmlElement(required = true)
    protected OpaqueDataType opaqueData;
    protected String callId;

    /**
     * Gets the value of the opaqueData property.
     * 
     * @return
     *     possible object is
     *     {@link OpaqueDataType }
     *     
     */
    public OpaqueDataType getOpaqueData() {
        return opaqueData;
    }

    /**
     * Sets the value of the opaqueData property.
     * 
     * @param value
     *     allowed object is
     *     {@link OpaqueDataType }
     *     
     */
    public void setOpaqueData(OpaqueDataType value) {
        this.opaqueData = value;
    }

    /**
     * Gets the value of the callId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallId() {
        return callId;
    }

    /**
     * Sets the value of the callId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallId(String value) {
        this.callId = value;
    }

}
