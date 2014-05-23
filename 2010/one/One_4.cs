using System;

class Test {
    public static int x = 3;
    public static int y;
    public int a = x;
    public int b;

    static Test () {
        x = 5;
    }

    public Test () {
        x++;
    }

    static void Main () {
        Test t1 = new Test();
        Test t2 = new Test();
        Console.Write(Test.x);
        Console.Write(' ');
        Console.Write(Test.y);
        Console.Write(' ');
        Console.Write(t2.a);
        Console.Write(' ');
        Console.Write(t2.b);
    }
}