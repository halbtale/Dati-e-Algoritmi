package org.unipd.tree.adt;

/**
 * Collezione che rende disponibile un iteratore ai suoi elementi
 * @param <E>
 */
public interface Iterable<E> {
    Iterator<E> iterator();
}
