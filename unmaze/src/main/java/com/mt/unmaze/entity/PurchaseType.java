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
@Table(name = "purchase_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseType.findAll", query = "SELECT p FROM PurchaseType p"),
    @NamedQuery(name = "PurchaseType.findByPurchaseTypeId", query = "SELECT p FROM PurchaseType p WHERE p.purchaseTypeId = :purchaseTypeId"),
    @NamedQuery(name = "PurchaseType.findByPurchaseTypeName", query = "SELECT p FROM PurchaseType p WHERE p.purchaseTypeName = :purchaseTypeName"),
    @NamedQuery(name = "PurchaseType.findByIsActive", query = "SELECT p FROM PurchaseType p WHERE p.isActive = :isActive")})
public class PurchaseType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "purchase_type_id")
    private Integer purchaseTypeId;
    @Basic(optional = false)
    @Column(name = "purchase_type_name")
    private String purchaseTypeName;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseTypeId")
    private List<PurchaseOrderMaster> purchaseOrderMasterList;

    public PurchaseType() {
    }

    public PurchaseType(Integer purchaseTypeId) {
        this.purchaseTypeId = purchaseTypeId;
    }

    public PurchaseType(Integer purchaseTypeId, String purchaseTypeName, Character isActive) {
        this.purchaseTypeId = purchaseTypeId;
        this.purchaseTypeName = purchaseTypeName;
        this.isActive = isActive;
    }

    public Integer getPurchaseTypeId() {
        return purchaseTypeId;
    }

    public void setPurchaseTypeId(Integer purchaseTypeId) {
        this.purchaseTypeId = purchaseTypeId;
    }

    public String getPurchaseTypeName() {
        return purchaseTypeName;
    }

    public void setPurchaseTypeName(String purchaseTypeName) {
        this.purchaseTypeName = purchaseTypeName;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<PurchaseOrderMaster> getPurchaseOrderMasterList() {
        return purchaseOrderMasterList;
    }

    public void setPurchaseOrderMasterList(List<PurchaseOrderMaster> purchaseOrderMasterList) {
        this.purchaseOrderMasterList = purchaseOrderMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchaseTypeId != null ? purchaseTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseType)) {
            return false;
        }
        PurchaseType other = (PurchaseType) object;
        if ((this.purchaseTypeId == null && other.purchaseTypeId != null) || (this.purchaseTypeId != null && !this.purchaseTypeId.equals(other.purchaseTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.PurchaseType[ purchaseTypeId=" + purchaseTypeId + " ]";
    }
    
}
