/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mt.unmaze.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "pan_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PanMaster.findAll", query = "SELECT p FROM PanMaster p"),
    @NamedQuery(name = "PanMaster.findByPanMasterId", query = "SELECT p FROM PanMaster p WHERE p.panMasterId = :panMasterId"),
    @NamedQuery(name = "PanMaster.findByPanNo", query = "SELECT p FROM PanMaster p WHERE p.panNo = :panNo"),
    @NamedQuery(name = "PanMaster.findByName", query = "SELECT p FROM PanMaster p WHERE p.name = :name"),
    @NamedQuery(name = "PanMaster.findByDob", query = "SELECT p FROM PanMaster p WHERE p.dob = :dob"),
    @NamedQuery(name = "PanMaster.findByIsActive", query = "SELECT p FROM PanMaster p WHERE p.isActive = :isActive")})
public class PanMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pan_master_id")
    private Integer panMasterId;
    @Basic(optional = false)
    @Column(name = "pan_no")
    private String panNo;
    @Column(name = "name")
    private String name;
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @OneToMany(mappedBy = "panMasterId")
    private List<LegalEntityMaster> legalEntityMasterList;
    @OneToMany(mappedBy = "panMasterId")
    private List<GstMaster> gstMasterList;
    @OneToMany(mappedBy = "panMasterId")
    private List<VendorMaster> vendorMasterList;
    @OneToMany(mappedBy = "panMasterId")
    private List<CustomerMaster> customerMasterList;

    public PanMaster() {
    }

    public PanMaster(Integer panMasterId) {
        this.panMasterId = panMasterId;
    }

    public PanMaster(Integer panMasterId, String panNo, Character isActive) {
        this.panMasterId = panMasterId;
        this.panNo = panNo;
        this.isActive = isActive;
    }

    public Integer getPanMasterId() {
        return panMasterId;
    }

    public void setPanMasterId(Integer panMasterId) {
        this.panMasterId = panMasterId;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<LegalEntityMaster> getLegalEntityMasterList() {
        return legalEntityMasterList;
    }

    public void setLegalEntityMasterList(List<LegalEntityMaster> legalEntityMasterList) {
        this.legalEntityMasterList = legalEntityMasterList;
    }

    @XmlTransient
    public List<GstMaster> getGstMasterList() {
        return gstMasterList;
    }

    public void setGstMasterList(List<GstMaster> gstMasterList) {
        this.gstMasterList = gstMasterList;
    }

    @XmlTransient
    public List<VendorMaster> getVendorMasterList() {
        return vendorMasterList;
    }

    public void setVendorMasterList(List<VendorMaster> vendorMasterList) {
        this.vendorMasterList = vendorMasterList;
    }

    @XmlTransient
    public List<CustomerMaster> getCustomerMasterList() {
        return customerMasterList;
    }

    public void setCustomerMasterList(List<CustomerMaster> customerMasterList) {
        this.customerMasterList = customerMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (panMasterId != null ? panMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PanMaster)) {
            return false;
        }
        PanMaster other = (PanMaster) object;
        if ((this.panMasterId == null && other.panMasterId != null) || (this.panMasterId != null && !this.panMasterId.equals(other.panMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.PanMaster[ panMasterId=" + panMasterId + " ]";
    }
    
}
