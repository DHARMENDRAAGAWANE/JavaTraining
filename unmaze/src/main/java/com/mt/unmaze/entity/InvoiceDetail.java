/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mt.unmaze.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "invoice_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvoiceDetail.findAll", query = "SELECT i FROM InvoiceDetail i"),
    @NamedQuery(name = "InvoiceDetail.findByInvoiceDetailId", query = "SELECT i FROM InvoiceDetail i WHERE i.invoiceDetailId = :invoiceDetailId"),
    @NamedQuery(name = "InvoiceDetail.findByInvoiceQty", query = "SELECT i FROM InvoiceDetail i WHERE i.invoiceQty = :invoiceQty"),
    @NamedQuery(name = "InvoiceDetail.findByQtyRateInr", query = "SELECT i FROM InvoiceDetail i WHERE i.qtyRateInr = :qtyRateInr"),
    @NamedQuery(name = "InvoiceDetail.findByDiscountAmt", query = "SELECT i FROM InvoiceDetail i WHERE i.discountAmt = :discountAmt"),
    @NamedQuery(name = "InvoiceDetail.findByServiceChargeAmt", query = "SELECT i FROM InvoiceDetail i WHERE i.serviceChargeAmt = :serviceChargeAmt"),
    @NamedQuery(name = "InvoiceDetail.findByBasicAmt", query = "SELECT i FROM InvoiceDetail i WHERE i.basicAmt = :basicAmt"),
    @NamedQuery(name = "InvoiceDetail.findByCgstAmt", query = "SELECT i FROM InvoiceDetail i WHERE i.cgstAmt = :cgstAmt"),
    @NamedQuery(name = "InvoiceDetail.findBySgstAmt", query = "SELECT i FROM InvoiceDetail i WHERE i.sgstAmt = :sgstAmt"),
    @NamedQuery(name = "InvoiceDetail.findByIgstAmt", query = "SELECT i FROM InvoiceDetail i WHERE i.igstAmt = :igstAmt"),
    @NamedQuery(name = "InvoiceDetail.findByCessAmt", query = "SELECT i FROM InvoiceDetail i WHERE i.cessAmt = :cessAmt"),
    @NamedQuery(name = "InvoiceDetail.findByVatAmt", query = "SELECT i FROM InvoiceDetail i WHERE i.vatAmt = :vatAmt"),
    @NamedQuery(name = "InvoiceDetail.findByTotalAmt", query = "SELECT i FROM InvoiceDetail i WHERE i.totalAmt = :totalAmt"),
    @NamedQuery(name = "InvoiceDetail.findByCreatedAt", query = "SELECT i FROM InvoiceDetail i WHERE i.createdAt = :createdAt"),
    @NamedQuery(name = "InvoiceDetail.findByLastUpdatedAt", query = "SELECT i FROM InvoiceDetail i WHERE i.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "InvoiceDetail.findByIsActive", query = "SELECT i FROM InvoiceDetail i WHERE i.isActive = :isActive"),
    @NamedQuery(name = "InvoiceDetail.findByIpAddress", query = "SELECT i FROM InvoiceDetail i WHERE i.ipAddress = :ipAddress")})
public class InvoiceDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "invoice_detail_id")
    private Integer invoiceDetailId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "invoice_qty")
    private Double invoiceQty;
    @Column(name = "qty_rate_inr")
    private Double qtyRateInr;
    @Column(name = "discount_amt")
    private Double discountAmt;
    @Column(name = "service_charge_amt")
    private Double serviceChargeAmt;
    @Column(name = "basic_amt")
    private Double basicAmt;
    @Column(name = "cgst_amt")
    private Double cgstAmt;
    @Column(name = "sgst_amt")
    private Double sgstAmt;
    @Column(name = "igst_amt")
    private Double igstAmt;
    @Column(name = "cess_amt")
    private Double cessAmt;
    @Column(name = "vat_amt")
    private Double vatAmt;
    @Column(name = "total_amt")
    private Double totalAmt;
    @Lob
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "last_updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedAt;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @Column(name = "ip_address")
    private String ipAddress;
    @JoinColumn(name = "booking_detail_id", referencedColumnName = "booking_detail_id")
    @ManyToOne(optional = false)
    private BookingDetail bookingDetailId;
    @JoinColumn(name = "booking_master_id", referencedColumnName = "booking_master_id")
    @ManyToOne(optional = false)
    private BookingMaster bookingMasterId;
    @JoinColumn(name = "invoice_master_id", referencedColumnName = "invoice_master_id")
    @ManyToOne(optional = false)
    private InvoiceMaster invoiceMasterId;
    @JoinColumn(name = "material_master_id", referencedColumnName = "material_master_id")
    @ManyToOne
    private MaterialMaster materialMasterId;
    @JoinColumn(name = "service_master_id", referencedColumnName = "service_master_id")
    @ManyToOne
    private ServiceMaster serviceMasterId;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoiceDetailId")
    private List<CreditNoteDetail> creditNoteDetailList;

    public InvoiceDetail() {
    }

    public InvoiceDetail(Integer invoiceDetailId) {
        this.invoiceDetailId = invoiceDetailId;
    }

    public InvoiceDetail(Integer invoiceDetailId, Character isActive) {
        this.invoiceDetailId = invoiceDetailId;
        this.isActive = isActive;
    }

    public Integer getInvoiceDetailId() {
        return invoiceDetailId;
    }

    public void setInvoiceDetailId(Integer invoiceDetailId) {
        this.invoiceDetailId = invoiceDetailId;
    }

    public Double getInvoiceQty() {
        return invoiceQty;
    }

    public void setInvoiceQty(Double invoiceQty) {
        this.invoiceQty = invoiceQty;
    }

    public Double getQtyRateInr() {
        return qtyRateInr;
    }

    public void setQtyRateInr(Double qtyRateInr) {
        this.qtyRateInr = qtyRateInr;
    }

    public Double getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(Double discountAmt) {
        this.discountAmt = discountAmt;
    }

    public Double getServiceChargeAmt() {
        return serviceChargeAmt;
    }

    public void setServiceChargeAmt(Double serviceChargeAmt) {
        this.serviceChargeAmt = serviceChargeAmt;
    }

    public Double getBasicAmt() {
        return basicAmt;
    }

    public void setBasicAmt(Double basicAmt) {
        this.basicAmt = basicAmt;
    }

    public Double getCgstAmt() {
        return cgstAmt;
    }

    public void setCgstAmt(Double cgstAmt) {
        this.cgstAmt = cgstAmt;
    }

    public Double getSgstAmt() {
        return sgstAmt;
    }

    public void setSgstAmt(Double sgstAmt) {
        this.sgstAmt = sgstAmt;
    }

    public Double getIgstAmt() {
        return igstAmt;
    }

    public void setIgstAmt(Double igstAmt) {
        this.igstAmt = igstAmt;
    }

    public Double getCessAmt() {
        return cessAmt;
    }

    public void setCessAmt(Double cessAmt) {
        this.cessAmt = cessAmt;
    }

    public Double getVatAmt() {
        return vatAmt;
    }

    public void setVatAmt(Double vatAmt) {
        this.vatAmt = vatAmt;
    }

    public Double getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(Double totalAmt) {
        this.totalAmt = totalAmt;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public BookingDetail getBookingDetailId() {
        return bookingDetailId;
    }

    public void setBookingDetailId(BookingDetail bookingDetailId) {
        this.bookingDetailId = bookingDetailId;
    }

    public BookingMaster getBookingMasterId() {
        return bookingMasterId;
    }

    public void setBookingMasterId(BookingMaster bookingMasterId) {
        this.bookingMasterId = bookingMasterId;
    }

    public InvoiceMaster getInvoiceMasterId() {
        return invoiceMasterId;
    }

    public void setInvoiceMasterId(InvoiceMaster invoiceMasterId) {
        this.invoiceMasterId = invoiceMasterId;
    }

    public MaterialMaster getMaterialMasterId() {
        return materialMasterId;
    }

    public void setMaterialMasterId(MaterialMaster materialMasterId) {
        this.materialMasterId = materialMasterId;
    }

    public ServiceMaster getServiceMasterId() {
        return serviceMasterId;
    }

    public void setServiceMasterId(ServiceMaster serviceMasterId) {
        this.serviceMasterId = serviceMasterId;
    }

    public UserMaster getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(UserMaster lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public UserMaster getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserMaster createdBy) {
        this.createdBy = createdBy;
    }

    @XmlTransient
    public List<CreditNoteDetail> getCreditNoteDetailList() {
        return creditNoteDetailList;
    }

    public void setCreditNoteDetailList(List<CreditNoteDetail> creditNoteDetailList) {
        this.creditNoteDetailList = creditNoteDetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceDetailId != null ? invoiceDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceDetail)) {
            return false;
        }
        InvoiceDetail other = (InvoiceDetail) object;
        if ((this.invoiceDetailId == null && other.invoiceDetailId != null) || (this.invoiceDetailId != null && !this.invoiceDetailId.equals(other.invoiceDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.InvoiceDetail[ invoiceDetailId=" + invoiceDetailId + " ]";
    }
    
}
