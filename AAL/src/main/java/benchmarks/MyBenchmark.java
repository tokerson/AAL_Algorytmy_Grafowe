package benchmarks;

import program.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class MyBenchmark {

    //TODO check if this is gonna work
    @Param("")  //I can add Param({filename1, filename2, ... }) later on in order to test on many graphs.
    public String filename;

    public Graph graph;

    @Setup
    public void setup(){
        filename = "/home/tokarz/Documents/Projects/AAL_Algorytmy_Grafowe/AAL/target/classes/in.txt";
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
    @Warmup(iterations = 2, time = 10, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void recursive() {
        Main.howManyScouts(graph,Main::DFS_Recursive);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @Warmup(iterations = 2, time = 10, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void non_recursive() {
        Main.howManyScouts(graph,Main::DFS_Stack);
    }

    public static void main(String[] args) throws IOException, RunnerException {
        org.openjdk.jmh.Main.main(args);
    }
}
