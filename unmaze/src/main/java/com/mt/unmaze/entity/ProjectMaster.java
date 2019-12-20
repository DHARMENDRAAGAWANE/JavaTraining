/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mt.unmaze.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "project_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectMaster.findAll", query = "SELECT p FROM ProjectMaster p"),
    @NamedQuery(name = "ProjectMaster.findByProjectMasterId", query = "SELECT p FROM ProjectMaster p WHERE p.projectMasterId = :projectMasterId"),
    @NamedQuery(name = "ProjectMaster.findByProjectMasterName", query = "SELECT p FROM ProjectMaster p WHERE p.projectMasterName = :projectMasterName"),
    @NamedQuery(name = "ProjectMaster.findByRemarks", query = "SELECT p FROM ProjectMaster p WHERE p.remarks = :remarks"),
    @NamedQuery(name = "ProjectMaster.findByCreatedAt", query = "SELECT p FROM ProjectMaster p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "ProjectMaster.findByLastUpdatedAt", query = "SELECT p FROM ProjectMaster p WHERE p.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "ProjectMaster.findByIsActive", query = "SELECT p FROM ProjectMaster p WHERE p.isActive = :isActive"),
    @NamedQuery(name = "ProjectMaster.findByIpAddress", query = "SELECT p FROM ProjectMaster p WHERE p.ipAddress = :ipAddress")})
public class ProjectMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "project_master_id")
    private Integer projectMasterId;
    @Basic(optional = false)
    @Column(name = "project_master_name")
    private String projectMasterName;
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
    @Column(name = "ip_address")
    private String ipAddress;
    @OneToMany(mappedBy = "projectMasterId")
    private List<PurchaseOrderMaster> purchaseOrderMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectMasterId")
    private List<TaskMaster> taskMasterList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectMasterId")
    private List<TaskDetailMaster> taskDetailMasterList;
    @OneToMany(mappedBy = "projectMasterId")
    private List<GeneralLedger> generalLedgerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectMasterId")
    private List<ProductionMaster> productionMasterList;
    @OneToMany(mappedBy = "projectMasterId")
    private List<BookingMaster> bookingMasterList;
    @JoinColumn(name = "branch_master_id", referencedColumnName = "branch_master_id")
    @ManyToOne
    private BranchMaster branchMasterId;
    @JoinColumn(name = "customer_master_id", referencedColumnName = "customer_master_id")
    @ManyToOne
    private CustomerMaster customerMasterId;
    @JoinColumn(name = "staff_master_id", referencedColumnName = "staff_master_id")
    @ManyToOne
    private StaffMaster staffMasterId;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;
    @OneToMany(mappedBy = "projectMasterId")
    private List<BudgetMaster> budgetMasterList;

    public ProjectMaster() {
    }

    public ProjectMaster(Integer projectMasterId) {
        this.projectMasterId = projectMasterId;
    }

    public ProjectMaster(Integer projectMasterId, String projectMasterName, Character isActive) {
        this.projectMasterId = projectMasterId;
        this.projectMasterName = projectMasterName;
        this.isActive = isActive;
    }

    public Integer getProjectMasterId() {
        return projectMasterId;
    }

    public void setProjectMasterId(Integer projectMasterId) {
        this.projectMasterId = projectMasterId;
    }

    public String getProjectMasterName() {
        return projectMasterName;
    }

    public void setProjectMasterName(String projectMasterName) {
        this.projectMasterName = projectMasterName;
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

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @XmlTransient
    public List<PurchaseOrderMaster> getPurchaseOrderMasterList() {
        return purchaseOrderMasterList;
    }

    public void setPurchaseOrderMasterList(List<PurchaseOrderMaster> purchaseOrderMasterList) {
        this.purchaseOrderMasterList = purchaseOrderMasterList;
    }

    @XmlTransient
    public List<TaskMaster> getTaskMasterList() {
        return taskMasterList;
    }

    public void setTaskMasterList(List<TaskMaster> taskMasterList) {
        this.taskMasterList = taskMasterList;
    }

    @XmlTransient
    public List<TaskDetailMaster> getTaskDetailMasterList() {
        return taskDetailMasterList;
    }

    public void setTaskDetailMasterList(List<TaskDetailMaster> taskDetailMasterList) {
        this.taskDetailMasterList = taskDetailMasterList;
    }

    @XmlTransient
    public List<GeneralLedger> getGeneralLedgerList() {
        return generalLedgerList;
    }

    public void setGeneralLedgerList(List<GeneralLedger> generalLedgerList) {
        this.generalLedgerList = generalLedgerList;
    }

    @XmlTransient
    public List<ProductionMaster> getProductionMasterList() {
        return productionMasterList;
    }

    public void setProductionMasterList(List<ProductionMaster> productionMasterList) {
        this.productionMasterList = productionMasterList;
    }

    @XmlTransient
    public List<BookingMaster> getBookingMasterList() {
        return bookingMasterList;
    }

    public void setBookingMasterList(List<BookingMaster> bookingMasterList) {
        this.bookingMasterList = bookingMasterList;
    }

    public BranchMaster getBranchMasterId() {
        return branchMasterId;
    }

    public void setBranchMasterId(BranchMaster branchMasterId) {
        this.branchMasterId = branchMasterId;
    }

    public CustomerMaster getCustomerMasterId() {
        return customerMasterId;
    }

    public void setCustomerMasterId(CustomerMaster customerMasterId) {
        this.customerMasterId = customerMasterId;
    }

    public StaffMaster getStaffMasterId() {
        return staffMasterId;
    }

    public void setStaffMasterId(StaffMaster staffMasterId) {
        this.staffMasterId = staffMasterId;
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

    @XmlTransient
    public List<BudgetMaster> getBudgetMasterList() {
        return budgetMasterList;
    }

    public void setBudgetMasterList(List<BudgetMaster> budgetMasterList) {
        this.budgetMasterList = budgetMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectMasterId != null ? projectMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectMaster)) {
            return false;
        }
        ProjectMaster other = (ProjectMaster) object;
        if ((this.projectMasterId == null && other.projectMasterId != null) || (this.projectMasterId != null && !this.projectMasterId.equals(other.projectMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.ProjectMaster[ projectMasterId=" + projectMasterId + " ]";
    }
    
}
