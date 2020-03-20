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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "file_asset")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FileAsset.findAll", query = "SELECT f FROM FileAsset f"),
    @NamedQuery(name = "FileAsset.findByFileAssetId", query = "SELECT f FROM FileAsset f WHERE f.fileAssetId = :fileAssetId"),
    @NamedQuery(name = "FileAsset.findByFileName", query = "SELECT f FROM FileAsset f WHERE f.fileName = :fileName"),
    @NamedQuery(name = "FileAsset.findByMimeType", query = "SELECT f FROM FileAsset f WHERE f.mimeType = :mimeType"),
    @NamedQuery(name = "FileAsset.findBySize", query = "SELECT f FROM FileAsset f WHERE f.size = :size"),
    @NamedQuery(name = "FileAsset.findBySizeUnit", query = "SELECT f FROM FileAsset f WHERE f.sizeUnit = :sizeUnit"),
    @NamedQuery(name = "FileAsset.findByCloud", query = "SELECT f FROM FileAsset f WHERE f.cloud = :cloud"),
    @NamedQuery(name = "FileAsset.findByCategory", query = "SELECT f FROM FileAsset f WHERE f.category = :category"),
    @NamedQuery(name = "FileAsset.findBySection", query = "SELECT f FROM FileAsset f WHERE f.section = :section"),
    @NamedQuery(name = "FileAsset.findByCreatedAt", query = "SELECT f FROM FileAsset f WHERE f.createdAt = :createdAt"),
    @NamedQuery(name = "FileAsset.findByLastUpdatedAt", query = "SELECT f FROM FileAsset f WHERE f.lastUpdatedAt = :lastUpdatedAt")})
public class FileAsset implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "file_asset_id")
    private Integer fileAssetId;
    @Basic(optional = false)
    @Column(name = "file_name")
    private String fileName;
    @Basic(optional = false)
    @Column(name = "mime_type")
    private String mimeType;
    @Column(name = "size")
    private BigInteger size;
    @Column(name = "size_unit")
    private String sizeUnit;
    @Lob
    @Column(name = "public_url")
    private String publicUrl;
    @Lob
    @Column(name = "server_path")
    private String serverPath;
    @Column(name = "cloud")
    private String cloud;
    @Lob
    @Column(name = "permanent_url")
    private String permanentUrl;
    @Lob
    @Column(name = "params")
    private String params;
    @Column(name = "category")
    private String category;
    @Column(name = "section")
    private String section;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "last_updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedAt;
    @OneToMany(mappedBy = "invoiceFileAssetId")
    private List<InvoiceMaster> invoiceMasterList;
    @OneToMany(mappedBy = "eWayBillFileAssetId")
    private List<InvoiceMaster> invoiceMasterList1;
    @OneToMany(mappedBy = "billFileAssetId")
    private List<BillMaster> billMasterList;
    @OneToMany(mappedBy = "eWayBillFileAssetId")
    private List<BillMaster> billMasterList1;
    @OneToMany(mappedBy = "billEntryFileAssetId")
    private List<BillMaster> billMasterList2;
    @OneToMany(mappedBy = "securityFileAssetDoc1")
    private List<GoodsRecieptNote> goodsRecieptNoteList;
    @OneToMany(mappedBy = "securityFileAssetDoc2")
    private List<GoodsRecieptNote> goodsRecieptNoteList1;
    @OneToMany(mappedBy = "panCardId")
    private List<VendorMaster> vendorMasterList;
    @OneToMany(mappedBy = "cancelledChequeId")
    private List<VendorMaster> vendorMasterList1;
    @OneToMany(mappedBy = "gstRegistrationCertificateId")
    private List<VendorMaster> vendorMasterList2;
    @OneToMany(mappedBy = "userProfilePicId")
    private List<UserMaster> userMasterList;
    @OneToMany(mappedBy = "gstRegistrationCertificateId")
    private List<CustomerMaster> customerMasterList;
    @OneToMany(mappedBy = "panCardId")
    private List<CustomerMaster> customerMasterList1;
    @OneToMany(mappedBy = "cancelledChequeId")
    private List<CustomerMaster> customerMasterList2;
    @OneToMany(mappedBy = "document2")
    private List<PayRequest> payRequestList;
    @OneToMany(mappedBy = "document1")
    private List<PayRequest> payRequestList1;

    public FileAsset() {
    }

    public FileAsset(Integer fileAssetId) {
        this.fileAssetId = fileAssetId;
    }

    public FileAsset(Integer fileAssetId, String fileName, String mimeType, Date createdAt) {
        this.fileAssetId = fileAssetId;
        this.fileName = fileName;
        this.mimeType = mimeType;
        this.createdAt = createdAt;
    }

    public Integer getFileAssetId() {
        return fileAssetId;
    }

    public void setFileAssetId(Integer fileAssetId) {
        this.fileAssetId = fileAssetId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public BigInteger getSize() {
        return size;
    }

    public void setSize(BigInteger size) {
        this.size = size;
    }

    public String getSizeUnit() {
        return sizeUnit;
    }

    public void setSizeUnit(String sizeUnit) {
        this.sizeUnit = sizeUnit;
    }

    public String getPublicUrl() {
        return publicUrl;
    }

    public void setPublicUrl(String publicUrl) {
        this.publicUrl = publicUrl;
    }

    public String getServerPath() {
        return serverPath;
    }

    public void setServerPath(String serverPath) {
        this.serverPath = serverPath;
    }

    public String getCloud() {
        return cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    public String getPermanentUrl() {
        return permanentUrl;
    }

    public void setPermanentUrl(String permanentUrl) {
        this.permanentUrl = permanentUrl;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
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
    public List<BillMaster> getBillMasterList2() {
        return billMasterList2;
    }

    public void setBillMasterList2(List<BillMaster> billMasterList2) {
        this.billMasterList2 = billMasterList2;
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
    public List<VendorMaster> getVendorMasterList2() {
        return vendorMasterList2;
    }

    public void setVendorMasterList2(List<VendorMaster> vendorMasterList2) {
        this.vendorMasterList2 = vendorMasterList2;
    }

    @XmlTransient
    public List<UserMaster> getUserMasterList() {
        return userMasterList;
    }

    public void setUserMasterList(List<UserMaster> userMasterList) {
        this.userMasterList = userMasterList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fileAssetId != null ? fileAssetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FileAsset)) {
            return false;
        }
        FileAsset other = (FileAsset) object;
        if ((this.fileAssetId == null && other.fileAssetId != null) || (this.fileAssetId != null && !this.fileAssetId.equals(other.fileAssetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.FileAsset[ fileAssetId=" + fileAssetId + " ]";
    }
    
}
