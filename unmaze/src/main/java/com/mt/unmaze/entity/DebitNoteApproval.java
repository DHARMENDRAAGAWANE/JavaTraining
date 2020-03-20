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
@Table(name = "debit_note_approval")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DebitNoteApproval.findAll", query = "SELECT d FROM DebitNoteApproval d"),
    @NamedQuery(name = "DebitNoteApproval.findByDebitNoteApprovalId", query = "SELECT d FROM DebitNoteApproval d WHERE d.debitNoteApprovalId = :debitNoteApprovalId"),
    @NamedQuery(name = "DebitNoteApproval.findByApprovalLevel", query = "SELECT d FROM DebitNoteApproval d WHERE d.approvalLevel = :approvalLevel"),
    @NamedQuery(name = "DebitNoteApproval.findByApprovalStatus", query = "SELECT d FROM DebitNoteApproval d WHERE d.approvalStatus = :approvalStatus"),
    @NamedQuery(name = "DebitNoteApproval.findByIsActive", query = "SELECT d FROM DebitNoteApproval d WHERE d.isActive = :isActive")})
public class DebitNoteApproval implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "debit_note_approval_id")
    private Integer debitNoteApprovalId;
    @Basic(optional = false)
    @Column(name = "approval_level")
    private int approvalLevel;
    @Basic(optional = false)
    @Column(name = "approval_status")
    private String approvalStatus;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @JoinColumn(name = "debit_note_master_id", referencedColumnName = "debit_note_master_id")
    @ManyToOne(optional = false)
    private DebitNoteMaster debitNoteMasterId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_master_id")
    @ManyToOne(optional = false)
    private UserMaster userId;

    public DebitNoteApproval() {
    }

    public DebitNoteApproval(Integer debitNoteApprovalId) {
        this.debitNoteApprovalId = debitNoteApprovalId;
    }

    public DebitNoteApproval(Integer debitNoteApprovalId, int approvalLevel, String approvalStatus, Character isActive) {
        this.debitNoteApprovalId = debitNoteApprovalId;
        this.approvalLevel = approvalLevel;
        this.approvalStatus = approvalStatus;
        this.isActive = isActive;
    }

    public Integer getDebitNoteApprovalId() {
        return debitNoteApprovalId;
    }

    public void setDebitNoteApprovalId(Integer debitNoteApprovalId) {
        this.debitNoteApprovalId = debitNoteApprovalId;
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

    public DebitNoteMaster getDebitNoteMasterId() {
        return debitNoteMasterId;
    }

    public void setDebitNoteMasterId(DebitNoteMaster debitNoteMasterId) {
        this.debitNoteMasterId = debitNoteMasterId;
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
        hash += (debitNoteApprovalId != null ? debitNoteApprovalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DebitNoteApproval)) {
            return false;
        }
        DebitNoteApproval other = (DebitNoteApproval) object;
        if ((this.debitNoteApprovalId == null && other.debitNoteApprovalId != null) || (this.debitNoteApprovalId != null && !this.debitNoteApprovalId.equals(other.debitNoteApprovalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.DebitNoteApproval[ debitNoteApprovalId=" + debitNoteApprovalId + " ]";
    }
    
}
