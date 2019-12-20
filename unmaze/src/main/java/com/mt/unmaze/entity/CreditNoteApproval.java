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
@Table(name = "credit_note_approval")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CreditNoteApproval.findAll", query = "SELECT c FROM CreditNoteApproval c"),
    @NamedQuery(name = "CreditNoteApproval.findByCreditNoteApprovalId", query = "SELECT c FROM CreditNoteApproval c WHERE c.creditNoteApprovalId = :creditNoteApprovalId"),
    @NamedQuery(name = "CreditNoteApproval.findByApprovalLevel", query = "SELECT c FROM CreditNoteApproval c WHERE c.approvalLevel = :approvalLevel"),
    @NamedQuery(name = "CreditNoteApproval.findByApprovalStatus", query = "SELECT c FROM CreditNoteApproval c WHERE c.approvalStatus = :approvalStatus"),
    @NamedQuery(name = "CreditNoteApproval.findByIsActive", query = "SELECT c FROM CreditNoteApproval c WHERE c.isActive = :isActive")})
public class CreditNoteApproval implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "credit_note_approval_id")
    private Integer creditNoteApprovalId;
    @Basic(optional = false)
    @Column(name = "approval_level")
    private int approvalLevel;
    @Basic(optional = false)
    @Column(name = "approval_status")
    private String approvalStatus;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @JoinColumn(name = "credit_note_master_id", referencedColumnName = "credit_note_master_id")
    @ManyToOne(optional = false)
    private CreditNoteMaster creditNoteMasterId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_master_id")
    @ManyToOne(optional = false)
    private UserMaster userId;

    public CreditNoteApproval() {
    }

    public CreditNoteApproval(Integer creditNoteApprovalId) {
        this.creditNoteApprovalId = creditNoteApprovalId;
    }

    public CreditNoteApproval(Integer creditNoteApprovalId, int approvalLevel, String approvalStatus, Character isActive) {
        this.creditNoteApprovalId = creditNoteApprovalId;
        this.approvalLevel = approvalLevel;
        this.approvalStatus = approvalStatus;
        this.isActive = isActive;
    }

    public Integer getCreditNoteApprovalId() {
        return creditNoteApprovalId;
    }

    public void setCreditNoteApprovalId(Integer creditNoteApprovalId) {
        this.creditNoteApprovalId = creditNoteApprovalId;
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

    public CreditNoteMaster getCreditNoteMasterId() {
        return creditNoteMasterId;
    }

    public void setCreditNoteMasterId(CreditNoteMaster creditNoteMasterId) {
        this.creditNoteMasterId = creditNoteMasterId;
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
        hash += (creditNoteApprovalId != null ? creditNoteApprovalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditNoteApproval)) {
            return false;
        }
        CreditNoteApproval other = (CreditNoteApproval) object;
        if ((this.creditNoteApprovalId == null && other.creditNoteApprovalId != null) || (this.creditNoteApprovalId != null && !this.creditNoteApprovalId.equals(other.creditNoteApprovalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.CreditNoteApproval[ creditNoteApprovalId=" + creditNoteApprovalId + " ]";
    }
    
}
