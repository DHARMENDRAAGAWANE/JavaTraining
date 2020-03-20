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
@Table(name = "material_tag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialTag.findAll", query = "SELECT m FROM MaterialTag m"),
    @NamedQuery(name = "MaterialTag.findByMaterialTagId", query = "SELECT m FROM MaterialTag m WHERE m.materialTagId = :materialTagId"),
    @NamedQuery(name = "MaterialTag.findByMaterialTagName", query = "SELECT m FROM MaterialTag m WHERE m.materialTagName = :materialTagName"),
    @NamedQuery(name = "MaterialTag.findByCreatedAt", query = "SELECT m FROM MaterialTag m WHERE m.createdAt = :createdAt"),
    @NamedQuery(name = "MaterialTag.findByLastUpdatedAt", query = "SELECT m FROM MaterialTag m WHERE m.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "MaterialTag.findByIsActive", query = "SELECT m FROM MaterialTag m WHERE m.isActive = :isActive"),
    @NamedQuery(name = "MaterialTag.findByIpAddress", query = "SELECT m FROM MaterialTag m WHERE m.ipAddress = :ipAddress")})
public class MaterialTag implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "material_tag_id")
    private Integer materialTagId;
    @Column(name = "material_tag_name")
    private String materialTagName;
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
    @Column(name = "ip_address")
    private String ipAddress;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialTagId")
    private List<MaterialTagLink> materialTagLinkList;

    public MaterialTag() {
    }

    public MaterialTag(Integer materialTagId) {
        this.materialTagId = materialTagId;
    }

    public MaterialTag(Integer materialTagId, Date lastUpdatedAt, Character isActive) {
        this.materialTagId = materialTagId;
        this.lastUpdatedAt = lastUpdatedAt;
        this.isActive = isActive;
    }

    public Integer getMaterialTagId() {
        return materialTagId;
    }

    public void setMaterialTagId(Integer materialTagId) {
        this.materialTagId = materialTagId;
    }

    public String getMaterialTagName() {
        return materialTagName;
    }

    public void setMaterialTagName(String materialTagName) {
        this.materialTagName = materialTagName;
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
    public List<MaterialTagLink> getMaterialTagLinkList() {
        return materialTagLinkList;
    }

    public void setMaterialTagLinkList(List<MaterialTagLink> materialTagLinkList) {
        this.materialTagLinkList = materialTagLinkList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materialTagId != null ? materialTagId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialTag)) {
            return false;
        }
        MaterialTag other = (MaterialTag) object;
        if ((this.materialTagId == null && other.materialTagId != null) || (this.materialTagId != null && !this.materialTagId.equals(other.materialTagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.MaterialTag[ materialTagId=" + materialTagId + " ]";
    }
    
}
