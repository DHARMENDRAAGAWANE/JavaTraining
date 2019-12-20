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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "state")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "State.findAll", query = "SELECT s FROM State s"),
    @NamedQuery(name = "State.findByStateId", query = "SELECT s FROM State s WHERE s.stateId = :stateId"),
    @NamedQuery(name = "State.findByStateName", query = "SELECT s FROM State s WHERE s.stateName = :stateName"),
    @NamedQuery(name = "State.findByIsActive", query = "SELECT s FROM State s WHERE s.isActive = :isActive")})
public class State implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "state_id")
    private Integer stateId;
    @Column(name = "state_name")
    private String stateName;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @OneToMany(mappedBy = "stateOfSupply")
    private List<PurchaseOrderMaster> purchaseOrderMasterList;
    @OneToMany(mappedBy = "stateId")
    private List<LegalEntityMaster> legalEntityMasterList;
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    @ManyToOne
    private Country countryId;
    @OneToMany(mappedBy = "stateId")
    private List<City> cityList;
    @OneToMany(mappedBy = "stateId")
    private List<VendorMaster> vendorMasterList;
    @OneToMany(mappedBy = "stateOfSupply")
    private List<BookingMaster> bookingMasterList;
    @OneToMany(mappedBy = "stateId")
    private List<CustomerMaster> customerMasterList;
    @OneToMany(mappedBy = "stateId")
    private List<BranchMaster> branchMasterList;

    public State() {
    }

    public State(Integer stateId) {
        this.stateId = stateId;
    }

    public State(Integer stateId, Character isActive) {
        this.stateId = stateId;
        this.isActive = isActive;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
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

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    @XmlTransient
    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
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
        hash += (stateId != null ? stateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof State)) {
            return false;
        }
        State other = (State) object;
        if ((this.stateId == null && other.stateId != null) || (this.stateId != null && !this.stateId.equals(other.stateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.State[ stateId=" + stateId + " ]";
    }
    
}
