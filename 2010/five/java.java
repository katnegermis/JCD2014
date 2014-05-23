class MainProgram {
    public static void main(String[] args) {
        // Initialize dummy list.
        Object[] list = new Object[10];
        for (int i = 0; i < list.length; i += 1) {
            list[i] = new Object();
        }

        // Initialize sorter function.
        SortingCriterion sorter = new SortingCriterion() {
            public boolean is_less_than(Object o1, Object o2) {
                OrderInAlphName obj = new OrderInAlphName();
                return obj.is_less_than(o1, o2);
            }
        };

        quickSortCData(list, sorter);
    }


    private static void quickSortCData(Object[] list, SortingCriterion sorter) {
        // Dummy implementation not doing any real sorting.
        for (int i = 0; i < list.length; i += 2) {
            sorter.is_less_than(list[i], list[i + 1]);
        }
    }
}

interface SortingCriterion {
    public boolean is_less_than(Object o1, Object o2);
}

class OrderInAlphName {
    public boolean is_less_than(Object o1, Object o2) {
        // Dummy implementation.
        System.out.println("OrderInAlphName: is_less_than");
        return true;
    }
}

class OrderInDescID {
    public boolean is_less_than(Object o1, Object o2) {
        // Dummy implementation.
        System.out.println("OrderInDescID: is_less_than");
        return true;
    }
}