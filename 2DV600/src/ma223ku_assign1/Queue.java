package ma223ku_assign1;

import java.security.PublicKey;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by marti on 2016-09-10.
 */
public class Queue implements QueueInterface
{
    private int size = 0;
    private Node head;
    private Node tail;

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size() == 0; //If value returned by size() is equal to 0 returns true else false
    }

    public void enqueue(Object element)
    {
        //Used some code from the presentationslides (23/27)
        if(head == null)
        {
            head = new Node(element);
            tail = head;
        }
        else
        {
            tail.setNextNode(new Node(element));
            tail.getNextNode();
        }
    }

    public Object dequeue() throws IndexOutOfBoundsException
    {
        if(head != null)
        {
            Node _toRemove = head; //Object to remove
            head =_toRemove.getNextNode(); //Gets node next to the node to remove
            size--; //Reduces the size therefore removing the first object(Old head)
            return _toRemove.getObject(); //Returns the object that got removed, I think this is what's supposed to be removed

        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }

    public Object first() throws IndexOutOfBoundsException
    {
        if(head != null)
        {
            return head.getObject();
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }

    public Object last() throws IndexOutOfBoundsException
    {
        if(head != null)
        {
            return tail.getObject();
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean contains(Object o)
    {
        Iterator<Object> _iterator = iterator();
        while(_iterator.hasNext())
        {
            if(_iterator.next() == o)
            {
                return true;
            }
        }
        return false;

    }

    //Slide 15
    public Iterator iterator()
    {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Object>
    {
        private Node _head = head;

        public boolean hasNext()
        {
            if(_head != null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public Object next()
        {
            if(_head != null)
            {
                Object _nextObj = _head.getObject();
                _head = _head.getNextNode();
                return _nextObj;
            }
            else
            {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    private class Node
    {
        private Node _next = null;
        private Object _object;

        public Node(Object element)
        {
            _object = element;
        }

        public Object getObject()
        {
            return _object;
        }

        public void setNextNode(Node element)
        {
            _next = element;
        }

        public Node getNextNode()
        {
            return _next;
        }
    }

}
