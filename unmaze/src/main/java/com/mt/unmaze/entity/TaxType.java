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
@Table(name = "tax_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaxType.findAll", query = "SELECT t FROM TaxType t"),
    @NamedQuery(name = "TaxType.findByTaxTypeId", query = "SELECT t FROM TaxType t WHERE t.taxTypeId = :taxTypeId"),
    @NamedQuery(name = "TaxType.findByTaxTypeName", query = "SELECT t FROM TaxType t WHERE t.taxTypeName = :taxTypeName"),
    @NamedQuery(name = "TaxType.findByIsActive", query = "SELECT t FROM TaxType t WHERE t.isActive = :isActive")})
public class TaxType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tax_type_id")
    private Integer taxTypeId;
    @Basic(optional = false)
    @Column(name = "tax_type_name")
    private String taxTypeName;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @OneToMany(mappedBy = "taxTypeId")
    private List<ServiceMaster> serviceMasterList;
    @OneToMany(mappedBy = "taxTypeId")
    private List<MaterialMaster> materialMasterList;

    public TaxType() {
    }

    public TaxType(Integer taxTypeId) {
        this.taxTypeId = taxTypeId;
    }

    public TaxType(Integer taxTypeId, String taxTypeName, Character isActive) {
        this.taxTypeId = taxTypeId;
        this.taxTypeName = taxTypeName;
        this.isActive = isActive;
    }

    public Integer getTaxTypeId() {
        return taxTypeId;
    }

    public void setTaxTypeId(Integer taxTypeId) {
        this.taxTypeId = taxTypeId;
    }

    public String getTaxTypeName() {
        return taxTypeName;
    }

    public void setTaxTypeName(String taxTypeName) {
        this.taxTypeName = taxTypeName;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<ServiceMaster> getServiceMasterList() {
        return serviceMasterList;
    }

    public void setServiceMasterList(List<ServiceMaster> serviceMasterList) {
        this.serviceMasterList = serviceMasterList;
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
        hash += (taxTypeId != null ? taxTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxType)) {
            return false;
        }
        TaxType other = (TaxType) object;
        if ((this.taxTypeId == null && other.taxTypeId != null) || (this.taxTypeId != null && !this.taxTypeId.equals(other.taxTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.TaxType[ taxTypeId=" + taxTypeId + " ]";
    }
    
}
