/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mt.rideshare.db.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author 992325
 */
@Embeddable
public class RideInfoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "provider_ride_id")
    private int providerRideId;
    @Basic(optional = false)
    @Column(name = "consumer_id")
    private String consumerId;

    public RideInfoPK() {
    }

    public RideInfoPK(int providerRideId, String consumerId) {
        this.providerRideId = providerRideId;
        this.consumerId = consumerId;
    }

    public int getProviderRideId() {
        return providerRideId;
    }

    public void setProviderRideId(int providerRideId) {
        this.providerRideId = providerRideId;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) providerRideId;
        hash += (consumerId != null ? consumerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RideInfoPK)) {
            return false;
        }
        RideInfoPK other = (RideInfoPK) object;
        if (this.providerRideId != other.providerRideId) {
            return false;
        }
        if ((this.consumerId == null && other.consumerId != null) || (this.consumerId != null && !this.consumerId.equals(other.consumerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.delta.rideshare.db.entity.RideInfoPK[ providerRideId=" + providerRideId + ", consumerId=" + consumerId + " ]";
    }
    
}
