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
@Table(name = "service_tag_link")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceTagLink.findAll", query = "SELECT s FROM ServiceTagLink s"),
    @NamedQuery(name = "ServiceTagLink.findByServiceTagLinkId", query = "SELECT s FROM ServiceTagLink s WHERE s.serviceTagLinkId = :serviceTagLinkId"),
    @NamedQuery(name = "ServiceTagLink.findByCreatedAt", query = "SELECT s FROM ServiceTagLink s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "ServiceTagLink.findByLastUpdatedAt", query = "SELECT s FROM ServiceTagLink s WHERE s.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "ServiceTagLink.findByIsActive", query = "SELECT s FROM ServiceTagLink s WHERE s.isActive = :isActive"),
    @NamedQuery(name = "ServiceTagLink.findByIpAddress", query = "SELECT s FROM ServiceTagLink s WHERE s.ipAddress = :ipAddress")})
public class ServiceTagLink implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "service_tag_link_id")
    private Integer serviceTagLinkId;
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
    @JoinColumn(name = "service_id", referencedColumnName = "service_master_id")
    @ManyToOne(optional = false)
    private ServiceMaster serviceId;
    @JoinColumn(name = "service_tag_id", referencedColumnName = "service_tag_id")
    @ManyToOne(optional = false)
    private ServiceTag serviceTagId;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;

    public ServiceTagLink() {
    }

    public ServiceTagLink(Integer serviceTagLinkId) {
        this.serviceTagLinkId = serviceTagLinkId;
    }

    public ServiceTagLink(Integer serviceTagLinkId, Character isActive) {
        this.serviceTagLinkId = serviceTagLinkId;
        this.isActive = isActive;
    }

    public Integer getServiceTagLinkId() {
        return serviceTagLinkId;
    }

    public void setServiceTagLinkId(Integer serviceTagLinkId) {
        this.serviceTagLinkId = serviceTagLinkId;
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

    public ServiceMaster getServiceId() {
        return serviceId;
    }

    public void setServiceId(ServiceMaster serviceId) {
        this.serviceId = serviceId;
    }

    public ServiceTag getServiceTagId() {
        return serviceTagId;
    }

    public void setServiceTagId(ServiceTag serviceTagId) {
        this.serviceTagId = serviceTagId;
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
        hash += (serviceTagLinkId != null ? serviceTagLinkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceTagLink)) {
            return false;
        }
        ServiceTagLink other = (ServiceTagLink) object;
        if ((this.serviceTagLinkId == null && other.serviceTagLinkId != null) || (this.serviceTagLinkId != null && !this.serviceTagLinkId.equals(other.serviceTagLinkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.ServiceTagLink[ serviceTagLinkId=" + serviceTagLinkId + " ]";
    }
    
}
