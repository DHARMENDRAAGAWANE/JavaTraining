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
@Table(name = "additional_user_rule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdditionalUserRule.findAll", query = "SELECT a FROM AdditionalUserRule a"),
    @NamedQuery(name = "AdditionalUserRule.findByAdditionalUserRuleId", query = "SELECT a FROM AdditionalUserRule a WHERE a.additionalUserRuleId = :additionalUserRuleId"),
    @NamedQuery(name = "AdditionalUserRule.findByIsActive", query = "SELECT a FROM AdditionalUserRule a WHERE a.isActive = :isActive")})
public class AdditionalUserRule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "additional_user_rule_id")
    private Integer additionalUserRuleId;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @JoinColumn(name = "rule_id", referencedColumnName = "rule_id")
    @ManyToOne(optional = false)
    private Rule ruleId;
    @JoinColumn(name = "user_master_id", referencedColumnName = "user_master_id")
    @ManyToOne(optional = false)
    private UserMaster userMasterId;

    public AdditionalUserRule() {
    }

    public AdditionalUserRule(Integer additionalUserRuleId) {
        this.additionalUserRuleId = additionalUserRuleId;
    }

    public AdditionalUserRule(Integer additionalUserRuleId, Character isActive) {
        this.additionalUserRuleId = additionalUserRuleId;
        this.isActive = isActive;
    }

    public Integer getAdditionalUserRuleId() {
        return additionalUserRuleId;
    }

    public void setAdditionalUserRuleId(Integer additionalUserRuleId) {
        this.additionalUserRuleId = additionalUserRuleId;
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
        hash += (additionalUserRuleId != null ? additionalUserRuleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdditionalUserRule)) {
            return false;
        }
        AdditionalUserRule other = (AdditionalUserRule) object;
        if ((this.additionalUserRuleId == null && other.additionalUserRuleId != null) || (this.additionalUserRuleId != null && !this.additionalUserRuleId.equals(other.additionalUserRuleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.AdditionalUserRule[ additionalUserRuleId=" + additionalUserRuleId + " ]";
    }
    
}
