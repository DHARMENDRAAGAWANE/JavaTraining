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
@Table(name = "widget_user_mapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WidgetUserMapping.findAll", query = "SELECT w FROM WidgetUserMapping w"),
    @NamedQuery(name = "WidgetUserMapping.findByWidgetUserMappingId", query = "SELECT w FROM WidgetUserMapping w WHERE w.widgetUserMappingId = :widgetUserMappingId"),
    @NamedQuery(name = "WidgetUserMapping.findByIsActive", query = "SELECT w FROM WidgetUserMapping w WHERE w.isActive = :isActive")})
public class WidgetUserMapping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "widget_user_mapping_id")
    private Integer widgetUserMappingId;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @JoinColumn(name = "user_master_id", referencedColumnName = "user_master_id")
    @ManyToOne(optional = false)
    private UserMaster userMasterId;
    @JoinColumn(name = "widget_type_mapping_id", referencedColumnName = "widget_type_mapping_id")
    @ManyToOne(optional = false)
    private WidgetTypeMapping widgetTypeMappingId;

    public WidgetUserMapping() {
    }

    public WidgetUserMapping(Integer widgetUserMappingId) {
        this.widgetUserMappingId = widgetUserMappingId;
    }

    public WidgetUserMapping(Integer widgetUserMappingId, Character isActive) {
        this.widgetUserMappingId = widgetUserMappingId;
        this.isActive = isActive;
    }

    public Integer getWidgetUserMappingId() {
        return widgetUserMappingId;
    }

    public void setWidgetUserMappingId(Integer widgetUserMappingId) {
        this.widgetUserMappingId = widgetUserMappingId;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    public UserMaster getUserMasterId() {
        return userMasterId;
    }

    public void setUserMasterId(UserMaster userMasterId) {
        this.userMasterId = userMasterId;
    }

    public WidgetTypeMapping getWidgetTypeMappingId() {
        return widgetTypeMappingId;
    }

    public void setWidgetTypeMappingId(WidgetTypeMapping widgetTypeMappingId) {
        this.widgetTypeMappingId = widgetTypeMappingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (widgetUserMappingId != null ? widgetUserMappingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WidgetUserMapping)) {
            return false;
        }
        WidgetUserMapping other = (WidgetUserMapping) object;
        if ((this.widgetUserMappingId == null && other.widgetUserMappingId != null) || (this.widgetUserMappingId != null && !this.widgetUserMappingId.equals(other.widgetUserMappingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.WidgetUserMapping[ widgetUserMappingId=" + widgetUserMappingId + " ]";
    }
    
}
