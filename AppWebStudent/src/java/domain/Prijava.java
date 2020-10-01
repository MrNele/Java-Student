/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nemanja
 */
@Entity
@Table(name = "prijava")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prijava.findAll", query = "SELECT p FROM Prijava p")
    , @NamedQuery(name = "Prijava.findByBrojIndeksa", query = "SELECT p FROM Prijava p WHERE p.prijavaPK.brojIndeksa = :brojIndeksa")
    , @NamedQuery(name = "Prijava.findBySifraPredmeta", query = "SELECT p FROM Prijava p WHERE p.prijavaPK.sifraPredmeta = :sifraPredmeta")
    , @NamedQuery(name = "Prijava.findByDatum", query = "SELECT p FROM Prijava p WHERE p.prijavaPK.datum = :datum")
    , @NamedQuery(name = "Prijava.findByOcena", query = "SELECT p FROM Prijava p WHERE p.ocena = :ocena")})
public class Prijava implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrijavaPK prijavaPK;
    @Column(name = "ocena")
    private Integer ocena;
    @JoinColumn(name = "brojIndeksa", referencedColumnName = "brojIndeksa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;
    @JoinColumn(name = "sifraPredmeta", referencedColumnName = "sifra", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Predmet predmet;

    public Prijava() {
    }

    public Prijava(PrijavaPK prijavaPK) {
        this.prijavaPK = prijavaPK;
    }

    public Prijava(String brojIndeksa, String sifraPredmeta, Date datum) {
        this.prijavaPK = new PrijavaPK(brojIndeksa, sifraPredmeta, datum);
    }

    public PrijavaPK getPrijavaPK() {
        return prijavaPK;
    }

    public void setPrijavaPK(PrijavaPK prijavaPK) {
        this.prijavaPK = prijavaPK;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prijavaPK != null ? prijavaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prijava)) {
            return false;
        }
        Prijava other = (Prijava) object;
        if ((this.prijavaPK == null && other.prijavaPK != null) || (this.prijavaPK != null && !this.prijavaPK.equals(other.prijavaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Prijava[ prijavaPK=" + prijavaPK + " ]";
    }
    
}
