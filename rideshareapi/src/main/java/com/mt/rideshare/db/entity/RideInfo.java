/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mt.rideshare.db.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 992325
 */
@Entity
@Table(name = "ride_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RideInfo.findAll", query = "SELECT r FROM RideInfo r"),
    @NamedQuery(name = "RideInfo.findByProviderRideId", query = "SELECT r FROM RideInfo r WHERE r.rideInfoPK.providerRideId = :providerRideId"),
    @NamedQuery(name = "RideInfo.findByConsumerId", query = "SELECT r FROM RideInfo r WHERE r.rideInfoPK.consumerId = :consumerId"),
    @NamedQuery(name = "RideInfo.findByStatus", query = "SELECT r FROM RideInfo r WHERE r.status = :status"),
    @NamedQuery(name = "RideInfo.findByDistance", query = "SELECT r FROM RideInfo r WHERE r.distance = :distance"),
    @NamedQuery(name = "RideInfo.findByCreateTime", query = "SELECT r FROM RideInfo r WHERE r.createTime = :createTime"),
    @NamedQuery(name = "RideInfo.findByComments", query = "SELECT r FROM RideInfo r WHERE r.comments = :comments"),
    @NamedQuery(name = "RideInfo.findByUpdatedTime", query = "SELECT r FROM RideInfo r WHERE r.updatedTime = :updatedTime")})
public class RideInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RideInfoPK rideInfoPK;
    @Column(name = "status")
    private String status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "distance")
    private Double distance;
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "comments")
    private String comments;
    @Column(name = "updated_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;
    @JoinColumn(name = "consumer_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "provider_ride_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProviderRideInfo providerRideInfo;
    @JoinColumn(name = "created_by", referencedColumnName = "user_id")
    @ManyToOne
    private User createdBy;
    @JoinColumn(name = "updated_by", referencedColumnName = "user_id")
    @ManyToOne
    private User updatedBy;

    public RideInfo() {
    }

    public RideInfo(RideInfoPK rideInfoPK) {
        this.rideInfoPK = rideInfoPK;
    }

    public RideInfo(int providerRideId, String consumerId) {
        this.rideInfoPK = new RideInfoPK(providerRideId, consumerId);
    }

    public RideInfoPK getRideInfoPK() {
        return rideInfoPK;
    }

    public void setRideInfoPK(RideInfoPK rideInfoPK) {
        this.rideInfoPK = rideInfoPK;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ProviderRideInfo getProviderRideInfo() {
        return providerRideInfo;
    }

    public void setProviderRideInfo(ProviderRideInfo providerRideInfo) {
        this.providerRideInfo = providerRideInfo;
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
        hash += (rideInfoPK != null ? rideInfoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RideInfo)) {
            return false;
        }
        RideInfo other = (RideInfo) object;
        if ((this.rideInfoPK == null && other.rideInfoPK != null) || (this.rideInfoPK != null && !this.rideInfoPK.equals(other.rideInfoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.delta.rideshare.db.entity.RideInfo[ rideInfoPK=" + rideInfoPK + " ]";
    }
    
}
