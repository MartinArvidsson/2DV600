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
        List<Node<E>> nodes = new ArrayList<>(); //Stores nodes to return
        List<Node<E>> visitednodes = new ArrayList<>(); // Mark a node as visited
        HashSet<Node<E>> nodeset = new HashSet<>();

        Iterator<Node<E>> iterator = graph.heads(); //Iterate over heads
        while(iterator.hasNext())
        {
            Node<E> nextitem = iterator.next();
            if(!visitednodes.contains(nextitem)) //If the node hasn't been visited before
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
        while(iterator.hasNext()) //Iterate over all items in the nodeset,
        {
            Node<E> nextitem = iterator.next();
            if(!visitednodes.contains(nextitem)) //If the item hasn't been visited
            {
                nextitem.num = visitednodes.size();
                visitednodes.add(nextitem); //Add it to visited to mark it so it doesn't get visited twice
                nodelist.add(nextitem); //Add it to the list to return
            }
            Iterator<Node<E>> succsiterator = nextitem.succsOf();
            while (succsiterator.hasNext()) //Check sucessors of the node
            {
                Node<E> successor = succsiterator.next();
                if(!visitednodes.contains(successor)) //If the node hasn't been visited, add it to a new set to iterate
                {
                    newset.add(successor);
                }
            }
        }
        if(!newset.isEmpty()) //Keep iterating until no more sucessors are found
        {
            bfs(nodelist,visitednodes,newset);
        }
        return nodelist;
    }



}
