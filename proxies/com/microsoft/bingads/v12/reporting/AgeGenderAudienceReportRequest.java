
package com.microsoft.bingads.v12.reporting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AgeGenderAudienceReportRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AgeGenderAudienceReportRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{https://bingads.microsoft.com/Reporting/v12}ReportRequest">
 *       &lt;sequence>
 *         &lt;element name="Aggregation" type="{https://bingads.microsoft.com/Reporting/v12}ReportAggregation"/>
 *         &lt;element name="Columns" type="{https://bingads.microsoft.com/Reporting/v12}ArrayOfAgeGenderAudienceReportColumn"/>
 *         &lt;element name="Filter" type="{https://bingads.microsoft.com/Reporting/v12}AgeGenderAudienceReportFilter" minOccurs="0"/>
 *         &lt;element name="Scope" type="{https://bingads.microsoft.com/Reporting/v12}AccountThroughAdGroupReportScope"/>
 *         &lt;element name="Time" type="{https://bingads.microsoft.com/Reporting/v12}ReportTime"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AgeGenderAudienceReportRequest", propOrder = {
    "aggregation",
    "columns",
    "filter",
    "scope",
    "time"
})
public class AgeGenderAudienceReportRequest
    extends ReportRequest
{

    @XmlElement(name = "Aggregation", required = true)
    @XmlSchemaType(name = "string")
    protected ReportAggregation aggregation;
    @XmlElement(name = "Columns", required = true, nillable = true)
    protected ArrayOfAgeGenderAudienceReportColumn columns;
    @XmlElement(name = "Filter", nillable = true)
    protected AgeGenderAudienceReportFilter filter;
    @XmlElement(name = "Scope", required = true, nillable = true)
    protected AccountThroughAdGroupReportScope scope;
    @XmlElement(name = "Time", required = true, nillable = true)
    protected ReportTime time;

    /**
     * Gets the value of the aggregation property.
     * 
     * @return
     *     possible object is
     *     {@link ReportAggregation }
     *     
     */
    public ReportAggregation getAggregation() {
        return aggregation;
    }

    /**
     * Sets the value of the aggregation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportAggregation }
     *     
     */
    public void setAggregation(ReportAggregation value) {
        this.aggregation = value;
    }

    /**
     * Gets the value of the columns property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAgeGenderAudienceReportColumn }
     *     
     */
    public ArrayOfAgeGenderAudienceReportColumn getColumns() {
        return columns;
    }

    /**
     * Sets the value of the columns property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAgeGenderAudienceReportColumn }
     *     
     */
    public void setColumns(ArrayOfAgeGenderAudienceReportColumn value) {
        this.columns = value;
    }

    /**
     * Gets the value of the filter property.
     * 
     * @return
     *     possible object is
     *     {@link AgeGenderAudienceReportFilter }
     *     
     */
    public AgeGenderAudienceReportFilter getFilter() {
        return filter;
    }

    /**
     * Sets the value of the filter property.
     * 
     * @param value
     *     allowed object is
     *     {@link AgeGenderAudienceReportFilter }
     *     
     */
    public void setFilter(AgeGenderAudienceReportFilter value) {
        this.filter = value;
    }

    /**
     * Gets the value of the scope property.
     * 
     * @return
     *     possible object is
     *     {@link AccountThroughAdGroupReportScope }
     *     
     */
    public AccountThroughAdGroupReportScope getScope() {
        return scope;
    }

    /**
     * Sets the value of the scope property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountThroughAdGroupReportScope }
     *     
     */
    public void setScope(AccountThroughAdGroupReportScope value) {
        this.scope = value;
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link ReportTime }
     *     
     */
    public ReportTime getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportTime }
     *     
     */
    public void setTime(ReportTime value) {
        this.time = value;
    }

}
