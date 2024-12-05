 interface SortingStrategy {
    void sort(int[] array);
}
 class BubbleSortStrategy implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        
        System.out.println("Sorting with Bubble Sort");
    }
}

class QuickSortStrategy implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        
        System.out.println("Sorting wiht QSort");
    }
}
 class Sorter {
    private SortingStrategy strategy;

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void sortArray(int[] array) {
        strategy.sort(array);
    }
}
 class Strategy {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();

        
        sorter.setStrategy(new BubbleSortStrategy());
        int[] array1 = {5, 3, 8, 4, 2};
        sorter.sortArray(array1);

       
        sorter.setStrategy(new QuickSortStrategy());
        int[] array2 = {1,2,3, 4};
        sorter.sortArray(array2);
    }
}