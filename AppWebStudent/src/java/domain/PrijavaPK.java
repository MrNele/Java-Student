/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Nemanja
 */
@Embeddable
public class PrijavaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "brojIndeksa")
    private String brojIndeksa;
    @Basic(optional = false)
    @Column(name = "sifraPredmeta")
    private String sifraPredmeta;
    @Basic(optional = false)
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;

    public PrijavaPK() {
    }

    public PrijavaPK(String brojIndeksa, String sifraPredmeta, Date datum) {
        this.brojIndeksa = brojIndeksa;
        this.sifraPredmeta = sifraPredmeta;
        this.datum = datum;
    }

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public String getSifraPredmeta() {
        return sifraPredmeta;
    }

    public void setSifraPredmeta(String sifraPredmeta) {
        this.sifraPredmeta = sifraPredmeta;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (brojIndeksa != null ? brojIndeksa.hashCode() : 0);
        hash += (sifraPredmeta != null ? sifraPredmeta.hashCode() : 0);
        hash += (datum != null ? datum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrijavaPK)) {
            return false;
        }
        PrijavaPK other = (PrijavaPK) object;
        if ((this.brojIndeksa == null && other.brojIndeksa != null) || (this.brojIndeksa != null && !this.brojIndeksa.equals(other.brojIndeksa))) {
            return false;
        }
        if ((this.sifraPredmeta == null && other.sifraPredmeta != null) || (this.sifraPredmeta != null && !this.sifraPredmeta.equals(other.sifraPredmeta))) {
            return false;
        }
        if ((this.datum == null && other.datum != null) || (this.datum != null && !this.datum.equals(other.datum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.PrijavaPK[ brojIndeksa=" + brojIndeksa + ", sifraPredmeta=" + sifraPredmeta + ", datum=" + datum + " ]";
    }
    
}
