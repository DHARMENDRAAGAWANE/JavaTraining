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
@Table(name = "purchase_order_approval")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseOrderApproval.findAll", query = "SELECT p FROM PurchaseOrderApproval p"),
    @NamedQuery(name = "PurchaseOrderApproval.findByPurchaseOrderApprovalId", query = "SELECT p FROM PurchaseOrderApproval p WHERE p.purchaseOrderApprovalId = :purchaseOrderApprovalId"),
    @NamedQuery(name = "PurchaseOrderApproval.findByApprovalLevel", query = "SELECT p FROM PurchaseOrderApproval p WHERE p.approvalLevel = :approvalLevel"),
    @NamedQuery(name = "PurchaseOrderApproval.findByApprovalStatus", query = "SELECT p FROM PurchaseOrderApproval p WHERE p.approvalStatus = :approvalStatus"),
    @NamedQuery(name = "PurchaseOrderApproval.findByIsActive", query = "SELECT p FROM PurchaseOrderApproval p WHERE p.isActive = :isActive")})
public class PurchaseOrderApproval implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "purchase_order_approval_id")
    private Integer purchaseOrderApprovalId;
    @Basic(optional = false)
    @Column(name = "approval_level")
    private int approvalLevel;
    @Basic(optional = false)
    @Column(name = "approval_status")
    private String approvalStatus;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @JoinColumn(name = "purchase_order_master_id", referencedColumnName = "purchase_order_master_id")
    @ManyToOne(optional = false)
    private PurchaseOrderMaster purchaseOrderMasterId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_master_id")
    @ManyToOne(optional = false)
    private UserMaster userId;

    public PurchaseOrderApproval() {
    }

    public PurchaseOrderApproval(Integer purchaseOrderApprovalId) {
        this.purchaseOrderApprovalId = purchaseOrderApprovalId;
    }

    public PurchaseOrderApproval(Integer purchaseOrderApprovalId, int approvalLevel, String approvalStatus, Character isActive) {
        this.purchaseOrderApprovalId = purchaseOrderApprovalId;
        this.approvalLevel = approvalLevel;
        this.approvalStatus = approvalStatus;
        this.isActive = isActive;
    }

    public Integer getPurchaseOrderApprovalId() {
        return purchaseOrderApprovalId;
    }

    public void setPurchaseOrderApprovalId(Integer purchaseOrderApprovalId) {
        this.purchaseOrderApprovalId = purchaseOrderApprovalId;
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

    public PurchaseOrderMaster getPurchaseOrderMasterId() {
        return purchaseOrderMasterId;
    }

    public void setPurchaseOrderMasterId(PurchaseOrderMaster purchaseOrderMasterId) {
        this.purchaseOrderMasterId = purchaseOrderMasterId;
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
        hash += (purchaseOrderApprovalId != null ? purchaseOrderApprovalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseOrderApproval)) {
            return false;
        }
        PurchaseOrderApproval other = (PurchaseOrderApproval) object;
        if ((this.purchaseOrderApprovalId == null && other.purchaseOrderApprovalId != null) || (this.purchaseOrderApprovalId != null && !this.purchaseOrderApprovalId.equals(other.purchaseOrderApprovalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.PurchaseOrderApproval[ purchaseOrderApprovalId=" + purchaseOrderApprovalId + " ]";
    }
    
}
