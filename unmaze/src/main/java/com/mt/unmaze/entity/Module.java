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
@Table(name = "module")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Module.findAll", query = "SELECT m FROM Module m"),
    @NamedQuery(name = "Module.findByModuleId", query = "SELECT m FROM Module m WHERE m.moduleId = :moduleId"),
    @NamedQuery(name = "Module.findByModuleName", query = "SELECT m FROM Module m WHERE m.moduleName = :moduleName"),
    @NamedQuery(name = "Module.findByModuleLevel", query = "SELECT m FROM Module m WHERE m.moduleLevel = :moduleLevel"),
    @NamedQuery(name = "Module.findByIsActive", query = "SELECT m FROM Module m WHERE m.isActive = :isActive")})
public class Module implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "module_id")
    private Integer moduleId;
    @Basic(optional = false)
    @Column(name = "module_name")
    private String moduleName;
    @Basic(optional = false)
    @Column(name = "module_level")
    private int moduleLevel;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @OneToMany(mappedBy = "parentModuleId")
    private List<Module> moduleList;
    @JoinColumn(name = "parent_module_id", referencedColumnName = "module_id")
    @ManyToOne
    private Module parentModuleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moduleId")
    private List<ModulePermission> modulePermissionList;

    public Module() {
    }

    public Module(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Module(Integer moduleId, String moduleName, int moduleLevel, Character isActive) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.moduleLevel = moduleLevel;
        this.isActive = isActive;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getModuleLevel() {
        return moduleLevel;
    }

    public void setModuleLevel(int moduleLevel) {
        this.moduleLevel = moduleLevel;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<Module> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    public Module getParentModuleId() {
        return parentModuleId;
    }

    public void setParentModuleId(Module parentModuleId) {
        this.parentModuleId = parentModuleId;
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
        hash += (moduleId != null ? moduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Module)) {
            return false;
        }
        Module other = (Module) object;
        if ((this.moduleId == null && other.moduleId != null) || (this.moduleId != null && !this.moduleId.equals(other.moduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.Module[ moduleId=" + moduleId + " ]";
    }
    
}
