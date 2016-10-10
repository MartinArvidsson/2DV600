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
    public Node addNodeFor(E item) //Try adding a node to the graph
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
    public Node getNodeFor(Object item) //Try to find the provided item in the graph
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
    public boolean addEdgeFor(E from, E to) //Try to add an edge between two nodes
    {
        if(from == null || to == null)
        {
            throw new RuntimeException("Recieved null as input");
        }

        MyNode<E> source = (MyNode<E>)addNodeFor(from);
        MyNode<E> target = (MyNode<E>)addNodeFor(to);

        if(source.hasSucc(target)) //If the connection already exists
        {
            return false;
        }
        else //Add the edge
        {
            source.addSucc(target);
            target.addPred(source);

            tails.remove(source);
            heads.remove(target);
            return true;
        }
    }

    @Override
    public boolean containsNodeFor(Object item) //Try to find the item, true if it exists in the graph
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
    public int edgeCount() //Count all nodes sucessors and add them together returns the value of edges.
    {
        int numberofedges = 0;


        for(MyNode _item : item2node.values())
        {
            numberofedges += _item.outDegree();
        }
        return numberofedges;
    }

    @Override
    public void removeNodeFor(Object item) //Try to remove the object from the graph
    {
        if(item == null && item2node.get(item) == null) //Exception if Object isn't valid
        {
            throw new RuntimeException("Null as input");
        }

        MyNode toremove = item2node.get(item); //Get the node

        if(toremove.isHead()) //If head/Tail remove from the list
        {
            heads.remove(item);
        }
        if(toremove.isTail())
        {
            tails.remove(item);
        }

        for(MyNode node: item2node.values()) //check all nodes if they have the item to be removed as pred or succ, if they do remove
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
        toremove.disconnect(); //Node Disconnect function
        item2node.remove(item); //Remove item from graph
    }

    @Override
    public boolean containsEdgeFor(Object from, Object to) //Is there a existing node between the provided parameters
    {
        if(from == null || to == null) //Exception if anyone is null
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
    public boolean removeEdgeFor(Object from, Object to) //Remove edge between two objects
    {
        if(from == null || to == null)
        {
            throw new RuntimeException("Recieved null as input");
        }
        if(containsEdgeFor(from,to)) //If an edge exists between two items
        {
            MyNode _from = item2node.get(from); //Remove connection between the nodes
            MyNode _to = item2node.get(to);
            _from.removeSucc(_to);
            _to.removePred(_from);

            if(_from.isTail()) //if the node is a tail and not added to the list of tails add it
            {
                if(!tails.contains(_from))
                {
                    tails.add(_from);
                }
            }

            if(_to.isHead()) //if the node is a head and not added to the list of heads add it.
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
        Iterator iterator = item2node.values().iterator(); //Iterate the map

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
