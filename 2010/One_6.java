import java.util.List;
import java.util.ArrayList;

public class One_6 {
    public static void main(String[] args) {
        Number[] a = new Integer[10];
        ArrayList<int> list1 = new ArrayList<int>(10);
        List<Integer> list2 = new ArrayList<Integer>(10);
        ArrayList<Number> list3 = new ArrayList<Integer>(10);
        ArrayList<?> list4 = new ArrayList<Integer>(10);
        ArrayList<? extends Number> list5 = new ArrayList<Integer>(10);
        ArrayList list6 = new ArrayList<Integer>(10);
    }
}