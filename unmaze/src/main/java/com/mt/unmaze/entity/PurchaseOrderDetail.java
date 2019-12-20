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
@Table(name = "purchase_order_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseOrderDetail.findAll", query = "SELECT p FROM PurchaseOrderDetail p"),
    @NamedQuery(name = "PurchaseOrderDetail.findByPurchaseOrderDetailId", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.purchaseOrderDetailId = :purchaseOrderDetailId"),
    @NamedQuery(name = "PurchaseOrderDetail.findByMaterialAccountMaster", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.materialAccountMaster = :materialAccountMaster"),
    @NamedQuery(name = "PurchaseOrderDetail.findByPurchaseOrderQty", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.purchaseOrderQty = :purchaseOrderQty"),
    @NamedQuery(name = "PurchaseOrderDetail.findByRate", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.rate = :rate"),
    @NamedQuery(name = "PurchaseOrderDetail.findByQtyRateInr", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.qtyRateInr = :qtyRateInr"),
    @NamedQuery(name = "PurchaseOrderDetail.findByLandingCharge", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.landingCharge = :landingCharge"),
    @NamedQuery(name = "PurchaseOrderDetail.findByAvInr", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.avInr = :avInr"),
    @NamedQuery(name = "PurchaseOrderDetail.findByBcdPercent", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.bcdPercent = :bcdPercent"),
    @NamedQuery(name = "PurchaseOrderDetail.findByBcdAmt", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.bcdAmt = :bcdAmt"),
    @NamedQuery(name = "PurchaseOrderDetail.findByPdPercent", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.pdPercent = :pdPercent"),
    @NamedQuery(name = "PurchaseOrderDetail.findByPdAmt", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.pdAmt = :pdAmt"),
    @NamedQuery(name = "PurchaseOrderDetail.findByCvdPercent", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.cvdPercent = :cvdPercent"),
    @NamedQuery(name = "PurchaseOrderDetail.findByCvdAmt", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.cvdAmt = :cvdAmt"),
    @NamedQuery(name = "PurchaseOrderDetail.findByCecPercent", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.cecPercent = :cecPercent"),
    @NamedQuery(name = "PurchaseOrderDetail.findByCecAmt", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.cecAmt = :cecAmt"),
    @NamedQuery(name = "PurchaseOrderDetail.findByScvdPercent", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.scvdPercent = :scvdPercent"),
    @NamedQuery(name = "PurchaseOrderDetail.findByScvdAmt", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.scvdAmt = :scvdAmt"),
    @NamedQuery(name = "PurchaseOrderDetail.findBySpecificDutyPerUnit", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.specificDutyPerUnit = :specificDutyPerUnit"),
    @NamedQuery(name = "PurchaseOrderDetail.findBySpecificDutyAmt", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.specificDutyAmt = :specificDutyAmt"),
    @NamedQuery(name = "PurchaseOrderDetail.findByOtherDutyPercent", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.otherDutyPercent = :otherDutyPercent"),
    @NamedQuery(name = "PurchaseOrderDetail.findByOtherDutyAmt", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.otherDutyAmt = :otherDutyAmt"),
    @NamedQuery(name = "PurchaseOrderDetail.findByTcdAmt", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.tcdAmt = :tcdAmt"),
    @NamedQuery(name = "PurchaseOrderDetail.findByTaxTypeId", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.taxTypeId = :taxTypeId"),
    @NamedQuery(name = "PurchaseOrderDetail.findByVatPercent", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.vatPercent = :vatPercent"),
    @NamedQuery(name = "PurchaseOrderDetail.findByGstPercent", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.gstPercent = :gstPercent"),
    @NamedQuery(name = "PurchaseOrderDetail.findByCessRate", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.cessRate = :cessRate"),
    @NamedQuery(name = "PurchaseOrderDetail.findByItcPercent", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.itcPercent = :itcPercent"),
    @NamedQuery(name = "PurchaseOrderDetail.findByBasicAmt", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.basicAmt = :basicAmt"),
    @NamedQuery(name = "PurchaseOrderDetail.findByCgstAmt", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.cgstAmt = :cgstAmt"),
    @NamedQuery(name = "PurchaseOrderDetail.findBySgstAmt", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.sgstAmt = :sgstAmt"),
    @NamedQuery(name = "PurchaseOrderDetail.findByIgstAmt", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.igstAmt = :igstAmt"),
    @NamedQuery(name = "PurchaseOrderDetail.findByCessAmt", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.cessAmt = :cessAmt"),
    @NamedQuery(name = "PurchaseOrderDetail.findByVatAmt", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.vatAmt = :vatAmt"),
    @NamedQuery(name = "PurchaseOrderDetail.findByTotalAmt", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.totalAmt = :totalAmt"),
    @NamedQuery(name = "PurchaseOrderDetail.findByCgstItc", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.cgstItc = :cgstItc"),
    @NamedQuery(name = "PurchaseOrderDetail.findBySgstItc", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.sgstItc = :sgstItc"),
    @NamedQuery(name = "PurchaseOrderDetail.findByIgstItc", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.igstItc = :igstItc"),
    @NamedQuery(name = "PurchaseOrderDetail.findByCessItc", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.cessItc = :cessItc"),
    @NamedQuery(name = "PurchaseOrderDetail.findByVatItc", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.vatItc = :vatItc"),
    @NamedQuery(name = "PurchaseOrderDetail.findBySuppliedQty", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.suppliedQty = :suppliedQty"),
    @NamedQuery(name = "PurchaseOrderDetail.findByBalanceQty", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.balanceQty = :balanceQty"),
    @NamedQuery(name = "PurchaseOrderDetail.findByCreatedAt", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "PurchaseOrderDetail.findByLastUpdatedAt", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "PurchaseOrderDetail.findByIsActive", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.isActive = :isActive"),
    @NamedQuery(name = "PurchaseOrderDetail.findByIpAddress", query = "SELECT p FROM PurchaseOrderDetail p WHERE p.ipAddress = :ipAddress")})
public class PurchaseOrderDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "purchase_order_detail_id")
    private Integer purchaseOrderDetailId;
    @Column(name = "material_account_master")
    private Integer materialAccountMaster;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "purchase_order_qty")
    private Double purchaseOrderQty;
    @Column(name = "rate")
    private Double rate;
    @Column(name = "qty_rate_inr")
    private Double qtyRateInr;
    @Column(name = "landing_charge")
    private Double landingCharge;
    @Column(name = "av_inr")
    private Double avInr;
    @Column(name = "bcd_percent")
    private Double bcdPercent;
    @Column(name = "bcd_amt")
    private Double bcdAmt;
    @Column(name = "pd_percent")
    private Double pdPercent;
    @Column(name = "pd_amt")
    private Double pdAmt;
    @Column(name = "cvd_percent")
    private Double cvdPercent;
    @Column(name = "cvd_amt")
    private Double cvdAmt;
    @Column(name = "cec_percent")
    private Double cecPercent;
    @Column(name = "cec_amt")
    private Double cecAmt;
    @Column(name = "scvd_percent")
    private Double scvdPercent;
    @Column(name = "scvd_amt")
    private Double scvdAmt;
    @Column(name = "specific_duty_per_unit")
    private Double specificDutyPerUnit;
    @Column(name = "specific_duty_amt")
    private Double specificDutyAmt;
    @Column(name = "other_duty_percent")
    private Double otherDutyPercent;
    @Column(name = "other_duty_amt")
    private Double otherDutyAmt;
    @Column(name = "tcd_amt")
    private Double tcdAmt;
    @Column(name = "tax_type_id")
    private Integer taxTypeId;
    @Column(name = "vat_percent")
    private Double vatPercent;
    @Column(name = "gst_percent")
    private Double gstPercent;
    @Column(name = "cess_rate")
    private Double cessRate;
    @Column(name = "itc_percent")
    private Double itcPercent;
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
    @Column(name = "supplied_qty")
    private Double suppliedQty;
    @Column(name = "balance_qty")
    private Double balanceQty;
    @Lob
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
    @Column(name = "ip_address")
    private String ipAddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderDetailId")
    private List<GoodsRecieptNote> goodsRecieptNoteList;
    @JoinColumn(name = "service_account_master", referencedColumnName = "account_master_id")
    @ManyToOne
    private AccountMaster serviceAccountMaster;
    @JoinColumn(name = "cess_type_id", referencedColumnName = "cess_type_id")
    @ManyToOne
    private CessType cessTypeId;
    @JoinColumn(name = "itc_type_id", referencedColumnName = "itc_type_id")
    @ManyToOne
    private ItcType itcTypeId;
    @JoinColumn(name = "material_master_id", referencedColumnName = "material_master_id")
    @ManyToOne
    private MaterialMaster materialMasterId;
    @JoinColumn(name = "product_type_id", referencedColumnName = "product_type_id")
    @ManyToOne
    private ProductType productTypeId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderDetailId")
    private List<DebitNoteDetail> debitNoteDetailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderDetailId")
    private List<BillDetail> billDetailList;

    public PurchaseOrderDetail() {
    }

    public PurchaseOrderDetail(Integer purchaseOrderDetailId) {
        this.purchaseOrderDetailId = purchaseOrderDetailId;
    }

    public PurchaseOrderDetail(Integer purchaseOrderDetailId, Character isActive) {
        this.purchaseOrderDetailId = purchaseOrderDetailId;
        this.isActive = isActive;
    }

    public Integer getPurchaseOrderDetailId() {
        return purchaseOrderDetailId;
    }

    public void setPurchaseOrderDetailId(Integer purchaseOrderDetailId) {
        this.purchaseOrderDetailId = purchaseOrderDetailId;
    }

    public Integer getMaterialAccountMaster() {
        return materialAccountMaster;
    }

    public void setMaterialAccountMaster(Integer materialAccountMaster) {
        this.materialAccountMaster = materialAccountMaster;
    }

    public Double getPurchaseOrderQty() {
        return purchaseOrderQty;
    }

    public void setPurchaseOrderQty(Double purchaseOrderQty) {
        this.purchaseOrderQty = purchaseOrderQty;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
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

    public Double getBcdPercent() {
        return bcdPercent;
    }

    public void setBcdPercent(Double bcdPercent) {
        this.bcdPercent = bcdPercent;
    }

    public Double getBcdAmt() {
        return bcdAmt;
    }

    public void setBcdAmt(Double bcdAmt) {
        this.bcdAmt = bcdAmt;
    }

    public Double getPdPercent() {
        return pdPercent;
    }

    public void setPdPercent(Double pdPercent) {
        this.pdPercent = pdPercent;
    }

    public Double getPdAmt() {
        return pdAmt;
    }

    public void setPdAmt(Double pdAmt) {
        this.pdAmt = pdAmt;
    }

    public Double getCvdPercent() {
        return cvdPercent;
    }

    public void setCvdPercent(Double cvdPercent) {
        this.cvdPercent = cvdPercent;
    }

    public Double getCvdAmt() {
        return cvdAmt;
    }

    public void setCvdAmt(Double cvdAmt) {
        this.cvdAmt = cvdAmt;
    }

    public Double getCecPercent() {
        return cecPercent;
    }

    public void setCecPercent(Double cecPercent) {
        this.cecPercent = cecPercent;
    }

    public Double getCecAmt() {
        return cecAmt;
    }

    public void setCecAmt(Double cecAmt) {
        this.cecAmt = cecAmt;
    }

    public Double getScvdPercent() {
        return scvdPercent;
    }

    public void setScvdPercent(Double scvdPercent) {
        this.scvdPercent = scvdPercent;
    }

    public Double getScvdAmt() {
        return scvdAmt;
    }

    public void setScvdAmt(Double scvdAmt) {
        this.scvdAmt = scvdAmt;
    }

    public Double getSpecificDutyPerUnit() {
        return specificDutyPerUnit;
    }

    public void setSpecificDutyPerUnit(Double specificDutyPerUnit) {
        this.specificDutyPerUnit = specificDutyPerUnit;
    }

    public Double getSpecificDutyAmt() {
        return specificDutyAmt;
    }

    public void setSpecificDutyAmt(Double specificDutyAmt) {
        this.specificDutyAmt = specificDutyAmt;
    }

    public Double getOtherDutyPercent() {
        return otherDutyPercent;
    }

    public void setOtherDutyPercent(Double otherDutyPercent) {
        this.otherDutyPercent = otherDutyPercent;
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

    public Integer getTaxTypeId() {
        return taxTypeId;
    }

    public void setTaxTypeId(Integer taxTypeId) {
        this.taxTypeId = taxTypeId;
    }

    public Double getVatPercent() {
        return vatPercent;
    }

    public void setVatPercent(Double vatPercent) {
        this.vatPercent = vatPercent;
    }

    public Double getGstPercent() {
        return gstPercent;
    }

    public void setGstPercent(Double gstPercent) {
        this.gstPercent = gstPercent;
    }

    public Double getCessRate() {
        return cessRate;
    }

    public void setCessRate(Double cessRate) {
        this.cessRate = cessRate;
    }

    public Double getItcPercent() {
        return itcPercent;
    }

    public void setItcPercent(Double itcPercent) {
        this.itcPercent = itcPercent;
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

    public Double getSuppliedQty() {
        return suppliedQty;
    }

    public void setSuppliedQty(Double suppliedQty) {
        this.suppliedQty = suppliedQty;
    }

    public Double getBalanceQty() {
        return balanceQty;
    }

    public void setBalanceQty(Double balanceQty) {
        this.balanceQty = balanceQty;
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
    public List<GoodsRecieptNote> getGoodsRecieptNoteList() {
        return goodsRecieptNoteList;
    }

    public void setGoodsRecieptNoteList(List<GoodsRecieptNote> goodsRecieptNoteList) {
        this.goodsRecieptNoteList = goodsRecieptNoteList;
    }

    public AccountMaster getServiceAccountMaster() {
        return serviceAccountMaster;
    }

    public void setServiceAccountMaster(AccountMaster serviceAccountMaster) {
        this.serviceAccountMaster = serviceAccountMaster;
    }

    public CessType getCessTypeId() {
        return cessTypeId;
    }

    public void setCessTypeId(CessType cessTypeId) {
        this.cessTypeId = cessTypeId;
    }

    public ItcType getItcTypeId() {
        return itcTypeId;
    }

    public void setItcTypeId(ItcType itcTypeId) {
        this.itcTypeId = itcTypeId;
    }

    public MaterialMaster getMaterialMasterId() {
        return materialMasterId;
    }

    public void setMaterialMasterId(MaterialMaster materialMasterId) {
        this.materialMasterId = materialMasterId;
    }

    public ProductType getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(ProductType productTypeId) {
        this.productTypeId = productTypeId;
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

    @XmlTransient
    public List<DebitNoteDetail> getDebitNoteDetailList() {
        return debitNoteDetailList;
    }

    public void setDebitNoteDetailList(List<DebitNoteDetail> debitNoteDetailList) {
        this.debitNoteDetailList = debitNoteDetailList;
    }

    @XmlTransient
    public List<BillDetail> getBillDetailList() {
        return billDetailList;
    }

    public void setBillDetailList(List<BillDetail> billDetailList) {
        this.billDetailList = billDetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchaseOrderDetailId != null ? purchaseOrderDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseOrderDetail)) {
            return false;
        }
        PurchaseOrderDetail other = (PurchaseOrderDetail) object;
        if ((this.purchaseOrderDetailId == null && other.purchaseOrderDetailId != null) || (this.purchaseOrderDetailId != null && !this.purchaseOrderDetailId.equals(other.purchaseOrderDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.PurchaseOrderDetail[ purchaseOrderDetailId=" + purchaseOrderDetailId + " ]";
    }
    
}
