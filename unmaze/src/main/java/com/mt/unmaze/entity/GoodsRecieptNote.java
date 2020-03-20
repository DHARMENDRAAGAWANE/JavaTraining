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
@Table(name = "goods_reciept_note")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GoodsRecieptNote.findAll", query = "SELECT g FROM GoodsRecieptNote g"),
    @NamedQuery(name = "GoodsRecieptNote.findByGoodsRecieptNoteId", query = "SELECT g FROM GoodsRecieptNote g WHERE g.goodsRecieptNoteId = :goodsRecieptNoteId"),
    @NamedQuery(name = "GoodsRecieptNote.findByGoodsRecieptNoteNo", query = "SELECT g FROM GoodsRecieptNote g WHERE g.goodsRecieptNoteNo = :goodsRecieptNoteNo"),
    @NamedQuery(name = "GoodsRecieptNote.findByQty", query = "SELECT g FROM GoodsRecieptNote g WHERE g.qty = :qty"),
    @NamedQuery(name = "GoodsRecieptNote.findByAllottedQty", query = "SELECT g FROM GoodsRecieptNote g WHERE g.allottedQty = :allottedQty"),
    @NamedQuery(name = "GoodsRecieptNote.findByBalanceQty", query = "SELECT g FROM GoodsRecieptNote g WHERE g.balanceQty = :balanceQty"),
    @NamedQuery(name = "GoodsRecieptNote.findByBatchNo", query = "SELECT g FROM GoodsRecieptNote g WHERE g.batchNo = :batchNo"),
    @NamedQuery(name = "GoodsRecieptNote.findByRemarks", query = "SELECT g FROM GoodsRecieptNote g WHERE g.remarks = :remarks"),
    @NamedQuery(name = "GoodsRecieptNote.findByCreatedAt", query = "SELECT g FROM GoodsRecieptNote g WHERE g.createdAt = :createdAt"),
    @NamedQuery(name = "GoodsRecieptNote.findByLastUpdatedAt", query = "SELECT g FROM GoodsRecieptNote g WHERE g.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "GoodsRecieptNote.findByIsActive", query = "SELECT g FROM GoodsRecieptNote g WHERE g.isActive = :isActive"),
    @NamedQuery(name = "GoodsRecieptNote.findByIsDeleted", query = "SELECT g FROM GoodsRecieptNote g WHERE g.isDeleted = :isDeleted"),
    @NamedQuery(name = "GoodsRecieptNote.findByIpAddress", query = "SELECT g FROM GoodsRecieptNote g WHERE g.ipAddress = :ipAddress")})
public class GoodsRecieptNote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "goods_reciept_note_id")
    private Integer goodsRecieptNoteId;
    @Basic(optional = false)
    @Column(name = "goods_reciept_note_no")
    private String goodsRecieptNoteNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qty")
    private Double qty;
    @Column(name = "allotted_qty")
    private Double allottedQty;
    @Column(name = "balance_qty")
    private Double balanceQty;
    @Column(name = "batch_no")
    private String batchNo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goodsRecieptNoteId")
    private List<GrnBillMapping> grnBillMappingList;
    @JoinColumn(name = "security_file_asset_doc_1", referencedColumnName = "file_asset_id")
    @ManyToOne
    private FileAsset securityFileAssetDoc1;
    @JoinColumn(name = "security_file_asset_doc_2", referencedColumnName = "file_asset_id")
    @ManyToOne
    private FileAsset securityFileAssetDoc2;
    @JoinColumn(name = "purchase_order_detail_id", referencedColumnName = "purchase_order_detail_id")
    @ManyToOne(optional = false)
    private PurchaseOrderDetail purchaseOrderDetailId;
    @JoinColumn(name = "purchase_order_master_id", referencedColumnName = "purchase_order_master_id")
    @ManyToOne(optional = false)
    private PurchaseOrderMaster purchaseOrderMasterId;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @OneToMany(mappedBy = "goodsRecieptNoteId")
    private List<MaterialTransactionMaster> materialTransactionMasterList;

    public GoodsRecieptNote() {
    }

    public GoodsRecieptNote(Integer goodsRecieptNoteId) {
        this.goodsRecieptNoteId = goodsRecieptNoteId;
    }

    public GoodsRecieptNote(Integer goodsRecieptNoteId, String goodsRecieptNoteNo, Date lastUpdatedAt, Character isActive, Character isDeleted) {
        this.goodsRecieptNoteId = goodsRecieptNoteId;
        this.goodsRecieptNoteNo = goodsRecieptNoteNo;
        this.lastUpdatedAt = lastUpdatedAt;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
    }

    public Integer getGoodsRecieptNoteId() {
        return goodsRecieptNoteId;
    }

    public void setGoodsRecieptNoteId(Integer goodsRecieptNoteId) {
        this.goodsRecieptNoteId = goodsRecieptNoteId;
    }

    public String getGoodsRecieptNoteNo() {
        return goodsRecieptNoteNo;
    }

    public void setGoodsRecieptNoteNo(String goodsRecieptNoteNo) {
        this.goodsRecieptNoteNo = goodsRecieptNoteNo;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getAllottedQty() {
        return allottedQty;
    }

    public void setAllottedQty(Double allottedQty) {
        this.allottedQty = allottedQty;
    }

    public Double getBalanceQty() {
        return balanceQty;
    }

    public void setBalanceQty(Double balanceQty) {
        this.balanceQty = balanceQty;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
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
    public List<GrnBillMapping> getGrnBillMappingList() {
        return grnBillMappingList;
    }

    public void setGrnBillMappingList(List<GrnBillMapping> grnBillMappingList) {
        this.grnBillMappingList = grnBillMappingList;
    }

    public FileAsset getSecurityFileAssetDoc1() {
        return securityFileAssetDoc1;
    }

    public void setSecurityFileAssetDoc1(FileAsset securityFileAssetDoc1) {
        this.securityFileAssetDoc1 = securityFileAssetDoc1;
    }

    public FileAsset getSecurityFileAssetDoc2() {
        return securityFileAssetDoc2;
    }

    public void setSecurityFileAssetDoc2(FileAsset securityFileAssetDoc2) {
        this.securityFileAssetDoc2 = securityFileAssetDoc2;
    }

    public PurchaseOrderDetail getPurchaseOrderDetailId() {
        return purchaseOrderDetailId;
    }

    public void setPurchaseOrderDetailId(PurchaseOrderDetail purchaseOrderDetailId) {
        this.purchaseOrderDetailId = purchaseOrderDetailId;
    }

    public PurchaseOrderMaster getPurchaseOrderMasterId() {
        return purchaseOrderMasterId;
    }

    public void setPurchaseOrderMasterId(PurchaseOrderMaster purchaseOrderMasterId) {
        this.purchaseOrderMasterId = purchaseOrderMasterId;
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
    public List<MaterialTransactionMaster> getMaterialTransactionMasterList() {
        return materialTransactionMasterList;
    }

    public void setMaterialTransactionMasterList(List<MaterialTransactionMaster> materialTransactionMasterList) {
        this.materialTransactionMasterList = materialTransactionMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (goodsRecieptNoteId != null ? goodsRecieptNoteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GoodsRecieptNote)) {
            return false;
        }
        GoodsRecieptNote other = (GoodsRecieptNote) object;
        if ((this.goodsRecieptNoteId == null && other.goodsRecieptNoteId != null) || (this.goodsRecieptNoteId != null && !this.goodsRecieptNoteId.equals(other.goodsRecieptNoteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.GoodsRecieptNote[ goodsRecieptNoteId=" + goodsRecieptNoteId + " ]";
    }
    
}
