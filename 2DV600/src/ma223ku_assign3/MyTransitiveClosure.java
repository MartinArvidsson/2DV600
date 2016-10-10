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
        Map<Node<E>,Collection<Node<E>>> nodemap = new HashMap<>(); //Map to save in.
        MyDFS dfs = new MyDFS(); //DFS to use when searching

        Iterator<Node<E>> iterator = dg.iterator(); //Iterate the map

        while(iterator.hasNext())
        {
            Node<E> nodeitem = iterator.next();
            List i = dfs.dfs(dg,nodeitem); //Dfs search on current node and graph
            nodemap.put(nodeitem,i); //Save in map
        }
        return nodemap; //Return map when all items have been iterated
    }
}
