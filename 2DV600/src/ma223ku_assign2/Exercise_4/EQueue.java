package ma223ku_assign2.Exercise_4;

import java.util.Iterator;

/**
 * Created by Martin on 2016-09-20.
 */
//VERY CLOSELY RESEMBLES QUEUE FROM ASSIGNMENT 1, MOSTLY CHANGED FROM OBJECT TO E
public class EQueue<E> implements Queue<E>
{
    private int size;
    private Node head;
    private Node tail;

    public int size()
    {
        return size;
    } //Size of queue

    public boolean isEmpty()
    {
        return size == 0;
    } //If the queue is empty returns true

    public void enqueue(E element)
    {
        if(head == null)//If no elements exist, create one thats both head and tail.
        {
            head = new Node(element);
            tail = head;
        }
        else
        {
            tail.setNextNode(new Node(element)); //Add a node to the tail then make the new node the new tail
            tail = tail.getNextNode();
        }
        size++;
    }
    public E dequeue()
    {
        if(head != null)
        {
            Node _toRemove = head; //Object to remove
            head =_toRemove.getNextNode(); //Gets node next to the node to remove
            size--; //Reduces the size therefore removing the first object
            return _toRemove.getElement(); //Returns the object that got removed, I think this is what's supposed to be removed

        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }

    public E first()
    {
        if(head != null) //If a head exist returns the head.
        {
            return head.getElement();
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }

    public E last() //If a head exist return the tail. If the queue is only one element the head and tail is same.
    {
        if (head != null)
        {
            return tail.getElement();
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Iterator<E> iterator()
    {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E>
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

        public E next()
        {
            if(_head != null)
            {
                E _nextObj = _head.getElement();
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
        private E _element;

        public Node(E element)
        {
            _element = element;
        }

        public E getElement()
        {
            return _element;
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
