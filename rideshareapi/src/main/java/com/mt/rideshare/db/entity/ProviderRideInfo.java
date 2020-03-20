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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "provider_ride_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProviderRideInfo.findAll", query = "SELECT p FROM ProviderRideInfo p"),
    @NamedQuery(name = "ProviderRideInfo.findById", query = "SELECT p FROM ProviderRideInfo p WHERE p.id = :id"),
    @NamedQuery(name = "ProviderRideInfo.findByTripTime", query = "SELECT p FROM ProviderRideInfo p WHERE p.tripTime = :tripTime"),
    @NamedQuery(name = "ProviderRideInfo.findByFromLoc", query = "SELECT p FROM ProviderRideInfo p WHERE p.fromLoc = :fromLoc"),
    @NamedQuery(name = "ProviderRideInfo.findByToLoc", query = "SELECT p FROM ProviderRideInfo p WHERE p.toLoc = :toLoc"),
    @NamedQuery(name = "ProviderRideInfo.findByFromPickupPoint", query = "SELECT p FROM ProviderRideInfo p WHERE p.fromPickupPoint = :fromPickupPoint"),
    @NamedQuery(name = "ProviderRideInfo.findByToPickupPoint", query = "SELECT p FROM ProviderRideInfo p WHERE p.toPickupPoint = :toPickupPoint"),
    @NamedQuery(name = "ProviderRideInfo.findByTripType", query = "SELECT p FROM ProviderRideInfo p WHERE p.tripType = :tripType"),
    @NamedQuery(name = "ProviderRideInfo.findByCreationTime", query = "SELECT p FROM ProviderRideInfo p WHERE p.creationTime = :creationTime"),
    @NamedQuery(name = "ProviderRideInfo.findByUpdateTime", query = "SELECT p FROM ProviderRideInfo p WHERE p.updateTime = :updateTime"),
    @NamedQuery(name = "ProviderRideInfo.findByAvaialbleSeats", query = "SELECT p FROM ProviderRideInfo p WHERE p.avaialbleSeats = :avaialbleSeats"),
    @NamedQuery(name = "ProviderRideInfo.findByAvailaleLuggageSpace", query = "SELECT p FROM ProviderRideInfo p WHERE p.availaleLuggageSpace = :availaleLuggageSpace"),
    @NamedQuery(name = "ProviderRideInfo.findByTripStatus", query = "SELECT p FROM ProviderRideInfo p WHERE p.tripStatus = :tripStatus"),
    @NamedQuery(name = "ProviderRideInfo.findByTripComments", query = "SELECT p FROM ProviderRideInfo p WHERE p.tripComments = :tripComments")})
public class ProviderRideInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "trip_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tripTime;
    @Column(name = "from_loc")
    private String fromLoc;
    @Column(name = "to_loc")
    private String toLoc;
    @Column(name = "from_pickup_point")
    private String fromPickupPoint;
    @Column(name = "to_pickup_point")
    private String toPickupPoint;
    @Column(name = "trip_type")
    private String tripType;
    @Column(name = "creation_time")
    private String creationTime;
    @Column(name = "update_time")
    private String updateTime;
    @Column(name = "avaialble_seats")
    private Integer avaialbleSeats;
    @Column(name = "availale_luggage_space")
    private Integer availaleLuggageSpace;
    @Column(name = "trip_status")
    private String tripStatus;
    @Column(name = "trip_comments")
    private String tripComments;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "providerRideInfo")
    private List<RideInfo> rideInfoList;
    @JoinColumn(name = "vehical_id", referencedColumnName = "license_plate")
    @ManyToOne(optional = false)
    private Vehicalinfo vehicalId;
    @JoinColumn(name = "provider_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User providerId;
    @JoinColumn(name = "created_by", referencedColumnName = "user_id")
    @ManyToOne
    private User createdBy;
    @JoinColumn(name = "updated_by", referencedColumnName = "user_id")
    @ManyToOne
    private User updatedBy;

    public ProviderRideInfo() {
    }

    public ProviderRideInfo(Integer id) {
        this.id = id;
    }

    public ProviderRideInfo(Integer id, Date tripTime) {
        this.id = id;
        this.tripTime = tripTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTripTime() {
        return tripTime;
    }

    public void setTripTime(Date tripTime) {
        this.tripTime = tripTime;
    }

    public String getFromLoc() {
        return fromLoc;
    }

    public void setFromLoc(String fromLoc) {
        this.fromLoc = fromLoc;
    }

    public String getToLoc() {
        return toLoc;
    }

    public void setToLoc(String toLoc) {
        this.toLoc = toLoc;
    }

    public String getFromPickupPoint() {
        return fromPickupPoint;
    }

    public void setFromPickupPoint(String fromPickupPoint) {
        this.fromPickupPoint = fromPickupPoint;
    }

    public String getToPickupPoint() {
        return toPickupPoint;
    }

    public void setToPickupPoint(String toPickupPoint) {
        this.toPickupPoint = toPickupPoint;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getAvaialbleSeats() {
        return avaialbleSeats;
    }

    public void setAvaialbleSeats(Integer avaialbleSeats) {
        this.avaialbleSeats = avaialbleSeats;
    }

    public Integer getAvailaleLuggageSpace() {
        return availaleLuggageSpace;
    }

    public void setAvailaleLuggageSpace(Integer availaleLuggageSpace) {
        this.availaleLuggageSpace = availaleLuggageSpace;
    }

    public String getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(String tripStatus) {
        this.tripStatus = tripStatus;
    }

    public String getTripComments() {
        return tripComments;
    }

    public void setTripComments(String tripComments) {
        this.tripComments = tripComments;
    }

    @XmlTransient
    public List<RideInfo> getRideInfoList() {
        return rideInfoList;
    }

    public void setRideInfoList(List<RideInfo> rideInfoList) {
        this.rideInfoList = rideInfoList;
    }

    public Vehicalinfo getVehicalId() {
        return vehicalId;
    }

    public void setVehicalId(Vehicalinfo vehicalId) {
        this.vehicalId = vehicalId;
    }

    public User getProviderId() {
        return providerId;
    }

    public void setProviderId(User providerId) {
        this.providerId = providerId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProviderRideInfo)) {
            return false;
        }
        ProviderRideInfo other = (ProviderRideInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.delta.rideshare.db.entity.ProviderRideInfo[ id=" + id + " ]";
    }
    
}
