class Test {
    public static void main ( String [] args ) {
    try {
        try {
            throw new Exception ();
        }
        catch ( RuntimeException e ) {
            System.out.println ("Inner runtime exception");
        }
        finally {
            System.out.println ("Finally");
        }
        try {
            ;
        }
        catch ( Exception e ){
            System.out.println ("Exception caught");
            throw new RuntimeException ();
        }
    } catch ( RuntimeException e ) {
        System.out.println ("Outer runtime exception");
    } catch ( Exception e ) {
        System.out.println ("Outer exception");
        throw new RuntimeException ();
        }
    }
}