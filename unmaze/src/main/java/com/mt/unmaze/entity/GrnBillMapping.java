/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mt.unmaze.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "grn_bill_mapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrnBillMapping.findAll", query = "SELECT g FROM GrnBillMapping g"),
    @NamedQuery(name = "GrnBillMapping.findByGrnBillMappingId", query = "SELECT g FROM GrnBillMapping g WHERE g.grnBillMappingId = :grnBillMappingId"),
    @NamedQuery(name = "GrnBillMapping.findByQty", query = "SELECT g FROM GrnBillMapping g WHERE g.qty = :qty"),
    @NamedQuery(name = "GrnBillMapping.findByStatus", query = "SELECT g FROM GrnBillMapping g WHERE g.status = :status"),
    @NamedQuery(name = "GrnBillMapping.findByRemarks", query = "SELECT g FROM GrnBillMapping g WHERE g.remarks = :remarks"),
    @NamedQuery(name = "GrnBillMapping.findByCreatedAt", query = "SELECT g FROM GrnBillMapping g WHERE g.createdAt = :createdAt"),
    @NamedQuery(name = "GrnBillMapping.findByLastUpdatedAt", query = "SELECT g FROM GrnBillMapping g WHERE g.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "GrnBillMapping.findByIsActive", query = "SELECT g FROM GrnBillMapping g WHERE g.isActive = :isActive"),
    @NamedQuery(name = "GrnBillMapping.findByIsDeleted", query = "SELECT g FROM GrnBillMapping g WHERE g.isDeleted = :isDeleted"),
    @NamedQuery(name = "GrnBillMapping.findByIpAddress", query = "SELECT g FROM GrnBillMapping g WHERE g.ipAddress = :ipAddress")})
public class GrnBillMapping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "grn_bill_mapping_id")
    private Integer grnBillMappingId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qty")
    private Double qty;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
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
    @Basic(optional = false)
    @Column(name = "is_deleted")
    private Character isDeleted;
    @Column(name = "ip_address")
    private String ipAddress;
    @JoinColumn(name = "bill_detail_id", referencedColumnName = "bill_detail_id")
    @ManyToOne(optional = false)
    private BillDetail billDetailId;
    @JoinColumn(name = "bill_master_id", referencedColumnName = "bill_master_id")
    @ManyToOne(optional = false)
    private BillMaster billMasterId;
    @JoinColumn(name = "goods_reciept_note_id", referencedColumnName = "goods_reciept_note_id")
    @ManyToOne(optional = false)
    private GoodsRecieptNote goodsRecieptNoteId;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;

    public GrnBillMapping() {
    }

    public GrnBillMapping(Integer grnBillMappingId) {
        this.grnBillMappingId = grnBillMappingId;
    }

    public GrnBillMapping(Integer grnBillMappingId, int status, Date lastUpdatedAt, Character isActive, Character isDeleted) {
        this.grnBillMappingId = grnBillMappingId;
        this.status = status;
        this.lastUpdatedAt = lastUpdatedAt;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
    }

    public Integer getGrnBillMappingId() {
        return grnBillMappingId;
    }

    public void setGrnBillMappingId(Integer grnBillMappingId) {
        this.grnBillMappingId = grnBillMappingId;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public BillDetail getBillDetailId() {
        return billDetailId;
    }

    public void setBillDetailId(BillDetail billDetailId) {
        this.billDetailId = billDetailId;
    }

    public BillMaster getBillMasterId() {
        return billMasterId;
    }

    public void setBillMasterId(BillMaster billMasterId) {
        this.billMasterId = billMasterId;
    }

    public GoodsRecieptNote getGoodsRecieptNoteId() {
        return goodsRecieptNoteId;
    }

    public void setGoodsRecieptNoteId(GoodsRecieptNote goodsRecieptNoteId) {
        this.goodsRecieptNoteId = goodsRecieptNoteId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grnBillMappingId != null ? grnBillMappingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrnBillMapping)) {
            return false;
        }
        GrnBillMapping other = (GrnBillMapping) object;
        if ((this.grnBillMappingId == null && other.grnBillMappingId != null) || (this.grnBillMappingId != null && !this.grnBillMappingId.equals(other.grnBillMappingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.GrnBillMapping[ grnBillMappingId=" + grnBillMappingId + " ]";
    }
    
}
