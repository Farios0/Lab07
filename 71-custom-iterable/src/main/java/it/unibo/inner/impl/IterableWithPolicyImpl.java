package it.unibo.inner.impl;

import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T>{

    private T[] array;

    public IterableWithPolicyImpl(T... elem){
        array = elem;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorWithPolicy();
    }

    @Override
    public void setIterationPolicy(Predicate filter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIterationPolicy'");
    }

    private class IteratorWithPolicy implements Iterator<T>{
        int counter;

        public IteratorWithPolicy(){
            counter = 0;
        }

        @Override
        public boolean hasNext() {
            return counter < IterableWithPolicyImpl.this.array.length;
        }

        @Override
        public T next() {
            return IterableWithPolicyImpl.this.array[counter++];
        }


    }

}
