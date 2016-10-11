package ma223ku_assign3;

import graphs.DFS;
import graphs.DirectedGraph;
import graphs.Node;
import java.util.*;

/**
 * Created by Martin on 2016-09-30.
 */
public class MyDFS<E> implements DFS<E>
{

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root)
    {
        List<Node<E>> nodes = new ArrayList<>(); //For storing the nodes found
        return dfs(root,nodes);
    }

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph)
    {
        List<Node<E>> nodes = new ArrayList<>();//Storage of the nodes.
        if(graph.headCount() > 0)
        {
            Iterator<Node<E>> nodeiterator = graph.heads(); //Since no root node is provided, iterate all heads instead.
            while(nodeiterator.hasNext()) //Iterate heads if avalible, else specific node
            {
                Node<E> nextItem = nodeiterator.next();
                nodes = dfs(nextItem,nodes);
            }
        }
        else
        {
            Node<E> _nextItem = graph.getNodeFor(graph.allItems().get(0));
            nodes = dfs(_nextItem,nodes);
        }
        return nodes;
    }

    private List<Node<E>> dfs(Node root,List<Node<E>> nodelist)
    {
        Iterator<Node<E>> nodeiterator = root.succsOf(); //Find all sucessors of the startnode
        root.num = nodelist.size(); //Add a number to the node
        if(!nodelist.contains(root))//If the node hasn't been added , add it to the list.
        {
            nodelist.add(root);
        }
        while(nodeiterator.hasNext()) //While the node has sucessors, repeat the process until no more sucessors can be found.
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

        return postOrder(nodes,nodesvisited,root);
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g)
    {
        List<Node<E>> nodes = new ArrayList<>();
        List<Node<E>> nodesvisited = new ArrayList<>();
        if(g.headCount() > 0)
        {
            Iterator<Node<E>> nodeiterator = g.heads();
            while(nodeiterator.hasNext()) //Iterate heads if avalible, else specific node
            {
                Node<E> nextItem = nodeiterator.next();
                nodes = postOrder(nodes,nodesvisited,nextItem);

            }
        }
        else
        {

            Node<E> _nextItem = g.getNodeFor(g.allItems().get(0));
            nodes = postOrder(nodes,nodesvisited,_nextItem);
        }


        return nodes;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number)
    {
        //Fixa
        return null;
    }


    private List<Node<E>> postOrder(List<Node<E>> nodes,List<Node<E>> visitednodes,Node<E> root)
    {
        if(!visitednodes.contains(root))//IF the node hasn't been visited
        {
            Iterator<Node<E>> nodeiterator = root.succsOf(); //Iterate sucessors
            visitednodes.add(root); //And add the sourcenode to visited
            while(nodeiterator.hasNext())//While there are successors, keep iterating
            {
                Node<E> nextitem = nodeiterator.next();
                if(!nodes.contains(nextitem))
                {
                    postOrder(nodes,visitednodes,nextitem);
                }
            }
            root.num = nodes.size();
            nodes.add(root);
        }
        return nodes;
    }

    @Override
    public boolean isCyclic(DirectedGraph<E> graph)
    {
        for(E item : graph.allItems()) //Check all items in the graph
        {
            Node<E> _node = graph.getNodeFor(item);
            Iterator iterator = _node.succsOf(); //Takes a node and then checks it's sucessors, if a sucoessor is the same as the root, return TRUE
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

        if(graph.headCount() > 0)
        {
            Iterator<Node<E>> nodeiterator = graph.heads(); //Since no root node is provided, iterate all heads instead.
            while(nodeiterator.hasNext())
            {
                nodes = postOrder(nodes,nodesvisited,nodeiterator.next());
            }
        }
        else
        {
            Node<E> _nextItem = graph.getNodeFor(graph.allItems().get(0));
            nodes = postOrder(nodes,nodesvisited,_nextItem);
        }

        Collections.reverse(nodes); //Not the most creative solution, Do a postOrder of the heads and reverse it after with collections.reverse
        return nodes;
    }
}
