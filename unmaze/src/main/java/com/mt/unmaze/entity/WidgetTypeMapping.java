/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mt.unmaze.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "widget_type_mapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WidgetTypeMapping.findAll", query = "SELECT w FROM WidgetTypeMapping w"),
    @NamedQuery(name = "WidgetTypeMapping.findByWidgetTypeMappingId", query = "SELECT w FROM WidgetTypeMapping w WHERE w.widgetTypeMappingId = :widgetTypeMappingId"),
    @NamedQuery(name = "WidgetTypeMapping.findByIsActive", query = "SELECT w FROM WidgetTypeMapping w WHERE w.isActive = :isActive")})
public class WidgetTypeMapping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "widget_type_mapping_id")
    private Integer widgetTypeMappingId;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @JoinColumn(name = "widget_master_id", referencedColumnName = "widget_master_id")
    @ManyToOne
    private WidgetMaster widgetMasterId;
    @JoinColumn(name = "widget_type_id", referencedColumnName = "widget_type_id")
    @ManyToOne
    private WidgetType widgetTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "widgetTypeMappingId")
    private List<WidgetUserMapping> widgetUserMappingList;

    public WidgetTypeMapping() {
    }

    public WidgetTypeMapping(Integer widgetTypeMappingId) {
        this.widgetTypeMappingId = widgetTypeMappingId;
    }

    public WidgetTypeMapping(Integer widgetTypeMappingId, Character isActive) {
        this.widgetTypeMappingId = widgetTypeMappingId;
        this.isActive = isActive;
    }

    public Integer getWidgetTypeMappingId() {
        return widgetTypeMappingId;
    }

    public void setWidgetTypeMappingId(Integer widgetTypeMappingId) {
        this.widgetTypeMappingId = widgetTypeMappingId;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    public WidgetMaster getWidgetMasterId() {
        return widgetMasterId;
    }

    public void setWidgetMasterId(WidgetMaster widgetMasterId) {
        this.widgetMasterId = widgetMasterId;
    }

    public WidgetType getWidgetTypeId() {
        return widgetTypeId;
    }

    public void setWidgetTypeId(WidgetType widgetTypeId) {
        this.widgetTypeId = widgetTypeId;
    }

    @XmlTransient
    public List<WidgetUserMapping> getWidgetUserMappingList() {
        return widgetUserMappingList;
    }

    public void setWidgetUserMappingList(List<WidgetUserMapping> widgetUserMappingList) {
        this.widgetUserMappingList = widgetUserMappingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (widgetTypeMappingId != null ? widgetTypeMappingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WidgetTypeMapping)) {
            return false;
        }
        WidgetTypeMapping other = (WidgetTypeMapping) object;
        if ((this.widgetTypeMappingId == null && other.widgetTypeMappingId != null) || (this.widgetTypeMappingId != null && !this.widgetTypeMappingId.equals(other.widgetTypeMappingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.WidgetTypeMapping[ widgetTypeMappingId=" + widgetTypeMappingId + " ]";
    }
    
}
