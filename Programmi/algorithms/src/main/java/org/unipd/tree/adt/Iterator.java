package org.unipd.tree.adt;

/**
 * Cursore che permette di enumerare gli elementi di una collezione
 * @param <E>
 */
public interface Iterator<E> {
    boolean hasNext();
    E next();
}
