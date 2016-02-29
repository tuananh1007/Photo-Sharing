/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "tblUser")
@NamedQueries({
    @NamedQuery(name = "TblUser.findAll", query = "SELECT t FROM TblUser t"),
    @NamedQuery(name = "TblUser.deleteUser", query = "DELETE FROM TblUser t WHERE t.userID = ?1"),
    @NamedQuery(name = "TblUser.countValidatedAccount", query = "SELECT COUNT(t) FROM TblUser t WHERE t.isApproved = 1"),
    @NamedQuery(name = "TblUser.countAccountWithEmail", query = "SELECT COUNT(t) FROM TblUser t WHERE t.email = ?1"),
    @NamedQuery(name = "TblUser.userNotApprove", query = "SELECT t FROM TblUser t WHERE t.isApproved = 0"),
    @NamedQuery(name =  "TblUser.newUser",query="SELECT t FROM TblUser t WHERE t.isApproved=1 ORDER BY t.dateRegistration DESC"),
    @NamedQuery(name = "TblUser.UserLogin", query = "SELECT COUNT(t) FROM TblUser t WHERE t.userID = ?1 AND t.passWord = ?2"),
    @NamedQuery(name = "TblUser.findByUserID", query = "SELECT t FROM TblUser t WHERE t.userID = :userID"),
    @NamedQuery(name = "TblUser.findByUserFullName", query = "SELECT t FROM TblUser t WHERE t.userFullName = :userFullName"),
    @NamedQuery(name = "TblUser.findByPassWord", query = "SELECT t FROM TblUser t WHERE t.passWord = :passWord"),
    @NamedQuery(name = "TblUser.findByGender", query = "SELECT t FROM TblUser t WHERE t.gender = :gender"),
    @NamedQuery(name = "TblUser.findByBirthday", query = "SELECT t FROM TblUser t WHERE t.birthday = :birthday"),
    @NamedQuery(name = "TblUser.findByEmail", query = "SELECT t FROM TblUser t WHERE t.email = :email"),
    @NamedQuery(name = "TblUser.findByUserAvatar", query = "SELECT t FROM TblUser t WHERE t.userAvatar = :userAvatar"),
    @NamedQuery(name = "TblUser.findByDateRegistration", query = "SELECT t FROM TblUser t WHERE t.dateRegistration = :dateRegistration"),
    @NamedQuery(name = "TblUser.findByIsApproved", query = "SELECT t FROM TblUser t WHERE t.isApproved = :isApproved")})
public class TblUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UserID")
    private String userID;
    @Column(name = "UserFullName")
    private String userFullName;
    @Column(name = "PassWord")
    private String passWord;
    @Column(name = "Gender")
    private Boolean gender;
    @Column(name = "Birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @Column(name = "Email")
    private String email;
    @Column(name = "UserAvatar")
    private String userAvatar;
    @Column(name = "DateRegistration")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistration;
    @Column(name = "isApproved")
    private Boolean isApproved;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID")
    private Collection<TblComment> tblCommentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID")
    private Collection<TblImage> tblImageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID")
    private Collection<TblQuery> tblQueryCollection;

    public TblUser() {
    }

    public TblUser(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public Date getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(Date dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public Collection<TblComment> getTblCommentCollection() {
        return tblCommentCollection;
    }

    public void setTblCommentCollection(Collection<TblComment> tblCommentCollection) {
        this.tblCommentCollection = tblCommentCollection;
    }

    public Collection<TblImage> getTblImageCollection() {
        return tblImageCollection;
    }

    public void setTblImageCollection(Collection<TblImage> tblImageCollection) {
        this.tblImageCollection = tblImageCollection;
    }

    public Collection<TblQuery> getTblQueryCollection() {
        return tblQueryCollection;
    }

    public void setTblQueryCollection(Collection<TblQuery> tblQueryCollection) {
        this.tblQueryCollection = tblQueryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblUser)) {
            return false;
        }
        TblUser other = (TblUser) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.entity.TblUser[userID=" + userID + "]";
    }

}
