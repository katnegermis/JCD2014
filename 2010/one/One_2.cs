using System;

public class One_1 {
    public static void Main(string[] args) {
        string a = "Good luck!";
        string b = "Good";
        string c = b ;
        b += " luck!";
        Console.Write(a == b);
        Console.Write(' ');
        Console.Write(b == c);
        Console.Write(' ');
        Console.Write(a.Equals(b));
        Console.Write(' ');
        Console.Write(a.Equals(c));
    }
}