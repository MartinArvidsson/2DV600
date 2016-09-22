package ma223ku_assign2.Exercise_5;

import java.util.Iterator;

/**
 * Created by marti on 2016-09-22.
 */
public class HashWordSet implements WordSet
{
    //http://homepage.lnu.se/staff/jlnmsi/fost/lectures/collections.pdf
    //http://homepage.lnu.se/staff/jlnmsi/fost/pa1_5.htm
    private int size;
    @Override
    public void add(Word word)
    {

    }
    @Override
    public boolean contains(Word word)
    {

    }

    @Override
    public int size()
    {

    }

    @Override
    public String toString()
    {

    }

    public void rehash()
    {

    }

    @Override
    public Iterator<Word> iterator()
    {
        return new wordIterator();
    }

    private class wordIterator implements Iterator<Word>
    {
        private int index;

        public wordIterator()
        {

        }
    }
}
