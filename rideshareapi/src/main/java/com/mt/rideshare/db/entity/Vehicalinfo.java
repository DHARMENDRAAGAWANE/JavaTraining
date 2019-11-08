/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mt.rideshare.db.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 992325
 */
@Entity
@Table(name = "vehicalinfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicalinfo.findAll", query = "SELECT v FROM Vehicalinfo v"),
    @NamedQuery(name = "Vehicalinfo.findByLicensePlate", query = "SELECT v FROM Vehicalinfo v WHERE v.licensePlate = :licensePlate"),
    @NamedQuery(name = "Vehicalinfo.findByType", query = "SELECT v FROM Vehicalinfo v WHERE v.type = :type"),
    @NamedQuery(name = "Vehicalinfo.findByPassengerCapacity", query = "SELECT v FROM Vehicalinfo v WHERE v.passengerCapacity = :passengerCapacity"),
    @NamedQuery(name = "Vehicalinfo.findByLuggageCapacity", query = "SELECT v FROM Vehicalinfo v WHERE v.luggageCapacity = :luggageCapacity"),
    @NamedQuery(name = "Vehicalinfo.findByColor", query = "SELECT v FROM Vehicalinfo v WHERE v.color = :color"),
    @NamedQuery(name = "Vehicalinfo.findByStatus", query = "SELECT v FROM Vehicalinfo v WHERE v.status = :status"),
    @NamedQuery(name = "Vehicalinfo.findByCreateTime", query = "SELECT v FROM Vehicalinfo v WHERE v.createTime = :createTime"),
    @NamedQuery(name = "Vehicalinfo.findByUpdateTime", query = "SELECT v FROM Vehicalinfo v WHERE v.updateTime = :updateTime")})
public class Vehicalinfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "license_plate")
    private String licensePlate;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "passenger_capacity")
    private int passengerCapacity;
    @Basic(optional = false)
    @Column(name = "luggage_capacity")
    private int luggageCapacity;
    @Basic(optional = false)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @JoinColumn(name = "ownerid", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User ownerid;
    @JoinColumn(name = "created_by", referencedColumnName = "user_id")
    @ManyToOne
    private User createdBy;
    @JoinColumn(name = "updated_by", referencedColumnName = "user_id")
    @ManyToOne
    private User updatedBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicalId")
    private List<ProviderRideInfo> providerRideInfoList;

    public Vehicalinfo() {
    }

    public Vehicalinfo(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Vehicalinfo(String licensePlate, String type, int passengerCapacity, int luggageCapacity, String color, String status) {
        this.licensePlate = licensePlate;
        this.type = type;
        this.passengerCapacity = passengerCapacity;
        this.luggageCapacity = luggageCapacity;
        this.color = color;
        this.status = status;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getLuggageCapacity() {
        return luggageCapacity;
    }

    public void setLuggageCapacity(int luggageCapacity) {
        this.luggageCapacity = luggageCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public User getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(User ownerid) {
        this.ownerid = ownerid;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    @XmlTransient
    public List<ProviderRideInfo> getProviderRideInfoList() {
        return providerRideInfoList;
    }

    public void setProviderRideInfoList(List<ProviderRideInfo> providerRideInfoList) {
        this.providerRideInfoList = providerRideInfoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (licensePlate != null ? licensePlate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicalinfo)) {
            return false;
        }
        Vehicalinfo other = (Vehicalinfo) object;
        if ((this.licensePlate == null && other.licensePlate != null) || (this.licensePlate != null && !this.licensePlate.equals(other.licensePlate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.delta.rideshare.db.entity.Vehicalinfo[ licensePlate=" + licensePlate + " ]";
    }
    
}
