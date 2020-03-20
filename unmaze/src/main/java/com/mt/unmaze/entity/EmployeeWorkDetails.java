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
@Table(name = "employee_work_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeWorkDetails.findAll", query = "SELECT e FROM EmployeeWorkDetails e"),
    @NamedQuery(name = "EmployeeWorkDetails.findByTableMasterId", query = "SELECT e FROM EmployeeWorkDetails e WHERE e.tableMasterId = :tableMasterId"),
    @NamedQuery(name = "EmployeeWorkDetails.findByDate", query = "SELECT e FROM EmployeeWorkDetails e WHERE e.date = :date"),
    @NamedQuery(name = "EmployeeWorkDetails.findByProjectMasterId", query = "SELECT e FROM EmployeeWorkDetails e WHERE e.projectMasterId = :projectMasterId"),
    @NamedQuery(name = "EmployeeWorkDetails.findByNoOfHours", query = "SELECT e FROM EmployeeWorkDetails e WHERE e.noOfHours = :noOfHours"),
    @NamedQuery(name = "EmployeeWorkDetails.findByWorkDescription", query = "SELECT e FROM EmployeeWorkDetails e WHERE e.workDescription = :workDescription"),
    @NamedQuery(name = "EmployeeWorkDetails.findByCreatedBy", query = "SELECT e FROM EmployeeWorkDetails e WHERE e.createdBy = :createdBy"),
    @NamedQuery(name = "EmployeeWorkDetails.findByLastUpdatedBy", query = "SELECT e FROM EmployeeWorkDetails e WHERE e.lastUpdatedBy = :lastUpdatedBy"),
    @NamedQuery(name = "EmployeeWorkDetails.findByCreatedAt", query = "SELECT e FROM EmployeeWorkDetails e WHERE e.createdAt = :createdAt"),
    @NamedQuery(name = "EmployeeWorkDetails.findByLastUpdatedAt", query = "SELECT e FROM EmployeeWorkDetails e WHERE e.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "EmployeeWorkDetails.findByIsActive", query = "SELECT e FROM EmployeeWorkDetails e WHERE e.isActive = :isActive"),
    @NamedQuery(name = "EmployeeWorkDetails.findByIpAddress", query = "SELECT e FROM EmployeeWorkDetails e WHERE e.ipAddress = :ipAddress")})
public class EmployeeWorkDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "table_master_id")
    private Integer tableMasterId;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "project_master_id")
    private int projectMasterId;
    @Basic(optional = false)
    @Column(name = "no_of_hours")
    private int noOfHours;
    @Basic(optional = false)
    @Column(name = "work_description")
    private String workDescription;
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

    public EmployeeWorkDetails() {
    }

    public EmployeeWorkDetails(Integer tableMasterId) {
        this.tableMasterId = tableMasterId;
    }

    public EmployeeWorkDetails(Integer tableMasterId, Date date, int projectMasterId, int noOfHours, String workDescription, int createdBy, int lastUpdatedBy, String ipAddress) {
        this.tableMasterId = tableMasterId;
        this.date = date;
        this.projectMasterId = projectMasterId;
        this.noOfHours = noOfHours;
        this.workDescription = workDescription;
        this.createdBy = createdBy;
        this.lastUpdatedBy = lastUpdatedBy;
        this.ipAddress = ipAddress;
    }

    public Integer getTableMasterId() {
        return tableMasterId;
    }

    public void setTableMasterId(Integer tableMasterId) {
        this.tableMasterId = tableMasterId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getProjectMasterId() {
        return projectMasterId;
    }

    public void setProjectMasterId(int projectMasterId) {
        this.projectMasterId = projectMasterId;
    }

    public int getNoOfHours() {
        return noOfHours;
    }

    public void setNoOfHours(int noOfHours) {
        this.noOfHours = noOfHours;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
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
        hash += (tableMasterId != null ? tableMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeWorkDetails)) {
            return false;
        }
        EmployeeWorkDetails other = (EmployeeWorkDetails) object;
        if ((this.tableMasterId == null && other.tableMasterId != null) || (this.tableMasterId != null && !this.tableMasterId.equals(other.tableMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.EmployeeWorkDetails[ tableMasterId=" + tableMasterId + " ]";
    }
    
}
