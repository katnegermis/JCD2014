class Program {
    public static void main(String[] args) {
        System.out.println(new Integer(7).equals(7)); // True
        System.out.println(new Long(7).equals(7)); // False
        System.out.println(new Long(7).equals(7L)); // True
        System.out.println(new Integer(7).equals(new Long(7))); // False
        // System.out.println(new Integer(7) == new Long(7)); // Compiler error.


        // Java automatically boxes number literals to the "correct" type
        // when doing comparisons.
        System.out.println(new Integer(7) == 7); // True
        System.out.println(new Integer(7) == 7f); // True
        System.out.println(new Integer(7) == 7L); // True
        System.out.println(new Integer(7) == 7.0); // True
        System.out.println(new Long(7) == 7); // True
        System.out.println(new Double(7) == 7); // True
        System.out.println(new Float(7) == 7); // True

        // Java doesn't automatically box arguments for functions,
        // as it does for equality.
        // Had the literals below not had their type-specific modifiers,
        // there would be compilation errors.
        System.out.println(Boxer.integerBox(7).getClass());
        System.out.println(Boxer.floatBox(7f).getClass());
        System.out.println(Boxer.doubleBox(7.0).getClass());
        System.out.println(Boxer.longBox(7L).getClass());
    }
}


class Boxer {
    public static <T> T box(T o) {
        return o;
    }

    public static Integer integerBox(Integer o) {
        return o;
    }

    public static Long longBox(Long o) {
        return o;
    }

    public static Float floatBox(Float o) {
        return o;
    }

    public static Double doubleBox(Double o) {
        return o;
    }
}
