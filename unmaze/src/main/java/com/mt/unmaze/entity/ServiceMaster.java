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
@Table(name = "service_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceMaster.findAll", query = "SELECT s FROM ServiceMaster s"),
    @NamedQuery(name = "ServiceMaster.findByServiceMasterId", query = "SELECT s FROM ServiceMaster s WHERE s.serviceMasterId = :serviceMasterId"),
    @NamedQuery(name = "ServiceMaster.findByServiceMasterName", query = "SELECT s FROM ServiceMaster s WHERE s.serviceMasterName = :serviceMasterName"),
    @NamedQuery(name = "ServiceMaster.findBySacCode", query = "SELECT s FROM ServiceMaster s WHERE s.sacCode = :sacCode"),
    @NamedQuery(name = "ServiceMaster.findByGstPercent", query = "SELECT s FROM ServiceMaster s WHERE s.gstPercent = :gstPercent"),
    @NamedQuery(name = "ServiceMaster.findByVatPercent", query = "SELECT s FROM ServiceMaster s WHERE s.vatPercent = :vatPercent"),
    @NamedQuery(name = "ServiceMaster.findByCessRate", query = "SELECT s FROM ServiceMaster s WHERE s.cessRate = :cessRate"),
    @NamedQuery(name = "ServiceMaster.findByItcTypeId", query = "SELECT s FROM ServiceMaster s WHERE s.itcTypeId = :itcTypeId"),
    @NamedQuery(name = "ServiceMaster.findByItcPercent", query = "SELECT s FROM ServiceMaster s WHERE s.itcPercent = :itcPercent"),
    @NamedQuery(name = "ServiceMaster.findByBcdPercent", query = "SELECT s FROM ServiceMaster s WHERE s.bcdPercent = :bcdPercent"),
    @NamedQuery(name = "ServiceMaster.findByCvdPercent", query = "SELECT s FROM ServiceMaster s WHERE s.cvdPercent = :cvdPercent"),
    @NamedQuery(name = "ServiceMaster.findByCecPercent", query = "SELECT s FROM ServiceMaster s WHERE s.cecPercent = :cecPercent"),
    @NamedQuery(name = "ServiceMaster.findByPdPercent", query = "SELECT s FROM ServiceMaster s WHERE s.pdPercent = :pdPercent"),
    @NamedQuery(name = "ServiceMaster.findByScvdPercent", query = "SELECT s FROM ServiceMaster s WHERE s.scvdPercent = :scvdPercent"),
    @NamedQuery(name = "ServiceMaster.findBySpecificDutyPerUnit", query = "SELECT s FROM ServiceMaster s WHERE s.specificDutyPerUnit = :specificDutyPerUnit"),
    @NamedQuery(name = "ServiceMaster.findByOtherDutyPercent", query = "SELECT s FROM ServiceMaster s WHERE s.otherDutyPercent = :otherDutyPercent"),
    @NamedQuery(name = "ServiceMaster.findByBestSellingPrice", query = "SELECT s FROM ServiceMaster s WHERE s.bestSellingPrice = :bestSellingPrice"),
    @NamedQuery(name = "ServiceMaster.findByApplicableTax", query = "SELECT s FROM ServiceMaster s WHERE s.applicableTax = :applicableTax"),
    @NamedQuery(name = "ServiceMaster.findByApplicableFor", query = "SELECT s FROM ServiceMaster s WHERE s.applicableFor = :applicableFor"),
    @NamedQuery(name = "ServiceMaster.findByServiceFor", query = "SELECT s FROM ServiceMaster s WHERE s.serviceFor = :serviceFor"),
    @NamedQuery(name = "ServiceMaster.findByCreatedAt", query = "SELECT s FROM ServiceMaster s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "ServiceMaster.findByLastUpdatedAt", query = "SELECT s FROM ServiceMaster s WHERE s.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "ServiceMaster.findByIsActive", query = "SELECT s FROM ServiceMaster s WHERE s.isActive = :isActive"),
    @NamedQuery(name = "ServiceMaster.findByIpAddress", query = "SELECT s FROM ServiceMaster s WHERE s.ipAddress = :ipAddress")})
public class ServiceMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "service_master_id")
    private Integer serviceMasterId;
    @Basic(optional = false)
    @Column(name = "service_master_name")
    private String serviceMasterName;
    @Column(name = "sac_code")
    private Integer sacCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "gst_percent")
    private Double gstPercent;
    @Column(name = "vat_percent")
    private Double vatPercent;
    @Column(name = "cess_rate")
    private Double cessRate;
    @Column(name = "itc_type_id")
    private Integer itcTypeId;
    @Column(name = "itc_percent")
    private Double itcPercent;
    @Column(name = "bcd_percent")
    private Double bcdPercent;
    @Column(name = "cvd_percent")
    private Double cvdPercent;
    @Column(name = "cec_percent")
    private Double cecPercent;
    @Column(name = "pd_percent")
    private Double pdPercent;
    @Column(name = "scvd_percent")
    private Double scvdPercent;
    @Column(name = "specific_duty_per_unit")
    private Double specificDutyPerUnit;
    @Column(name = "other_duty_percent")
    private Double otherDutyPercent;
    @Column(name = "best_selling_price")
    private Double bestSellingPrice;
    @Basic(optional = false)
    @Column(name = "applicable_tax")
    private double applicableTax;
    @Basic(optional = false)
    @Column(name = "applicable_for")
    private String applicableFor;
    @Basic(optional = false)
    @Column(name = "service_for")
    private String serviceFor;
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
    @OneToMany(mappedBy = "serviceMasterId")
    private List<PurchaseOrderDetail> purchaseOrderDetailList;
    @OneToMany(mappedBy = "serviceMasterId")
    private List<InvoiceDetail> invoiceDetailList;
    @OneToMany(mappedBy = "serviceMasterId")
    private List<PricingMaster> pricingMasterList;
    @JoinColumn(name = "account_master_id", referencedColumnName = "account_master_id")
    @ManyToOne
    private AccountMaster accountMasterId;
    @JoinColumn(name = "cess_type_id", referencedColumnName = "cess_type_id")
    @ManyToOne
    private CessType cessTypeId;
    @JoinColumn(name = "service_category_id", referencedColumnName = "service_category_id")
    @ManyToOne
    private ServiceCategory serviceCategoryId;
    @JoinColumn(name = "service_unit_id", referencedColumnName = "service_unit_id")
    @ManyToOne
    private ServiceUnit serviceUnitId;
    @JoinColumn(name = "tax_type_id", referencedColumnName = "tax_type_id")
    @ManyToOne
    private TaxType taxTypeId;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @OneToMany(mappedBy = "serviceMasterId")
    private List<DebitNoteDetail> debitNoteDetailList;
    @OneToMany(mappedBy = "serviceMasterId")
    private List<CreditNoteDetail> creditNoteDetailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceId")
    private List<ServiceTagLink> serviceTagLinkList;
    @OneToMany(mappedBy = "serviceMasterId")
    private List<BookingDetail> bookingDetailList;
    @OneToMany(mappedBy = "serviceMasterId")
    private List<BillDetail> billDetailList;

    public ServiceMaster() {
    }

    public ServiceMaster(Integer serviceMasterId) {
        this.serviceMasterId = serviceMasterId;
    }

    public ServiceMaster(Integer serviceMasterId, String serviceMasterName, double applicableTax, String applicableFor, String serviceFor, Date lastUpdatedAt, Character isActive) {
        this.serviceMasterId = serviceMasterId;
        this.serviceMasterName = serviceMasterName;
        this.applicableTax = applicableTax;
        this.applicableFor = applicableFor;
        this.serviceFor = serviceFor;
        this.lastUpdatedAt = lastUpdatedAt;
        this.isActive = isActive;
    }

    public Integer getServiceMasterId() {
        return serviceMasterId;
    }

    public void setServiceMasterId(Integer serviceMasterId) {
        this.serviceMasterId = serviceMasterId;
    }

    public String getServiceMasterName() {
        return serviceMasterName;
    }

    public void setServiceMasterName(String serviceMasterName) {
        this.serviceMasterName = serviceMasterName;
    }

    public Integer getSacCode() {
        return sacCode;
    }

    public void setSacCode(Integer sacCode) {
        this.sacCode = sacCode;
    }

    public Double getGstPercent() {
        return gstPercent;
    }

    public void setGstPercent(Double gstPercent) {
        this.gstPercent = gstPercent;
    }

    public Double getVatPercent() {
        return vatPercent;
    }

    public void setVatPercent(Double vatPercent) {
        this.vatPercent = vatPercent;
    }

    public Double getCessRate() {
        return cessRate;
    }

    public void setCessRate(Double cessRate) {
        this.cessRate = cessRate;
    }

    public Integer getItcTypeId() {
        return itcTypeId;
    }

    public void setItcTypeId(Integer itcTypeId) {
        this.itcTypeId = itcTypeId;
    }

    public Double getItcPercent() {
        return itcPercent;
    }

    public void setItcPercent(Double itcPercent) {
        this.itcPercent = itcPercent;
    }

    public Double getBcdPercent() {
        return bcdPercent;
    }

    public void setBcdPercent(Double bcdPercent) {
        this.bcdPercent = bcdPercent;
    }

    public Double getCvdPercent() {
        return cvdPercent;
    }

    public void setCvdPercent(Double cvdPercent) {
        this.cvdPercent = cvdPercent;
    }

    public Double getCecPercent() {
        return cecPercent;
    }

    public void setCecPercent(Double cecPercent) {
        this.cecPercent = cecPercent;
    }

    public Double getPdPercent() {
        return pdPercent;
    }

    public void setPdPercent(Double pdPercent) {
        this.pdPercent = pdPercent;
    }

    public Double getScvdPercent() {
        return scvdPercent;
    }

    public void setScvdPercent(Double scvdPercent) {
        this.scvdPercent = scvdPercent;
    }

    public Double getSpecificDutyPerUnit() {
        return specificDutyPerUnit;
    }

    public void setSpecificDutyPerUnit(Double specificDutyPerUnit) {
        this.specificDutyPerUnit = specificDutyPerUnit;
    }

    public Double getOtherDutyPercent() {
        return otherDutyPercent;
    }

    public void setOtherDutyPercent(Double otherDutyPercent) {
        this.otherDutyPercent = otherDutyPercent;
    }

    public Double getBestSellingPrice() {
        return bestSellingPrice;
    }

    public void setBestSellingPrice(Double bestSellingPrice) {
        this.bestSellingPrice = bestSellingPrice;
    }

    public double getApplicableTax() {
        return applicableTax;
    }

    public void setApplicableTax(double applicableTax) {
        this.applicableTax = applicableTax;
    }

    public String getApplicableFor() {
        return applicableFor;
    }

    public void setApplicableFor(String applicableFor) {
        this.applicableFor = applicableFor;
    }

    public String getServiceFor() {
        return serviceFor;
    }

    public void setServiceFor(String serviceFor) {
        this.serviceFor = serviceFor;
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
    public List<PurchaseOrderDetail> getPurchaseOrderDetailList() {
        return purchaseOrderDetailList;
    }

    public void setPurchaseOrderDetailList(List<PurchaseOrderDetail> purchaseOrderDetailList) {
        this.purchaseOrderDetailList = purchaseOrderDetailList;
    }

    @XmlTransient
    public List<InvoiceDetail> getInvoiceDetailList() {
        return invoiceDetailList;
    }

    public void setInvoiceDetailList(List<InvoiceDetail> invoiceDetailList) {
        this.invoiceDetailList = invoiceDetailList;
    }

    @XmlTransient
    public List<PricingMaster> getPricingMasterList() {
        return pricingMasterList;
    }

    public void setPricingMasterList(List<PricingMaster> pricingMasterList) {
        this.pricingMasterList = pricingMasterList;
    }

    public AccountMaster getAccountMasterId() {
        return accountMasterId;
    }

    public void setAccountMasterId(AccountMaster accountMasterId) {
        this.accountMasterId = accountMasterId;
    }

    public CessType getCessTypeId() {
        return cessTypeId;
    }

    public void setCessTypeId(CessType cessTypeId) {
        this.cessTypeId = cessTypeId;
    }

    public ServiceCategory getServiceCategoryId() {
        return serviceCategoryId;
    }

    public void setServiceCategoryId(ServiceCategory serviceCategoryId) {
        this.serviceCategoryId = serviceCategoryId;
    }

    public ServiceUnit getServiceUnitId() {
        return serviceUnitId;
    }

    public void setServiceUnitId(ServiceUnit serviceUnitId) {
        this.serviceUnitId = serviceUnitId;
    }

    public TaxType getTaxTypeId() {
        return taxTypeId;
    }

    public void setTaxTypeId(TaxType taxTypeId) {
        this.taxTypeId = taxTypeId;
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
    public List<CreditNoteDetail> getCreditNoteDetailList() {
        return creditNoteDetailList;
    }

    public void setCreditNoteDetailList(List<CreditNoteDetail> creditNoteDetailList) {
        this.creditNoteDetailList = creditNoteDetailList;
    }

    @XmlTransient
    public List<ServiceTagLink> getServiceTagLinkList() {
        return serviceTagLinkList;
    }

    public void setServiceTagLinkList(List<ServiceTagLink> serviceTagLinkList) {
        this.serviceTagLinkList = serviceTagLinkList;
    }

    @XmlTransient
    public List<BookingDetail> getBookingDetailList() {
        return bookingDetailList;
    }

    public void setBookingDetailList(List<BookingDetail> bookingDetailList) {
        this.bookingDetailList = bookingDetailList;
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
        hash += (serviceMasterId != null ? serviceMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceMaster)) {
            return false;
        }
        ServiceMaster other = (ServiceMaster) object;
        if ((this.serviceMasterId == null && other.serviceMasterId != null) || (this.serviceMasterId != null && !this.serviceMasterId.equals(other.serviceMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.ServiceMaster[ serviceMasterId=" + serviceMasterId + " ]";
    }
    
}
