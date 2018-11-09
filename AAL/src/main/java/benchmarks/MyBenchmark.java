package benchmarks;

import program.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class MyBenchmark {

    public String filename;

    public Graph graph ;

    @Setup
    public void setup(){
        filename = "./classes/in.txt";
        graph = Main.createGraph(filename);
    }

    @TearDown
    public void check() {
        assert filename.equals("") : "Nothing changed";
        assert graph.getSize() == 0 : "I don't have any graph";
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5, time = 5, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void recursive() {
        Main.howManyScouts(graph,Main::DFS_Recursive);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 5, time = 5, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void non_recursive() {
        Main.howManyScouts(graph,Main::DFS_Stack);
    }

    public static void main(String[] args) throws IOException, RunnerException {
        org.openjdk.jmh.Main.main(args);
    }
}
