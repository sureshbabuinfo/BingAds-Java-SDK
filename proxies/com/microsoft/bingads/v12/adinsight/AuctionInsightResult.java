
package com.microsoft.bingads.v12.adinsight;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuctionInsightResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuctionInsightResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Segment" type="{http://schemas.datacontract.org/2004/07/Microsoft.BingAds.Advertiser.AdInsight.Api.DataContract.V12.Entity}AuctionSegment" minOccurs="0"/>
 *         &lt;element name="Entries" type="{http://schemas.datacontract.org/2004/07/Microsoft.BingAds.Advertiser.AdInsight.Api.DataContract.V12.Entity}ArrayOfAuctionInsightEntry" minOccurs="0"/>
 *         &lt;element name="UsedImpressions" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="UsedKeywords" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuctionInsightResult", propOrder = {
    "segment",
    "entries",
    "usedImpressions",
    "usedKeywords"
})
public class AuctionInsightResult {

    @XmlElement(name = "Segment", nillable = true)
    @XmlSchemaType(name = "string")
    protected AuctionSegment segment;
    @XmlElement(name = "Entries", nillable = true)
    protected ArrayOfAuctionInsightEntry entries;
    @XmlElement(name = "UsedImpressions")
    protected Double usedImpressions;
    @XmlElement(name = "UsedKeywords")
    protected Double usedKeywords;

    /**
     * Gets the value of the segment property.
     * 
     * @return
     *     possible object is
     *     {@link AuctionSegment }
     *     
     */
    public AuctionSegment getSegment() {
        return segment;
    }

    /**
     * Sets the value of the segment property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuctionSegment }
     *     
     */
    public void setSegment(AuctionSegment value) {
        this.segment = value;
    }

    /**
     * Gets the value of the entries property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAuctionInsightEntry }
     *     
     */
    public ArrayOfAuctionInsightEntry getEntries() {
        return entries;
    }

    /**
     * Sets the value of the entries property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAuctionInsightEntry }
     *     
     */
    public void setEntries(ArrayOfAuctionInsightEntry value) {
        this.entries = value;
    }

    /**
     * Gets the value of the usedImpressions property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getUsedImpressions() {
        return usedImpressions;
    }

    /**
     * Sets the value of the usedImpressions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setUsedImpressions(Double value) {
        this.usedImpressions = value;
    }

    /**
     * Gets the value of the usedKeywords property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getUsedKeywords() {
        return usedKeywords;
    }

    /**
     * Sets the value of the usedKeywords property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setUsedKeywords(Double value) {
        this.usedKeywords = value;
    }

}
