package ma223ku_assign3;

import graphs.DirectedGraph;
import graphs.GML;

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
        return null;
    }
}
