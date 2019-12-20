/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mt.unmaze.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "branch_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BranchMaster.findAll", query = "SELECT b FROM BranchMaster b"),
    @NamedQuery(name = "BranchMaster.findByBranchMasterId", query = "SELECT b FROM BranchMaster b WHERE b.branchMasterId = :branchMasterId"),
    @NamedQuery(name = "BranchMaster.findByBranchMasterName", query = "SELECT b FROM BranchMaster b WHERE b.branchMasterName = :branchMasterName"),
    @NamedQuery(name = "BranchMaster.findByPrimaryContactName", query = "SELECT b FROM BranchMaster b WHERE b.primaryContactName = :primaryContactName"),
    @NamedQuery(name = "BranchMaster.findByPrimaryContactNo", query = "SELECT b FROM BranchMaster b WHERE b.primaryContactNo = :primaryContactNo"),
    @NamedQuery(name = "BranchMaster.findByAlternateContactName", query = "SELECT b FROM BranchMaster b WHERE b.alternateContactName = :alternateContactName"),
    @NamedQuery(name = "BranchMaster.findByAlternateContactNo", query = "SELECT b FROM BranchMaster b WHERE b.alternateContactNo = :alternateContactNo"),
    @NamedQuery(name = "BranchMaster.findByAddress", query = "SELECT b FROM BranchMaster b WHERE b.address = :address"),
    @NamedQuery(name = "BranchMaster.findByPincode", query = "SELECT b FROM BranchMaster b WHERE b.pincode = :pincode"),
    @NamedQuery(name = "BranchMaster.findByCreatedAt", query = "SELECT b FROM BranchMaster b WHERE b.createdAt = :createdAt"),
    @NamedQuery(name = "BranchMaster.findByLastUpdatedAt", query = "SELECT b FROM BranchMaster b WHERE b.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "BranchMaster.findByIsActive", query = "SELECT b FROM BranchMaster b WHERE b.isActive = :isActive"),
    @NamedQuery(name = "BranchMaster.findByIpAddress", query = "SELECT b FROM BranchMaster b WHERE b.ipAddress = :ipAddress")})
public class BranchMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "branch_master_id")
    private Integer branchMasterId;
    @Basic(optional = false)
    @Column(name = "branch_master_name")
    private String branchMasterName;
    @Column(name = "primary_contact_name")
    private String primaryContactName;
    @Column(name = "primary_contact_no")
    private BigInteger primaryContactNo;
    @Column(name = "alternate_contact_name")
    private String alternateContactName;
    @Column(name = "alternate_contact_no")
    private BigInteger alternateContactNo;
    @Column(name = "address")
    private String address;
    @Column(name = "pincode")
    private Integer pincode;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branchMasterId")
    private List<PurchaseOrderMaster> purchaseOrderMasterList;
    @OneToMany(mappedBy = "branchMasterId")
    private List<PricingMaster> pricingMasterList;
    @OneToMany(mappedBy = "branchMasterId")
    private List<GeneralLedger> generalLedgerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branchMasterId")
    private List<ProductionMaster> productionMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branchMasterId")
    private List<UserBranchMapping> userBranchMappingList;
    @OneToMany(mappedBy = "branchMasterId")
    private List<BookingMaster> bookingMasterList;
    @OneToMany(mappedBy = "branchMasterId")
    private List<UserMaster> userMasterList;
    @OneToMany(mappedBy = "branchMasterId")
    private List<AssetMaster> assetMasterList;
    @OneToMany(mappedBy = "branchMasterId")
    private List<CustomerMaster> customerMasterList;
    @OneToMany(mappedBy = "branchMasterId")
    private List<ProjectMaster> projectMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branchMasterId")
    private List<MaterialTransactionMaster> materialTransactionMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branchMasterId")
    private List<BudgetMaster> budgetMasterList;
    @OneToMany(mappedBy = "branchMasterId")
    private List<PayRequest> payRequestList;
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    @ManyToOne
    private Country countryId;
    @JoinColumn(name = "gst_master_id", referencedColumnName = "gst_master_id")
    @ManyToOne
    private GstMaster gstMasterId;
    @JoinColumn(name = "legal_entity_master_id", referencedColumnName = "legal_entity_master_id")
    @ManyToOne(optional = false)
    private LegalEntityMaster legalEntityMasterId;
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    @ManyToOne
    private State stateId;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;

    public BranchMaster() {
    }

    public BranchMaster(Integer branchMasterId) {
        this.branchMasterId = branchMasterId;
    }

    public BranchMaster(Integer branchMasterId, String branchMasterName, Character isActive) {
        this.branchMasterId = branchMasterId;
        this.branchMasterName = branchMasterName;
        this.isActive = isActive;
    }

    public Integer getBranchMasterId() {
        return branchMasterId;
    }

    public void setBranchMasterId(Integer branchMasterId) {
        this.branchMasterId = branchMasterId;
    }

    public String getBranchMasterName() {
        return branchMasterName;
    }

    public void setBranchMasterName(String branchMasterName) {
        this.branchMasterName = branchMasterName;
    }

    public String getPrimaryContactName() {
        return primaryContactName;
    }

    public void setPrimaryContactName(String primaryContactName) {
        this.primaryContactName = primaryContactName;
    }

    public BigInteger getPrimaryContactNo() {
        return primaryContactNo;
    }

    public void setPrimaryContactNo(BigInteger primaryContactNo) {
        this.primaryContactNo = primaryContactNo;
    }

    public String getAlternateContactName() {
        return alternateContactName;
    }

    public void setAlternateContactName(String alternateContactName) {
        this.alternateContactName = alternateContactName;
    }

    public BigInteger getAlternateContactNo() {
        return alternateContactNo;
    }

    public void setAlternateContactNo(BigInteger alternateContactNo) {
        this.alternateContactNo = alternateContactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
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
    public List<PurchaseOrderMaster> getPurchaseOrderMasterList() {
        return purchaseOrderMasterList;
    }

    public void setPurchaseOrderMasterList(List<PurchaseOrderMaster> purchaseOrderMasterList) {
        this.purchaseOrderMasterList = purchaseOrderMasterList;
    }

    @XmlTransient
    public List<PricingMaster> getPricingMasterList() {
        return pricingMasterList;
    }

    public void setPricingMasterList(List<PricingMaster> pricingMasterList) {
        this.pricingMasterList = pricingMasterList;
    }

    @XmlTransient
    public List<GeneralLedger> getGeneralLedgerList() {
        return generalLedgerList;
    }

    public void setGeneralLedgerList(List<GeneralLedger> generalLedgerList) {
        this.generalLedgerList = generalLedgerList;
    }

    @XmlTransient
    public List<ProductionMaster> getProductionMasterList() {
        return productionMasterList;
    }

    public void setProductionMasterList(List<ProductionMaster> productionMasterList) {
        this.productionMasterList = productionMasterList;
    }

    @XmlTransient
    public List<UserBranchMapping> getUserBranchMappingList() {
        return userBranchMappingList;
    }

    public void setUserBranchMappingList(List<UserBranchMapping> userBranchMappingList) {
        this.userBranchMappingList = userBranchMappingList;
    }

    @XmlTransient
    public List<BookingMaster> getBookingMasterList() {
        return bookingMasterList;
    }

    public void setBookingMasterList(List<BookingMaster> bookingMasterList) {
        this.bookingMasterList = bookingMasterList;
    }

    @XmlTransient
    public List<UserMaster> getUserMasterList() {
        return userMasterList;
    }

    public void setUserMasterList(List<UserMaster> userMasterList) {
        this.userMasterList = userMasterList;
    }

    @XmlTransient
    public List<AssetMaster> getAssetMasterList() {
        return assetMasterList;
    }

    public void setAssetMasterList(List<AssetMaster> assetMasterList) {
        this.assetMasterList = assetMasterList;
    }

    @XmlTransient
    public List<CustomerMaster> getCustomerMasterList() {
        return customerMasterList;
    }

    public void setCustomerMasterList(List<CustomerMaster> customerMasterList) {
        this.customerMasterList = customerMasterList;
    }

    @XmlTransient
    public List<ProjectMaster> getProjectMasterList() {
        return projectMasterList;
    }

    public void setProjectMasterList(List<ProjectMaster> projectMasterList) {
        this.projectMasterList = projectMasterList;
    }

    @XmlTransient
    public List<MaterialTransactionMaster> getMaterialTransactionMasterList() {
        return materialTransactionMasterList;
    }

    public void setMaterialTransactionMasterList(List<MaterialTransactionMaster> materialTransactionMasterList) {
        this.materialTransactionMasterList = materialTransactionMasterList;
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

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    public GstMaster getGstMasterId() {
        return gstMasterId;
    }

    public void setGstMasterId(GstMaster gstMasterId) {
        this.gstMasterId = gstMasterId;
    }

    public LegalEntityMaster getLegalEntityMasterId() {
        return legalEntityMasterId;
    }

    public void setLegalEntityMasterId(LegalEntityMaster legalEntityMasterId) {
        this.legalEntityMasterId = legalEntityMasterId;
    }

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (branchMasterId != null ? branchMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BranchMaster)) {
            return false;
        }
        BranchMaster other = (BranchMaster) object;
        if ((this.branchMasterId == null && other.branchMasterId != null) || (this.branchMasterId != null && !this.branchMasterId.equals(other.branchMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.BranchMaster[ branchMasterId=" + branchMasterId + " ]";
    }
    
}
