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
@Table(name = "cess_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CessType.findAll", query = "SELECT c FROM CessType c"),
    @NamedQuery(name = "CessType.findByCessTypeId", query = "SELECT c FROM CessType c WHERE c.cessTypeId = :cessTypeId"),
    @NamedQuery(name = "CessType.findByCessTypeName", query = "SELECT c FROM CessType c WHERE c.cessTypeName = :cessTypeName"),
    @NamedQuery(name = "CessType.findByIsActive", query = "SELECT c FROM CessType c WHERE c.isActive = :isActive")})
public class CessType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cess_type_id")
    private Integer cessTypeId;
    @Basic(optional = false)
    @Column(name = "cess_type_name")
    private String cessTypeName;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @OneToMany(mappedBy = "cessTypeId")
    private List<PurchaseOrderDetail> purchaseOrderDetailList;
    @OneToMany(mappedBy = "cessTypeId")
    private List<ServiceMaster> serviceMasterList;
    @OneToMany(mappedBy = "cessTypeId")
    private List<MaterialMaster> materialMasterList;
    @OneToMany(mappedBy = "cessTypeId")
    private List<BookingDetail> bookingDetailList;

    public CessType() {
    }

    public CessType(Integer cessTypeId) {
        this.cessTypeId = cessTypeId;
    }

    public CessType(Integer cessTypeId, String cessTypeName, Character isActive) {
        this.cessTypeId = cessTypeId;
        this.cessTypeName = cessTypeName;
        this.isActive = isActive;
    }

    public Integer getCessTypeId() {
        return cessTypeId;
    }

    public void setCessTypeId(Integer cessTypeId) {
        this.cessTypeId = cessTypeId;
    }

    public String getCessTypeName() {
        return cessTypeName;
    }

    public void setCessTypeName(String cessTypeName) {
        this.cessTypeName = cessTypeName;
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

    @XmlTransient
    public List<BookingDetail> getBookingDetailList() {
        return bookingDetailList;
    }

    public void setBookingDetailList(List<BookingDetail> bookingDetailList) {
        this.bookingDetailList = bookingDetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cessTypeId != null ? cessTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CessType)) {
            return false;
        }
        CessType other = (CessType) object;
        if ((this.cessTypeId == null && other.cessTypeId != null) || (this.cessTypeId != null && !this.cessTypeId.equals(other.cessTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.CessType[ cessTypeId=" + cessTypeId + " ]";
    }
    
}
