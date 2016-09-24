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
        if(isEmpty()) //If there are no items in the stack, add a new item at the first pos. also increase size by one
        {
            size++;
            values[0] = n;
        }
        else //Move all items and place the new item at the first position. increase size by one aswell.
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
    public int pop() //Remove the first position. if no items are avalible to remove, throw exception instead.
    {
        if(size == 0)
        {
            throw new IndexOutOfBoundsException();
        }
        int removedInt;
        removedInt = values[0];

        for (int i = 0; i < size-1; i+= 1)
        {
            values[i] = values[i+1];
        }
        size--;
        return removedInt;
    }
    @Override
    public int peek() //Return first item, if there are no item to return. throw exception.
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
        if(size() == values.length) //If we have filled the stack and no more positions are avalible, resize it, increasing the size.
        {
            resize();
        }
    }
}
