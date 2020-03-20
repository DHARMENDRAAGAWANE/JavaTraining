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
@Table(name = "account_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountMaster.findAll", query = "SELECT a FROM AccountMaster a"),
    @NamedQuery(name = "AccountMaster.findByAccountMasterId", query = "SELECT a FROM AccountMaster a WHERE a.accountMasterId = :accountMasterId"),
    @NamedQuery(name = "AccountMaster.findByAccountMasterName", query = "SELECT a FROM AccountMaster a WHERE a.accountMasterName = :accountMasterName"),
    @NamedQuery(name = "AccountMaster.findByAccountType", query = "SELECT a FROM AccountMaster a WHERE a.accountType = :accountType"),
    @NamedQuery(name = "AccountMaster.findByActionType", query = "SELECT a FROM AccountMaster a WHERE a.actionType = :actionType"),
    @NamedQuery(name = "AccountMaster.findByConditionalActionType", query = "SELECT a FROM AccountMaster a WHERE a.conditionalActionType = :conditionalActionType"),
    @NamedQuery(name = "AccountMaster.findByAccountFieldType", query = "SELECT a FROM AccountMaster a WHERE a.accountFieldType = :accountFieldType"),
    @NamedQuery(name = "AccountMaster.findByCreatedAt", query = "SELECT a FROM AccountMaster a WHERE a.createdAt = :createdAt"),
    @NamedQuery(name = "AccountMaster.findByLastUpdatedAt", query = "SELECT a FROM AccountMaster a WHERE a.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "AccountMaster.findByIsActive", query = "SELECT a FROM AccountMaster a WHERE a.isActive = :isActive"),
    @NamedQuery(name = "AccountMaster.findByIpAddress", query = "SELECT a FROM AccountMaster a WHERE a.ipAddress = :ipAddress")})
public class AccountMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "account_master_id")
    private Integer accountMasterId;
    @Basic(optional = false)
    @Column(name = "account_master_name")
    private String accountMasterName;
    @Basic(optional = false)
    @Column(name = "account_type")
    private String accountType;
    @Basic(optional = false)
    @Column(name = "action_type")
    private String actionType;
    @Column(name = "conditional_action_type")
    private String conditionalActionType;
    @Lob
    @Column(name = "formula")
    private String formula;
    @Column(name = "account_field_type")
    private String accountFieldType;
    @Basic(optional = false)
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
    @OneToMany(mappedBy = "accountMasterId")
    private List<PurchaseOrderMaster> purchaseOrderMasterList;
    @OneToMany(mappedBy = "serviceAccountMaster")
    private List<PurchaseOrderDetail> purchaseOrderDetailList;
    @OneToMany(mappedBy = "accountMasterId")
    private List<GeneralLedger> generalLedgerList;
    @JoinColumn(name = "account_group_master_id", referencedColumnName = "account_group_master_id")
    @ManyToOne(optional = false)
    private AccountGroupMaster accountGroupMasterId;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @OneToMany(mappedBy = "accountMasterId")
    private List<InvoicePayment> invoicePaymentList;
    @OneToMany(mappedBy = "accountMasterId")
    private List<VendorMaster> vendorMasterList;
    @OneToMany(mappedBy = "linkedAccountMasterId")
    private List<VendorMaster> vendorMasterList1;
    @OneToMany(mappedBy = "accountMasterId")
    private List<ServiceMaster> serviceMasterList;
    @OneToMany(mappedBy = "accountMasterId")
    private List<BillPayment> billPaymentList;
    @OneToMany(mappedBy = "accountMasterId")
    private List<MaterialMaster> materialMasterList;
    @OneToMany(mappedBy = "accountMasterId")
    private List<BudgetMaster> budgetMasterList;
    @OneToMany(mappedBy = "payToAccountMasterId")
    private List<PayRequest> payRequestList;
    @OneToMany(mappedBy = "payViaAccountMasterId")
    private List<PayRequest> payRequestList1;

    public AccountMaster() {
    }

    public AccountMaster(Integer accountMasterId) {
        this.accountMasterId = accountMasterId;
    }

    public AccountMaster(Integer accountMasterId, String accountMasterName, String accountType, String actionType, Date createdAt, Character isActive) {
        this.accountMasterId = accountMasterId;
        this.accountMasterName = accountMasterName;
        this.accountType = accountType;
        this.actionType = actionType;
        this.createdAt = createdAt;
        this.isActive = isActive;
    }

    public Integer getAccountMasterId() {
        return accountMasterId;
    }

    public void setAccountMasterId(Integer accountMasterId) {
        this.accountMasterId = accountMasterId;
    }

    public String getAccountMasterName() {
        return accountMasterName;
    }

    public void setAccountMasterName(String accountMasterName) {
        this.accountMasterName = accountMasterName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getConditionalActionType() {
        return conditionalActionType;
    }

    public void setConditionalActionType(String conditionalActionType) {
        this.conditionalActionType = conditionalActionType;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getAccountFieldType() {
        return accountFieldType;
    }

    public void setAccountFieldType(String accountFieldType) {
        this.accountFieldType = accountFieldType;
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
    public List<PurchaseOrderMaster> getPurchaseOrderMasterList() {
        return purchaseOrderMasterList;
    }

    public void setPurchaseOrderMasterList(List<PurchaseOrderMaster> purchaseOrderMasterList) {
        this.purchaseOrderMasterList = purchaseOrderMasterList;
    }

    @XmlTransient
    public List<PurchaseOrderDetail> getPurchaseOrderDetailList() {
        return purchaseOrderDetailList;
    }

    public void setPurchaseOrderDetailList(List<PurchaseOrderDetail> purchaseOrderDetailList) {
        this.purchaseOrderDetailList = purchaseOrderDetailList;
    }

    @XmlTransient
    public List<GeneralLedger> getGeneralLedgerList() {
        return generalLedgerList;
    }

    public void setGeneralLedgerList(List<GeneralLedger> generalLedgerList) {
        this.generalLedgerList = generalLedgerList;
    }

    public AccountGroupMaster getAccountGroupMasterId() {
        return accountGroupMasterId;
    }

    public void setAccountGroupMasterId(AccountGroupMaster accountGroupMasterId) {
        this.accountGroupMasterId = accountGroupMasterId;
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
    public List<InvoicePayment> getInvoicePaymentList() {
        return invoicePaymentList;
    }

    public void setInvoicePaymentList(List<InvoicePayment> invoicePaymentList) {
        this.invoicePaymentList = invoicePaymentList;
    }

    @XmlTransient
    public List<VendorMaster> getVendorMasterList() {
        return vendorMasterList;
    }

    public void setVendorMasterList(List<VendorMaster> vendorMasterList) {
        this.vendorMasterList = vendorMasterList;
    }

    @XmlTransient
    public List<VendorMaster> getVendorMasterList1() {
        return vendorMasterList1;
    }

    public void setVendorMasterList1(List<VendorMaster> vendorMasterList1) {
        this.vendorMasterList1 = vendorMasterList1;
    }

    @XmlTransient
    public List<ServiceMaster> getServiceMasterList() {
        return serviceMasterList;
    }

    public void setServiceMasterList(List<ServiceMaster> serviceMasterList) {
        this.serviceMasterList = serviceMasterList;
    }

    @XmlTransient
    public List<BillPayment> getBillPaymentList() {
        return billPaymentList;
    }

    public void setBillPaymentList(List<BillPayment> billPaymentList) {
        this.billPaymentList = billPaymentList;
    }

    @XmlTransient
    public List<MaterialMaster> getMaterialMasterList() {
        return materialMasterList;
    }

    public void setMaterialMasterList(List<MaterialMaster> materialMasterList) {
        this.materialMasterList = materialMasterList;
    }

    @XmlTransient
    public List<BudgetMaster> getBudgetMasterList() {
        return budgetMasterList;
    }

    public void setBudgetMasterList(List<BudgetMaster> budgetMasterList) {
        this.budgetMasterList = budgetMasterList;
    }

    @XmlTransient
    public List<PayRequest> getPayRequestList() {
        return payRequestList;
    }

    public void setPayRequestList(List<PayRequest> payRequestList) {
        this.payRequestList = payRequestList;
    }

    @XmlTransient
    public List<PayRequest> getPayRequestList1() {
        return payRequestList1;
    }

    public void setPayRequestList1(List<PayRequest> payRequestList1) {
        this.payRequestList1 = payRequestList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountMasterId != null ? accountMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountMaster)) {
            return false;
        }
        AccountMaster other = (AccountMaster) object;
        if ((this.accountMasterId == null && other.accountMasterId != null) || (this.accountMasterId != null && !this.accountMasterId.equals(other.accountMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.AccountMaster[ accountMasterId=" + accountMasterId + " ]";
    }
    
}
