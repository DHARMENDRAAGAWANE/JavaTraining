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
@Table(name = "user_branch_mapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserBranchMapping.findAll", query = "SELECT u FROM UserBranchMapping u"),
    @NamedQuery(name = "UserBranchMapping.findByUserBranchMappingId", query = "SELECT u FROM UserBranchMapping u WHERE u.userBranchMappingId = :userBranchMappingId"),
    @NamedQuery(name = "UserBranchMapping.findByIsActive", query = "SELECT u FROM UserBranchMapping u WHERE u.isActive = :isActive")})
public class UserBranchMapping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_branch_mapping_id")
    private Integer userBranchMappingId;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @JoinColumn(name = "branch_master_id", referencedColumnName = "branch_master_id")
    @ManyToOne(optional = false)
    private BranchMaster branchMasterId;
    @JoinColumn(name = "user_master_id", referencedColumnName = "user_master_id")
    @ManyToOne(optional = false)
    private UserMaster userMasterId;

    public UserBranchMapping() {
    }

    public UserBranchMapping(Integer userBranchMappingId) {
        this.userBranchMappingId = userBranchMappingId;
    }

    public UserBranchMapping(Integer userBranchMappingId, Character isActive) {
        this.userBranchMappingId = userBranchMappingId;
        this.isActive = isActive;
    }

    public Integer getUserBranchMappingId() {
        return userBranchMappingId;
    }

    public void setUserBranchMappingId(Integer userBranchMappingId) {
        this.userBranchMappingId = userBranchMappingId;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    public BranchMaster getBranchMasterId() {
        return branchMasterId;
    }

    public void setBranchMasterId(BranchMaster branchMasterId) {
        this.branchMasterId = branchMasterId;
    }

    public UserMaster getUserMasterId() {
        return userMasterId;
    }

    public void setUserMasterId(UserMaster userMasterId) {
        this.userMasterId = userMasterId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userBranchMappingId != null ? userBranchMappingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserBranchMapping)) {
            return false;
        }
        UserBranchMapping other = (UserBranchMapping) object;
        if ((this.userBranchMappingId == null && other.userBranchMappingId != null) || (this.userBranchMappingId != null && !this.userBranchMappingId.equals(other.userBranchMappingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.UserBranchMapping[ userBranchMappingId=" + userBranchMappingId + " ]";
    }
    
}
