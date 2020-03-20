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
@Table(name = "sales_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesType.findAll", query = "SELECT s FROM SalesType s"),
    @NamedQuery(name = "SalesType.findBySalesTypeId", query = "SELECT s FROM SalesType s WHERE s.salesTypeId = :salesTypeId"),
    @NamedQuery(name = "SalesType.findBySalesTypeName", query = "SELECT s FROM SalesType s WHERE s.salesTypeName = :salesTypeName"),
    @NamedQuery(name = "SalesType.findByIsActive", query = "SELECT s FROM SalesType s WHERE s.isActive = :isActive")})
public class SalesType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sales_type_id")
    private Integer salesTypeId;
    @Basic(optional = false)
    @Column(name = "sales_type_name")
    private String salesTypeName;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @OneToMany(mappedBy = "salesTypeId")
    private List<BookingMaster> bookingMasterList;

    public SalesType() {
    }

    public SalesType(Integer salesTypeId) {
        this.salesTypeId = salesTypeId;
    }

    public SalesType(Integer salesTypeId, String salesTypeName, Character isActive) {
        this.salesTypeId = salesTypeId;
        this.salesTypeName = salesTypeName;
        this.isActive = isActive;
    }

    public Integer getSalesTypeId() {
        return salesTypeId;
    }

    public void setSalesTypeId(Integer salesTypeId) {
        this.salesTypeId = salesTypeId;
    }

    public String getSalesTypeName() {
        return salesTypeName;
    }

    public void setSalesTypeName(String salesTypeName) {
        this.salesTypeName = salesTypeName;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<BookingMaster> getBookingMasterList() {
        return bookingMasterList;
    }

    public void setBookingMasterList(List<BookingMaster> bookingMasterList) {
        this.bookingMasterList = bookingMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salesTypeId != null ? salesTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesType)) {
            return false;
        }
        SalesType other = (SalesType) object;
        if ((this.salesTypeId == null && other.salesTypeId != null) || (this.salesTypeId != null && !this.salesTypeId.equals(other.salesTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.SalesType[ salesTypeId=" + salesTypeId + " ]";
    }
    
}
