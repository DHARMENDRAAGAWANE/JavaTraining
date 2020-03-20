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
@Table(name = "account_group_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountGroupMaster.findAll", query = "SELECT a FROM AccountGroupMaster a"),
    @NamedQuery(name = "AccountGroupMaster.findByAccountGroupMasterId", query = "SELECT a FROM AccountGroupMaster a WHERE a.accountGroupMasterId = :accountGroupMasterId"),
    @NamedQuery(name = "AccountGroupMaster.findByAccountGroupMasterName", query = "SELECT a FROM AccountGroupMaster a WHERE a.accountGroupMasterName = :accountGroupMasterName"),
    @NamedQuery(name = "AccountGroupMaster.findByIsActive", query = "SELECT a FROM AccountGroupMaster a WHERE a.isActive = :isActive")})
public class AccountGroupMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "account_group_master_id")
    private Integer accountGroupMasterId;
    @Basic(optional = false)
    @Column(name = "account_group_master_name")
    private String accountGroupMasterName;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountGroupMasterId")
    private List<AccountMaster> accountMasterList;
    @JoinColumn(name = "account_type_id", referencedColumnName = "account_type_id")
    @ManyToOne(optional = false)
    private AccountType accountTypeId;
    @JoinColumn(name = "cash_flow_type_id", referencedColumnName = "cash_flow_type_id")
    @ManyToOne(optional = false)
    private CashFlowType cashFlowTypeId;
    @JoinColumn(name = "display_item_id", referencedColumnName = "display_item_id")
    @ManyToOne(optional = false)
    private DisplayItem displayItemId;

    public AccountGroupMaster() {
    }

    public AccountGroupMaster(Integer accountGroupMasterId) {
        this.accountGroupMasterId = accountGroupMasterId;
    }

    public AccountGroupMaster(Integer accountGroupMasterId, String accountGroupMasterName, Character isActive) {
        this.accountGroupMasterId = accountGroupMasterId;
        this.accountGroupMasterName = accountGroupMasterName;
        this.isActive = isActive;
    }

    public Integer getAccountGroupMasterId() {
        return accountGroupMasterId;
    }

    public void setAccountGroupMasterId(Integer accountGroupMasterId) {
        this.accountGroupMasterId = accountGroupMasterId;
    }

    public String getAccountGroupMasterName() {
        return accountGroupMasterName;
    }

    public void setAccountGroupMasterName(String accountGroupMasterName) {
        this.accountGroupMasterName = accountGroupMasterName;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<AccountMaster> getAccountMasterList() {
        return accountMasterList;
    }

    public void setAccountMasterList(List<AccountMaster> accountMasterList) {
        this.accountMasterList = accountMasterList;
    }

    public AccountType getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(AccountType accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public CashFlowType getCashFlowTypeId() {
        return cashFlowTypeId;
    }

    public void setCashFlowTypeId(CashFlowType cashFlowTypeId) {
        this.cashFlowTypeId = cashFlowTypeId;
    }

    public DisplayItem getDisplayItemId() {
        return displayItemId;
    }

    public void setDisplayItemId(DisplayItem displayItemId) {
        this.displayItemId = displayItemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountGroupMasterId != null ? accountGroupMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountGroupMaster)) {
            return false;
        }
        AccountGroupMaster other = (AccountGroupMaster) object;
        if ((this.accountGroupMasterId == null && other.accountGroupMasterId != null) || (this.accountGroupMasterId != null && !this.accountGroupMasterId.equals(other.accountGroupMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.AccountGroupMaster[ accountGroupMasterId=" + accountGroupMasterId + " ]";
    }
    
}
