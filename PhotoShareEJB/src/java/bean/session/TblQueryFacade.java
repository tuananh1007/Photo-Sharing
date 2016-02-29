/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean.session;

import bean.entity.TblQuery;
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
public class TblQueryFacade implements TblQueryFacadeRemote {
    @PersistenceContext(unitName = "PhotoShareEJBPU")
    private EntityManager em;

    public EntityManager getEm() {
        em=Persistence.createEntityManagerFactory("PhotoShareEJBPU").createEntityManager();
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void create(TblQuery tblQuery) {
        getEm().persist(tblQuery);
    }

    public void edit(TblQuery tblQuery) {
        getEm().merge(tblQuery);
    }

    public void remove(TblQuery tblQuery) {
        getEm().remove(getEm().merge(tblQuery));
    }

    public TblQuery find(Object id) {
        return getEm().find(TblQuery.class, id);
    }

    public List<TblQuery> findAll() {
        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        cq.select(cq.from(TblQuery.class));
        return getEm().createQuery(cq).getResultList();
    }

    public List<TblQuery> findRange(int[] range) {
        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        cq.select(cq.from(TblQuery.class));
        Query q = getEm().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        Root<TblQuery> rt = cq.from(TblQuery.class);
        cq.select(getEm().getCriteriaBuilder().count(rt));
        Query q = getEm().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public List<TblQuery> getQueryUnAnswer(int[] range) {
        List<TblQuery> qlist=null;
        Query query=getEm().createNamedQuery("TblQuery.findNewQuery");
        query.setFirstResult(range[0]);
        query.setMaxResults(range[1]-range[0]);
        qlist=(List<TblQuery>)query.getResultList();
        return qlist;
    }
    public int countQueryUnAnswer() {
        int rs=0;
        Query query=getEm().createNamedQuery("TblQuery.countQueryUnAnswer");
        rs=((Long)query.getSingleResult()).intValue();
        return rs;
    }

}
