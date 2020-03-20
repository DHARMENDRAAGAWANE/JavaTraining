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
@Table(name = "material_variant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialVariant.findAll", query = "SELECT m FROM MaterialVariant m"),
    @NamedQuery(name = "MaterialVariant.findByMaterialVariantId", query = "SELECT m FROM MaterialVariant m WHERE m.materialVariantId = :materialVariantId"),
    @NamedQuery(name = "MaterialVariant.findByMaterialVariantName", query = "SELECT m FROM MaterialVariant m WHERE m.materialVariantName = :materialVariantName"),
    @NamedQuery(name = "MaterialVariant.findByCreatedAt", query = "SELECT m FROM MaterialVariant m WHERE m.createdAt = :createdAt"),
    @NamedQuery(name = "MaterialVariant.findByLastUpdatedAt", query = "SELECT m FROM MaterialVariant m WHERE m.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "MaterialVariant.findByIsActive", query = "SELECT m FROM MaterialVariant m WHERE m.isActive = :isActive"),
    @NamedQuery(name = "MaterialVariant.findByIpAddress", query = "SELECT m FROM MaterialVariant m WHERE m.ipAddress = :ipAddress")})
public class MaterialVariant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "material_variant_id")
    private Integer materialVariantId;
    @Basic(optional = false)
    @Column(name = "material_variant_name")
    private String materialVariantName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialVariantId")
    private List<MaterialVariantValue> materialVariantValueList;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;

    public MaterialVariant() {
    }

    public MaterialVariant(Integer materialVariantId) {
        this.materialVariantId = materialVariantId;
    }

    public MaterialVariant(Integer materialVariantId, String materialVariantName, Date lastUpdatedAt, Character isActive) {
        this.materialVariantId = materialVariantId;
        this.materialVariantName = materialVariantName;
        this.lastUpdatedAt = lastUpdatedAt;
        this.isActive = isActive;
    }

    public Integer getMaterialVariantId() {
        return materialVariantId;
    }

    public void setMaterialVariantId(Integer materialVariantId) {
        this.materialVariantId = materialVariantId;
    }

    public String getMaterialVariantName() {
        return materialVariantName;
    }

    public void setMaterialVariantName(String materialVariantName) {
        this.materialVariantName = materialVariantName;
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
    public List<MaterialVariantValue> getMaterialVariantValueList() {
        return materialVariantValueList;
    }

    public void setMaterialVariantValueList(List<MaterialVariantValue> materialVariantValueList) {
        this.materialVariantValueList = materialVariantValueList;
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
        hash += (materialVariantId != null ? materialVariantId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialVariant)) {
            return false;
        }
        MaterialVariant other = (MaterialVariant) object;
        if ((this.materialVariantId == null && other.materialVariantId != null) || (this.materialVariantId != null && !this.materialVariantId.equals(other.materialVariantId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.MaterialVariant[ materialVariantId=" + materialVariantId + " ]";
    }
    
}
