package it.unibo.inner.impl;

import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T>{

    private T[] array;
    private Predicate<T> predicate;

    public IterableWithPolicyImpl(T... elem){
        this(elem, new Predicate<T>(){
        @Override
        public boolean test(Object t) {
        return true;
        }
        }); 
    }

    public IterableWithPolicyImpl(T[] elem, Predicate<T> t){
        array = elem;
        predicate = t;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorWithPolicy();
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        predicate = filter;
    }

    private class IteratorWithPolicy implements Iterator<T>{
        int counter;

        public IteratorWithPolicy(){
            counter = 0;
        }

        @Override
        public boolean hasNext() {
            if (counter < IterableWithPolicyImpl.this.array.length){
                if (predicate.test(array[counter])){
                    return true;
                } else{
                    counter++;
                    return hasNext();
                }
            }
            return false;
        }

        @Override
        public T next() {
            return IterableWithPolicyImpl.this.array[counter++];
        }


    }

}
