/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mt.unmaze.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "material_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialType.findAll", query = "SELECT m FROM MaterialType m"),
    @NamedQuery(name = "MaterialType.findByMaterialTypeId", query = "SELECT m FROM MaterialType m WHERE m.materialTypeId = :materialTypeId"),
    @NamedQuery(name = "MaterialType.findByMaterialTypeName", query = "SELECT m FROM MaterialType m WHERE m.materialTypeName = :materialTypeName"),
    @NamedQuery(name = "MaterialType.findByTransactionApplicable", query = "SELECT m FROM MaterialType m WHERE m.transactionApplicable = :transactionApplicable"),
    @NamedQuery(name = "MaterialType.findByIsActive", query = "SELECT m FROM MaterialType m WHERE m.isActive = :isActive")})
public class MaterialType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "material_type_id")
    private Integer materialTypeId;
    @Basic(optional = false)
    @Column(name = "material_type_name")
    private String materialTypeName;
    @Basic(optional = false)
    @Column(name = "transaction_applicable")
    private Character transactionApplicable;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @OneToMany(mappedBy = "materialTypeId")
    private List<MaterialMaster> materialMasterList;

    public MaterialType() {
    }

    public MaterialType(Integer materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    public MaterialType(Integer materialTypeId, String materialTypeName, Character transactionApplicable, Character isActive) {
        this.materialTypeId = materialTypeId;
        this.materialTypeName = materialTypeName;
        this.transactionApplicable = transactionApplicable;
        this.isActive = isActive;
    }

    public Integer getMaterialTypeId() {
        return materialTypeId;
    }

    public void setMaterialTypeId(Integer materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    public String getMaterialTypeName() {
        return materialTypeName;
    }

    public void setMaterialTypeName(String materialTypeName) {
        this.materialTypeName = materialTypeName;
    }

    public Character getTransactionApplicable() {
        return transactionApplicable;
    }

    public void setTransactionApplicable(Character transactionApplicable) {
        this.transactionApplicable = transactionApplicable;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<MaterialMaster> getMaterialMasterList() {
        return materialMasterList;
    }

    public void setMaterialMasterList(List<MaterialMaster> materialMasterList) {
        this.materialMasterList = materialMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materialTypeId != null ? materialTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialType)) {
            return false;
        }
        MaterialType other = (MaterialType) object;
        if ((this.materialTypeId == null && other.materialTypeId != null) || (this.materialTypeId != null && !this.materialTypeId.equals(other.materialTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.MaterialType[ materialTypeId=" + materialTypeId + " ]";
    }
    
}
