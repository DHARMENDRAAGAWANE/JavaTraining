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
@Table(name = "payment_mode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentMode.findAll", query = "SELECT p FROM PaymentMode p"),
    @NamedQuery(name = "PaymentMode.findByPaymentModeId", query = "SELECT p FROM PaymentMode p WHERE p.paymentModeId = :paymentModeId"),
    @NamedQuery(name = "PaymentMode.findByPaymentModeName", query = "SELECT p FROM PaymentMode p WHERE p.paymentModeName = :paymentModeName"),
    @NamedQuery(name = "PaymentMode.findByIsActive", query = "SELECT p FROM PaymentMode p WHERE p.isActive = :isActive")})
public class PaymentMode implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "payment_mode_id")
    private Integer paymentModeId;
    @Basic(optional = false)
    @Column(name = "payment_mode_name")
    private String paymentModeName;
    @Basic(optional = false)
    @Column(name = "is_active")
    private Character isActive;
    @OneToMany(mappedBy = "paymentModeId")
    private List<InvoicePayment> invoicePaymentList;
    @OneToMany(mappedBy = "paymentModeId")
    private List<BillPayment> billPaymentList;
    @OneToMany(mappedBy = "paymentModeId")
    private List<PayRequest> payRequestList;

    public PaymentMode() {
    }

    public PaymentMode(Integer paymentModeId) {
        this.paymentModeId = paymentModeId;
    }

    public PaymentMode(Integer paymentModeId, String paymentModeName, Character isActive) {
        this.paymentModeId = paymentModeId;
        this.paymentModeName = paymentModeName;
        this.isActive = isActive;
    }

    public Integer getPaymentModeId() {
        return paymentModeId;
    }

    public void setPaymentModeId(Integer paymentModeId) {
        this.paymentModeId = paymentModeId;
    }

    public String getPaymentModeName() {
        return paymentModeName;
    }

    public void setPaymentModeName(String paymentModeName) {
        this.paymentModeName = paymentModeName;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<InvoicePayment> getInvoicePaymentList() {
        return invoicePaymentList;
    }

    public void setInvoicePaymentList(List<InvoicePayment> invoicePaymentList) {
        this.invoicePaymentList = invoicePaymentList;
    }

    @XmlTransient
    public List<BillPayment> getBillPaymentList() {
        return billPaymentList;
    }

    public void setBillPaymentList(List<BillPayment> billPaymentList) {
        this.billPaymentList = billPaymentList;
    }

    @XmlTransient
    public List<PayRequest> getPayRequestList() {
        return payRequestList;
    }

    public void setPayRequestList(List<PayRequest> payRequestList) {
        this.payRequestList = payRequestList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentModeId != null ? paymentModeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentMode)) {
            return false;
        }
        PaymentMode other = (PaymentMode) object;
        if ((this.paymentModeId == null && other.paymentModeId != null) || (this.paymentModeId != null && !this.paymentModeId.equals(other.paymentModeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mt.unmaze.entity.PaymentMode[ paymentModeId=" + paymentModeId + " ]";
    }
    
}
