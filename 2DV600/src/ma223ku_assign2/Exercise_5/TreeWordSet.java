package ma223ku_assign2.Exercise_5;

import java.util.Iterator;

/**
 * Created by Martin on 2016-09-23.
 */
public class TreeWordSet implements WordSet
{
    //Many functions are taken from the presentationslides
    private int size = 0;
    private Node root = null;
    public void add(Word word)
    {
        if(root == null)
        {
            size++;
            root = new Node(word);
        }
        else
        {
            if(contains(word))
            {
                return;
            }
            size++;
            root.add(word);
        }
    }

    private class Node
    {
        Word value;
        Node left = null, right = null;

        Node(Word _word)
        {
            value = _word;
        }

        void add(Word word)
        {
            if(word.compareTo(value) < 0)
            {
                if(left == null)
                {
                    left = new Node(word);
                }
                else
                {
                    left.add(word);
                }
            }
            else if(word.compareTo(value) > 0)
            {
                if(right == null)
                {
                    right = new Node(word);
                }
                else
                {
                    right.add(word);
                }
            }
        }

        boolean contains(Word word)
        {
            if(word.compareTo(value) < 0)
            {
                if(left == null)
                {
                    return false;
                }
                else
                {
                    return left.contains(word);
                }
            }
            else if(word.compareTo(value) > 0)
            {
                if(right == null)
                {
                    return false;
                }
                else
                {
                    return right.contains(word);
                }
            }
            return true;
        }
    }

    public boolean contains(Word word) //Uses the node function to check if value exist.
    {
        return root.contains(word);
    }

    public int size()
    {
        return size;
    }

    public String toString() //Iterate all items and add them to a string as we go along.
    {                        //When all items are iterated return the string with all information.
        Iterator<Word> iterator = iterator();
        String textcontent ="";
        while(iterator.hasNext())
        {
            textcontent += iterator.next() + " , ";
        }
        return textcontent;
    }

    public Iterator<Word> iterator()
    {
        return new WordIterator();
    }

    private class WordIterator implements Iterator<Word>
    {
        private EQueue _queue = new EQueue<Word>();
        private int index = 0;
        public WordIterator()
        {
            iterateTree(root);
        }

        public void iterateTree(Node word) // The print method from the slides
        {
            if ( word.left != null ) // visit left child
            {
                iterateTree(word.left);
            }
            _queue.enqueue(word);
            if ( word.right != null ) // visit right child
            {
                iterateTree(word.right);
            }
        }

        public Word next()
        {
            Node node = (Node)_queue.dequeue();
            return node.value;
        }

        public boolean hasNext()
        {
            if(_queue.isEmpty())
            {
                return false;
            }
            return true;
        }
    }
}