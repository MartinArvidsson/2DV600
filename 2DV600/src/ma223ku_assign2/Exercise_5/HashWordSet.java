package ma223ku_assign2.Exercise_5;

import java.util.Iterator;

/**
 * Created by marti on 2016-09-22.
 */
public class HashWordSet implements WordSet
{
    //http://homepage.lnu.se/staff/jlnmsi/fost/lectures/collections.pdf
    //http://homepage.lnu.se/staff/jlnmsi/fost/pa1_5.htm
    private Node[] buckets = new Node[8];
    private int size;
    @Override
    public void add(Word word)
    {
        int pos = getBucketNumber(word);
        Node node = buckets[pos]; // First node in list
        while (node != null) { // Search list
            if (node.value. equals( word ))
                return; // Element found ==> return
            else
                node = node.next; // Next node in list
        }
        node = new Node(word); // Not found, add new node as first entry
        node.next = buckets[pos ];
        buckets [pos] = node;
        size++;
        if (size == buckets.length) rehash (); // Rehash if needed
    }
    @Override
    public boolean contains(Word word)
    {
        int pos = getBucketNumber(word);
        Node node = buckets[pos];
        while (node != null) { // Search list for element
            if (node.value. equals( word ))
                return true; // Found!
            else
                node = node.next;
        }
        return false ; // Not found
    }
    public int getBucketNumber(Word word)
    {
        int hc = word.hashCode(); // Use hashCode() from String class
        if (hc < 0) hc = -hc; // Make sure non−negative
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
        return "";
    }

    public void rehash()
    {
        Node[] temp = buckets; // Copy of old buckets
        buckets = new Node[2*temp.length];
        size = 0;
        for (Node n : temp)
        { // Insert old values into new buckets
            if (n == null) continue; // Empty bucket
            while (n != null )
            {
                add(n.value); // Add elements again
                n = n.next;
            }
        }

    }
    private class Node
    {
        Word value ;
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

    private class wordIterator implements Iterator<Word>
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

        public Node findBucket()
        {
            for (int i = index; i < buckets.length; i++)
            {
                if (buckets[i] != null)
                {
                    index = i + 1;
                    return buckets[i];
                }
            }
            return null;
        }

        public Word next()
        {
            //System.out.println(size);
            Word toReturn = next.value;
            if (next.next != null)
            {
                next = next.next;
            }
            else
            {
                next = findBucket();
            }
            return toReturn;
        }
    }
}
