public class Main2 {
    public static void main(String[] args) throws Exception {
        MySerializer s = new MySerializer();
        BankAccount ba2 = (BankAccount)(s.deserialize());
        System.out.println(ba2);
        // - 2 - ...........................................
        // - 3 - ...........................................
        // - 5 - ...........................................

    }
}