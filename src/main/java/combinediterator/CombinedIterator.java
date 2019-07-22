package combinediterator;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 *
 * Implement method
 * public static <T> Iterator<T> flatten(Iterator<Iterator<T>> iterator)
 * which will flattern iterator of iterators
 *
 */
public class CombinedIterator {
    public static <T> Iterator<T> flatten(Iterator<Iterator<T>> iterator) {
        return new MyIterator<>(iterator);
    }

    private static class MyIterator<T> implements Iterator<T> {
        private final Iterator<Iterator<T>> iterator;
        Iterator<T> currentElementIterator;

        public MyIterator(Iterator<Iterator<T>> iterator) {
            this.iterator = iterator;

            if (iterator != null && iterator.hasNext()) {
                currentElementIterator = iterator.next();
            }
        }

        @Override
        public boolean hasNext() {
            while (currentElementIterator != null && !currentElementIterator.hasNext()) {
                if (iterator.hasNext()) {
                    currentElementIterator = iterator.next();
                } else {
                    currentElementIterator = null;
                }
            }

            if (currentElementIterator == null) {
                return false;
            }

            return true;
        }

        @Override
        public T next() {
            if (currentElementIterator == null) {
                throw new NoSuchElementException();
            }

            hasNext();

            return currentElementIterator.next();
        }
    }
}
