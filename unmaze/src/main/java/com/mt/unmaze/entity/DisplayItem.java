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
@Table(name = "display_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DisplayItem.findAll", query = "SELECT d FROM DisplayItem d"),
    @NamedQuery(name = "DisplayItem.findByDisplayItemId", query = "SELECT d FROM DisplayItem d WHERE d.displayItemId = :displayItemId"),
    @NamedQuery(name = "DisplayItem.findByDisplayItemName", query = "SELECT d FROM DisplayItem d WHERE d.displayItemName = :displayItemName"),
    @NamedQuery(name = "DisplayItem.findByIsActive", query = "SELECT d FROM DisplayItem d WHERE d.isActive = :isActive")})
public class DisplayItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "display_item_id")
    private Integer displayItemId;
    @Basic(optional = false)
    @Column(name = "display_item_name")
    private String displayItemName;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "displayItemId")
    private List<AccountGroupMaster> accountGroupMasterList;

    public DisplayItem() {
    }

    public DisplayItem(Integer displayItemId) {
        this.displayItemId = displayItemId;
    }

    public DisplayItem(Integer displayItemId, String displayItemName, Character isActive) {
        this.displayItemId = displayItemId;
        this.displayItemName = displayItemName;
        this.isActive = isActive;
    }

    public Integer getDisplayItemId() {
        return displayItemId;
    }

    public void setDisplayItemId(Integer displayItemId) {
        this.displayItemId = displayItemId;
    }

    public String getDisplayItemName() {
        return displayItemName;
    }

    public void setDisplayItemName(String displayItemName) {
        this.displayItemName = displayItemName;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<AccountGroupMaster> getAccountGroupMasterList() {
        return accountGroupMasterList;
    }

    public void setAccountGroupMasterList(List<AccountGroupMaster> accountGroupMasterList) {
        this.accountGroupMasterList = accountGroupMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (displayItemId != null ? displayItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisplayItem)) {
            return false;
        }
        DisplayItem other = (DisplayItem) object;
        if ((this.displayItemId == null && other.displayItemId != null) || (this.displayItemId != null && !this.displayItemId.equals(other.displayItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.DisplayItem[ displayItemId=" + displayItemId + " ]";
    }
    
}
