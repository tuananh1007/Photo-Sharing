/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean.session;

import bean.entity.TblAdmin;
import java.util.List;
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
public class TblAdminFacadeTest {
    public TblAdminFacadeTest() {
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
     * Test of create method, of class TblAdminFacade.
     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        TblAdmin tblAdmin = new TblAdmin();
//        tblAdmin.setAdminID("catcat");
//        tblAdmin.setAdminPass("hixhix");
//        tblAdmin.setAdminFullName("Pho viet Bach");
//        tblAdmin.setAdminLevel(new Integer(1));
//        TblAdminFacadeRemote instance = (TblAdminFacadeRemote)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblAdminFacade");
//        instance.create(tblAdmin);
//    }

    /**
     * Test of edit method, of class TblAdminFacade.
     */
//    @Test
//    public void testEdit() throws Exception {
//        System.out.println("edit");
//        TblAdmin tblAdmin = null;
//        TblAdminFacadeRemote instance = (TblAdminFacadeRemote)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblAdminFacade");
//        instance.edit(tblAdmin);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of remove method, of class TblAdminFacade.
//     */
//    @Test
//    public void testRemove() throws Exception {
//        System.out.println("remove");
//        TblAdmin tblAdmin = null;
//        TblAdminFacade instance = (TblAdminFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblAdminFacade");
//        instance.remove(tblAdmin);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of find method, of class TblAdminFacade.
//     */
//    @Test
//    public void testFind() throws Exception {
//        System.out.println("find");
//        Object id = "bachpva";
//        TblAdminFacadeRemote instance = (TblAdminFacadeRemote)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblAdminFacade");
//        TblAdmin expResult = null;
//        TblAdmin result = instance.find(id);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of findAll method, of class TblAdminFacade.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
//        TblAdminFacade instance = (TblAdminFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblAdminFacade");
//        List expResult = null;
//        List result = instance.findAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findRange method, of class TblAdminFacade.
//     */
//    @Test
//    public void testFindRange() throws Exception {
//        System.out.println("findRange");
//        int[] range = null;
//        TblAdminFacade instance = (TblAdminFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblAdminFacade");
//        List expResult = null;
//        List result = instance.findRange(range);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of count method, of class TblAdminFacade.
//     */
//    @Test
//    public void testCount() throws Exception {
//        System.out.println("count");
//        TblAdminFacade instance = (TblAdminFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblAdminFacade");
//        int expResult = 0;
//        int result = instance.count();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of adminLogin method, of class TblAdminFacade.
//     */
    @Test
    public void testAdminLogin() throws Exception {
        System.out.println("adminLogin");
        String name = "admin";
//        String pass = "cc175b9c0f1b6a831c399e269772661";
        String pass = "123456";
        TblAdminFacadeRemote instance = (TblAdminFacadeRemote)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblAdminFacade");
        int expResult = 1;
        int result = instance.adminLogin(name, pass);
        assertEquals(expResult, result);
    }

}