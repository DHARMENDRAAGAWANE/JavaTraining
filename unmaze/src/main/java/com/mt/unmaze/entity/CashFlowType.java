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
@Table(name = "cash_flow_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CashFlowType.findAll", query = "SELECT c FROM CashFlowType c"),
    @NamedQuery(name = "CashFlowType.findByCashFlowTypeId", query = "SELECT c FROM CashFlowType c WHERE c.cashFlowTypeId = :cashFlowTypeId"),
    @NamedQuery(name = "CashFlowType.findByCashFlowTypeName", query = "SELECT c FROM CashFlowType c WHERE c.cashFlowTypeName = :cashFlowTypeName"),
    @NamedQuery(name = "CashFlowType.findByIsActive", query = "SELECT c FROM CashFlowType c WHERE c.isActive = :isActive")})
public class CashFlowType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cash_flow_type_id")
    private Integer cashFlowTypeId;
    @Basic(optional = false)
    @Column(name = "cash_flow_type_name")
    private String cashFlowTypeName;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cashFlowTypeId")
    private List<AccountGroupMaster> accountGroupMasterList;

    public CashFlowType() {
    }

    public CashFlowType(Integer cashFlowTypeId) {
        this.cashFlowTypeId = cashFlowTypeId;
    }

    public CashFlowType(Integer cashFlowTypeId, String cashFlowTypeName, Character isActive) {
        this.cashFlowTypeId = cashFlowTypeId;
        this.cashFlowTypeName = cashFlowTypeName;
        this.isActive = isActive;
    }

    public Integer getCashFlowTypeId() {
        return cashFlowTypeId;
    }

    public void setCashFlowTypeId(Integer cashFlowTypeId) {
        this.cashFlowTypeId = cashFlowTypeId;
    }

    public String getCashFlowTypeName() {
        return cashFlowTypeName;
    }

    public void setCashFlowTypeName(String cashFlowTypeName) {
        this.cashFlowTypeName = cashFlowTypeName;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<AccountGroupMaster> getAccountGroupMasterList() {
        return accountGroupMasterList;
    }

    public void setAccountGroupMasterList(List<AccountGroupMaster> accountGroupMasterList) {
        this.accountGroupMasterList = accountGroupMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cashFlowTypeId != null ? cashFlowTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CashFlowType)) {
            return false;
        }
        CashFlowType other = (CashFlowType) object;
        if ((this.cashFlowTypeId == null && other.cashFlowTypeId != null) || (this.cashFlowTypeId != null && !this.cashFlowTypeId.equals(other.cashFlowTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.CashFlowType[ cashFlowTypeId=" + cashFlowTypeId + " ]";
    }
    
}
