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
@Table(name = "credit_note_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CreditNoteMaster.findAll", query = "SELECT c FROM CreditNoteMaster c"),
    @NamedQuery(name = "CreditNoteMaster.findByCreditNoteMasterId", query = "SELECT c FROM CreditNoteMaster c WHERE c.creditNoteMasterId = :creditNoteMasterId"),
    @NamedQuery(name = "CreditNoteMaster.findByDate", query = "SELECT c FROM CreditNoteMaster c WHERE c.date = :date"),
    @NamedQuery(name = "CreditNoteMaster.findByCreditNoteNo", query = "SELECT c FROM CreditNoteMaster c WHERE c.creditNoteNo = :creditNoteNo"),
    @NamedQuery(name = "CreditNoteMaster.findByExchangeRate", query = "SELECT c FROM CreditNoteMaster c WHERE c.exchangeRate = :exchangeRate"),
    @NamedQuery(name = "CreditNoteMaster.findByDiscountAmt", query = "SELECT c FROM CreditNoteMaster c WHERE c.discountAmt = :discountAmt"),
    @NamedQuery(name = "CreditNoteMaster.findByServiceChargeAmt", query = "SELECT c FROM CreditNoteMaster c WHERE c.serviceChargeAmt = :serviceChargeAmt"),
    @NamedQuery(name = "CreditNoteMaster.findByQtyRateInr", query = "SELECT c FROM CreditNoteMaster c WHERE c.qtyRateInr = :qtyRateInr"),
    @NamedQuery(name = "CreditNoteMaster.findByCustomerAmt", query = "SELECT c FROM CreditNoteMaster c WHERE c.customerAmt = :customerAmt"),
    @NamedQuery(name = "CreditNoteMaster.findByRevenueAmt", query = "SELECT c FROM CreditNoteMaster c WHERE c.revenueAmt = :revenueAmt"),
    @NamedQuery(name = "CreditNoteMaster.findByCgstPayable", query = "SELECT c FROM CreditNoteMaster c WHERE c.cgstPayable = :cgstPayable"),
    @NamedQuery(name = "CreditNoteMaster.findBySgstPayable", query = "SELECT c FROM CreditNoteMaster c WHERE c.sgstPayable = :sgstPayable"),
    @NamedQuery(name = "CreditNoteMaster.findByIgstPayable", query = "SELECT c FROM CreditNoteMaster c WHERE c.igstPayable = :igstPayable"),
    @NamedQuery(name = "CreditNoteMaster.findByCessPayable", query = "SELECT c FROM CreditNoteMaster c WHERE c.cessPayable = :cessPayable"),
    @NamedQuery(name = "CreditNoteMaster.findByVatPayable", query = "SELECT c FROM CreditNoteMaster c WHERE c.vatPayable = :vatPayable"),
    @NamedQuery(name = "CreditNoteMaster.findByCreditNoteStatus", query = "SELECT c FROM CreditNoteMaster c WHERE c.creditNoteStatus = :creditNoteStatus"),
    @NamedQuery(name = "CreditNoteMaster.findByActiveStatus", query = "SELECT c FROM CreditNoteMaster c WHERE c.activeStatus = :activeStatus"),
    @NamedQuery(name = "CreditNoteMaster.findByCreatedAt", query = "SELECT c FROM CreditNoteMaster c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "CreditNoteMaster.findByLastUpdatedAt", query = "SELECT c FROM CreditNoteMaster c WHERE c.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "CreditNoteMaster.findByIsActive", query = "SELECT c FROM CreditNoteMaster c WHERE c.isActive = :isActive"),
    @NamedQuery(name = "CreditNoteMaster.findByIpAddress", query = "SELECT c FROM CreditNoteMaster c WHERE c.ipAddress = :ipAddress")})
public class CreditNoteMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "credit_note_master_id")
    private Integer creditNoteMasterId;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "credit_note_no")
    private String creditNoteNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "exchange_rate")
    private Double exchangeRate;
    @Column(name = "discount_amt")
    private Double discountAmt;
    @Column(name = "service_charge_amt")
    private Double serviceChargeAmt;
    @Column(name = "qty_rate_inr")
    private Double qtyRateInr;
    @Column(name = "customer_amt")
    private Double customerAmt;
    @Column(name = "revenue_amt")
    private Double revenueAmt;
    @Column(name = "cgst_payable")
    private Double cgstPayable;
    @Column(name = "sgst_payable")
    private Double sgstPayable;
    @Column(name = "igst_payable")
    private Double igstPayable;
    @Column(name = "cess_payable")
    private Double cessPayable;
    @Column(name = "vat_payable")
    private Double vatPayable;
    @Column(name = "credit_note_status")
    private String creditNoteStatus;
    @Column(name = "active_status")
    private String activeStatus;
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
    @OneToMany(mappedBy = "creditNoteMasterId")
    private List<GeneralLedger> generalLedgerList;
    @OneToMany(mappedBy = "creditNoteMasterId")
    private List<TagMapping> tagMappingList;
    @JoinColumn(name = "booking_master_id", referencedColumnName = "booking_master_id")
    @ManyToOne(optional = false)
    private BookingMaster bookingMasterId;
    @JoinColumn(name = "invoice_master_id", referencedColumnName = "invoice_master_id")
    @ManyToOne(optional = false)
    private InvoiceMaster invoiceMasterId;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @OneToMany(mappedBy = "creditNoteMasterId")
    private List<BookingTagMaster> bookingTagMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creditNoteMasterId")
    private List<CreditNoteDetail> creditNoteDetailList;
    @OneToMany(mappedBy = "creditNoteMasterId")
    private List<MaterialTransactionMaster> materialTransactionMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creditNoteMasterId")
    private List<CreditNoteApproval> creditNoteApprovalList;

    public CreditNoteMaster() {
    }

    public CreditNoteMaster(Integer creditNoteMasterId) {
        this.creditNoteMasterId = creditNoteMasterId;
    }

    public CreditNoteMaster(Integer creditNoteMasterId, Character isActive) {
        this.creditNoteMasterId = creditNoteMasterId;
        this.isActive = isActive;
    }

    public Integer getCreditNoteMasterId() {
        return creditNoteMasterId;
    }

    public void setCreditNoteMasterId(Integer creditNoteMasterId) {
        this.creditNoteMasterId = creditNoteMasterId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCreditNoteNo() {
        return creditNoteNo;
    }

    public void setCreditNoteNo(String creditNoteNo) {
        this.creditNoteNo = creditNoteNo;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
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

    public Double getQtyRateInr() {
        return qtyRateInr;
    }

    public void setQtyRateInr(Double qtyRateInr) {
        this.qtyRateInr = qtyRateInr;
    }

    public Double getCustomerAmt() {
        return customerAmt;
    }

    public void setCustomerAmt(Double customerAmt) {
        this.customerAmt = customerAmt;
    }

    public Double getRevenueAmt() {
        return revenueAmt;
    }

    public void setRevenueAmt(Double revenueAmt) {
        this.revenueAmt = revenueAmt;
    }

    public Double getCgstPayable() {
        return cgstPayable;
    }

    public void setCgstPayable(Double cgstPayable) {
        this.cgstPayable = cgstPayable;
    }

    public Double getSgstPayable() {
        return sgstPayable;
    }

    public void setSgstPayable(Double sgstPayable) {
        this.sgstPayable = sgstPayable;
    }

    public Double getIgstPayable() {
        return igstPayable;
    }

    public void setIgstPayable(Double igstPayable) {
        this.igstPayable = igstPayable;
    }

    public Double getCessPayable() {
        return cessPayable;
    }

    public void setCessPayable(Double cessPayable) {
        this.cessPayable = cessPayable;
    }

    public Double getVatPayable() {
        return vatPayable;
    }

    public void setVatPayable(Double vatPayable) {
        this.vatPayable = vatPayable;
    }

    public String getCreditNoteStatus() {
        return creditNoteStatus;
    }

    public void setCreditNoteStatus(String creditNoteStatus) {
        this.creditNoteStatus = creditNoteStatus;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
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

    @XmlTransient
    public List<GeneralLedger> getGeneralLedgerList() {
        return generalLedgerList;
    }

    public void setGeneralLedgerList(List<GeneralLedger> generalLedgerList) {
        this.generalLedgerList = generalLedgerList;
    }

    @XmlTransient
    public List<TagMapping> getTagMappingList() {
        return tagMappingList;
    }

    public void setTagMappingList(List<TagMapping> tagMappingList) {
        this.tagMappingList = tagMappingList;
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

    public UserMaster getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserMaster createdBy) {
        this.createdBy = createdBy;
    }

    public UserMaster getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(UserMaster lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @XmlTransient
    public List<BookingTagMaster> getBookingTagMasterList() {
        return bookingTagMasterList;
    }

    public void setBookingTagMasterList(List<BookingTagMaster> bookingTagMasterList) {
        this.bookingTagMasterList = bookingTagMasterList;
    }

    @XmlTransient
    public List<CreditNoteDetail> getCreditNoteDetailList() {
        return creditNoteDetailList;
    }

    public void setCreditNoteDetailList(List<CreditNoteDetail> creditNoteDetailList) {
        this.creditNoteDetailList = creditNoteDetailList;
    }

    @XmlTransient
    public List<MaterialTransactionMaster> getMaterialTransactionMasterList() {
        return materialTransactionMasterList;
    }

    public void setMaterialTransactionMasterList(List<MaterialTransactionMaster> materialTransactionMasterList) {
        this.materialTransactionMasterList = materialTransactionMasterList;
    }

    @XmlTransient
    public List<CreditNoteApproval> getCreditNoteApprovalList() {
        return creditNoteApprovalList;
    }

    public void setCreditNoteApprovalList(List<CreditNoteApproval> creditNoteApprovalList) {
        this.creditNoteApprovalList = creditNoteApprovalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (creditNoteMasterId != null ? creditNoteMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditNoteMaster)) {
            return false;
        }
        CreditNoteMaster other = (CreditNoteMaster) object;
        if ((this.creditNoteMasterId == null && other.creditNoteMasterId != null) || (this.creditNoteMasterId != null && !this.creditNoteMasterId.equals(other.creditNoteMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.CreditNoteMaster[ creditNoteMasterId=" + creditNoteMasterId + " ]";
    }
    
}
