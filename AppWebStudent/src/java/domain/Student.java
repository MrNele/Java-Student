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
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findByBrojIndeksa", query = "SELECT s FROM Student s WHERE s.brojIndeksa = :brojIndeksa")
    , @NamedQuery(name = "Student.findByIme", query = "SELECT s FROM Student s WHERE s.ime = :ime")
    , @NamedQuery(name = "Student.findByPrezime", query = "SELECT s FROM Student s WHERE s.prezime = :prezime")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "brojIndeksa")
    private String brojIndeksa;
    @Column(name = "ime")
    private String ime;
    @Column(name = "prezime")
    private String prezime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Prijava> prijavaList;

    public Student() {
    }

    public Student(String brojIndeksa, String ime, String prezime) {
        this.brojIndeksa = brojIndeksa;
        this.ime = ime;
        this.prezime = prezime;
    }
    
    

    public Student(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
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
        hash += (brojIndeksa != null ? brojIndeksa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.brojIndeksa == null && other.brojIndeksa != null) || (this.brojIndeksa != null && !this.brojIndeksa.equals(other.brojIndeksa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Student[ brojIndeksa=" + brojIndeksa + " ]";
    }
    
}
