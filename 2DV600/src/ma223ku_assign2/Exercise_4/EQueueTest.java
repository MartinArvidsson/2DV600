package ma223ku_assign2.Exercise_4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Martin on 2016-09-20.
 */
public class EQueueTest
{
    @Before
    public void setUp() throws Exception
    {
        System.out.println("Running test..");
    }

    @After
    public void tearDown() throws Exception
    {
        System.out.println("Test finished.");
    }


    @Test
    public void enqueue() throws Exception
    {
        EQueue _queue = new EQueue();
        EQueue testqueue = new EQueue();
        _queue.enqueue(1);
        _queue.enqueue("Test");
        _queue.enqueue(testqueue);

    }

    @Test
    public void dequeue() throws Exception
    {
        EQueue _queue = new EQueue();
        EQueue testqueue = new EQueue();
        _queue.enqueue(1);
        _queue.enqueue("Test");
        _queue.enqueue(testqueue);

        _queue.dequeue();
        _queue.dequeue();
        _queue.dequeue();

        try
        {
            _queue.dequeue();
            fail("Test failed, no exception was thrown");
        }
        catch (IndexOutOfBoundsException e)
        {
            assertTrue(true);
        }
    }

    @Test
    public void size() throws Exception
    {
        EQueue _queue = new EQueue();
        for (int i = 0; i < 100; i++)
        {
            _queue.enqueue(i);
        }
        _queue.size();
        for (int i = 0; i < 50; i++)
        {
            _queue.dequeue();
        }
        _queue.size();
    }

    @Test
    public void isEmpty() throws Exception
    {
        EQueue _queue = new EQueue();
        _queue.isEmpty();
        _queue.enqueue(1);
        if(!_queue.isEmpty())
        {
            assertTrue(true);
        }
    }

    @Test
    public void first() throws Exception
    {
        EQueue _queue = new EQueue();
        try
        {
           _queue.first();
            fail("Test failed, no exception was thrown");
        }
        catch (IndexOutOfBoundsException e)
        {
            assertTrue(true);
        }
        _queue.enqueue(1);
        _queue.first();
    }

    @Test
    public void last() throws Exception
    {
        EQueue _queue = new EQueue();
        try
        {
            _queue.last();
            fail("Test failed, no exception was thrown");
        }
        catch (IndexOutOfBoundsException e)
        {
            assertTrue(true);
        }
        _queue.enqueue(1);
        _queue.last();

    }
}