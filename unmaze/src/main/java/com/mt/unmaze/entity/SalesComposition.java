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
@Table(name = "sales_composition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesComposition.findAll", query = "SELECT s FROM SalesComposition s"),
    @NamedQuery(name = "SalesComposition.findBySalesCompositionId", query = "SELECT s FROM SalesComposition s WHERE s.salesCompositionId = :salesCompositionId"),
    @NamedQuery(name = "SalesComposition.findByIssueQty", query = "SELECT s FROM SalesComposition s WHERE s.issueQty = :issueQty"),
    @NamedQuery(name = "SalesComposition.findByCreatedAt", query = "SELECT s FROM SalesComposition s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "SalesComposition.findByLastUpdatedAt", query = "SELECT s FROM SalesComposition s WHERE s.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "SalesComposition.findByIsActive", query = "SELECT s FROM SalesComposition s WHERE s.isActive = :isActive"),
    @NamedQuery(name = "SalesComposition.findByIpAddress", query = "SELECT s FROM SalesComposition s WHERE s.ipAddress = :ipAddress")})
public class SalesComposition implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sales_composition_id")
    private Integer salesCompositionId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "issue_qty")
    private Double issueQty;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "last_updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedAt;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @Column(name = "ip_address")
    private String ipAddress;
    @JoinColumn(name = "input_material_id", referencedColumnName = "material_master_id")
    @ManyToOne
    private MaterialMaster inputMaterialId;
    @JoinColumn(name = "output_material_id", referencedColumnName = "material_master_id")
    @ManyToOne
    private MaterialMaster outputMaterialId;
    @JoinColumn(name = "created_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster createdBy;
    @JoinColumn(name = "last_updated_by", referencedColumnName = "user_master_id")
    @ManyToOne
    private UserMaster lastUpdatedBy;

    public SalesComposition() {
    }

    public SalesComposition(Integer salesCompositionId) {
        this.salesCompositionId = salesCompositionId;
    }

    public SalesComposition(Integer salesCompositionId, Date createdAt, Date lastUpdatedAt, Character isActive) {
        this.salesCompositionId = salesCompositionId;
        this.createdAt = createdAt;
        this.lastUpdatedAt = lastUpdatedAt;
        this.isActive = isActive;
    }

    public Integer getSalesCompositionId() {
        return salesCompositionId;
    }

    public void setSalesCompositionId(Integer salesCompositionId) {
        this.salesCompositionId = salesCompositionId;
    }

    public Double getIssueQty() {
        return issueQty;
    }

    public void setIssueQty(Double issueQty) {
        this.issueQty = issueQty;
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

    public MaterialMaster getInputMaterialId() {
        return inputMaterialId;
    }

    public void setInputMaterialId(MaterialMaster inputMaterialId) {
        this.inputMaterialId = inputMaterialId;
    }

    public MaterialMaster getOutputMaterialId() {
        return outputMaterialId;
    }

    public void setOutputMaterialId(MaterialMaster outputMaterialId) {
        this.outputMaterialId = outputMaterialId;
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
        hash += (salesCompositionId != null ? salesCompositionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesComposition)) {
            return false;
        }
        SalesComposition other = (SalesComposition) object;
        if ((this.salesCompositionId == null && other.salesCompositionId != null) || (this.salesCompositionId != null && !this.salesCompositionId.equals(other.salesCompositionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.SalesComposition[ salesCompositionId=" + salesCompositionId + " ]";
    }
    
}
