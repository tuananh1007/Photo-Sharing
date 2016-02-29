/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean.session;

import bean.entity.TblUser;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dell
 */
public class TblUserFacadeTest {

    public TblUserFacadeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getEm method, of class TblUserFacade.
     */
//    @Test
//    public void testGetEm() throws Exception {
//        System.out.println("getEm");
//        TblUserFacade instance = (TblUserFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblUserFacade");
//        EntityManager expResult = null;
//        EntityManager result = instance.getEm();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setEm method, of class TblUserFacade.
//     */
//    @Test
//    public void testSetEm() throws Exception {
//        System.out.println("setEm");
//        EntityManager em = null;
//        TblUserFacade instance = (TblUserFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblUserFacade");
//        instance.setEm(em);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of create method, of class TblUserFacade.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        TblUser tblUser = null;
//        TblUserFacade instance = (TblUserFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblUserFacade");
//        instance.create(tblUser);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of edit method, of class TblUserFacade.
//     */
//    @Test
//    public void testEdit() throws Exception {
//        System.out.println("edit");
//        TblUser tblUser = null;
//        TblUserFacade instance = (TblUserFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblUserFacade");
//        instance.edit(tblUser);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of remove method, of class TblUserFacade.
//     */
//    @Test
//    public void testRemove() throws Exception {
//        System.out.println("remove");
//        TblUser tblUser = null;
//        TblUserFacade instance = (TblUserFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblUserFacade");
//        instance.remove(tblUser);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of find method, of class TblUserFacade.
//     */
//    @Test
//    public void testFind() throws Exception {
//        System.out.println("find");
//        Object id = null;
//        TblUserFacade instance = (TblUserFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblUserFacade");
//        TblUser expResult = null;
//        TblUser result = instance.find(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findAll method, of class TblUserFacade.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
//        TblUserFacade instance = (TblUserFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblUserFacade");
//        List expResult = null;
//        List result = instance.findAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findRange method, of class TblUserFacade.
//     */
//    @Test
//    public void testFindRange() throws Exception {
//        System.out.println("findRange");
//        int[] range = null;
//        TblUserFacade instance = (TblUserFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblUserFacade");
//        List expResult = null;
//        List result = instance.findRange(range);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of count method, of class TblUserFacade.
//     */
//    @Test
//    public void testCount() throws Exception {
//        System.out.println("count");
//        TblUserFacade instance = (TblUserFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblUserFacade");
//        int expResult = 0;
//        int result = instance.count();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of login method, of class TblUserFacade.
//     */
//    @Test
//    public void testLogin() throws Exception {
//        System.out.println("login");
//        String userid = "";
//        String password = "";
//        TblUserFacade instance = (TblUserFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblUserFacade");
//        int expResult = 0;
//        int result = instance.login(userid, password);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of listNewUser method, of class TblUserFacade.
//     */
//    @Test
//    public void testListNewUser() throws Exception {
//        System.out.println("listNewUser");
//        TblUserFacade instance = (TblUserFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblUserFacade");
//        List expResult = null;
//        List result = instance.listNewUser();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delUser method, of class TblUserFacade.
//     */
    @Test
    public void testDelUser() throws Exception {
        System.out.println("delUser");
        String uid = "catcat";
        TblUserFacadeRemote instance = (TblUserFacadeRemote)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblUserFacade");
        instance.delUser(uid);
    }
//
//    /**
//     * Test of listNewUserPaging method, of class TblUserFacade.
//     */
//    @Test
//    public void testListNewUserPaging() throws Exception {
//        System.out.println("listNewUserPaging");
//        int[] range = null;
//        TblUserFacade instance = (TblUserFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblUserFacade");
//        List expResult = null;
//        List result = instance.listNewUserPaging(range);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of countValidatedUser method, of class TblUserFacade.
//     */
//    @Test
//    public void testCountValidatedUser() throws Exception {
//        System.out.println("countValidatedUser");
//        TblUserFacadeRemote instance = (TblUserFacadeRemote)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblUserFacade");
//        int expResult = 0;
//        int result = instance.countValidatedUser();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of listUserNotApproved method, of class TblUserFacade.
//     */
//    @Test
//    public void testListUserNotApproved() throws Exception {
//        System.out.println("listUserNotApproved");
//        int[] range = new int[2];
//        range[0]=1;
//        range[1]=5;
//        TblUserFacadeRemote instance = (TblUserFacadeRemote)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblUserFacade");
//        List expResult = new ArrayList();
//        List result = instance.listUserNotApproved(range);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of countAccountByEmail method, of class TblUserFacade.
     */
//    @Test
//    public void testCountAccountByEmail() throws Exception {
//        System.out.println("countAccountByEmail");
//        String email = "bachpv@viegrid.com";
//        TblUserFacadeRemote instance = (TblUserFacadeRemote)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblUserFacade");
//        int expResult = 0;
//        int result = instance.countAccountByEmail(email);
//        assertEquals(expResult, result);
//    }

}