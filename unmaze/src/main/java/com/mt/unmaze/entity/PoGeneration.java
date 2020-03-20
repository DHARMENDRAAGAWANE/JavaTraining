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
@Table(name = "po_generation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PoGeneration.findAll", query = "SELECT p FROM PoGeneration p"),
    @NamedQuery(name = "PoGeneration.findByPoGenerationId", query = "SELECT p FROM PoGeneration p WHERE p.poGenerationId = :poGenerationId")})
public class PoGeneration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "po_generation_id")
    private Integer poGenerationId;
    @Lob
    @Column(name = "po_no")
    private String poNo;

    public PoGeneration() {
    }

    public PoGeneration(Integer poGenerationId) {
        this.poGenerationId = poGenerationId;
    }

    public Integer getPoGenerationId() {
        return poGenerationId;
    }

    public void setPoGenerationId(Integer poGenerationId) {
        this.poGenerationId = poGenerationId;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (poGenerationId != null ? poGenerationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoGeneration)) {
            return false;
        }
        PoGeneration other = (PoGeneration) object;
        if ((this.poGenerationId == null && other.poGenerationId != null) || (this.poGenerationId != null && !this.poGenerationId.equals(other.poGenerationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.PoGeneration[ poGenerationId=" + poGenerationId + " ]";
    }
    
}
