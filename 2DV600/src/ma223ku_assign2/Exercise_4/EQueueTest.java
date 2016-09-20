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

    }

    @Test
    public void size() throws Exception
    {
        EQueue _queue = new EQueue();
    }

    @Test
    public void isEmpty() throws Exception
    {

    }

    @Test
    public void first() throws Exception
    {

    }

    @Test
    public void last() throws Exception
    {

    }

    @Test
    public void iterator() throws Exception
    {

    }

}