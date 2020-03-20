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
@Table(name = "rule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rule.findAll", query = "SELECT r FROM Rule r"),
    @NamedQuery(name = "Rule.findByRuleId", query = "SELECT r FROM Rule r WHERE r.ruleId = :ruleId"),
    @NamedQuery(name = "Rule.findByIsActive", query = "SELECT r FROM Rule r WHERE r.isActive = :isActive")})
public class Rule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rule_id")
    private Integer ruleId;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ruleId")
    private List<AdditionalUserRule> additionalUserRuleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ruleId")
    private List<RestrictedUserRule> restrictedUserRuleList;
    @JoinColumn(name = "module_permission_id", referencedColumnName = "module_permission_id")
    @ManyToOne(optional = false)
    private ModulePermission modulePermissionId;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false)
    private Role roleId;

    public Rule() {
    }

    public Rule(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public Rule(Integer ruleId, Character isActive) {
        this.ruleId = ruleId;
        this.isActive = isActive;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<AdditionalUserRule> getAdditionalUserRuleList() {
        return additionalUserRuleList;
    }

    public void setAdditionalUserRuleList(List<AdditionalUserRule> additionalUserRuleList) {
        this.additionalUserRuleList = additionalUserRuleList;
    }

    @XmlTransient
    public List<RestrictedUserRule> getRestrictedUserRuleList() {
        return restrictedUserRuleList;
    }

    public void setRestrictedUserRuleList(List<RestrictedUserRule> restrictedUserRuleList) {
        this.restrictedUserRuleList = restrictedUserRuleList;
    }

    public ModulePermission getModulePermissionId() {
        return modulePermissionId;
    }

    public void setModulePermissionId(ModulePermission modulePermissionId) {
        this.modulePermissionId = modulePermissionId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ruleId != null ? ruleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rule)) {
            return false;
        }
        Rule other = (Rule) object;
        if ((this.ruleId == null && other.ruleId != null) || (this.ruleId != null && !this.ruleId.equals(other.ruleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.Rule[ ruleId=" + ruleId + " ]";
    }
    
}
