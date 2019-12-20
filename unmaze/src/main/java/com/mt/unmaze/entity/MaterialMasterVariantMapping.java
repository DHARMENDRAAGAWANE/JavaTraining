/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mt.unmaze.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "material_master_variant_mapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialMasterVariantMapping.findAll", query = "SELECT m FROM MaterialMasterVariantMapping m"),
    @NamedQuery(name = "MaterialMasterVariantMapping.findByMaterialMasterVariantMappingId", query = "SELECT m FROM MaterialMasterVariantMapping m WHERE m.materialMasterVariantMappingId = :materialMasterVariantMappingId"),
    @NamedQuery(name = "MaterialMasterVariantMapping.findByIsActive", query = "SELECT m FROM MaterialMasterVariantMapping m WHERE m.isActive = :isActive")})
public class MaterialMasterVariantMapping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "material_master_variant_mapping_id")
    private Integer materialMasterVariantMappingId;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @JoinColumn(name = "material_master_id", referencedColumnName = "material_master_id")
    @ManyToOne(optional = false)
    private MaterialMaster materialMasterId;
    @JoinColumn(name = "material_variant_value_id", referencedColumnName = "material_variant_value_id")
    @ManyToOne(optional = false)
    private MaterialVariantValue materialVariantValueId;

    public MaterialMasterVariantMapping() {
    }

    public MaterialMasterVariantMapping(Integer materialMasterVariantMappingId) {
        this.materialMasterVariantMappingId = materialMasterVariantMappingId;
    }

    public MaterialMasterVariantMapping(Integer materialMasterVariantMappingId, Character isActive) {
        this.materialMasterVariantMappingId = materialMasterVariantMappingId;
        this.isActive = isActive;
    }

    public Integer getMaterialMasterVariantMappingId() {
        return materialMasterVariantMappingId;
    }

    public void setMaterialMasterVariantMappingId(Integer materialMasterVariantMappingId) {
        this.materialMasterVariantMappingId = materialMasterVariantMappingId;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    public MaterialMaster getMaterialMasterId() {
        return materialMasterId;
    }

    public void setMaterialMasterId(MaterialMaster materialMasterId) {
        this.materialMasterId = materialMasterId;
    }

    public MaterialVariantValue getMaterialVariantValueId() {
        return materialVariantValueId;
    }

    public void setMaterialVariantValueId(MaterialVariantValue materialVariantValueId) {
        this.materialVariantValueId = materialVariantValueId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materialMasterVariantMappingId != null ? materialMasterVariantMappingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialMasterVariantMapping)) {
            return false;
        }
        MaterialMasterVariantMapping other = (MaterialMasterVariantMapping) object;
        if ((this.materialMasterVariantMappingId == null && other.materialMasterVariantMappingId != null) || (this.materialMasterVariantMappingId != null && !this.materialMasterVariantMappingId.equals(other.materialMasterVariantMappingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.MaterialMasterVariantMapping[ materialMasterVariantMappingId=" + materialMasterVariantMappingId + " ]";
    }
    
}
