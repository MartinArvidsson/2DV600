package ma223ku_assign3;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by Martin on 2016-09-27.
 */
public class MyGraph<E> implements DirectedGraph<E>
{
    private Map<E,MyNode<E>> item2node = new HashMap<E, MyNode<E>>();
    private Set<Node<E>> heads = new HashSet<>();
    private Set<Node<E>> tails = new HashSet<>();
    @Override
    public Node addNodeFor(E item)
    {
        if(item == null)
        {
            throw new IndexOutOfBoundsException();
        }
        if (containsNodeFor(item))
        {
            System.out.println("Item already exist in the hashset");
            return null;
        } else
        {
            MyNode _mynode = new MyNode<>(item);
            item2node.put(item, _mynode);
            return _mynode;
        }
    }

    @Override
    public Node getNodeFor(Object item)
    {

        if(item == null)
        {
            throw new RuntimeException("Null as input");
        }
        else if (item2node.get(item) != null)
        {
            return item2node.get(item);
        }
        else if (item2node.get(item) == null)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            return null;
        }
    }
    @SuppressWarnings("unchecked cast")
    @Override
    public boolean addEdgeFor(E from, E to)
    {
        if(from == null || to == null)
        {
            throw new RuntimeException("Recieved null as input");
        }

        MyNode<E> source = (MyNode<E>)addNodeFor(from);
        MyNode<E> target = (MyNode<E>)addNodeFor(to);

        if(source.hasSucc(target))
        {
            return false;
        }
        else
        {
            source.addSucc(target);
            target.addPred(source);

            tails.remove(source);
            heads.remove(target);
            return true;
        }
    }

    @Override
    public boolean containsNodeFor(Object item)
    {
        if(item2node.containsKey(item))
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    @Override
    public int nodeCount()
    {
        return item2node.size();
    }

    @Override
    public Iterator<Node<E>> iterator()
    {
        return new mapiterator();
    }

    @Override
    public Iterator<Node<E>> heads()
    {
        return heads.iterator();
    }

    @Override
    public int headCount()
    {
        return heads.size();
    }

    @Override
    public Iterator<Node<E>> tails()
    {
        return tails.iterator();
    }

    @Override
    public int tailCount()
    {
        return tails.size();
    }

    @Override
    public List allItems()
    {
        return null;
    }

    @Override
    public int edgeCount()
    {
        return 0;
    }

    @Override
    public void removeNodeFor(Object item)
    {

    }

    @Override
    public boolean containsEdgeFor(Object from, Object to)
    {
        if(from == null || to == null)
        {
            throw new RuntimeException("Recieved null as input");
        }

        return false;
    }

    @Override
    public boolean removeEdgeFor(Object from, Object to)
    {
        if(from == null || to == null)
        {
            throw new RuntimeException("Recieved null as input");
        }

        return false;
    }

    private class mapiterator implements Iterator<Node<E>>
    {
        Iterator iterator = item2node.entrySet().iterator();

        @Override
        public boolean hasNext()
        {
           return iterator.hasNext();
        }

        public MyNode next()
        {
            MyNode<E> node = (MyNode<E>)iterator.next();
            return node;
        }
    }
}
