using System;
using System.Threading;

class Model {
    private int value = 0;

    public int NextValue() {
        var rnd = new Random();
        Thread.Sleep(rnd.Next(25));
        value++;
        return value;
    }
}

class Viewer {
    public void Display(int value) {
        var rnd = new Random();
        Thread.Sleep(rnd.Next(500));
        Console.WriteLine(value);
    }
}

class MainProgram {
    static Model model;
    static Viewer viewer;
    static int numSteps = 25;

    static void ExecuteSequentially() {
        model = new Model();
        viewer = new Viewer();
        for (int i = 0; i < numSteps; i++) {
            viewer.Display(model.NextValue());
        }
    }

    // Free space
    static int bufferSize = 2;
    static int[] buffer = new int[bufferSize];
    static bool[] calculateValue = new bool[] { true, true };
    // End of free space

    static void CalculateAll() {
        for (int i = 0; i < numSteps; i++) {
            // Free space
            int val = MainProgram.model.NextValue();

            // Wait for next buffer space to become free.
            while (!MainProgram.calculateValue[i % bufferSize]);

            buffer[i % bufferSize] = val;

            // Mark buffer space occupied.
            MainProgram.calculateValue[i % bufferSize] = false;
            // End of free space
        }
    }

    static void DisplayAll() {
        for (int i = 0; i < numSteps; i++) {
            // Free space
            // Wait for next buffer space to be occupied.
            while (MainProgram.calculateValue[i % bufferSize]);

            int val = MainProgram.buffer[i % bufferSize];

            // Mark buffer space free.
            MainProgram.calculateValue[i % bufferSize] = true;

            MainProgram.viewer.Display(val);
            // End of free space
        }
    }

    static void ExecuteConcurrently() {
        model = new Model();
        viewer = new Viewer();
        // Free space
        Thread modelThread = new Thread(new ThreadStart(MainProgram.CalculateAll));
        modelThread.Start();

        Thread viewerThread = new Thread(new ThreadStart(MainProgram.DisplayAll));
        viewerThread.Start();

        modelThread.Join();
        viewerThread.Join();
        // End of free space
    }

    static void Main(string[] args) {
        DateTime start;
        TimeSpan span;

        start = DateTime.Now;
        ExecuteSequentially();
        span = DateTime.Now - start;
        Console.WriteLine(span.TotalMilliseconds);

        start = DateTime.Now;
        ExecuteConcurrently();
        span = DateTime.Now - start;
        Console.WriteLine(span.TotalMilliseconds);
    }
}