/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mt.unmaze.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "revenue_segment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RevenueSegment.findAll", query = "SELECT r FROM RevenueSegment r"),
    @NamedQuery(name = "RevenueSegment.findByRevenueSegmentId", query = "SELECT r FROM RevenueSegment r WHERE r.revenueSegmentId = :revenueSegmentId"),
    @NamedQuery(name = "RevenueSegment.findByRevenueSegmentName", query = "SELECT r FROM RevenueSegment r WHERE r.revenueSegmentName = :revenueSegmentName"),
    @NamedQuery(name = "RevenueSegment.findByIsActive", query = "SELECT r FROM RevenueSegment r WHERE r.isActive = :isActive")})
public class RevenueSegment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "revenue_segment_id")
    private Integer revenueSegmentId;
    @Basic(optional = false)
    @Column(name = "revenue_segment_name")
    private String revenueSegmentName;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @OneToMany(mappedBy = "revenueSegmentId")
    private List<BookingTagMaster> bookingTagMasterList;
    @OneToMany(mappedBy = "revenueSegmentId")
    private List<PoTagMaster> poTagMasterList;

    public RevenueSegment() {
    }

    public RevenueSegment(Integer revenueSegmentId) {
        this.revenueSegmentId = revenueSegmentId;
    }

    public RevenueSegment(Integer revenueSegmentId, String revenueSegmentName, Character isActive) {
        this.revenueSegmentId = revenueSegmentId;
        this.revenueSegmentName = revenueSegmentName;
        this.isActive = isActive;
    }

    public Integer getRevenueSegmentId() {
        return revenueSegmentId;
    }

    public void setRevenueSegmentId(Integer revenueSegmentId) {
        this.revenueSegmentId = revenueSegmentId;
    }

    public String getRevenueSegmentName() {
        return revenueSegmentName;
    }

    public void setRevenueSegmentName(String revenueSegmentName) {
        this.revenueSegmentName = revenueSegmentName;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<BookingTagMaster> getBookingTagMasterList() {
        return bookingTagMasterList;
    }

    public void setBookingTagMasterList(List<BookingTagMaster> bookingTagMasterList) {
        this.bookingTagMasterList = bookingTagMasterList;
    }

    @XmlTransient
    public List<PoTagMaster> getPoTagMasterList() {
        return poTagMasterList;
    }

    public void setPoTagMasterList(List<PoTagMaster> poTagMasterList) {
        this.poTagMasterList = poTagMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (revenueSegmentId != null ? revenueSegmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RevenueSegment)) {
            return false;
        }
        RevenueSegment other = (RevenueSegment) object;
        if ((this.revenueSegmentId == null && other.revenueSegmentId != null) || (this.revenueSegmentId != null && !this.revenueSegmentId.equals(other.revenueSegmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.RevenueSegment[ revenueSegmentId=" + revenueSegmentId + " ]";
    }
    
}
