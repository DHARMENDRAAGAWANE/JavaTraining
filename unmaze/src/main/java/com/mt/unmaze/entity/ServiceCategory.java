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
@Table(name = "service_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceCategory.findAll", query = "SELECT s FROM ServiceCategory s"),
    @NamedQuery(name = "ServiceCategory.findByServiceCategoryId", query = "SELECT s FROM ServiceCategory s WHERE s.serviceCategoryId = :serviceCategoryId"),
    @NamedQuery(name = "ServiceCategory.findByServiceCategoryName", query = "SELECT s FROM ServiceCategory s WHERE s.serviceCategoryName = :serviceCategoryName"),
    @NamedQuery(name = "ServiceCategory.findByCreatedAt", query = "SELECT s FROM ServiceCategory s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "ServiceCategory.findByLastUpdatedAt", query = "SELECT s FROM ServiceCategory s WHERE s.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "ServiceCategory.findByIsActive", query = "SELECT s FROM ServiceCategory s WHERE s.isActive = :isActive"),
    @NamedQuery(name = "ServiceCategory.findByIsDeleted", query = "SELECT s FROM ServiceCategory s WHERE s.isDeleted = :isDeleted"),
    @NamedQuery(name = "ServiceCategory.findByIpAddress", query = "SELECT s FROM ServiceCategory s WHERE s.ipAddress = :ipAddress")})
public class ServiceCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "service_category_id")
    private Integer serviceCategoryId;
    @Basic(optional = false)
    @Column(name = "service_category_name")
    private String serviceCategoryName;
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
    @OneToMany(mappedBy = "serviceCategoryId")
    private List<ServiceMaster> serviceMasterList;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;

    public ServiceCategory() {
    }

    public ServiceCategory(Integer serviceCategoryId) {
        this.serviceCategoryId = serviceCategoryId;
    }

    public ServiceCategory(Integer serviceCategoryId, String serviceCategoryName, Date lastUpdatedAt, Character isActive, Character isDeleted) {
        this.serviceCategoryId = serviceCategoryId;
        this.serviceCategoryName = serviceCategoryName;
        this.lastUpdatedAt = lastUpdatedAt;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
    }

    public Integer getServiceCategoryId() {
        return serviceCategoryId;
    }

    public void setServiceCategoryId(Integer serviceCategoryId) {
        this.serviceCategoryId = serviceCategoryId;
    }

    public String getServiceCategoryName() {
        return serviceCategoryName;
    }

    public void setServiceCategoryName(String serviceCategoryName) {
        this.serviceCategoryName = serviceCategoryName;
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
        hash += (serviceCategoryId != null ? serviceCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceCategory)) {
            return false;
        }
        ServiceCategory other = (ServiceCategory) object;
        if ((this.serviceCategoryId == null && other.serviceCategoryId != null) || (this.serviceCategoryId != null && !this.serviceCategoryId.equals(other.serviceCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.ServiceCategory[ serviceCategoryId=" + serviceCategoryId + " ]";
    }
    
}
