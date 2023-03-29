/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ludvik
 */
@Entity
@Table(name = "PERSON", catalog = "", schema = "ROOT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByIdPerson", query = "SELECT p FROM Person p WHERE p.idPerson = :idPerson"),
    @NamedQuery(name = "Person.findByName", query = "SELECT p FROM Person p WHERE p.name = :name"),
    @NamedQuery(name = "Person.findBySurname", query = "SELECT p FROM Person p WHERE p.surname = :surname"),
    @NamedQuery(name = "Person.findByEmail", query = "SELECT p FROM Person p WHERE p.email = :email"),
    @NamedQuery(name = "Person.findByTelephone", query = "SELECT p FROM Person p WHERE p.telephone = :telephone"),
    @NamedQuery(name = "Person.findBySkiSnb", query = "SELECT p FROM Person p WHERE p.skiSnb = :skiSnb"),
    @NamedQuery(name = "Person.findByTyp", query = "SELECT p FROM Person p WHERE p.typ = :typ"),
    @NamedQuery(name = "Person.findByLicence", query = "SELECT p FROM Person p WHERE p.licence = :licence")})
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERSON")
    private Integer idPerson;
    @Size(max = 30)
    @Column(name = "NAME")
    private String name;
    @Size(max = 30)
    @Column(name = "SURNAME")
    private String surname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "TELEPHONE")
    private Integer telephone;
    @Size(max = 6)
    @Column(name = "SKI_SNB")
    private String skiSnb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "TYP")
    private String typ;
    @Column(name = "LICENCE")
    private Integer licence;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPlanClient")
    private Collection<Plan> planCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPlanIns")
    private Collection<Plan> planCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkResClient")
    private Collection<Reservation> reservationCollection;

    public Person() {
    }

    public Person(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public Person(Integer idPerson, String typ) {
        this.idPerson = idPerson;
        this.typ = typ;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getSkiSnb() {
        return skiSnb;
    }

    public void setSkiSnb(String skiSnb) {
        this.skiSnb = skiSnb;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Integer getLicence() {
        return licence;
    }

    public void setLicence(Integer licence) {
        this.licence = licence;
    }

    @XmlTransient
    public Collection<Plan> getPlanCollection() {
        return planCollection;
    }

    public void setPlanCollection(Collection<Plan> planCollection) {
        this.planCollection = planCollection;
    }

    @XmlTransient
    public Collection<Plan> getPlanCollection1() {
        return planCollection1;
    }

    public void setPlanCollection1(Collection<Plan> planCollection1) {
        this.planCollection1 = planCollection1;
    }

    @XmlTransient
    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerson != null ? idPerson.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.idPerson == null && other.idPerson != null) || (this.idPerson != null && !this.idPerson.equals(other.idPerson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Person[ idPerson=" + idPerson + " ]";
    }
    
}
