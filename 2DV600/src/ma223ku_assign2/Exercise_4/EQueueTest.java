package ma223ku_assign2.Exercise_4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Martin on 2016-09-20.
 */
public class EQueueTest //Testing the queue with E
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
    public void enqueue() throws Exception //Testing the add by adding a int,string and a new instance of queue.
    {
        EQueue _queue = new EQueue();
        EQueue testqueue = new EQueue();
        _queue.enqueue(1);
        _queue.enqueue("Test");
        _queue.enqueue(testqueue);

    }

    @Test
    public void dequeue() throws Exception //Testing remove by adding 3, then removing 3. Try removing a 4th that don't exist and catch the error
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
    public void size() throws Exception //Testing the sizefunction by adding items and then checking the size
    {
        EQueue _queue = new EQueue();
        for (int i = 0; i < 100; i++)
        {
            _queue.enqueue(i);
        }

        assertEquals(100,_queue.size());
        for (int i = 0; i < 50; i++)
        {
            _queue.dequeue();
        }
        assertEquals(50,_queue.size());
    }

    @Test
    public void isEmpty() throws Exception //Test of the isEmpty by adding a item,calling the function and Wanting a false
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
    public void first() throws Exception //Test of first, test on empty queue and on non empty queue
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
    public void last() throws Exception //Test of last. Test on empty queue and on non empty queue
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