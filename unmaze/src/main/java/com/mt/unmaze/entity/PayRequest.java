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
@Table(name = "pay_request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PayRequest.findAll", query = "SELECT p FROM PayRequest p"),
    @NamedQuery(name = "PayRequest.findByPayRequestId", query = "SELECT p FROM PayRequest p WHERE p.payRequestId = :payRequestId"),
    @NamedQuery(name = "PayRequest.findByDate", query = "SELECT p FROM PayRequest p WHERE p.date = :date"),
    @NamedQuery(name = "PayRequest.findByBillNo", query = "SELECT p FROM PayRequest p WHERE p.billNo = :billNo"),
    @NamedQuery(name = "PayRequest.findByRequestAmount", query = "SELECT p FROM PayRequest p WHERE p.requestAmount = :requestAmount"),
    @NamedQuery(name = "PayRequest.findByFirstApprovalStatus", query = "SELECT p FROM PayRequest p WHERE p.firstApprovalStatus = :firstApprovalStatus"),
    @NamedQuery(name = "PayRequest.findBySecApprovalStatus", query = "SELECT p FROM PayRequest p WHERE p.secApprovalStatus = :secApprovalStatus"),
    @NamedQuery(name = "PayRequest.findByGrnNo", query = "SELECT p FROM PayRequest p WHERE p.grnNo = :grnNo"),
    @NamedQuery(name = "PayRequest.findByBillEntryTally", query = "SELECT p FROM PayRequest p WHERE p.billEntryTally = :billEntryTally"),
    @NamedQuery(name = "PayRequest.findByBillEntryUnmaze", query = "SELECT p FROM PayRequest p WHERE p.billEntryUnmaze = :billEntryUnmaze"),
    @NamedQuery(name = "PayRequest.findByTdEntryTally", query = "SELECT p FROM PayRequest p WHERE p.tdEntryTally = :tdEntryTally"),
    @NamedQuery(name = "PayRequest.findByTdsEntryUnmaze", query = "SELECT p FROM PayRequest p WHERE p.tdsEntryUnmaze = :tdsEntryUnmaze"),
    @NamedQuery(name = "PayRequest.findByTdsAmt", query = "SELECT p FROM PayRequest p WHERE p.tdsAmt = :tdsAmt"),
    @NamedQuery(name = "PayRequest.findByPhysicalBill", query = "SELECT p FROM PayRequest p WHERE p.physicalBill = :physicalBill"),
    @NamedQuery(name = "PayRequest.findByThirdApprovalStatus", query = "SELECT p FROM PayRequest p WHERE p.thirdApprovalStatus = :thirdApprovalStatus"),
    @NamedQuery(name = "PayRequest.findByFourthApprovalStatus", query = "SELECT p FROM PayRequest p WHERE p.fourthApprovalStatus = :fourthApprovalStatus"),
    @NamedQuery(name = "PayRequest.findByFifthApprovalStatus", query = "SELECT p FROM PayRequest p WHERE p.fifthApprovalStatus = :fifthApprovalStatus"),
    @NamedQuery(name = "PayRequest.findByOtherDeductionAmt", query = "SELECT p FROM PayRequest p WHERE p.otherDeductionAmt = :otherDeductionAmt"),
    @NamedQuery(name = "PayRequest.findByFinalApprovalStatus", query = "SELECT p FROM PayRequest p WHERE p.finalApprovalStatus = :finalApprovalStatus"),
    @NamedQuery(name = "PayRequest.findByFinalApprovalDate", query = "SELECT p FROM PayRequest p WHERE p.finalApprovalDate = :finalApprovalDate"),
    @NamedQuery(name = "PayRequest.findByReferenceNo", query = "SELECT p FROM PayRequest p WHERE p.referenceNo = :referenceNo"),
    @NamedQuery(name = "PayRequest.findByPaymentEntryTally", query = "SELECT p FROM PayRequest p WHERE p.paymentEntryTally = :paymentEntryTally"),
    @NamedQuery(name = "PayRequest.findByPaymentEntryUnmaze", query = "SELECT p FROM PayRequest p WHERE p.paymentEntryUnmaze = :paymentEntryUnmaze"),
    @NamedQuery(name = "PayRequest.findByBank", query = "SELECT p FROM PayRequest p WHERE p.bank = :bank"),
    @NamedQuery(name = "PayRequest.findByBankAccountNo", query = "SELECT p FROM PayRequest p WHERE p.bankAccountNo = :bankAccountNo"),
    @NamedQuery(name = "PayRequest.findByBankIfsc", query = "SELECT p FROM PayRequest p WHERE p.bankIfsc = :bankIfsc"),
    @NamedQuery(name = "PayRequest.findByCreatedAt", query = "SELECT p FROM PayRequest p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "PayRequest.findByLastUpdatedAt", query = "SELECT p FROM PayRequest p WHERE p.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "PayRequest.findByIsActive", query = "SELECT p FROM PayRequest p WHERE p.isActive = :isActive"),
    @NamedQuery(name = "PayRequest.findByIpAddress", query = "SELECT p FROM PayRequest p WHERE p.ipAddress = :ipAddress")})
public class PayRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pay_request_id")
    private Integer payRequestId;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "bill_no")
    private String billNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "request_amount")
    private Double requestAmount;
    @Column(name = "first_approval_status")
    private String firstApprovalStatus;
    @Column(name = "sec_approval_status")
    private String secApprovalStatus;
    @Column(name = "grn_no")
    private String grnNo;
    @Column(name = "bill_entry_tally")
    private String billEntryTally;
    @Column(name = "bill_entry_unmaze")
    private String billEntryUnmaze;
    @Column(name = "td_entry_tally")
    private String tdEntryTally;
    @Column(name = "tds_entry_unmaze")
    private String tdsEntryUnmaze;
    @Column(name = "tds_amt")
    private Double tdsAmt;
    @Column(name = "physical_bill")
    private String physicalBill;
    @Column(name = "third_approval_status")
    private String thirdApprovalStatus;
    @Column(name = "fourth_approval_status")
    private String fourthApprovalStatus;
    @Column(name = "fifth_approval_status")
    private String fifthApprovalStatus;
    @Column(name = "other_deduction_amt")
    private Double otherDeductionAmt;
    @Column(name = "final_approval_status")
    private String finalApprovalStatus;
    @Column(name = "final_approval_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finalApprovalDate;
    @Column(name = "reference_no")
    private String referenceNo;
    @Column(name = "payment_entry_tally")
    private String paymentEntryTally;
    @Column(name = "payment_entry_unmaze")
    private String paymentEntryUnmaze;
    @Column(name = "bank")
    private String bank;
    @Column(name = "bank_account_no")
    private String bankAccountNo;
    @Column(name = "bank_ifsc")
    private String bankIfsc;
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
    @JoinColumn(name = "document_2", referencedColumnName = "file_asset_id")
    @ManyToOne
    private FileAsset document2;
    @JoinColumn(name = "pay_to_account_master_id", referencedColumnName = "account_master_id")
    @ManyToOne
    private AccountMaster payToAccountMasterId;
    @JoinColumn(name = "pay_via_account_master_id", referencedColumnName = "account_master_id")
    @ManyToOne
    private AccountMaster payViaAccountMasterId;
    @JoinColumn(name = "branch_master_id", referencedColumnName = "branch_master_id")
    @ManyToOne
    private BranchMaster branchMasterId;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @JoinColumn(name = "first_approver_user_id", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster firstApproverUserId;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @JoinColumn(name = "document_1", referencedColumnName = "file_asset_id")
    @ManyToOne
    private FileAsset document1;
    @JoinColumn(name = "payment_mode_id", referencedColumnName = "payment_mode_id")
    @ManyToOne
    private PaymentMode paymentModeId;
    @JoinColumn(name = "payment_type_id", referencedColumnName = "payment_type_id")
    @ManyToOne
    private PaymentType paymentTypeId;
    @JoinColumn(name = "purchase_order_master_id", referencedColumnName = "purchase_order_master_id")
    @ManyToOne
    private PurchaseOrderMaster purchaseOrderMasterId;
    @JoinColumn(name = "tds_type_id", referencedColumnName = "tds_type_id")
    @ManyToOne
    private TdsType tdsTypeId;
    @JoinColumn(name = "user_master_id", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster userMasterId;
    @JoinColumn(name = "third_approver_user_id", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster thirdApproverUserId;
    @JoinColumn(name = "final_approver_user_id", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster finalApproverUserId;
    @JoinColumn(name = "sec_approver_user_id", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster secApproverUserId;
    @JoinColumn(name = "fifth_approver_user_id", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster fifthApproverUserId;
    @JoinColumn(name = "fourth_approver_user_id", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster fourthApproverUserId;

    public PayRequest() {
    }

    public PayRequest(Integer payRequestId) {
        this.payRequestId = payRequestId;
    }

    public PayRequest(Integer payRequestId, Character isActive) {
        this.payRequestId = payRequestId;
        this.isActive = isActive;
    }

    public Integer getPayRequestId() {
        return payRequestId;
    }

    public void setPayRequestId(Integer payRequestId) {
        this.payRequestId = payRequestId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public Double getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(Double requestAmount) {
        this.requestAmount = requestAmount;
    }

    public String getFirstApprovalStatus() {
        return firstApprovalStatus;
    }

    public void setFirstApprovalStatus(String firstApprovalStatus) {
        this.firstApprovalStatus = firstApprovalStatus;
    }

    public String getSecApprovalStatus() {
        return secApprovalStatus;
    }

    public void setSecApprovalStatus(String secApprovalStatus) {
        this.secApprovalStatus = secApprovalStatus;
    }

    public String getGrnNo() {
        return grnNo;
    }

    public void setGrnNo(String grnNo) {
        this.grnNo = grnNo;
    }

    public String getBillEntryTally() {
        return billEntryTally;
    }

    public void setBillEntryTally(String billEntryTally) {
        this.billEntryTally = billEntryTally;
    }

    public String getBillEntryUnmaze() {
        return billEntryUnmaze;
    }

    public void setBillEntryUnmaze(String billEntryUnmaze) {
        this.billEntryUnmaze = billEntryUnmaze;
    }

    public String getTdEntryTally() {
        return tdEntryTally;
    }

    public void setTdEntryTally(String tdEntryTally) {
        this.tdEntryTally = tdEntryTally;
    }

    public String getTdsEntryUnmaze() {
        return tdsEntryUnmaze;
    }

    public void setTdsEntryUnmaze(String tdsEntryUnmaze) {
        this.tdsEntryUnmaze = tdsEntryUnmaze;
    }

    public Double getTdsAmt() {
        return tdsAmt;
    }

    public void setTdsAmt(Double tdsAmt) {
        this.tdsAmt = tdsAmt;
    }

    public String getPhysicalBill() {
        return physicalBill;
    }

    public void setPhysicalBill(String physicalBill) {
        this.physicalBill = physicalBill;
    }

    public String getThirdApprovalStatus() {
        return thirdApprovalStatus;
    }

    public void setThirdApprovalStatus(String thirdApprovalStatus) {
        this.thirdApprovalStatus = thirdApprovalStatus;
    }

    public String getFourthApprovalStatus() {
        return fourthApprovalStatus;
    }

    public void setFourthApprovalStatus(String fourthApprovalStatus) {
        this.fourthApprovalStatus = fourthApprovalStatus;
    }

    public String getFifthApprovalStatus() {
        return fifthApprovalStatus;
    }

    public void setFifthApprovalStatus(String fifthApprovalStatus) {
        this.fifthApprovalStatus = fifthApprovalStatus;
    }

    public Double getOtherDeductionAmt() {
        return otherDeductionAmt;
    }

    public void setOtherDeductionAmt(Double otherDeductionAmt) {
        this.otherDeductionAmt = otherDeductionAmt;
    }

    public String getFinalApprovalStatus() {
        return finalApprovalStatus;
    }

    public void setFinalApprovalStatus(String finalApprovalStatus) {
        this.finalApprovalStatus = finalApprovalStatus;
    }

    public Date getFinalApprovalDate() {
        return finalApprovalDate;
    }

    public void setFinalApprovalDate(Date finalApprovalDate) {
        this.finalApprovalDate = finalApprovalDate;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getPaymentEntryTally() {
        return paymentEntryTally;
    }

    public void setPaymentEntryTally(String paymentEntryTally) {
        this.paymentEntryTally = paymentEntryTally;
    }

    public String getPaymentEntryUnmaze() {
        return paymentEntryUnmaze;
    }

    public void setPaymentEntryUnmaze(String paymentEntryUnmaze) {
        this.paymentEntryUnmaze = paymentEntryUnmaze;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getBankIfsc() {
        return bankIfsc;
    }

    public void setBankIfsc(String bankIfsc) {
        this.bankIfsc = bankIfsc;
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

    public FileAsset getDocument2() {
        return document2;
    }

    public void setDocument2(FileAsset document2) {
        this.document2 = document2;
    }

    public AccountMaster getPayToAccountMasterId() {
        return payToAccountMasterId;
    }

    public void setPayToAccountMasterId(AccountMaster payToAccountMasterId) {
        this.payToAccountMasterId = payToAccountMasterId;
    }

    public AccountMaster getPayViaAccountMasterId() {
        return payViaAccountMasterId;
    }

    public void setPayViaAccountMasterId(AccountMaster payViaAccountMasterId) {
        this.payViaAccountMasterId = payViaAccountMasterId;
    }

    public BranchMaster getBranchMasterId() {
        return branchMasterId;
    }

    public void setBranchMasterId(BranchMaster branchMasterId) {
        this.branchMasterId = branchMasterId;
    }

    public UserMaster getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(UserMaster lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public UserMaster getFirstApproverUserId() {
        return firstApproverUserId;
    }

    public void setFirstApproverUserId(UserMaster firstApproverUserId) {
        this.firstApproverUserId = firstApproverUserId;
    }

    public UserMaster getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserMaster createdBy) {
        this.createdBy = createdBy;
    }

    public FileAsset getDocument1() {
        return document1;
    }

    public void setDocument1(FileAsset document1) {
        this.document1 = document1;
    }

    public PaymentMode getPaymentModeId() {
        return paymentModeId;
    }

    public void setPaymentModeId(PaymentMode paymentModeId) {
        this.paymentModeId = paymentModeId;
    }

    public PaymentType getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(PaymentType paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public PurchaseOrderMaster getPurchaseOrderMasterId() {
        return purchaseOrderMasterId;
    }

    public void setPurchaseOrderMasterId(PurchaseOrderMaster purchaseOrderMasterId) {
        this.purchaseOrderMasterId = purchaseOrderMasterId;
    }

    public TdsType getTdsTypeId() {
        return tdsTypeId;
    }

    public void setTdsTypeId(TdsType tdsTypeId) {
        this.tdsTypeId = tdsTypeId;
    }

    public UserMaster getUserMasterId() {
        return userMasterId;
    }

    public void setUserMasterId(UserMaster userMasterId) {
        this.userMasterId = userMasterId;
    }

    public UserMaster getThirdApproverUserId() {
        return thirdApproverUserId;
    }

    public void setThirdApproverUserId(UserMaster thirdApproverUserId) {
        this.thirdApproverUserId = thirdApproverUserId;
    }

    public UserMaster getFinalApproverUserId() {
        return finalApproverUserId;
    }

    public void setFinalApproverUserId(UserMaster finalApproverUserId) {
        this.finalApproverUserId = finalApproverUserId;
    }

    public UserMaster getSecApproverUserId() {
        return secApproverUserId;
    }

    public void setSecApproverUserId(UserMaster secApproverUserId) {
        this.secApproverUserId = secApproverUserId;
    }

    public UserMaster getFifthApproverUserId() {
        return fifthApproverUserId;
    }

    public void setFifthApproverUserId(UserMaster fifthApproverUserId) {
        this.fifthApproverUserId = fifthApproverUserId;
    }

    public UserMaster getFourthApproverUserId() {
        return fourthApproverUserId;
    }

    public void setFourthApproverUserId(UserMaster fourthApproverUserId) {
        this.fourthApproverUserId = fourthApproverUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (payRequestId != null ? payRequestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PayRequest)) {
            return false;
        }
        PayRequest other = (PayRequest) object;
        if ((this.payRequestId == null && other.payRequestId != null) || (this.payRequestId != null && !this.payRequestId.equals(other.payRequestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.PayRequest[ payRequestId=" + payRequestId + " ]";
    }
    
}
