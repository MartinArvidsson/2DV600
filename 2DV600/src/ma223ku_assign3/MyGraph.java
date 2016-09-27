package ma223ku_assign3;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Martin on 2016-09-27.
 */
public class MyGraph implements DirectedGraph
{
    public MyGraph()
    {

    }

    @Override
    public Node addNodeFor(Object item)
    {
        return null;
    }

    @Override
    public Node getNodeFor(Object item)
    {
        return null;
    }

    @Override
    public boolean addEdgeFor(Object from, Object to)
    {
        return false;
    }

    @Override
    public boolean containsNodeFor(Object item)
    {
        return false;
    }

    @Override
    public int nodeCount()
    {
        return 0;
    }

    @Override
    public Iterator<Node> iterator()
    {
        return null;
    }

    @Override
    public Iterator<Node> heads()
    {
        return null;
    }

    @Override
    public int headCount()
    {
        return 0;
    }

    @Override
    public Iterator<Node> tails()
    {
        return null;
    }

    @Override
    public int tailCount()
    {
        return 0;
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
        return false;
    }

    @Override
    public boolean removeEdgeFor(Object from, Object to)
    {
        return false;
    }
}
