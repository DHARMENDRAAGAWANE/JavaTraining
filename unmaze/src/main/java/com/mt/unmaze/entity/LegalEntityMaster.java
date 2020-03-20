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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "legal_entity_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LegalEntityMaster.findAll", query = "SELECT l FROM LegalEntityMaster l"),
    @NamedQuery(name = "LegalEntityMaster.findByLegalEntityMasterId", query = "SELECT l FROM LegalEntityMaster l WHERE l.legalEntityMasterId = :legalEntityMasterId"),
    @NamedQuery(name = "LegalEntityMaster.findByLegalEntityMasterName", query = "SELECT l FROM LegalEntityMaster l WHERE l.legalEntityMasterName = :legalEntityMasterName"),
    @NamedQuery(name = "LegalEntityMaster.findByAddress", query = "SELECT l FROM LegalEntityMaster l WHERE l.address = :address"),
    @NamedQuery(name = "LegalEntityMaster.findByPincode", query = "SELECT l FROM LegalEntityMaster l WHERE l.pincode = :pincode"),
    @NamedQuery(name = "LegalEntityMaster.findByCreatedAt", query = "SELECT l FROM LegalEntityMaster l WHERE l.createdAt = :createdAt"),
    @NamedQuery(name = "LegalEntityMaster.findByLastUpdatedAt", query = "SELECT l FROM LegalEntityMaster l WHERE l.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "LegalEntityMaster.findByIsActive", query = "SELECT l FROM LegalEntityMaster l WHERE l.isActive = :isActive"),
    @NamedQuery(name = "LegalEntityMaster.findByIpAddress", query = "SELECT l FROM LegalEntityMaster l WHERE l.ipAddress = :ipAddress")})
public class LegalEntityMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "legal_entity_master_id")
    private Integer legalEntityMasterId;
    @Basic(optional = false)
    @Column(name = "legal_entity_master_name")
    private String legalEntityMasterName;
    @Column(name = "address")
    private String address;
    @Column(name = "pincode")
    private Integer pincode;
    @Lob
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "last_updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedAt;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @Column(name = "ip_address")
    private String ipAddress;
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    @ManyToOne
    private Country countryId;
    @JoinColumn(name = "gst_master_id", referencedColumnName = "gst_master_id")
    @ManyToOne
    private GstMaster gstMasterId;
    @JoinColumn(name = "pan_master_id", referencedColumnName = "pan_master_id")
    @ManyToOne
    private PanMaster panMasterId;
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    @ManyToOne
    private State stateId;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "legalEntityMasterId")
    private List<BranchMaster> branchMasterList;

    public LegalEntityMaster() {
    }

    public LegalEntityMaster(Integer legalEntityMasterId) {
        this.legalEntityMasterId = legalEntityMasterId;
    }

    public LegalEntityMaster(Integer legalEntityMasterId, String legalEntityMasterName, Date lastUpdatedAt, Character isActive) {
        this.legalEntityMasterId = legalEntityMasterId;
        this.legalEntityMasterName = legalEntityMasterName;
        this.lastUpdatedAt = lastUpdatedAt;
        this.isActive = isActive;
    }

    public Integer getLegalEntityMasterId() {
        return legalEntityMasterId;
    }

    public void setLegalEntityMasterId(Integer legalEntityMasterId) {
        this.legalEntityMasterId = legalEntityMasterId;
    }

    public String getLegalEntityMasterName() {
        return legalEntityMasterName;
    }

    public void setLegalEntityMasterName(String legalEntityMasterName) {
        this.legalEntityMasterName = legalEntityMasterName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    public GstMaster getGstMasterId() {
        return gstMasterId;
    }

    public void setGstMasterId(GstMaster gstMasterId) {
        this.gstMasterId = gstMasterId;
    }

    public PanMaster getPanMasterId() {
        return panMasterId;
    }

    public void setPanMasterId(PanMaster panMasterId) {
        this.panMasterId = panMasterId;
    }

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
    }

    public UserMaster getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserMaster createdBy) {
        this.createdBy = createdBy;
    }

    public UserMaster getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(UserMaster lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
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
        hash += (legalEntityMasterId != null ? legalEntityMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LegalEntityMaster)) {
            return false;
        }
        LegalEntityMaster other = (LegalEntityMaster) object;
        if ((this.legalEntityMasterId == null && other.legalEntityMasterId != null) || (this.legalEntityMasterId != null && !this.legalEntityMasterId.equals(other.legalEntityMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.LegalEntityMaster[ legalEntityMasterId=" + legalEntityMasterId + " ]";
    }
    
}
