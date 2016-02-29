/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean.entity;

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

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "tblVote")
@NamedQueries({
    @NamedQuery(name = "TblVote.findAll", query = "SELECT t FROM TblVote t"),
    @NamedQuery(name = "TblVote.findById", query = "SELECT t FROM TblVote t WHERE t.id = :id"),
    @NamedQuery(name = "TblVote.findByVoteCount", query = "SELECT t FROM TblVote t WHERE t.voteCount = :voteCount"),
    @NamedQuery(name = "TblVote.findByVote", query = "SELECT t FROM TblVote t WHERE t.vote = :vote")})
public class TblVote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "VoteCount")
    private Integer voteCount;
    @Column(name = "Vote")
    private Double vote;
    @JoinColumn(name = "ImageID", referencedColumnName = "ImageID")
    @ManyToOne(optional = false)
    private TblImage imageID;

    public TblVote() {
    }

    public TblVote(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Double getVote() {
        return vote;
    }

    public void setVote(Double vote) {
        this.vote = vote;
    }

    public TblImage getImageID() {
        return imageID;
    }

    public void setImageID(TblImage imageID) {
        this.imageID = imageID;
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
        if (!(object instanceof TblVote)) {
            return false;
        }
        TblVote other = (TblVote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.entity.TblVote[id=" + id + "]";
    }

}
