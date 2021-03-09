package AnalysisOfAlgorithm;

/**
 * @author quinn
 * @create 2021-01-21 22:42
 */
public class SelectionSortTest {
    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 2, 1, 3};

        SelectionSort.swapElements(array, 0, 1);
        System.out.println(array);

        System.out.println(SelectionSort.indexLowest(array, 0));

        SelectionSort.selectionSort(array);
        System.out.println(array);
    }
}
