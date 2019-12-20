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
@Table(name = "vendor_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VendorMaster.findAll", query = "SELECT v FROM VendorMaster v"),
    @NamedQuery(name = "VendorMaster.findByVendorMasterId", query = "SELECT v FROM VendorMaster v WHERE v.vendorMasterId = :vendorMasterId"),
    @NamedQuery(name = "VendorMaster.findByVendorName", query = "SELECT v FROM VendorMaster v WHERE v.vendorName = :vendorName"),
    @NamedQuery(name = "VendorMaster.findByPrimaryContactName", query = "SELECT v FROM VendorMaster v WHERE v.primaryContactName = :primaryContactName"),
    @NamedQuery(name = "VendorMaster.findByPrimaryContactNo", query = "SELECT v FROM VendorMaster v WHERE v.primaryContactNo = :primaryContactNo"),
    @NamedQuery(name = "VendorMaster.findByAlternateContactName", query = "SELECT v FROM VendorMaster v WHERE v.alternateContactName = :alternateContactName"),
    @NamedQuery(name = "VendorMaster.findByAlternateContactNo", query = "SELECT v FROM VendorMaster v WHERE v.alternateContactNo = :alternateContactNo"),
    @NamedQuery(name = "VendorMaster.findByVatNo", query = "SELECT v FROM VendorMaster v WHERE v.vatNo = :vatNo"),
    @NamedQuery(name = "VendorMaster.findByAddress", query = "SELECT v FROM VendorMaster v WHERE v.address = :address"),
    @NamedQuery(name = "VendorMaster.findByPincode", query = "SELECT v FROM VendorMaster v WHERE v.pincode = :pincode"),
    @NamedQuery(name = "VendorMaster.findByBankAccountNumber", query = "SELECT v FROM VendorMaster v WHERE v.bankAccountNumber = :bankAccountNumber"),
    @NamedQuery(name = "VendorMaster.findByBankIfsc", query = "SELECT v FROM VendorMaster v WHERE v.bankIfsc = :bankIfsc"),
    @NamedQuery(name = "VendorMaster.findByVendorStatus", query = "SELECT v FROM VendorMaster v WHERE v.vendorStatus = :vendorStatus"),
    @NamedQuery(name = "VendorMaster.findByCreatedAt", query = "SELECT v FROM VendorMaster v WHERE v.createdAt = :createdAt"),
    @NamedQuery(name = "VendorMaster.findByLastUpdatedAt", query = "SELECT v FROM VendorMaster v WHERE v.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "VendorMaster.findByIsActive", query = "SELECT v FROM VendorMaster v WHERE v.isActive = :isActive"),
    @NamedQuery(name = "VendorMaster.findByIpAddress", query = "SELECT v FROM VendorMaster v WHERE v.ipAddress = :ipAddress")})
public class VendorMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vendor_master_id")
    private Integer vendorMasterId;
    @Basic(optional = false)
    @Column(name = "vendor_name")
    private String vendorName;
    @Column(name = "primary_contact_name")
    private String primaryContactName;
    @Column(name = "primary_contact_no")
    private BigInteger primaryContactNo;
    @Column(name = "alternate_contact_name")
    private String alternateContactName;
    @Column(name = "alternate_contact_no")
    private BigInteger alternateContactNo;
    @Column(name = "vat_no")
    private String vatNo;
    @Column(name = "address")
    private String address;
    @Column(name = "pincode")
    private Integer pincode;
    @Column(name = "bank_account_number")
    private String bankAccountNumber;
    @Column(name = "bank_ifsc")
    private String bankIfsc;
    @Column(name = "vendor_status")
    private String vendorStatus;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendorMasterId")
    private List<PurchaseOrderMaster> purchaseOrderMasterList;
    @JoinColumn(name = "pan_card_id", referencedColumnName = "file_asset_id")
    @ManyToOne
    private FileAsset panCardId;
    @JoinColumn(name = "account_master_id", referencedColumnName = "account_master_id")
    @ManyToOne
    private AccountMaster accountMasterId;
    @JoinColumn(name = "linked_account_master_id", referencedColumnName = "account_master_id")
    @ManyToOne
    private AccountMaster linkedAccountMasterId;
    @JoinColumn(name = "bank_id", referencedColumnName = "bank_id")
    @ManyToOne
    private Bank bankId;
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    @ManyToOne
    private Country countryId;
    @JoinColumn(name = "cancelled_cheque_id", referencedColumnName = "file_asset_id")
    @ManyToOne
    private FileAsset cancelledChequeId;
    @JoinColumn(name = "gst_registration_certificate_id", referencedColumnName = "file_asset_id")
    @ManyToOne
    private FileAsset gstRegistrationCertificateId;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "gst_master_id", referencedColumnName = "gst_master_id")
    @ManyToOne
    private GstMaster gstMasterId;
    @JoinColumn(name = "vendor_user_master_id", referencedColumnName = "vendor_user_master_id")
    @ManyToOne
    private VendorUserMaster vendorUserMasterId;
    @JoinColumn(name = "pan_master_id", referencedColumnName = "pan_master_id")
    @ManyToOne
    private PanMaster panMasterId;
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    @ManyToOne
    private State stateId;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;

    public VendorMaster() {
    }

    public VendorMaster(Integer vendorMasterId) {
        this.vendorMasterId = vendorMasterId;
    }

    public VendorMaster(Integer vendorMasterId, String vendorName, Date lastUpdatedAt, Character isActive) {
        this.vendorMasterId = vendorMasterId;
        this.vendorName = vendorName;
        this.lastUpdatedAt = lastUpdatedAt;
        this.isActive = isActive;
    }

    public Integer getVendorMasterId() {
        return vendorMasterId;
    }

    public void setVendorMasterId(Integer vendorMasterId) {
        this.vendorMasterId = vendorMasterId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
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

    public String getVatNo() {
        return vatNo;
    }

    public void setVatNo(String vatNo) {
        this.vatNo = vatNo;
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

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankIfsc() {
        return bankIfsc;
    }

    public void setBankIfsc(String bankIfsc) {
        this.bankIfsc = bankIfsc;
    }

    public String getVendorStatus() {
        return vendorStatus;
    }

    public void setVendorStatus(String vendorStatus) {
        this.vendorStatus = vendorStatus;
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

    public FileAsset getPanCardId() {
        return panCardId;
    }

    public void setPanCardId(FileAsset panCardId) {
        this.panCardId = panCardId;
    }

    public AccountMaster getAccountMasterId() {
        return accountMasterId;
    }

    public void setAccountMasterId(AccountMaster accountMasterId) {
        this.accountMasterId = accountMasterId;
    }

    public AccountMaster getLinkedAccountMasterId() {
        return linkedAccountMasterId;
    }

    public void setLinkedAccountMasterId(AccountMaster linkedAccountMasterId) {
        this.linkedAccountMasterId = linkedAccountMasterId;
    }

    public Bank getBankId() {
        return bankId;
    }

    public void setBankId(Bank bankId) {
        this.bankId = bankId;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    public FileAsset getCancelledChequeId() {
        return cancelledChequeId;
    }

    public void setCancelledChequeId(FileAsset cancelledChequeId) {
        this.cancelledChequeId = cancelledChequeId;
    }

    public FileAsset getGstRegistrationCertificateId() {
        return gstRegistrationCertificateId;
    }

    public void setGstRegistrationCertificateId(FileAsset gstRegistrationCertificateId) {
        this.gstRegistrationCertificateId = gstRegistrationCertificateId;
    }

    public UserMaster getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(UserMaster lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public GstMaster getGstMasterId() {
        return gstMasterId;
    }

    public void setGstMasterId(GstMaster gstMasterId) {
        this.gstMasterId = gstMasterId;
    }

    public VendorUserMaster getVendorUserMasterId() {
        return vendorUserMasterId;
    }

    public void setVendorUserMasterId(VendorUserMaster vendorUserMasterId) {
        this.vendorUserMasterId = vendorUserMasterId;
    }

    public PanMaster getPanMasterId() {
        return panMasterId;
    }

    public void setPanMasterId(PanMaster panMasterId) {
        this.panMasterId = panMasterId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendorMasterId != null ? vendorMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VendorMaster)) {
            return false;
        }
        VendorMaster other = (VendorMaster) object;
        if ((this.vendorMasterId == null && other.vendorMasterId != null) || (this.vendorMasterId != null && !this.vendorMasterId.equals(other.vendorMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.VendorMaster[ vendorMasterId=" + vendorMasterId + " ]";
    }
    
}
