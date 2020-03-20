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
@Table(name = "grn_generation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrnGeneration.findAll", query = "SELECT g FROM GrnGeneration g"),
    @NamedQuery(name = "GrnGeneration.findByGrnGenerationId", query = "SELECT g FROM GrnGeneration g WHERE g.grnGenerationId = :grnGenerationId")})
public class GrnGeneration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "grn_generation_id")
    private Integer grnGenerationId;
    @Lob
    @Column(name = "grn_no")
    private String grnNo;

    public GrnGeneration() {
    }

    public GrnGeneration(Integer grnGenerationId) {
        this.grnGenerationId = grnGenerationId;
    }

    public Integer getGrnGenerationId() {
        return grnGenerationId;
    }

    public void setGrnGenerationId(Integer grnGenerationId) {
        this.grnGenerationId = grnGenerationId;
    }

    public String getGrnNo() {
        return grnNo;
    }

    public void setGrnNo(String grnNo) {
        this.grnNo = grnNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grnGenerationId != null ? grnGenerationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrnGeneration)) {
            return false;
        }
        GrnGeneration other = (GrnGeneration) object;
        if ((this.grnGenerationId == null && other.grnGenerationId != null) || (this.grnGenerationId != null && !this.grnGenerationId.equals(other.grnGenerationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.GrnGeneration[ grnGenerationId=" + grnGenerationId + " ]";
    }
    
}
