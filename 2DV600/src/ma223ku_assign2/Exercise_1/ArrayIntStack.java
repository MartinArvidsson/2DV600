package ma223ku_assign2.Exercise_1;


import ma223ku_assign2.Exercise_1.da1031.AbstractIntCollection;
import ma223ku_assign2.Exercise_1.da1031.IntStack;

/**
 * Created by Martin on 2016-09-14.
 */
public class ArrayIntStack extends AbstractIntCollection implements IntStack
{
    public void push(int n)
    {
//
//        size ++;
//        checkSize();

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

    public int pop()
    {
        int removedInt = 0;
        try
        {
            removedInt = values[0];

            for (int i = 0; i < size-1; i+= 1)
            {
                values[i] = values[i+1];
            }
            size--;
        }
        catch (Exception e)
        {
            System.out.println("An error occured :(");
        }
        return removedInt;
    }

    public int peek()
    {
        int valueToReturn = 0;
        try
        {
            valueToReturn = values[0];
        }
        catch (Exception e)
        {
            System.out.println("An unexpected error occured");
        }
        return valueToReturn;
    }


    public void checkSize()
    {
        if(size() == values.length)
        {
            resize();
        }
    }
}
