/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean.session;

import bean.entity.TblFAQ;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Dell
 */
@Stateless
public class TblFAQFacade implements TblFAQFacadeRemote {
    @PersistenceContext(unitName = "PhotoShareEJBPU")
    private EntityManager em;

    public void create(TblFAQ tblFAQ) {
        em.persist(tblFAQ);
    }

    public void edit(TblFAQ tblFAQ) {
        em.merge(tblFAQ);
    }

    public void remove(TblFAQ tblFAQ) {
        em.remove(em.merge(tblFAQ));
    }

    public TblFAQ find(Object id) {
        return em.find(TblFAQ.class, id);
    }

    public List<TblFAQ> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(TblFAQ.class));
        return em.createQuery(cq).getResultList();
    }

    public List<TblFAQ> findRange(int[] range) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(TblFAQ.class));
        Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<TblFAQ> rt = cq.from(TblFAQ.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
