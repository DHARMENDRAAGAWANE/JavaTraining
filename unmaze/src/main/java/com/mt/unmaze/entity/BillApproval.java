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
@Table(name = "bill_approval")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BillApproval.findAll", query = "SELECT b FROM BillApproval b"),
    @NamedQuery(name = "BillApproval.findByBillApprovalId", query = "SELECT b FROM BillApproval b WHERE b.billApprovalId = :billApprovalId"),
    @NamedQuery(name = "BillApproval.findByApprovalLevel", query = "SELECT b FROM BillApproval b WHERE b.approvalLevel = :approvalLevel"),
    @NamedQuery(name = "BillApproval.findByApprovalStatus", query = "SELECT b FROM BillApproval b WHERE b.approvalStatus = :approvalStatus"),
    @NamedQuery(name = "BillApproval.findByIsActive", query = "SELECT b FROM BillApproval b WHERE b.isActive = :isActive")})
public class BillApproval implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bill_approval_id")
    private Integer billApprovalId;
    @Basic(optional = false)
    @Column(name = "approval_level")
    private int approvalLevel;
    @Basic(optional = false)
    @Column(name = "approval_status")
    private String approvalStatus;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @JoinColumn(name = "bill_master_id", referencedColumnName = "bill_master_id")
    @ManyToOne(optional = false)
    private BillMaster billMasterId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_master_id")
    @ManyToOne(optional = false)
    private UserMaster userId;

    public BillApproval() {
    }

    public BillApproval(Integer billApprovalId) {
        this.billApprovalId = billApprovalId;
    }

    public BillApproval(Integer billApprovalId, int approvalLevel, String approvalStatus, Character isActive) {
        this.billApprovalId = billApprovalId;
        this.approvalLevel = approvalLevel;
        this.approvalStatus = approvalStatus;
        this.isActive = isActive;
    }

    public Integer getBillApprovalId() {
        return billApprovalId;
    }

    public void setBillApprovalId(Integer billApprovalId) {
        this.billApprovalId = billApprovalId;
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

    public BillMaster getBillMasterId() {
        return billMasterId;
    }

    public void setBillMasterId(BillMaster billMasterId) {
        this.billMasterId = billMasterId;
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
        hash += (billApprovalId != null ? billApprovalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BillApproval)) {
            return false;
        }
        BillApproval other = (BillApproval) object;
        if ((this.billApprovalId == null && other.billApprovalId != null) || (this.billApprovalId != null && !this.billApprovalId.equals(other.billApprovalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.BillApproval[ billApprovalId=" + billApprovalId + " ]";
    }
    
}
