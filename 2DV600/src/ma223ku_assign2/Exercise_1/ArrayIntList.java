package ma223ku_assign2.Exercise_1;

/**
 * Created by Martin on 2016-09-14.
 */
import ma223ku_assign2.Exercise_1.da1031.AbstractIntCollection;
import ma223ku_assign2.Exercise_1.da1031.IntList;

public class ArrayIntList extends AbstractIntCollection implements IntList
{
    @Override
    public void add(int n) //Check first if we need to use the provided resize function, after that add a number at the end of the list, increase size after adding item.
    {
        checkSize();
        values[size] = n;
        size++;
    }
    @Override
    public void addAt(int n,int index) //Add a value to a specific index. Move all other numbers to the right. Increase size since we added a new item.
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
    public void remove(int index) //Index is used to find the item to remove, remove the item on the specific index and move all other items after the removed item
    {                             //Reduce size after item has been removed aswell.
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
    public int get(int index) //Index is used to find the specific item on that position. Return it without removing. If index value is out of range, throw exception.
    {
        if(index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }
        return values[index];
    }

    @Override
    public int indexOf(int n) //Send a value ex "2". Look in the list for the specific item. if found return the index, else returns -1.
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

    private void checkSize() //Used to check if a  resize is needed , if a resize is needed use the provided function in "AbstractIntCollection"
    {
        if(size() == values.length)
        {
            resize();
        }
    }


}
