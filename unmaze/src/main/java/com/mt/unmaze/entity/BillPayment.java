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
@Table(name = "bill_payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BillPayment.findAll", query = "SELECT b FROM BillPayment b"),
    @NamedQuery(name = "BillPayment.findByBillPaymentId", query = "SELECT b FROM BillPayment b WHERE b.billPaymentId = :billPaymentId"),
    @NamedQuery(name = "BillPayment.findByDate", query = "SELECT b FROM BillPayment b WHERE b.date = :date"),
    @NamedQuery(name = "BillPayment.findByTotalAmt", query = "SELECT b FROM BillPayment b WHERE b.totalAmt = :totalAmt"),
    @NamedQuery(name = "BillPayment.findByPayableAmt", query = "SELECT b FROM BillPayment b WHERE b.payableAmt = :payableAmt"),
    @NamedQuery(name = "BillPayment.findByReferenceNo", query = "SELECT b FROM BillPayment b WHERE b.referenceNo = :referenceNo"),
    @NamedQuery(name = "BillPayment.findByCreatedAt", query = "SELECT b FROM BillPayment b WHERE b.createdAt = :createdAt"),
    @NamedQuery(name = "BillPayment.findByLastUpdatedAt", query = "SELECT b FROM BillPayment b WHERE b.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "BillPayment.findByIsActive", query = "SELECT b FROM BillPayment b WHERE b.isActive = :isActive"),
    @NamedQuery(name = "BillPayment.findByIpAddress", query = "SELECT b FROM BillPayment b WHERE b.ipAddress = :ipAddress")})
public class BillPayment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bill_payment_id")
    private Integer billPaymentId;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_amt")
    private Double totalAmt;
    @Basic(optional = false)
    @Column(name = "payable_amt")
    private double payableAmt;
    @Column(name = "reference_no")
    private String referenceNo;
    @Lob
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "last_updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedAt;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @Column(name = "ip_address")
    private String ipAddress;
    @OneToMany(mappedBy = "billPaymentId")
    private List<GeneralLedger> generalLedgerList;
    @JoinColumn(name = "account_master_id", referencedColumnName = "account_master_id")
    @ManyToOne
    private AccountMaster accountMasterId;
    @JoinColumn(name = "bill_master_id", referencedColumnName = "bill_master_id")
    @ManyToOne
    private BillMaster billMasterId;
    @JoinColumn(name = "payment_mode_id", referencedColumnName = "payment_mode_id")
    @ManyToOne
    private PaymentMode paymentModeId;
    @JoinColumn(name = "payment_type_id", referencedColumnName = "payment_type_id")
    @ManyToOne
    private PaymentType paymentTypeId;
    @JoinColumn(name = "purchase_order_master_id", referencedColumnName = "purchase_order_master_id")
    @ManyToOne(optional = false)
    private PurchaseOrderMaster purchaseOrderMasterId;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;

    public BillPayment() {
    }

    public BillPayment(Integer billPaymentId) {
        this.billPaymentId = billPaymentId;
    }

    public BillPayment(Integer billPaymentId, double payableAmt, Date lastUpdatedAt, Character isActive) {
        this.billPaymentId = billPaymentId;
        this.payableAmt = payableAmt;
        this.lastUpdatedAt = lastUpdatedAt;
        this.isActive = isActive;
    }

    public Integer getBillPaymentId() {
        return billPaymentId;
    }

    public void setBillPaymentId(Integer billPaymentId) {
        this.billPaymentId = billPaymentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(Double totalAmt) {
        this.totalAmt = totalAmt;
    }

    public double getPayableAmt() {
        return payableAmt;
    }

    public void setPayableAmt(double payableAmt) {
        this.payableAmt = payableAmt;
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

    public BillMaster getBillMasterId() {
        return billMasterId;
    }

    public void setBillMasterId(BillMaster billMasterId) {
        this.billMasterId = billMasterId;
    }

    public PaymentMode getPaymentModeId() {
        return paymentModeId;
    }

    public void setPaymentModeId(PaymentMode paymentModeId) {
        this.paymentModeId = paymentModeId;
    }

    public PaymentType getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(PaymentType paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public PurchaseOrderMaster getPurchaseOrderMasterId() {
        return purchaseOrderMasterId;
    }

    public void setPurchaseOrderMasterId(PurchaseOrderMaster purchaseOrderMasterId) {
        this.purchaseOrderMasterId = purchaseOrderMasterId;
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
        hash += (billPaymentId != null ? billPaymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BillPayment)) {
            return false;
        }
        BillPayment other = (BillPayment) object;
        if ((this.billPaymentId == null && other.billPaymentId != null) || (this.billPaymentId != null && !this.billPaymentId.equals(other.billPaymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.BillPayment[ billPaymentId=" + billPaymentId + " ]";
    }
    
}
