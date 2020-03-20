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
import javax.persistence.Lob;
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
@Table(name = "material_transaction_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialTransactionMaster.findAll", query = "SELECT m FROM MaterialTransactionMaster m"),
    @NamedQuery(name = "MaterialTransactionMaster.findByMaterialTransactionMasterId", query = "SELECT m FROM MaterialTransactionMaster m WHERE m.materialTransactionMasterId = :materialTransactionMasterId"),
    @NamedQuery(name = "MaterialTransactionMaster.findByDate", query = "SELECT m FROM MaterialTransactionMaster m WHERE m.date = :date"),
    @NamedQuery(name = "MaterialTransactionMaster.findByProductionMasterId", query = "SELECT m FROM MaterialTransactionMaster m WHERE m.productionMasterId = :productionMasterId"),
    @NamedQuery(name = "MaterialTransactionMaster.findByOutputProductionMasterId", query = "SELECT m FROM MaterialTransactionMaster m WHERE m.outputProductionMasterId = :outputProductionMasterId"),
    @NamedQuery(name = "MaterialTransactionMaster.findByBatchNo", query = "SELECT m FROM MaterialTransactionMaster m WHERE m.batchNo = :batchNo"),
    @NamedQuery(name = "MaterialTransactionMaster.findByQty", query = "SELECT m FROM MaterialTransactionMaster m WHERE m.qty = :qty"),
    @NamedQuery(name = "MaterialTransactionMaster.findByFifoRate", query = "SELECT m FROM MaterialTransactionMaster m WHERE m.fifoRate = :fifoRate"),
    @NamedQuery(name = "MaterialTransactionMaster.findByValue", query = "SELECT m FROM MaterialTransactionMaster m WHERE m.value = :value"),
    @NamedQuery(name = "MaterialTransactionMaster.findByCreatedAt", query = "SELECT m FROM MaterialTransactionMaster m WHERE m.createdAt = :createdAt"),
    @NamedQuery(name = "MaterialTransactionMaster.findByLastUpdatedAt", query = "SELECT m FROM MaterialTransactionMaster m WHERE m.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "MaterialTransactionMaster.findByIsActive", query = "SELECT m FROM MaterialTransactionMaster m WHERE m.isActive = :isActive"),
    @NamedQuery(name = "MaterialTransactionMaster.findByIpAddress", query = "SELECT m FROM MaterialTransactionMaster m WHERE m.ipAddress = :ipAddress")})
public class MaterialTransactionMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "material_transaction_master_id")
    private Integer materialTransactionMasterId;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "production_master_id")
    private Integer productionMasterId;
    @Column(name = "output_production_master_id")
    private Integer outputProductionMasterId;
    @Column(name = "batch_no")
    private String batchNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qty")
    private Double qty;
    @Column(name = "fifo_rate")
    private Double fifoRate;
    @Column(name = "value")
    private Double value;
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
    @JoinColumn(name = "bill_master_id", referencedColumnName = "bill_master_id")
    @ManyToOne
    private BillMaster billMasterId;
    @JoinColumn(name = "branch_master_id", referencedColumnName = "branch_master_id")
    @ManyToOne(optional = false)
    private BranchMaster branchMasterId;
    @JoinColumn(name = "credit_note_master_id", referencedColumnName = "credit_note_master_id")
    @ManyToOne
    private CreditNoteMaster creditNoteMasterId;
    @JoinColumn(name = "debit_note_master_id", referencedColumnName = "debit_note_master_id")
    @ManyToOne
    private DebitNoteMaster debitNoteMasterId;
    @JoinColumn(name = "goods_reciept_note_id", referencedColumnName = "goods_reciept_note_id")
    @ManyToOne
    private GoodsRecieptNote goodsRecieptNoteId;
    @JoinColumn(name = "invoice_master_id", referencedColumnName = "invoice_master_id")
    @ManyToOne
    private InvoiceMaster invoiceMasterId;
    @JoinColumn(name = "material_master_id", referencedColumnName = "material_master_id")
    @ManyToOne(optional = false)
    private MaterialMaster materialMasterId;
    @JoinColumn(name = "material_transaction_type_id", referencedColumnName = "material_service_transaction_type_id")
    @ManyToOne(optional = false)
    private MaterialServiceTransactionType materialTransactionTypeId;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;

    public MaterialTransactionMaster() {
    }

    public MaterialTransactionMaster(Integer materialTransactionMasterId) {
        this.materialTransactionMasterId = materialTransactionMasterId;
    }

    public MaterialTransactionMaster(Integer materialTransactionMasterId, Date date, Date lastUpdatedAt, Character isActive) {
        this.materialTransactionMasterId = materialTransactionMasterId;
        this.date = date;
        this.lastUpdatedAt = lastUpdatedAt;
        this.isActive = isActive;
    }

    public Integer getMaterialTransactionMasterId() {
        return materialTransactionMasterId;
    }

    public void setMaterialTransactionMasterId(Integer materialTransactionMasterId) {
        this.materialTransactionMasterId = materialTransactionMasterId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getProductionMasterId() {
        return productionMasterId;
    }

    public void setProductionMasterId(Integer productionMasterId) {
        this.productionMasterId = productionMasterId;
    }

    public Integer getOutputProductionMasterId() {
        return outputProductionMasterId;
    }

    public void setOutputProductionMasterId(Integer outputProductionMasterId) {
        this.outputProductionMasterId = outputProductionMasterId;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getFifoRate() {
        return fifoRate;
    }

    public void setFifoRate(Double fifoRate) {
        this.fifoRate = fifoRate;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
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

    public BillMaster getBillMasterId() {
        return billMasterId;
    }

    public void setBillMasterId(BillMaster billMasterId) {
        this.billMasterId = billMasterId;
    }

    public BranchMaster getBranchMasterId() {
        return branchMasterId;
    }

    public void setBranchMasterId(BranchMaster branchMasterId) {
        this.branchMasterId = branchMasterId;
    }

    public CreditNoteMaster getCreditNoteMasterId() {
        return creditNoteMasterId;
    }

    public void setCreditNoteMasterId(CreditNoteMaster creditNoteMasterId) {
        this.creditNoteMasterId = creditNoteMasterId;
    }

    public DebitNoteMaster getDebitNoteMasterId() {
        return debitNoteMasterId;
    }

    public void setDebitNoteMasterId(DebitNoteMaster debitNoteMasterId) {
        this.debitNoteMasterId = debitNoteMasterId;
    }

    public GoodsRecieptNote getGoodsRecieptNoteId() {
        return goodsRecieptNoteId;
    }

    public void setGoodsRecieptNoteId(GoodsRecieptNote goodsRecieptNoteId) {
        this.goodsRecieptNoteId = goodsRecieptNoteId;
    }

    public InvoiceMaster getInvoiceMasterId() {
        return invoiceMasterId;
    }

    public void setInvoiceMasterId(InvoiceMaster invoiceMasterId) {
        this.invoiceMasterId = invoiceMasterId;
    }

    public MaterialMaster getMaterialMasterId() {
        return materialMasterId;
    }

    public void setMaterialMasterId(MaterialMaster materialMasterId) {
        this.materialMasterId = materialMasterId;
    }

    public MaterialServiceTransactionType getMaterialTransactionTypeId() {
        return materialTransactionTypeId;
    }

    public void setMaterialTransactionTypeId(MaterialServiceTransactionType materialTransactionTypeId) {
        this.materialTransactionTypeId = materialTransactionTypeId;
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
        hash += (materialTransactionMasterId != null ? materialTransactionMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialTransactionMaster)) {
            return false;
        }
        MaterialTransactionMaster other = (MaterialTransactionMaster) object;
        if ((this.materialTransactionMasterId == null && other.materialTransactionMasterId != null) || (this.materialTransactionMasterId != null && !this.materialTransactionMasterId.equals(other.materialTransactionMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.MaterialTransactionMaster[ materialTransactionMasterId=" + materialTransactionMasterId + " ]";
    }
    
}
