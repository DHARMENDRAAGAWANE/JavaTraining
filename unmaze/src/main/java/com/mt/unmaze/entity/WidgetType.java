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
@Table(name = "widget_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WidgetType.findAll", query = "SELECT w FROM WidgetType w"),
    @NamedQuery(name = "WidgetType.findByWidgetTypeId", query = "SELECT w FROM WidgetType w WHERE w.widgetTypeId = :widgetTypeId"),
    @NamedQuery(name = "WidgetType.findByWidgetTypeName", query = "SELECT w FROM WidgetType w WHERE w.widgetTypeName = :widgetTypeName"),
    @NamedQuery(name = "WidgetType.findByIsActive", query = "SELECT w FROM WidgetType w WHERE w.isActive = :isActive")})
public class WidgetType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "widget_type_id")
    private Integer widgetTypeId;
    @Basic(optional = false)
    @Column(name = "widget_type_name")
    private String widgetTypeName;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @OneToMany(mappedBy = "widgetTypeId")
    private List<WidgetTypeMapping> widgetTypeMappingList;

    public WidgetType() {
    }

    public WidgetType(Integer widgetTypeId) {
        this.widgetTypeId = widgetTypeId;
    }

    public WidgetType(Integer widgetTypeId, String widgetTypeName, Character isActive) {
        this.widgetTypeId = widgetTypeId;
        this.widgetTypeName = widgetTypeName;
        this.isActive = isActive;
    }

    public Integer getWidgetTypeId() {
        return widgetTypeId;
    }

    public void setWidgetTypeId(Integer widgetTypeId) {
        this.widgetTypeId = widgetTypeId;
    }

    public String getWidgetTypeName() {
        return widgetTypeName;
    }

    public void setWidgetTypeName(String widgetTypeName) {
        this.widgetTypeName = widgetTypeName;
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
        hash += (widgetTypeId != null ? widgetTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WidgetType)) {
            return false;
        }
        WidgetType other = (WidgetType) object;
        if ((this.widgetTypeId == null && other.widgetTypeId != null) || (this.widgetTypeId != null && !this.widgetTypeId.equals(other.widgetTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.WidgetType[ widgetTypeId=" + widgetTypeId + " ]";
    }
    
}
