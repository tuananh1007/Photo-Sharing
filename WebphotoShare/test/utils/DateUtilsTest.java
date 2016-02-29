/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.util.Date;
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
public class DateUtilsTest {

    public DateUtilsTest() {
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
     * Test of daydiff method, of class DateUtils.
     */
    @Test
    public void testDaydiff() throws Exception {
        System.out.println("daydiff");
        Date toDiff = new Date();
        int expResult = 0;
        int result = DateUtils.daydiff(toDiff);
        assertEquals(expResult, result);
    }

}