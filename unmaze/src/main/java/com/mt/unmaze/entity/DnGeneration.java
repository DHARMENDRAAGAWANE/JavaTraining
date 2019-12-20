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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "dn_generation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DnGeneration.findAll", query = "SELECT d FROM DnGeneration d"),
    @NamedQuery(name = "DnGeneration.findByDnGenerationId", query = "SELECT d FROM DnGeneration d WHERE d.dnGenerationId = :dnGenerationId")})
public class DnGeneration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dn_generation_id")
    private Integer dnGenerationId;
    @Lob
    @Column(name = "dn_no")
    private String dnNo;

    public DnGeneration() {
    }

    public DnGeneration(Integer dnGenerationId) {
        this.dnGenerationId = dnGenerationId;
    }

    public Integer getDnGenerationId() {
        return dnGenerationId;
    }

    public void setDnGenerationId(Integer dnGenerationId) {
        this.dnGenerationId = dnGenerationId;
    }

    public String getDnNo() {
        return dnNo;
    }

    public void setDnNo(String dnNo) {
        this.dnNo = dnNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dnGenerationId != null ? dnGenerationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DnGeneration)) {
            return false;
        }
        DnGeneration other = (DnGeneration) object;
        if ((this.dnGenerationId == null && other.dnGenerationId != null) || (this.dnGenerationId != null && !this.dnGenerationId.equals(other.dnGenerationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.DnGeneration[ dnGenerationId=" + dnGenerationId + " ]";
    }
    
}
