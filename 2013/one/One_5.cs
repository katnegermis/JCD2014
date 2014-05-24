struct Sample {
    private int x;
    public int Increment() {
        this.x = this.x + 1;
        return this.x;
    }
}

class Foo {
    public readonly Sample s = new Sample();
}

class Program {
    static void Main(string[] args) {
        Foo f = new Foo();
        System.Console.WriteLine(f.s.Increment());
        System.Console.WriteLine(f.s.Increment());
        System.Console.WriteLine(f.s.Increment());
    }
}