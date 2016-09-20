package ma223ku_assign2.Exercise_3;

import ma223ku_assign2.Exercise_1.ArrayIntList;

import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Created by marti on 2016-09-19.
 */
public class ArrayIntListTest
{
    @org.junit.Before
    public void setUp() throws Exception
    {
        System.out.println("Running test..");
    }

    @org.junit.After
    public void tearDown() throws Exception
    {
        System.out.println("Test finished..");
    }

    @Test
    public void add() throws Exception
    {
        ArrayIntList intlist = new ArrayIntList();
        intlist.add(14);
        assertEquals(1,intlist.size());
        ArrayIntList _intlist = new ArrayIntList();
        _intlist.add(-1);
        ArrayIntList __intlist = new ArrayIntList();
        for (int i = 0; i < 1000000; i++)
        {
            __intlist.add(i);
        }
        assertEquals(1000000,__intlist.size());
    }

    @Test
    public void addAt() throws Exception
    {
        ArrayIntList intlist = new ArrayIntList();
        intlist.addAt(1,0);
        try
        {
            intlist.addAt(1,-1);
            fail("Test failed, no exception was thrown");
        }
        catch (IndexOutOfBoundsException e)
        {
            assertTrue(true);
        }
        try
        {
            intlist.addAt(1,200);
            fail("Test failed, no exception was thrown");
        }
        catch (IndexOutOfBoundsException e)
        {
            assertTrue(true);
        }
    }

    @Test
    public void remove() throws Exception
    {
        ArrayIntList intlist = new ArrayIntList();
        for (int i = 0; i < 50000; i++)
        {
            intlist.add(i);
        }

        intlist.remove(0);
        try
        {
            intlist.remove(-1);
            fail("Test failed, no exception was thrown");
        }
        catch (IndexOutOfBoundsException e)
        {
            assertTrue(true);
        }
        try
        {
            intlist.remove(60000);
            fail("Test failed, no exception was thrown");
        }
        catch (IndexOutOfBoundsException e)
        {
            assertTrue(true);
        }

    }

    @Test
    public void get() throws Exception
    {
        ArrayIntList intlist = new ArrayIntList();
        for (int i = 0; i < 50000; i++)
        {
            intlist.add(i);
        }
        intlist.get(20);
        try
        {
            intlist.get(60000);
            fail("Test failed, no exception was thrown");
        }
        catch (IndexOutOfBoundsException e)
        {
            assertTrue(true);
        }
    }

    @Test
    public void indexOf() throws Exception
    {
        ArrayIntList intlist = new ArrayIntList();
        for (int i = 0; i < 50000; i++)
        {
            intlist.add(i);
        }
        intlist.indexOf(30);
        intlist.indexOf(45);
        intlist.indexOf(1);
        intlist.indexOf(100);
        intlist.indexOf(60000);
    }

}