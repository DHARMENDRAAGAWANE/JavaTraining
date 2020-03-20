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
@Table(name = "attendance_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AttendanceMaster.findAll", query = "SELECT a FROM AttendanceMaster a"),
    @NamedQuery(name = "AttendanceMaster.findByAttendanceMasterId", query = "SELECT a FROM AttendanceMaster a WHERE a.attendanceMasterId = :attendanceMasterId"),
    @NamedQuery(name = "AttendanceMaster.findByDate", query = "SELECT a FROM AttendanceMaster a WHERE a.date = :date"),
    @NamedQuery(name = "AttendanceMaster.findByStaffName", query = "SELECT a FROM AttendanceMaster a WHERE a.staffName = :staffName"),
    @NamedQuery(name = "AttendanceMaster.findByAttendanceMasterStatus", query = "SELECT a FROM AttendanceMaster a WHERE a.attendanceMasterStatus = :attendanceMasterStatus"),
    @NamedQuery(name = "AttendanceMaster.findByAttendanceMasterType", query = "SELECT a FROM AttendanceMaster a WHERE a.attendanceMasterType = :attendanceMasterType"),
    @NamedQuery(name = "AttendanceMaster.findByCreatedBy", query = "SELECT a FROM AttendanceMaster a WHERE a.createdBy = :createdBy"),
    @NamedQuery(name = "AttendanceMaster.findByLastUpdatedBy", query = "SELECT a FROM AttendanceMaster a WHERE a.lastUpdatedBy = :lastUpdatedBy"),
    @NamedQuery(name = "AttendanceMaster.findByCreatedAt", query = "SELECT a FROM AttendanceMaster a WHERE a.createdAt = :createdAt"),
    @NamedQuery(name = "AttendanceMaster.findByLastUpdatedAt", query = "SELECT a FROM AttendanceMaster a WHERE a.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "AttendanceMaster.findByIsActive", query = "SELECT a FROM AttendanceMaster a WHERE a.isActive = :isActive"),
    @NamedQuery(name = "AttendanceMaster.findByIpAddress", query = "SELECT a FROM AttendanceMaster a WHERE a.ipAddress = :ipAddress")})
public class AttendanceMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "attendance_master_id")
    private Integer attendanceMasterId;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "staff_name")
    private String staffName;
    @Basic(optional = false)
    @Column(name = "attendance_master_status")
    private String attendanceMasterStatus;
    @Basic(optional = false)
    @Column(name = "attendance_master_type")
    private String attendanceMasterType;
    @Basic(optional = false)
    @Column(name = "created_by")
    private int createdBy;
    @Basic(optional = false)
    @Column(name = "last_updated_by")
    private int lastUpdatedBy;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "last_updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedAt;
    @Column(name = "is_active")
    private Character isActive;
    @Basic(optional = false)
    @Column(name = "ip_address")
    private String ipAddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staffId")
    private List<EmployeeWorkDetails> employeeWorkDetailsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staffId")
    private List<EmployeeCtcTable> employeeCtcTableList;
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_master_id")
    @ManyToOne(optional = false)
    private StaffMaster staffId;

    public AttendanceMaster() {
    }

    public AttendanceMaster(Integer attendanceMasterId) {
        this.attendanceMasterId = attendanceMasterId;
    }

    public AttendanceMaster(Integer attendanceMasterId, Date date, String staffName, String attendanceMasterStatus, String attendanceMasterType, int createdBy, int lastUpdatedBy, String ipAddress) {
        this.attendanceMasterId = attendanceMasterId;
        this.date = date;
        this.staffName = staffName;
        this.attendanceMasterStatus = attendanceMasterStatus;
        this.attendanceMasterType = attendanceMasterType;
        this.createdBy = createdBy;
        this.lastUpdatedBy = lastUpdatedBy;
        this.ipAddress = ipAddress;
    }

    public Integer getAttendanceMasterId() {
        return attendanceMasterId;
    }

    public void setAttendanceMasterId(Integer attendanceMasterId) {
        this.attendanceMasterId = attendanceMasterId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getAttendanceMasterStatus() {
        return attendanceMasterStatus;
    }

    public void setAttendanceMasterStatus(String attendanceMasterStatus) {
        this.attendanceMasterStatus = attendanceMasterStatus;
    }

    public String getAttendanceMasterType() {
        return attendanceMasterType;
    }

    public void setAttendanceMasterType(String attendanceMasterType) {
        this.attendanceMasterType = attendanceMasterType;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(int lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
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
    public List<EmployeeWorkDetails> getEmployeeWorkDetailsList() {
        return employeeWorkDetailsList;
    }

    public void setEmployeeWorkDetailsList(List<EmployeeWorkDetails> employeeWorkDetailsList) {
        this.employeeWorkDetailsList = employeeWorkDetailsList;
    }

    @XmlTransient
    public List<EmployeeCtcTable> getEmployeeCtcTableList() {
        return employeeCtcTableList;
    }

    public void setEmployeeCtcTableList(List<EmployeeCtcTable> employeeCtcTableList) {
        this.employeeCtcTableList = employeeCtcTableList;
    }

    public StaffMaster getStaffId() {
        return staffId;
    }

    public void setStaffId(StaffMaster staffId) {
        this.staffId = staffId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attendanceMasterId != null ? attendanceMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AttendanceMaster)) {
            return false;
        }
        AttendanceMaster other = (AttendanceMaster) object;
        if ((this.attendanceMasterId == null && other.attendanceMasterId != null) || (this.attendanceMasterId != null && !this.attendanceMasterId.equals(other.attendanceMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.AttendanceMaster[ attendanceMasterId=" + attendanceMasterId + " ]";
    }
    
}
