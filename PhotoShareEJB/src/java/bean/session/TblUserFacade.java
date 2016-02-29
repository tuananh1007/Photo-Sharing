/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean.session;

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
public class TblUserFacade implements TblUserFacadeRemote {
    @PersistenceContext(unitName = "PhotoShareEJBPU")
    private EntityManager em;

    public EntityManager getEm() {
        em=Persistence.createEntityManagerFactory("PhotoShareEJBPU").createEntityManager();
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void create(TblUser tblUser) {
        getEm().persist(tblUser);
    }

    public void edit(TblUser tblUser) {
        getEm().merge(tblUser);
    }

    public void remove(TblUser tblUser) {
        getEm().remove(getEm().merge(tblUser));
    }

    public TblUser find(Object id) {
        return getEm().find(TblUser.class, id);
    }

    public List<TblUser> findAll() {
        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        cq.select(cq.from(TblUser.class));
        return getEm().createQuery(cq).getResultList();
    }

    public List<TblUser> findRange(int[] range) {
        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        cq.select(cq.from(TblUser.class));
        Query q = getEm().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        Root<TblUser> rt = cq.from(TblUser.class);
        cq.select(getEm().getCriteriaBuilder().count(rt));
        Query q = getEm().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public int login(String userid, String password) {
        int rs=0;
        Query query=getEm().createNamedQuery("TblUser.UserLogin");
        query.setParameter(1, userid);
        query.setParameter(2, password);
    try{
        rs=((Long)query.getSingleResult()).intValue();
    }catch(Exception e)
    {
        e.printStackTrace();
    }
        return rs;
    }
    public List<TblUser> listNewUser()
    {
    List<TblUser> listuser=null;
    Query query=getEm().createNamedQuery("TblUser.newUser");
    query.setMaxResults(3);
    query.setFirstResult(0);
    listuser=(List<TblUser>)query.getResultList();
    return listuser;
    }

    public void delUser(String uid) {
        Query query=getEm().createNamedQuery("TblUser.deleteUser");
        query.setParameter(1, uid);
        query.executeUpdate();
    }

    public List<TblUser> listNewUserPaging(int[] range) {
    List<TblUser> listuser=null;
    Query query=getEm().createNamedQuery("TblUser.newUser");
    query.setMaxResults(range[1]-range[0]);
    query.setFirstResult(range[0]);
    listuser=(List<TblUser>)query.getResultList();
        return listuser;
    }

    public int countValidatedUser() {
        int rs=0;
        Query query=getEm().createNamedQuery("TblUser.countValidatedAccount");
        rs=((Long)query.getSingleResult()).intValue();
        return rs;
    }

    public List<TblUser> listUserNotApproved(int[] range) {
        List<TblUser> listuser=null;
        Query query=getEm().createNamedQuery("TblUser.userNotApprove");
        query.setFirstResult(range[0]);
        query.setMaxResults(range[1]-range[0]);
        listuser=query.getResultList();
        return listuser;
    }

    public int countAccountByEmail(String email) {
        int rs=0;
        Query query=getEm().createNamedQuery("TblUser.countAccountWithEmail");
        query.setParameter(1, email);
        rs=((Long)query.getSingleResult()).intValue();
        return rs;
    }

}
