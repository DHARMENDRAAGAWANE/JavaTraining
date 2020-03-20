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
@Table(name = "tds_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TdsMaster.findAll", query = "SELECT t FROM TdsMaster t"),
    @NamedQuery(name = "TdsMaster.findByTdsMasterId", query = "SELECT t FROM TdsMaster t WHERE t.tdsMasterId = :tdsMasterId"),
    @NamedQuery(name = "TdsMaster.findByDate", query = "SELECT t FROM TdsMaster t WHERE t.date = :date"),
    @NamedQuery(name = "TdsMaster.findByBasicBillAmt", query = "SELECT t FROM TdsMaster t WHERE t.basicBillAmt = :basicBillAmt"),
    @NamedQuery(name = "TdsMaster.findByTdsAmt", query = "SELECT t FROM TdsMaster t WHERE t.tdsAmt = :tdsAmt"),
    @NamedQuery(name = "TdsMaster.findByCreatedAt", query = "SELECT t FROM TdsMaster t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "TdsMaster.findByLastUpdatedAt", query = "SELECT t FROM TdsMaster t WHERE t.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "TdsMaster.findByIsActive", query = "SELECT t FROM TdsMaster t WHERE t.isActive = :isActive"),
    @NamedQuery(name = "TdsMaster.findByIpAddress", query = "SELECT t FROM TdsMaster t WHERE t.ipAddress = :ipAddress")})
public class TdsMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tds_master_id")
    private Integer tdsMasterId;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "basic_bill_amt")
    private Double basicBillAmt;
    @Column(name = "tds_amt")
    private Double tdsAmt;
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
    @OneToMany(mappedBy = "tdsMasterId")
    private List<GeneralLedger> generalLedgerList;
    @JoinColumn(name = "bill_master_id", referencedColumnName = "bill_master_id")
    @ManyToOne(optional = false)
    private BillMaster billMasterId;
    @JoinColumn(name = "purchase_order_master_id", referencedColumnName = "purchase_order_master_id")
    @ManyToOne(optional = false)
    private PurchaseOrderMaster purchaseOrderMasterId;
    @JoinColumn(name = "tds_type_id", referencedColumnName = "tds_type_id")
    @ManyToOne
    private TdsType tdsTypeId;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;

    public TdsMaster() {
    }

    public TdsMaster(Integer tdsMasterId) {
        this.tdsMasterId = tdsMasterId;
    }

    public TdsMaster(Integer tdsMasterId, Date lastUpdatedAt, Character isActive) {
        this.tdsMasterId = tdsMasterId;
        this.lastUpdatedAt = lastUpdatedAt;
        this.isActive = isActive;
    }

    public Integer getTdsMasterId() {
        return tdsMasterId;
    }

    public void setTdsMasterId(Integer tdsMasterId) {
        this.tdsMasterId = tdsMasterId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getBasicBillAmt() {
        return basicBillAmt;
    }

    public void setBasicBillAmt(Double basicBillAmt) {
        this.basicBillAmt = basicBillAmt;
    }

    public Double getTdsAmt() {
        return tdsAmt;
    }

    public void setTdsAmt(Double tdsAmt) {
        this.tdsAmt = tdsAmt;
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

    @XmlTransient
    public List<GeneralLedger> getGeneralLedgerList() {
        return generalLedgerList;
    }

    public void setGeneralLedgerList(List<GeneralLedger> generalLedgerList) {
        this.generalLedgerList = generalLedgerList;
    }

    public BillMaster getBillMasterId() {
        return billMasterId;
    }

    public void setBillMasterId(BillMaster billMasterId) {
        this.billMasterId = billMasterId;
    }

    public PurchaseOrderMaster getPurchaseOrderMasterId() {
        return purchaseOrderMasterId;
    }

    public void setPurchaseOrderMasterId(PurchaseOrderMaster purchaseOrderMasterId) {
        this.purchaseOrderMasterId = purchaseOrderMasterId;
    }

    public TdsType getTdsTypeId() {
        return tdsTypeId;
    }

    public void setTdsTypeId(TdsType tdsTypeId) {
        this.tdsTypeId = tdsTypeId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tdsMasterId != null ? tdsMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TdsMaster)) {
            return false;
        }
        TdsMaster other = (TdsMaster) object;
        if ((this.tdsMasterId == null && other.tdsMasterId != null) || (this.tdsMasterId != null && !this.tdsMasterId.equals(other.tdsMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.TdsMaster[ tdsMasterId=" + tdsMasterId + " ]";
    }
    
}
