import java.math.BigDecimal;

public class Main
{
    public static void main(String [ ] args) throws Exception {
        BankAccount ba = new BankAccount("001");
        ba.deposit(new BigDecimal("1.50"));
        ba.withdraw(new BigDecimal("3"));
        System.out.println(ba);
        // − 1 −..............................................
        MySerializer s = new MySerializer();
        s.serialize(ba);
    }
}