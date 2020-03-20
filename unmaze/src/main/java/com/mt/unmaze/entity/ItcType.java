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
@Table(name = "itc_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItcType.findAll", query = "SELECT i FROM ItcType i"),
    @NamedQuery(name = "ItcType.findByItcTypeId", query = "SELECT i FROM ItcType i WHERE i.itcTypeId = :itcTypeId"),
    @NamedQuery(name = "ItcType.findByItcTypeName", query = "SELECT i FROM ItcType i WHERE i.itcTypeName = :itcTypeName"),
    @NamedQuery(name = "ItcType.findByIsActive", query = "SELECT i FROM ItcType i WHERE i.isActive = :isActive")})
public class ItcType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "itc_type_id")
    private Integer itcTypeId;
    @Basic(optional = false)
    @Column(name = "itc_type_name")
    private String itcTypeName;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @OneToMany(mappedBy = "itcTypeId")
    private List<PurchaseOrderDetail> purchaseOrderDetailList;
    @OneToMany(mappedBy = "itcTypeId")
    private List<MaterialMaster> materialMasterList;

    public ItcType() {
    }

    public ItcType(Integer itcTypeId) {
        this.itcTypeId = itcTypeId;
    }

    public ItcType(Integer itcTypeId, String itcTypeName, Character isActive) {
        this.itcTypeId = itcTypeId;
        this.itcTypeName = itcTypeName;
        this.isActive = isActive;
    }

    public Integer getItcTypeId() {
        return itcTypeId;
    }

    public void setItcTypeId(Integer itcTypeId) {
        this.itcTypeId = itcTypeId;
    }

    public String getItcTypeName() {
        return itcTypeName;
    }

    public void setItcTypeName(String itcTypeName) {
        this.itcTypeName = itcTypeName;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<PurchaseOrderDetail> getPurchaseOrderDetailList() {
        return purchaseOrderDetailList;
    }

    public void setPurchaseOrderDetailList(List<PurchaseOrderDetail> purchaseOrderDetailList) {
        this.purchaseOrderDetailList = purchaseOrderDetailList;
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
        hash += (itcTypeId != null ? itcTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItcType)) {
            return false;
        }
        ItcType other = (ItcType) object;
        if ((this.itcTypeId == null && other.itcTypeId != null) || (this.itcTypeId != null && !this.itcTypeId.equals(other.itcTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.ItcType[ itcTypeId=" + itcTypeId + " ]";
    }
    
}
