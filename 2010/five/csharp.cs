using System;

class MainProgram {
    delegate bool SortingCriterion (object o1, object o2);

    public static void Main(string[] args) {
        var list = new object[10];
        for (int i = 0; i < list.Length; i += 1) {
            list[i] = new object();
        }

        var obj = new OrderInAlphName();
        SortingCriterion sorter = obj.is_less_than;
        quickSortCData(list, sorter);
    }

    private static void quickSortCData(object[] list, SortingCriterion sorter) {
        for (int i = 0; i < list.Length; i += 2) {
            // Not doing any real sorting.
            sorter(list[i], list[i + 1]);
        }
    }
}

class OrderInAlphName {
    public bool is_less_than(object o1, object o2) {
        // Dummy implementation.
        Console.WriteLine("OrderInAlphName: is_less_than");
        return true;
    }
}

class OrderInDescID {
    public bool is_less_than(object o1, object o2) {
        // Dummy implementation.
        Console.WriteLine("OrderInDescID: is_less_than");
        return true;
    }
}