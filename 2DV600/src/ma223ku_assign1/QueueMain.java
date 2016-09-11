package ma223ku_assign1;

import java.util.Iterator;

/**
 * Created by marti on 2016-09-11.
 */
public class QueueMain
{
    public static void main(String[] args)
    {
        Queue _queue = new Queue();
        //--------------------------------------------------------------
        try //Test for error handling
        {
            _queue.last();
        }
        catch (Exception e)
        {
            System.out.println("Can't find last pos in an empty queue");
        }
        //--------------------------------------------------------------
        System.out.println("is the newly created queue empty? Status:["+ _queue.isEmpty()+"]"); //Should be true
        _queue.enqueue(1);
        _queue.enqueue(2);
        _queue.enqueue(3); //Adds 3 items to the queue
        Iterator<Object> _iterator = _queue.iterator();
        while(_iterator.hasNext())
        {
            System.out.println("Item in queue [" + _iterator.next()+"]");
        }
        System.out.println("3 items were added, the size should be equal to three. Size:[" + _queue.size()+"]"); //Should be 3 since we added 3 items
        System.out.println();
        System.out.println("Since three items was added the queue shouldn't be empty now. Status:[" + _queue.isEmpty()+"]"); //Should be false
        System.out.println("Removes the first item. Removed:[" + _queue.dequeue() + "]"); //First in first out. Should remove item "1"
        System.out.println("size of queue after we removed item. Size:[" + _queue.size() + "]"); //Should be one less since we have removed one item from the queue
        System.out.println("First item should now be 2 since we removed 1. First item:[" + _queue.first() +"]");
        System.out.println("Last pos. should still be 3 since we haven't touched that. Last:["+ _queue.last()+"]");
        System.out.println("Checking the remaining queue for the item [1], should return false Status:["+_queue.contains(1)+"]");
        System.out.println("Checking the remaining queue for the item [2], should return true Status:["+_queue.contains(2)+"]");




    }
}
