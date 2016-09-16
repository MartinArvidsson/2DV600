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
        try
        {
            size++;
            checkSize();
            checkIndex(index,values.length);
            for (int i = size-1; i > index; i--)
            {
                values[i] = values[i-1];
            }
            values[index] = n;

        }
        catch (Exception e)
        {
            System.out.println("An unexpected error has occured.");
        }
    }
    @Override
    public void remove(int index)
    {
        try
        {
            checkIndex(index,size);
            for (int i = index; i < size-1; i+= 1)
            {
                values[i] = values[i+1];
            }
            size--;

        }
        catch (Exception e)
        {
            System.out.println("An unexpected error has occured.");
        }
    }
    @Override
    public int get(int index)
    {
        checkIndex(index,size);
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