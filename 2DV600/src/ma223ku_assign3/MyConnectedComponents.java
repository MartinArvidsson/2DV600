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

        MyDFS dfs = new MyDFS(); //DFS to use for iterating

        Iterator<Node<E>> nodeiterator = dg.iterator();
        while(nodeiterator.hasNext())  //Iterate the graph
        {
            isConnection = false;
            Node<E> item = nodeiterator.next();
            if(!visitedNodes.contains(item)) //If item hasn't been visisted
            {
                dfscomponents = dfs.dfs(dg,item); //dfs search on current node
                for(Node<E> _item : dfscomponents) //All items in the dfs
                {
                    if(visitedNodes.contains(_item))//if the item has been checked before
                    {
                        for(Collection<Node<E>> _c : collectionOfNodeCollections) //Check what collection the item is saved in
                        {
                            if(_c.contains(_item))
                            {
                                isConnection = true;
                                visitedNodes.addAll(dfscomponents); //Add all to visited
                                _c.addAll(dfscomponents); //Add current items to the collection that the item also was part of
                            }
                        }
                    }
                }
                if(!isConnection) //if no item was previously added
                {
                    visitedNodes.addAll(dfscomponents);
                    components = new HashSet<>(); //new collection,add items, add collection to collectionofcollections
                    components.addAll(dfscomponents);
                    collectionOfNodeCollections.add(components);
                }
            }
            visitedNodes.add(item);

        }
        return collectionOfNodeCollections;
    }
}
