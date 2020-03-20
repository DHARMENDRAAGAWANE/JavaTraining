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
@Table(name = "invoice_approval")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvoiceApproval.findAll", query = "SELECT i FROM InvoiceApproval i"),
    @NamedQuery(name = "InvoiceApproval.findByInvoiceApprovalId", query = "SELECT i FROM InvoiceApproval i WHERE i.invoiceApprovalId = :invoiceApprovalId"),
    @NamedQuery(name = "InvoiceApproval.findByApprovalLevel", query = "SELECT i FROM InvoiceApproval i WHERE i.approvalLevel = :approvalLevel"),
    @NamedQuery(name = "InvoiceApproval.findByApprovalStatus", query = "SELECT i FROM InvoiceApproval i WHERE i.approvalStatus = :approvalStatus"),
    @NamedQuery(name = "InvoiceApproval.findByIsActive", query = "SELECT i FROM InvoiceApproval i WHERE i.isActive = :isActive")})
public class InvoiceApproval implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "invoice_approval_id")
    private Integer invoiceApprovalId;
    @Basic(optional = false)
    @Column(name = "approval_level")
    private int approvalLevel;
    @Basic(optional = false)
    @Column(name = "approval_status")
    private String approvalStatus;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @JoinColumn(name = "invoice_master_id", referencedColumnName = "invoice_master_id")
    @ManyToOne(optional = false)
    private InvoiceMaster invoiceMasterId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_master_id")
    @ManyToOne(optional = false)
    private UserMaster userId;

    public InvoiceApproval() {
    }

    public InvoiceApproval(Integer invoiceApprovalId) {
        this.invoiceApprovalId = invoiceApprovalId;
    }

    public InvoiceApproval(Integer invoiceApprovalId, int approvalLevel, String approvalStatus, Character isActive) {
        this.invoiceApprovalId = invoiceApprovalId;
        this.approvalLevel = approvalLevel;
        this.approvalStatus = approvalStatus;
        this.isActive = isActive;
    }

    public Integer getInvoiceApprovalId() {
        return invoiceApprovalId;
    }

    public void setInvoiceApprovalId(Integer invoiceApprovalId) {
        this.invoiceApprovalId = invoiceApprovalId;
    }

    public int getApprovalLevel() {
        return approvalLevel;
    }

    public void setApprovalLevel(int approvalLevel) {
        this.approvalLevel = approvalLevel;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    public InvoiceMaster getInvoiceMasterId() {
        return invoiceMasterId;
    }

    public void setInvoiceMasterId(InvoiceMaster invoiceMasterId) {
        this.invoiceMasterId = invoiceMasterId;
    }

    public UserMaster getUserId() {
        return userId;
    }

    public void setUserId(UserMaster userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceApprovalId != null ? invoiceApprovalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceApproval)) {
            return false;
        }
        InvoiceApproval other = (InvoiceApproval) object;
        if ((this.invoiceApprovalId == null && other.invoiceApprovalId != null) || (this.invoiceApprovalId != null && !this.invoiceApprovalId.equals(other.invoiceApprovalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.InvoiceApproval[ invoiceApprovalId=" + invoiceApprovalId + " ]";
    }
    
}
