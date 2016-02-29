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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "tblAdmin")
@NamedQueries({
    @NamedQuery(name = "TblAdmin.findAll", query = "SELECT t FROM TblAdmin t"),
    @NamedQuery(name = "TblAdmin.adminLogin", query = "SELECT COUNT(t) FROM TblAdmin t WHERE t.adminID = ?1 AND t.adminPass = ?2"),
    @NamedQuery(name = "TblAdmin.findByAdminID", query = "SELECT t FROM TblAdmin t WHERE t.adminID = :adminID"),
    @NamedQuery(name = "TblAdmin.findByAdminLevel", query = "SELECT t FROM TblAdmin t WHERE t.adminLevel = :adminLevel"),
    @NamedQuery(name = "TblAdmin.findByAdminFullName", query = "SELECT t FROM TblAdmin t WHERE t.adminFullName = :adminFullName"),
    @NamedQuery(name = "TblAdmin.findByAdminPass", query = "SELECT t FROM TblAdmin t WHERE t.adminPass = :adminPass")})
public class TblAdmin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AdminID")
    private String adminID;
    @Column(name = "AdminLevel")
    private Integer adminLevel;
    @Column(name = "AdminFullName")
    private String adminFullName;
    @Column(name = "AdminPass")
    private String adminPass;

    public TblAdmin() {
    }

    public TblAdmin(String adminID) {
        this.adminID = adminID;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public Integer getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(Integer adminLevel) {
        this.adminLevel = adminLevel;
    }

    public String getAdminFullName() {
        return adminFullName;
    }

    public void setAdminFullName(String adminFullName) {
        this.adminFullName = adminFullName;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminID != null ? adminID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAdmin)) {
            return false;
        }
        TblAdmin other = (TblAdmin) object;
        if ((this.adminID == null && other.adminID != null) || (this.adminID != null && !this.adminID.equals(other.adminID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.entity.TblAdmin[adminID=" + adminID + "]";
    }

}
