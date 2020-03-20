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
@Table(name = "pricing_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PricingMaster.findAll", query = "SELECT p FROM PricingMaster p"),
    @NamedQuery(name = "PricingMaster.findByPricingMasterId", query = "SELECT p FROM PricingMaster p WHERE p.pricingMasterId = :pricingMasterId"),
    @NamedQuery(name = "PricingMaster.findByBestSellingPrice", query = "SELECT p FROM PricingMaster p WHERE p.bestSellingPrice = :bestSellingPrice"),
    @NamedQuery(name = "PricingMaster.findByIsActive", query = "SELECT p FROM PricingMaster p WHERE p.isActive = :isActive")})
public class PricingMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pricing_master_id")
    private Integer pricingMasterId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "best_selling_price")
    private Double bestSellingPrice;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @JoinColumn(name = "branch_master_id", referencedColumnName = "branch_master_id")
    @ManyToOne
    private BranchMaster branchMasterId;
    @JoinColumn(name = "material_master_id", referencedColumnName = "material_master_id")
    @ManyToOne
    private MaterialMaster materialMasterId;
    @JoinColumn(name = "service_master_id", referencedColumnName = "service_master_id")
    @ManyToOne
    private ServiceMaster serviceMasterId;

    public PricingMaster() {
    }

    public PricingMaster(Integer pricingMasterId) {
        this.pricingMasterId = pricingMasterId;
    }

    public PricingMaster(Integer pricingMasterId, Character isActive) {
        this.pricingMasterId = pricingMasterId;
        this.isActive = isActive;
    }

    public Integer getPricingMasterId() {
        return pricingMasterId;
    }

    public void setPricingMasterId(Integer pricingMasterId) {
        this.pricingMasterId = pricingMasterId;
    }

    public Double getBestSellingPrice() {
        return bestSellingPrice;
    }

    public void setBestSellingPrice(Double bestSellingPrice) {
        this.bestSellingPrice = bestSellingPrice;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    public BranchMaster getBranchMasterId() {
        return branchMasterId;
    }

    public void setBranchMasterId(BranchMaster branchMasterId) {
        this.branchMasterId = branchMasterId;
    }

    public MaterialMaster getMaterialMasterId() {
        return materialMasterId;
    }

    public void setMaterialMasterId(MaterialMaster materialMasterId) {
        this.materialMasterId = materialMasterId;
    }

    public ServiceMaster getServiceMasterId() {
        return serviceMasterId;
    }

    public void setServiceMasterId(ServiceMaster serviceMasterId) {
        this.serviceMasterId = serviceMasterId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pricingMasterId != null ? pricingMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PricingMaster)) {
            return false;
        }
        PricingMaster other = (PricingMaster) object;
        if ((this.pricingMasterId == null && other.pricingMasterId != null) || (this.pricingMasterId != null && !this.pricingMasterId.equals(other.pricingMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.PricingMaster[ pricingMasterId=" + pricingMasterId + " ]";
    }
    
}
