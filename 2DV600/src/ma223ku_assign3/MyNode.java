package ma223ku_assign3;


import graphs.Node;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Martin on 2016-09-27.
 */
public class MyNode<E> extends Node<E>
{
    private Set<Node<E>> preds = new HashSet<>();
    private Set<Node<E>> succs = new HashSet<>();
    public int num;

    /**
     * Constructs a new node using <tt>item</tt> as key.
     *
     * @param item
     */
    protected MyNode(E item)
    {
        super(item);
    }

    @Override
    public boolean hasSucc(Node<E> node)
    {
        return false;
    }

    @Override
    public int outDegree()
    {
        return 0;
    }

    @Override
    public Iterator<Node<E>> succsOf()
    {
        return null;
    }

    @Override
    public boolean hasPred(Node<E> node)
    {
        return false;
    }

    @Override
    public int inDegree()
    {
        return 0;
    }

    @Override
    public Iterator<Node<E>> predsOf()
    {
        return null;
    }

    @Override
    protected void addSucc(Node<E> succ)
    {
        succs.add(succ);
    }

    @Override
    protected void removeSucc(Node<E> succ)
    {

    }

    @Override
    protected void addPred(Node<E> pred)
    {

    }

    @Override
    protected void removePred(Node<E> pred)
    {

    }

    @Override
    protected void disconnect()
    {

    }
}
