import java.util.*;

class GC <T extends List<Number>> {}

class One_3 {
    public static void main(String[] args) {
        GC ex_a = new GC();
        GC<Number> ex_b = new GC<Number>();
        GC<List<Number>> ex_c = new GC<List<Number>>();
        GC<List<Number>> ex_d = new GC<>();
        GC<List<Integer>> ex_e = new GC<List<Integer>>();
        GC<List<Number>> ex_f = new GC<List<Integer>>();
        GC ex_g = new GC<List<Number>>();
        GC<List<Number>> ex_h = new GC<ArrayList<Number>>();
        GC<ArrayList<Number>> ex_i = new GC<ArrayList<Number>>();
    }
}