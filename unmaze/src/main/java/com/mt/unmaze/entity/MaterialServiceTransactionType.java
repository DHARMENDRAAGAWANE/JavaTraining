/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mt.unmaze.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "material_service_transaction_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialServiceTransactionType.findAll", query = "SELECT m FROM MaterialServiceTransactionType m"),
    @NamedQuery(name = "MaterialServiceTransactionType.findByMaterialServiceTransactionTypeId", query = "SELECT m FROM MaterialServiceTransactionType m WHERE m.materialServiceTransactionTypeId = :materialServiceTransactionTypeId"),
    @NamedQuery(name = "MaterialServiceTransactionType.findByMaterialServiceTransactionTypeName", query = "SELECT m FROM MaterialServiceTransactionType m WHERE m.materialServiceTransactionTypeName = :materialServiceTransactionTypeName"),
    @NamedQuery(name = "MaterialServiceTransactionType.findByIsActive", query = "SELECT m FROM MaterialServiceTransactionType m WHERE m.isActive = :isActive")})
public class MaterialServiceTransactionType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "material_service_transaction_type_id")
    private Integer materialServiceTransactionTypeId;
    @Basic(optional = false)
    @Column(name = "material_service_transaction_type_name")
    private String materialServiceTransactionTypeName;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialTransactionTypeId")
    private List<MaterialTransactionMaster> materialTransactionMasterList;

    public MaterialServiceTransactionType() {
    }

    public MaterialServiceTransactionType(Integer materialServiceTransactionTypeId) {
        this.materialServiceTransactionTypeId = materialServiceTransactionTypeId;
    }

    public MaterialServiceTransactionType(Integer materialServiceTransactionTypeId, String materialServiceTransactionTypeName, Character isActive) {
        this.materialServiceTransactionTypeId = materialServiceTransactionTypeId;
        this.materialServiceTransactionTypeName = materialServiceTransactionTypeName;
        this.isActive = isActive;
    }

    public Integer getMaterialServiceTransactionTypeId() {
        return materialServiceTransactionTypeId;
    }

    public void setMaterialServiceTransactionTypeId(Integer materialServiceTransactionTypeId) {
        this.materialServiceTransactionTypeId = materialServiceTransactionTypeId;
    }

    public String getMaterialServiceTransactionTypeName() {
        return materialServiceTransactionTypeName;
    }

    public void setMaterialServiceTransactionTypeName(String materialServiceTransactionTypeName) {
        this.materialServiceTransactionTypeName = materialServiceTransactionTypeName;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<MaterialTransactionMaster> getMaterialTransactionMasterList() {
        return materialTransactionMasterList;
    }

    public void setMaterialTransactionMasterList(List<MaterialTransactionMaster> materialTransactionMasterList) {
        this.materialTransactionMasterList = materialTransactionMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materialServiceTransactionTypeId != null ? materialServiceTransactionTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialServiceTransactionType)) {
            return false;
        }
        MaterialServiceTransactionType other = (MaterialServiceTransactionType) object;
        if ((this.materialServiceTransactionTypeId == null && other.materialServiceTransactionTypeId != null) || (this.materialServiceTransactionTypeId != null && !this.materialServiceTransactionTypeId.equals(other.materialServiceTransactionTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.MaterialServiceTransactionType[ materialServiceTransactionTypeId=" + materialServiceTransactionTypeId + " ]";
    }
    
}
