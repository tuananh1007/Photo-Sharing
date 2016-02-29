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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author bkc
 */
@Entity
@Table(name = "tblComment")
@NamedQueries({
    @NamedQuery(name = "TblComment.findAll", query = "SELECT t FROM TblComment t"),
    @NamedQuery(name = "TblComment.deleteComment", query = "DELETE FROM TblComment t WHERE t.commentID = ?1"),
    @NamedQuery(name = "TblComment.findByCommentID", query = "SELECT t FROM TblComment t WHERE t.commentID = :commentID"),
    @NamedQuery(name = "TblComment.findByCommentTitle", query = "SELECT t FROM TblComment t WHERE t.commentTitle = :commentTitle"),
    @NamedQuery(name = "TblComment.findByImage",query="SELECT t FROM TblComment t WHERE t.imageID = ?1" ),
    @NamedQuery(name = "TblComment.findByCommentTimeCreate", query = "SELECT t FROM TblComment t WHERE t.commentTimeCreate = :commentTimeCreate")})
public class TblComment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CommentID")
    private Integer commentID;
    @Column(name = "CommentTitle")
    private String commentTitle;
    @Lob
    @Column(name = "CommentContent")
    private String commentContent;
    @Column(name = "CommentTimeCreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentTimeCreate;
    @JoinColumn(name = "ImageID", referencedColumnName = "ImageID")
    @ManyToOne(optional = false)
    private TblImage imageID;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private TblUser userID;

    public TblComment() {
    }

    public TblComment(Integer commentID) {
        this.commentID = commentID;
    }

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
    }

    public String getCommentTitle() {
        return commentTitle;
    }

    public void setCommentTitle(String commentTitle) {
        this.commentTitle = commentTitle;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentTimeCreate() {
        return commentTimeCreate;
    }

    public void setCommentTimeCreate(Date commentTimeCreate) {
        this.commentTimeCreate = commentTimeCreate;
    }

    public TblImage getImageID() {
        return imageID;
    }

    public void setImageID(TblImage imageID) {
        this.imageID = imageID;
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
        hash += (commentID != null ? commentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblComment)) {
            return false;
        }
        TblComment other = (TblComment) object;
        if ((this.commentID == null && other.commentID != null) || (this.commentID != null && !this.commentID.equals(other.commentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.entity.TblComment[commentID=" + commentID + "]";
    }

}
