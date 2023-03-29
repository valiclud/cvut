/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ludvik
 */
@Entity
@Table(name = "RESERVATION", catalog = "", schema = "ROOT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r"),
    @NamedQuery(name = "Reservation.findByIdRes", query = "SELECT r FROM Reservation r WHERE r.idRes = :idRes"),
    @NamedQuery(name = "Reservation.findByDate", query = "SELECT r FROM Reservation r WHERE r.date = :date"),
    @NamedQuery(name = "Reservation.findByFromDate", query = "SELECT r FROM Reservation r WHERE r.fromDate = :fromDate"),
    @NamedQuery(name = "Reservation.findByToDate", query = "SELECT r FROM Reservation r WHERE r.toDate = :toDate")})
public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_RES")
    private Integer idRes;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "FROM_DATE")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Column(name = "TO_DATE")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkRes")
    private Collection<Lesson> lessonCollection;
    @JoinColumn(name = "FK_RES_CLIENT", referencedColumnName = "ID_PERSON", insertable=true, updatable = false)
    @ManyToOne(optional = false)
    private Person fkResClient;
    @JoinColumn(name = "FK_LESSON", referencedColumnName = "ID_LESSON", insertable=true, updatable=false)
    @ManyToOne(optional = false)
    private Lesson fkLesson;

    public Reservation() {
    }

    public Reservation(Integer idRes) {
        this.idRes = idRes;
    }

    public Integer getIdRes() {
        return idRes;
    }

    public void setIdRes(Integer idRes) {
        this.idRes = idRes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    @XmlTransient
    public Collection<Lesson> getLessonCollection() {
        return lessonCollection;
    }

    public void setLessonCollection(Collection<Lesson> lessonCollection) {
        this.lessonCollection = lessonCollection;
    }

    public Person getFkResClient() {
        return fkResClient;
    }

    public void setFkResClient(Person fkResClient) {
        this.fkResClient = fkResClient;
    }

    public Lesson getFkLesson() {
        return fkLesson;
    }

    public void setFkLesson(Lesson fkLesson) {
        this.fkLesson = fkLesson;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRes != null ? idRes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.idRes == null && other.idRes != null) || (this.idRes != null && !this.idRes.equals(other.idRes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Reservation[ idRes=" + idRes + " ]";
    }
    
}
