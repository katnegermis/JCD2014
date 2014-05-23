public class One_1 {
    public static void main(String[] args) {
        String a = "Good luck!";
        String b = "Good";
        String c = b ;
        b += " luck!";
        System.out.print(a == b);
        System.out.print(' ');
        System.out.print(b == c);
        System.out.print(' ');
        System.out.print(a.equals(b));
        System.out.print(' ');
        System.out.print(a.equals(c));
    }
}