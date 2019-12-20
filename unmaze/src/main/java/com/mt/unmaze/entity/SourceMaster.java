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
@Table(name = "source_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SourceMaster.findAll", query = "SELECT s FROM SourceMaster s"),
    @NamedQuery(name = "SourceMaster.findBySourceMasterId", query = "SELECT s FROM SourceMaster s WHERE s.sourceMasterId = :sourceMasterId"),
    @NamedQuery(name = "SourceMaster.findBySourceMasterName", query = "SELECT s FROM SourceMaster s WHERE s.sourceMasterName = :sourceMasterName"),
    @NamedQuery(name = "SourceMaster.findByCost", query = "SELECT s FROM SourceMaster s WHERE s.cost = :cost"),
    @NamedQuery(name = "SourceMaster.findByCreatedAt", query = "SELECT s FROM SourceMaster s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "SourceMaster.findByLastUpdatedAt", query = "SELECT s FROM SourceMaster s WHERE s.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "SourceMaster.findByIsActive", query = "SELECT s FROM SourceMaster s WHERE s.isActive = :isActive"),
    @NamedQuery(name = "SourceMaster.findByIsDeleted", query = "SELECT s FROM SourceMaster s WHERE s.isDeleted = :isDeleted"),
    @NamedQuery(name = "SourceMaster.findByIpAddress", query = "SELECT s FROM SourceMaster s WHERE s.ipAddress = :ipAddress")})
public class SourceMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "source_master_id")
    private Integer sourceMasterId;
    @Basic(optional = false)
    @Column(name = "source_master_name")
    private String sourceMasterName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost")
    private Double cost;
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
    @Basic(optional = false)
    @Column(name = "is_deleted")
    private Character isDeleted;
    @Column(name = "ip_address")
    private String ipAddress;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @OneToMany(mappedBy = "sourceMasterId")
    private List<BookingTagMaster> bookingTagMasterList;
    @OneToMany(mappedBy = "sourceMasterId")
    private List<CustomerMaster> customerMasterList;
    @OneToMany(mappedBy = "sourceMasterId")
    private List<PoTagMaster> poTagMasterList;

    public SourceMaster() {
    }

    public SourceMaster(Integer sourceMasterId) {
        this.sourceMasterId = sourceMasterId;
    }

    public SourceMaster(Integer sourceMasterId, String sourceMasterName, Date lastUpdatedAt, Character isActive, Character isDeleted) {
        this.sourceMasterId = sourceMasterId;
        this.sourceMasterName = sourceMasterName;
        this.lastUpdatedAt = lastUpdatedAt;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
    }

    public Integer getSourceMasterId() {
        return sourceMasterId;
    }

    public void setSourceMasterId(Integer sourceMasterId) {
        this.sourceMasterId = sourceMasterId;
    }

    public String getSourceMasterName() {
        return sourceMasterName;
    }

    public void setSourceMasterName(String sourceMasterName) {
        this.sourceMasterName = sourceMasterName;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
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

    public UserMaster getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(UserMaster lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public UserMaster getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserMaster createdBy) {
        this.createdBy = createdBy;
    }

    @XmlTransient
    public List<BookingTagMaster> getBookingTagMasterList() {
        return bookingTagMasterList;
    }

    public void setBookingTagMasterList(List<BookingTagMaster> bookingTagMasterList) {
        this.bookingTagMasterList = bookingTagMasterList;
    }

    @XmlTransient
    public List<CustomerMaster> getCustomerMasterList() {
        return customerMasterList;
    }

    public void setCustomerMasterList(List<CustomerMaster> customerMasterList) {
        this.customerMasterList = customerMasterList;
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
        hash += (sourceMasterId != null ? sourceMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SourceMaster)) {
            return false;
        }
        SourceMaster other = (SourceMaster) object;
        if ((this.sourceMasterId == null && other.sourceMasterId != null) || (this.sourceMasterId != null && !this.sourceMasterId.equals(other.sourceMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.SourceMaster[ sourceMasterId=" + sourceMasterId + " ]";
    }
    
}
