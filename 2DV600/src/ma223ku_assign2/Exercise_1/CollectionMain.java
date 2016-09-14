package ma223ku_assign2.Exercise_1;

/**
 * Created by Martin on 2016-09-14.
 */
public class CollectionMain
{
    public static void main(String[] args)
    {
        ArrayIntList _list = new ArrayIntList();
        ArrayIntStack _stack = new ArrayIntStack();

        _list.add(1);
        _list.add(2);
        _list.add(4);
        _list.addAt(3,2);
        System.out.println("-----------");
        System.out.println("---List----");
        System.out.println("-----------");
        System.out.println(_list.toString());
        _list.remove(2);
        System.out.println(_list.toString());
        System.out.println(_list.get(1));
        System.out.println(_list.indexOf(2));
        System.out.println(_list.indexOf(8));
        _stack.push(1);
        _stack.push(2);
        _stack.push(3);
        System.out.println("-----------");
        System.out.println("---Stack---");
        System.out.println("-----------");
        System.out.println(_stack.toString());
        System.out.println(_stack.peek());
        System.out.println(_stack.pop());
        System.out.println(_stack.toString());

    }
}
