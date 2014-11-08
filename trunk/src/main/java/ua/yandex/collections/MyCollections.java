package ua.yandex.collections;

import java.util.Comparator;

public class MyCollections {

    // Reverses the order of the elements in the specified list
    public static void reverse(MyList list) {
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            Object firstForSwap = list.get(i);
            Object secondForSwap = list.get(j);
            list.set(i, secondForSwap);
            list.set(j, firstForSwap);
        }
    }

    //Реализует рекурсивный поиск в отсортированном массиве методом бисекции.
    public static int binarySearch(MyList list, Object key) {
        if (list.isEmpty()) {
            return -1;
        }
        return binarySearch(list, key, 0, list.size() - 1);
    }

    public static int binarySearch(MyList list, Object key,
            int indexOfBegin, int indexOfEnd) {
        if (indexOfBegin == indexOfEnd) {
            if (((Comparable) list.get(indexOfBegin)).compareTo(key) > 0) {
                return -indexOfBegin - 1;
            }
            if (((Comparable) list.get(indexOfBegin)).compareTo(key) == 0) {
                return indexOfBegin;
            }

            return -indexOfBegin - 2;
        }
        int indexOfMiddle = (int) (indexOfBegin + indexOfEnd) / 2;
        if (((Comparable) list.get(indexOfMiddle)).compareTo(key) > 0) {
            return binarySearch(list, key, indexOfBegin, indexOfMiddle);
        }
        if (((Comparable) list.get(indexOfMiddle)).compareTo(key) < 0) {
            return binarySearch(list, key, indexOfMiddle + 1, indexOfEnd);
        }
        return indexOfMiddle;
    }

    //Реализует рекурсивный поиск в отсортированном массиве методом бисекции.
    public static int binarySearch(MyList list, Object key, Comparator cp) {
        if (list.isEmpty()) {
            return -1;
        }
        return binarySearch(list, key, cp, 0, list.size() - 1);
    }

    public static int binarySearch(MyList list, Object key, Comparator cp,
            int indexOfBegin, int indexOfEnd) {
        if (indexOfBegin == indexOfEnd) {
            if (cp.compare(list.get(indexOfBegin), key) > 0) {
                return -indexOfBegin - 1;
            }
            if (cp.compare(list.get(indexOfBegin), key) == 0) {
                return indexOfBegin;
            }
            return -indexOfBegin - 2;
        }
        int indexOfMiddle = (int) (indexOfBegin + indexOfEnd) / 2;
        if (cp.compare(list.get(indexOfMiddle), key) > 0) {
            return binarySearch(list, key, cp, indexOfBegin, indexOfMiddle);
        }
        if (cp.compare(list.get(indexOfMiddle), key) < 0) {
            return binarySearch(list, key, cp, indexOfMiddle + 1, indexOfEnd);
        }
        return indexOfMiddle;
    }
}
