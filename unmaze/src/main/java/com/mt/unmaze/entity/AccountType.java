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
@Table(name = "account_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountType.findAll", query = "SELECT a FROM AccountType a"),
    @NamedQuery(name = "AccountType.findByAccountTypeId", query = "SELECT a FROM AccountType a WHERE a.accountTypeId = :accountTypeId"),
    @NamedQuery(name = "AccountType.findByAccountTypeName", query = "SELECT a FROM AccountType a WHERE a.accountTypeName = :accountTypeName"),
    @NamedQuery(name = "AccountType.findByIsActive", query = "SELECT a FROM AccountType a WHERE a.isActive = :isActive")})
public class AccountType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "account_type_id")
    private Integer accountTypeId;
    @Basic(optional = false)
    @Column(name = "account_type_name")
    private String accountTypeName;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountTypeId")
    private List<AccountGroupMaster> accountGroupMasterList;

    public AccountType() {
    }

    public AccountType(Integer accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public AccountType(Integer accountTypeId, String accountTypeName, Character isActive) {
        this.accountTypeId = accountTypeId;
        this.accountTypeName = accountTypeName;
        this.isActive = isActive;
    }

    public Integer getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Integer accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
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
        hash += (accountTypeId != null ? accountTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountType)) {
            return false;
        }
        AccountType other = (AccountType) object;
        if ((this.accountTypeId == null && other.accountTypeId != null) || (this.accountTypeId != null && !this.accountTypeId.equals(other.accountTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.AccountType[ accountTypeId=" + accountTypeId + " ]";
    }
    
}
