package ma223ku_assign2.Exercise_3;

import static org.junit.Assert.*;

import ma223ku_assign2.Exercise_1.ArrayIntStack;
import org.junit.Test;
/**
 * Created by marti on 2016-09-18.
 */
public class ArrayIntStackTest
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
    public void push() throws Exception
    {
        ArrayIntStack intstack = new ArrayIntStack();
        for (int i = 0; i < 10000; i++)
        {
            intstack.push(i);
        }
    }

    @Test
    public void pop() throws Exception
    {
        ArrayIntStack intstack = new ArrayIntStack();
        for (int i = 0; i < 10000; i++)
        {
            intstack.push(i);
        }
        intstack.pop();
        ArrayIntStack _intstack = new ArrayIntStack();
        try
        {
            _intstack.pop();
            fail("Test failed, no exception was thrown");
        }
        catch (IndexOutOfBoundsException e)
        {
            assertTrue(true);
        }
    }

    @Test
    public void peek() throws Exception
    {
        ArrayIntStack intstack = new ArrayIntStack();
        for (int i = 0; i < 10000; i++)
        {
            intstack.push(i);
        }
        intstack.peek();
        ArrayIntStack _intstack = new ArrayIntStack();
        try
        {
            _intstack.peek();
            fail("Test failed, no exception was thrown");
        }
        catch (IndexOutOfBoundsException e)
        {
            assertTrue(true);
        }
    }
}