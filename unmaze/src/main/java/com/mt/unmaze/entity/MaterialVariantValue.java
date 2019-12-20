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
@Table(name = "material_variant_value")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialVariantValue.findAll", query = "SELECT m FROM MaterialVariantValue m"),
    @NamedQuery(name = "MaterialVariantValue.findByMaterialVariantValueId", query = "SELECT m FROM MaterialVariantValue m WHERE m.materialVariantValueId = :materialVariantValueId"),
    @NamedQuery(name = "MaterialVariantValue.findByMaterialVariantValueName", query = "SELECT m FROM MaterialVariantValue m WHERE m.materialVariantValueName = :materialVariantValueName"),
    @NamedQuery(name = "MaterialVariantValue.findByCreatedAt", query = "SELECT m FROM MaterialVariantValue m WHERE m.createdAt = :createdAt"),
    @NamedQuery(name = "MaterialVariantValue.findByLastUpdatedAt", query = "SELECT m FROM MaterialVariantValue m WHERE m.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "MaterialVariantValue.findByIsActive", query = "SELECT m FROM MaterialVariantValue m WHERE m.isActive = :isActive"),
    @NamedQuery(name = "MaterialVariantValue.findByIpAddress", query = "SELECT m FROM MaterialVariantValue m WHERE m.ipAddress = :ipAddress")})
public class MaterialVariantValue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "material_variant_value_id")
    private Integer materialVariantValueId;
    @Basic(optional = false)
    @Column(name = "material_variant_value_name")
    private String materialVariantValueName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialVariantValueId")
    private List<MaterialMasterVariantMapping> materialMasterVariantMappingList;
    @JoinColumn(name = "material_variant_id", referencedColumnName = "material_variant_id")
    @ManyToOne(optional = false)
    private MaterialVariant materialVariantId;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;

    public MaterialVariantValue() {
    }

    public MaterialVariantValue(Integer materialVariantValueId) {
        this.materialVariantValueId = materialVariantValueId;
    }

    public MaterialVariantValue(Integer materialVariantValueId, String materialVariantValueName, Date lastUpdatedAt, Character isActive) {
        this.materialVariantValueId = materialVariantValueId;
        this.materialVariantValueName = materialVariantValueName;
        this.lastUpdatedAt = lastUpdatedAt;
        this.isActive = isActive;
    }

    public Integer getMaterialVariantValueId() {
        return materialVariantValueId;
    }

    public void setMaterialVariantValueId(Integer materialVariantValueId) {
        this.materialVariantValueId = materialVariantValueId;
    }

    public String getMaterialVariantValueName() {
        return materialVariantValueName;
    }

    public void setMaterialVariantValueName(String materialVariantValueName) {
        this.materialVariantValueName = materialVariantValueName;
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
    public List<MaterialMasterVariantMapping> getMaterialMasterVariantMappingList() {
        return materialMasterVariantMappingList;
    }

    public void setMaterialMasterVariantMappingList(List<MaterialMasterVariantMapping> materialMasterVariantMappingList) {
        this.materialMasterVariantMappingList = materialMasterVariantMappingList;
    }

    public MaterialVariant getMaterialVariantId() {
        return materialVariantId;
    }

    public void setMaterialVariantId(MaterialVariant materialVariantId) {
        this.materialVariantId = materialVariantId;
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
        hash += (materialVariantValueId != null ? materialVariantValueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialVariantValue)) {
            return false;
        }
        MaterialVariantValue other = (MaterialVariantValue) object;
        if ((this.materialVariantValueId == null && other.materialVariantValueId != null) || (this.materialVariantValueId != null && !this.materialVariantValueId.equals(other.materialVariantValueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.MaterialVariantValue[ materialVariantValueId=" + materialVariantValueId + " ]";
    }
    
}
