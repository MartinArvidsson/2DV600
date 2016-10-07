package ma223ku_assign3;

import graphs.ConnectedComponents;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by Martin on 2016-09-30.
 */
public class MyConnectedComponents<E> implements ConnectedComponents<E>
{
    @Override
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg)
    {
        Collection<Node<E>> components;
        List<Node<E>> dfscomponents;
        Collection<Node<E>> visitedNodes = new HashSet<>();
        Collection<Collection<Node<E>>> collectionOfNodeCollections = new HashSet<>();
        boolean isConnection;

        MyDFS dfs = new MyDFS();

        Iterator<Node<E>> nodeiterator = dg.iterator();
        while(nodeiterator.hasNext())
        {
            isConnection = false;
            Node<E> item = nodeiterator.next();
            if(!visitedNodes.contains(item))
            {
                dfscomponents = dfs.dfs(dg,item);
                for(Node<E> _item : dfscomponents)
                {
                    if(visitedNodes.contains(_item))
                    {
                        for(Collection<Node<E>> _c : collectionOfNodeCollections)
                        {
                            if(_c.contains(_item))
                            {
                                isConnection = true;
                                visitedNodes.addAll(dfscomponents);
                                _c.addAll(dfscomponents);
                            }
                        }
                    }
                }
                if(!isConnection)
                {
                    visitedNodes.addAll(dfscomponents);
                    components = new HashSet<>();
                    components.addAll(dfscomponents);
                    collectionOfNodeCollections.add(components);
                }
            }
            visitedNodes.add(item);

        }
        return collectionOfNodeCollections;
    }
}
