/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean.session;

import bean.entity.TblImage;
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
public class TblImageFacadeTest {

    public TblImageFacadeTest() {
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
     * Test of getEm method, of class TblImageFacade.
     */
//    @Test
//    public void testGetEm() throws Exception {
//        System.out.println("getEm");
//        TblImageFacade instance = (TblImageFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblImageFacade");
//        EntityManager expResult = null;
//        EntityManager result = instance.getEm();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setEm method, of class TblImageFacade.
//     */
//    @Test
//    public void testSetEm() throws Exception {
//        System.out.println("setEm");
//        EntityManager em = null;
//        TblImageFacade instance = (TblImageFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblImageFacade");
//        instance.setEm(em);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of create method, of class TblImageFacade.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        TblImage tblImage = null;
//        TblImageFacade instance = (TblImageFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblImageFacade");
//        instance.create(tblImage);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of edit method, of class TblImageFacade.
//     */
//    @Test
//    public void testEdit() throws Exception {
//        System.out.println("edit");
//        TblImage tblImage = null;
//        TblImageFacade instance = (TblImageFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblImageFacade");
//        instance.edit(tblImage);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of remove method, of class TblImageFacade.
//     */
//    @Test
//    public void testRemove() throws Exception {
//        System.out.println("remove");
//        TblImage tblImage = null;
//        TblImageFacade instance = (TblImageFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblImageFacade");
//        instance.remove(tblImage);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of find method, of class TblImageFacade.
//     */
//    @Test
//    public void testFind() throws Exception {
//        System.out.println("find");
//        Object id = null;
//        TblImageFacade instance = (TblImageFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblImageFacade");
//        TblImage expResult = null;
//        TblImage result = instance.find(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findAll method, of class TblImageFacade.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
//        TblImageFacade instance = (TblImageFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblImageFacade");
//        List expResult = null;
//        List result = instance.findAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findRange method, of class TblImageFacade.
//     */
//    @Test
//    public void testFindRange() throws Exception {
//        System.out.println("findRange");
//        int[] range = null;
//        TblImageFacade instance = (TblImageFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblImageFacade");
//        List expResult = null;
//        List result = instance.findRange(range);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of count method, of class TblImageFacade.
//     */
//    @Test
//    public void testCount() throws Exception {
//        System.out.println("count");
//        TblImageFacade instance = (TblImageFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblImageFacade");
//        int expResult = 0;
//        int result = instance.count();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of searchImageByname method, of class TblImageFacade.
//     */
    @Test
    public void testSearchImageByname() throws Exception {
        System.out.println("searchImageByname");
        String imgName = "hehe";
        int[] range = new int[2];
        range[0]=3;
        range[1]=5;
        TblImageFacadeRemote instance = (TblImageFacadeRemote)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblImageFacade");
        List expResult = null;
        List result = instance.searchImageByname(imgName, range);
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of countImageByName method, of class TblImageFacade.
//     */
//    @Test
//    public void testCountImageByName() throws Exception {
//        System.out.println("countImageByName");
//        String iname = "hixhix";
//        TblImageFacadeRemote instance = (TblImageFacadeRemote)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblImageFacade");
//        int expResult = 0;
//        int result = instance.countImageByName(iname);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of findImageByUserID method, of class TblImageFacade.
//     */
//    @Test
//    public void testFindImageByUserID() throws Exception {
//        System.out.println("findImageByUserID");
//        String userid = "bachpasddfv";
//        TblImageFacadeRemote instance = (TblImageFacadeRemote)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblImageFacade");
//        List expResult = new ArrayList();
//        List result = instance.findImageByUserID(userid);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of topDownload method, of class TblImageFacade.
//     */
//    @Test
//    public void testTopDownload() throws Exception {
//        System.out.println("topDownload");
//        TblImageFacade instance = (TblImageFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblImageFacade");
//        List expResult = null;
//        List result = instance.topDownload();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findByUserID_Pagination method, of class TblImageFacade.
//     */
//    @Test
//    public void testFindByUserID_Pagination() throws Exception {
//        System.out.println("findByUserID_Pagination");
//        String username = "";
//        int[] range = null;
//        TblImageFacade instance = (TblImageFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblImageFacade");
//        List expResult = null;
//        List result = instance.findByUserID_Pagination(username, range);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of countByUsername method, of class TblImageFacade.
//     */
//    @Test
//    public void testCountByUsername() throws Exception {
//        System.out.println("countByUsername");
//        String username = "";
//        TblImageFacade instance = (TblImageFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblImageFacade");
//        int expResult = 0;
//        int result = instance.countByUsername(username);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delImage method, of class TblImageFacade.
//     */
//    @Test
//    public void testDelImage() throws Exception {
//        System.out.println("delImage");
//        int iid = 0;
//        TblImageFacade instance = (TblImageFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblImageFacade");
//        instance.delImage(iid);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of topDownloadPaging method, of class TblImageFacade.
//     */
//    @Test
//    public void testTopDownloadPaging() throws Exception {
//        System.out.println("topDownloadPaging");
//        int[] rang = null;
//        TblImageFacade instance = (TblImageFacade)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblImageFacade");
//        List expResult = null;
//        List result = instance.topDownloadPaging(rang);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of topNewPaging method, of class TblImageFacade.
     */
//    @Test
//    public void testTopNewPaging() throws Exception {
//        System.out.println("topNewPaging");
//        int[] range = new int[2];
//        range[0]=4;
//        range[1]=9;
//        TblImageFacadeRemote instance = (TblImageFacadeRemote)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/TblImageFacade");
//        List expResult = new ArrayList();
//        List result = instance.topNewPaging(range);
//        assertEquals(expResult, result);
//    }

}