/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "tblQuery")
@NamedQueries({
    @NamedQuery(name = "TblQuery.findAll", query = "SELECT t FROM TblQuery t"),
    @NamedQuery(name = "TblQuery.countQueryUnAnswer", query = "SELECT COUNT(t) FROM TblQuery t WHERE t.queryAnswer IS NULL"),
    @NamedQuery(name = "TblQuery.findByQueryID", query = "SELECT t FROM TblQuery t WHERE t.queryID = :queryID"),
    @NamedQuery(name = "TblQuery.findNewQuery", query = "SELECT t FROM TblQuery t WHERE t.queryAnswer IS NULL"),
    @NamedQuery(name = "TblQuery.findByDateAnswer", query = "SELECT t FROM TblQuery t WHERE t.dateAnswer = :dateAnswer"),
    @NamedQuery(name = "TblQuery.findByDateCreate", query = "SELECT t FROM TblQuery t WHERE t.dateCreate = :dateCreate"),
    @NamedQuery(name = "TblQuery.findByQueryAnswer", query = "SELECT t FROM TblQuery t WHERE t.queryAnswer = :queryAnswer"),
    @NamedQuery(name = "TblQuery.findByQueryContent", query = "SELECT t FROM TblQuery t WHERE t.queryContent = :queryContent")})
public class TblQuery implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "QueryID")
    private Integer queryID;
    @Column(name = "DateAnswer")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAnswer;
    @Column(name = "DateCreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    @Column(name = "QueryAnswer")
    private String queryAnswer;
    @Column(name = "QueryContent")
    private String queryContent;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private TblUser userID;

    public TblQuery() {
    }

    public TblQuery(Integer queryID) {
        this.queryID = queryID;
    }

    public Integer getQueryID() {
        return queryID;
    }

    public void setQueryID(Integer queryID) {
        this.queryID = queryID;
    }

    public Date getDateAnswer() {
        return dateAnswer;
    }

    public void setDateAnswer(Date dateAnswer) {
        this.dateAnswer = dateAnswer;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getQueryAnswer() {
        return queryAnswer;
    }

    public void setQueryAnswer(String queryAnswer) {
        this.queryAnswer = queryAnswer;
    }

    public String getQueryContent() {
        return queryContent;
    }

    public void setQueryContent(String queryContent) {
        this.queryContent = queryContent;
    }

    public TblUser getUserID() {
        return userID;
    }

    public void setUserID(TblUser userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (queryID != null ? queryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblQuery)) {
            return false;
        }
        TblQuery other = (TblQuery) object;
        if ((this.queryID == null && other.queryID != null) || (this.queryID != null && !this.queryID.equals(other.queryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.entity.TblQuery[queryID=" + queryID + "]";
    }

}
