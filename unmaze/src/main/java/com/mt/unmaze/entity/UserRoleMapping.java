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
@Table(name = "user_role_mapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRoleMapping.findAll", query = "SELECT u FROM UserRoleMapping u"),
    @NamedQuery(name = "UserRoleMapping.findByUserRoleMappingId", query = "SELECT u FROM UserRoleMapping u WHERE u.userRoleMappingId = :userRoleMappingId"),
    @NamedQuery(name = "UserRoleMapping.findByIsActive", query = "SELECT u FROM UserRoleMapping u WHERE u.isActive = :isActive")})
public class UserRoleMapping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_role_mapping_id")
    private Integer userRoleMappingId;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false)
    private Role roleId;
    @JoinColumn(name = "user_master_id", referencedColumnName = "user_master_id")
    @ManyToOne(optional = false)
    private UserMaster userMasterId;

    public UserRoleMapping() {
    }

    public UserRoleMapping(Integer userRoleMappingId) {
        this.userRoleMappingId = userRoleMappingId;
    }

    public UserRoleMapping(Integer userRoleMappingId, Character isActive) {
        this.userRoleMappingId = userRoleMappingId;
        this.isActive = isActive;
    }

    public Integer getUserRoleMappingId() {
        return userRoleMappingId;
    }

    public void setUserRoleMappingId(Integer userRoleMappingId) {
        this.userRoleMappingId = userRoleMappingId;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
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
        hash += (userRoleMappingId != null ? userRoleMappingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRoleMapping)) {
            return false;
        }
        UserRoleMapping other = (UserRoleMapping) object;
        if ((this.userRoleMappingId == null && other.userRoleMappingId != null) || (this.userRoleMappingId != null && !this.userRoleMappingId.equals(other.userRoleMappingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.UserRoleMapping[ userRoleMappingId=" + userRoleMappingId + " ]";
    }
    
}
