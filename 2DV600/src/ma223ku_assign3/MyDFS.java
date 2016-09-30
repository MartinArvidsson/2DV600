package ma223ku_assign3;

import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.List;

/**
 * Created by Martin on 2016-09-30.
 */
public class MyDFS<E> implements DFS<E>
{

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root)
    {
        return null;
    }

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph)
    {
        return null;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root)
    {
        return null;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g)
    {
        return null;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number)
    {
        return null;
    }

    @Override
    public boolean isCyclic(DirectedGraph<E> graph)
    {
        return false;
    }

    @Override
    public List<Node<E>> topSort(DirectedGraph<E> graph)
    {
        return null;
    }
}
