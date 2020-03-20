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
@Table(name = "booking_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookingDetail.findAll", query = "SELECT b FROM BookingDetail b"),
    @NamedQuery(name = "BookingDetail.findByBookingDetailId", query = "SELECT b FROM BookingDetail b WHERE b.bookingDetailId = :bookingDetailId"),
    @NamedQuery(name = "BookingDetail.findByBookingQty", query = "SELECT b FROM BookingDetail b WHERE b.bookingQty = :bookingQty"),
    @NamedQuery(name = "BookingDetail.findByRate", query = "SELECT b FROM BookingDetail b WHERE b.rate = :rate"),
    @NamedQuery(name = "BookingDetail.findByQtyRateInr", query = "SELECT b FROM BookingDetail b WHERE b.qtyRateInr = :qtyRateInr"),
    @NamedQuery(name = "BookingDetail.findByDiscountPercent", query = "SELECT b FROM BookingDetail b WHERE b.discountPercent = :discountPercent"),
    @NamedQuery(name = "BookingDetail.findByServiceChargePercent", query = "SELECT b FROM BookingDetail b WHERE b.serviceChargePercent = :serviceChargePercent"),
    @NamedQuery(name = "BookingDetail.findByVatPercent", query = "SELECT b FROM BookingDetail b WHERE b.vatPercent = :vatPercent"),
    @NamedQuery(name = "BookingDetail.findByGstPercent", query = "SELECT b FROM BookingDetail b WHERE b.gstPercent = :gstPercent"),
    @NamedQuery(name = "BookingDetail.findByApplicableRatePercent", query = "SELECT b FROM BookingDetail b WHERE b.applicableRatePercent = :applicableRatePercent"),
    @NamedQuery(name = "BookingDetail.findByCessRate", query = "SELECT b FROM BookingDetail b WHERE b.cessRate = :cessRate"),
    @NamedQuery(name = "BookingDetail.findByBasicAmt", query = "SELECT b FROM BookingDetail b WHERE b.basicAmt = :basicAmt"),
    @NamedQuery(name = "BookingDetail.findByCgstAmt", query = "SELECT b FROM BookingDetail b WHERE b.cgstAmt = :cgstAmt"),
    @NamedQuery(name = "BookingDetail.findBySgstAmt", query = "SELECT b FROM BookingDetail b WHERE b.sgstAmt = :sgstAmt"),
    @NamedQuery(name = "BookingDetail.findByIgstAmt", query = "SELECT b FROM BookingDetail b WHERE b.igstAmt = :igstAmt"),
    @NamedQuery(name = "BookingDetail.findByCessAmt", query = "SELECT b FROM BookingDetail b WHERE b.cessAmt = :cessAmt"),
    @NamedQuery(name = "BookingDetail.findByVatAmt", query = "SELECT b FROM BookingDetail b WHERE b.vatAmt = :vatAmt"),
    @NamedQuery(name = "BookingDetail.findByDiscountAmt", query = "SELECT b FROM BookingDetail b WHERE b.discountAmt = :discountAmt"),
    @NamedQuery(name = "BookingDetail.findByServiceChargeAmt", query = "SELECT b FROM BookingDetail b WHERE b.serviceChargeAmt = :serviceChargeAmt"),
    @NamedQuery(name = "BookingDetail.findByTotalAmt", query = "SELECT b FROM BookingDetail b WHERE b.totalAmt = :totalAmt"),
    @NamedQuery(name = "BookingDetail.findBySuppliedQty", query = "SELECT b FROM BookingDetail b WHERE b.suppliedQty = :suppliedQty"),
    @NamedQuery(name = "BookingDetail.findByBalanceQty", query = "SELECT b FROM BookingDetail b WHERE b.balanceQty = :balanceQty"),
    @NamedQuery(name = "BookingDetail.findByCreatedAt", query = "SELECT b FROM BookingDetail b WHERE b.createdAt = :createdAt"),
    @NamedQuery(name = "BookingDetail.findByLastUpdatedAt", query = "SELECT b FROM BookingDetail b WHERE b.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "BookingDetail.findByIsActive", query = "SELECT b FROM BookingDetail b WHERE b.isActive = :isActive"),
    @NamedQuery(name = "BookingDetail.findByIpAddress", query = "SELECT b FROM BookingDetail b WHERE b.ipAddress = :ipAddress")})
public class BookingDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "booking_detail_id")
    private Integer bookingDetailId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "booking_qty")
    private Double bookingQty;
    @Column(name = "rate")
    private Double rate;
    @Column(name = "qty_rate_inr")
    private Double qtyRateInr;
    @Column(name = "discount_percent")
    private Double discountPercent;
    @Column(name = "service_charge_percent")
    private Double serviceChargePercent;
    @Column(name = "vat_percent")
    private Double vatPercent;
    @Column(name = "gst_percent")
    private Double gstPercent;
    @Column(name = "applicable_rate_percent")
    private Double applicableRatePercent;
    @Column(name = "cess_rate")
    private Double cessRate;
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
    @Column(name = "discount_amt")
    private Double discountAmt;
    @Column(name = "service_charge_amt")
    private Double serviceChargeAmt;
    @Column(name = "total_amt")
    private Double totalAmt;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingDetailId")
    private List<InvoiceDetail> invoiceDetailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingDetailId")
    private List<CreditNoteDetail> creditNoteDetailList;
    @JoinColumn(name = "booking_master_id", referencedColumnName = "booking_master_id")
    @ManyToOne(optional = false)
    private BookingMaster bookingMasterId;
    @JoinColumn(name = "cess_type_id", referencedColumnName = "cess_type_id")
    @ManyToOne
    private CessType cessTypeId;
    @JoinColumn(name = "material_master_id", referencedColumnName = "material_master_id")
    @ManyToOne
    private MaterialMaster materialMasterId;
    @JoinColumn(name = "product_type_id", referencedColumnName = "product_type_id")
    @ManyToOne
    private ProductType productTypeId;
    @JoinColumn(name = "service_master_id", referencedColumnName = "service_master_id")
    @ManyToOne
    private ServiceMaster serviceMasterId;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;

    public BookingDetail() {
    }

    public BookingDetail(Integer bookingDetailId) {
        this.bookingDetailId = bookingDetailId;
    }

    public BookingDetail(Integer bookingDetailId, Character isActive) {
        this.bookingDetailId = bookingDetailId;
        this.isActive = isActive;
    }

    public Integer getBookingDetailId() {
        return bookingDetailId;
    }

    public void setBookingDetailId(Integer bookingDetailId) {
        this.bookingDetailId = bookingDetailId;
    }

    public Double getBookingQty() {
        return bookingQty;
    }

    public void setBookingQty(Double bookingQty) {
        this.bookingQty = bookingQty;
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

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Double getServiceChargePercent() {
        return serviceChargePercent;
    }

    public void setServiceChargePercent(Double serviceChargePercent) {
        this.serviceChargePercent = serviceChargePercent;
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

    public Double getApplicableRatePercent() {
        return applicableRatePercent;
    }

    public void setApplicableRatePercent(Double applicableRatePercent) {
        this.applicableRatePercent = applicableRatePercent;
    }

    public Double getCessRate() {
        return cessRate;
    }

    public void setCessRate(Double cessRate) {
        this.cessRate = cessRate;
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

    public Double getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(Double discountAmt) {
        this.discountAmt = discountAmt;
    }

    public Double getServiceChargeAmt() {
        return serviceChargeAmt;
    }

    public void setServiceChargeAmt(Double serviceChargeAmt) {
        this.serviceChargeAmt = serviceChargeAmt;
    }

    public Double getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(Double totalAmt) {
        this.totalAmt = totalAmt;
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
    public List<InvoiceDetail> getInvoiceDetailList() {
        return invoiceDetailList;
    }

    public void setInvoiceDetailList(List<InvoiceDetail> invoiceDetailList) {
        this.invoiceDetailList = invoiceDetailList;
    }

    @XmlTransient
    public List<CreditNoteDetail> getCreditNoteDetailList() {
        return creditNoteDetailList;
    }

    public void setCreditNoteDetailList(List<CreditNoteDetail> creditNoteDetailList) {
        this.creditNoteDetailList = creditNoteDetailList;
    }

    public BookingMaster getBookingMasterId() {
        return bookingMasterId;
    }

    public void setBookingMasterId(BookingMaster bookingMasterId) {
        this.bookingMasterId = bookingMasterId;
    }

    public CessType getCessTypeId() {
        return cessTypeId;
    }

    public void setCessTypeId(CessType cessTypeId) {
        this.cessTypeId = cessTypeId;
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
        hash += (bookingDetailId != null ? bookingDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookingDetail)) {
            return false;
        }
        BookingDetail other = (BookingDetail) object;
        if ((this.bookingDetailId == null && other.bookingDetailId != null) || (this.bookingDetailId != null && !this.bookingDetailId.equals(other.bookingDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.BookingDetail[ bookingDetailId=" + bookingDetailId + " ]";
    }
    
}
