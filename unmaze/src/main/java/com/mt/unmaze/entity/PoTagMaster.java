/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mt.unmaze.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "po_tag_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PoTagMaster.findAll", query = "SELECT p FROM PoTagMaster p"),
    @NamedQuery(name = "PoTagMaster.findByPoTagMasterId", query = "SELECT p FROM PoTagMaster p WHERE p.poTagMasterId = :poTagMasterId"),
    @NamedQuery(name = "PoTagMaster.findByProductionId", query = "SELECT p FROM PoTagMaster p WHERE p.productionId = :productionId"),
    @NamedQuery(name = "PoTagMaster.findByIsActive", query = "SELECT p FROM PoTagMaster p WHERE p.isActive = :isActive")})
public class PoTagMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "po_tag_master_id")
    private Integer poTagMasterId;
    @Column(name = "production_id")
    private Integer productionId;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @JoinColumn(name = "asset_master_id", referencedColumnName = "asset_master_id")
    @ManyToOne
    private AssetMaster assetMasterId;
    @JoinColumn(name = "bill_master_id", referencedColumnName = "bill_master_id")
    @ManyToOne
    private BillMaster billMasterId;
    @JoinColumn(name = "booking_master_id", referencedColumnName = "booking_master_id")
    @ManyToOne
    private BookingMaster bookingMasterId;
    @JoinColumn(name = "debit_note_master_id", referencedColumnName = "debit_note_master_id")
    @ManyToOne
    private DebitNoteMaster debitNoteMasterId;
    @JoinColumn(name = "purchase_order_master_id", referencedColumnName = "purchase_order_master_id")
    @ManyToOne
    private PurchaseOrderMaster purchaseOrderMasterId;
    @JoinColumn(name = "revenue_segment_id", referencedColumnName = "revenue_segment_id")
    @ManyToOne
    private RevenueSegment revenueSegmentId;
    @JoinColumn(name = "source_master_id", referencedColumnName = "source_master_id")
    @ManyToOne
    private SourceMaster sourceMasterId;
    @JoinColumn(name = "staff_master_id", referencedColumnName = "staff_master_id")
    @ManyToOne
    private StaffMaster staffMasterId;
    @JoinColumn(name = "custom_tag_master_id", referencedColumnName = "tag_master_id")
    @ManyToOne
    private TagMaster customTagMasterId;

    public PoTagMaster() {
    }

    public PoTagMaster(Integer poTagMasterId) {
        this.poTagMasterId = poTagMasterId;
    }

    public PoTagMaster(Integer poTagMasterId, Character isActive) {
        this.poTagMasterId = poTagMasterId;
        this.isActive = isActive;
    }

    public Integer getPoTagMasterId() {
        return poTagMasterId;
    }

    public void setPoTagMasterId(Integer poTagMasterId) {
        this.poTagMasterId = poTagMasterId;
    }

    public Integer getProductionId() {
        return productionId;
    }

    public void setProductionId(Integer productionId) {
        this.productionId = productionId;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    public AssetMaster getAssetMasterId() {
        return assetMasterId;
    }

    public void setAssetMasterId(AssetMaster assetMasterId) {
        this.assetMasterId = assetMasterId;
    }

    public BillMaster getBillMasterId() {
        return billMasterId;
    }

    public void setBillMasterId(BillMaster billMasterId) {
        this.billMasterId = billMasterId;
    }

    public BookingMaster getBookingMasterId() {
        return bookingMasterId;
    }

    public void setBookingMasterId(BookingMaster bookingMasterId) {
        this.bookingMasterId = bookingMasterId;
    }

    public DebitNoteMaster getDebitNoteMasterId() {
        return debitNoteMasterId;
    }

    public void setDebitNoteMasterId(DebitNoteMaster debitNoteMasterId) {
        this.debitNoteMasterId = debitNoteMasterId;
    }

    public PurchaseOrderMaster getPurchaseOrderMasterId() {
        return purchaseOrderMasterId;
    }

    public void setPurchaseOrderMasterId(PurchaseOrderMaster purchaseOrderMasterId) {
        this.purchaseOrderMasterId = purchaseOrderMasterId;
    }

    public RevenueSegment getRevenueSegmentId() {
        return revenueSegmentId;
    }

    public void setRevenueSegmentId(RevenueSegment revenueSegmentId) {
        this.revenueSegmentId = revenueSegmentId;
    }

    public SourceMaster getSourceMasterId() {
        return sourceMasterId;
    }

    public void setSourceMasterId(SourceMaster sourceMasterId) {
        this.sourceMasterId = sourceMasterId;
    }

    public StaffMaster getStaffMasterId() {
        return staffMasterId;
    }

    public void setStaffMasterId(StaffMaster staffMasterId) {
        this.staffMasterId = staffMasterId;
    }

    public TagMaster getCustomTagMasterId() {
        return customTagMasterId;
    }

    public void setCustomTagMasterId(TagMaster customTagMasterId) {
        this.customTagMasterId = customTagMasterId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (poTagMasterId != null ? poTagMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoTagMaster)) {
            return false;
        }
        PoTagMaster other = (PoTagMaster) object;
        if ((this.poTagMasterId == null && other.poTagMasterId != null) || (this.poTagMasterId != null && !this.poTagMasterId.equals(other.poTagMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.PoTagMaster[ poTagMasterId=" + poTagMasterId + " ]";
    }
    
}
