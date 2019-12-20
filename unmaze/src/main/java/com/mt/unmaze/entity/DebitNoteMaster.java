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
@Table(name = "debit_note_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DebitNoteMaster.findAll", query = "SELECT d FROM DebitNoteMaster d"),
    @NamedQuery(name = "DebitNoteMaster.findByDebitNoteMasterId", query = "SELECT d FROM DebitNoteMaster d WHERE d.debitNoteMasterId = :debitNoteMasterId"),
    @NamedQuery(name = "DebitNoteMaster.findByDebitNoteNo", query = "SELECT d FROM DebitNoteMaster d WHERE d.debitNoteNo = :debitNoteNo"),
    @NamedQuery(name = "DebitNoteMaster.findByDate", query = "SELECT d FROM DebitNoteMaster d WHERE d.date = :date"),
    @NamedQuery(name = "DebitNoteMaster.findByExchangeRate", query = "SELECT d FROM DebitNoteMaster d WHERE d.exchangeRate = :exchangeRate"),
    @NamedQuery(name = "DebitNoteMaster.findByVendorAmt", query = "SELECT d FROM DebitNoteMaster d WHERE d.vendorAmt = :vendorAmt"),
    @NamedQuery(name = "DebitNoteMaster.findByExpenseAmt", query = "SELECT d FROM DebitNoteMaster d WHERE d.expenseAmt = :expenseAmt"),
    @NamedQuery(name = "DebitNoteMaster.findByCustomsDuty", query = "SELECT d FROM DebitNoteMaster d WHERE d.customsDuty = :customsDuty"),
    @NamedQuery(name = "DebitNoteMaster.findByCustomsDutyPayable", query = "SELECT d FROM DebitNoteMaster d WHERE d.customsDutyPayable = :customsDutyPayable"),
    @NamedQuery(name = "DebitNoteMaster.findByCgstPayable", query = "SELECT d FROM DebitNoteMaster d WHERE d.cgstPayable = :cgstPayable"),
    @NamedQuery(name = "DebitNoteMaster.findBySgstPayable", query = "SELECT d FROM DebitNoteMaster d WHERE d.sgstPayable = :sgstPayable"),
    @NamedQuery(name = "DebitNoteMaster.findByIgstPayable", query = "SELECT d FROM DebitNoteMaster d WHERE d.igstPayable = :igstPayable"),
    @NamedQuery(name = "DebitNoteMaster.findByCessPayable", query = "SELECT d FROM DebitNoteMaster d WHERE d.cessPayable = :cessPayable"),
    @NamedQuery(name = "DebitNoteMaster.findByVatPayable", query = "SELECT d FROM DebitNoteMaster d WHERE d.vatPayable = :vatPayable"),
    @NamedQuery(name = "DebitNoteMaster.findByCgstItc", query = "SELECT d FROM DebitNoteMaster d WHERE d.cgstItc = :cgstItc"),
    @NamedQuery(name = "DebitNoteMaster.findBySgstItc", query = "SELECT d FROM DebitNoteMaster d WHERE d.sgstItc = :sgstItc"),
    @NamedQuery(name = "DebitNoteMaster.findByIgstItc", query = "SELECT d FROM DebitNoteMaster d WHERE d.igstItc = :igstItc"),
    @NamedQuery(name = "DebitNoteMaster.findByCessItc", query = "SELECT d FROM DebitNoteMaster d WHERE d.cessItc = :cessItc"),
    @NamedQuery(name = "DebitNoteMaster.findByVatItc", query = "SELECT d FROM DebitNoteMaster d WHERE d.vatItc = :vatItc"),
    @NamedQuery(name = "DebitNoteMaster.findByTotalAmt", query = "SELECT d FROM DebitNoteMaster d WHERE d.totalAmt = :totalAmt"),
    @NamedQuery(name = "DebitNoteMaster.findByDebitNoteStatus", query = "SELECT d FROM DebitNoteMaster d WHERE d.debitNoteStatus = :debitNoteStatus"),
    @NamedQuery(name = "DebitNoteMaster.findByActiveStatus", query = "SELECT d FROM DebitNoteMaster d WHERE d.activeStatus = :activeStatus"),
    @NamedQuery(name = "DebitNoteMaster.findByCreatedAt", query = "SELECT d FROM DebitNoteMaster d WHERE d.createdAt = :createdAt"),
    @NamedQuery(name = "DebitNoteMaster.findByLastUpdatedAt", query = "SELECT d FROM DebitNoteMaster d WHERE d.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "DebitNoteMaster.findByIsActive", query = "SELECT d FROM DebitNoteMaster d WHERE d.isActive = :isActive"),
    @NamedQuery(name = "DebitNoteMaster.findByIpAddress", query = "SELECT d FROM DebitNoteMaster d WHERE d.ipAddress = :ipAddress")})
public class DebitNoteMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "debit_note_master_id")
    private Integer debitNoteMasterId;
    @Column(name = "debit_note_no")
    private String debitNoteNo;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
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
    @Column(name = "debit_note_status")
    private String debitNoteStatus;
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
    @OneToMany(mappedBy = "debitNoteMasterId")
    private List<GeneralLedger> generalLedgerList;
    @OneToMany(mappedBy = "debitNoteMasterId")
    private List<TagMapping> tagMappingList;
    @JoinColumn(name = "bill_master_id", referencedColumnName = "bill_master_id")
    @ManyToOne(optional = false)
    private BillMaster billMasterId;
    @JoinColumn(name = "purchase_order_master_id", referencedColumnName = "purchase_order_master_id")
    @ManyToOne(optional = false)
    private PurchaseOrderMaster purchaseOrderMasterId;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "debitNoteMasterId")
    private List<DebitNoteApproval> debitNoteApprovalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "debitNoteMasterId")
    private List<DebitNoteDetail> debitNoteDetailList;
    @OneToMany(mappedBy = "debitNoteMasterId")
    private List<MaterialTransactionMaster> materialTransactionMasterList;
    @OneToMany(mappedBy = "debitNoteMasterId")
    private List<PoTagMaster> poTagMasterList;

    public DebitNoteMaster() {
    }

    public DebitNoteMaster(Integer debitNoteMasterId) {
        this.debitNoteMasterId = debitNoteMasterId;
    }

    public DebitNoteMaster(Integer debitNoteMasterId, Date lastUpdatedAt, Character isActive) {
        this.debitNoteMasterId = debitNoteMasterId;
        this.lastUpdatedAt = lastUpdatedAt;
        this.isActive = isActive;
    }

    public Integer getDebitNoteMasterId() {
        return debitNoteMasterId;
    }

    public void setDebitNoteMasterId(Integer debitNoteMasterId) {
        this.debitNoteMasterId = debitNoteMasterId;
    }

    public String getDebitNoteNo() {
        return debitNoteNo;
    }

    public void setDebitNoteNo(String debitNoteNo) {
        this.debitNoteNo = debitNoteNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getDebitNoteStatus() {
        return debitNoteStatus;
    }

    public void setDebitNoteStatus(String debitNoteStatus) {
        this.debitNoteStatus = debitNoteStatus;
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
    public List<DebitNoteApproval> getDebitNoteApprovalList() {
        return debitNoteApprovalList;
    }

    public void setDebitNoteApprovalList(List<DebitNoteApproval> debitNoteApprovalList) {
        this.debitNoteApprovalList = debitNoteApprovalList;
    }

    @XmlTransient
    public List<DebitNoteDetail> getDebitNoteDetailList() {
        return debitNoteDetailList;
    }

    public void setDebitNoteDetailList(List<DebitNoteDetail> debitNoteDetailList) {
        this.debitNoteDetailList = debitNoteDetailList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (debitNoteMasterId != null ? debitNoteMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DebitNoteMaster)) {
            return false;
        }
        DebitNoteMaster other = (DebitNoteMaster) object;
        if ((this.debitNoteMasterId == null && other.debitNoteMasterId != null) || (this.debitNoteMasterId != null && !this.debitNoteMasterId.equals(other.debitNoteMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.DebitNoteMaster[ debitNoteMasterId=" + debitNoteMasterId + " ]";
    }
    
}
