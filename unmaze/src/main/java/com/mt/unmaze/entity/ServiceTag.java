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
@Table(name = "service_tag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceTag.findAll", query = "SELECT s FROM ServiceTag s"),
    @NamedQuery(name = "ServiceTag.findByServiceTagId", query = "SELECT s FROM ServiceTag s WHERE s.serviceTagId = :serviceTagId"),
    @NamedQuery(name = "ServiceTag.findByServiceTagName", query = "SELECT s FROM ServiceTag s WHERE s.serviceTagName = :serviceTagName"),
    @NamedQuery(name = "ServiceTag.findByCreatedAt", query = "SELECT s FROM ServiceTag s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "ServiceTag.findByLastUpdatedAt", query = "SELECT s FROM ServiceTag s WHERE s.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "ServiceTag.findByIsActive", query = "SELECT s FROM ServiceTag s WHERE s.isActive = :isActive"),
    @NamedQuery(name = "ServiceTag.findByIsDeleted", query = "SELECT s FROM ServiceTag s WHERE s.isDeleted = :isDeleted"),
    @NamedQuery(name = "ServiceTag.findByIpAddress", query = "SELECT s FROM ServiceTag s WHERE s.ipAddress = :ipAddress")})
public class ServiceTag implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "service_tag_id")
    private Integer serviceTagId;
    @Basic(optional = false)
    @Column(name = "service_tag_name")
    private String serviceTagName;
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
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceTagId")
    private List<ServiceTagLink> serviceTagLinkList;

    public ServiceTag() {
    }

    public ServiceTag(Integer serviceTagId) {
        this.serviceTagId = serviceTagId;
    }

    public ServiceTag(Integer serviceTagId, String serviceTagName, Date lastUpdatedAt, Character isActive, Character isDeleted) {
        this.serviceTagId = serviceTagId;
        this.serviceTagName = serviceTagName;
        this.lastUpdatedAt = lastUpdatedAt;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
    }

    public Integer getServiceTagId() {
        return serviceTagId;
    }

    public void setServiceTagId(Integer serviceTagId) {
        this.serviceTagId = serviceTagId;
    }

    public String getServiceTagName() {
        return serviceTagName;
    }

    public void setServiceTagName(String serviceTagName) {
        this.serviceTagName = serviceTagName;
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
    public List<ServiceTagLink> getServiceTagLinkList() {
        return serviceTagLinkList;
    }

    public void setServiceTagLinkList(List<ServiceTagLink> serviceTagLinkList) {
        this.serviceTagLinkList = serviceTagLinkList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceTagId != null ? serviceTagId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceTag)) {
            return false;
        }
        ServiceTag other = (ServiceTag) object;
        if ((this.serviceTagId == null && other.serviceTagId != null) || (this.serviceTagId != null && !this.serviceTagId.equals(other.serviceTagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.ServiceTag[ serviceTagId=" + serviceTagId + " ]";
    }
    
}
