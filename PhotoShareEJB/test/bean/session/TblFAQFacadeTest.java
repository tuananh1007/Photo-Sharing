/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean.session;

import bean.entity.TblFAQ;
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
public class TblFAQFacadeTest {

    public TblFAQFacadeTest() {
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
     * Test of create method, of class TblFAQFacade.
     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        TblFAQ tblFAQ = new TblFAQ();
//        tblFAQ.setFAQAnswer("Answer");
//        tblFAQ.setFAQQuestion("question");
//        TblFAQFacadeRemote instance = (TblFAQFacadeRemote)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblFAQFacade");
//        instance.create(tblFAQ);
//    }

    /**
     * Test of edit method, of class TblFAQFacade.
//     */
//    @Test
//    public void testEdit() throws Exception {
//        System.out.println("edit");
//        TblFAQ tblFAQ = new TblFAQ();
//        tblFAQ.setFAQAnswer("Answer");
//        tblFAQ.setFAQQuestion("question");
//        tblFAQ.setFaqid(2);
//        TblFAQFacadeRemote instance = (TblFAQFacadeRemote)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblFAQFacade");
//        instance.edit(tblFAQ);
//    }
//
//    /**
//     * Test of remove method, of class TblFAQFacade.
//     */
//    @Test
//    public void testRemove() throws Exception {
//        System.out.println("remove");
//        TblFAQ tblFAQ = new TblFAQ();
//        tblFAQ.setFaqid(1);
//        TblFAQFacadeRemote instance = (TblFAQFacadeRemote)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblFAQFacade");
//        instance.remove(tblFAQ);
//    }
//
//    /**
//     * Test of find method, of class TblFAQFacade.
//     */
//    @Test
//    public void testFind() throws Exception {
//        System.out.println("find");
//        Object id = null;
//        TblFAQFacade instance = (TblFAQFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblFAQFacade");
//        TblFAQ expResult = null;
//        TblFAQ result = instance.find(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findAll method, of class TblFAQFacade.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
//        TblFAQFacade instance = (TblFAQFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblFAQFacade");
//        List expResult = null;
//        List result = instance.findAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findRange method, of class TblFAQFacade.
//     */
//    @Test
//    public void testFindRange() throws Exception {
//        System.out.println("findRange");
//        int[] range = null;
//        TblFAQFacade instance = (TblFAQFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblFAQFacade");
//        List expResult = null;
//        List result = instance.findRange(range);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of count method, of class TblFAQFacade.
//     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        TblFAQFacadeRemote instance = (TblFAQFacadeRemote)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblFAQFacade");
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
    }

}