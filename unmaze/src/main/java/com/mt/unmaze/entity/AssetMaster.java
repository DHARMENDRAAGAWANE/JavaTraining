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
@Table(name = "asset_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AssetMaster.findAll", query = "SELECT a FROM AssetMaster a"),
    @NamedQuery(name = "AssetMaster.findByAssetMasterId", query = "SELECT a FROM AssetMaster a WHERE a.assetMasterId = :assetMasterId"),
    @NamedQuery(name = "AssetMaster.findByAssetMasterName", query = "SELECT a FROM AssetMaster a WHERE a.assetMasterName = :assetMasterName"),
    @NamedQuery(name = "AssetMaster.findByCreatedAt", query = "SELECT a FROM AssetMaster a WHERE a.createdAt = :createdAt"),
    @NamedQuery(name = "AssetMaster.findByLastUpdatedAt", query = "SELECT a FROM AssetMaster a WHERE a.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "AssetMaster.findByIsActive", query = "SELECT a FROM AssetMaster a WHERE a.isActive = :isActive"),
    @NamedQuery(name = "AssetMaster.findByIsDeleted", query = "SELECT a FROM AssetMaster a WHERE a.isDeleted = :isDeleted"),
    @NamedQuery(name = "AssetMaster.findByIpAddress", query = "SELECT a FROM AssetMaster a WHERE a.ipAddress = :ipAddress")})
public class AssetMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "asset_master_id")
    private Integer assetMasterId;
    @Basic(optional = false)
    @Column(name = "asset_master_name")
    private String assetMasterName;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "last_updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedAt;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @Basic(optional = false)
    @Column(name = "is_deleted")
    private Character isDeleted;
    @Column(name = "ip_address")
    private String ipAddress;
    @OneToMany(mappedBy = "assetMasterId")
    private List<BookingTagMaster> bookingTagMasterList;
    @JoinColumn(name = "branch_master_id", referencedColumnName = "branch_master_id")
    @ManyToOne
    private BranchMaster branchMasterId;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @OneToMany(mappedBy = "assetMasterId")
    private List<PoTagMaster> poTagMasterList;

    public AssetMaster() {
    }

    public AssetMaster(Integer assetMasterId) {
        this.assetMasterId = assetMasterId;
    }

    public AssetMaster(Integer assetMasterId, String assetMasterName, Character isActive, Character isDeleted) {
        this.assetMasterId = assetMasterId;
        this.assetMasterName = assetMasterName;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
    }

    public Integer getAssetMasterId() {
        return assetMasterId;
    }

    public void setAssetMasterId(Integer assetMasterId) {
        this.assetMasterId = assetMasterId;
    }

    public String getAssetMasterName() {
        return assetMasterName;
    }

    public void setAssetMasterName(String assetMasterName) {
        this.assetMasterName = assetMasterName;
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

    public Character getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Character isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @XmlTransient
    public List<BookingTagMaster> getBookingTagMasterList() {
        return bookingTagMasterList;
    }

    public void setBookingTagMasterList(List<BookingTagMaster> bookingTagMasterList) {
        this.bookingTagMasterList = bookingTagMasterList;
    }

    public BranchMaster getBranchMasterId() {
        return branchMasterId;
    }

    public void setBranchMasterId(BranchMaster branchMasterId) {
        this.branchMasterId = branchMasterId;
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
    public List<PoTagMaster> getPoTagMasterList() {
        return poTagMasterList;
    }

    public void setPoTagMasterList(List<PoTagMaster> poTagMasterList) {
        this.poTagMasterList = poTagMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assetMasterId != null ? assetMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssetMaster)) {
            return false;
        }
        AssetMaster other = (AssetMaster) object;
        if ((this.assetMasterId == null && other.assetMasterId != null) || (this.assetMasterId != null && !this.assetMasterId.equals(other.assetMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.AssetMaster[ assetMasterId=" + assetMasterId + " ]";
    }
    
}
