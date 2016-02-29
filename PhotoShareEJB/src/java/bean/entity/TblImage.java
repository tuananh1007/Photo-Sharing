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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tblImage")
@NamedQueries({
    @NamedQuery(name = "TblImage.findAll", query = "SELECT t FROM TblImage t WHERE t.isShared = 1 ORDER BY t.timeUpload DESC"),
    @NamedQuery(name = "TblImage.findByImageID", query = "SELECT t FROM TblImage t WHERE t.isShared = 1 AND t.imageID = :imageID"),
    @NamedQuery(name = "TblImage.findByImageName", query = "SELECT t FROM TblImage t WHERE t.imageName LIKE ?1"),
    @NamedQuery(name = "TblImage.deleteImage", query= "DELETE FROM TblImage t WHERE t.imageID =?1"),
    @NamedQuery(name = "TblImage.topDownload", query = "SELECT t FROM TblImage t ORDER BY t.downloadCount DESC"),
    @NamedQuery(name = "TblImage.findByImageNameNotRange", query = "SELECT COUNT(t) FROM TblImage t WHERE t.imageName LIKE ?1"),
    @NamedQuery(name = "TblImage.countImageByUser", query = "SELECT COUNT(t) FROM TblImage t WHERE t.userID = ?1"),
    @NamedQuery(name = "TblImage.findByImageLocation", query = "SELECT t FROM TblImage t WHERE t.imageLocation = :imageLocation"),
    @NamedQuery(name = "TblImage.findByViewCount", query = "SELECT t FROM TblImage t WHERE t.viewCount = :viewCount"),
    @NamedQuery(name = "TblImage.findByDownloadCount", query = "SELECT t FROM TblImage t WHERE t.downloadCount = :downloadCount"),
    @NamedQuery(name = "TblImage.findByIsShared", query = "SELECT t FROM TblImage t WHERE t.isShared = :isShared"),
    @NamedQuery(name = "TblImage.findbyUserName", query= "SELECT t FROM TblImage t WHERE t.userID =?1"),
    @NamedQuery(name = "TblImage.findByTimeUpload", query = "SELECT t FROM TblImage t WHERE t.timeUpload = :timeUpload")})
public class TblImage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ImageID")
    private Integer imageID;
    @Column(name = "ImageName")
    private String imageName;
    @Column(name = "ImageLocation")
    private String imageLocation;
    @Column(name = "ViewCount")
    private Integer viewCount;
    @Column(name = "DownloadCount")
    private Integer downloadCount;
    @Column(name = "IsShared")
    private Boolean isShared;
    @Column(name = "TimeUpload")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeUpload;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imageID")
    private Collection<TblComment> tblCommentCollection;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private TblUser userID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imageID")
    private Collection<TblVote> tblVoteCollection;

    public TblImage() {
    }

    public TblImage(Integer imageID) {
        this.imageID = imageID;
    }

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Boolean getIsShared() {
        return isShared;
    }

    public void setIsShared(Boolean isShared) {
        this.isShared = isShared;
    }

    public Date getTimeUpload() {
        return timeUpload;
    }

    public void setTimeUpload(Date timeUpload) {
        this.timeUpload = timeUpload;
    }

    public Collection<TblComment> getTblCommentCollection() {
        return tblCommentCollection;
    }

    public void setTblCommentCollection(Collection<TblComment> tblCommentCollection) {
        this.tblCommentCollection = tblCommentCollection;
    }

    public TblUser getUserID() {
        return userID;
    }

    public void setUserID(TblUser userID) {
        this.userID = userID;
    }

    public Collection<TblVote> getTblVoteCollection() {
        return tblVoteCollection;
    }

    public void setTblVoteCollection(Collection<TblVote> tblVoteCollection) {
        this.tblVoteCollection = tblVoteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imageID != null ? imageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblImage)) {
            return false;
        }
        TblImage other = (TblImage) object;
        if ((this.imageID == null && other.imageID != null) || (this.imageID != null && !this.imageID.equals(other.imageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.entity.TblImage[imageID=" + imageID + "]";
    }

}
