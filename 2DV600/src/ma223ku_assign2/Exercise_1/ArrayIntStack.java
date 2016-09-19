package ma223ku_assign2.Exercise_1;


import ma223ku_assign2.Exercise_1.da1031.AbstractIntCollection;
import ma223ku_assign2.Exercise_1.da1031.IntStack;

/**
 * Created by Martin on 2016-09-14.
 */
public class ArrayIntStack extends AbstractIntCollection implements IntStack
{
    @Override
    public void push(int n)
    {
        if(isEmpty())
        {
            values[0] = n;
            size++;
        }
        else
        {
            int temp = values[0];
            int _temp;
            for (int i = 0; i < size; i++)
            {
                checkSize();
                if(values[i + 1] == 0)
                {
                    values[i+1] = temp;
                    temp = values[i];
                }
                else
                {
                    _temp = values[i + 1];
                    values[i + 1] = temp;
                    temp = _temp;
                }
            }
            size++;
        }
        values[0] = n;
    }
    @Override
    public int pop()
    {
        if(size == 0)
        {
            throw new IndexOutOfBoundsException();
        }
        int removedInt = 0;
        removedInt = values[0];

        for (int i = 0; i < size-1; i+= 1)
        {
            values[i] = values[i+1];
        }
        size--;
        return removedInt;
    }
    @Override
    public int peek()
    {
        if(size == 0)
        {
            throw new IndexOutOfBoundsException();
        }
        int valueToReturn = values[0];
        return valueToReturn;
    }


    private void checkSize()
    {
        if(size() == values.length)
        {
            resize();
        }
    }
}
