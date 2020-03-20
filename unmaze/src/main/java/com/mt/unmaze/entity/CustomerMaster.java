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
@Table(name = "customer_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerMaster.findAll", query = "SELECT c FROM CustomerMaster c"),
    @NamedQuery(name = "CustomerMaster.findByCustomerMasterId", query = "SELECT c FROM CustomerMaster c WHERE c.customerMasterId = :customerMasterId"),
    @NamedQuery(name = "CustomerMaster.findByCustomerMasterName", query = "SELECT c FROM CustomerMaster c WHERE c.customerMasterName = :customerMasterName"),
    @NamedQuery(name = "CustomerMaster.findByPrimaryContactName", query = "SELECT c FROM CustomerMaster c WHERE c.primaryContactName = :primaryContactName"),
    @NamedQuery(name = "CustomerMaster.findByPrimaryContactNo", query = "SELECT c FROM CustomerMaster c WHERE c.primaryContactNo = :primaryContactNo"),
    @NamedQuery(name = "CustomerMaster.findByAlternateContactName", query = "SELECT c FROM CustomerMaster c WHERE c.alternateContactName = :alternateContactName"),
    @NamedQuery(name = "CustomerMaster.findByAlternateContactNo", query = "SELECT c FROM CustomerMaster c WHERE c.alternateContactNo = :alternateContactNo"),
    @NamedQuery(name = "CustomerMaster.findByAddress", query = "SELECT c FROM CustomerMaster c WHERE c.address = :address"),
    @NamedQuery(name = "CustomerMaster.findByPincode", query = "SELECT c FROM CustomerMaster c WHERE c.pincode = :pincode"),
    @NamedQuery(name = "CustomerMaster.findByNextCallDate", query = "SELECT c FROM CustomerMaster c WHERE c.nextCallDate = :nextCallDate"),
    @NamedQuery(name = "CustomerMaster.findByCreatedAt", query = "SELECT c FROM CustomerMaster c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "CustomerMaster.findByLastUpdatedAt", query = "SELECT c FROM CustomerMaster c WHERE c.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "CustomerMaster.findByIsActive", query = "SELECT c FROM CustomerMaster c WHERE c.isActive = :isActive"),
    @NamedQuery(name = "CustomerMaster.findByIpAddress", query = "SELECT c FROM CustomerMaster c WHERE c.ipAddress = :ipAddress")})
public class CustomerMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_master_id")
    private Integer customerMasterId;
    @Basic(optional = false)
    @Column(name = "customer_master_name")
    private String customerMasterName;
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
    @Column(name = "next_call_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nextCallDate;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerMasterId")
    private List<TaskMaster> taskMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerMasterId")
    private List<TaskDetailMaster> taskDetailMasterList;
    @OneToMany(mappedBy = "customerMasterId")
    private List<BookingMaster> bookingMasterList;
    @JoinColumn(name = "gst_registration_certificate_id", referencedColumnName = "file_asset_id")
    @ManyToOne
    private FileAsset gstRegistrationCertificateId;
    @JoinColumn(name = "branch_master_id", referencedColumnName = "branch_master_id")
    @ManyToOne
    private BranchMaster branchMasterId;
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    @ManyToOne
    private Country countryId;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "pan_card_id", referencedColumnName = "file_asset_id")
    @ManyToOne
    private FileAsset panCardId;
    @JoinColumn(name = "cancelled_cheque_id", referencedColumnName = "file_asset_id")
    @ManyToOne
    private FileAsset cancelledChequeId;
    @JoinColumn(name = "gst_master_id", referencedColumnName = "gst_master_id")
    @ManyToOne
    private GstMaster gstMasterId;
    @JoinColumn(name = "pan_master_id", referencedColumnName = "pan_master_id")
    @ManyToOne
    private PanMaster panMasterId;
    @JoinColumn(name = "source_master_id", referencedColumnName = "source_master_id")
    @ManyToOne
    private SourceMaster sourceMasterId;
    @JoinColumn(name = "staff_master_id", referencedColumnName = "staff_master_id")
    @ManyToOne
    private StaffMaster staffMasterId;
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    @ManyToOne
    private State stateId;
    @JoinColumn(name = "user_master_id", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster userMasterId;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @OneToMany(mappedBy = "customerMasterId")
    private List<ProjectMaster> projectMasterList;

    public CustomerMaster() {
    }

    public CustomerMaster(Integer customerMasterId) {
        this.customerMasterId = customerMasterId;
    }

    public CustomerMaster(Integer customerMasterId, String customerMasterName, Character isActive) {
        this.customerMasterId = customerMasterId;
        this.customerMasterName = customerMasterName;
        this.isActive = isActive;
    }

    public Integer getCustomerMasterId() {
        return customerMasterId;
    }

    public void setCustomerMasterId(Integer customerMasterId) {
        this.customerMasterId = customerMasterId;
    }

    public String getCustomerMasterName() {
        return customerMasterName;
    }

    public void setCustomerMasterName(String customerMasterName) {
        this.customerMasterName = customerMasterName;
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

    public Date getNextCallDate() {
        return nextCallDate;
    }

    public void setNextCallDate(Date nextCallDate) {
        this.nextCallDate = nextCallDate;
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
    public List<TaskMaster> getTaskMasterList() {
        return taskMasterList;
    }

    public void setTaskMasterList(List<TaskMaster> taskMasterList) {
        this.taskMasterList = taskMasterList;
    }

    @XmlTransient
    public List<TaskDetailMaster> getTaskDetailMasterList() {
        return taskDetailMasterList;
    }

    public void setTaskDetailMasterList(List<TaskDetailMaster> taskDetailMasterList) {
        this.taskDetailMasterList = taskDetailMasterList;
    }

    @XmlTransient
    public List<BookingMaster> getBookingMasterList() {
        return bookingMasterList;
    }

    public void setBookingMasterList(List<BookingMaster> bookingMasterList) {
        this.bookingMasterList = bookingMasterList;
    }

    public FileAsset getGstRegistrationCertificateId() {
        return gstRegistrationCertificateId;
    }

    public void setGstRegistrationCertificateId(FileAsset gstRegistrationCertificateId) {
        this.gstRegistrationCertificateId = gstRegistrationCertificateId;
    }

    public BranchMaster getBranchMasterId() {
        return branchMasterId;
    }

    public void setBranchMasterId(BranchMaster branchMasterId) {
        this.branchMasterId = branchMasterId;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    public UserMaster getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(UserMaster lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public FileAsset getPanCardId() {
        return panCardId;
    }

    public void setPanCardId(FileAsset panCardId) {
        this.panCardId = panCardId;
    }

    public FileAsset getCancelledChequeId() {
        return cancelledChequeId;
    }

    public void setCancelledChequeId(FileAsset cancelledChequeId) {
        this.cancelledChequeId = cancelledChequeId;
    }

    public GstMaster getGstMasterId() {
        return gstMasterId;
    }

    public void setGstMasterId(GstMaster gstMasterId) {
        this.gstMasterId = gstMasterId;
    }

    public PanMaster getPanMasterId() {
        return panMasterId;
    }

    public void setPanMasterId(PanMaster panMasterId) {
        this.panMasterId = panMasterId;
    }

    public SourceMaster getSourceMasterId() {
        return sourceMasterId;
    }

    public void setSourceMasterId(SourceMaster sourceMasterId) {
        this.sourceMasterId = sourceMasterId;
    }

    public StaffMaster getStaffMasterId() {
        return staffMasterId;
    }

    public void setStaffMasterId(StaffMaster staffMasterId) {
        this.staffMasterId = staffMasterId;
    }

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
    }

    public UserMaster getUserMasterId() {
        return userMasterId;
    }

    public void setUserMasterId(UserMaster userMasterId) {
        this.userMasterId = userMasterId;
    }

    public UserMaster getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserMaster createdBy) {
        this.createdBy = createdBy;
    }

    @XmlTransient
    public List<ProjectMaster> getProjectMasterList() {
        return projectMasterList;
    }

    public void setProjectMasterList(List<ProjectMaster> projectMasterList) {
        this.projectMasterList = projectMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerMasterId != null ? customerMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerMaster)) {
            return false;
        }
        CustomerMaster other = (CustomerMaster) object;
        if ((this.customerMasterId == null && other.customerMasterId != null) || (this.customerMasterId != null && !this.customerMasterId.equals(other.customerMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.CustomerMaster[ customerMasterId=" + customerMasterId + " ]";
    }
    
}
