/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mt.unmaze.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "widget_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WidgetMaster.findAll", query = "SELECT w FROM WidgetMaster w"),
    @NamedQuery(name = "WidgetMaster.findByWidgetMasterId", query = "SELECT w FROM WidgetMaster w WHERE w.widgetMasterId = :widgetMasterId"),
    @NamedQuery(name = "WidgetMaster.findByWidgetName", query = "SELECT w FROM WidgetMaster w WHERE w.widgetName = :widgetName"),
    @NamedQuery(name = "WidgetMaster.findByIsActive", query = "SELECT w FROM WidgetMaster w WHERE w.isActive = :isActive")})
public class WidgetMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "widget_master_id")
    private Integer widgetMasterId;
    @Basic(optional = false)
    @Column(name = "widget_name")
    private String widgetName;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @OneToMany(mappedBy = "widgetMasterId")
    private List<WidgetTypeMapping> widgetTypeMappingList;

    public WidgetMaster() {
    }

    public WidgetMaster(Integer widgetMasterId) {
        this.widgetMasterId = widgetMasterId;
    }

    public WidgetMaster(Integer widgetMasterId, String widgetName, Character isActive) {
        this.widgetMasterId = widgetMasterId;
        this.widgetName = widgetName;
        this.isActive = isActive;
    }

    public Integer getWidgetMasterId() {
        return widgetMasterId;
    }

    public void setWidgetMasterId(Integer widgetMasterId) {
        this.widgetMasterId = widgetMasterId;
    }

    public String getWidgetName() {
        return widgetName;
    }

    public void setWidgetName(String widgetName) {
        this.widgetName = widgetName;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<WidgetTypeMapping> getWidgetTypeMappingList() {
        return widgetTypeMappingList;
    }

    public void setWidgetTypeMappingList(List<WidgetTypeMapping> widgetTypeMappingList) {
        this.widgetTypeMappingList = widgetTypeMappingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (widgetMasterId != null ? widgetMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WidgetMaster)) {
            return false;
        }
        WidgetMaster other = (WidgetMaster) object;
        if ((this.widgetMasterId == null && other.widgetMasterId != null) || (this.widgetMasterId != null && !this.widgetMasterId.equals(other.widgetMasterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.WidgetMaster[ widgetMasterId=" + widgetMasterId + " ]";
    }
    
}
