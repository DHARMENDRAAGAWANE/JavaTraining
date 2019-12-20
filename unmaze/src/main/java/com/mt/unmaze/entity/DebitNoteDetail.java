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
@Table(name = "debit_note_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DebitNoteDetail.findAll", query = "SELECT d FROM DebitNoteDetail d"),
    @NamedQuery(name = "DebitNoteDetail.findByDebitNoteDetailId", query = "SELECT d FROM DebitNoteDetail d WHERE d.debitNoteDetailId = :debitNoteDetailId"),
    @NamedQuery(name = "DebitNoteDetail.findByDebitNoteQty", query = "SELECT d FROM DebitNoteDetail d WHERE d.debitNoteQty = :debitNoteQty"),
    @NamedQuery(name = "DebitNoteDetail.findByQtyRateInr", query = "SELECT d FROM DebitNoteDetail d WHERE d.qtyRateInr = :qtyRateInr"),
    @NamedQuery(name = "DebitNoteDetail.findByLandingCharge", query = "SELECT d FROM DebitNoteDetail d WHERE d.landingCharge = :landingCharge"),
    @NamedQuery(name = "DebitNoteDetail.findByAvInr", query = "SELECT d FROM DebitNoteDetail d WHERE d.avInr = :avInr"),
    @NamedQuery(name = "DebitNoteDetail.findByBcdAmt", query = "SELECT d FROM DebitNoteDetail d WHERE d.bcdAmt = :bcdAmt"),
    @NamedQuery(name = "DebitNoteDetail.findByPdAmt", query = "SELECT d FROM DebitNoteDetail d WHERE d.pdAmt = :pdAmt"),
    @NamedQuery(name = "DebitNoteDetail.findByCvdAmt", query = "SELECT d FROM DebitNoteDetail d WHERE d.cvdAmt = :cvdAmt"),
    @NamedQuery(name = "DebitNoteDetail.findByCecAmt", query = "SELECT d FROM DebitNoteDetail d WHERE d.cecAmt = :cecAmt"),
    @NamedQuery(name = "DebitNoteDetail.findByScvdAmt", query = "SELECT d FROM DebitNoteDetail d WHERE d.scvdAmt = :scvdAmt"),
    @NamedQuery(name = "DebitNoteDetail.findBySpecificDutyAmt", query = "SELECT d FROM DebitNoteDetail d WHERE d.specificDutyAmt = :specificDutyAmt"),
    @NamedQuery(name = "DebitNoteDetail.findByOtherDutyAmt", query = "SELECT d FROM DebitNoteDetail d WHERE d.otherDutyAmt = :otherDutyAmt"),
    @NamedQuery(name = "DebitNoteDetail.findByTcdAmt", query = "SELECT d FROM DebitNoteDetail d WHERE d.tcdAmt = :tcdAmt"),
    @NamedQuery(name = "DebitNoteDetail.findByBasicAmt", query = "SELECT d FROM DebitNoteDetail d WHERE d.basicAmt = :basicAmt"),
    @NamedQuery(name = "DebitNoteDetail.findByCgstAmt", query = "SELECT d FROM DebitNoteDetail d WHERE d.cgstAmt = :cgstAmt"),
    @NamedQuery(name = "DebitNoteDetail.findBySgstAmt", query = "SELECT d FROM DebitNoteDetail d WHERE d.sgstAmt = :sgstAmt"),
    @NamedQuery(name = "DebitNoteDetail.findByIgstAmt", query = "SELECT d FROM DebitNoteDetail d WHERE d.igstAmt = :igstAmt"),
    @NamedQuery(name = "DebitNoteDetail.findByCessAmt", query = "SELECT d FROM DebitNoteDetail d WHERE d.cessAmt = :cessAmt"),
    @NamedQuery(name = "DebitNoteDetail.findByVatAmt", query = "SELECT d FROM DebitNoteDetail d WHERE d.vatAmt = :vatAmt"),
    @NamedQuery(name = "DebitNoteDetail.findByTotalAmt", query = "SELECT d FROM DebitNoteDetail d WHERE d.totalAmt = :totalAmt"),
    @NamedQuery(name = "DebitNoteDetail.findByCgstItc", query = "SELECT d FROM DebitNoteDetail d WHERE d.cgstItc = :cgstItc"),
    @NamedQuery(name = "DebitNoteDetail.findBySgstItc", query = "SELECT d FROM DebitNoteDetail d WHERE d.sgstItc = :sgstItc"),
    @NamedQuery(name = "DebitNoteDetail.findByIgstItc", query = "SELECT d FROM DebitNoteDetail d WHERE d.igstItc = :igstItc"),
    @NamedQuery(name = "DebitNoteDetail.findByCessItc", query = "SELECT d FROM DebitNoteDetail d WHERE d.cessItc = :cessItc"),
    @NamedQuery(name = "DebitNoteDetail.findByVatItc", query = "SELECT d FROM DebitNoteDetail d WHERE d.vatItc = :vatItc"),
    @NamedQuery(name = "DebitNoteDetail.findByCreatedAt", query = "SELECT d FROM DebitNoteDetail d WHERE d.createdAt = :createdAt"),
    @NamedQuery(name = "DebitNoteDetail.findByLastUpdatedAt", query = "SELECT d FROM DebitNoteDetail d WHERE d.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "DebitNoteDetail.findByIsActive", query = "SELECT d FROM DebitNoteDetail d WHERE d.isActive = :isActive"),
    @NamedQuery(name = "DebitNoteDetail.findByIpAddress", query = "SELECT d FROM DebitNoteDetail d WHERE d.ipAddress = :ipAddress")})
public class DebitNoteDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "debit_note_detail_id")
    private Integer debitNoteDetailId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "debit_note_qty")
    private Double debitNoteQty;
    @Column(name = "qty_rate_inr")
    private Double qtyRateInr;
    @Column(name = "landing_charge")
    private Double landingCharge;
    @Column(name = "av_inr")
    private Double avInr;
    @Column(name = "bcd_amt")
    private Double bcdAmt;
    @Column(name = "pd_amt")
    private Double pdAmt;
    @Column(name = "cvd_amt")
    private Double cvdAmt;
    @Column(name = "cec_amt")
    private Double cecAmt;
    @Column(name = "scvd_amt")
    private Double scvdAmt;
    @Column(name = "specific_duty_amt")
    private Double specificDutyAmt;
    @Column(name = "other_duty_amt")
    private Double otherDutyAmt;
    @Column(name = "tcd_amt")
    private Double tcdAmt;
    @Column(name = "basic_amt")
    private Double basicAmt;
    @Column(name = "cgst_amt")
    private Double cgstAmt;
    @Column(name = "sgst_amt")
    private Double sgstAmt;
    @Column(name = "igst_amt")
    private Double igstAmt;
    @Column(name = "cess_amt")
    private Double cessAmt;
    @Column(name = "vat_amt")
    private Double vatAmt;
    @Column(name = "total_amt")
    private Double totalAmt;
    @Column(name = "cgst_itc")
    private Double cgstItc;
    @Column(name = "sgst_itc")
    private Double sgstItc;
    @Column(name = "igst_itc")
    private Double igstItc;
    @Column(name = "cess_itc")
    private Double cessItc;
    @Column(name = "vat_itc")
    private Double vatItc;
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
    @JoinColumn(name = "bill_detail_id", referencedColumnName = "bill_detail_id")
    @ManyToOne(optional = false)
    private BillDetail billDetailId;
    @JoinColumn(name = "bill_master_id", referencedColumnName = "bill_master_id")
    @ManyToOne(optional = false)
    private BillMaster billMasterId;
    @JoinColumn(name = "debit_note_master_id", referencedColumnName = "debit_note_master_id")
    @ManyToOne(optional = false)
    private DebitNoteMaster debitNoteMasterId;
    @JoinColumn(name = "material_master_id", referencedColumnName = "material_master_id")
    @ManyToOne
    private MaterialMaster materialMasterId;
    @JoinColumn(name = "purchase_order_detail_id", referencedColumnName = "purchase_order_detail_id")
    @ManyToOne(optional = false)
    private PurchaseOrderDetail purchaseOrderDetailId;
    @JoinColumn(name = "purchase_order_master_id", referencedColumnName = "purchase_order_master_id")
    @ManyToOne(optional = false)
    private PurchaseOrderMaster purchaseOrderMasterId;
    @JoinColumn(name = "service_master_id", referencedColumnName = "service_master_id")
    @ManyToOne
    private ServiceMaster serviceMasterId;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;

    public DebitNoteDetail() {
    }

    public DebitNoteDetail(Integer debitNoteDetailId) {
        this.debitNoteDetailId = debitNoteDetailId;
    }

    public DebitNoteDetail(Integer debitNoteDetailId, Date lastUpdatedAt, Character isActive) {
        this.debitNoteDetailId = debitNoteDetailId;
        this.lastUpdatedAt = lastUpdatedAt;
        this.isActive = isActive;
    }

    public Integer getDebitNoteDetailId() {
        return debitNoteDetailId;
    }

    public void setDebitNoteDetailId(Integer debitNoteDetailId) {
        this.debitNoteDetailId = debitNoteDetailId;
    }

    public Double getDebitNoteQty() {
        return debitNoteQty;
    }

    public void setDebitNoteQty(Double debitNoteQty) {
        this.debitNoteQty = debitNoteQty;
    }

    public Double getQtyRateInr() {
        return qtyRateInr;
    }

    public void setQtyRateInr(Double qtyRateInr) {
        this.qtyRateInr = qtyRateInr;
    }

    public Double getLandingCharge() {
        return landingCharge;
    }

    public void setLandingCharge(Double landingCharge) {
        this.landingCharge = landingCharge;
    }

    public Double getAvInr() {
        return avInr;
    }

    public void setAvInr(Double avInr) {
        this.avInr = avInr;
    }

    public Double getBcdAmt() {
        return bcdAmt;
    }

    public void setBcdAmt(Double bcdAmt) {
        this.bcdAmt = bcdAmt;
    }

    public Double getPdAmt() {
        return pdAmt;
    }

    public void setPdAmt(Double pdAmt) {
        this.pdAmt = pdAmt;
    }

    public Double getCvdAmt() {
        return cvdAmt;
    }

    public void setCvdAmt(Double cvdAmt) {
        this.cvdAmt = cvdAmt;
    }

    public Double getCecAmt() {
        return cecAmt;
    }

    public void setCecAmt(Double cecAmt) {
        this.cecAmt = cecAmt;
    }

    public Double getScvdAmt() {
        return scvdAmt;
    }

    public void setScvdAmt(Double scvdAmt) {
        this.scvdAmt = scvdAmt;
    }

    public Double getSpecificDutyAmt() {
        return specificDutyAmt;
    }

    public void setSpecificDutyAmt(Double specificDutyAmt) {
        this.specificDutyAmt = specificDutyAmt;
    }

    public Double getOtherDutyAmt() {
        return otherDutyAmt;
    }

    public void setOtherDutyAmt(Double otherDutyAmt) {
        this.otherDutyAmt = otherDutyAmt;
    }

    public Double getTcdAmt() {
        return tcdAmt;
    }

    public void setTcdAmt(Double tcdAmt) {
        this.tcdAmt = tcdAmt;
    }

    public Double getBasicAmt() {
        return basicAmt;
    }

    public void setBasicAmt(Double basicAmt) {
        this.basicAmt = basicAmt;
    }

    public Double getCgstAmt() {
        return cgstAmt;
    }

    public void setCgstAmt(Double cgstAmt) {
        this.cgstAmt = cgstAmt;
    }

    public Double getSgstAmt() {
        return sgstAmt;
    }

    public void setSgstAmt(Double sgstAmt) {
        this.sgstAmt = sgstAmt;
    }

    public Double getIgstAmt() {
        return igstAmt;
    }

    public void setIgstAmt(Double igstAmt) {
        this.igstAmt = igstAmt;
    }

    public Double getCessAmt() {
        return cessAmt;
    }

    public void setCessAmt(Double cessAmt) {
        this.cessAmt = cessAmt;
    }

    public Double getVatAmt() {
        return vatAmt;
    }

    public void setVatAmt(Double vatAmt) {
        this.vatAmt = vatAmt;
    }

    public Double getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(Double totalAmt) {
        this.totalAmt = totalAmt;
    }

    public Double getCgstItc() {
        return cgstItc;
    }

    public void setCgstItc(Double cgstItc) {
        this.cgstItc = cgstItc;
    }

    public Double getSgstItc() {
        return sgstItc;
    }

    public void setSgstItc(Double sgstItc) {
        this.sgstItc = sgstItc;
    }

    public Double getIgstItc() {
        return igstItc;
    }

    public void setIgstItc(Double igstItc) {
        this.igstItc = igstItc;
    }

    public Double getCessItc() {
        return cessItc;
    }

    public void setCessItc(Double cessItc) {
        this.cessItc = cessItc;
    }

    public Double getVatItc() {
        return vatItc;
    }

    public void setVatItc(Double vatItc) {
        this.vatItc = vatItc;
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

    public DebitNoteMaster getDebitNoteMasterId() {
        return debitNoteMasterId;
    }

    public void setDebitNoteMasterId(DebitNoteMaster debitNoteMasterId) {
        this.debitNoteMasterId = debitNoteMasterId;
    }

    public MaterialMaster getMaterialMasterId() {
        return materialMasterId;
    }

    public void setMaterialMasterId(MaterialMaster materialMasterId) {
        this.materialMasterId = materialMasterId;
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

    public ServiceMaster getServiceMasterId() {
        return serviceMasterId;
    }

    public void setServiceMasterId(ServiceMaster serviceMasterId) {
        this.serviceMasterId = serviceMasterId;
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
        hash += (debitNoteDetailId != null ? debitNoteDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DebitNoteDetail)) {
            return false;
        }
        DebitNoteDetail other = (DebitNoteDetail) object;
        if ((this.debitNoteDetailId == null && other.debitNoteDetailId != null) || (this.debitNoteDetailId != null && !this.debitNoteDetailId.equals(other.debitNoteDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.DebitNoteDetail[ debitNoteDetailId=" + debitNoteDetailId + " ]";
    }
    
}
