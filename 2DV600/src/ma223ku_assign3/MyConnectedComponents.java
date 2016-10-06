package ma223ku_assign3;

import graphs.ConnectedComponents;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Martin on 2016-09-30.
 */
public class MyConnectedComponents<E> implements ConnectedComponents<E>
{
    @Override
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg)
    {
        Collection<Node<E>> components = new ArrayList<>();
        Iterator<Node<E>> iterator = dg.iterator();

        while(iterator.hasNext())
        {
            components.add(iterator.next());
        }
        for(Node<E> item : components)
        {
            if(item.succsOf() != item.predsOf())
            {

            }
        }
        return null;
    }
}
