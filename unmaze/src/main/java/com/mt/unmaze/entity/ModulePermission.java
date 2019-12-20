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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "module_permission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModulePermission.findAll", query = "SELECT m FROM ModulePermission m"),
    @NamedQuery(name = "ModulePermission.findByModulePermissionId", query = "SELECT m FROM ModulePermission m WHERE m.modulePermissionId = :modulePermissionId"),
    @NamedQuery(name = "ModulePermission.findByIsActive", query = "SELECT m FROM ModulePermission m WHERE m.isActive = :isActive")})
public class ModulePermission implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "module_permission_id")
    private Integer modulePermissionId;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @JoinColumn(name = "module_id", referencedColumnName = "module_id")
    @ManyToOne(optional = false)
    private Module moduleId;
    @JoinColumn(name = "permission_id", referencedColumnName = "permission_id")
    @ManyToOne(optional = false)
    private Permission permissionId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulePermissionId")
    private List<Rule> ruleList;

    public ModulePermission() {
    }

    public ModulePermission(Integer modulePermissionId) {
        this.modulePermissionId = modulePermissionId;
    }

    public ModulePermission(Integer modulePermissionId, Character isActive) {
        this.modulePermissionId = modulePermissionId;
        this.isActive = isActive;
    }

    public Integer getModulePermissionId() {
        return modulePermissionId;
    }

    public void setModulePermissionId(Integer modulePermissionId) {
        this.modulePermissionId = modulePermissionId;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    public Module getModuleId() {
        return moduleId;
    }

    public void setModuleId(Module moduleId) {
        this.moduleId = moduleId;
    }

    public Permission getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Permission permissionId) {
        this.permissionId = permissionId;
    }

    @XmlTransient
    public List<Rule> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<Rule> ruleList) {
        this.ruleList = ruleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modulePermissionId != null ? modulePermissionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModulePermission)) {
            return false;
        }
        ModulePermission other = (ModulePermission) object;
        if ((this.modulePermissionId == null && other.modulePermissionId != null) || (this.modulePermissionId != null && !this.modulePermissionId.equals(other.modulePermissionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.ModulePermission[ modulePermissionId=" + modulePermissionId + " ]";
    }
    
}
