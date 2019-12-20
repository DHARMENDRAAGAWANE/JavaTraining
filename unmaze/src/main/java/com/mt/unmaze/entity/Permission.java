/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mt.unmaze.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "permission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permission.findAll", query = "SELECT p FROM Permission p"),
    @NamedQuery(name = "Permission.findByPermissionId", query = "SELECT p FROM Permission p WHERE p.permissionId = :permissionId"),
    @NamedQuery(name = "Permission.findByPermissionName", query = "SELECT p FROM Permission p WHERE p.permissionName = :permissionName"),
    @NamedQuery(name = "Permission.findByIsActive", query = "SELECT p FROM Permission p WHERE p.isActive = :isActive")})
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "permission_id")
    private Integer permissionId;
    @Basic(optional = false)
    @Column(name = "permission_name")
    private String permissionName;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permissionId")
    private List<ModulePermission> modulePermissionList;

    public Permission() {
    }

    public Permission(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Permission(Integer permissionId, String permissionName, Character isActive) {
        this.permissionId = permissionId;
        this.permissionName = permissionName;
        this.isActive = isActive;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<ModulePermission> getModulePermissionList() {
        return modulePermissionList;
    }

    public void setModulePermissionList(List<ModulePermission> modulePermissionList) {
        this.modulePermissionList = modulePermissionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permissionId != null ? permissionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permission)) {
            return false;
        }
        Permission other = (Permission) object;
        if ((this.permissionId == null && other.permissionId != null) || (this.permissionId != null && !this.permissionId.equals(other.permissionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.Permission[ permissionId=" + permissionId + " ]";
    }
    
}
