using System;

public class A {
    public virtual string m() {
        return "A";
    }

    public string T { get; set; }

    public A() {
        T = m();
    }
}

public class B : A {
    public new string m() {
        return "B";
    }
}

public class C : A {
    public override string m() {
        return "C";
    }
}

public class main {
    public static void Main(string[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        A x = new B();
        A y = new C();
        // part a)
        Console.WriteLine(a.m() + b.m() + c.m() + x.m() + y.m());
        // part b)
        Console.WriteLine(a.T + b.T + c.T + x.T + y.T);
    }
}