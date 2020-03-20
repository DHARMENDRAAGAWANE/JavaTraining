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
@Table(name = "system_lock_date")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SystemLockDate.findAll", query = "SELECT s FROM SystemLockDate s"),
    @NamedQuery(name = "SystemLockDate.findBySystemLockDateId", query = "SELECT s FROM SystemLockDate s WHERE s.systemLockDateId = :systemLockDateId"),
    @NamedQuery(name = "SystemLockDate.findByStartDate", query = "SELECT s FROM SystemLockDate s WHERE s.startDate = :startDate"),
    @NamedQuery(name = "SystemLockDate.findByEndDate", query = "SELECT s FROM SystemLockDate s WHERE s.endDate = :endDate"),
    @NamedQuery(name = "SystemLockDate.findByIsActive", query = "SELECT s FROM SystemLockDate s WHERE s.isActive = :isActive")})
public class SystemLockDate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "system_lock_date_id")
    private Integer systemLockDateId;
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;

    public SystemLockDate() {
    }

    public SystemLockDate(Integer systemLockDateId) {
        this.systemLockDateId = systemLockDateId;
    }

    public SystemLockDate(Integer systemLockDateId, Character isActive) {
        this.systemLockDateId = systemLockDateId;
        this.isActive = isActive;
    }

    public Integer getSystemLockDateId() {
        return systemLockDateId;
    }

    public void setSystemLockDateId(Integer systemLockDateId) {
        this.systemLockDateId = systemLockDateId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (systemLockDateId != null ? systemLockDateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SystemLockDate)) {
            return false;
        }
        SystemLockDate other = (SystemLockDate) object;
        if ((this.systemLockDateId == null && other.systemLockDateId != null) || (this.systemLockDateId != null && !this.systemLockDateId.equals(other.systemLockDateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.SystemLockDate[ systemLockDateId=" + systemLockDateId + " ]";
    }
    
}
