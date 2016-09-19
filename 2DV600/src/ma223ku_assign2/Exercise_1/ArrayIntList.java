package ma223ku_assign2.Exercise_1;

/**
 * Created by Martin on 2016-09-14.
 */
import ma223ku_assign2.Exercise_1.da1031.AbstractIntCollection;
import ma223ku_assign2.Exercise_1.da1031.IntList;

public class ArrayIntList extends AbstractIntCollection implements IntList
{
    @Override
    public void add(int n)
    {
        checkSize();
        values[size] = n;
        size++;
    }
    @Override
    public void addAt(int n,int index)
    {
        if(index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }
        size++;
        checkSize();
        for (int i = size-1; i > index; i--)
        {
            values[i] = values[i-1];
        }
        values[index] = n;
    }
    @Override
    public void remove(int index)
    {
        if(index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size-1; i+= 1)
        {
            values[i] = values[i+1];
        }
        size--;
    }
    @Override
    public int get(int index)
    {
        if(index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }
        return values[index];
    }

    @Override
    public int indexOf(int n)
    {
        for (int i = 0; i < size; i++)
        {
            if(values[i] == n)
            {
                return i;
            }
        }
        return -1;
    }

    private void checkSize()
    {
        if(size() == values.length)
        {
            resize();
        }
    }


}
