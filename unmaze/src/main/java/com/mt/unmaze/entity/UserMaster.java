/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mt.unmaze.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "user_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserMaster.findAll", query = "SELECT u FROM UserMaster u"),
    @NamedQuery(name = "UserMaster.findByUserMasterId", query = "SELECT u FROM UserMaster u WHERE u.userMasterId = :userMasterId"),
    @NamedQuery(name = "UserMaster.findByFirstName", query = "SELECT u FROM UserMaster u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "UserMaster.findByMiddleName", query = "SELECT u FROM UserMaster u WHERE u.middleName = :middleName"),
    @NamedQuery(name = "UserMaster.findByLastName", query = "SELECT u FROM UserMaster u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "UserMaster.findByContactNumber", query = "SELECT u FROM UserMaster u WHERE u.contactNumber = :contactNumber"),
    @NamedQuery(name = "UserMaster.findByEmail", query = "SELECT u FROM UserMaster u WHERE u.email = :email"),
    @NamedQuery(name = "UserMaster.findByLastLoginDate", query = "SELECT u FROM UserMaster u WHERE u.lastLoginDate = :lastLoginDate"),
    @NamedQuery(name = "UserMaster.findByIsActive", query = "SELECT u FROM UserMaster u WHERE u.isActive = :isActive"),
    @NamedQuery(name = "UserMaster.findByIsDeleted", query = "SELECT u FROM UserMaster u WHERE u.isDeleted = :isDeleted")})
public class UserMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_master_id")
    private Integer userMasterId;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "contact_number")
    private BigInteger contactNumber;
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Lob
    @Column(name = "password")
    private String password;
    @Lob
    @Column(name = "auth_token")
    private String authToken;
    @Column(name = "last_login_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginDate;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @Basic(optional = false)
    @Column(name = "is_deleted")
    private Character isDeleted;
    @OneToMany(mappedBy = "createdBy")
    private List<ECommerce> eCommerceList;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<ECommerce> eCommerceList1;
    @OneToMany(mappedBy = "createdBy")
    private List<GrnBillMapping> grnBillMappingList;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<GrnBillMapping> grnBillMappingList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<PurchaseOrderMaster> purchaseOrderMasterList;
    @OneToMany(mappedBy = "createdBy")
    private List<PurchaseOrderMaster> purchaseOrderMasterList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<ServiceTag> serviceTagList;
    @OneToMany(mappedBy = "createdBy")
    private List<ServiceTag> serviceTagList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<InvoiceMaster> invoiceMasterList;
    @OneToMany(mappedBy = "createdBy")
    private List<InvoiceMaster> invoiceMasterList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<Bank> bankList;
    @OneToMany(mappedBy = "createdBy")
    private List<Bank> bankList1;
    @OneToMany(mappedBy = "createdBy")
    private List<ProductionComposition> productionCompositionList;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<ProductionComposition> productionCompositionList1;
    @OneToMany(mappedBy = "createdBy")
    private List<LegalEntityMaster> legalEntityMasterList;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<LegalEntityMaster> legalEntityMasterList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<BillMaster> billMasterList;
    @OneToMany(mappedBy = "createdBy")
    private List<BillMaster> billMasterList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<MaterialUnit> materialUnitList;
    @OneToMany(mappedBy = "createdBy")
    private List<MaterialUnit> materialUnitList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userMasterId")
    private List<UserRoleMapping> userRoleMappingList;
    @OneToMany(mappedBy = "createdBy")
    private List<GoodsRecieptNote> goodsRecieptNoteList;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<GoodsRecieptNote> goodsRecieptNoteList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<PurchaseOrderDetail> purchaseOrderDetailList;
    @OneToMany(mappedBy = "createdBy")
    private List<PurchaseOrderDetail> purchaseOrderDetailList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<InvoiceDetail> invoiceDetailList;
    @OneToMany(mappedBy = "createdBy")
    private List<InvoiceDetail> invoiceDetailList1;
    @OneToMany(mappedBy = "createdBy")
    private List<GeneralLedger> generalLedgerList;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<GeneralLedger> generalLedgerList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<TdsMaster> tdsMasterList;
    @OneToMany(mappedBy = "createdBy")
    private List<TdsMaster> tdsMasterList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<AccountMaster> accountMasterList;
    @OneToMany(mappedBy = "createdBy")
    private List<AccountMaster> accountMasterList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<PurchaseOrderApproval> purchaseOrderApprovalList;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<TdsType> tdsTypeList;
    @OneToMany(mappedBy = "createdBy")
    private List<TdsType> tdsTypeList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<SourceMaster> sourceMasterList;
    @OneToMany(mappedBy = "createdBy")
    private List<SourceMaster> sourceMasterList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<InvoicePayment> invoicePaymentList;
    @OneToMany(mappedBy = "createdBy")
    private List<InvoicePayment> invoicePaymentList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<VendorMaster> vendorMasterList;
    @OneToMany(mappedBy = "createdBy")
    private List<VendorMaster> vendorMasterList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<DebitNoteMaster> debitNoteMasterList;
    @OneToMany(mappedBy = "createdBy")
    private List<DebitNoteMaster> debitNoteMasterList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<MaterialTag> materialTagList;
    @OneToMany(mappedBy = "createdBy")
    private List<MaterialTag> materialTagList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<TagMaster> tagMasterList;
    @OneToMany(mappedBy = "createdBy")
    private List<TagMaster> tagMasterList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<InvoiceApproval> invoiceApprovalList;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<ServiceMaster> serviceMasterList;
    @OneToMany(mappedBy = "createdBy")
    private List<ServiceMaster> serviceMasterList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userMasterId")
    private List<UserBranchMapping> userBranchMappingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<DebitNoteApproval> debitNoteApprovalList;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<BookingMaster> bookingMasterList;
    @OneToMany(mappedBy = "createdBy")
    private List<BookingMaster> bookingMasterList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userMasterId")
    private List<AdditionalUserRule> additionalUserRuleList;
    @OneToMany(mappedBy = "createdBy")
    private List<CreditNoteMaster> creditNoteMasterList;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<CreditNoteMaster> creditNoteMasterList1;
    @JoinColumn(name = "branch_master_id", referencedColumnName = "branch_master_id")
    @ManyToOne
    private BranchMaster branchMasterId;
    @JoinColumn(name = "user_profile_pic_id", referencedColumnName = "file_asset_id")
    @ManyToOne
    private FileAsset userProfilePicId;
    @JoinColumn(name = "staff_master_id", referencedColumnName = "staff_master_id")
    @ManyToOne
    private StaffMaster staffMasterId;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<DebitNoteDetail> debitNoteDetailList;
    @OneToMany(mappedBy = "createdBy")
    private List<DebitNoteDetail> debitNoteDetailList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<StaffMaster> staffMasterList;
    @OneToMany(mappedBy = "createdBy")
    private List<StaffMaster> staffMasterList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<BillPayment> billPaymentList;
    @OneToMany(mappedBy = "createdBy")
    private List<BillPayment> billPaymentList1;
    @OneToMany(mappedBy = "createdBy")
    private List<SalesComposition> salesCompositionList;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<SalesComposition> salesCompositionList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<CreditNoteDetail> creditNoteDetailList;
    @OneToMany(mappedBy = "createdBy")
    private List<CreditNoteDetail> creditNoteDetailList1;
    @OneToMany(mappedBy = "createdBy")
    private List<AssetMaster> assetMasterList;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<AssetMaster> assetMasterList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<CustomerMaster> customerMasterList;
    @OneToMany(mappedBy = "userMasterId")
    private List<CustomerMaster> customerMasterList1;
    @OneToMany(mappedBy = "createdBy")
    private List<CustomerMaster> customerMasterList2;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<ServiceCategory> serviceCategoryList;
    @OneToMany(mappedBy = "createdBy")
    private List<ServiceCategory> serviceCategoryList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<ServiceTagLink> serviceTagLinkList;
    @OneToMany(mappedBy = "createdBy")
    private List<ServiceTagLink> serviceTagLinkList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<MaterialTagLink> materialTagLinkList;
    @OneToMany(mappedBy = "createdBy")
    private List<MaterialTagLink> materialTagLinkList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<MaterialVariantValue> materialVariantValueList;
    @OneToMany(mappedBy = "createdBy")
    private List<MaterialVariantValue> materialVariantValueList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<MaterialMaster> materialMasterList;
    @OneToMany(mappedBy = "createdBy")
    private List<MaterialMaster> materialMasterList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<ServiceUnit> serviceUnitList;
    @OneToMany(mappedBy = "createdBy")
    private List<ServiceUnit> serviceUnitList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<BookingDetail> bookingDetailList;
    @OneToMany(mappedBy = "createdBy")
    private List<BookingDetail> bookingDetailList1;
    @OneToMany(mappedBy = "createdBy")
    private List<ProjectMaster> projectMasterList;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<ProjectMaster> projectMasterList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userMasterId")
    private List<RestrictedUserRule> restrictedUserRuleList;
    @OneToMany(mappedBy = "createdBy")
    private List<MaterialTransactionMaster> materialTransactionMasterList;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<MaterialTransactionMaster> materialTransactionMasterList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<BookingApproval> bookingApprovalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<CreditNoteApproval> creditNoteApprovalList;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<MaterialCategory> materialCategoryList;
    @OneToMany(mappedBy = "createdBy")
    private List<MaterialCategory> materialCategoryList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<MaterialVariant> materialVariantList;
    @OneToMany(mappedBy = "createdBy")
    private List<MaterialVariant> materialVariantList1;
    @OneToMany(mappedBy = "createdBy")
    private List<BudgetMaster> budgetMasterList;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<BudgetMaster> budgetMasterList1;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<PayRequest> payRequestList;
    @OneToMany(mappedBy = "firstApproverUserId")
    private List<PayRequest> payRequestList1;
    @OneToMany(mappedBy = "createdBy")
    private List<PayRequest> payRequestList2;
    @OneToMany(mappedBy = "userMasterId")
    private List<PayRequest> payRequestList3;
    @OneToMany(mappedBy = "thirdApproverUserId")
    private List<PayRequest> payRequestList4;
    @OneToMany(mappedBy = "finalApproverUserId")
    private List<PayRequest> payRequestList5;
    @OneToMany(mappedBy = "secApproverUserId")
    private List<PayRequest> payRequestList6;
    @OneToMany(mappedBy = "fifthApproverUserId")
    private List<PayRequest> payRequestList7;
    @OneToMany(mappedBy = "fourthApproverUserId")
    private List<PayRequest> payRequestList8;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<BillDetail> billDetailList;
    @OneToMany(mappedBy = "createdBy")
    private List<BillDetail> billDetailList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userMasterId")
    private List<WidgetUserMapping> widgetUserMappingList;
    @OneToMany(mappedBy = "createdBy")
    private List<BranchMaster> branchMasterList;
    @OneToMany(mappedBy = "lastUpdatedBy")
    private List<BranchMaster> branchMasterList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<BillApproval> billApprovalList;

    public UserMaster() {
    }

    public UserMaster(Integer userMasterId) {
        this.userMasterId = userMasterId;
    }

    public UserMaster(Integer userMasterId, String firstName, String lastName, String password, Character isActive, Character isDeleted) {
        this.userMasterId = userMasterId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
    }

    public Integer getUserMasterId() {
        return userMasterId;
    }

    public void setUserMasterId(Integer userMasterId) {
        this.userMasterId = userMasterId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigInteger getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(BigInteger contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    public Character getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Character isDeleted) {
        this.isDeleted = isDeleted;
    }

    @XmlTransient
    public List<ECommerce> getECommerceList() {
        return eCommerceList;
    }

    public void setECommerceList(List<ECommerce> eCommerceList) {
        this.eCommerceList = eCommerceList;
    }

    @XmlTransient
    public List<ECommerce> getECommerceList1() {
        return eCommerceList1;
    }

    public void setECommerceList1(List<ECommerce> eCommerceList1) {
        this.eCommerceList1 = eCommerceList1;
    }

    @XmlTransient
    public List<GrnBillMapping> getGrnBillMappingList() {
        return grnBillMappingList;
    }

    public void setGrnBillMappingList(List<GrnBillMapping> grnBillMappingList) {
        this.grnBillMappingList = grnBillMappingList;
    }

    @XmlTransient
    public List<GrnBillMapping> getGrnBillMappingList1() {
        return grnBillMappingList1;
    }

    public void setGrnBillMappingList1(List<GrnBillMapping> grnBillMappingList1) {
        this.grnBillMappingList1 = grnBillMappingList1;
    }

    @XmlTransient
    public List<PurchaseOrderMaster> getPurchaseOrderMasterList() {
        return purchaseOrderMasterList;
    }

    public void setPurchaseOrderMasterList(List<PurchaseOrderMaster> purchaseOrderMasterList) {
        this.purchaseOrderMasterList = purchaseOrderMasterList;
    }

    @XmlTransient
    public List<PurchaseOrderMaster> getPurchaseOrderMasterList1() {
        return purchaseOrderMasterList1;
    }

    public void setPurchaseOrderMasterList1(List<PurchaseOrderMaster> purchaseOrderMasterList1) {
        this.purchaseOrderMasterList1 = purchaseOrderMasterList1;
    }

    @XmlTransient
    public List<ServiceTag> getServiceTagList() {
        return serviceTagList;
    }

    public void setServiceTagList(List<ServiceTag> serviceTagList) {
        this.serviceTagList = serviceTagList;
    }

    @XmlTransient
    public List<ServiceTag> getServiceTagList1() {
        return serviceTagList1;
    }

    public void setServiceTagList1(List<ServiceTag> serviceTagList1) {
        this.serviceTagList1 = serviceTagList1;
    }

    @XmlTransient
    public List<InvoiceMaster> getInvoiceMasterList() {
        return invoiceMasterList;
    }

    public void setInvoiceMasterList(List<InvoiceMaster> invoiceMasterList) {
        this.invoiceMasterList = invoiceMasterList;
    }

    @XmlTransient
    public List<InvoiceMaster> getInvoiceMasterList1() {
        return invoiceMasterList1;
    }

    public void setInvoiceMasterList1(List<InvoiceMaster> invoiceMasterList1) {
        this.invoiceMasterList1 = invoiceMasterList1;
    }

    @XmlTransient
    public List<Bank> getBankList() {
        return bankList;
    }

    public void setBankList(List<Bank> bankList) {
        this.bankList = bankList;
    }

    @XmlTransient
    public List<Bank> getBankList1() {
        return bankList1;
    }

    public void setBankList1(List<Bank> bankList1) {
        this.bankList1 = bankList1;
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
    public List<LegalEntityMaster> getLegalEntityMasterList() {
        return legalEntityMasterList;
    }

    public void setLegalEntityMasterList(List<LegalEntityMaster> legalEntityMasterList) {
        this.legalEntityMasterList = legalEntityMasterList;
    }

    @XmlTransient
    public List<LegalEntityMaster> getLegalEntityMasterList1() {
        return legalEntityMasterList1;
    }

    public void setLegalEntityMasterList1(List<LegalEntityMaster> legalEntityMasterList1) {
        this.legalEntityMasterList1 = legalEntityMasterList1;
    }

    @XmlTransient
    public List<BillMaster> getBillMasterList() {
        return billMasterList;
    }

    public void setBillMasterList(List<BillMaster> billMasterList) {
        this.billMasterList = billMasterList;
    }

    @XmlTransient
    public List<BillMaster> getBillMasterList1() {
        return billMasterList1;
    }

    public void setBillMasterList1(List<BillMaster> billMasterList1) {
        this.billMasterList1 = billMasterList1;
    }

    @XmlTransient
    public List<MaterialUnit> getMaterialUnitList() {
        return materialUnitList;
    }

    public void setMaterialUnitList(List<MaterialUnit> materialUnitList) {
        this.materialUnitList = materialUnitList;
    }

    @XmlTransient
    public List<MaterialUnit> getMaterialUnitList1() {
        return materialUnitList1;
    }

    public void setMaterialUnitList1(List<MaterialUnit> materialUnitList1) {
        this.materialUnitList1 = materialUnitList1;
    }

    @XmlTransient
    public List<UserRoleMapping> getUserRoleMappingList() {
        return userRoleMappingList;
    }

    public void setUserRoleMappingList(List<UserRoleMapping> userRoleMappingList) {
        this.userRoleMappingList = userRoleMappingList;
    }

    @XmlTransient
    public List<GoodsRecieptNote> getGoodsRecieptNoteList() {
        return goodsRecieptNoteList;
    }

    public void setGoodsRecieptNoteList(List<GoodsRecieptNote> goodsRecieptNoteList) {
        this.goodsRecieptNoteList = goodsRecieptNoteList;
    }

    @XmlTransient
    public List<GoodsRecieptNote> getGoodsRecieptNoteList1() {
        return goodsRecieptNoteList1;
    }

    public void setGoodsRecieptNoteList1(List<GoodsRecieptNote> goodsRecieptNoteList1) {
        this.goodsRecieptNoteList1 = goodsRecieptNoteList1;
    }

    @XmlTransient
    public List<PurchaseOrderDetail> getPurchaseOrderDetailList() {
        return purchaseOrderDetailList;
    }

    public void setPurchaseOrderDetailList(List<PurchaseOrderDetail> purchaseOrderDetailList) {
        this.purchaseOrderDetailList = purchaseOrderDetailList;
    }

    @XmlTransient
    public List<PurchaseOrderDetail> getPurchaseOrderDetailList1() {
        return purchaseOrderDetailList1;
    }

    public void setPurchaseOrderDetailList1(List<PurchaseOrderDetail> purchaseOrderDetailList1) {
        this.purchaseOrderDetailList1 = purchaseOrderDetailList1;
    }

    @XmlTransient
    public List<InvoiceDetail> getInvoiceDetailList() {
        return invoiceDetailList;
    }

    public void setInvoiceDetailList(List<InvoiceDetail> invoiceDetailList) {
        this.invoiceDetailList = invoiceDetailList;
    }

    @XmlTransient
    public List<InvoiceDetail> getInvoiceDetailList1() {
        return invoiceDetailList1;
    }

    public void setInvoiceDetailList1(List<InvoiceDetail> invoiceDetailList1) {
        this.invoiceDetailList1 = invoiceDetailList1;
    }

    @XmlTransient
    public List<GeneralLedger> getGeneralLedgerList() {
        return generalLedgerList;
    }

    public void setGeneralLedgerList(List<GeneralLedger> generalLedgerList) {
        this.generalLedgerList = generalLedgerList;
    }

    @XmlTransient
    public List<GeneralLedger> getGeneralLedgerList1() {
        return generalLedgerList1;
    }

    public void setGeneralLedgerList1(List<GeneralLedger> generalLedgerList1) {
        this.generalLedgerList1 = generalLedgerList1;
    }

    @XmlTransient
    public List<TdsMaster> getTdsMasterList() {
        return tdsMasterList;
    }

    public void setTdsMasterList(List<TdsMaster> tdsMasterList) {
        this.tdsMasterList = tdsMasterList;
    }

    @XmlTransient
    public List<TdsMaster> getTdsMasterList1() {
        return tdsMasterList1;
    }

    public void setTdsMasterList1(List<TdsMaster> tdsMasterList1) {
        this.tdsMasterList1 = tdsMasterList1;
    }

    @XmlTransient
    public List<AccountMaster> getAccountMasterList() {
        return accountMasterList;
    }

    public void setAccountMasterList(List<AccountMaster> accountMasterList) {
        this.accountMasterList = accountMasterList;
    }

    @XmlTransient
    public List<AccountMaster> getAccountMasterList1() {
        return accountMasterList1;
    }

    public void setAccountMasterList1(List<AccountMaster> accountMasterList1) {
        this.accountMasterList1 = accountMasterList1;
    }

    @XmlTransient
    public List<PurchaseOrderApproval> getPurchaseOrderApprovalList() {
        return purchaseOrderApprovalList;
    }

    public void setPurchaseOrderApprovalList(List<PurchaseOrderApproval> purchaseOrderApprovalList) {
        this.purchaseOrderApprovalList = purchaseOrderApprovalList;
    }

    @XmlTransient
    public List<TdsType> getTdsTypeList() {
        return tdsTypeList;
    }

    public void setTdsTypeList(List<TdsType> tdsTypeList) {
        this.tdsTypeList = tdsTypeList;
    }

    @XmlTransient
    public List<TdsType> getTdsTypeList1() {
        return tdsTypeList1;
    }

    public void setTdsTypeList1(List<TdsType> tdsTypeList1) {
        this.tdsTypeList1 = tdsTypeList1;
    }

    @XmlTransient
    public List<SourceMaster> getSourceMasterList() {
        return sourceMasterList;
    }

    public void setSourceMasterList(List<SourceMaster> sourceMasterList) {
        this.sourceMasterList = sourceMasterList;
    }

    @XmlTransient
    public List<SourceMaster> getSourceMasterList1() {
        return sourceMasterList1;
    }

    public void setSourceMasterList1(List<SourceMaster> sourceMasterList1) {
        this.sourceMasterList1 = sourceMasterList1;
    }

    @XmlTransient
    public List<InvoicePayment> getInvoicePaymentList() {
        return invoicePaymentList;
    }

    public void setInvoicePaymentList(List<InvoicePayment> invoicePaymentList) {
        this.invoicePaymentList = invoicePaymentList;
    }

    @XmlTransient
    public List<InvoicePayment> getInvoicePaymentList1() {
        return invoicePaymentList1;
    }

    public void setInvoicePaymentList1(List<InvoicePayment> invoicePaymentList1) {
        this.invoicePaymentList1 = invoicePaymentList1;
    }

    @XmlTransient
    public List<VendorMaster> getVendorMasterList() {
        return vendorMasterList;
    }

    public void setVendorMasterList(List<VendorMaster> vendorMasterList) {
        this.vendorMasterList = vendorMasterList;
    }

    @XmlTransient
    public List<VendorMaster> getVendorMasterList1() {
        return vendorMasterList1;
    }

    public void setVendorMasterList1(List<VendorMaster> vendorMasterList1) {
        this.vendorMasterList1 = vendorMasterList1;
    }

    @XmlTransient
    public List<DebitNoteMaster> getDebitNoteMasterList() {
        return debitNoteMasterList;
    }

    public void setDebitNoteMasterList(List<DebitNoteMaster> debitNoteMasterList) {
        this.debitNoteMasterList = debitNoteMasterList;
    }

    @XmlTransient
    public List<DebitNoteMaster> getDebitNoteMasterList1() {
        return debitNoteMasterList1;
    }

    public void setDebitNoteMasterList1(List<DebitNoteMaster> debitNoteMasterList1) {
        this.debitNoteMasterList1 = debitNoteMasterList1;
    }

    @XmlTransient
    public List<MaterialTag> getMaterialTagList() {
        return materialTagList;
    }

    public void setMaterialTagList(List<MaterialTag> materialTagList) {
        this.materialTagList = materialTagList;
    }

    @XmlTransient
    public List<MaterialTag> getMaterialTagList1() {
        return materialTagList1;
    }

    public void setMaterialTagList1(List<MaterialTag> materialTagList1) {
        this.materialTagList1 = materialTagList1;
    }

    @XmlTransient
    public List<TagMaster> getTagMasterList() {
        return tagMasterList;
    }

    public void setTagMasterList(List<TagMaster> tagMasterList) {
        this.tagMasterList = tagMasterList;
    }

    @XmlTransient
    public List<TagMaster> getTagMasterList1() {
        return tagMasterList1;
    }

    public void setTagMasterList1(List<TagMaster> tagMasterList1) {
        this.tagMasterList1 = tagMasterList1;
    }

    @XmlTransient
    public List<InvoiceApproval> getInvoiceApprovalList() {
        return invoiceApprovalList;
    }

    public void setInvoiceApprovalList(List<InvoiceApproval> invoiceApprovalList) {
        this.invoiceApprovalList = invoiceApprovalList;
    }

    @XmlTransient
    public List<ServiceMaster> getServiceMasterList() {
        return serviceMasterList;
    }

    public void setServiceMasterList(List<ServiceMaster> serviceMasterList) {
        this.serviceMasterList = serviceMasterList;
    }

    @XmlTransient
    public List<ServiceMaster> getServiceMasterList1() {
        return serviceMasterList1;
    }

    public void setServiceMasterList1(List<ServiceMaster> serviceMasterList1) {
        this.serviceMasterList1 = serviceMasterList1;
    }

    @XmlTransient
    public List<UserBranchMapping> getUserBranchMappingList() {
        return userBranchMappingList;
    }

    public void setUserBranchMappingList(List<UserBranchMapping> userBranchMappingList) {
        this.userBranchMappingList = userBranchMappingList;
    }

    @XmlTransient
    public List<DebitNoteApproval> getDebitNoteApprovalList() {
        return debitNoteApprovalList;
    }

    public void setDebitNoteApprovalList(List<DebitNoteApproval> debitNoteApprovalList) {
        this.debitNoteApprovalList = debitNoteApprovalList;
    }

    @XmlTransient
    public List<BookingMaster> getBookingMasterList() {
        return bookingMasterList;
    }

    public void setBookingMasterList(List<BookingMaster> bookingMasterList) {
        this.bookingMasterList = bookingMasterList;
    }

    @XmlTransient
    public List<BookingMaster> getBookingMasterList1() {
        return bookingMasterList1;
    }

    public void setBookingMasterList1(List<BookingMaster> bookingMasterList1) {
        this.bookingMasterList1 = bookingMasterList1;
    }

    @XmlTransient
    public List<AdditionalUserRule> getAdditionalUserRuleList() {
        return additionalUserRuleList;
    }

    public void setAdditionalUserRuleList(List<AdditionalUserRule> additionalUserRuleList) {
        this.additionalUserRuleList = additionalUserRuleList;
    }

    @XmlTransient
    public List<CreditNoteMaster> getCreditNoteMasterList() {
        return creditNoteMasterList;
    }

    public void setCreditNoteMasterList(List<CreditNoteMaster> creditNoteMasterList) {
        this.creditNoteMasterList = creditNoteMasterList;
    }

    @XmlTransient
    public List<CreditNoteMaster> getCreditNoteMasterList1() {
        return creditNoteMasterList1;
    }

    public void setCreditNoteMasterList1(List<CreditNoteMaster> creditNoteMasterList1) {
        this.creditNoteMasterList1 = creditNoteMasterList1;
    }

    public BranchMaster getBranchMasterId() {
        return branchMasterId;
    }

    public void setBranchMasterId(BranchMaster branchMasterId) {
        this.branchMasterId = branchMasterId;
    }

    public FileAsset getUserProfilePicId() {
        return userProfilePicId;
    }

    public void setUserProfilePicId(FileAsset userProfilePicId) {
        this.userProfilePicId = userProfilePicId;
    }

    public StaffMaster getStaffMasterId() {
        return staffMasterId;
    }

    public void setStaffMasterId(StaffMaster staffMasterId) {
        this.staffMasterId = staffMasterId;
    }

    @XmlTransient
    public List<DebitNoteDetail> getDebitNoteDetailList() {
        return debitNoteDetailList;
    }

    public void setDebitNoteDetailList(List<DebitNoteDetail> debitNoteDetailList) {
        this.debitNoteDetailList = debitNoteDetailList;
    }

    @XmlTransient
    public List<DebitNoteDetail> getDebitNoteDetailList1() {
        return debitNoteDetailList1;
    }

    public void setDebitNoteDetailList1(List<DebitNoteDetail> debitNoteDetailList1) {
        this.debitNoteDetailList1 = debitNoteDetailList1;
    }

    @XmlTransient
    public List<StaffMaster> getStaffMasterList() {
        return staffMasterList;
    }

    public void setStaffMasterList(List<StaffMaster> staffMasterList) {
        this.staffMasterList = staffMasterList;
    }

    @XmlTransient
    public List<StaffMaster> getStaffMasterList1() {
        return staffMasterList1;
    }

    public void setStaffMasterList1(List<StaffMaster> staffMasterList1) {
        this.staffMasterList1 = staffMasterList1;
    }

    @XmlTransient
    public List<BillPayment> getBillPaymentList() {
        return billPaymentList;
    }

    public void setBillPaymentList(List<BillPayment> billPaymentList) {
        this.billPaymentList = billPaymentList;
    }

    @XmlTransient
    public List<BillPayment> getBillPaymentList1() {
        return billPaymentList1;
    }

    public void setBillPaymentList1(List<BillPayment> billPaymentList1) {
        this.billPaymentList1 = billPaymentList1;
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
    public List<CreditNoteDetail> getCreditNoteDetailList1() {
        return creditNoteDetailList1;
    }

    public void setCreditNoteDetailList1(List<CreditNoteDetail> creditNoteDetailList1) {
        this.creditNoteDetailList1 = creditNoteDetailList1;
    }

    @XmlTransient
    public List<AssetMaster> getAssetMasterList() {
        return assetMasterList;
    }

    public void setAssetMasterList(List<AssetMaster> assetMasterList) {
        this.assetMasterList = assetMasterList;
    }

    @XmlTransient
    public List<AssetMaster> getAssetMasterList1() {
        return assetMasterList1;
    }

    public void setAssetMasterList1(List<AssetMaster> assetMasterList1) {
        this.assetMasterList1 = assetMasterList1;
    }

    @XmlTransient
    public List<CustomerMaster> getCustomerMasterList() {
        return customerMasterList;
    }

    public void setCustomerMasterList(List<CustomerMaster> customerMasterList) {
        this.customerMasterList = customerMasterList;
    }

    @XmlTransient
    public List<CustomerMaster> getCustomerMasterList1() {
        return customerMasterList1;
    }

    public void setCustomerMasterList1(List<CustomerMaster> customerMasterList1) {
        this.customerMasterList1 = customerMasterList1;
    }

    @XmlTransient
    public List<CustomerMaster> getCustomerMasterList2() {
        return customerMasterList2;
    }

    public void setCustomerMasterList2(List<CustomerMaster> customerMasterList2) {
        this.customerMasterList2 = customerMasterList2;
    }

    @XmlTransient
    public List<ServiceCategory> getServiceCategoryList() {
        return serviceCategoryList;
    }

    public void setServiceCategoryList(List<ServiceCategory> serviceCategoryList) {
        this.serviceCategoryList = serviceCategoryList;
    }

    @XmlTransient
    public List<ServiceCategory> getServiceCategoryList1() {
        return serviceCategoryList1;
    }

    public void setServiceCategoryList1(List<ServiceCategory> serviceCategoryList1) {
        this.serviceCategoryList1 = serviceCategoryList1;
    }

    @XmlTransient
    public List<ServiceTagLink> getServiceTagLinkList() {
        return serviceTagLinkList;
    }

    public void setServiceTagLinkList(List<ServiceTagLink> serviceTagLinkList) {
        this.serviceTagLinkList = serviceTagLinkList;
    }

    @XmlTransient
    public List<ServiceTagLink> getServiceTagLinkList1() {
        return serviceTagLinkList1;
    }

    public void setServiceTagLinkList1(List<ServiceTagLink> serviceTagLinkList1) {
        this.serviceTagLinkList1 = serviceTagLinkList1;
    }

    @XmlTransient
    public List<MaterialTagLink> getMaterialTagLinkList() {
        return materialTagLinkList;
    }

    public void setMaterialTagLinkList(List<MaterialTagLink> materialTagLinkList) {
        this.materialTagLinkList = materialTagLinkList;
    }

    @XmlTransient
    public List<MaterialTagLink> getMaterialTagLinkList1() {
        return materialTagLinkList1;
    }

    public void setMaterialTagLinkList1(List<MaterialTagLink> materialTagLinkList1) {
        this.materialTagLinkList1 = materialTagLinkList1;
    }

    @XmlTransient
    public List<MaterialVariantValue> getMaterialVariantValueList() {
        return materialVariantValueList;
    }

    public void setMaterialVariantValueList(List<MaterialVariantValue> materialVariantValueList) {
        this.materialVariantValueList = materialVariantValueList;
    }

    @XmlTransient
    public List<MaterialVariantValue> getMaterialVariantValueList1() {
        return materialVariantValueList1;
    }

    public void setMaterialVariantValueList1(List<MaterialVariantValue> materialVariantValueList1) {
        this.materialVariantValueList1 = materialVariantValueList1;
    }

    @XmlTransient
    public List<MaterialMaster> getMaterialMasterList() {
        return materialMasterList;
    }

    public void setMaterialMasterList(List<MaterialMaster> materialMasterList) {
        this.materialMasterList = materialMasterList;
    }

    @XmlTransient
    public List<MaterialMaster> getMaterialMasterList1() {
        return materialMasterList1;
    }

    public void setMaterialMasterList1(List<MaterialMaster> materialMasterList1) {
        this.materialMasterList1 = materialMasterList1;
    }

    @XmlTransient
    public List<ServiceUnit> getServiceUnitList() {
        return serviceUnitList;
    }

    public void setServiceUnitList(List<ServiceUnit> serviceUnitList) {
        this.serviceUnitList = serviceUnitList;
    }

    @XmlTransient
    public List<ServiceUnit> getServiceUnitList1() {
        return serviceUnitList1;
    }

    public void setServiceUnitList1(List<ServiceUnit> serviceUnitList1) {
        this.serviceUnitList1 = serviceUnitList1;
    }

    @XmlTransient
    public List<BookingDetail> getBookingDetailList() {
        return bookingDetailList;
    }

    public void setBookingDetailList(List<BookingDetail> bookingDetailList) {
        this.bookingDetailList = bookingDetailList;
    }

    @XmlTransient
    public List<BookingDetail> getBookingDetailList1() {
        return bookingDetailList1;
    }

    public void setBookingDetailList1(List<BookingDetail> bookingDetailList1) {
        this.bookingDetailList1 = bookingDetailList1;
    }

    @XmlTransient
    public List<ProjectMaster> getProjectMasterList() {
        return projectMasterList;
    }

    public void setProjectMasterList(List<ProjectMaster> projectMasterList) {
        this.projectMasterList = projectMasterList;
    }

    @XmlTransient
    public List<ProjectMaster> getProjectMasterList1() {
        return projectMasterList1;
    }

    public void setProjectMasterList1(List<ProjectMaster> projectMasterList1) {
        this.projectMasterList1 = projectMasterList1;
    }

    @XmlTransient
    public List<RestrictedUserRule> getRestrictedUserRuleList() {
        return restrictedUserRuleList;
    }

    public void setRestrictedUserRuleList(List<RestrictedUserRule> restrictedUserRuleList) {
        this.restrictedUserRuleList = restrictedUserRuleList;
    }

    @XmlTransient
    public List<MaterialTransactionMaster> getMaterialTransactionMasterList() {
        return materialTransactionMasterList;
    }

    public void setMaterialTransactionMasterList(List<MaterialTransactionMaster> materialTransactionMasterList) {
        this.materialTransactionMasterList = materialTransactionMasterList;
    }

    @XmlTransient
    public List<MaterialTransactionMaster> getMaterialTransactionMasterList1() {
        return materialTransactionMasterList1;
    }

    public void setMaterialTransactionMasterList1(List<MaterialTransactionMaster> materialTransactionMasterList1) {
        this.materialTransactionMasterList1 = materialTransactionMasterList1;
    }

    @XmlTransient
    public List<BookingApproval> getBookingApprovalList() {
        return bookingApprovalList;
    }

    public void setBookingApprovalList(List<BookingApproval> bookingApprovalList) {
        this.bookingApprovalList = bookingApprovalList;
    }

    @XmlTransient
    public List<CreditNoteApproval> getCreditNoteApprovalList() {
        return creditNoteApprovalList;
    }

    public void setCreditNoteApprovalList(List<CreditNoteApproval> creditNoteApprovalList) {
        this.creditNoteApprovalList = creditNoteApprovalList;
    }

    @XmlTransient
    public List<MaterialCategory> getMaterialCategoryList() {
        return materialCategoryList;
    }

    public void setMaterialCategoryList(List<MaterialCategory> materialCategoryList) {
        this.materialCategoryList = materialCategoryList;
    }

    @XmlTransient
    public List<MaterialCategory> getMaterialCategoryList1() {
        return materialCategoryList1;
    }

    public void setMaterialCategoryList1(List<MaterialCategory> materialCategoryList1) {
        this.materialCategoryList1 = materialCategoryList1;
    }

    @XmlTransient
    public List<MaterialVariant> getMaterialVariantList() {
        return materialVariantList;
    }

    public void setMaterialVariantList(List<MaterialVariant> materialVariantList) {
        this.materialVariantList = materialVariantList;
    }

    @XmlTransient
    public List<MaterialVariant> getMaterialVariantList1() {
        return materialVariantList1;
    }

    public void setMaterialVariantList1(List<MaterialVariant> materialVariantList1) {
        this.materialVariantList1 = materialVariantList1;
    }

    @XmlTransient
    public List<BudgetMaster> getBudgetMasterList() {
        return budgetMasterList;
    }

    public void setBudgetMasterList(List<BudgetMaster> budgetMasterList) {
        this.budgetMasterList = budgetMasterList;
    }

    @XmlTransient
    public List<BudgetMaster> getBudgetMasterList1() {
        return budgetMasterList1;
    }

    public void setBudgetMasterList1(List<BudgetMaster> budgetMasterList1) {
        this.budgetMasterList1 = budgetMasterList1;
    }

    @XmlTransient
    public List<PayRequest> getPayRequestList() {
        return payRequestList;
    }

    public void setPayRequestList(List<PayRequest> payRequestList) {
        this.payRequestList = payRequestList;
    }

    @XmlTransient
    public List<PayRequest> getPayRequestList1() {
        return payRequestList1;
    }

    public void setPayRequestList1(List<PayRequest> payRequestList1) {
        this.payRequestList1 = payRequestList1;
    }

    @XmlTransient
    public List<PayRequest> getPayRequestList2() {
        return payRequestList2;
    }

    public void setPayRequestList2(List<PayRequest> payRequestList2) {
        this.payRequestList2 = payRequestList2;
    }

    @XmlTransient
    public List<PayRequest> getPayRequestList3() {
        return payRequestList3;
    }

    public void setPayRequestList3(List<PayRequest> payRequestList3) {
        this.payRequestList3 = payRequestList3;
    }

    @XmlTransient
    public List<PayRequest> getPayRequestList4() {
        return payRequestList4;
    }

    public void setPayRequestList4(List<PayRequest> payRequestList4) {
        this.payRequestList4 = payRequestList4;
    }

    @XmlTransient
    public List<PayRequest> getPayRequestList5() {
        return payRequestList5;
    }

    public void setPayRequestList5(List<PayRequest> payRequestList5) {
        this.payRequestList5 = payRequestList5;
    }

    @XmlTransient
    public List<PayRequest> getPayRequestList6() {
        return payRequestList6;
    }

    public void setPayRequestList6(List<PayRequest> payRequestList6) {
        this.payRequestList6 = payRequestList6;
    }

    @XmlTransient
    public List<PayRequest> getPayRequestList7() {
        return payRequestList7;
    }

    public void setPayRequestList7(List<PayRequest> payRequestList7) {
        this.payRequestList7 = payRequestList7;
    }

    @XmlTransient
    public List<PayRequest> getPayRequestList8() {
        return payRequestList8;
    }

    public void setPayRequestList8(List<PayRequest> payRequestList8) {
        this.payRequestList8 = payRequestList8;
    }

    @XmlTransient
    public List<BillDetail> getBillDetailList() {
        return billDetailList;
    }

    public void setBillDetailList(List<BillDetail> billDetailList) {
        this.billDetailList = billDetailList;
    }

    @XmlTransient
    public List<BillDetail> getBillDetailList1() {
        return billDetailList1;
    }

    public void setBillDetailList1(List<BillDetail> billDetailList1) {
        this.billDetailList1 = billDetailList1;
    }

    @XmlTransient
    public List<WidgetUserMapping> getWidgetUserMappingList() {
        return widgetUserMappingList;
    }

    public void setWidgetUserMappingList(List<WidgetUserMapping> widgetUserMappingList) {
        this.widgetUserMappingList = widgetUserMappingList;
    }

    @XmlTransient
    public List<BranchMaster> getBranchMasterList() {
        return branchMasterList;
    }

    public void setBranchMasterList(List<BranchMaster> branchMasterList) {
        this.branchMasterList = branchMasterList;
    }

    @XmlTransient
    public List<BranchMaster> getBranchMasterList1() {
        return branchMasterList1;
    }

    public void setBranchMasterList1(List<BranchMaster> branchMasterList1) {
        this.branchMasterList1 = branchMasterList1;
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
        hash += (userMasterId != null ? userMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserMaster)) {
            return false;
        }
        UserMaster other = (UserMaster) object;
        if ((this.userMasterId == null && other.userMasterId != null) || (this.userMasterId != null && !this.userMasterId.equals(other.userMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.UserMaster[ userMasterId=" + userMasterId + " ]";
    }
    
}
