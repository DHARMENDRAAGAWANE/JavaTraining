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
@Table(name = "employee_ctc_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeCtcTable.findAll", query = "SELECT e FROM EmployeeCtcTable e"),
    @NamedQuery(name = "EmployeeCtcTable.findByEmployeeCtcId", query = "SELECT e FROM EmployeeCtcTable e WHERE e.employeeCtcId = :employeeCtcId"),
    @NamedQuery(name = "EmployeeCtcTable.findByFromDate", query = "SELECT e FROM EmployeeCtcTable e WHERE e.fromDate = :fromDate"),
    @NamedQuery(name = "EmployeeCtcTable.findByToDate", query = "SELECT e FROM EmployeeCtcTable e WHERE e.toDate = :toDate"),
    @NamedQuery(name = "EmployeeCtcTable.findByEmployeeCtc", query = "SELECT e FROM EmployeeCtcTable e WHERE e.employeeCtc = :employeeCtc"),
    @NamedQuery(name = "EmployeeCtcTable.findByCreatedBy", query = "SELECT e FROM EmployeeCtcTable e WHERE e.createdBy = :createdBy"),
    @NamedQuery(name = "EmployeeCtcTable.findByLastUpdatedBy", query = "SELECT e FROM EmployeeCtcTable e WHERE e.lastUpdatedBy = :lastUpdatedBy"),
    @NamedQuery(name = "EmployeeCtcTable.findByCreatedAt", query = "SELECT e FROM EmployeeCtcTable e WHERE e.createdAt = :createdAt"),
    @NamedQuery(name = "EmployeeCtcTable.findByLastUpdatedAt", query = "SELECT e FROM EmployeeCtcTable e WHERE e.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "EmployeeCtcTable.findByIsActive", query = "SELECT e FROM EmployeeCtcTable e WHERE e.isActive = :isActive"),
    @NamedQuery(name = "EmployeeCtcTable.findByIpAddress", query = "SELECT e FROM EmployeeCtcTable e WHERE e.ipAddress = :ipAddress")})
public class EmployeeCtcTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "employee_ctc_id")
    private Integer employeeCtcId;
    @Basic(optional = false)
    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Basic(optional = false)
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @Basic(optional = false)
    @Column(name = "employee_ctc")
    private double employeeCtc;
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
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id")
    @ManyToOne(optional = false)
    private AttendanceMaster staffId;

    public EmployeeCtcTable() {
    }

    public EmployeeCtcTable(Integer employeeCtcId) {
        this.employeeCtcId = employeeCtcId;
    }

    public EmployeeCtcTable(Integer employeeCtcId, Date fromDate, Date toDate, double employeeCtc, int createdBy, int lastUpdatedBy, String ipAddress) {
        this.employeeCtcId = employeeCtcId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.employeeCtc = employeeCtc;
        this.createdBy = createdBy;
        this.lastUpdatedBy = lastUpdatedBy;
        this.ipAddress = ipAddress;
    }

    public Integer getEmployeeCtcId() {
        return employeeCtcId;
    }

    public void setEmployeeCtcId(Integer employeeCtcId) {
        this.employeeCtcId = employeeCtcId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public double getEmployeeCtc() {
        return employeeCtc;
    }

    public void setEmployeeCtc(double employeeCtc) {
        this.employeeCtc = employeeCtc;
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

    public AttendanceMaster getStaffId() {
        return staffId;
    }

    public void setStaffId(AttendanceMaster staffId) {
        this.staffId = staffId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeCtcId != null ? employeeCtcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeCtcTable)) {
            return false;
        }
        EmployeeCtcTable other = (EmployeeCtcTable) object;
        if ((this.employeeCtcId == null && other.employeeCtcId != null) || (this.employeeCtcId != null && !this.employeeCtcId.equals(other.employeeCtcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.EmployeeCtcTable[ employeeCtcId=" + employeeCtcId + " ]";
    }
    
}
