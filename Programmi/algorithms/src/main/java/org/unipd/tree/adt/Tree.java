package org.unipd.tree.adt;

/**
 * Albero generico
 * Complessità costante per tutti i metodi eccetto children, iterator e positions (lineare)
 * @param <E>
 */
public interface Tree<E> extends Iterable<E> {
    int size();

    boolean isEmpty();

    Position<E> root();

    Position<E> parent(Position<E> p);

    Iterable<Position<E>> children(Position<E> p);

    int numChildren(Position<E> p);

    boolean isInternal(Position<E> p);

    boolean isExternal(Position<E> p);

    boolean isRoot(Position<E> p);

    Iterator<E> iterator();

    Iterable<Position<E>> positions();
}
