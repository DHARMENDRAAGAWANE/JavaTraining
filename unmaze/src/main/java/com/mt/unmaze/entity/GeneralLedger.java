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
@Table(name = "general_ledger")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GeneralLedger.findAll", query = "SELECT g FROM GeneralLedger g"),
    @NamedQuery(name = "GeneralLedger.findByGeneralLedgerId", query = "SELECT g FROM GeneralLedger g WHERE g.generalLedgerId = :generalLedgerId"),
    @NamedQuery(name = "GeneralLedger.findByDate", query = "SELECT g FROM GeneralLedger g WHERE g.date = :date"),
    @NamedQuery(name = "GeneralLedger.findByGlBatch", query = "SELECT g FROM GeneralLedger g WHERE g.glBatch = :glBatch"),
    @NamedQuery(name = "GeneralLedger.findByDebitAmt", query = "SELECT g FROM GeneralLedger g WHERE g.debitAmt = :debitAmt"),
    @NamedQuery(name = "GeneralLedger.findByCreditAmt", query = "SELECT g FROM GeneralLedger g WHERE g.creditAmt = :creditAmt"),
    @NamedQuery(name = "GeneralLedger.findByCreatedAt", query = "SELECT g FROM GeneralLedger g WHERE g.createdAt = :createdAt"),
    @NamedQuery(name = "GeneralLedger.findByLastUpdatedAt", query = "SELECT g FROM GeneralLedger g WHERE g.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "GeneralLedger.findByIsActive", query = "SELECT g FROM GeneralLedger g WHERE g.isActive = :isActive"),
    @NamedQuery(name = "GeneralLedger.findByIpAddress", query = "SELECT g FROM GeneralLedger g WHERE g.ipAddress = :ipAddress")})
public class GeneralLedger implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "general_ledger_id")
    private Integer generalLedgerId;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @Column(name = "gl_batch")
    private String glBatch;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "debit_amt")
    private Double debitAmt;
    @Column(name = "credit_amt")
    private Double creditAmt;
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
    @JoinColumn(name = "bill_payment_id", referencedColumnName = "bill_payment_id")
    @ManyToOne
    private BillPayment billPaymentId;
    @JoinColumn(name = "account_master_id", referencedColumnName = "account_master_id")
    @ManyToOne
    private AccountMaster accountMasterId;
    @JoinColumn(name = "bill_master_id", referencedColumnName = "bill_master_id")
    @ManyToOne
    private BillMaster billMasterId;
    @JoinColumn(name = "branch_master_id", referencedColumnName = "branch_master_id")
    @ManyToOne
    private BranchMaster branchMasterId;
    @JoinColumn(name = "credit_note_master_id", referencedColumnName = "credit_note_master_id")
    @ManyToOne
    private CreditNoteMaster creditNoteMasterId;
    @JoinColumn(name = "debit_note_master_id", referencedColumnName = "debit_note_master_id")
    @ManyToOne
    private DebitNoteMaster debitNoteMasterId;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @JoinColumn(name = "invoice_master_id", referencedColumnName = "invoice_master_id")
    @ManyToOne
    private InvoiceMaster invoiceMasterId;
    @JoinColumn(name = "invoice_payment_id", referencedColumnName = "invoice_payment_id")
    @ManyToOne
    private InvoicePayment invoicePaymentId;
    @JoinColumn(name = "project_master_id", referencedColumnName = "project_master_id")
    @ManyToOne
    private ProjectMaster projectMasterId;
    @JoinColumn(name = "purchase_order_master_id", referencedColumnName = "purchase_order_master_id")
    @ManyToOne
    private PurchaseOrderMaster purchaseOrderMasterId;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "tds_master_id", referencedColumnName = "tds_master_id")
    @ManyToOne
    private TdsMaster tdsMasterId;

    public GeneralLedger() {
    }

    public GeneralLedger(Integer generalLedgerId) {
        this.generalLedgerId = generalLedgerId;
    }

    public GeneralLedger(Integer generalLedgerId, String glBatch, Date lastUpdatedAt, Character isActive) {
        this.generalLedgerId = generalLedgerId;
        this.glBatch = glBatch;
        this.lastUpdatedAt = lastUpdatedAt;
        this.isActive = isActive;
    }

    public Integer getGeneralLedgerId() {
        return generalLedgerId;
    }

    public void setGeneralLedgerId(Integer generalLedgerId) {
        this.generalLedgerId = generalLedgerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGlBatch() {
        return glBatch;
    }

    public void setGlBatch(String glBatch) {
        this.glBatch = glBatch;
    }

    public Double getDebitAmt() {
        return debitAmt;
    }

    public void setDebitAmt(Double debitAmt) {
        this.debitAmt = debitAmt;
    }

    public Double getCreditAmt() {
        return creditAmt;
    }

    public void setCreditAmt(Double creditAmt) {
        this.creditAmt = creditAmt;
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

    public BillPayment getBillPaymentId() {
        return billPaymentId;
    }

    public void setBillPaymentId(BillPayment billPaymentId) {
        this.billPaymentId = billPaymentId;
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

    public BranchMaster getBranchMasterId() {
        return branchMasterId;
    }

    public void setBranchMasterId(BranchMaster branchMasterId) {
        this.branchMasterId = branchMasterId;
    }

    public CreditNoteMaster getCreditNoteMasterId() {
        return creditNoteMasterId;
    }

    public void setCreditNoteMasterId(CreditNoteMaster creditNoteMasterId) {
        this.creditNoteMasterId = creditNoteMasterId;
    }

    public DebitNoteMaster getDebitNoteMasterId() {
        return debitNoteMasterId;
    }

    public void setDebitNoteMasterId(DebitNoteMaster debitNoteMasterId) {
        this.debitNoteMasterId = debitNoteMasterId;
    }

    public UserMaster getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserMaster createdBy) {
        this.createdBy = createdBy;
    }

    public InvoiceMaster getInvoiceMasterId() {
        return invoiceMasterId;
    }

    public void setInvoiceMasterId(InvoiceMaster invoiceMasterId) {
        this.invoiceMasterId = invoiceMasterId;
    }

    public InvoicePayment getInvoicePaymentId() {
        return invoicePaymentId;
    }

    public void setInvoicePaymentId(InvoicePayment invoicePaymentId) {
        this.invoicePaymentId = invoicePaymentId;
    }

    public ProjectMaster getProjectMasterId() {
        return projectMasterId;
    }

    public void setProjectMasterId(ProjectMaster projectMasterId) {
        this.projectMasterId = projectMasterId;
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

    public TdsMaster getTdsMasterId() {
        return tdsMasterId;
    }

    public void setTdsMasterId(TdsMaster tdsMasterId) {
        this.tdsMasterId = tdsMasterId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (generalLedgerId != null ? generalLedgerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeneralLedger)) {
            return false;
        }
        GeneralLedger other = (GeneralLedger) object;
        if ((this.generalLedgerId == null && other.generalLedgerId != null) || (this.generalLedgerId != null && !this.generalLedgerId.equals(other.generalLedgerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.GeneralLedger[ generalLedgerId=" + generalLedgerId + " ]";
    }
    
}
