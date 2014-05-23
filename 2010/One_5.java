public class One_5 {
    public static void main(String[] args) {
        try {
            try {
                throw new RuntimeException ( ) ;
            } catch (RuntimeException e) {
                System.out.println("Inner runtime exception") ;
                throw e ;
            } catch (Exception e) {
                System.out.println("Inner exception") ;
            } finally {
                System.out.println("Finally!") ;
                throw new Exception() ;
            }
        } catch (RuntimeException e) {
            System.out.println("Outer runtime exception") ;
        } catch (Exception e) {
            System.out.println("Outer exception") ;
        }
    }
}