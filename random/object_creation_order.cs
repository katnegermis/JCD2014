class Grandparent {
    static Grandparent() {
        System.Console.WriteLine("static Grandparent()");
    }

    public Grandparent() {
        System.Console.WriteLine("Grandparent()");
    }

    public Grandparent(int arg) {
        System.Console.WriteLine("Grandparent(int)");
    }
}

class Parent : Grandparent {
    static Parent() {
        System.Console.WriteLine("static Parent()");
    }

    public Parent() {
        System.Console.WriteLine("Parent()");
    }

    public Parent(int arg) {
        System.Console.WriteLine("Parent(int)");
    }
}

class Child : Parent {
    static Child() {
        System.Console.WriteLine("static Child()");
    }

    public Child() {
        System.Console.WriteLine("Child()");
    }

    public Child(int arg) : base(arg) {
        System.Console.WriteLine("Child(int)");
    }
}

class Program {
    public static void Main(string[] args) {
        System.Console.WriteLine("Child c1 = new Child();");
        Child c1 = new Child();
        System.Console.WriteLine("\n\n");
        // Notice that static constructors are only run ONCE per class.
        System.Console.WriteLine("Child c2 = new Child(5)");
        Child c2 = new Child(5);
    }
}