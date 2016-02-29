/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean.session;

import bean.entity.TblComment;
import bean.entity.TblImage;
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
 * @author bkc
 */
@Stateless
public class TblCommentFacade implements TblCommentFacadeRemote {
    @PersistenceContext(unitName = "PhotoShareEJBPU")
    private EntityManager em;

    public EntityManager getEm() {
        em=Persistence.createEntityManagerFactory("PhotoShareEJBPU").createEntityManager();
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void create(TblComment tblComment) {
        getEm().persist(tblComment);
    }

    public void edit(TblComment tblComment) {
        getEm().merge(tblComment);
    }

    public void remove(TblComment tblComment) {
        TblComment cm= getEm().merge(tblComment);
        getEm().remove(cm);
        getEm().flush();
    }

    public TblComment find(Object id) {
        return getEm().find(TblComment.class, id);
    }

    public List<TblComment> findAll() {
        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        cq.select(cq.from(TblComment.class));
        return getEm().createQuery(cq).getResultList();
    }

    public List<TblComment> findRange(int[] range) {
        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        cq.select(cq.from(TblComment.class));
        Query q = getEm().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        Root<TblComment> rt = cq.from(TblComment.class);
        cq.select(getEm().getCriteriaBuilder().count(rt));
        Query q = getEm().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public List findByImageID(int iid) {
        List<TblComment> clist=null;
        Query query=getEm().createNamedQuery("TblComment.findByImage");
        TblImage image=new TblImage(new Integer(iid));
        query.setParameter(1,image );
        clist=(List<TblComment>)query.getResultList();
        return clist;
    }

    public void delCommentByID(int cid) {
        Query query=getEm().createNamedQuery("TblComment.deleteComment");
        query.setParameter(1,new Integer(cid));
        query.executeUpdate();
    }

}
