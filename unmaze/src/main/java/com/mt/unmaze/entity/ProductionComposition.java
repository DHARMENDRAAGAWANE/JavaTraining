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
@Table(name = "production_composition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductionComposition.findAll", query = "SELECT p FROM ProductionComposition p"),
    @NamedQuery(name = "ProductionComposition.findByProductionCompositionId", query = "SELECT p FROM ProductionComposition p WHERE p.productionCompositionId = :productionCompositionId"),
    @NamedQuery(name = "ProductionComposition.findByIssueQty", query = "SELECT p FROM ProductionComposition p WHERE p.issueQty = :issueQty"),
    @NamedQuery(name = "ProductionComposition.findByCreatedAt", query = "SELECT p FROM ProductionComposition p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "ProductionComposition.findByLastUpdatedAt", query = "SELECT p FROM ProductionComposition p WHERE p.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "ProductionComposition.findByIsActive", query = "SELECT p FROM ProductionComposition p WHERE p.isActive = :isActive"),
    @NamedQuery(name = "ProductionComposition.findByIpAddress", query = "SELECT p FROM ProductionComposition p WHERE p.ipAddress = :ipAddress")})
public class ProductionComposition implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "production_composition_id")
    private Integer productionCompositionId;
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

    public ProductionComposition() {
    }

    public ProductionComposition(Integer productionCompositionId) {
        this.productionCompositionId = productionCompositionId;
    }

    public ProductionComposition(Integer productionCompositionId, Date createdAt, Date lastUpdatedAt, Character isActive) {
        this.productionCompositionId = productionCompositionId;
        this.createdAt = createdAt;
        this.lastUpdatedAt = lastUpdatedAt;
        this.isActive = isActive;
    }

    public Integer getProductionCompositionId() {
        return productionCompositionId;
    }

    public void setProductionCompositionId(Integer productionCompositionId) {
        this.productionCompositionId = productionCompositionId;
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
        hash += (productionCompositionId != null ? productionCompositionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductionComposition)) {
            return false;
        }
        ProductionComposition other = (ProductionComposition) object;
        if ((this.productionCompositionId == null && other.productionCompositionId != null) || (this.productionCompositionId != null && !this.productionCompositionId.equals(other.productionCompositionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.ProductionComposition[ productionCompositionId=" + productionCompositionId + " ]";
    }
    
}
