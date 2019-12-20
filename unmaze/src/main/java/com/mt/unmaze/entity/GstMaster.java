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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "gst_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GstMaster.findAll", query = "SELECT g FROM GstMaster g"),
    @NamedQuery(name = "GstMaster.findByGstMasterId", query = "SELECT g FROM GstMaster g WHERE g.gstMasterId = :gstMasterId"),
    @NamedQuery(name = "GstMaster.findByGstNo", query = "SELECT g FROM GstMaster g WHERE g.gstNo = :gstNo"),
    @NamedQuery(name = "GstMaster.findByName", query = "SELECT g FROM GstMaster g WHERE g.name = :name"),
    @NamedQuery(name = "GstMaster.findByValidTill", query = "SELECT g FROM GstMaster g WHERE g.validTill = :validTill"),
    @NamedQuery(name = "GstMaster.findByIsActive", query = "SELECT g FROM GstMaster g WHERE g.isActive = :isActive")})
public class GstMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gst_master_id")
    private Integer gstMasterId;
    @Basic(optional = false)
    @Column(name = "gst_no")
    private String gstNo;
    @Column(name = "name")
    private String name;
    @Column(name = "valid_till")
    @Temporal(TemporalType.DATE)
    private Date validTill;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @OneToMany(mappedBy = "gstId")
    private List<ECommerce> eCommerceList;
    @OneToMany(mappedBy = "gstMasterId")
    private List<LegalEntityMaster> legalEntityMasterList;
    @JoinColumn(name = "pan_master_id", referencedColumnName = "pan_master_id")
    @ManyToOne
    private PanMaster panMasterId;
    @OneToMany(mappedBy = "gstMasterId")
    private List<VendorMaster> vendorMasterList;
    @OneToMany(mappedBy = "gstMasterId")
    private List<CustomerMaster> customerMasterList;
    @OneToMany(mappedBy = "gstMasterId")
    private List<BranchMaster> branchMasterList;

    public GstMaster() {
    }

    public GstMaster(Integer gstMasterId) {
        this.gstMasterId = gstMasterId;
    }

    public GstMaster(Integer gstMasterId, String gstNo, Character isActive) {
        this.gstMasterId = gstMasterId;
        this.gstNo = gstNo;
        this.isActive = isActive;
    }

    public Integer getGstMasterId() {
        return gstMasterId;
    }

    public void setGstMasterId(Integer gstMasterId) {
        this.gstMasterId = gstMasterId;
    }

    public String getGstNo() {
        return gstNo;
    }

    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getValidTill() {
        return validTill;
    }

    public void setValidTill(Date validTill) {
        this.validTill = validTill;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<ECommerce> getECommerceList() {
        return eCommerceList;
    }

    public void setECommerceList(List<ECommerce> eCommerceList) {
        this.eCommerceList = eCommerceList;
    }

    @XmlTransient
    public List<LegalEntityMaster> getLegalEntityMasterList() {
        return legalEntityMasterList;
    }

    public void setLegalEntityMasterList(List<LegalEntityMaster> legalEntityMasterList) {
        this.legalEntityMasterList = legalEntityMasterList;
    }

    public PanMaster getPanMasterId() {
        return panMasterId;
    }

    public void setPanMasterId(PanMaster panMasterId) {
        this.panMasterId = panMasterId;
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
        hash += (gstMasterId != null ? gstMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GstMaster)) {
            return false;
        }
        GstMaster other = (GstMaster) object;
        if ((this.gstMasterId == null && other.gstMasterId != null) || (this.gstMasterId != null && !this.gstMasterId.equals(other.gstMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.GstMaster[ gstMasterId=" + gstMasterId + " ]";
    }
    
}
