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
@Table(name = "bill_of_material_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BillOfMaterialMaster.findAll", query = "SELECT b FROM BillOfMaterialMaster b"),
    @NamedQuery(name = "BillOfMaterialMaster.findByBillOfMaterialId", query = "SELECT b FROM BillOfMaterialMaster b WHERE b.billOfMaterialId = :billOfMaterialId"),
    @NamedQuery(name = "BillOfMaterialMaster.findByQty", query = "SELECT b FROM BillOfMaterialMaster b WHERE b.qty = :qty"),
    @NamedQuery(name = "BillOfMaterialMaster.findByStdRate", query = "SELECT b FROM BillOfMaterialMaster b WHERE b.stdRate = :stdRate"),
    @NamedQuery(name = "BillOfMaterialMaster.findByCost", query = "SELECT b FROM BillOfMaterialMaster b WHERE b.cost = :cost"),
    @NamedQuery(name = "BillOfMaterialMaster.findByCreatedBy", query = "SELECT b FROM BillOfMaterialMaster b WHERE b.createdBy = :createdBy"),
    @NamedQuery(name = "BillOfMaterialMaster.findByLastUpdatedBy", query = "SELECT b FROM BillOfMaterialMaster b WHERE b.lastUpdatedBy = :lastUpdatedBy"),
    @NamedQuery(name = "BillOfMaterialMaster.findByCreatedAt", query = "SELECT b FROM BillOfMaterialMaster b WHERE b.createdAt = :createdAt"),
    @NamedQuery(name = "BillOfMaterialMaster.findByLastUpdatedAt", query = "SELECT b FROM BillOfMaterialMaster b WHERE b.lastUpdatedAt = :lastUpdatedAt"),
    @NamedQuery(name = "BillOfMaterialMaster.findByIsActive", query = "SELECT b FROM BillOfMaterialMaster b WHERE b.isActive = :isActive"),
    @NamedQuery(name = "BillOfMaterialMaster.findByIpAddress", query = "SELECT b FROM BillOfMaterialMaster b WHERE b.ipAddress = :ipAddress")})
public class BillOfMaterialMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bill_of_material_id")
    private Integer billOfMaterialId;
    @Basic(optional = false)
    @Column(name = "qty")
    private double qty;
    @Basic(optional = false)
    @Column(name = "std_rate")
    private double stdRate;
    @Basic(optional = false)
    @Column(name = "cost")
    private double cost;
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
    @JoinColumn(name = "bill_of_in_material", referencedColumnName = "material_master_id")
    @ManyToOne(optional = false)
    private MaterialMaster billOfInMaterial;
    @JoinColumn(name = "bill_of_out_material", referencedColumnName = "material_master_id")
    @ManyToOne(optional = false)
    private MaterialMaster billOfOutMaterial;
    @JoinColumn(name = "units", referencedColumnName = "material_unit_id")
    @ManyToOne(optional = false)
    private MaterialUnit units;

    public BillOfMaterialMaster() {
    }

    public BillOfMaterialMaster(Integer billOfMaterialId) {
        this.billOfMaterialId = billOfMaterialId;
    }

    public BillOfMaterialMaster(Integer billOfMaterialId, double qty, double stdRate, double cost, int createdBy, int lastUpdatedBy, String ipAddress) {
        this.billOfMaterialId = billOfMaterialId;
        this.qty = qty;
        this.stdRate = stdRate;
        this.cost = cost;
        this.createdBy = createdBy;
        this.lastUpdatedBy = lastUpdatedBy;
        this.ipAddress = ipAddress;
    }

    public Integer getBillOfMaterialId() {
        return billOfMaterialId;
    }

    public void setBillOfMaterialId(Integer billOfMaterialId) {
        this.billOfMaterialId = billOfMaterialId;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getStdRate() {
        return stdRate;
    }

    public void setStdRate(double stdRate) {
        this.stdRate = stdRate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
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

    public MaterialMaster getBillOfInMaterial() {
        return billOfInMaterial;
    }

    public void setBillOfInMaterial(MaterialMaster billOfInMaterial) {
        this.billOfInMaterial = billOfInMaterial;
    }

    public MaterialMaster getBillOfOutMaterial() {
        return billOfOutMaterial;
    }

    public void setBillOfOutMaterial(MaterialMaster billOfOutMaterial) {
        this.billOfOutMaterial = billOfOutMaterial;
    }

    public MaterialUnit getUnits() {
        return units;
    }

    public void setUnits(MaterialUnit units) {
        this.units = units;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billOfMaterialId != null ? billOfMaterialId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BillOfMaterialMaster)) {
            return false;
        }
        BillOfMaterialMaster other = (BillOfMaterialMaster) object;
        if ((this.billOfMaterialId == null && other.billOfMaterialId != null) || (this.billOfMaterialId != null && !this.billOfMaterialId.equals(other.billOfMaterialId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.BillOfMaterialMaster[ billOfMaterialId=" + billOfMaterialId + " ]";
    }
    
}
