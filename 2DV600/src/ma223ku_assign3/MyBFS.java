package ma223ku_assign3;

import graphs.BFS;
import graphs.DirectedGraph;
import graphs.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Martin on 2016-09-30.
 */
public class MyBFS<E> implements BFS<E>
{
    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root)
    {
        List<Node<E>> nodes = new ArrayList<>();
        List<Node<E>> visitednodes = new ArrayList<>();
        HashSet<Node<E>> nodeset = new HashSet<>();
        nodeset.add(root);


        return bfs(nodes,visitednodes,nodeset);
    }

    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph)
    {
        List<Node<E>> nodes = new ArrayList<>();
        List<Node<E>> visitednodes = new ArrayList<>();
        HashSet<Node<E>> nodeset = new HashSet<>();

        Iterator<Node<E>> iterator = graph.heads();
        while(iterator.hasNext())
        {
            Node<E> nextitem = iterator.next();
            if(!visitednodes.contains(nextitem))
            {
                nextitem.num = visitednodes.size();
                visitednodes.add(nextitem);
                nodeset.add(nextitem);
                nodes.add(nextitem);
                nodes = bfs(nodes,visitednodes,nodeset);
            }
        }

        return nodes;
    }

    private List<Node<E>> bfs(List<Node<E>> nodelist,List<Node<E>> visitednodes,HashSet<Node<E>> nodeset)
    {
        Iterator<Node<E>> iterator = nodeset.iterator();
        HashSet<Node<E>> newset = new HashSet<>();
        while(iterator.hasNext())
        {
            Node<E> nextitem = iterator.next();
            if(!visitednodes.contains(nextitem))
            {
                nextitem.num = visitednodes.size();
                visitednodes.add(nextitem);
                nodelist.add(nextitem);
            }
            Iterator<Node<E>> succsiterator = nextitem.succsOf();
            while (succsiterator.hasNext())
            {
                Node<E> successor = succsiterator.next();
                if(!visitednodes.contains(successor))
                {
                    newset.add(successor);
                }
            }
        }
        if(!newset.isEmpty())
        {
            bfs(nodelist,visitednodes,newset);
        }
        return nodelist;
    }



}
