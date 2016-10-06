package ma223ku_assign3;

import graphs.DirectedGraph;
import graphs.Node;
import graphs.TransitiveClosure;

import java.util.*;

/**
 * Created by Martin on 2016-09-30.
 */
public class MyTransitiveClosure<E> implements TransitiveClosure<E>
{
    @Override
    public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg)
    {
        Map<Node<E>,Collection<Node<E>>> nodemap = new HashMap<>();
        MyDFS dfs = new MyDFS();

        Iterator<Node<E>> iterator = dg.iterator();

        while(iterator.hasNext())
        {
            Node<E> nodeitem = iterator.next();
            List i = dfs.dfs(dg,nodeitem);
            nodemap.put(nodeitem,i);
        }
        return nodemap;
    }
}
