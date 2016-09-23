package ma223ku_assign2.Exercise_5;

/**
 * Created by Martin on 2016-09-20.
 */
public interface Queue<E> extends Iterable<E>
{
    int size();                          // current queue size
    boolean isEmpty();                   // true if queue is empty
    void enqueue(E element);             // add element at end of queue
    E dequeue();                         // return and remove first element.
    E first();                           // return (without removing) first element
    E last();                            // return (without removing) last element
}
