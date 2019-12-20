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
@Table(name = "tag_mapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TagMapping.findAll", query = "SELECT t FROM TagMapping t"),
    @NamedQuery(name = "TagMapping.findByTagMappingId", query = "SELECT t FROM TagMapping t WHERE t.tagMappingId = :tagMappingId"),
    @NamedQuery(name = "TagMapping.findByIsActive", query = "SELECT t FROM TagMapping t WHERE t.isActive = :isActive")})
public class TagMapping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tag_mapping_id")
    private Integer tagMappingId;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @JoinColumn(name = "bill_master_id", referencedColumnName = "bill_master_id")
    @ManyToOne
    private BillMaster billMasterId;
    @JoinColumn(name = "booking_master_id", referencedColumnName = "booking_master_id")
    @ManyToOne
    private BookingMaster bookingMasterId;
    @JoinColumn(name = "credit_note_master_id", referencedColumnName = "credit_note_master_id")
    @ManyToOne
    private CreditNoteMaster creditNoteMasterId;
    @JoinColumn(name = "debit_note_master_id", referencedColumnName = "debit_note_master_id")
    @ManyToOne
    private DebitNoteMaster debitNoteMasterId;
    @JoinColumn(name = "invoice_master_id", referencedColumnName = "invoice_master_id")
    @ManyToOne
    private InvoiceMaster invoiceMasterId;
    @JoinColumn(name = "purchase_order_master_id", referencedColumnName = "purchase_order_master_id")
    @ManyToOne
    private PurchaseOrderMaster purchaseOrderMasterId;
    @JoinColumn(name = "tag_master_id", referencedColumnName = "tag_master_id")
    @ManyToOne
    private TagMaster tagMasterId;

    public TagMapping() {
    }

    public TagMapping(Integer tagMappingId) {
        this.tagMappingId = tagMappingId;
    }

    public TagMapping(Integer tagMappingId, Character isActive) {
        this.tagMappingId = tagMappingId;
        this.isActive = isActive;
    }

    public Integer getTagMappingId() {
        return tagMappingId;
    }

    public void setTagMappingId(Integer tagMappingId) {
        this.tagMappingId = tagMappingId;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
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

    public CreditNoteMaster getCreditNoteMasterId() {
        return creditNoteMasterId;
    }

    public void setCreditNoteMasterId(CreditNoteMaster creditNoteMasterId) {
        this.creditNoteMasterId = creditNoteMasterId;
    }

    public DebitNoteMaster getDebitNoteMasterId() {
        return debitNoteMasterId;
    }

    public void setDebitNoteMasterId(DebitNoteMaster debitNoteMasterId) {
        this.debitNoteMasterId = debitNoteMasterId;
    }

    public InvoiceMaster getInvoiceMasterId() {
        return invoiceMasterId;
    }

    public void setInvoiceMasterId(InvoiceMaster invoiceMasterId) {
        this.invoiceMasterId = invoiceMasterId;
    }

    public PurchaseOrderMaster getPurchaseOrderMasterId() {
        return purchaseOrderMasterId;
    }

    public void setPurchaseOrderMasterId(PurchaseOrderMaster purchaseOrderMasterId) {
        this.purchaseOrderMasterId = purchaseOrderMasterId;
    }

    public TagMaster getTagMasterId() {
        return tagMasterId;
    }

    public void setTagMasterId(TagMaster tagMasterId) {
        this.tagMasterId = tagMasterId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tagMappingId != null ? tagMappingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TagMapping)) {
            return false;
        }
        TagMapping other = (TagMapping) object;
        if ((this.tagMappingId == null && other.tagMappingId != null) || (this.tagMappingId != null && !this.tagMappingId.equals(other.tagMappingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.TagMapping[ tagMappingId=" + tagMappingId + " ]";
    }
    
}
