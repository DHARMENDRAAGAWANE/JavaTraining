/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mt.unmaze.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "credit_note_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CreditNoteDetail.findAll", query = "SELECT c FROM CreditNoteDetail c"),
    @NamedQuery(name = "CreditNoteDetail.findByCreditNoteDetailId", query = "SELECT c FROM CreditNoteDetail c WHERE c.creditNoteDetailId = :creditNoteDetailId"),
    @NamedQuery(name = "CreditNoteDetail.findByCreditNoteQty", query = "SELECT c FROM CreditNoteDetail c WHERE c.creditNoteQty = :creditNoteQty"),
    @NamedQuery(name = "CreditNoteDetail.findByQtyRateInr", query = "SELECT c FROM CreditNoteDetail c WHERE c.qtyRateInr = :qtyRateInr"),
    @NamedQuery(name = "CreditNoteDetail.findByDiscountAmt", query = "SELECT c FROM CreditNoteDetail c WHERE c.discountAmt = :discountAmt"),
    @NamedQuery(name = "CreditNoteDetail.findByServiceChargeAmt", query = "SELECT c FROM CreditNoteDetail c WHERE c.serviceChargeAmt = :serviceChargeAmt"),
    @NamedQuery(name = "CreditNoteDetail.findByBasicAmt", query = "SELECT c FROM CreditNoteDetail c WHERE c.basicAmt = :basicAmt"),
    @NamedQuery(name = "CreditNoteDetail.findByCgstAmt", query = "SELECT c FROM CreditNoteDetail c WHERE c.cgstAmt = :cgstAmt"),
    @NamedQuery(name = "CreditNoteDetail.findBySgstAmt", query = "SELECT c FROM CreditNoteDetail c WHERE c.sgstAmt = :sgstAmt"),
    @NamedQuery(name = "CreditNoteDetail.findByIgstAmt", query = "SELECT c FROM CreditNoteDetail c WHERE c.igstAmt = :igstAmt"),
    @NamedQuery(name = "CreditNoteDetail.findByCessAmt", query = "SELECT c FROM CreditNoteDetail c WHERE c.cessAmt = :cessAmt"),
    @NamedQuery(name = "CreditNoteDetail.findByVatAmt", query = "SELECT c FROM CreditNoteDetail c WHERE c.vatAmt = :vatAmt"),
    @NamedQuery(name = "CreditNoteDetail.findByTotalAmt", query = "SELECT c FROM CreditNoteDetail c WHERE c.totalAmt = :totalAmt"),
    @NamedQuery(name = "CreditNoteDetail.findByCreatedAt", query = "SELECT c FROM CreditNoteDetail c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "CreditNoteDetail.findByLastUpdatedAt", query = "SELECT c FROM CreditNoteDetail c WHERE c.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "CreditNoteDetail.findByIsActive", query = "SELECT c FROM CreditNoteDetail c WHERE c.isActive = :isActive"),
    @NamedQuery(name = "CreditNoteDetail.findByIpAddress", query = "SELECT c FROM CreditNoteDetail c WHERE c.ipAddress = :ipAddress")})
public class CreditNoteDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "credit_note_detail_id")
    private Integer creditNoteDetailId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "credit_note_qty")
    private Double creditNoteQty;
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
    @JoinColumn(name = "credit_note_master_id", referencedColumnName = "credit_note_master_id")
    @ManyToOne(optional = false)
    private CreditNoteMaster creditNoteMasterId;
    @JoinColumn(name = "invoice_detail_id", referencedColumnName = "invoice_detail_id")
    @ManyToOne(optional = false)
    private InvoiceDetail invoiceDetailId;
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

    public CreditNoteDetail() {
    }

    public CreditNoteDetail(Integer creditNoteDetailId) {
        this.creditNoteDetailId = creditNoteDetailId;
    }

    public CreditNoteDetail(Integer creditNoteDetailId, Character isActive) {
        this.creditNoteDetailId = creditNoteDetailId;
        this.isActive = isActive;
    }

    public Integer getCreditNoteDetailId() {
        return creditNoteDetailId;
    }

    public void setCreditNoteDetailId(Integer creditNoteDetailId) {
        this.creditNoteDetailId = creditNoteDetailId;
    }

    public Double getCreditNoteQty() {
        return creditNoteQty;
    }

    public void setCreditNoteQty(Double creditNoteQty) {
        this.creditNoteQty = creditNoteQty;
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

    public CreditNoteMaster getCreditNoteMasterId() {
        return creditNoteMasterId;
    }

    public void setCreditNoteMasterId(CreditNoteMaster creditNoteMasterId) {
        this.creditNoteMasterId = creditNoteMasterId;
    }

    public InvoiceDetail getInvoiceDetailId() {
        return invoiceDetailId;
    }

    public void setInvoiceDetailId(InvoiceDetail invoiceDetailId) {
        this.invoiceDetailId = invoiceDetailId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (creditNoteDetailId != null ? creditNoteDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditNoteDetail)) {
            return false;
        }
        CreditNoteDetail other = (CreditNoteDetail) object;
        if ((this.creditNoteDetailId == null && other.creditNoteDetailId != null) || (this.creditNoteDetailId != null && !this.creditNoteDetailId.equals(other.creditNoteDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.CreditNoteDetail[ creditNoteDetailId=" + creditNoteDetailId + " ]";
    }
    
}
