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
@Table(name = "bill_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BillMaster.findAll", query = "SELECT b FROM BillMaster b"),
    @NamedQuery(name = "BillMaster.findByBillMasterId", query = "SELECT b FROM BillMaster b WHERE b.billMasterId = :billMasterId"),
    @NamedQuery(name = "BillMaster.findByBillNo", query = "SELECT b FROM BillMaster b WHERE b.billNo = :billNo"),
    @NamedQuery(name = "BillMaster.findByDate", query = "SELECT b FROM BillMaster b WHERE b.date = :date"),
    @NamedQuery(name = "BillMaster.findByEWayBillNo", query = "SELECT b FROM BillMaster b WHERE b.eWayBillNo = :eWayBillNo"),
    @NamedQuery(name = "BillMaster.findByBillEntryNo", query = "SELECT b FROM BillMaster b WHERE b.billEntryNo = :billEntryNo"),
    @NamedQuery(name = "BillMaster.findByBillEntryDate", query = "SELECT b FROM BillMaster b WHERE b.billEntryDate = :billEntryDate"),
    @NamedQuery(name = "BillMaster.findByPortCode", query = "SELECT b FROM BillMaster b WHERE b.portCode = :portCode"),
    @NamedQuery(name = "BillMaster.findByExchangeRate", query = "SELECT b FROM BillMaster b WHERE b.exchangeRate = :exchangeRate"),
    @NamedQuery(name = "BillMaster.findByVendorAmt", query = "SELECT b FROM BillMaster b WHERE b.vendorAmt = :vendorAmt"),
    @NamedQuery(name = "BillMaster.findByExpenseAmt", query = "SELECT b FROM BillMaster b WHERE b.expenseAmt = :expenseAmt"),
    @NamedQuery(name = "BillMaster.findByCustomsDuty", query = "SELECT b FROM BillMaster b WHERE b.customsDuty = :customsDuty"),
    @NamedQuery(name = "BillMaster.findByCustomsDutyPayable", query = "SELECT b FROM BillMaster b WHERE b.customsDutyPayable = :customsDutyPayable"),
    @NamedQuery(name = "BillMaster.findByCgstPayable", query = "SELECT b FROM BillMaster b WHERE b.cgstPayable = :cgstPayable"),
    @NamedQuery(name = "BillMaster.findBySgstPayable", query = "SELECT b FROM BillMaster b WHERE b.sgstPayable = :sgstPayable"),
    @NamedQuery(name = "BillMaster.findByIgstPayable", query = "SELECT b FROM BillMaster b WHERE b.igstPayable = :igstPayable"),
    @NamedQuery(name = "BillMaster.findByCessPayable", query = "SELECT b FROM BillMaster b WHERE b.cessPayable = :cessPayable"),
    @NamedQuery(name = "BillMaster.findByVatPayable", query = "SELECT b FROM BillMaster b WHERE b.vatPayable = :vatPayable"),
    @NamedQuery(name = "BillMaster.findByCgstItc", query = "SELECT b FROM BillMaster b WHERE b.cgstItc = :cgstItc"),
    @NamedQuery(name = "BillMaster.findBySgstItc", query = "SELECT b FROM BillMaster b WHERE b.sgstItc = :sgstItc"),
    @NamedQuery(name = "BillMaster.findByIgstItc", query = "SELECT b FROM BillMaster b WHERE b.igstItc = :igstItc"),
    @NamedQuery(name = "BillMaster.findByCessItc", query = "SELECT b FROM BillMaster b WHERE b.cessItc = :cessItc"),
    @NamedQuery(name = "BillMaster.findByVatItc", query = "SELECT b FROM BillMaster b WHERE b.vatItc = :vatItc"),
    @NamedQuery(name = "BillMaster.findByTotalAmt", query = "SELECT b FROM BillMaster b WHERE b.totalAmt = :totalAmt"),
    @NamedQuery(name = "BillMaster.findByBasicAmt", query = "SELECT b FROM BillMaster b WHERE b.basicAmt = :basicAmt"),
    @NamedQuery(name = "BillMaster.findByPaidAmt", query = "SELECT b FROM BillMaster b WHERE b.paidAmt = :paidAmt"),
    @NamedQuery(name = "BillMaster.findByDebitNoteTotalAmt", query = "SELECT b FROM BillMaster b WHERE b.debitNoteTotalAmt = :debitNoteTotalAmt"),
    @NamedQuery(name = "BillMaster.findByDueDate", query = "SELECT b FROM BillMaster b WHERE b.dueDate = :dueDate"),
    @NamedQuery(name = "BillMaster.findByBillStatus", query = "SELECT b FROM BillMaster b WHERE b.billStatus = :billStatus"),
    @NamedQuery(name = "BillMaster.findByActiveStatus", query = "SELECT b FROM BillMaster b WHERE b.activeStatus = :activeStatus"),
    @NamedQuery(name = "BillMaster.findByCreatedAt", query = "SELECT b FROM BillMaster b WHERE b.createdAt = :createdAt"),
    @NamedQuery(name = "BillMaster.findByLastUpdatedAt", query = "SELECT b FROM BillMaster b WHERE b.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "BillMaster.findByIsActive", query = "SELECT b FROM BillMaster b WHERE b.isActive = :isActive"),
    @NamedQuery(name = "BillMaster.findByIpAddress", query = "SELECT b FROM BillMaster b WHERE b.ipAddress = :ipAddress")})
public class BillMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bill_master_id")
    private Integer billMasterId;
    @Basic(optional = false)
    @Column(name = "bill_no")
    private String billNo;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "e_way_bill_no")
    private String eWayBillNo;
    @Column(name = "bill_entry_no")
    private String billEntryNo;
    @Column(name = "bill_entry_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date billEntryDate;
    @Column(name = "port_code")
    private String portCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "exchange_rate")
    private Double exchangeRate;
    @Column(name = "vendor_amt")
    private Double vendorAmt;
    @Column(name = "expense_amt")
    private Double expenseAmt;
    @Column(name = "customs_duty")
    private Double customsDuty;
    @Column(name = "customs_duty_payable")
    private Double customsDutyPayable;
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
    @Column(name = "total_amt")
    private Double totalAmt;
    @Column(name = "basic_amt")
    private Double basicAmt;
    @Column(name = "paid_amt")
    private Double paidAmt;
    @Column(name = "debit_note_total_amt")
    private Double debitNoteTotalAmt;
    @Column(name = "due_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Column(name = "bill_status")
    private String billStatus;
    @Column(name = "active_status")
    private String activeStatus;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billMasterId")
    private List<GrnBillMapping> grnBillMappingList;
    @JoinColumn(name = "bill_file_asset_id", referencedColumnName = "file_asset_id")
    @ManyToOne
    private FileAsset billFileAssetId;
    @JoinColumn(name = "e_way_bill_file_asset_id", referencedColumnName = "file_asset_id")
    @ManyToOne
    private FileAsset eWayBillFileAssetId;
    @JoinColumn(name = "bill_entry_file_asset_id", referencedColumnName = "file_asset_id")
    @ManyToOne
    private FileAsset billEntryFileAssetId;
    @JoinColumn(name = "purchase_order_master_id", referencedColumnName = "purchase_order_master_id")
    @ManyToOne
    private PurchaseOrderMaster purchaseOrderMasterId;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @OneToMany(mappedBy = "billMasterId")
    private List<GeneralLedger> generalLedgerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billMasterId")
    private List<TdsMaster> tdsMasterList;
    @OneToMany(mappedBy = "billMasterId")
    private List<TagMapping> tagMappingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billMasterId")
    private List<DebitNoteMaster> debitNoteMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billMasterId")
    private List<DebitNoteDetail> debitNoteDetailList;
    @OneToMany(mappedBy = "billMasterId")
    private List<BillPayment> billPaymentList;
    @OneToMany(mappedBy = "billMasterId")
    private List<MaterialTransactionMaster> materialTransactionMasterList;
    @OneToMany(mappedBy = "billMasterId")
    private List<PoTagMaster> poTagMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billMasterId")
    private List<BillDetail> billDetailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billMasterId")
    private List<BillApproval> billApprovalList;

    public BillMaster() {
    }

    public BillMaster(Integer billMasterId) {
        this.billMasterId = billMasterId;
    }

    public BillMaster(Integer billMasterId, String billNo, Date lastUpdatedAt, Character isActive) {
        this.billMasterId = billMasterId;
        this.billNo = billNo;
        this.lastUpdatedAt = lastUpdatedAt;
        this.isActive = isActive;
    }

    public Integer getBillMasterId() {
        return billMasterId;
    }

    public void setBillMasterId(Integer billMasterId) {
        this.billMasterId = billMasterId;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEWayBillNo() {
        return eWayBillNo;
    }

    public void setEWayBillNo(String eWayBillNo) {
        this.eWayBillNo = eWayBillNo;
    }

    public String getBillEntryNo() {
        return billEntryNo;
    }

    public void setBillEntryNo(String billEntryNo) {
        this.billEntryNo = billEntryNo;
    }

    public Date getBillEntryDate() {
        return billEntryDate;
    }

    public void setBillEntryDate(Date billEntryDate) {
        this.billEntryDate = billEntryDate;
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

    public Double getVendorAmt() {
        return vendorAmt;
    }

    public void setVendorAmt(Double vendorAmt) {
        this.vendorAmt = vendorAmt;
    }

    public Double getExpenseAmt() {
        return expenseAmt;
    }

    public void setExpenseAmt(Double expenseAmt) {
        this.expenseAmt = expenseAmt;
    }

    public Double getCustomsDuty() {
        return customsDuty;
    }

    public void setCustomsDuty(Double customsDuty) {
        this.customsDuty = customsDuty;
    }

    public Double getCustomsDutyPayable() {
        return customsDutyPayable;
    }

    public void setCustomsDutyPayable(Double customsDutyPayable) {
        this.customsDutyPayable = customsDutyPayable;
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

    public Double getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(Double totalAmt) {
        this.totalAmt = totalAmt;
    }

    public Double getBasicAmt() {
        return basicAmt;
    }

    public void setBasicAmt(Double basicAmt) {
        this.basicAmt = basicAmt;
    }

    public Double getPaidAmt() {
        return paidAmt;
    }

    public void setPaidAmt(Double paidAmt) {
        this.paidAmt = paidAmt;
    }

    public Double getDebitNoteTotalAmt() {
        return debitNoteTotalAmt;
    }

    public void setDebitNoteTotalAmt(Double debitNoteTotalAmt) {
        this.debitNoteTotalAmt = debitNoteTotalAmt;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
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
    public List<GrnBillMapping> getGrnBillMappingList() {
        return grnBillMappingList;
    }

    public void setGrnBillMappingList(List<GrnBillMapping> grnBillMappingList) {
        this.grnBillMappingList = grnBillMappingList;
    }

    public FileAsset getBillFileAssetId() {
        return billFileAssetId;
    }

    public void setBillFileAssetId(FileAsset billFileAssetId) {
        this.billFileAssetId = billFileAssetId;
    }

    public FileAsset getEWayBillFileAssetId() {
        return eWayBillFileAssetId;
    }

    public void setEWayBillFileAssetId(FileAsset eWayBillFileAssetId) {
        this.eWayBillFileAssetId = eWayBillFileAssetId;
    }

    public FileAsset getBillEntryFileAssetId() {
        return billEntryFileAssetId;
    }

    public void setBillEntryFileAssetId(FileAsset billEntryFileAssetId) {
        this.billEntryFileAssetId = billEntryFileAssetId;
    }

    public PurchaseOrderMaster getPurchaseOrderMasterId() {
        return purchaseOrderMasterId;
    }

    public void setPurchaseOrderMasterId(PurchaseOrderMaster purchaseOrderMasterId) {
        this.purchaseOrderMasterId = purchaseOrderMasterId;
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
    public List<GeneralLedger> getGeneralLedgerList() {
        return generalLedgerList;
    }

    public void setGeneralLedgerList(List<GeneralLedger> generalLedgerList) {
        this.generalLedgerList = generalLedgerList;
    }

    @XmlTransient
    public List<TdsMaster> getTdsMasterList() {
        return tdsMasterList;
    }

    public void setTdsMasterList(List<TdsMaster> tdsMasterList) {
        this.tdsMasterList = tdsMasterList;
    }

    @XmlTransient
    public List<TagMapping> getTagMappingList() {
        return tagMappingList;
    }

    public void setTagMappingList(List<TagMapping> tagMappingList) {
        this.tagMappingList = tagMappingList;
    }

    @XmlTransient
    public List<DebitNoteMaster> getDebitNoteMasterList() {
        return debitNoteMasterList;
    }

    public void setDebitNoteMasterList(List<DebitNoteMaster> debitNoteMasterList) {
        this.debitNoteMasterList = debitNoteMasterList;
    }

    @XmlTransient
    public List<DebitNoteDetail> getDebitNoteDetailList() {
        return debitNoteDetailList;
    }

    public void setDebitNoteDetailList(List<DebitNoteDetail> debitNoteDetailList) {
        this.debitNoteDetailList = debitNoteDetailList;
    }

    @XmlTransient
    public List<BillPayment> getBillPaymentList() {
        return billPaymentList;
    }

    public void setBillPaymentList(List<BillPayment> billPaymentList) {
        this.billPaymentList = billPaymentList;
    }

    @XmlTransient
    public List<MaterialTransactionMaster> getMaterialTransactionMasterList() {
        return materialTransactionMasterList;
    }

    public void setMaterialTransactionMasterList(List<MaterialTransactionMaster> materialTransactionMasterList) {
        this.materialTransactionMasterList = materialTransactionMasterList;
    }

    @XmlTransient
    public List<PoTagMaster> getPoTagMasterList() {
        return poTagMasterList;
    }

    public void setPoTagMasterList(List<PoTagMaster> poTagMasterList) {
        this.poTagMasterList = poTagMasterList;
    }

    @XmlTransient
    public List<BillDetail> getBillDetailList() {
        return billDetailList;
    }

    public void setBillDetailList(List<BillDetail> billDetailList) {
        this.billDetailList = billDetailList;
    }

    @XmlTransient
    public List<BillApproval> getBillApprovalList() {
        return billApprovalList;
    }

    public void setBillApprovalList(List<BillApproval> billApprovalList) {
        this.billApprovalList = billApprovalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billMasterId != null ? billMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BillMaster)) {
            return false;
        }
        BillMaster other = (BillMaster) object;
        if ((this.billMasterId == null && other.billMasterId != null) || (this.billMasterId != null && !this.billMasterId.equals(other.billMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.BillMaster[ billMasterId=" + billMasterId + " ]";
    }
    
}
