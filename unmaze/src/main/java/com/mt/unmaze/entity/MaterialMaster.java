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
@Table(name = "material_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialMaster.findAll", query = "SELECT m FROM MaterialMaster m"),
    @NamedQuery(name = "MaterialMaster.findByMaterialMasterId", query = "SELECT m FROM MaterialMaster m WHERE m.materialMasterId = :materialMasterId"),
    @NamedQuery(name = "MaterialMaster.findByMaterialMasterName", query = "SELECT m FROM MaterialMaster m WHERE m.materialMasterName = :materialMasterName"),
    @NamedQuery(name = "MaterialMaster.findByHsnCode", query = "SELECT m FROM MaterialMaster m WHERE m.hsnCode = :hsnCode"),
    @NamedQuery(name = "MaterialMaster.findByInitialQty", query = "SELECT m FROM MaterialMaster m WHERE m.initialQty = :initialQty"),
    @NamedQuery(name = "MaterialMaster.findByCurrentQty", query = "SELECT m FROM MaterialMaster m WHERE m.currentQty = :currentQty"),
    @NamedQuery(name = "MaterialMaster.findByVatPercent", query = "SELECT m FROM MaterialMaster m WHERE m.vatPercent = :vatPercent"),
    @NamedQuery(name = "MaterialMaster.findByGstPercent", query = "SELECT m FROM MaterialMaster m WHERE m.gstPercent = :gstPercent"),
    @NamedQuery(name = "MaterialMaster.findByCessRate", query = "SELECT m FROM MaterialMaster m WHERE m.cessRate = :cessRate"),
    @NamedQuery(name = "MaterialMaster.findByItcPercent", query = "SELECT m FROM MaterialMaster m WHERE m.itcPercent = :itcPercent"),
    @NamedQuery(name = "MaterialMaster.findByBcdPercent", query = "SELECT m FROM MaterialMaster m WHERE m.bcdPercent = :bcdPercent"),
    @NamedQuery(name = "MaterialMaster.findByPdPercent", query = "SELECT m FROM MaterialMaster m WHERE m.pdPercent = :pdPercent"),
    @NamedQuery(name = "MaterialMaster.findByCvdPercent", query = "SELECT m FROM MaterialMaster m WHERE m.cvdPercent = :cvdPercent"),
    @NamedQuery(name = "MaterialMaster.findByCecPercent", query = "SELECT m FROM MaterialMaster m WHERE m.cecPercent = :cecPercent"),
    @NamedQuery(name = "MaterialMaster.findByScvdPercent", query = "SELECT m FROM MaterialMaster m WHERE m.scvdPercent = :scvdPercent"),
    @NamedQuery(name = "MaterialMaster.findBySpecificDutyPerUnit", query = "SELECT m FROM MaterialMaster m WHERE m.specificDutyPerUnit = :specificDutyPerUnit"),
    @NamedQuery(name = "MaterialMaster.findByOtherDutyPercent", query = "SELECT m FROM MaterialMaster m WHERE m.otherDutyPercent = :otherDutyPercent"),
    @NamedQuery(name = "MaterialMaster.findByBasicSellingPrice", query = "SELECT m FROM MaterialMaster m WHERE m.basicSellingPrice = :basicSellingPrice"),
    @NamedQuery(name = "MaterialMaster.findByApplicableTax", query = "SELECT m FROM MaterialMaster m WHERE m.applicableTax = :applicableTax"),
    @NamedQuery(name = "MaterialMaster.findByCreatedAt", query = "SELECT m FROM MaterialMaster m WHERE m.createdAt = :createdAt"),
    @NamedQuery(name = "MaterialMaster.findByLastUpdatedAt", query = "SELECT m FROM MaterialMaster m WHERE m.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "MaterialMaster.findByIsActive", query = "SELECT m FROM MaterialMaster m WHERE m.isActive = :isActive"),
    @NamedQuery(name = "MaterialMaster.findByIpAddress", query = "SELECT m FROM MaterialMaster m WHERE m.ipAddress = :ipAddress")})
public class MaterialMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "material_master_id")
    private Integer materialMasterId;
    @Column(name = "material_master_name")
    private String materialMasterName;
    @Column(name = "hsn_code")
    private String hsnCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "initial_qty")
    private Double initialQty;
    @Column(name = "current_qty")
    private Double currentQty;
    @Column(name = "vat_percent")
    private Double vatPercent;
    @Column(name = "gst_percent")
    private Double gstPercent;
    @Column(name = "cess_rate")
    private Double cessRate;
    @Column(name = "itc_percent")
    private Double itcPercent;
    @Column(name = "bcd_percent")
    private Double bcdPercent;
    @Column(name = "pd_percent")
    private Double pdPercent;
    @Column(name = "cvd_percent")
    private Double cvdPercent;
    @Column(name = "cec_percent")
    private Double cecPercent;
    @Column(name = "scvd_percent")
    private Double scvdPercent;
    @Column(name = "specific_duty_per_unit")
    private Double specificDutyPerUnit;
    @Column(name = "other_duty_percent")
    private Double otherDutyPercent;
    @Column(name = "basic_selling_price")
    private Double basicSellingPrice;
    @Basic(optional = false)
    @Column(name = "applicable_tax")
    private double applicableTax;
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
    @OneToMany(mappedBy = "inputMaterialId")
    private List<ProductionComposition> productionCompositionList;
    @OneToMany(mappedBy = "outputMaterialId")
    private List<ProductionComposition> productionCompositionList1;
    @OneToMany(mappedBy = "materialMasterId")
    private List<PurchaseOrderDetail> purchaseOrderDetailList;
    @OneToMany(mappedBy = "materialMasterId")
    private List<InvoiceDetail> invoiceDetailList;
    @OneToMany(mappedBy = "materialMasterId")
    private List<PricingMaster> pricingMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialMasterId")
    private List<MaterialMasterVariantMapping> materialMasterVariantMappingList;
    @OneToMany(mappedBy = "materialMasterId")
    private List<DebitNoteDetail> debitNoteDetailList;
    @OneToMany(mappedBy = "inputMaterialId")
    private List<SalesComposition> salesCompositionList;
    @OneToMany(mappedBy = "outputMaterialId")
    private List<SalesComposition> salesCompositionList1;
    @OneToMany(mappedBy = "materialMasterId")
    private List<CreditNoteDetail> creditNoteDetailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialMasterId")
    private List<MaterialTagLink> materialTagLinkList;
    @JoinColumn(name = "account_master_id", referencedColumnName = "account_master_id")
    @ManyToOne
    private AccountMaster accountMasterId;
    @JoinColumn(name = "cess_type_id", referencedColumnName = "cess_type_id")
    @ManyToOne
    private CessType cessTypeId;
    @JoinColumn(name = "itc_type_id", referencedColumnName = "itc_type_id")
    @ManyToOne
    private ItcType itcTypeId;
    @JoinColumn(name = "material_category_id", referencedColumnName = "material_category_id")
    @ManyToOne
    private MaterialCategory materialCategoryId;
    @JoinColumn(name = "material_type_id", referencedColumnName = "material_type_id")
    @ManyToOne
    private MaterialType materialTypeId;
    @JoinColumn(name = "material_unit_id", referencedColumnName = "material_unit_id")
    @ManyToOne
    private MaterialUnit materialUnitId;
    @JoinColumn(name = "tax_type_id", referencedColumnName = "tax_type_id")
    @ManyToOne
    private TaxType taxTypeId;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @OneToMany(mappedBy = "materialMasterId")
    private List<BookingDetail> bookingDetailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialMasterId")
    private List<MaterialTransactionMaster> materialTransactionMasterList;
    @OneToMany(mappedBy = "materialMasterId")
    private List<BillDetail> billDetailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billOfInMaterial")
    private List<BillOfMaterialMaster> billOfMaterialMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billOfOutMaterial")
    private List<BillOfMaterialMaster> billOfMaterialMasterList1;

    public MaterialMaster() {
    }

    public MaterialMaster(Integer materialMasterId) {
        this.materialMasterId = materialMasterId;
    }

    public MaterialMaster(Integer materialMasterId, double applicableTax, Date lastUpdatedAt, Character isActive) {
        this.materialMasterId = materialMasterId;
        this.applicableTax = applicableTax;
        this.lastUpdatedAt = lastUpdatedAt;
        this.isActive = isActive;
    }

    public Integer getMaterialMasterId() {
        return materialMasterId;
    }

    public void setMaterialMasterId(Integer materialMasterId) {
        this.materialMasterId = materialMasterId;
    }

    public String getMaterialMasterName() {
        return materialMasterName;
    }

    public void setMaterialMasterName(String materialMasterName) {
        this.materialMasterName = materialMasterName;
    }

    public String getHsnCode() {
        return hsnCode;
    }

    public void setHsnCode(String hsnCode) {
        this.hsnCode = hsnCode;
    }

    public Double getInitialQty() {
        return initialQty;
    }

    public void setInitialQty(Double initialQty) {
        this.initialQty = initialQty;
    }

    public Double getCurrentQty() {
        return currentQty;
    }

    public void setCurrentQty(Double currentQty) {
        this.currentQty = currentQty;
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

    public Double getBcdPercent() {
        return bcdPercent;
    }

    public void setBcdPercent(Double bcdPercent) {
        this.bcdPercent = bcdPercent;
    }

    public Double getPdPercent() {
        return pdPercent;
    }

    public void setPdPercent(Double pdPercent) {
        this.pdPercent = pdPercent;
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

    public Double getBasicSellingPrice() {
        return basicSellingPrice;
    }

    public void setBasicSellingPrice(Double basicSellingPrice) {
        this.basicSellingPrice = basicSellingPrice;
    }

    public double getApplicableTax() {
        return applicableTax;
    }

    public void setApplicableTax(double applicableTax) {
        this.applicableTax = applicableTax;
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
    public List<ProductionComposition> getProductionCompositionList() {
        return productionCompositionList;
    }

    public void setProductionCompositionList(List<ProductionComposition> productionCompositionList) {
        this.productionCompositionList = productionCompositionList;
    }

    @XmlTransient
    public List<ProductionComposition> getProductionCompositionList1() {
        return productionCompositionList1;
    }

    public void setProductionCompositionList1(List<ProductionComposition> productionCompositionList1) {
        this.productionCompositionList1 = productionCompositionList1;
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

    @XmlTransient
    public List<MaterialMasterVariantMapping> getMaterialMasterVariantMappingList() {
        return materialMasterVariantMappingList;
    }

    public void setMaterialMasterVariantMappingList(List<MaterialMasterVariantMapping> materialMasterVariantMappingList) {
        this.materialMasterVariantMappingList = materialMasterVariantMappingList;
    }

    @XmlTransient
    public List<DebitNoteDetail> getDebitNoteDetailList() {
        return debitNoteDetailList;
    }

    public void setDebitNoteDetailList(List<DebitNoteDetail> debitNoteDetailList) {
        this.debitNoteDetailList = debitNoteDetailList;
    }

    @XmlTransient
    public List<SalesComposition> getSalesCompositionList() {
        return salesCompositionList;
    }

    public void setSalesCompositionList(List<SalesComposition> salesCompositionList) {
        this.salesCompositionList = salesCompositionList;
    }

    @XmlTransient
    public List<SalesComposition> getSalesCompositionList1() {
        return salesCompositionList1;
    }

    public void setSalesCompositionList1(List<SalesComposition> salesCompositionList1) {
        this.salesCompositionList1 = salesCompositionList1;
    }

    @XmlTransient
    public List<CreditNoteDetail> getCreditNoteDetailList() {
        return creditNoteDetailList;
    }

    public void setCreditNoteDetailList(List<CreditNoteDetail> creditNoteDetailList) {
        this.creditNoteDetailList = creditNoteDetailList;
    }

    @XmlTransient
    public List<MaterialTagLink> getMaterialTagLinkList() {
        return materialTagLinkList;
    }

    public void setMaterialTagLinkList(List<MaterialTagLink> materialTagLinkList) {
        this.materialTagLinkList = materialTagLinkList;
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

    public ItcType getItcTypeId() {
        return itcTypeId;
    }

    public void setItcTypeId(ItcType itcTypeId) {
        this.itcTypeId = itcTypeId;
    }

    public MaterialCategory getMaterialCategoryId() {
        return materialCategoryId;
    }

    public void setMaterialCategoryId(MaterialCategory materialCategoryId) {
        this.materialCategoryId = materialCategoryId;
    }

    public MaterialType getMaterialTypeId() {
        return materialTypeId;
    }

    public void setMaterialTypeId(MaterialType materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    public MaterialUnit getMaterialUnitId() {
        return materialUnitId;
    }

    public void setMaterialUnitId(MaterialUnit materialUnitId) {
        this.materialUnitId = materialUnitId;
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
    public List<BookingDetail> getBookingDetailList() {
        return bookingDetailList;
    }

    public void setBookingDetailList(List<BookingDetail> bookingDetailList) {
        this.bookingDetailList = bookingDetailList;
    }

    @XmlTransient
    public List<MaterialTransactionMaster> getMaterialTransactionMasterList() {
        return materialTransactionMasterList;
    }

    public void setMaterialTransactionMasterList(List<MaterialTransactionMaster> materialTransactionMasterList) {
        this.materialTransactionMasterList = materialTransactionMasterList;
    }

    @XmlTransient
    public List<BillDetail> getBillDetailList() {
        return billDetailList;
    }

    public void setBillDetailList(List<BillDetail> billDetailList) {
        this.billDetailList = billDetailList;
    }

    @XmlTransient
    public List<BillOfMaterialMaster> getBillOfMaterialMasterList() {
        return billOfMaterialMasterList;
    }

    public void setBillOfMaterialMasterList(List<BillOfMaterialMaster> billOfMaterialMasterList) {
        this.billOfMaterialMasterList = billOfMaterialMasterList;
    }

    @XmlTransient
    public List<BillOfMaterialMaster> getBillOfMaterialMasterList1() {
        return billOfMaterialMasterList1;
    }

    public void setBillOfMaterialMasterList1(List<BillOfMaterialMaster> billOfMaterialMasterList1) {
        this.billOfMaterialMasterList1 = billOfMaterialMasterList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materialMasterId != null ? materialMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialMaster)) {
            return false;
        }
        MaterialMaster other = (MaterialMaster) object;
        if ((this.materialMasterId == null && other.materialMasterId != null) || (this.materialMasterId != null && !this.materialMasterId.equals(other.materialMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.MaterialMaster[ materialMasterId=" + materialMasterId + " ]";
    }
    
}
