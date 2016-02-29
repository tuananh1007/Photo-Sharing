/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean.session;

import bean.entity.TblImage;
import bean.entity.TblUser;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Dell
 */
@Stateless
public class TblImageFacade implements TblImageFacadeRemote {
    @PersistenceContext(unitName = "PhotoShareEJBPU")
    private EntityManager em;

    public EntityManager getEm() {
        em=Persistence.createEntityManagerFactory("PhotoShareEJBPU").createEntityManager();
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void create(TblImage tblImage) {
        getEm().persist(tblImage);
    }

    public void edit(TblImage tblImage) {
        getEm().merge(tblImage);
    }

    public void remove(TblImage tblImage) {
        getEm().remove(getEm().merge(tblImage));
    }

    public TblImage find(Object id) {
        return getEm().find(TblImage.class, id);
    }

    public List<TblImage> findAll() {
        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        cq.select(cq.from(TblImage.class));
        return getEm().createQuery(cq).getResultList();
    }

    public List<TblImage> findRange(int[] range) {
        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        cq.select(cq.from(TblImage.class));
        Query q = getEm().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        Root<TblImage> rt = cq.from(TblImage.class);
        cq.select(getEm().getCriteriaBuilder().count(rt));
        Query q = getEm().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
@Override
    public List<TblImage> searchImageByname(String imgName, int[] range) {
                imgName="%"+imgName+"%";
        Query query=getEm().createNamedQuery("TblImage.findByImageName");
        query.setParameter(1, imgName);
        query.setMaxResults(range[1]-range[0]);
        query.setFirstResult(range[0]);
        return query.getResultList();
    }
    public int countImageByName(String iname) {
        int rs=0;
        iname="%"+iname+"%";
        Query query=getEm().createNamedQuery("TblImage.findByImageNameNotRange");
        query.setParameter(1, iname);
        rs=((Long)query.getSingleResult()).intValue();
        return rs;
    }
    public List<TblImage> findImageByUserID(String userid) {
    List<TblImage> ilist=null;
    Query query=getEm().createNamedQuery("TblImage.findbyUserName");
    TblUser user=new TblUser();
    user.setUserID(userid);
    query.setParameter(1, user);
    ilist=query.getResultList();
       return ilist;
    }

    public List<TblImage> topDownload() {
        List<TblImage> ilist=null;
        Query query=getEm().createNamedQuery("TblImage.topDownload");
        ilist=query.getResultList();
        return ilist;
    }

    public List<TblImage> findByUserID_Pagination(String username, int[] range) {
        List<TblImage> ilist=null;
        TblUser user=new TblUser(username);
        Query query=getEm().createNamedQuery("TblImage.findbyUserName");
        query.setParameter(1, user);
        query.setFirstResult(range[0]);
        query.setMaxResults(range[1]-range[0]);
        ilist=query.getResultList();
        return ilist;
    }

    public int countByUsername(String username) {
        TblUser user=new TblUser(username);
        int rs=0;
        Query query=getEm().createNamedQuery("TblImage.countImageByUser");
        query.setParameter(1, user);
        rs=((Long)query.getSingleResult()).intValue();
        return rs;
    }

    public void delImage(int iid) {
        Query query=getEm().createNamedQuery("TblImage.deleteImage");
        query.setParameter(1, new Integer(iid));
        query.executeUpdate();
    }

    public List<TblImage> topDownloadPaging(int[] rang) {
        List<TblImage> ilist=null;
        Query query=getEm().createNamedQuery("TblImage.topDownload");
        query.setFirstResult(rang[0]);
        query.setMaxResults(rang[1]-rang[0]);
        ilist=(List<TblImage>)query.getResultList();
        return ilist;
    }

    public List<TblImage> topNewPaging(int[] range) {
        List<TblImage> ilist=null;
        Query query=getEm().createNamedQuery("TblImage.findAll");
        query.setFirstResult(range[0]);
        query.setMaxResults(range[1]-range[0]);
        ilist=(List<TblImage>)query.getResultList();
        return ilist;
    }

}
