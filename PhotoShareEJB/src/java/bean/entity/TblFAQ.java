/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean.entity;

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

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "tblFAQ")
@NamedQueries({
    @NamedQuery(name = "TblFAQ.findAll", query = "SELECT t FROM TblFAQ t"),
    @NamedQuery(name = "TblFAQ.findByFaqid", query = "SELECT t FROM TblFAQ t WHERE t.faqid = :faqid"),
    @NamedQuery(name = "TblFAQ.findByFAQQuestion", query = "SELECT t FROM TblFAQ t WHERE t.fAQQuestion = :fAQQuestion"),
    @NamedQuery(name = "TblFAQ.findByFAQAnswer", query = "SELECT t FROM TblFAQ t WHERE t.fAQAnswer = :fAQAnswer")})
public class TblFAQ implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FAQID")
    private Integer faqid;
    @Column(name = "FAQQuestion")
    private String fAQQuestion;
    @Column(name = "FAQAnswer")
    private String fAQAnswer;

    public TblFAQ() {
    }

    public TblFAQ(Integer faqid) {
        this.faqid = faqid;
    }

    public Integer getFaqid() {
        return faqid;
    }

    public void setFaqid(Integer faqid) {
        this.faqid = faqid;
    }

    public String getFAQQuestion() {
        return fAQQuestion;
    }

    public void setFAQQuestion(String fAQQuestion) {
        this.fAQQuestion = fAQQuestion;
    }

    public String getFAQAnswer() {
        return fAQAnswer;
    }

    public void setFAQAnswer(String fAQAnswer) {
        this.fAQAnswer = fAQAnswer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (faqid != null ? faqid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblFAQ)) {
            return false;
        }
        TblFAQ other = (TblFAQ) object;
        if ((this.faqid == null && other.faqid != null) || (this.faqid != null && !this.faqid.equals(other.faqid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.entity.TblFAQ[faqid=" + faqid + "]";
    }

}
