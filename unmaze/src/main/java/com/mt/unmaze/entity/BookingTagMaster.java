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
@Table(name = "booking_tag_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookingTagMaster.findAll", query = "SELECT b FROM BookingTagMaster b"),
    @NamedQuery(name = "BookingTagMaster.findByBookingTagMasterId", query = "SELECT b FROM BookingTagMaster b WHERE b.bookingTagMasterId = :bookingTagMasterId"),
    @NamedQuery(name = "BookingTagMaster.findByProductionId", query = "SELECT b FROM BookingTagMaster b WHERE b.productionId = :productionId"),
    @NamedQuery(name = "BookingTagMaster.findByIsActive", query = "SELECT b FROM BookingTagMaster b WHERE b.isActive = :isActive")})
public class BookingTagMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "booking_tag_master_id")
    private Integer bookingTagMasterId;
    @Column(name = "production_id")
    private Integer productionId;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @JoinColumn(name = "asset_master_id", referencedColumnName = "asset_master_id")
    @ManyToOne
    private AssetMaster assetMasterId;
    @JoinColumn(name = "booking_master_id", referencedColumnName = "booking_master_id")
    @ManyToOne
    private BookingMaster bookingMasterId;
    @JoinColumn(name = "credit_note_master_id", referencedColumnName = "credit_note_master_id")
    @ManyToOne
    private CreditNoteMaster creditNoteMasterId;
    @JoinColumn(name = "e_commerce_id", referencedColumnName = "e_commerce_id")
    @ManyToOne
    private ECommerce eCommerceId;
    @JoinColumn(name = "invoice_master_id", referencedColumnName = "invoice_master_id")
    @ManyToOne
    private InvoiceMaster invoiceMasterId;
    @JoinColumn(name = "revenue_segment_id", referencedColumnName = "revenue_segment_id")
    @ManyToOne
    private RevenueSegment revenueSegmentId;
    @JoinColumn(name = "source_master_id", referencedColumnName = "source_master_id")
    @ManyToOne
    private SourceMaster sourceMasterId;
    @JoinColumn(name = "staff_master_id", referencedColumnName = "staff_master_id")
    @ManyToOne
    private StaffMaster staffMasterId;

    public BookingTagMaster() {
    }

    public BookingTagMaster(Integer bookingTagMasterId) {
        this.bookingTagMasterId = bookingTagMasterId;
    }

    public BookingTagMaster(Integer bookingTagMasterId, Character isActive) {
        this.bookingTagMasterId = bookingTagMasterId;
        this.isActive = isActive;
    }

    public Integer getBookingTagMasterId() {
        return bookingTagMasterId;
    }

    public void setBookingTagMasterId(Integer bookingTagMasterId) {
        this.bookingTagMasterId = bookingTagMasterId;
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

    public BookingMaster getBookingMasterId() {
        return bookingMasterId;
    }

    public void setBookingMasterId(BookingMaster bookingMasterId) {
        this.bookingMasterId = bookingMasterId;
    }

    public CreditNoteMaster getCreditNoteMasterId() {
        return creditNoteMasterId;
    }

    public void setCreditNoteMasterId(CreditNoteMaster creditNoteMasterId) {
        this.creditNoteMasterId = creditNoteMasterId;
    }

    public ECommerce getECommerceId() {
        return eCommerceId;
    }

    public void setECommerceId(ECommerce eCommerceId) {
        this.eCommerceId = eCommerceId;
    }

    public InvoiceMaster getInvoiceMasterId() {
        return invoiceMasterId;
    }

    public void setInvoiceMasterId(InvoiceMaster invoiceMasterId) {
        this.invoiceMasterId = invoiceMasterId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingTagMasterId != null ? bookingTagMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookingTagMaster)) {
            return false;
        }
        BookingTagMaster other = (BookingTagMaster) object;
        if ((this.bookingTagMasterId == null && other.bookingTagMasterId != null) || (this.bookingTagMasterId != null && !this.bookingTagMasterId.equals(other.bookingTagMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.BookingTagMaster[ bookingTagMasterId=" + bookingTagMasterId + " ]";
    }
    
}
