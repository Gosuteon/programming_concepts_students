package algorithms;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * A Recursive Stack is a stack (LIFO)
 * that is immutable.
 * @param <E>
 */
public class RecursiveStack<E>  implements Iterable<E> {

    E e;
    final RecursiveStack<E> next;

    /**
     * Creates an empty stack
     */
    public RecursiveStack() {
        // TODO
        e = null;
        next = null;

    }

    /**
     * Create a stack with e on top and next as the next stack.
     * The next is unchanged.
     *
     * @param e the element to put on top
     * @param next the following stack
     */
    private RecursiveStack(E e, RecursiveStack<E> next) {
        // TODO
        this.e = e;
        this.next = next;
    }

    /**
     * Creates and return a new stack with e on top and the
     * current stack at the bottom.
     * The current stack is unchanged.
     *
     * @param e the element to place on top
     * @return the new stack
     */
    public RecursiveStack<E> add(E e) {
        return new RecursiveStack<E>(e, this);
        // TODO
    }

    /**
     * Returns the element on top of the stack
     *
     * @throws EmptyStackException if the stack is empty
     * @return the element on top of the stack
     */
    public E top() {
        if (this.e == null){
            throw new EmptyStackException();
        }
         return this.e;
    }

    /**
     * Return the stack with element on top removed.
     * The current stack is unchanged.
     *
     * @return the stack with the top element removed
     */
    public RecursiveStack<E> removeTop() {
        // TODO
        RecursiveStack<E> copy = this;
        if (copy.next==null){
            throw new EmptyStackException();
        }

         return copy.next;
    }

    /**
     * Computes the number of elements in the stack
     *
     * @return the number of element in the stack
     */
    public int size() {
        // TODO
        if (this.next == null){
            return 0;
        }

         return this.next.size()+1;
    }

    /**
     * Reverse the stack.
     * The current stack is unchanged.
     *
     * @return a reversed version of the current stack (the top element becomes the bottom one)
     */
    public RecursiveStack<E> reverse() {
        // TODO

        RecursiveStack<E> copy = this;
        RecursiveStack<E> reversed = new RecursiveStack<E>(null,null);
        for (int i = 0; i<this.size();i++){
            reversed = reversed.add(copy.e);
            copy = copy.next;
        }
         return reversed;
    }

    /**
     * Creates a top-down iterator on the stack
     * The delete is not implemented
     *
     * @return the top-down iterator.
     */
    @Override
    public Iterator<E> iterator() {
        // TODO: think about implementing an inner class
         //return null;
         return new Iterator<E>() {
             RecursiveStack<E> current = RecursiveStack.this;
             @Override
             public boolean hasNext() {
                 return current.next!=null;
             }

             @Override
             public E next() {
                 E e = current.e;
                 current = current.next;
                 return e;
             }
         };
    }



}
