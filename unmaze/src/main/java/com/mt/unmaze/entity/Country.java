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
@Table(name = "country")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c"),
    @NamedQuery(name = "Country.findByCountryId", query = "SELECT c FROM Country c WHERE c.countryId = :countryId"),
    @NamedQuery(name = "Country.findByCountryName", query = "SELECT c FROM Country c WHERE c.countryName = :countryName"),
    @NamedQuery(name = "Country.findByCountryCode", query = "SELECT c FROM Country c WHERE c.countryCode = :countryCode"),
    @NamedQuery(name = "Country.findByCurrency", query = "SELECT c FROM Country c WHERE c.currency = :currency"),
    @NamedQuery(name = "Country.findByIsActive", query = "SELECT c FROM Country c WHERE c.isActive = :isActive")})
public class Country implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "country_id")
    private Integer countryId;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "country_code")
    private String countryCode;
    @Column(name = "currency")
    private String currency;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @OneToMany(mappedBy = "countryOfSupply")
    private List<PurchaseOrderMaster> purchaseOrderMasterList;
    @OneToMany(mappedBy = "countryId")
    private List<LegalEntityMaster> legalEntityMasterList;
    @OneToMany(mappedBy = "countryId")
    private List<State> stateList;
    @OneToMany(mappedBy = "countryId")
    private List<VendorMaster> vendorMasterList;
    @OneToMany(mappedBy = "countryOfSupply")
    private List<BookingMaster> bookingMasterList;
    @OneToMany(mappedBy = "countryId")
    private List<CustomerMaster> customerMasterList;
    @OneToMany(mappedBy = "countryId")
    private List<BranchMaster> branchMasterList;

    public Country() {
    }

    public Country(Integer countryId) {
        this.countryId = countryId;
    }

    public Country(Integer countryId, Character isActive) {
        this.countryId = countryId;
        this.isActive = isActive;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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
    public List<LegalEntityMaster> getLegalEntityMasterList() {
        return legalEntityMasterList;
    }

    public void setLegalEntityMasterList(List<LegalEntityMaster> legalEntityMasterList) {
        this.legalEntityMasterList = legalEntityMasterList;
    }

    @XmlTransient
    public List<State> getStateList() {
        return stateList;
    }

    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }

    @XmlTransient
    public List<VendorMaster> getVendorMasterList() {
        return vendorMasterList;
    }

    public void setVendorMasterList(List<VendorMaster> vendorMasterList) {
        this.vendorMasterList = vendorMasterList;
    }

    @XmlTransient
    public List<BookingMaster> getBookingMasterList() {
        return bookingMasterList;
    }

    public void setBookingMasterList(List<BookingMaster> bookingMasterList) {
        this.bookingMasterList = bookingMasterList;
    }

    @XmlTransient
    public List<CustomerMaster> getCustomerMasterList() {
        return customerMasterList;
    }

    public void setCustomerMasterList(List<CustomerMaster> customerMasterList) {
        this.customerMasterList = customerMasterList;
    }

    @XmlTransient
    public List<BranchMaster> getBranchMasterList() {
        return branchMasterList;
    }

    public void setBranchMasterList(List<BranchMaster> branchMasterList) {
        this.branchMasterList = branchMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryId != null ? countryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if ((this.countryId == null && other.countryId != null) || (this.countryId != null && !this.countryId.equals(other.countryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.Country[ countryId=" + countryId + " ]";
    }
    
}
