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
@Table(name = "booking_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookingMaster.findAll", query = "SELECT b FROM BookingMaster b"),
    @NamedQuery(name = "BookingMaster.findByBookingMasterId", query = "SELECT b FROM BookingMaster b WHERE b.bookingMasterId = :bookingMasterId"),
    @NamedQuery(name = "BookingMaster.findByBookingNo", query = "SELECT b FROM BookingMaster b WHERE b.bookingNo = :bookingNo"),
    @NamedQuery(name = "BookingMaster.findByDate", query = "SELECT b FROM BookingMaster b WHERE b.date = :date"),
    @NamedQuery(name = "BookingMaster.findByCurrency", query = "SELECT b FROM BookingMaster b WHERE b.currency = :currency"),
    @NamedQuery(name = "BookingMaster.findByExchangeRate", query = "SELECT b FROM BookingMaster b WHERE b.exchangeRate = :exchangeRate"),
    @NamedQuery(name = "BookingMaster.findByReverseCharge", query = "SELECT b FROM BookingMaster b WHERE b.reverseCharge = :reverseCharge"),
    @NamedQuery(name = "BookingMaster.findByQtyRateInr", query = "SELECT b FROM BookingMaster b WHERE b.qtyRateInr = :qtyRateInr"),
    @NamedQuery(name = "BookingMaster.findByDiscountAmt", query = "SELECT b FROM BookingMaster b WHERE b.discountAmt = :discountAmt"),
    @NamedQuery(name = "BookingMaster.findByServiceChargeAmt", query = "SELECT b FROM BookingMaster b WHERE b.serviceChargeAmt = :serviceChargeAmt"),
    @NamedQuery(name = "BookingMaster.findByBasicAmt", query = "SELECT b FROM BookingMaster b WHERE b.basicAmt = :basicAmt"),
    @NamedQuery(name = "BookingMaster.findByCgstAmt", query = "SELECT b FROM BookingMaster b WHERE b.cgstAmt = :cgstAmt"),
    @NamedQuery(name = "BookingMaster.findBySgstAmt", query = "SELECT b FROM BookingMaster b WHERE b.sgstAmt = :sgstAmt"),
    @NamedQuery(name = "BookingMaster.findByIgstAmt", query = "SELECT b FROM BookingMaster b WHERE b.igstAmt = :igstAmt"),
    @NamedQuery(name = "BookingMaster.findByCessAmt", query = "SELECT b FROM BookingMaster b WHERE b.cessAmt = :cessAmt"),
    @NamedQuery(name = "BookingMaster.findByVatAmt", query = "SELECT b FROM BookingMaster b WHERE b.vatAmt = :vatAmt"),
    @NamedQuery(name = "BookingMaster.findByTotalAmt", query = "SELECT b FROM BookingMaster b WHERE b.totalAmt = :totalAmt"),
    @NamedQuery(name = "BookingMaster.findByCustomerAmt", query = "SELECT b FROM BookingMaster b WHERE b.customerAmt = :customerAmt"),
    @NamedQuery(name = "BookingMaster.findByPaymentAmt", query = "SELECT b FROM BookingMaster b WHERE b.paymentAmt = :paymentAmt"),
    @NamedQuery(name = "BookingMaster.findByBalanceAmt", query = "SELECT b FROM BookingMaster b WHERE b.balanceAmt = :balanceAmt"),
    @NamedQuery(name = "BookingMaster.findByBookingStatus", query = "SELECT b FROM BookingMaster b WHERE b.bookingStatus = :bookingStatus"),
    @NamedQuery(name = "BookingMaster.findByActiveStatus", query = "SELECT b FROM BookingMaster b WHERE b.activeStatus = :activeStatus"),
    @NamedQuery(name = "BookingMaster.findByCreatedAt", query = "SELECT b FROM BookingMaster b WHERE b.createdAt = :createdAt"),
    @NamedQuery(name = "BookingMaster.findByLastUpdatedAt", query = "SELECT b FROM BookingMaster b WHERE b.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "BookingMaster.findByIsActive", query = "SELECT b FROM BookingMaster b WHERE b.isActive = :isActive"),
    @NamedQuery(name = "BookingMaster.findByIpAddress", query = "SELECT b FROM BookingMaster b WHERE b.ipAddress = :ipAddress")})
public class BookingMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "booking_master_id")
    private Integer bookingMasterId;
    @Basic(optional = false)
    @Column(name = "booking_no")
    private String bookingNo;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "currency")
    private String currency;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "exchange_rate")
    private Double exchangeRate;
    @Column(name = "reverse_charge")
    private String reverseCharge;
    @Column(name = "qty_rate_inr")
    private Double qtyRateInr;
    @Column(name = "discount_amt")
    private Double discountAmt;
    @Column(name = "service_charge_amt")
    private Double serviceChargeAmt;
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
    @Column(name = "customer_amt")
    private Double customerAmt;
    @Column(name = "payment_amt")
    private Double paymentAmt;
    @Column(name = "balance_amt")
    private Double balanceAmt;
    @Column(name = "booking_status")
    private String bookingStatus;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingMasterId")
    private List<InvoiceMaster> invoiceMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingMasterId")
    private List<InvoiceDetail> invoiceDetailList;
    @OneToMany(mappedBy = "bookingMasterId")
    private List<TagMapping> tagMappingList;
    @OneToMany(mappedBy = "bookingMasterId")
    private List<InvoicePayment> invoicePaymentList;
    @JoinColumn(name = "branch_master_id", referencedColumnName = "branch_master_id")
    @ManyToOne
    private BranchMaster branchMasterId;
    @JoinColumn(name = "country_of_supply", referencedColumnName = "country_id")
    @ManyToOne
    private Country countryOfSupply;
    @JoinColumn(name = "customer_master_id", referencedColumnName = "customer_master_id")
    @ManyToOne
    private CustomerMaster customerMasterId;
    @JoinColumn(name = "project_master_id", referencedColumnName = "project_master_id")
    @ManyToOne
    private ProjectMaster projectMasterId;
    @JoinColumn(name = "sales_type_id", referencedColumnName = "sales_type_id")
    @ManyToOne
    private SalesType salesTypeId;
    @JoinColumn(name = "state_of_supply", referencedColumnName = "state_id")
    @ManyToOne
    private State stateOfSupply;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingMasterId")
    private List<CreditNoteMaster> creditNoteMasterList;
    @OneToMany(mappedBy = "bookingMasterId")
    private List<BookingTagMaster> bookingTagMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingMasterId")
    private List<CreditNoteDetail> creditNoteDetailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingMasterId")
    private List<BookingDetail> bookingDetailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingMasterId")
    private List<BookingApproval> bookingApprovalList;
    @OneToMany(mappedBy = "bookingMasterId")
    private List<PoTagMaster> poTagMasterList;

    public BookingMaster() {
    }

    public BookingMaster(Integer bookingMasterId) {
        this.bookingMasterId = bookingMasterId;
    }

    public BookingMaster(Integer bookingMasterId, String bookingNo, Character isActive) {
        this.bookingMasterId = bookingMasterId;
        this.bookingNo = bookingNo;
        this.isActive = isActive;
    }

    public Integer getBookingMasterId() {
        return bookingMasterId;
    }

    public void setBookingMasterId(Integer bookingMasterId) {
        this.bookingMasterId = bookingMasterId;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getReverseCharge() {
        return reverseCharge;
    }

    public void setReverseCharge(String reverseCharge) {
        this.reverseCharge = reverseCharge;
    }

    public Double getQtyRateInr() {
        return qtyRateInr;
    }

    public void setQtyRateInr(Double qtyRateInr) {
        this.qtyRateInr = qtyRateInr;
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

    public Double getCustomerAmt() {
        return customerAmt;
    }

    public void setCustomerAmt(Double customerAmt) {
        this.customerAmt = customerAmt;
    }

    public Double getPaymentAmt() {
        return paymentAmt;
    }

    public void setPaymentAmt(Double paymentAmt) {
        this.paymentAmt = paymentAmt;
    }

    public Double getBalanceAmt() {
        return balanceAmt;
    }

    public void setBalanceAmt(Double balanceAmt) {
        this.balanceAmt = balanceAmt;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
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

    @XmlTransient
    public List<InvoiceMaster> getInvoiceMasterList() {
        return invoiceMasterList;
    }

    public void setInvoiceMasterList(List<InvoiceMaster> invoiceMasterList) {
        this.invoiceMasterList = invoiceMasterList;
    }

    @XmlTransient
    public List<InvoiceDetail> getInvoiceDetailList() {
        return invoiceDetailList;
    }

    public void setInvoiceDetailList(List<InvoiceDetail> invoiceDetailList) {
        this.invoiceDetailList = invoiceDetailList;
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

    public BranchMaster getBranchMasterId() {
        return branchMasterId;
    }

    public void setBranchMasterId(BranchMaster branchMasterId) {
        this.branchMasterId = branchMasterId;
    }

    public Country getCountryOfSupply() {
        return countryOfSupply;
    }

    public void setCountryOfSupply(Country countryOfSupply) {
        this.countryOfSupply = countryOfSupply;
    }

    public CustomerMaster getCustomerMasterId() {
        return customerMasterId;
    }

    public void setCustomerMasterId(CustomerMaster customerMasterId) {
        this.customerMasterId = customerMasterId;
    }

    public ProjectMaster getProjectMasterId() {
        return projectMasterId;
    }

    public void setProjectMasterId(ProjectMaster projectMasterId) {
        this.projectMasterId = projectMasterId;
    }

    public SalesType getSalesTypeId() {
        return salesTypeId;
    }

    public void setSalesTypeId(SalesType salesTypeId) {
        this.salesTypeId = salesTypeId;
    }

    public State getStateOfSupply() {
        return stateOfSupply;
    }

    public void setStateOfSupply(State stateOfSupply) {
        this.stateOfSupply = stateOfSupply;
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
    public List<BookingDetail> getBookingDetailList() {
        return bookingDetailList;
    }

    public void setBookingDetailList(List<BookingDetail> bookingDetailList) {
        this.bookingDetailList = bookingDetailList;
    }

    @XmlTransient
    public List<BookingApproval> getBookingApprovalList() {
        return bookingApprovalList;
    }

    public void setBookingApprovalList(List<BookingApproval> bookingApprovalList) {
        this.bookingApprovalList = bookingApprovalList;
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
        hash += (bookingMasterId != null ? bookingMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookingMaster)) {
            return false;
        }
        BookingMaster other = (BookingMaster) object;
        if ((this.bookingMasterId == null && other.bookingMasterId != null) || (this.bookingMasterId != null && !this.bookingMasterId.equals(other.bookingMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.BookingMaster[ bookingMasterId=" + bookingMasterId + " ]";
    }
    
}
