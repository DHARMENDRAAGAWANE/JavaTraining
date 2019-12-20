/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mt.unmaze.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author user
 */
@Entity
@Table(name = "vendor_user_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VendorUserMaster.findAll", query = "SELECT v FROM VendorUserMaster v"),
    @NamedQuery(name = "VendorUserMaster.findByVendorUserMasterId", query = "SELECT v FROM VendorUserMaster v WHERE v.vendorUserMasterId = :vendorUserMasterId"),
    @NamedQuery(name = "VendorUserMaster.findByFirstName", query = "SELECT v FROM VendorUserMaster v WHERE v.firstName = :firstName"),
    @NamedQuery(name = "VendorUserMaster.findByLastName", query = "SELECT v FROM VendorUserMaster v WHERE v.lastName = :lastName"),
    @NamedQuery(name = "VendorUserMaster.findByContactNumber", query = "SELECT v FROM VendorUserMaster v WHERE v.contactNumber = :contactNumber"),
    @NamedQuery(name = "VendorUserMaster.findByEmail", query = "SELECT v FROM VendorUserMaster v WHERE v.email = :email"),
    @NamedQuery(name = "VendorUserMaster.findByPassword", query = "SELECT v FROM VendorUserMaster v WHERE v.password = :password"),
    @NamedQuery(name = "VendorUserMaster.findByLastLoginDate", query = "SELECT v FROM VendorUserMaster v WHERE v.lastLoginDate = :lastLoginDate"),
    @NamedQuery(name = "VendorUserMaster.findByIsActive", query = "SELECT v FROM VendorUserMaster v WHERE v.isActive = :isActive"),
    @NamedQuery(name = "VendorUserMaster.findByIsDeleted", query = "SELECT v FROM VendorUserMaster v WHERE v.isDeleted = :isDeleted")})
public class VendorUserMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vendor_user_master_id")
    private Integer vendorUserMasterId;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "contact_number")
    private BigInteger contactNumber;
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Lob
    @Column(name = "auth_token")
    private String authToken;
    @Column(name = "last_login_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginDate;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @Basic(optional = false)
    @Column(name = "is_deleted")
    private Character isDeleted;
    @OneToMany(mappedBy = "vendorUserMasterId")
    private List<VendorMaster> vendorMasterList;

    public VendorUserMaster() {
    }

    public VendorUserMaster(Integer vendorUserMasterId) {
        this.vendorUserMasterId = vendorUserMasterId;
    }

    public VendorUserMaster(Integer vendorUserMasterId, String firstName, String password, Character isActive, Character isDeleted) {
        this.vendorUserMasterId = vendorUserMasterId;
        this.firstName = firstName;
        this.password = password;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
    }

    public Integer getVendorUserMasterId() {
        return vendorUserMasterId;
    }

    public void setVendorUserMasterId(Integer vendorUserMasterId) {
        this.vendorUserMasterId = vendorUserMasterId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigInteger getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(BigInteger contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    public Character getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Character isDeleted) {
        this.isDeleted = isDeleted;
    }

    @XmlTransient
    public List<VendorMaster> getVendorMasterList() {
        return vendorMasterList;
    }

    public void setVendorMasterList(List<VendorMaster> vendorMasterList) {
        this.vendorMasterList = vendorMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendorUserMasterId != null ? vendorUserMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VendorUserMaster)) {
            return false;
        }
        VendorUserMaster other = (VendorUserMaster) object;
        if ((this.vendorUserMasterId == null && other.vendorUserMasterId != null) || (this.vendorUserMasterId != null && !this.vendorUserMasterId.equals(other.vendorUserMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.VendorUserMaster[ vendorUserMasterId=" + vendorUserMasterId + " ]";
    }
    
}
