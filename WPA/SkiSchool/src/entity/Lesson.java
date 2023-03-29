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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "LESSON", catalog = "", schema = "ROOT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lesson.findAll", query = "SELECT l FROM Lesson l"),
    @NamedQuery(name = "Lesson.findByIdLesson", query = "SELECT l FROM Lesson l WHERE l.idLesson = :idLesson"),
    @NamedQuery(name = "Lesson.findByGroupPriv", query = "SELECT l FROM Lesson l WHERE l.groupPriv = :groupPriv"),
    @NamedQuery(name = "Lesson.findByGrown", query = "SELECT l FROM Lesson l WHERE l.grown = :grown"),
    @NamedQuery(name = "Lesson.findByLevel", query = "SELECT l FROM Lesson l WHERE l.level = :level"),
    @NamedQuery(name = "Lesson.findByTime", query = "SELECT l FROM Lesson l WHERE l.time = :time")})
public class Lesson implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LESSON")
    private Integer idLesson;
    @Size(max = 5)
    @Column(name = "GROUP_PRIV")
    private String groupPriv;
    @Size(max = 5)
    @Column(name = "GROWN")
    private String grown;
    @Size(max = 1)
    @Column(name = "LEVEL")
    private String level;
    @Size(max = 1)
    @Column(name = "TIME")
    private String time;
    @JoinColumn(name = "FK_RES", referencedColumnName = "ID_RES", insertable=false, updatable = false)
//    @ManyToOne(optional = false)
    @ManyToOne(optional = true)
    private Reservation fkRes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkLesson")
    private Collection<Reservation> reservationCollection;

    public Lesson() {
    }

    public Lesson(Integer idLesson) {
        this.idLesson = idLesson;
    }

    public Integer getIdLesson() {
        return idLesson;
    }

    public void setIdLesson(Integer idLesson) {
        this.idLesson = idLesson;
    }

    public String getGroupPriv() {
        return groupPriv;
    }

    public void setGroupPriv(String groupPriv) {
        this.groupPriv = groupPriv;
    }

    public String getGrown() {
        return grown;
    }

    public void setGrown(String grown) {
        this.grown = grown;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Reservation getFkRes() {
        return fkRes;
    }

    public void setFkRes(Reservation fkRes) {
        this.fkRes = fkRes;
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
        hash += (idLesson != null ? idLesson.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lesson)) {
            return false;
        }
        Lesson other = (Lesson) object;
        if ((this.idLesson == null && other.idLesson != null) || (this.idLesson != null && !this.idLesson.equals(other.idLesson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Lesson[ idLesson=" + idLesson + " ]";
    }
    
}
