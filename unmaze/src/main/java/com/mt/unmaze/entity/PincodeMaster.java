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
@Table(name = "pincode_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PincodeMaster.findAll", query = "SELECT p FROM PincodeMaster p"),
    @NamedQuery(name = "PincodeMaster.findByPincodeMasterId", query = "SELECT p FROM PincodeMaster p WHERE p.pincodeMasterId = :pincodeMasterId"),
    @NamedQuery(name = "PincodeMaster.findByPincode", query = "SELECT p FROM PincodeMaster p WHERE p.pincode = :pincode"),
    @NamedQuery(name = "PincodeMaster.findByIsActive", query = "SELECT p FROM PincodeMaster p WHERE p.isActive = :isActive")})
public class PincodeMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pincode_master_id")
    private Integer pincodeMasterId;
    @Basic(optional = false)
    @Column(name = "pincode")
    private int pincode;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    @ManyToOne(optional = false)
    private City cityId;

    public PincodeMaster() {
    }

    public PincodeMaster(Integer pincodeMasterId) {
        this.pincodeMasterId = pincodeMasterId;
    }

    public PincodeMaster(Integer pincodeMasterId, int pincode, Character isActive) {
        this.pincodeMasterId = pincodeMasterId;
        this.pincode = pincode;
        this.isActive = isActive;
    }

    public Integer getPincodeMasterId() {
        return pincodeMasterId;
    }

    public void setPincodeMasterId(Integer pincodeMasterId) {
        this.pincodeMasterId = pincodeMasterId;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pincodeMasterId != null ? pincodeMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PincodeMaster)) {
            return false;
        }
        PincodeMaster other = (PincodeMaster) object;
        if ((this.pincodeMasterId == null && other.pincodeMasterId != null) || (this.pincodeMasterId != null && !this.pincodeMasterId.equals(other.pincodeMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.PincodeMaster[ pincodeMasterId=" + pincodeMasterId + " ]";
    }
    
}
