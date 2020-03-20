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
@Table(name = "restricted_user_rule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RestrictedUserRule.findAll", query = "SELECT r FROM RestrictedUserRule r"),
    @NamedQuery(name = "RestrictedUserRule.findByRestrictedUserRuleId", query = "SELECT r FROM RestrictedUserRule r WHERE r.restrictedUserRuleId = :restrictedUserRuleId"),
    @NamedQuery(name = "RestrictedUserRule.findByIsActive", query = "SELECT r FROM RestrictedUserRule r WHERE r.isActive = :isActive")})
public class RestrictedUserRule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "restricted_user_rule_id")
    private Integer restrictedUserRuleId;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @JoinColumn(name = "rule_id", referencedColumnName = "rule_id")
    @ManyToOne(optional = false)
    private Rule ruleId;
    @JoinColumn(name = "user_master_id", referencedColumnName = "user_master_id")
    @ManyToOne(optional = false)
    private UserMaster userMasterId;

    public RestrictedUserRule() {
    }

    public RestrictedUserRule(Integer restrictedUserRuleId) {
        this.restrictedUserRuleId = restrictedUserRuleId;
    }

    public RestrictedUserRule(Integer restrictedUserRuleId, Character isActive) {
        this.restrictedUserRuleId = restrictedUserRuleId;
        this.isActive = isActive;
    }

    public Integer getRestrictedUserRuleId() {
        return restrictedUserRuleId;
    }

    public void setRestrictedUserRuleId(Integer restrictedUserRuleId) {
        this.restrictedUserRuleId = restrictedUserRuleId;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    public Rule getRuleId() {
        return ruleId;
    }

    public void setRuleId(Rule ruleId) {
        this.ruleId = ruleId;
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
        hash += (restrictedUserRuleId != null ? restrictedUserRuleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RestrictedUserRule)) {
            return false;
        }
        RestrictedUserRule other = (RestrictedUserRule) object;
        if ((this.restrictedUserRuleId == null && other.restrictedUserRuleId != null) || (this.restrictedUserRuleId != null && !this.restrictedUserRuleId.equals(other.restrictedUserRuleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.RestrictedUserRule[ restrictedUserRuleId=" + restrictedUserRuleId + " ]";
    }
    
}
