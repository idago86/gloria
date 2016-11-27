/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Israel Dago
 */
@Entity
@Table(name = "persoane")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersoanaDB.findAll", query = "SELECT p FROM PersoanaDB p")
    , @NamedQuery(name = "PersoanaDB.findById", query = "SELECT p FROM PersoanaDB p WHERE p.id = :id")
    , @NamedQuery(name = "PersoanaDB.findByNume", query = "SELECT p FROM PersoanaDB p WHERE p.nume = :nume")
    , @NamedQuery(name = "PersoanaDB.findByPrenume", query = "SELECT p FROM PersoanaDB p WHERE p.prenume = :prenume")
    , @NamedQuery(name = "PersoanaDB.findByCnp", query = "SELECT p FROM PersoanaDB p WHERE p.cnp = :cnp")})
public class PersoanaDB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nume")
    private String nume;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "prenume")
    private String prenume;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "cnp")
    private String cnp;

    public PersoanaDB() {
    }

    public PersoanaDB(Integer id) {
        this.id = id;
    }

    public PersoanaDB(Integer id, String nume, String prenume, String cnp) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersoanaDB)) {
            return false;
        }
        PersoanaDB other = (PersoanaDB) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.PersoanaDB[ id=" + id + " ]";
    }
    
}
