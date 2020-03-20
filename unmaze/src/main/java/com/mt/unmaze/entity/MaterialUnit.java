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
@Table(name = "material_unit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialUnit.findAll", query = "SELECT m FROM MaterialUnit m"),
    @NamedQuery(name = "MaterialUnit.findByMaterialUnitId", query = "SELECT m FROM MaterialUnit m WHERE m.materialUnitId = :materialUnitId"),
    @NamedQuery(name = "MaterialUnit.findByMaterialUnitName", query = "SELECT m FROM MaterialUnit m WHERE m.materialUnitName = :materialUnitName"),
    @NamedQuery(name = "MaterialUnit.findByCreatedAt", query = "SELECT m FROM MaterialUnit m WHERE m.createdAt = :createdAt"),
    @NamedQuery(name = "MaterialUnit.findByLastUpdatedAt", query = "SELECT m FROM MaterialUnit m WHERE m.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "MaterialUnit.findByIsActive", query = "SELECT m FROM MaterialUnit m WHERE m.isActive = :isActive"),
    @NamedQuery(name = "MaterialUnit.findByIsDeleted", query = "SELECT m FROM MaterialUnit m WHERE m.isDeleted = :isDeleted"),
    @NamedQuery(name = "MaterialUnit.findByIpAddress", query = "SELECT m FROM MaterialUnit m WHERE m.ipAddress = :ipAddress")})
public class MaterialUnit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "material_unit_id")
    private Integer materialUnitId;
    @Column(name = "material_unit_name")
    private String materialUnitName;
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
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @OneToMany(mappedBy = "materialUnitId")
    private List<MaterialMaster> materialMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "units")
    private List<BillOfMaterialMaster> billOfMaterialMasterList;

    public MaterialUnit() {
    }

    public MaterialUnit(Integer materialUnitId) {
        this.materialUnitId = materialUnitId;
    }

    public MaterialUnit(Integer materialUnitId, Character isActive, Character isDeleted) {
        this.materialUnitId = materialUnitId;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
    }

    public Integer getMaterialUnitId() {
        return materialUnitId;
    }

    public void setMaterialUnitId(Integer materialUnitId) {
        this.materialUnitId = materialUnitId;
    }

    public String getMaterialUnitName() {
        return materialUnitName;
    }

    public void setMaterialUnitName(String materialUnitName) {
        this.materialUnitName = materialUnitName;
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
    public List<MaterialMaster> getMaterialMasterList() {
        return materialMasterList;
    }

    public void setMaterialMasterList(List<MaterialMaster> materialMasterList) {
        this.materialMasterList = materialMasterList;
    }

    @XmlTransient
    public List<BillOfMaterialMaster> getBillOfMaterialMasterList() {
        return billOfMaterialMasterList;
    }

    public void setBillOfMaterialMasterList(List<BillOfMaterialMaster> billOfMaterialMasterList) {
        this.billOfMaterialMasterList = billOfMaterialMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materialUnitId != null ? materialUnitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialUnit)) {
            return false;
        }
        MaterialUnit other = (MaterialUnit) object;
        if ((this.materialUnitId == null && other.materialUnitId != null) || (this.materialUnitId != null && !this.materialUnitId.equals(other.materialUnitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.MaterialUnit[ materialUnitId=" + materialUnitId + " ]";
    }
    
}
