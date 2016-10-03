package ma223ku_assign3;

import graphs.DirectedGraph;
import graphs.GML;
import graphs.Node;

import java.util.Iterator;

/**
 * Created by Martin on 2016-09-30.
 */
public class MyGML<E> extends GML<E>
{
    public MyGML(DirectedGraph<E> graph)
    {
        super(graph);
    }

    @Override
    public String toGML()
    {
        String toReturn = "";
        int id = 1;
        Iterator nodeIterator = graph.iterator();
        Iterator edgeIterator = graph.iterator();

        toReturn += "graph [\n";
        while(nodeIterator.hasNext())
        {
            Node<E> node = (Node<E>)nodeIterator.next();
            node.num = id;
            toReturn += "\tnode [" +
                    "\n\t\tid "+node.num+
                    "\n\t\tlabel \"" +node.item()+ "\"\n\t]\n";
            id++;
        }
        while(edgeIterator.hasNext())
        {
            Node<E> _src = (Node<E>)edgeIterator.next();
            Iterator _sucessors = _src.succsOf();

            while(_sucessors.hasNext())
            {
                Node<E> _tar = (Node<E>)_sucessors.next();
                toReturn += "\tedge [" +
                        "\n\t\tsource "+ _src.num+
                        "\n\t\ttarget " + _tar.num+
                        "\n\t]\n";
                id++;
            }
        }
        toReturn += "]";
        return toReturn;
    }
}
