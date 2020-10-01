/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nemanja
 */
@Entity
@Table(name = "predmet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Predmet.findAll", query = "SELECT p FROM Predmet p")
    , @NamedQuery(name = "Predmet.findBySifra", query = "SELECT p FROM Predmet p WHERE p.sifra = :sifra")
    , @NamedQuery(name = "Predmet.findByNaziv", query = "SELECT p FROM Predmet p WHERE p.naziv = :naziv")
    , @NamedQuery(name = "Predmet.findByBrojESPB", query = "SELECT p FROM Predmet p WHERE p.brojESPB = :brojESPB")})
public class Predmet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "sifra")
    private String sifra;
    @Column(name = "naziv")
    private String naziv;
    @Column(name = "brojESPB")
    private Integer brojESPB;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "predmet")
    private List<Prijava> prijavaList;

    public Predmet() {
    }

    public Predmet(String sifra) {
        this.sifra = sifra;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getBrojESPB() {
        return brojESPB;
    }

    public void setBrojESPB(Integer brojESPB) {
        this.brojESPB = brojESPB;
    }

    @XmlTransient
    public List<Prijava> getPrijavaList() {
        return prijavaList;
    }

    public void setPrijavaList(List<Prijava> prijavaList) {
        this.prijavaList = prijavaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sifra != null ? sifra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Predmet)) {
            return false;
        }
        Predmet other = (Predmet) object;
        if ((this.sifra == null && other.sifra != null) || (this.sifra != null && !this.sifra.equals(other.sifra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Predmet[ sifra=" + sifra + " ]";
    }
    
}
