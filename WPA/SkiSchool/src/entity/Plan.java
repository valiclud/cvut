/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ludvik
 */
@Entity
@Table(name = "PLAN", catalog = "", schema = "ROOT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plan.findAll", query = "SELECT p FROM Plan p"),
    @NamedQuery(name = "Plan.findByIdPlan", query = "SELECT p FROM Plan p WHERE p.idPlan = :idPlan"),
    @NamedQuery(name = "Plan.findByPrice", query = "SELECT p FROM Plan p WHERE p.price = :price"),
    @NamedQuery(name = "Plan.findByProvision", query = "SELECT p FROM Plan p WHERE p.provision = :provision"),
    @NamedQuery(name = "Plan.findBySalary", query = "SELECT p FROM Plan p WHERE p.salary = :salary")})
public class Plan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PLAN")
    private Integer idPlan;
    @Column(name = "PRICE")
    private Integer price;
    @Column(name = "PROVISION")
    private Integer provision;
    @Column(name = "SALARY")
    private Integer salary;
    @JoinColumn(name = "FK_PLAN_CLIENT", referencedColumnName = "ID_PERSON", insertable=true, updatable = false)
    @ManyToOne(optional = false)
    private Person fkPlanClient;
    @JoinColumn(name = "FK_PLAN_INS", referencedColumnName = "ID_PERSON", insertable=true, updatable = false)
    @ManyToOne(optional = false)
    private Person fkPlanIns;

    public Plan() {
    }

    public Plan(Integer idPlan) {
        this.idPlan = idPlan;
    }

    public Integer getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Integer idPlan) {
        this.idPlan = idPlan;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getProvision() {
        return provision;
    }

    public void setProvision(Integer provision) {
        this.provision = provision;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Person getFkPlanClient() {
        return fkPlanClient;
    }

    public void setFkPlanClient(Person fkPlanClient) {
        this.fkPlanClient = fkPlanClient;
    }

    public Person getFkPlanIns() {
        return fkPlanIns;
    }

    public void setFkPlanIns(Person fkPlanIns) {
        this.fkPlanIns = fkPlanIns;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlan != null ? idPlan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plan)) {
            return false;
        }
        Plan other = (Plan) object;
        if ((this.idPlan == null && other.idPlan != null) || (this.idPlan != null && !this.idPlan.equals(other.idPlan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Plan[ idPlan=" + idPlan + " ]";
    }
    
}
