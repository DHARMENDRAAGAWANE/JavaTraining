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
@Table(name = "staff_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StaffMaster.findAll", query = "SELECT s FROM StaffMaster s"),
    @NamedQuery(name = "StaffMaster.findByStaffMasterId", query = "SELECT s FROM StaffMaster s WHERE s.staffMasterId = :staffMasterId"),
    @NamedQuery(name = "StaffMaster.findByStaffMasterName", query = "SELECT s FROM StaffMaster s WHERE s.staffMasterName = :staffMasterName"),
    @NamedQuery(name = "StaffMaster.findByMobile", query = "SELECT s FROM StaffMaster s WHERE s.mobile = :mobile"),
    @NamedQuery(name = "StaffMaster.findByCtc", query = "SELECT s FROM StaffMaster s WHERE s.ctc = :ctc"),
    @NamedQuery(name = "StaffMaster.findByCreatedAt", query = "SELECT s FROM StaffMaster s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "StaffMaster.findByLastUpdatedAt", query = "SELECT s FROM StaffMaster s WHERE s.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "StaffMaster.findByIsActive", query = "SELECT s FROM StaffMaster s WHERE s.isActive = :isActive"),
    @NamedQuery(name = "StaffMaster.findByIsDeleted", query = "SELECT s FROM StaffMaster s WHERE s.isDeleted = :isDeleted"),
    @NamedQuery(name = "StaffMaster.findByIpAddress", query = "SELECT s FROM StaffMaster s WHERE s.ipAddress = :ipAddress")})
public class StaffMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "staff_master_id")
    private Integer staffMasterId;
    @Basic(optional = false)
    @Column(name = "staff_master_name")
    private String staffMasterName;
    @Column(name = "mobile")
    private BigInteger mobile;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ctc")
    private Double ctc;
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
    @Basic(optional = false)
    @Column(name = "is_deleted")
    private Character isDeleted;
    @Column(name = "ip_address")
    private String ipAddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staffId")
    private List<TaskMaster> taskMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staffId")
    private List<TaskDetailMaster> taskDetailMasterList;
    @OneToMany(mappedBy = "staffMasterId")
    private List<UserMaster> userMasterList;
    @OneToMany(mappedBy = "staffMasterId")
    private List<BookingTagMaster> bookingTagMasterList;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @OneToMany(mappedBy = "staffMasterId")
    private List<CustomerMaster> customerMasterList;
    @OneToMany(mappedBy = "staffMasterId")
    private List<ProjectMaster> projectMasterList;
    @OneToMany(mappedBy = "staffMasterId")
    private List<PoTagMaster> poTagMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staffId")
    private List<AttendanceMaster> attendanceMasterList;

    public StaffMaster() {
    }

    public StaffMaster(Integer staffMasterId) {
        this.staffMasterId = staffMasterId;
    }

    public StaffMaster(Integer staffMasterId, String staffMasterName, Date lastUpdatedAt, Character isActive, Character isDeleted) {
        this.staffMasterId = staffMasterId;
        this.staffMasterName = staffMasterName;
        this.lastUpdatedAt = lastUpdatedAt;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
    }

    public Integer getStaffMasterId() {
        return staffMasterId;
    }

    public void setStaffMasterId(Integer staffMasterId) {
        this.staffMasterId = staffMasterId;
    }

    public String getStaffMasterName() {
        return staffMasterName;
    }

    public void setStaffMasterName(String staffMasterName) {
        this.staffMasterName = staffMasterName;
    }

    public BigInteger getMobile() {
        return mobile;
    }

    public void setMobile(BigInteger mobile) {
        this.mobile = mobile;
    }

    public Double getCtc() {
        return ctc;
    }

    public void setCtc(Double ctc) {
        this.ctc = ctc;
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

    public Character getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Character isDeleted) {
        this.isDeleted = isDeleted;
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
    public List<UserMaster> getUserMasterList() {
        return userMasterList;
    }

    public void setUserMasterList(List<UserMaster> userMasterList) {
        this.userMasterList = userMasterList;
    }

    @XmlTransient
    public List<BookingTagMaster> getBookingTagMasterList() {
        return bookingTagMasterList;
    }

    public void setBookingTagMasterList(List<BookingTagMaster> bookingTagMasterList) {
        this.bookingTagMasterList = bookingTagMasterList;
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
    public List<PoTagMaster> getPoTagMasterList() {
        return poTagMasterList;
    }

    public void setPoTagMasterList(List<PoTagMaster> poTagMasterList) {
        this.poTagMasterList = poTagMasterList;
    }

    @XmlTransient
    public List<AttendanceMaster> getAttendanceMasterList() {
        return attendanceMasterList;
    }

    public void setAttendanceMasterList(List<AttendanceMaster> attendanceMasterList) {
        this.attendanceMasterList = attendanceMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffMasterId != null ? staffMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StaffMaster)) {
            return false;
        }
        StaffMaster other = (StaffMaster) object;
        if ((this.staffMasterId == null && other.staffMasterId != null) || (this.staffMasterId != null && !this.staffMasterId.equals(other.staffMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.StaffMaster[ staffMasterId=" + staffMasterId + " ]";
    }
    
}
