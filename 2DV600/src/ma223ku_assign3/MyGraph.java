package ma223ku_assign3;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by Martin on 2016-09-27.
 */
public class MyGraph<E> implements DirectedGraph<E>
{
    private Map<E,MyNode<E>> item2node;
    private Set<Node<E>> heads;
    private Set<Node<E>> tails;

    public MyGraph()
    {
        item2node = new HashMap<>();
        heads = new HashSet<>();
        tails = new HashSet<>();
    }

    @Override
    public Node addNodeFor(E item)
    {
        if(item == null)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            if(!item2node.containsKey(item))
            {
                MyNode _mynode = new MyNode<>(item);
                heads.add(_mynode);
                tails.add(_mynode);
                item2node.put(item, _mynode);
            }
            return item2node.get(item);
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
        if(item == null)
        {
            throw new IndexOutOfBoundsException();
        }
        return item2node.get(item) != null;
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
        ArrayList list = new ArrayList();
        for(MyNode _item : item2node.values())
        {
            list.add(_item.item());
        }
        return list;
    }

    @Override
    public int edgeCount()
    {
        int numberofedges = 0;


        for(MyNode _item : item2node.values())
        {
            numberofedges += _item.outDegree();
        }
        return numberofedges;
    }

    @Override
    public void removeNodeFor(Object item)
    {
        if(item == null && item2node.get(item) == null)
        {
            throw new RuntimeException("Null as input");
        }

        MyNode toremove = item2node.get(item);
        if(toremove.isHead())
        {
            heads.remove(item);
        }
        if(toremove.isTail())
        {
            tails.remove(item);
        }

        for(MyNode node: item2node.values())
        {
            if(node.hasPred(toremove))
            {
                node.removePred(toremove);
                if(node.isHead())
                {
                    heads.add(node);
                }
            }
            if(node.hasSucc(toremove))
            {
                node.removeSucc(toremove);
                if(node.isTail())
                {
                    heads.add(node);
                }
            }
        }
        toremove.disconnect();
        item2node.remove(item);
    }

    @Override
    public boolean containsEdgeFor(Object from, Object to)
    {
        if(from == null || to == null)
        {
            throw new IndexOutOfBoundsException();
        }
        if(!containsNodeFor(from) && !containsNodeFor(to))
        {
            return false;
        }

        return item2node.get(from).hasSucc(item2node.get(to));
    }

    @Override
    public boolean removeEdgeFor(Object from, Object to)
    {
        if(from == null || to == null)
        {
            throw new RuntimeException("Recieved null as input");
        }
        if(containsEdgeFor(from,to))
        {
            MyNode _from = item2node.get(from);
            MyNode _to = item2node.get(to);
            _from.removeSucc(_to);
            _to.removePred(_from);

            if(_from.isTail())
            {
                if(!tails.contains(_from))
                {
                    tails.add(_from);
                }
            }

            if(_to.isHead())
            {
                if(!heads.contains(_to))
                {
                    heads.add(_to);
                }
            }

            return true;
        }

        return false;
    }

    private class mapiterator implements Iterator<Node<E>>
    {
        Iterator iterator = item2node.values().iterator();

        @Override
        public boolean hasNext()
        {
           return iterator.hasNext();
        }
        @Override
        public MyNode next()
        {
            MyNode<E> node = (MyNode<E>)iterator.next();
            return node;
        }
    }
}
