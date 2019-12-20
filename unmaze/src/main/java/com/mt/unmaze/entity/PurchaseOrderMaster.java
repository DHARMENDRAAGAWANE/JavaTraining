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
@Table(name = "purchase_order_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseOrderMaster.findAll", query = "SELECT p FROM PurchaseOrderMaster p"),
    @NamedQuery(name = "PurchaseOrderMaster.findByPurchaseOrderMasterId", query = "SELECT p FROM PurchaseOrderMaster p WHERE p.purchaseOrderMasterId = :purchaseOrderMasterId"),
    @NamedQuery(name = "PurchaseOrderMaster.findByPurchaseOrderNo", query = "SELECT p FROM PurchaseOrderMaster p WHERE p.purchaseOrderNo = :purchaseOrderNo"),
    @NamedQuery(name = "PurchaseOrderMaster.findByDate", query = "SELECT p FROM PurchaseOrderMaster p WHERE p.date = :date"),
    @NamedQuery(name = "PurchaseOrderMaster.findByCurrency", query = "SELECT p FROM PurchaseOrderMaster p WHERE p.currency = :currency"),
    @NamedQuery(name = "PurchaseOrderMaster.findByExchangeRate", query = "SELECT p FROM PurchaseOrderMaster p WHERE p.exchangeRate = :exchangeRate"),
    @NamedQuery(name = "PurchaseOrderMaster.findByReverseCharge", query = "SELECT p FROM PurchaseOrderMaster p WHERE p.reverseCharge = :reverseCharge"),
    @NamedQuery(name = "PurchaseOrderMaster.findByTotalAdvance", query = "SELECT p FROM PurchaseOrderMaster p WHERE p.totalAdvance = :totalAdvance"),
    @NamedQuery(name = "PurchaseOrderMaster.findByAdvancePaid", query = "SELECT p FROM PurchaseOrderMaster p WHERE p.advancePaid = :advancePaid"),
    @NamedQuery(name = "PurchaseOrderMaster.findByAdvancePending", query = "SELECT p FROM PurchaseOrderMaster p WHERE p.advancePending = :advancePending"),
    @NamedQuery(name = "PurchaseOrderMaster.findByTotalAmt", query = "SELECT p FROM PurchaseOrderMaster p WHERE p.totalAmt = :totalAmt"),
    @NamedQuery(name = "PurchaseOrderMaster.findByBilledAmt", query = "SELECT p FROM PurchaseOrderMaster p WHERE p.billedAmt = :billedAmt"),
    @NamedQuery(name = "PurchaseOrderMaster.findByPaymentAmt", query = "SELECT p FROM PurchaseOrderMaster p WHERE p.paymentAmt = :paymentAmt"),
    @NamedQuery(name = "PurchaseOrderMaster.findByBalanceBilledAmt", query = "SELECT p FROM PurchaseOrderMaster p WHERE p.balanceBilledAmt = :balanceBilledAmt"),
    @NamedQuery(name = "PurchaseOrderMaster.findByBalanceAmt", query = "SELECT p FROM PurchaseOrderMaster p WHERE p.balanceAmt = :balanceAmt"),
    @NamedQuery(name = "PurchaseOrderMaster.findByActiveStatus", query = "SELECT p FROM PurchaseOrderMaster p WHERE p.activeStatus = :activeStatus"),
    @NamedQuery(name = "PurchaseOrderMaster.findByPurchaseOrderStatus", query = "SELECT p FROM PurchaseOrderMaster p WHERE p.purchaseOrderStatus = :purchaseOrderStatus"),
    @NamedQuery(name = "PurchaseOrderMaster.findByCreatedAt", query = "SELECT p FROM PurchaseOrderMaster p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "PurchaseOrderMaster.findByLastUpdatedAt", query = "SELECT p FROM PurchaseOrderMaster p WHERE p.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "PurchaseOrderMaster.findByIsActive", query = "SELECT p FROM PurchaseOrderMaster p WHERE p.isActive = :isActive"),
    @NamedQuery(name = "PurchaseOrderMaster.findByIpAddress", query = "SELECT p FROM PurchaseOrderMaster p WHERE p.ipAddress = :ipAddress")})
public class PurchaseOrderMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "purchase_order_master_id")
    private Integer purchaseOrderMasterId;
    @Basic(optional = false)
    @Column(name = "purchase_order_no")
    private String purchaseOrderNo;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "currency")
    private String currency;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "exchange_rate")
    private Double exchangeRate;
    @Basic(optional = false)
    @Column(name = "reverse_charge")
    private String reverseCharge;
    @Column(name = "total_advance")
    private Double totalAdvance;
    @Column(name = "advance_paid")
    private Double advancePaid;
    @Column(name = "advance_pending")
    private Double advancePending;
    @Column(name = "total_amt")
    private Double totalAmt;
    @Column(name = "billed_amt")
    private Double billedAmt;
    @Column(name = "payment_amt")
    private Double paymentAmt;
    @Column(name = "balance_billed_amt")
    private Double balanceBilledAmt;
    @Column(name = "balance_amt")
    private Double balanceAmt;
    @Column(name = "active_status")
    private String activeStatus;
    @Column(name = "purchase_order_status")
    private String purchaseOrderStatus;
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
    @JoinColumn(name = "account_master_id", referencedColumnName = "account_master_id")
    @ManyToOne
    private AccountMaster accountMasterId;
    @JoinColumn(name = "branch_master_id", referencedColumnName = "branch_master_id")
    @ManyToOne(optional = false)
    private BranchMaster branchMasterId;
    @JoinColumn(name = "country_of_supply", referencedColumnName = "country_id")
    @ManyToOne
    private Country countryOfSupply;
    @JoinColumn(name = "product_type_id", referencedColumnName = "product_type_id")
    @ManyToOne(optional = false)
    private ProductType productTypeId;
    @JoinColumn(name = "project_master_id", referencedColumnName = "project_master_id")
    @ManyToOne
    private ProjectMaster projectMasterId;
    @JoinColumn(name = "purchase_type_id", referencedColumnName = "purchase_type_id")
    @ManyToOne(optional = false)
    private PurchaseType purchaseTypeId;
    @JoinColumn(name = "state_of_supply", referencedColumnName = "state_id")
    @ManyToOne
    private State stateOfSupply;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @JoinColumn(name = "vendor_master_id", referencedColumnName = "vendor_master_id")
    @ManyToOne(optional = false)
    private VendorMaster vendorMasterId;
    @OneToMany(mappedBy = "purchaseOrderMasterId")
    private List<BillMaster> billMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderMasterId")
    private List<GoodsRecieptNote> goodsRecieptNoteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderMasterId")
    private List<PurchaseOrderDetail> purchaseOrderDetailList;
    @OneToMany(mappedBy = "purchaseOrderMasterId")
    private List<GeneralLedger> generalLedgerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderMasterId")
    private List<TdsMaster> tdsMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderMasterId")
    private List<PurchaseOrderApproval> purchaseOrderApprovalList;
    @OneToMany(mappedBy = "purchaseOrderMasterId")
    private List<TagMapping> tagMappingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderMasterId")
    private List<DebitNoteMaster> debitNoteMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderMasterId")
    private List<DebitNoteDetail> debitNoteDetailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderMasterId")
    private List<BillPayment> billPaymentList;
    @OneToMany(mappedBy = "purchaseOrderMasterId")
    private List<PayRequest> payRequestList;
    @OneToMany(mappedBy = "purchaseOrderMasterId")
    private List<PoTagMaster> poTagMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderMasterId")
    private List<BillDetail> billDetailList;

    public PurchaseOrderMaster() {
    }

    public PurchaseOrderMaster(Integer purchaseOrderMasterId) {
        this.purchaseOrderMasterId = purchaseOrderMasterId;
    }

    public PurchaseOrderMaster(Integer purchaseOrderMasterId, String purchaseOrderNo, String reverseCharge, Character isActive) {
        this.purchaseOrderMasterId = purchaseOrderMasterId;
        this.purchaseOrderNo = purchaseOrderNo;
        this.reverseCharge = reverseCharge;
        this.isActive = isActive;
    }

    public Integer getPurchaseOrderMasterId() {
        return purchaseOrderMasterId;
    }

    public void setPurchaseOrderMasterId(Integer purchaseOrderMasterId) {
        this.purchaseOrderMasterId = purchaseOrderMasterId;
    }

    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getReverseCharge() {
        return reverseCharge;
    }

    public void setReverseCharge(String reverseCharge) {
        this.reverseCharge = reverseCharge;
    }

    public Double getTotalAdvance() {
        return totalAdvance;
    }

    public void setTotalAdvance(Double totalAdvance) {
        this.totalAdvance = totalAdvance;
    }

    public Double getAdvancePaid() {
        return advancePaid;
    }

    public void setAdvancePaid(Double advancePaid) {
        this.advancePaid = advancePaid;
    }

    public Double getAdvancePending() {
        return advancePending;
    }

    public void setAdvancePending(Double advancePending) {
        this.advancePending = advancePending;
    }

    public Double getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(Double totalAmt) {
        this.totalAmt = totalAmt;
    }

    public Double getBilledAmt() {
        return billedAmt;
    }

    public void setBilledAmt(Double billedAmt) {
        this.billedAmt = billedAmt;
    }

    public Double getPaymentAmt() {
        return paymentAmt;
    }

    public void setPaymentAmt(Double paymentAmt) {
        this.paymentAmt = paymentAmt;
    }

    public Double getBalanceBilledAmt() {
        return balanceBilledAmt;
    }

    public void setBalanceBilledAmt(Double balanceBilledAmt) {
        this.balanceBilledAmt = balanceBilledAmt;
    }

    public Double getBalanceAmt() {
        return balanceAmt;
    }

    public void setBalanceAmt(Double balanceAmt) {
        this.balanceAmt = balanceAmt;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getPurchaseOrderStatus() {
        return purchaseOrderStatus;
    }

    public void setPurchaseOrderStatus(String purchaseOrderStatus) {
        this.purchaseOrderStatus = purchaseOrderStatus;
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

    public AccountMaster getAccountMasterId() {
        return accountMasterId;
    }

    public void setAccountMasterId(AccountMaster accountMasterId) {
        this.accountMasterId = accountMasterId;
    }

    public BranchMaster getBranchMasterId() {
        return branchMasterId;
    }

    public void setBranchMasterId(BranchMaster branchMasterId) {
        this.branchMasterId = branchMasterId;
    }

    public Country getCountryOfSupply() {
        return countryOfSupply;
    }

    public void setCountryOfSupply(Country countryOfSupply) {
        this.countryOfSupply = countryOfSupply;
    }

    public ProductType getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(ProductType productTypeId) {
        this.productTypeId = productTypeId;
    }

    public ProjectMaster getProjectMasterId() {
        return projectMasterId;
    }

    public void setProjectMasterId(ProjectMaster projectMasterId) {
        this.projectMasterId = projectMasterId;
    }

    public PurchaseType getPurchaseTypeId() {
        return purchaseTypeId;
    }

    public void setPurchaseTypeId(PurchaseType purchaseTypeId) {
        this.purchaseTypeId = purchaseTypeId;
    }

    public State getStateOfSupply() {
        return stateOfSupply;
    }

    public void setStateOfSupply(State stateOfSupply) {
        this.stateOfSupply = stateOfSupply;
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

    public VendorMaster getVendorMasterId() {
        return vendorMasterId;
    }

    public void setVendorMasterId(VendorMaster vendorMasterId) {
        this.vendorMasterId = vendorMasterId;
    }

    @XmlTransient
    public List<BillMaster> getBillMasterList() {
        return billMasterList;
    }

    public void setBillMasterList(List<BillMaster> billMasterList) {
        this.billMasterList = billMasterList;
    }

    @XmlTransient
    public List<GoodsRecieptNote> getGoodsRecieptNoteList() {
        return goodsRecieptNoteList;
    }

    public void setGoodsRecieptNoteList(List<GoodsRecieptNote> goodsRecieptNoteList) {
        this.goodsRecieptNoteList = goodsRecieptNoteList;
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

    @XmlTransient
    public List<TdsMaster> getTdsMasterList() {
        return tdsMasterList;
    }

    public void setTdsMasterList(List<TdsMaster> tdsMasterList) {
        this.tdsMasterList = tdsMasterList;
    }

    @XmlTransient
    public List<PurchaseOrderApproval> getPurchaseOrderApprovalList() {
        return purchaseOrderApprovalList;
    }

    public void setPurchaseOrderApprovalList(List<PurchaseOrderApproval> purchaseOrderApprovalList) {
        this.purchaseOrderApprovalList = purchaseOrderApprovalList;
    }

    @XmlTransient
    public List<TagMapping> getTagMappingList() {
        return tagMappingList;
    }

    public void setTagMappingList(List<TagMapping> tagMappingList) {
        this.tagMappingList = tagMappingList;
    }

    @XmlTransient
    public List<DebitNoteMaster> getDebitNoteMasterList() {
        return debitNoteMasterList;
    }

    public void setDebitNoteMasterList(List<DebitNoteMaster> debitNoteMasterList) {
        this.debitNoteMasterList = debitNoteMasterList;
    }

    @XmlTransient
    public List<DebitNoteDetail> getDebitNoteDetailList() {
        return debitNoteDetailList;
    }

    public void setDebitNoteDetailList(List<DebitNoteDetail> debitNoteDetailList) {
        this.debitNoteDetailList = debitNoteDetailList;
    }

    @XmlTransient
    public List<BillPayment> getBillPaymentList() {
        return billPaymentList;
    }

    public void setBillPaymentList(List<BillPayment> billPaymentList) {
        this.billPaymentList = billPaymentList;
    }

    @XmlTransient
    public List<PayRequest> getPayRequestList() {
        return payRequestList;
    }

    public void setPayRequestList(List<PayRequest> payRequestList) {
        this.payRequestList = payRequestList;
    }

    @XmlTransient
    public List<PoTagMaster> getPoTagMasterList() {
        return poTagMasterList;
    }

    public void setPoTagMasterList(List<PoTagMaster> poTagMasterList) {
        this.poTagMasterList = poTagMasterList;
    }

    @XmlTransient
    public List<BillDetail> getBillDetailList() {
        return billDetailList;
    }

    public void setBillDetailList(List<BillDetail> billDetailList) {
        this.billDetailList = billDetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchaseOrderMasterId != null ? purchaseOrderMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseOrderMaster)) {
            return false;
        }
        PurchaseOrderMaster other = (PurchaseOrderMaster) object;
        if ((this.purchaseOrderMasterId == null && other.purchaseOrderMasterId != null) || (this.purchaseOrderMasterId != null && !this.purchaseOrderMasterId.equals(other.purchaseOrderMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.PurchaseOrderMaster[ purchaseOrderMasterId=" + purchaseOrderMasterId + " ]";
    }
    
}
