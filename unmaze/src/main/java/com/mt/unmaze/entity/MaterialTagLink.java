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
@Table(name = "material_tag_link")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialTagLink.findAll", query = "SELECT m FROM MaterialTagLink m"),
    @NamedQuery(name = "MaterialTagLink.findByMaterialTagLinkId", query = "SELECT m FROM MaterialTagLink m WHERE m.materialTagLinkId = :materialTagLinkId"),
    @NamedQuery(name = "MaterialTagLink.findByCreatedAt", query = "SELECT m FROM MaterialTagLink m WHERE m.createdAt = :createdAt"),
    @NamedQuery(name = "MaterialTagLink.findByLastUpdatedAt", query = "SELECT m FROM MaterialTagLink m WHERE m.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "MaterialTagLink.findByIsActive", query = "SELECT m FROM MaterialTagLink m WHERE m.isActive = :isActive"),
    @NamedQuery(name = "MaterialTagLink.findByIpAddress", query = "SELECT m FROM MaterialTagLink m WHERE m.ipAddress = :ipAddress")})
public class MaterialTagLink implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "material_tag_link_id")
    private Integer materialTagLinkId;
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
    @JoinColumn(name = "material_master_id", referencedColumnName = "material_master_id")
    @ManyToOne(optional = false)
    private MaterialMaster materialMasterId;
    @JoinColumn(name = "material_tag_id", referencedColumnName = "material_tag_id")
    @ManyToOne(optional = false)
    private MaterialTag materialTagId;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;

    public MaterialTagLink() {
    }

    public MaterialTagLink(Integer materialTagLinkId) {
        this.materialTagLinkId = materialTagLinkId;
    }

    public MaterialTagLink(Integer materialTagLinkId, Character isActive) {
        this.materialTagLinkId = materialTagLinkId;
        this.isActive = isActive;
    }

    public Integer getMaterialTagLinkId() {
        return materialTagLinkId;
    }

    public void setMaterialTagLinkId(Integer materialTagLinkId) {
        this.materialTagLinkId = materialTagLinkId;
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

    public MaterialMaster getMaterialMasterId() {
        return materialMasterId;
    }

    public void setMaterialMasterId(MaterialMaster materialMasterId) {
        this.materialMasterId = materialMasterId;
    }

    public MaterialTag getMaterialTagId() {
        return materialTagId;
    }

    public void setMaterialTagId(MaterialTag materialTagId) {
        this.materialTagId = materialTagId;
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
        hash += (materialTagLinkId != null ? materialTagLinkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialTagLink)) {
            return false;
        }
        MaterialTagLink other = (MaterialTagLink) object;
        if ((this.materialTagLinkId == null && other.materialTagLinkId != null) || (this.materialTagLinkId != null && !this.materialTagLinkId.equals(other.materialTagLinkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.MaterialTagLink[ materialTagLinkId=" + materialTagLinkId + " ]";
    }
    
}
