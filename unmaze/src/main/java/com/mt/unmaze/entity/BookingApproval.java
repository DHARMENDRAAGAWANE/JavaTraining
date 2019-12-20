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
@Table(name = "booking_approval")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookingApproval.findAll", query = "SELECT b FROM BookingApproval b"),
    @NamedQuery(name = "BookingApproval.findByBookingApprovalId", query = "SELECT b FROM BookingApproval b WHERE b.bookingApprovalId = :bookingApprovalId"),
    @NamedQuery(name = "BookingApproval.findByApprovalLevel", query = "SELECT b FROM BookingApproval b WHERE b.approvalLevel = :approvalLevel"),
    @NamedQuery(name = "BookingApproval.findByApprovalStatus", query = "SELECT b FROM BookingApproval b WHERE b.approvalStatus = :approvalStatus"),
    @NamedQuery(name = "BookingApproval.findByIsActive", query = "SELECT b FROM BookingApproval b WHERE b.isActive = :isActive")})
public class BookingApproval implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "booking_approval_id")
    private Integer bookingApprovalId;
    @Basic(optional = false)
    @Column(name = "approval_level")
    private int approvalLevel;
    @Basic(optional = false)
    @Column(name = "approval_status")
    private String approvalStatus;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @JoinColumn(name = "booking_master_id", referencedColumnName = "booking_master_id")
    @ManyToOne(optional = false)
    private BookingMaster bookingMasterId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_master_id")
    @ManyToOne(optional = false)
    private UserMaster userId;

    public BookingApproval() {
    }

    public BookingApproval(Integer bookingApprovalId) {
        this.bookingApprovalId = bookingApprovalId;
    }

    public BookingApproval(Integer bookingApprovalId, int approvalLevel, String approvalStatus, Character isActive) {
        this.bookingApprovalId = bookingApprovalId;
        this.approvalLevel = approvalLevel;
        this.approvalStatus = approvalStatus;
        this.isActive = isActive;
    }

    public Integer getBookingApprovalId() {
        return bookingApprovalId;
    }

    public void setBookingApprovalId(Integer bookingApprovalId) {
        this.bookingApprovalId = bookingApprovalId;
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

    public BookingMaster getBookingMasterId() {
        return bookingMasterId;
    }

    public void setBookingMasterId(BookingMaster bookingMasterId) {
        this.bookingMasterId = bookingMasterId;
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
        hash += (bookingApprovalId != null ? bookingApprovalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookingApproval)) {
            return false;
        }
        BookingApproval other = (BookingApproval) object;
        if ((this.bookingApprovalId == null && other.bookingApprovalId != null) || (this.bookingApprovalId != null && !this.bookingApprovalId.equals(other.bookingApprovalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.BookingApproval[ bookingApprovalId=" + bookingApprovalId + " ]";
    }
    
}
