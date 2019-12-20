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
@Table(name = "invoice_payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvoicePayment.findAll", query = "SELECT i FROM InvoicePayment i"),
    @NamedQuery(name = "InvoicePayment.findByInvoicePaymentId", query = "SELECT i FROM InvoicePayment i WHERE i.invoicePaymentId = :invoicePaymentId"),
    @NamedQuery(name = "InvoicePayment.findByDate", query = "SELECT i FROM InvoicePayment i WHERE i.date = :date"),
    @NamedQuery(name = "InvoicePayment.findByRemittedAmt", query = "SELECT i FROM InvoicePayment i WHERE i.remittedAmt = :remittedAmt"),
    @NamedQuery(name = "InvoicePayment.findByTdsAmt", query = "SELECT i FROM InvoicePayment i WHERE i.tdsAmt = :tdsAmt"),
    @NamedQuery(name = "InvoicePayment.findByCharges", query = "SELECT i FROM InvoicePayment i WHERE i.charges = :charges"),
    @NamedQuery(name = "InvoicePayment.findByTotalAmt", query = "SELECT i FROM InvoicePayment i WHERE i.totalAmt = :totalAmt"),
    @NamedQuery(name = "InvoicePayment.findByReferenceNo", query = "SELECT i FROM InvoicePayment i WHERE i.referenceNo = :referenceNo"),
    @NamedQuery(name = "InvoicePayment.findByCreatedAt", query = "SELECT i FROM InvoicePayment i WHERE i.createdAt = :createdAt"),
    @NamedQuery(name = "InvoicePayment.findByLastUpdatedAt", query = "SELECT i FROM InvoicePayment i WHERE i.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "InvoicePayment.findByIsActive", query = "SELECT i FROM InvoicePayment i WHERE i.isActive = :isActive"),
    @NamedQuery(name = "InvoicePayment.findByIpAddress", query = "SELECT i FROM InvoicePayment i WHERE i.ipAddress = :ipAddress")})
public class InvoicePayment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "invoice_payment_id")
    private Integer invoicePaymentId;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "remitted_amt")
    private Double remittedAmt;
    @Column(name = "tds_amt")
    private Double tdsAmt;
    @Column(name = "charges")
    private Double charges;
    @Column(name = "total_amt")
    private Double totalAmt;
    @Column(name = "reference_no")
    private String referenceNo;
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
    @OneToMany(mappedBy = "invoicePaymentId")
    private List<GeneralLedger> generalLedgerList;
    @JoinColumn(name = "account_master_id", referencedColumnName = "account_master_id")
    @ManyToOne
    private AccountMaster accountMasterId;
    @JoinColumn(name = "booking_master_id", referencedColumnName = "booking_master_id")
    @ManyToOne
    private BookingMaster bookingMasterId;
    @JoinColumn(name = "invoice_master_id", referencedColumnName = "invoice_master_id")
    @ManyToOne
    private InvoiceMaster invoiceMasterId;
    @JoinColumn(name = "payment_mode_id", referencedColumnName = "payment_mode_id")
    @ManyToOne
    private PaymentMode paymentModeId;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;

    public InvoicePayment() {
    }

    public InvoicePayment(Integer invoicePaymentId) {
        this.invoicePaymentId = invoicePaymentId;
    }

    public InvoicePayment(Integer invoicePaymentId, Character isActive) {
        this.invoicePaymentId = invoicePaymentId;
        this.isActive = isActive;
    }

    public Integer getInvoicePaymentId() {
        return invoicePaymentId;
    }

    public void setInvoicePaymentId(Integer invoicePaymentId) {
        this.invoicePaymentId = invoicePaymentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getRemittedAmt() {
        return remittedAmt;
    }

    public void setRemittedAmt(Double remittedAmt) {
        this.remittedAmt = remittedAmt;
    }

    public Double getTdsAmt() {
        return tdsAmt;
    }

    public void setTdsAmt(Double tdsAmt) {
        this.tdsAmt = tdsAmt;
    }

    public Double getCharges() {
        return charges;
    }

    public void setCharges(Double charges) {
        this.charges = charges;
    }

    public Double getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(Double totalAmt) {
        this.totalAmt = totalAmt;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
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

    public AccountMaster getAccountMasterId() {
        return accountMasterId;
    }

    public void setAccountMasterId(AccountMaster accountMasterId) {
        this.accountMasterId = accountMasterId;
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

    public PaymentMode getPaymentModeId() {
        return paymentModeId;
    }

    public void setPaymentModeId(PaymentMode paymentModeId) {
        this.paymentModeId = paymentModeId;
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
        hash += (invoicePaymentId != null ? invoicePaymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoicePayment)) {
            return false;
        }
        InvoicePayment other = (InvoicePayment) object;
        if ((this.invoicePaymentId == null && other.invoicePaymentId != null) || (this.invoicePaymentId != null && !this.invoicePaymentId.equals(other.invoicePaymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.InvoicePayment[ invoicePaymentId=" + invoicePaymentId + " ]";
    }
    
}
