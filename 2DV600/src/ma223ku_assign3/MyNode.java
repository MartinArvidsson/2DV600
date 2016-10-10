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
        return succs.contains(node);
    }

    @Override
    public int outDegree()
    {
        return succs.size();
    }

    @Override
    public Iterator<Node<E>> succsOf()
    {
        return succs.iterator();
    }

    @Override
    public boolean hasPred(Node<E> node)
    {
        return preds.contains(node);
    }

    @Override
    public int inDegree()
    {
        return preds.size();
    }

    @Override
    public Iterator<Node<E>> predsOf()
    {
        return preds.iterator();
    }

    @Override
    protected void addSucc(Node<E> succ)
    {
        succs.add(succ);
    }

    @Override
    protected void removeSucc(Node<E> succ)
    {
        succs.remove(succ);
    }

    @Override
    protected void addPred(Node<E> pred)
    {
        preds.add(pred);
    }

    @Override
    protected void removePred(Node<E> pred)
    {
        preds.remove(pred);
    }

    @SuppressWarnings("unchecked cast")
    @Override
    protected void disconnect()
    {
        Iterator iterator = predsOf(); //Iterate over all preds and remove this node as a sucessor
        while(iterator.hasNext())
        {
            MyNode<E> node = (MyNode<E>)iterator.next();
            node.removeSucc(this);
        }

        Iterator _iterator = succsOf(); //Iterate over all succs and remove this node as a pred

        while(_iterator.hasNext())
        {
            MyNode<E> node = (MyNode<E>)_iterator.next();
            node.removePred(this);

        }
        //Removes all preds and sucs.
        preds.clear();
        succs.clear();
    }
}
