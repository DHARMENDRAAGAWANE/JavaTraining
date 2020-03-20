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
@Table(name = "e_commerce")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ECommerce.findAll", query = "SELECT e FROM ECommerce e"),
    @NamedQuery(name = "ECommerce.findByECommerceId", query = "SELECT e FROM ECommerce e WHERE e.eCommerceId = :eCommerceId"),
    @NamedQuery(name = "ECommerce.findByECommerceName", query = "SELECT e FROM ECommerce e WHERE e.eCommerceName = :eCommerceName"),
    @NamedQuery(name = "ECommerce.findByCommissionRate", query = "SELECT e FROM ECommerce e WHERE e.commissionRate = :commissionRate"),
    @NamedQuery(name = "ECommerce.findByCreatedAt", query = "SELECT e FROM ECommerce e WHERE e.createdAt = :createdAt"),
    @NamedQuery(name = "ECommerce.findByLastUpdatedAt", query = "SELECT e FROM ECommerce e WHERE e.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "ECommerce.findByIsActive", query = "SELECT e FROM ECommerce e WHERE e.isActive = :isActive"),
    @NamedQuery(name = "ECommerce.findByIsDeleted", query = "SELECT e FROM ECommerce e WHERE e.isDeleted = :isDeleted"),
    @NamedQuery(name = "ECommerce.findByIpAddress", query = "SELECT e FROM ECommerce e WHERE e.ipAddress = :ipAddress")})
public class ECommerce implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "e_commerce_id")
    private Integer eCommerceId;
    @Basic(optional = false)
    @Column(name = "e_commerce_name")
    private String eCommerceName;
    @Column(name = "commission_rate")
    private Integer commissionRate;
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
    @JoinColumn(name = "gst_id", referencedColumnName = "gst_master_id")
    @ManyToOne
    private GstMaster gstId;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @OneToMany(mappedBy = "eCommerceId")
    private List<BookingTagMaster> bookingTagMasterList;

    public ECommerce() {
    }

    public ECommerce(Integer eCommerceId) {
        this.eCommerceId = eCommerceId;
    }

    public ECommerce(Integer eCommerceId, String eCommerceName, Character isActive, Character isDeleted) {
        this.eCommerceId = eCommerceId;
        this.eCommerceName = eCommerceName;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
    }

    public Integer getECommerceId() {
        return eCommerceId;
    }

    public void setECommerceId(Integer eCommerceId) {
        this.eCommerceId = eCommerceId;
    }

    public String getECommerceName() {
        return eCommerceName;
    }

    public void setECommerceName(String eCommerceName) {
        this.eCommerceName = eCommerceName;
    }

    public Integer getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Integer commissionRate) {
        this.commissionRate = commissionRate;
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

    public GstMaster getGstId() {
        return gstId;
    }

    public void setGstId(GstMaster gstId) {
        this.gstId = gstId;
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
    public List<BookingTagMaster> getBookingTagMasterList() {
        return bookingTagMasterList;
    }

    public void setBookingTagMasterList(List<BookingTagMaster> bookingTagMasterList) {
        this.bookingTagMasterList = bookingTagMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eCommerceId != null ? eCommerceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ECommerce)) {
            return false;
        }
        ECommerce other = (ECommerce) object;
        if ((this.eCommerceId == null && other.eCommerceId != null) || (this.eCommerceId != null && !this.eCommerceId.equals(other.eCommerceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.ECommerce[ eCommerceId=" + eCommerceId + " ]";
    }
    
}
