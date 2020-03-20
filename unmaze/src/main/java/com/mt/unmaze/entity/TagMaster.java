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
@Table(name = "tag_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TagMaster.findAll", query = "SELECT t FROM TagMaster t"),
    @NamedQuery(name = "TagMaster.findByTagMasterId", query = "SELECT t FROM TagMaster t WHERE t.tagMasterId = :tagMasterId"),
    @NamedQuery(name = "TagMaster.findByTagMasterName", query = "SELECT t FROM TagMaster t WHERE t.tagMasterName = :tagMasterName"),
    @NamedQuery(name = "TagMaster.findByCreatedAt", query = "SELECT t FROM TagMaster t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "TagMaster.findByLastUpdatedAt", query = "SELECT t FROM TagMaster t WHERE t.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "TagMaster.findByIsActive", query = "SELECT t FROM TagMaster t WHERE t.isActive = :isActive"),
    @NamedQuery(name = "TagMaster.findByIsDeleted", query = "SELECT t FROM TagMaster t WHERE t.isDeleted = :isDeleted"),
    @NamedQuery(name = "TagMaster.findByIpAddress", query = "SELECT t FROM TagMaster t WHERE t.ipAddress = :ipAddress")})
public class TagMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tag_master_id")
    private Integer tagMasterId;
    @Column(name = "tag_master_name")
    private String tagMasterName;
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
    @OneToMany(mappedBy = "tagMasterId")
    private List<TagMapping> tagMappingList;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @OneToMany(mappedBy = "customTagMasterId")
    private List<PoTagMaster> poTagMasterList;

    public TagMaster() {
    }

    public TagMaster(Integer tagMasterId) {
        this.tagMasterId = tagMasterId;
    }

    public TagMaster(Integer tagMasterId, Character isActive, Character isDeleted) {
        this.tagMasterId = tagMasterId;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
    }

    public Integer getTagMasterId() {
        return tagMasterId;
    }

    public void setTagMasterId(Integer tagMasterId) {
        this.tagMasterId = tagMasterId;
    }

    public String getTagMasterName() {
        return tagMasterName;
    }

    public void setTagMasterName(String tagMasterName) {
        this.tagMasterName = tagMasterName;
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
    public List<TagMapping> getTagMappingList() {
        return tagMappingList;
    }

    public void setTagMappingList(List<TagMapping> tagMappingList) {
        this.tagMappingList = tagMappingList;
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
    public List<PoTagMaster> getPoTagMasterList() {
        return poTagMasterList;
    }

    public void setPoTagMasterList(List<PoTagMaster> poTagMasterList) {
        this.poTagMasterList = poTagMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tagMasterId != null ? tagMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TagMaster)) {
            return false;
        }
        TagMaster other = (TagMaster) object;
        if ((this.tagMasterId == null && other.tagMasterId != null) || (this.tagMasterId != null && !this.tagMasterId.equals(other.tagMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.TagMaster[ tagMasterId=" + tagMasterId + " ]";
    }
    
}
