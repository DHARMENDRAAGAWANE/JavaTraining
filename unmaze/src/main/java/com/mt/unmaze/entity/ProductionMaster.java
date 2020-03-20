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
@Table(name = "production_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductionMaster.findAll", query = "SELECT p FROM ProductionMaster p"),
    @NamedQuery(name = "ProductionMaster.findByProductionMasterId", query = "SELECT p FROM ProductionMaster p WHERE p.productionMasterId = :productionMasterId"),
    @NamedQuery(name = "ProductionMaster.findByDate", query = "SELECT p FROM ProductionMaster p WHERE p.date = :date"),
    @NamedQuery(name = "ProductionMaster.findByProductionMasterNo", query = "SELECT p FROM ProductionMaster p WHERE p.productionMasterNo = :productionMasterNo"),
    @NamedQuery(name = "ProductionMaster.findByProductionStatus", query = "SELECT p FROM ProductionMaster p WHERE p.productionStatus = :productionStatus"),
    @NamedQuery(name = "ProductionMaster.findByProductionActions", query = "SELECT p FROM ProductionMaster p WHERE p.productionActions = :productionActions"),
    @NamedQuery(name = "ProductionMaster.findByCreatedBy", query = "SELECT p FROM ProductionMaster p WHERE p.createdBy = :createdBy"),
    @NamedQuery(name = "ProductionMaster.findByLastUpdatedBy", query = "SELECT p FROM ProductionMaster p WHERE p.lastUpdatedBy = :lastUpdatedBy"),
    @NamedQuery(name = "ProductionMaster.findByCreatedAt", query = "SELECT p FROM ProductionMaster p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "ProductionMaster.findByLastUpdatedAt", query = "SELECT p FROM ProductionMaster p WHERE p.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "ProductionMaster.findByIsActive", query = "SELECT p FROM ProductionMaster p WHERE p.isActive = :isActive"),
    @NamedQuery(name = "ProductionMaster.findByIpAddress", query = "SELECT p FROM ProductionMaster p WHERE p.ipAddress = :ipAddress")})
public class ProductionMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "production_master_id")
    private Integer productionMasterId;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "production_master_no")
    private String productionMasterNo;
    @Column(name = "production_status")
    private String productionStatus;
    @Basic(optional = false)
    @Column(name = "production_actions")
    private String productionActions;
    @Basic(optional = false)
    @Column(name = "created_by")
    private int createdBy;
    @Basic(optional = false)
    @Column(name = "last_updated_by")
    private int lastUpdatedBy;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "last_updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedAt;
    @Column(name = "is_active")
    private Character isActive;
    @Basic(optional = false)
    @Column(name = "ip_address")
    private String ipAddress;
    @JoinColumn(name = "branch_master_id", referencedColumnName = "branch_master_id")
    @ManyToOne(optional = false)
    private BranchMaster branchMasterId;
    @JoinColumn(name = "project_master_id", referencedColumnName = "project_master_id")
    @ManyToOne(optional = false)
    private ProjectMaster projectMasterId;

    public ProductionMaster() {
    }

    public ProductionMaster(Integer productionMasterId) {
        this.productionMasterId = productionMasterId;
    }

    public ProductionMaster(Integer productionMasterId, Date date, String productionMasterNo, String productionActions, int createdBy, int lastUpdatedBy, String ipAddress) {
        this.productionMasterId = productionMasterId;
        this.date = date;
        this.productionMasterNo = productionMasterNo;
        this.productionActions = productionActions;
        this.createdBy = createdBy;
        this.lastUpdatedBy = lastUpdatedBy;
        this.ipAddress = ipAddress;
    }

    public Integer getProductionMasterId() {
        return productionMasterId;
    }

    public void setProductionMasterId(Integer productionMasterId) {
        this.productionMasterId = productionMasterId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProductionMasterNo() {
        return productionMasterNo;
    }

    public void setProductionMasterNo(String productionMasterNo) {
        this.productionMasterNo = productionMasterNo;
    }

    public String getProductionStatus() {
        return productionStatus;
    }

    public void setProductionStatus(String productionStatus) {
        this.productionStatus = productionStatus;
    }

    public String getProductionActions() {
        return productionActions;
    }

    public void setProductionActions(String productionActions) {
        this.productionActions = productionActions;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(int lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
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

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productionMasterId != null ? productionMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductionMaster)) {
            return false;
        }
        ProductionMaster other = (ProductionMaster) object;
        if ((this.productionMasterId == null && other.productionMasterId != null) || (this.productionMasterId != null && !this.productionMasterId.equals(other.productionMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.ProductionMaster[ productionMasterId=" + productionMasterId + " ]";
    }
    
}
