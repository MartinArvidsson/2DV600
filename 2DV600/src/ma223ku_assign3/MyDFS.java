package ma223ku_assign3;

import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;
import org.w3c.dom.NodeList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Martin on 2016-09-30.
 */
public class MyDFS<E> implements DFS<E>
{

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root)
    {
        List<Node<E>> nodes = new ArrayList<>();
        root = graph.getNodeFor(root.item());
        return dfs(root,nodes);
    }

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph)
    {
        List<Node<E>> nodes = new ArrayList<>();
        Iterator<Node<E>> nodeiterator = graph.heads();

        while(nodeiterator.hasNext())
        {
            Node<E> item = nodeiterator.next();
            if(!nodes.contains(item))
            {
                nodes.add(item);
            }
            nodes = dfs(item,nodes);
        }
        return nodes;
    }

    private List<Node<E>> dfs(Node root,List<Node<E>> nodelist)
    {
        Iterator<Node<E>> nodeiterator = root.succsOf();
        root.num = nodelist.size();
        nodelist.add(root);

        while(nodeiterator.hasNext())
        {
            Node<E> nextItem = nodeiterator.next();
            if(!nodelist.contains(nextItem))
            {
                dfs(nextItem,nodelist);
            }
        }
        return nodelist;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root)
    {
        ArrayList<Node<E>> nodes = new ArrayList<>();
        ArrayList<Node<E>> nodesvisited = new ArrayList<>();
        root = g.getNodeFor(root.item());

        return postOrder(nodes,nodesvisited,root);
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g)
    {
        List<Node<E>> nodes = new ArrayList<>();
        List<Node<E>> nodesvisited = new ArrayList<>();
        Iterator<Node<E>> nodeiterator = g.heads();

        while(nodeiterator.hasNext())
        {
            Node<E> nextItem = nodeiterator.next();
            nodes = postOrder(nodes,nodesvisited,nextItem);
        }

        return nodes;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number)
    {
        //Fixa sen
        return null;
    }


    private List<Node<E>> postOrder(List<Node<E>> nodes,List<Node<E>> visitednodes,Node<E> root)
    {
        if(!visitednodes.contains(root))
        {
            Iterator<Node<E>> nodeiterator = root.succsOf();
            visitednodes.add(root);
            while(nodeiterator.hasNext())
            {
                Node<E> nextitem = nodeiterator.next();
                if(!nodes.contains(nextitem))
                {
                    postOrder(nodes,visitednodes,nextitem);
                }
            }
            root.num = nodes.size() +1;
            nodes.add(root);
        }
        return nodes;
    }

    @Override
    public boolean isCyclic(DirectedGraph<E> graph)
    {
        for(E item : graph.allItems())
        {
            Node<E> _node = graph.getNodeFor(item);
            Iterator iterator = _node.succsOf();
            while(iterator.hasNext())
            {
                if(iterator.next() == _node)
                {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<Node<E>> topSort(DirectedGraph<E> graph)
    {
        List<Node<E>> nodes = new ArrayList<>();
        ArrayList<Node<E>> nodesvisited = new ArrayList<>();
        Iterator<Node<E>> nodeiterator = graph.heads();

        while(nodeiterator.hasNext())
        {
            nodes = postOrder(nodes,nodesvisited,nodeiterator.next());
        }

        Collections.reverse(nodes);
        return nodes;
    }
}
