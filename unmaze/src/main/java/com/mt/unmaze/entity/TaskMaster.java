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
@Table(name = "task_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaskMaster.findAll", query = "SELECT t FROM TaskMaster t"),
    @NamedQuery(name = "TaskMaster.findByTaskMasterId", query = "SELECT t FROM TaskMaster t WHERE t.taskMasterId = :taskMasterId"),
    @NamedQuery(name = "TaskMaster.findByProjectMasterName", query = "SELECT t FROM TaskMaster t WHERE t.projectMasterName = :projectMasterName"),
    @NamedQuery(name = "TaskMaster.findByDetailsOfTheTask", query = "SELECT t FROM TaskMaster t WHERE t.detailsOfTheTask = :detailsOfTheTask"),
    @NamedQuery(name = "TaskMaster.findByDueDate", query = "SELECT t FROM TaskMaster t WHERE t.dueDate = :dueDate"),
    @NamedQuery(name = "TaskMaster.findByTaskType", query = "SELECT t FROM TaskMaster t WHERE t.taskType = :taskType"),
    @NamedQuery(name = "TaskMaster.findByRepeatAfterDays", query = "SELECT t FROM TaskMaster t WHERE t.repeatAfterDays = :repeatAfterDays"),
    @NamedQuery(name = "TaskMaster.findByActions", query = "SELECT t FROM TaskMaster t WHERE t.actions = :actions"),
    @NamedQuery(name = "TaskMaster.findByCreatedBy", query = "SELECT t FROM TaskMaster t WHERE t.createdBy = :createdBy"),
    @NamedQuery(name = "TaskMaster.findByLastUpdatedBy", query = "SELECT t FROM TaskMaster t WHERE t.lastUpdatedBy = :lastUpdatedBy"),
    @NamedQuery(name = "TaskMaster.findByCreatedAt", query = "SELECT t FROM TaskMaster t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "TaskMaster.findByLastUpdatedAt", query = "SELECT t FROM TaskMaster t WHERE t.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "TaskMaster.findByIsActive", query = "SELECT t FROM TaskMaster t WHERE t.isActive = :isActive"),
    @NamedQuery(name = "TaskMaster.findByIpAddress", query = "SELECT t FROM TaskMaster t WHERE t.ipAddress = :ipAddress")})
public class TaskMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "task_master_id")
    private Integer taskMasterId;
    @Basic(optional = false)
    @Column(name = "project_master_name")
    private int projectMasterName;
    @Basic(optional = false)
    @Column(name = "details_of_the_task")
    private String detailsOfTheTask;
    @Basic(optional = false)
    @Column(name = "due_date")
    @Temporal(TemporalType.DATE)
    private Date dueDate;
    @Basic(optional = false)
    @Column(name = "task_type")
    private String taskType;
    @Basic(optional = false)
    @Column(name = "repeat_after_days")
    private int repeatAfterDays;
    @Basic(optional = false)
    @Column(name = "actions")
    private String actions;
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
    @JoinColumn(name = "customer_master_id", referencedColumnName = "customer_master_id")
    @ManyToOne(optional = false)
    private CustomerMaster customerMasterId;
    @JoinColumn(name = "project_master_id", referencedColumnName = "project_master_id")
    @ManyToOne(optional = false)
    private ProjectMaster projectMasterId;
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_master_id")
    @ManyToOne(optional = false)
    private StaffMaster staffId;

    public TaskMaster() {
    }

    public TaskMaster(Integer taskMasterId) {
        this.taskMasterId = taskMasterId;
    }

    public TaskMaster(Integer taskMasterId, int projectMasterName, String detailsOfTheTask, Date dueDate, String taskType, int repeatAfterDays, String actions, int createdBy, int lastUpdatedBy, String ipAddress) {
        this.taskMasterId = taskMasterId;
        this.projectMasterName = projectMasterName;
        this.detailsOfTheTask = detailsOfTheTask;
        this.dueDate = dueDate;
        this.taskType = taskType;
        this.repeatAfterDays = repeatAfterDays;
        this.actions = actions;
        this.createdBy = createdBy;
        this.lastUpdatedBy = lastUpdatedBy;
        this.ipAddress = ipAddress;
    }

    public Integer getTaskMasterId() {
        return taskMasterId;
    }

    public void setTaskMasterId(Integer taskMasterId) {
        this.taskMasterId = taskMasterId;
    }

    public int getProjectMasterName() {
        return projectMasterName;
    }

    public void setProjectMasterName(int projectMasterName) {
        this.projectMasterName = projectMasterName;
    }

    public String getDetailsOfTheTask() {
        return detailsOfTheTask;
    }

    public void setDetailsOfTheTask(String detailsOfTheTask) {
        this.detailsOfTheTask = detailsOfTheTask;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public int getRepeatAfterDays() {
        return repeatAfterDays;
    }

    public void setRepeatAfterDays(int repeatAfterDays) {
        this.repeatAfterDays = repeatAfterDays;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
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

    public CustomerMaster getCustomerMasterId() {
        return customerMasterId;
    }

    public void setCustomerMasterId(CustomerMaster customerMasterId) {
        this.customerMasterId = customerMasterId;
    }

    public ProjectMaster getProjectMasterId() {
        return projectMasterId;
    }

    public void setProjectMasterId(ProjectMaster projectMasterId) {
        this.projectMasterId = projectMasterId;
    }

    public StaffMaster getStaffId() {
        return staffId;
    }

    public void setStaffId(StaffMaster staffId) {
        this.staffId = staffId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskMasterId != null ? taskMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaskMaster)) {
            return false;
        }
        TaskMaster other = (TaskMaster) object;
        if ((this.taskMasterId == null && other.taskMasterId != null) || (this.taskMasterId != null && !this.taskMasterId.equals(other.taskMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.TaskMaster[ taskMasterId=" + taskMasterId + " ]";
    }
    
}
