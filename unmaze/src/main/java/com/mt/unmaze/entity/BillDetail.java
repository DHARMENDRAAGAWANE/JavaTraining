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
@Table(name = "bill_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BillDetail.findAll", query = "SELECT b FROM BillDetail b"),
    @NamedQuery(name = "BillDetail.findByBillDetailId", query = "SELECT b FROM BillDetail b WHERE b.billDetailId = :billDetailId"),
    @NamedQuery(name = "BillDetail.findByBillQty", query = "SELECT b FROM BillDetail b WHERE b.billQty = :billQty"),
    @NamedQuery(name = "BillDetail.findByQtyRateInr", query = "SELECT b FROM BillDetail b WHERE b.qtyRateInr = :qtyRateInr"),
    @NamedQuery(name = "BillDetail.findByLandingCharge", query = "SELECT b FROM BillDetail b WHERE b.landingCharge = :landingCharge"),
    @NamedQuery(name = "BillDetail.findByAvInr", query = "SELECT b FROM BillDetail b WHERE b.avInr = :avInr"),
    @NamedQuery(name = "BillDetail.findByBcdAmt", query = "SELECT b FROM BillDetail b WHERE b.bcdAmt = :bcdAmt"),
    @NamedQuery(name = "BillDetail.findByPdAmt", query = "SELECT b FROM BillDetail b WHERE b.pdAmt = :pdAmt"),
    @NamedQuery(name = "BillDetail.findByCvdAmt", query = "SELECT b FROM BillDetail b WHERE b.cvdAmt = :cvdAmt"),
    @NamedQuery(name = "BillDetail.findByCecAmt", query = "SELECT b FROM BillDetail b WHERE b.cecAmt = :cecAmt"),
    @NamedQuery(name = "BillDetail.findByScvdAmt", query = "SELECT b FROM BillDetail b WHERE b.scvdAmt = :scvdAmt"),
    @NamedQuery(name = "BillDetail.findBySpecificDutyAmt", query = "SELECT b FROM BillDetail b WHERE b.specificDutyAmt = :specificDutyAmt"),
    @NamedQuery(name = "BillDetail.findByOtherDutyAmt", query = "SELECT b FROM BillDetail b WHERE b.otherDutyAmt = :otherDutyAmt"),
    @NamedQuery(name = "BillDetail.findByTcdAmt", query = "SELECT b FROM BillDetail b WHERE b.tcdAmt = :tcdAmt"),
    @NamedQuery(name = "BillDetail.findByBasicAmt", query = "SELECT b FROM BillDetail b WHERE b.basicAmt = :basicAmt"),
    @NamedQuery(name = "BillDetail.findByCgstAmt", query = "SELECT b FROM BillDetail b WHERE b.cgstAmt = :cgstAmt"),
    @NamedQuery(name = "BillDetail.findBySgstAmt", query = "SELECT b FROM BillDetail b WHERE b.sgstAmt = :sgstAmt"),
    @NamedQuery(name = "BillDetail.findByIgstAmt", query = "SELECT b FROM BillDetail b WHERE b.igstAmt = :igstAmt"),
    @NamedQuery(name = "BillDetail.findByCessAmt", query = "SELECT b FROM BillDetail b WHERE b.cessAmt = :cessAmt"),
    @NamedQuery(name = "BillDetail.findByVatAmt", query = "SELECT b FROM BillDetail b WHERE b.vatAmt = :vatAmt"),
    @NamedQuery(name = "BillDetail.findByTotalAmt", query = "SELECT b FROM BillDetail b WHERE b.totalAmt = :totalAmt"),
    @NamedQuery(name = "BillDetail.findByCgstItc", query = "SELECT b FROM BillDetail b WHERE b.cgstItc = :cgstItc"),
    @NamedQuery(name = "BillDetail.findBySgstItc", query = "SELECT b FROM BillDetail b WHERE b.sgstItc = :sgstItc"),
    @NamedQuery(name = "BillDetail.findByIgstItc", query = "SELECT b FROM BillDetail b WHERE b.igstItc = :igstItc"),
    @NamedQuery(name = "BillDetail.findByCessItc", query = "SELECT b FROM BillDetail b WHERE b.cessItc = :cessItc"),
    @NamedQuery(name = "BillDetail.findByVatItc", query = "SELECT b FROM BillDetail b WHERE b.vatItc = :vatItc"),
    @NamedQuery(name = "BillDetail.findByCreatedAt", query = "SELECT b FROM BillDetail b WHERE b.createdAt = :createdAt"),
    @NamedQuery(name = "BillDetail.findByLastUpdatedAt", query = "SELECT b FROM BillDetail b WHERE b.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "BillDetail.findByIsActive", query = "SELECT b FROM BillDetail b WHERE b.isActive = :isActive"),
    @NamedQuery(name = "BillDetail.findByIpAddress", query = "SELECT b FROM BillDetail b WHERE b.ipAddress = :ipAddress")})
public class BillDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bill_detail_id")
    private Integer billDetailId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "bill_qty")
    private Double billQty;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billDetailId")
    private List<GrnBillMapping> grnBillMappingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billDetailId")
    private List<DebitNoteDetail> debitNoteDetailList;
    @JoinColumn(name = "bill_master_id", referencedColumnName = "bill_master_id")
    @ManyToOne(optional = false)
    private BillMaster billMasterId;
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

    public BillDetail() {
    }

    public BillDetail(Integer billDetailId) {
        this.billDetailId = billDetailId;
    }

    public BillDetail(Integer billDetailId, Date lastUpdatedAt, Character isActive) {
        this.billDetailId = billDetailId;
        this.lastUpdatedAt = lastUpdatedAt;
        this.isActive = isActive;
    }

    public Integer getBillDetailId() {
        return billDetailId;
    }

    public void setBillDetailId(Integer billDetailId) {
        this.billDetailId = billDetailId;
    }

    public Double getBillQty() {
        return billQty;
    }

    public void setBillQty(Double billQty) {
        this.billQty = billQty;
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

    @XmlTransient
    public List<GrnBillMapping> getGrnBillMappingList() {
        return grnBillMappingList;
    }

    public void setGrnBillMappingList(List<GrnBillMapping> grnBillMappingList) {
        this.grnBillMappingList = grnBillMappingList;
    }

    @XmlTransient
    public List<DebitNoteDetail> getDebitNoteDetailList() {
        return debitNoteDetailList;
    }

    public void setDebitNoteDetailList(List<DebitNoteDetail> debitNoteDetailList) {
        this.debitNoteDetailList = debitNoteDetailList;
    }

    public BillMaster getBillMasterId() {
        return billMasterId;
    }

    public void setBillMasterId(BillMaster billMasterId) {
        this.billMasterId = billMasterId;
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
        hash += (billDetailId != null ? billDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BillDetail)) {
            return false;
        }
        BillDetail other = (BillDetail) object;
        if ((this.billDetailId == null && other.billDetailId != null) || (this.billDetailId != null && !this.billDetailId.equals(other.billDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.BillDetail[ billDetailId=" + billDetailId + " ]";
    }
    
}
