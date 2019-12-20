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
@Table(name = "service_unit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceUnit.findAll", query = "SELECT s FROM ServiceUnit s"),
    @NamedQuery(name = "ServiceUnit.findByServiceUnitId", query = "SELECT s FROM ServiceUnit s WHERE s.serviceUnitId = :serviceUnitId"),
    @NamedQuery(name = "ServiceUnit.findByServiceUnitName", query = "SELECT s FROM ServiceUnit s WHERE s.serviceUnitName = :serviceUnitName"),
    @NamedQuery(name = "ServiceUnit.findByCreatedAt", query = "SELECT s FROM ServiceUnit s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "ServiceUnit.findByLastUpdatedAt", query = "SELECT s FROM ServiceUnit s WHERE s.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "ServiceUnit.findByIsActive", query = "SELECT s FROM ServiceUnit s WHERE s.isActive = :isActive"),
    @NamedQuery(name = "ServiceUnit.findByIsDeleted", query = "SELECT s FROM ServiceUnit s WHERE s.isDeleted = :isDeleted"),
    @NamedQuery(name = "ServiceUnit.findByIpAddress", query = "SELECT s FROM ServiceUnit s WHERE s.ipAddress = :ipAddress")})
public class ServiceUnit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "service_unit_id")
    private Integer serviceUnitId;
    @Column(name = "service_unit_name")
    private String serviceUnitName;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
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
    @OneToMany(mappedBy = "serviceUnitId")
    private List<ServiceMaster> serviceMasterList;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;

    public ServiceUnit() {
    }

    public ServiceUnit(Integer serviceUnitId) {
        this.serviceUnitId = serviceUnitId;
    }

    public ServiceUnit(Integer serviceUnitId, Character isActive, Character isDeleted) {
        this.serviceUnitId = serviceUnitId;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
    }

    public Integer getServiceUnitId() {
        return serviceUnitId;
    }

    public void setServiceUnitId(Integer serviceUnitId) {
        this.serviceUnitId = serviceUnitId;
    }

    public String getServiceUnitName() {
        return serviceUnitName;
    }

    public void setServiceUnitName(String serviceUnitName) {
        this.serviceUnitName = serviceUnitName;
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
    public List<ServiceMaster> getServiceMasterList() {
        return serviceMasterList;
    }

    public void setServiceMasterList(List<ServiceMaster> serviceMasterList) {
        this.serviceMasterList = serviceMasterList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceUnitId != null ? serviceUnitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceUnit)) {
            return false;
        }
        ServiceUnit other = (ServiceUnit) object;
        if ((this.serviceUnitId == null && other.serviceUnitId != null) || (this.serviceUnitId != null && !this.serviceUnitId.equals(other.serviceUnitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.ServiceUnit[ serviceUnitId=" + serviceUnitId + " ]";
    }
    
}
