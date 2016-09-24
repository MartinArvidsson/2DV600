package ma223ku_assign2.Exercise_5;

import java.util.Iterator;

/**
 * Created by marti on 2016-09-22.
 */
public class HashWordSet implements WordSet
{
    //http://homepage.lnu.se/staff/jlnmsi/fost/lectures/collections.pdf

    //Most of the functions are taken from the presentationslides linked above. The functions have only been altered from adding String  to adding Word
    private Node[] buckets = new Node[8];
    private int size;
    @Override
    public void add(Word word)
    {
        int pos = getBucketNumber(word);
        Node node = buckets[pos]; //First node in list
        while (node != null) //Go through all elements
        {
            if (node.value.equals(word)) //If value found return
            {
                return;
            }
            else
            {
                node = node.next; //Next node
            }
        }
        node = new Node(word); //Add new node.
        node.next = buckets[pos ];
        buckets [pos] = node;
        size++;
        if (size == buckets.length) //If maxsize has been reached, rehash.
        {
            rehash();
        }
    }
    @Override
    public boolean contains(Word word)
    {
        int pos = getBucketNumber(word);
        Node node = buckets[pos];
        while (node != null) //Search through all items
        {
            if (node.value. equals( word ))
            {
                return true;
            }
            else
            {
                node = node.next;
            }
        }
        return false ;
    }
    public int getBucketNumber(Word word)
    {
        int hc = word.hashCode();
        if (hc < 0)
        {
            hc = -hc;
        }
        return hc % buckets.length;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public String toString()
    {
        Iterator<Word> iterator = iterator();
        String textcontent ="";
        while(iterator.hasNext())
        {
            textcontent += iterator.next() + ", ";
        }
        return textcontent;
    }

    public void rehash()
    {
        Node[] temp = buckets; //Old buckets
        buckets = new Node[2*temp.length]; //New with double the amount
        size = 0;
        for (Node n : temp) //Move old into new
        {
            if (n == null) continue;
            while (n != null )
            {
                add(n.value);
                n = n.next;
            }
        }

    }
    private class Node //Node placed in buckets
    {
        Word value;
        Node next = null;
        public Node (Word _word )
        {
            value = _word;
        }
        public String toString ()
        {
            return value.toString();
        }

    }

    @Override
    public Iterator<Word> iterator()
    {
        return new wordIterator();
    }

    private class wordIterator implements Iterator<Word> //Iterate all items
    {
        private Node next;
        private int index = 0;

        public wordIterator()
        {
            next = findBucket();
        }
        public boolean hasNext()
        {
            return next != null;
        }

        public Node findBucket() //Find a bucket that contains items
        {
            for (int i = index; i < buckets.length; i++)
            {
                if (buckets[i] != null)
                {
                    index = i + 1; //So the iterator starts again at next item and don't enter the same bucket twice
                    return buckets[i];
                }
            }
            return null;
        }

        public Word next() //Returns Word in bucket
        {
            Word toReturn = next.value;
            if (next.next != null)
            {
                next = next.next;
            }
            else
            {
                next = findBucket(); //If all items have been returned keep looking for new buckets with items in them.
            }
            return toReturn;
        }
    }
}
