/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mt.unmaze.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "budget_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BudgetMaster.findAll", query = "SELECT b FROM BudgetMaster b"),
    @NamedQuery(name = "BudgetMaster.findByBudgetMasterId", query = "SELECT b FROM BudgetMaster b WHERE b.budgetMasterId = :budgetMasterId"),
    @NamedQuery(name = "BudgetMaster.findByDate", query = "SELECT b FROM BudgetMaster b WHERE b.date = :date"),
    @NamedQuery(name = "BudgetMaster.findByAmount", query = "SELECT b FROM BudgetMaster b WHERE b.amount = :amount"),
    @NamedQuery(name = "BudgetMaster.findByCreatedAt", query = "SELECT b FROM BudgetMaster b WHERE b.createdAt = :createdAt"),
    @NamedQuery(name = "BudgetMaster.findByLastUpdatedAt", query = "SELECT b FROM BudgetMaster b WHERE b.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "BudgetMaster.findByIsActive", query = "SELECT b FROM BudgetMaster b WHERE b.isActive = :isActive"),
    @NamedQuery(name = "BudgetMaster.findByIsDeleted", query = "SELECT b FROM BudgetMaster b WHERE b.isDeleted = :isDeleted"),
    @NamedQuery(name = "BudgetMaster.findByIpAddress", query = "SELECT b FROM BudgetMaster b WHERE b.ipAddress = :ipAddress")})
public class BudgetMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "budget_master_id")
    private Integer budgetMasterId;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @Lob
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "last_updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedAt;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @Basic(optional = false)
    @Column(name = "is_deleted")
    private Character isDeleted;
    @Column(name = "ip_address")
    private String ipAddress;
    @JoinColumn(name = "account_master_id", referencedColumnName = "account_master_id")
    @ManyToOne
    private AccountMaster accountMasterId;
    @JoinColumn(name = "branch_master_id", referencedColumnName = "branch_master_id")
    @ManyToOne(optional = false)
    private BranchMaster branchMasterId;
    @JoinColumn(name = "project_master_id", referencedColumnName = "project_master_id")
    @ManyToOne
    private ProjectMaster projectMasterId;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;

    public BudgetMaster() {
    }

    public BudgetMaster(Integer budgetMasterId) {
        this.budgetMasterId = budgetMasterId;
    }

    public BudgetMaster(Integer budgetMasterId, Character isActive, Character isDeleted) {
        this.budgetMasterId = budgetMasterId;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
    }

    public Integer getBudgetMasterId() {
        return budgetMasterId;
    }

    public void setBudgetMasterId(Integer budgetMasterId) {
        this.budgetMasterId = budgetMasterId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    public Character getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Character isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public AccountMaster getAccountMasterId() {
        return accountMasterId;
    }

    public void setAccountMasterId(AccountMaster accountMasterId) {
        this.accountMasterId = accountMasterId;
    }

    public BranchMaster getBranchMasterId() {
        return branchMasterId;
    }

    public void setBranchMasterId(BranchMaster branchMasterId) {
        this.branchMasterId = branchMasterId;
    }

    public ProjectMaster getProjectMasterId() {
        return projectMasterId;
    }

    public void setProjectMasterId(ProjectMaster projectMasterId) {
        this.projectMasterId = projectMasterId;
    }

    public UserMaster getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserMaster createdBy) {
        this.createdBy = createdBy;
    }

    public UserMaster getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(UserMaster lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (budgetMasterId != null ? budgetMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BudgetMaster)) {
            return false;
        }
        BudgetMaster other = (BudgetMaster) object;
        if ((this.budgetMasterId == null && other.budgetMasterId != null) || (this.budgetMasterId != null && !this.budgetMasterId.equals(other.budgetMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.BudgetMaster[ budgetMasterId=" + budgetMasterId + " ]";
    }
    
}
