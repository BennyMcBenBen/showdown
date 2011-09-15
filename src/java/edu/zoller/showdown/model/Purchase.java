/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.zoller.showdown.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;

/**
 * Purchase POJO
 * @author Ben Zoller
 */
public class Purchase {

    private CreditCardType creditCardType;
    private String creditCardPostfix;
    private Calendar creditCardExpiration;
    private String billingName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private Collection<Dvd> dvds;

    public Purchase(CreditCardType creditCardType, String creditCardPostfix,
            Calendar creditCardExpiration, String billingName, String address,
            String city, String state, String zip, Collection<Dvd> dvds) {
        this.creditCardType = creditCardType;
        this.creditCardPostfix = creditCardPostfix;
        this.creditCardExpiration = creditCardExpiration;
        this.billingName = billingName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.dvds = dvds;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBillingName() {
        return billingName;
    }

    public void setBillingName(String billingName) {
        this.billingName = billingName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Calendar getCreditCardExpiration() {
        return creditCardExpiration;
    }

    public void setCreditCardExpiration(Calendar creditCardExpiration) {
        this.creditCardExpiration = creditCardExpiration;
    }

    public String getCreditCardPostfix() {
        return creditCardPostfix;
    }

    public void setCreditCardPostfix(String creditCardPostfix) {
        this.creditCardPostfix = creditCardPostfix;
    }

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Collection<Dvd> getDvds() {
        return dvds;
    }

    public void setDvds(Collection<Dvd> dvds) {
        this.dvds = dvds;
    }

    public BigDecimal getTotal() {
        BigDecimal total = new BigDecimal(0);
        for (Dvd dvd : dvds) {
            total.add(dvd.getPrice());
        }
        return total;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Purchase other = (Purchase) obj;
        if (this.creditCardType != other.creditCardType) {
            return false;
        }
        if ((this.creditCardPostfix == null) ? (other.creditCardPostfix != null) : !this.creditCardPostfix.equals(other.creditCardPostfix)) {
            return false;
        }
        if ((this.creditCardExpiration == null) ? (other.creditCardExpiration != null) : !this.creditCardExpiration.equals(other.creditCardExpiration)) {
            return false;
        }
        if ((this.billingName == null) ? (other.billingName != null) : !this.billingName.equals(other.billingName)) {
            return false;
        }
        if ((this.address == null) ? (other.address != null) : !this.address.equals(other.address)) {
            return false;
        }
        if ((this.city == null) ? (other.city != null) : !this.city.equals(other.city)) {
            return false;
        }
        if ((this.state == null) ? (other.state != null) : !this.state.equals(other.state)) {
            return false;
        }
        if ((this.zip == null) ? (other.zip != null) : !this.zip.equals(other.zip)) {
            return false;
        }
        if (this.dvds != other.dvds && (this.dvds == null || !this.dvds.equals(other.dvds))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.creditCardType.hashCode();
        hash = 61 * hash + (this.creditCardPostfix != null ? this.creditCardPostfix.hashCode() : 0);
        hash = 61 * hash + (this.creditCardExpiration != null ? this.creditCardExpiration.hashCode() : 0);
        hash = 61 * hash + (this.billingName != null ? this.billingName.hashCode() : 0);
        hash = 61 * hash + (this.address != null ? this.address.hashCode() : 0);
        hash = 61 * hash + (this.city != null ? this.city.hashCode() : 0);
        hash = 61 * hash + (this.state != null ? this.state.hashCode() : 0);
        hash = 61 * hash + (this.zip != null ? this.zip.hashCode() : 0);
        hash = 61 * hash + (this.dvds != null ? this.dvds.hashCode() : 0);
        return hash;
    }
}
