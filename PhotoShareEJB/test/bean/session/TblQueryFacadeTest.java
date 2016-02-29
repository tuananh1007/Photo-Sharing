/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean.session;

import bean.entity.TblQuery;
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
public class TblQueryFacadeTest {

    public TblQueryFacadeTest() {
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
     * Test of getEm method, of class TblQueryFacade.
     */
//    @Test
//    public void testGetEm() throws Exception {
//        System.out.println("getEm");
//        TblQueryFacade instance = (TblQueryFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblQueryFacade");
//        EntityManager expResult = null;
//        EntityManager result = instance.getEm();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setEm method, of class TblQueryFacade.
//     */
//    @Test
//    public void testSetEm() throws Exception {
//        System.out.println("setEm");
//        EntityManager em = null;
//        TblQueryFacade instance = (TblQueryFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblQueryFacade");
//        instance.setEm(em);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of create method, of class TblQueryFacade.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        TblQuery tblQuery = null;
//        TblQueryFacade instance = (TblQueryFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblQueryFacade");
//        instance.create(tblQuery);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of edit method, of class TblQueryFacade.
//     */
//    @Test
//    public void testEdit() throws Exception {
//        System.out.println("edit");
//        TblQuery tblQuery = null;
//        TblQueryFacade instance = (TblQueryFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblQueryFacade");
//        instance.edit(tblQuery);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of remove method, of class TblQueryFacade.
//     */
//    @Test
//    public void testRemove() throws Exception {
//        System.out.println("remove");
//        TblQuery tblQuery = null;
//        TblQueryFacade instance = (TblQueryFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblQueryFacade");
//        instance.remove(tblQuery);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of find method, of class TblQueryFacade.
//     */
//    @Test
//    public void testFind() throws Exception {
//        System.out.println("find");
//        Object id = null;
//        TblQueryFacade instance = (TblQueryFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblQueryFacade");
//        TblQuery expResult = null;
//        TblQuery result = instance.find(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findAll method, of class TblQueryFacade.
//     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        TblQueryFacadeRemote instance = (TblQueryFacadeRemote)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblQueryFacade");
        List expResult = new ArrayList();
        List result = instance.findAll();
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of findRange method, of class TblQueryFacade.
//     */
//    @Test
//    public void testFindRange() throws Exception {
//        System.out.println("findRange");
//        int[] range = null;
//        TblQueryFacade instance = (TblQueryFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblQueryFacade");
//        List expResult = null;
//        List result = instance.findRange(range);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of count method, of class TblQueryFacade.
//     */
//    @Test
//    public void testCount() throws Exception {
//        System.out.println("count");
//        TblQueryFacadeRemote instance = (TblQueryFacadeRemote)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblQueryFacade");
//        int expResult = 0;
//        int result = instance.count();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of getQueryUnAnswer method, of class TblQueryFacade.
//     */
//    @Test
//    public void testGetQueryUnAnswer() throws Exception {
//        System.out.println("getQueryUnAnswer");
//        int[] range = new int[2];
//        range[0]=1;
//        range[1]=5;
//        TblQueryFacadeRemote instance = (TblQueryFacadeRemote)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblQueryFacade");
//        List expResult = new ArrayList();
//        List result = instance.getQueryUnAnswer(range);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of countQueryUnAnswer method, of class TblQueryFacade.
     */
//    @Test
//    public void testCountQueryUnAnswer() throws Exception {
//        System.out.println("countQueryUnAnswer");
//        TblQueryFacadeRemote instance = (TblQueryFacadeRemote)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblQueryFacade");
//        int expResult = 0;
//        int result = instance.countQueryUnAnswer();
//        assertEquals(expResult, result);
//    }

}