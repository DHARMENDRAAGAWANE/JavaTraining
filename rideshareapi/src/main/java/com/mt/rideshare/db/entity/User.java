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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByPhoneNo", query = "SELECT u FROM User u WHERE u.phoneNo = :phoneNo"),
    @NamedQuery(name = "User.findByCreateTime", query = "SELECT u FROM User u WHERE u.createTime = :createTime"),
    @NamedQuery(name = "User.findByUserType", query = "SELECT u FROM User u WHERE u.userType = :userType"),
    @NamedQuery(name = "User.findByModeOfContact", query = "SELECT u FROM User u WHERE u.modeOfContact = :modeOfContact"),
    @NamedQuery(name = "User.findByCreatedBy", query = "SELECT u FROM User u WHERE u.createdBy = :createdBy"),
    @NamedQuery(name = "User.findByUpdatedBy", query = "SELECT u FROM User u WHERE u.updatedBy = :updatedBy"),
    @NamedQuery(name = "User.findByUpdateTime", query = "SELECT u FROM User u WHERE u.updateTime = :updateTime")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "user_id")
    private String userId;
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "phone_no")
    private String phoneNo;
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "user_type")
    private String userType;
    @Column(name = "mode_of_contact")
    private String modeOfContact;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerid")
    private List<Vehicalinfo> vehicalinfoList;
    @OneToMany(mappedBy = "createdBy")
    private List<Vehicalinfo> vehicalinfoList1;
    @OneToMany(mappedBy = "updatedBy")
    private List<Vehicalinfo> vehicalinfoList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<RideInfo> rideInfoList;
    @OneToMany(mappedBy = "createdBy")
    private List<RideInfo> rideInfoList1;
    @OneToMany(mappedBy = "updatedBy")
    private List<RideInfo> rideInfoList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "providerId")
    private List<ProviderRideInfo> providerRideInfoList;
    @OneToMany(mappedBy = "createdBy")
    private List<ProviderRideInfo> providerRideInfoList1;
    @OneToMany(mappedBy = "updatedBy")
    private List<ProviderRideInfo> providerRideInfoList2;

    public User() {
    }

    public User(String userId) {
        this.userId = userId;
    }

    public User(String userId, String phoneNo) {
        this.userId = userId;
        this.phoneNo = phoneNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getModeOfContact() {
        return modeOfContact;
    }

    public void setModeOfContact(String modeOfContact) {
        this.modeOfContact = modeOfContact;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @XmlTransient
    public List<Vehicalinfo> getVehicalinfoList() {
        return vehicalinfoList;
    }

    public void setVehicalinfoList(List<Vehicalinfo> vehicalinfoList) {
        this.vehicalinfoList = vehicalinfoList;
    }

    @XmlTransient
    public List<Vehicalinfo> getVehicalinfoList1() {
        return vehicalinfoList1;
    }

    public void setVehicalinfoList1(List<Vehicalinfo> vehicalinfoList1) {
        this.vehicalinfoList1 = vehicalinfoList1;
    }

    @XmlTransient
    public List<Vehicalinfo> getVehicalinfoList2() {
        return vehicalinfoList2;
    }

    public void setVehicalinfoList2(List<Vehicalinfo> vehicalinfoList2) {
        this.vehicalinfoList2 = vehicalinfoList2;
    }

    @XmlTransient
    public List<RideInfo> getRideInfoList() {
        return rideInfoList;
    }

    public void setRideInfoList(List<RideInfo> rideInfoList) {
        this.rideInfoList = rideInfoList;
    }

    @XmlTransient
    public List<RideInfo> getRideInfoList1() {
        return rideInfoList1;
    }

    public void setRideInfoList1(List<RideInfo> rideInfoList1) {
        this.rideInfoList1 = rideInfoList1;
    }

    @XmlTransient
    public List<RideInfo> getRideInfoList2() {
        return rideInfoList2;
    }

    public void setRideInfoList2(List<RideInfo> rideInfoList2) {
        this.rideInfoList2 = rideInfoList2;
    }

    @XmlTransient
    public List<ProviderRideInfo> getProviderRideInfoList() {
        return providerRideInfoList;
    }

    public void setProviderRideInfoList(List<ProviderRideInfo> providerRideInfoList) {
        this.providerRideInfoList = providerRideInfoList;
    }

    @XmlTransient
    public List<ProviderRideInfo> getProviderRideInfoList1() {
        return providerRideInfoList1;
    }

    public void setProviderRideInfoList1(List<ProviderRideInfo> providerRideInfoList1) {
        this.providerRideInfoList1 = providerRideInfoList1;
    }

    @XmlTransient
    public List<ProviderRideInfo> getProviderRideInfoList2() {
        return providerRideInfoList2;
    }

    public void setProviderRideInfoList2(List<ProviderRideInfo> providerRideInfoList2) {
        this.providerRideInfoList2 = providerRideInfoList2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.delta.rideshare.db.entity.User[ userId=" + userId + " ]";
    }
    
}
