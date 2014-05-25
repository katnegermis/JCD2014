class Grandparent {
    public Grandparent() {
        System.out.println("Grandparent()");
    }

    public Grandparent(int arg) {
        System.out.println("Grandparent(int)");
    }
}

class Parent extends Grandparent {
    public Parent() {
        System.out.println("Parent()");
    }

    public Parent(int arg) {
        System.out.println("Parent(int)");
    }
}

class Child extends Parent {
    public Child() {
        System.out.println("Child()");
    }

    public Child(int arg) {
        super(arg);
        System.out.println("Child(int)");
    }
}

class Program {
    public static void main(String[] args) {
        System.out.println("Child c1 = new Child();");
        Child c1 = new Child();
        System.out.println("\n\nChild c2 = new Child(5);");
        Child c2 = new Child(5);
    }
}