/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean.session;

import bean.entity.TblComment;
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
public class TblCommentFacadeTest {

    public TblCommentFacadeTest() {
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
     * Test of getEm method, of class TblCommentFacade.
     */
//    @Test
//    public void testGetEm() throws Exception {
//        System.out.println("getEm");
//        TblCommentFacade instance = (TblCommentFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblCommentFacade");
//        EntityManager expResult = null;
//        EntityManager result = instance.getEm();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setEm method, of class TblCommentFacade.
//     */
//    @Test
//    public void testSetEm() throws Exception {
//        System.out.println("setEm");
//        EntityManager em = null;
//        TblCommentFacade instance = (TblCommentFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblCommentFacade");
//        instance.setEm(em);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of create method, of class TblCommentFacade.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        TblComment tblComment = null;
//        TblCommentFacade instance = (TblCommentFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblCommentFacade");
//        instance.create(tblComment);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of edit method, of class TblCommentFacade.
//     */
//    @Test
//    public void testEdit() throws Exception {
//        System.out.println("edit");
//        TblComment tblComment = null;
//        TblCommentFacade instance = (TblCommentFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblCommentFacade");
//        instance.edit(tblComment);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of remove method, of class TblCommentFacade.
//     */
//    @Test
//    public void testRemove() throws Exception {
//        System.out.println("remove");
//        TblComment tblComment = null;
//        TblCommentFacade instance = (TblCommentFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblCommentFacade");
//        instance.remove(tblComment);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of find method, of class TblCommentFacade.
//     */
//    @Test
//    public void testFind() throws Exception {
//        System.out.println("find");
//        Object id = null;
//        TblCommentFacade instance = (TblCommentFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblCommentFacade");
//        TblComment expResult = null;
//        TblComment result = instance.find(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findAll method, of class TblCommentFacade.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
//        TblCommentFacadeRemote instance = (TblCommentFacadeRemote)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblCommentFacade");
//        List expResult = new ArrayList();
//        List result = instance.findAll();
//        assertNotSame(expResult, result);
//    }
//
//    /**
//     * Test of findRange method, of class TblCommentFacade.
//     */
//    @Test
//    public void testFindRange() throws Exception {
//        System.out.println("findRange");
//        int[] range = null;
//        TblCommentFacade instance = (TblCommentFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblCommentFacade");
//        List expResult = null;
//        List result = instance.findRange(range);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of count method, of class TblCommentFacade.
//     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        TblCommentFacadeRemote instance = (TblCommentFacadeRemote)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblCommentFacade");
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);

    }
//
//    /**
//     * Test of findByImageID method, of class TblCommentFacade.
//     */
//    @Test
//    public void testFindByImageID() throws Exception {
//        System.out.println("findByImageID");
//        int iid = 432;
//        TblCommentFacadeRemote instance = (TblCommentFacadeRemote)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblCommentFacade");
//        List expResult = new ArrayList();
//        List result = instance.findByImageID(iid);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of delCommentByID method, of class TblCommentFacade.
     */
//    @Test
//    public void testDelCommentByID() throws Exception {
//        System.out.println("delCommentByID");
//        int cid = 40;
//        TblCommentFacadeRemote instance = (TblCommentFacadeRemote)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblCommentFacade");
//        instance.delCommentByID(cid);
//    }

}