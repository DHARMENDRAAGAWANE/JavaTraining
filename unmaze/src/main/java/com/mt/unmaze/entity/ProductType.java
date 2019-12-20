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
@Table(name = "product_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductType.findAll", query = "SELECT p FROM ProductType p"),
    @NamedQuery(name = "ProductType.findByProductTypeId", query = "SELECT p FROM ProductType p WHERE p.productTypeId = :productTypeId"),
    @NamedQuery(name = "ProductType.findByProductTypeName", query = "SELECT p FROM ProductType p WHERE p.productTypeName = :productTypeName"),
    @NamedQuery(name = "ProductType.findByIsActive", query = "SELECT p FROM ProductType p WHERE p.isActive = :isActive")})
public class ProductType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "product_type_id")
    private Integer productTypeId;
    @Basic(optional = false)
    @Column(name = "product_type_name")
    private String productTypeName;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productTypeId")
    private List<PurchaseOrderMaster> purchaseOrderMasterList;
    @OneToMany(mappedBy = "productTypeId")
    private List<PurchaseOrderDetail> purchaseOrderDetailList;
    @OneToMany(mappedBy = "productTypeId")
    private List<BookingDetail> bookingDetailList;

    public ProductType() {
    }

    public ProductType(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public ProductType(Integer productTypeId, String productTypeName, Character isActive) {
        this.productTypeId = productTypeId;
        this.productTypeName = productTypeName;
        this.isActive = isActive;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
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

    @XmlTransient
    public List<PurchaseOrderDetail> getPurchaseOrderDetailList() {
        return purchaseOrderDetailList;
    }

    public void setPurchaseOrderDetailList(List<PurchaseOrderDetail> purchaseOrderDetailList) {
        this.purchaseOrderDetailList = purchaseOrderDetailList;
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
        hash += (productTypeId != null ? productTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductType)) {
            return false;
        }
        ProductType other = (ProductType) object;
        if ((this.productTypeId == null && other.productTypeId != null) || (this.productTypeId != null && !this.productTypeId.equals(other.productTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.ProductType[ productTypeId=" + productTypeId + " ]";
    }
    
}
