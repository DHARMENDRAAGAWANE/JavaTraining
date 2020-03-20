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
@Table(name = "material_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialCategory.findAll", query = "SELECT m FROM MaterialCategory m"),
    @NamedQuery(name = "MaterialCategory.findByMaterialCategoryId", query = "SELECT m FROM MaterialCategory m WHERE m.materialCategoryId = :materialCategoryId"),
    @NamedQuery(name = "MaterialCategory.findByMaterialCategoryName", query = "SELECT m FROM MaterialCategory m WHERE m.materialCategoryName = :materialCategoryName"),
    @NamedQuery(name = "MaterialCategory.findByCreatedAt", query = "SELECT m FROM MaterialCategory m WHERE m.createdAt = :createdAt"),
    @NamedQuery(name = "MaterialCategory.findByLastUpdatedAt", query = "SELECT m FROM MaterialCategory m WHERE m.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "MaterialCategory.findByIsActive", query = "SELECT m FROM MaterialCategory m WHERE m.isActive = :isActive"),
    @NamedQuery(name = "MaterialCategory.findByIpAddress", query = "SELECT m FROM MaterialCategory m WHERE m.ipAddress = :ipAddress")})
public class MaterialCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "material_category_id")
    private Integer materialCategoryId;
    @Basic(optional = false)
    @Column(name = "material_category_name")
    private String materialCategoryName;
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
    @OneToMany(mappedBy = "materialCategoryId")
    private List<MaterialMaster> materialMasterList;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;

    public MaterialCategory() {
    }

    public MaterialCategory(Integer materialCategoryId) {
        this.materialCategoryId = materialCategoryId;
    }

    public MaterialCategory(Integer materialCategoryId, String materialCategoryName, Date lastUpdatedAt, Character isActive) {
        this.materialCategoryId = materialCategoryId;
        this.materialCategoryName = materialCategoryName;
        this.lastUpdatedAt = lastUpdatedAt;
        this.isActive = isActive;
    }

    public Integer getMaterialCategoryId() {
        return materialCategoryId;
    }

    public void setMaterialCategoryId(Integer materialCategoryId) {
        this.materialCategoryId = materialCategoryId;
    }

    public String getMaterialCategoryName() {
        return materialCategoryName;
    }

    public void setMaterialCategoryName(String materialCategoryName) {
        this.materialCategoryName = materialCategoryName;
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
    public List<MaterialMaster> getMaterialMasterList() {
        return materialMasterList;
    }

    public void setMaterialMasterList(List<MaterialMaster> materialMasterList) {
        this.materialMasterList = materialMasterList;
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
        hash += (materialCategoryId != null ? materialCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialCategory)) {
            return false;
        }
        MaterialCategory other = (MaterialCategory) object;
        if ((this.materialCategoryId == null && other.materialCategoryId != null) || (this.materialCategoryId != null && !this.materialCategoryId.equals(other.materialCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.MaterialCategory[ materialCategoryId=" + materialCategoryId + " ]";
    }
    
}
