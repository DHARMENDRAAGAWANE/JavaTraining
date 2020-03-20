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
@Table(name = "tds_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TdsType.findAll", query = "SELECT t FROM TdsType t"),
    @NamedQuery(name = "TdsType.findByTdsTypeId", query = "SELECT t FROM TdsType t WHERE t.tdsTypeId = :tdsTypeId"),
    @NamedQuery(name = "TdsType.findByTdsSection", query = "SELECT t FROM TdsType t WHERE t.tdsSection = :tdsSection"),
    @NamedQuery(name = "TdsType.findByTdsName", query = "SELECT t FROM TdsType t WHERE t.tdsName = :tdsName"),
    @NamedQuery(name = "TdsType.findByTdsPercent", query = "SELECT t FROM TdsType t WHERE t.tdsPercent = :tdsPercent"),
    @NamedQuery(name = "TdsType.findByRemarks", query = "SELECT t FROM TdsType t WHERE t.remarks = :remarks"),
    @NamedQuery(name = "TdsType.findByCreatedAt", query = "SELECT t FROM TdsType t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "TdsType.findByLastUpdatedAt", query = "SELECT t FROM TdsType t WHERE t.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "TdsType.findByIsActive", query = "SELECT t FROM TdsType t WHERE t.isActive = :isActive"),
    @NamedQuery(name = "TdsType.findByIsDeleted", query = "SELECT t FROM TdsType t WHERE t.isDeleted = :isDeleted"),
    @NamedQuery(name = "TdsType.findByIpAddress", query = "SELECT t FROM TdsType t WHERE t.ipAddress = :ipAddress")})
public class TdsType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tds_type_id")
    private Integer tdsTypeId;
    @Basic(optional = false)
    @Column(name = "tds_section")
    private String tdsSection;
    @Column(name = "tds_name")
    private String tdsName;
    @Column(name = "tds_percent")
    private Integer tdsPercent;
    @Column(name = "remarks")
    private String remarks;
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
    @OneToMany(mappedBy = "tdsTypeId")
    private List<TdsMaster> tdsMasterList;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @OneToMany(mappedBy = "tdsTypeId")
    private List<PayRequest> payRequestList;

    public TdsType() {
    }

    public TdsType(Integer tdsTypeId) {
        this.tdsTypeId = tdsTypeId;
    }

    public TdsType(Integer tdsTypeId, String tdsSection, Character isActive, Character isDeleted) {
        this.tdsTypeId = tdsTypeId;
        this.tdsSection = tdsSection;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
    }

    public Integer getTdsTypeId() {
        return tdsTypeId;
    }

    public void setTdsTypeId(Integer tdsTypeId) {
        this.tdsTypeId = tdsTypeId;
    }

    public String getTdsSection() {
        return tdsSection;
    }

    public void setTdsSection(String tdsSection) {
        this.tdsSection = tdsSection;
    }

    public String getTdsName() {
        return tdsName;
    }

    public void setTdsName(String tdsName) {
        this.tdsName = tdsName;
    }

    public Integer getTdsPercent() {
        return tdsPercent;
    }

    public void setTdsPercent(Integer tdsPercent) {
        this.tdsPercent = tdsPercent;
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
    public List<TdsMaster> getTdsMasterList() {
        return tdsMasterList;
    }

    public void setTdsMasterList(List<TdsMaster> tdsMasterList) {
        this.tdsMasterList = tdsMasterList;
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
    public List<PayRequest> getPayRequestList() {
        return payRequestList;
    }

    public void setPayRequestList(List<PayRequest> payRequestList) {
        this.payRequestList = payRequestList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tdsTypeId != null ? tdsTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TdsType)) {
            return false;
        }
        TdsType other = (TdsType) object;
        if ((this.tdsTypeId == null && other.tdsTypeId != null) || (this.tdsTypeId != null && !this.tdsTypeId.equals(other.tdsTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.TdsType[ tdsTypeId=" + tdsTypeId + " ]";
    }
    
}
