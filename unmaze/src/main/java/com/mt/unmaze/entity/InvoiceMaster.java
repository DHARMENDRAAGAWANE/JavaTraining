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
@Table(name = "invoice_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvoiceMaster.findAll", query = "SELECT i FROM InvoiceMaster i"),
    @NamedQuery(name = "InvoiceMaster.findByInvoiceMasterId", query = "SELECT i FROM InvoiceMaster i WHERE i.invoiceMasterId = :invoiceMasterId"),
    @NamedQuery(name = "InvoiceMaster.findByDate", query = "SELECT i FROM InvoiceMaster i WHERE i.date = :date"),
    @NamedQuery(name = "InvoiceMaster.findByInvoiceNo", query = "SELECT i FROM InvoiceMaster i WHERE i.invoiceNo = :invoiceNo"),
    @NamedQuery(name = "InvoiceMaster.findByEWayBillNo", query = "SELECT i FROM InvoiceMaster i WHERE i.eWayBillNo = :eWayBillNo"),
    @NamedQuery(name = "InvoiceMaster.findByShippingBillNo", query = "SELECT i FROM InvoiceMaster i WHERE i.shippingBillNo = :shippingBillNo"),
    @NamedQuery(name = "InvoiceMaster.findByShippingBillDate", query = "SELECT i FROM InvoiceMaster i WHERE i.shippingBillDate = :shippingBillDate"),
    @NamedQuery(name = "InvoiceMaster.findByPortCode", query = "SELECT i FROM InvoiceMaster i WHERE i.portCode = :portCode"),
    @NamedQuery(name = "InvoiceMaster.findByExchangeRate", query = "SELECT i FROM InvoiceMaster i WHERE i.exchangeRate = :exchangeRate"),
    @NamedQuery(name = "InvoiceMaster.findByQtyRateInr", query = "SELECT i FROM InvoiceMaster i WHERE i.qtyRateInr = :qtyRateInr"),
    @NamedQuery(name = "InvoiceMaster.findByCustomerAmt", query = "SELECT i FROM InvoiceMaster i WHERE i.customerAmt = :customerAmt"),
    @NamedQuery(name = "InvoiceMaster.findByDiscountAmt", query = "SELECT i FROM InvoiceMaster i WHERE i.discountAmt = :discountAmt"),
    @NamedQuery(name = "InvoiceMaster.findByServiceChargeAmt", query = "SELECT i FROM InvoiceMaster i WHERE i.serviceChargeAmt = :serviceChargeAmt"),
    @NamedQuery(name = "InvoiceMaster.findByRevenueAmt", query = "SELECT i FROM InvoiceMaster i WHERE i.revenueAmt = :revenueAmt"),
    @NamedQuery(name = "InvoiceMaster.findByCgstPayable", query = "SELECT i FROM InvoiceMaster i WHERE i.cgstPayable = :cgstPayable"),
    @NamedQuery(name = "InvoiceMaster.findBySgstPayable", query = "SELECT i FROM InvoiceMaster i WHERE i.sgstPayable = :sgstPayable"),
    @NamedQuery(name = "InvoiceMaster.findByIgstPayable", query = "SELECT i FROM InvoiceMaster i WHERE i.igstPayable = :igstPayable"),
    @NamedQuery(name = "InvoiceMaster.findByCessPayable", query = "SELECT i FROM InvoiceMaster i WHERE i.cessPayable = :cessPayable"),
    @NamedQuery(name = "InvoiceMaster.findByVatPayable", query = "SELECT i FROM InvoiceMaster i WHERE i.vatPayable = :vatPayable"),
    @NamedQuery(name = "InvoiceMaster.findByDueDate", query = "SELECT i FROM InvoiceMaster i WHERE i.dueDate = :dueDate"),
    @NamedQuery(name = "InvoiceMaster.findByInvoiceStatus", query = "SELECT i FROM InvoiceMaster i WHERE i.invoiceStatus = :invoiceStatus"),
    @NamedQuery(name = "InvoiceMaster.findByActiveStatus", query = "SELECT i FROM InvoiceMaster i WHERE i.activeStatus = :activeStatus"),
    @NamedQuery(name = "InvoiceMaster.findByCreatedAt", query = "SELECT i FROM InvoiceMaster i WHERE i.createdAt = :createdAt"),
    @NamedQuery(name = "InvoiceMaster.findByLastUpdatedAt", query = "SELECT i FROM InvoiceMaster i WHERE i.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "InvoiceMaster.findByIsActive", query = "SELECT i FROM InvoiceMaster i WHERE i.isActive = :isActive"),
    @NamedQuery(name = "InvoiceMaster.findByIpAddress", query = "SELECT i FROM InvoiceMaster i WHERE i.ipAddress = :ipAddress")})
public class InvoiceMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "invoice_master_id")
    private Integer invoiceMasterId;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "invoice_no")
    private String invoiceNo;
    @Column(name = "e_way_bill_no")
    private String eWayBillNo;
    @Column(name = "shipping_bill_no")
    private String shippingBillNo;
    @Column(name = "shipping_bill_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shippingBillDate;
    @Column(name = "port_code")
    private String portCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "exchange_rate")
    private Double exchangeRate;
    @Column(name = "qty_rate_inr")
    private Double qtyRateInr;
    @Column(name = "customer_amt")
    private Double customerAmt;
    @Column(name = "discount_amt")
    private Double discountAmt;
    @Column(name = "service_charge_amt")
    private Double serviceChargeAmt;
    @Column(name = "revenue_amt")
    private Double revenueAmt;
    @Column(name = "cgst_payable")
    private Double cgstPayable;
    @Column(name = "sgst_payable")
    private Double sgstPayable;
    @Column(name = "igst_payable")
    private Double igstPayable;
    @Column(name = "cess_payable")
    private Double cessPayable;
    @Column(name = "vat_payable")
    private Double vatPayable;
    @Column(name = "due_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Column(name = "invoice_status")
    private String invoiceStatus;
    @Column(name = "active_status")
    private String activeStatus;
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
    @JoinColumn(name = "booking_master_id", referencedColumnName = "booking_master_id")
    @ManyToOne(optional = false)
    private BookingMaster bookingMasterId;
    @JoinColumn(name = "invoice_file_asset_id", referencedColumnName = "file_asset_id")
    @ManyToOne
    private FileAsset invoiceFileAssetId;
    @JoinColumn(name = "e_way_bill_file_asset_id", referencedColumnName = "file_asset_id")
    @ManyToOne
    private FileAsset eWayBillFileAssetId;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoiceMasterId")
    private List<InvoiceDetail> invoiceDetailList;
    @OneToMany(mappedBy = "invoiceMasterId")
    private List<GeneralLedger> generalLedgerList;
    @OneToMany(mappedBy = "invoiceMasterId")
    private List<TagMapping> tagMappingList;
    @OneToMany(mappedBy = "invoiceMasterId")
    private List<InvoicePayment> invoicePaymentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoiceMasterId")
    private List<InvoiceApproval> invoiceApprovalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoiceMasterId")
    private List<CreditNoteMaster> creditNoteMasterList;
    @OneToMany(mappedBy = "invoiceMasterId")
    private List<BookingTagMaster> bookingTagMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoiceMasterId")
    private List<CreditNoteDetail> creditNoteDetailList;
    @OneToMany(mappedBy = "invoiceMasterId")
    private List<MaterialTransactionMaster> materialTransactionMasterList;

    public InvoiceMaster() {
    }

    public InvoiceMaster(Integer invoiceMasterId) {
        this.invoiceMasterId = invoiceMasterId;
    }

    public InvoiceMaster(Integer invoiceMasterId, Character isActive) {
        this.invoiceMasterId = invoiceMasterId;
        this.isActive = isActive;
    }

    public Integer getInvoiceMasterId() {
        return invoiceMasterId;
    }

    public void setInvoiceMasterId(Integer invoiceMasterId) {
        this.invoiceMasterId = invoiceMasterId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getEWayBillNo() {
        return eWayBillNo;
    }

    public void setEWayBillNo(String eWayBillNo) {
        this.eWayBillNo = eWayBillNo;
    }

    public String getShippingBillNo() {
        return shippingBillNo;
    }

    public void setShippingBillNo(String shippingBillNo) {
        this.shippingBillNo = shippingBillNo;
    }

    public Date getShippingBillDate() {
        return shippingBillDate;
    }

    public void setShippingBillDate(Date shippingBillDate) {
        this.shippingBillDate = shippingBillDate;
    }

    public String getPortCode() {
        return portCode;
    }

    public void setPortCode(String portCode) {
        this.portCode = portCode;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Double getQtyRateInr() {
        return qtyRateInr;
    }

    public void setQtyRateInr(Double qtyRateInr) {
        this.qtyRateInr = qtyRateInr;
    }

    public Double getCustomerAmt() {
        return customerAmt;
    }

    public void setCustomerAmt(Double customerAmt) {
        this.customerAmt = customerAmt;
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

    public Double getRevenueAmt() {
        return revenueAmt;
    }

    public void setRevenueAmt(Double revenueAmt) {
        this.revenueAmt = revenueAmt;
    }

    public Double getCgstPayable() {
        return cgstPayable;
    }

    public void setCgstPayable(Double cgstPayable) {
        this.cgstPayable = cgstPayable;
    }

    public Double getSgstPayable() {
        return sgstPayable;
    }

    public void setSgstPayable(Double sgstPayable) {
        this.sgstPayable = sgstPayable;
    }

    public Double getIgstPayable() {
        return igstPayable;
    }

    public void setIgstPayable(Double igstPayable) {
        this.igstPayable = igstPayable;
    }

    public Double getCessPayable() {
        return cessPayable;
    }

    public void setCessPayable(Double cessPayable) {
        this.cessPayable = cessPayable;
    }

    public Double getVatPayable() {
        return vatPayable;
    }

    public void setVatPayable(Double vatPayable) {
        this.vatPayable = vatPayable;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
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

    public BookingMaster getBookingMasterId() {
        return bookingMasterId;
    }

    public void setBookingMasterId(BookingMaster bookingMasterId) {
        this.bookingMasterId = bookingMasterId;
    }

    public FileAsset getInvoiceFileAssetId() {
        return invoiceFileAssetId;
    }

    public void setInvoiceFileAssetId(FileAsset invoiceFileAssetId) {
        this.invoiceFileAssetId = invoiceFileAssetId;
    }

    public FileAsset getEWayBillFileAssetId() {
        return eWayBillFileAssetId;
    }

    public void setEWayBillFileAssetId(FileAsset eWayBillFileAssetId) {
        this.eWayBillFileAssetId = eWayBillFileAssetId;
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
    public List<InvoiceDetail> getInvoiceDetailList() {
        return invoiceDetailList;
    }

    public void setInvoiceDetailList(List<InvoiceDetail> invoiceDetailList) {
        this.invoiceDetailList = invoiceDetailList;
    }

    @XmlTransient
    public List<GeneralLedger> getGeneralLedgerList() {
        return generalLedgerList;
    }

    public void setGeneralLedgerList(List<GeneralLedger> generalLedgerList) {
        this.generalLedgerList = generalLedgerList;
    }

    @XmlTransient
    public List<TagMapping> getTagMappingList() {
        return tagMappingList;
    }

    public void setTagMappingList(List<TagMapping> tagMappingList) {
        this.tagMappingList = tagMappingList;
    }

    @XmlTransient
    public List<InvoicePayment> getInvoicePaymentList() {
        return invoicePaymentList;
    }

    public void setInvoicePaymentList(List<InvoicePayment> invoicePaymentList) {
        this.invoicePaymentList = invoicePaymentList;
    }

    @XmlTransient
    public List<InvoiceApproval> getInvoiceApprovalList() {
        return invoiceApprovalList;
    }

    public void setInvoiceApprovalList(List<InvoiceApproval> invoiceApprovalList) {
        this.invoiceApprovalList = invoiceApprovalList;
    }

    @XmlTransient
    public List<CreditNoteMaster> getCreditNoteMasterList() {
        return creditNoteMasterList;
    }

    public void setCreditNoteMasterList(List<CreditNoteMaster> creditNoteMasterList) {
        this.creditNoteMasterList = creditNoteMasterList;
    }

    @XmlTransient
    public List<BookingTagMaster> getBookingTagMasterList() {
        return bookingTagMasterList;
    }

    public void setBookingTagMasterList(List<BookingTagMaster> bookingTagMasterList) {
        this.bookingTagMasterList = bookingTagMasterList;
    }

    @XmlTransient
    public List<CreditNoteDetail> getCreditNoteDetailList() {
        return creditNoteDetailList;
    }

    public void setCreditNoteDetailList(List<CreditNoteDetail> creditNoteDetailList) {
        this.creditNoteDetailList = creditNoteDetailList;
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
        hash += (invoiceMasterId != null ? invoiceMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceMaster)) {
            return false;
        }
        InvoiceMaster other = (InvoiceMaster) object;
        if ((this.invoiceMasterId == null && other.invoiceMasterId != null) || (this.invoiceMasterId != null && !this.invoiceMasterId.equals(other.invoiceMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.InvoiceMaster[ invoiceMasterId=" + invoiceMasterId + " ]";
    }
    
}
