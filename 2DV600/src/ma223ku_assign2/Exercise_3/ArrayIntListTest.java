package ma223ku_assign2.Exercise_3;

import ma223ku_assign2.Exercise_1.ArrayIntList;

import static org.junit.Assert.*;

/**
 * Created by marti on 2016-09-19.
 */
public class ArrayIntListTest
{
/*    @org.junit.Before
    public void setUp() throws Exception
    {

    }

    @org.junit.After
    public void tearDown() throws Exception
    {

    }*/

    @org.junit.Test
    public void add() throws Exception
    {
        ArrayIntList intlist = new ArrayIntList();
        intlist.add(14);
        assertEquals(1,intlist.size());
        ArrayIntList _intlist = new ArrayIntList();
        _intlist.add(-1);
    }

    @org.junit.Test
    public void addAt() throws Exception
    {

    }

    @org.junit.Test
    public void remove() throws Exception
    {

    }

    @org.junit.Test
    public void get() throws Exception
    {

    }

    @org.junit.Test
    public void indexOf() throws Exception
    {

    }

}