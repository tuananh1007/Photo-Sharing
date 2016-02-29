/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean.session;

import bean.entity.TblAdmin;
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
public class TblAdminFacade implements TblAdminFacadeRemote {
    @PersistenceContext(unitName = "PhotoShareEJBPU")
    private EntityManager em;

    public EntityManager getEm() {
        em=Persistence.createEntityManagerFactory("PhotoShareEJBPU").createEntityManager();
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void create(TblAdmin tblAdmin) {
        getEm().persist(tblAdmin);
    }

    public void edit(TblAdmin tblAdmin) {
        getEm().merge(tblAdmin);
    }

    public void remove(TblAdmin tblAdmin) {
        getEm().remove(getEm().merge(tblAdmin));
    }

    public TblAdmin find(Object id) {
        return getEm().find(TblAdmin.class, id);
    }

    public List<TblAdmin> findAll() {
        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        cq.select(cq.from(TblAdmin.class));
        return getEm().createQuery(cq).getResultList();
    }

    public List<TblAdmin> findRange(int[] range) {
        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        cq.select(cq.from(TblAdmin.class));
        Query q = getEm().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        Root<TblAdmin> rt = cq.from(TblAdmin.class);
        cq.select(getEm().getCriteriaBuilder().count(rt));
        Query q = getEm().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public int adminLogin(String name, String pass) {
        int rs=0;
        Query query=getEm().createNamedQuery("TblAdmin.adminLogin");
        query.setParameter(1, name);
        query.setParameter(2, pass);
        Object obj=query.getSingleResult();
        if(obj!=null) rs=((Long)obj).intValue();
        return rs;
    }

}
