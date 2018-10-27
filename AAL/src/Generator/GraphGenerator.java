package Generator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class GraphGenerator {

    public static void main(String[] args) {

        if(args.length != 0) {

            int size = Integer.parseInt(args[0]);

            try {
                PrintWriter printWriter = new PrintWriter("in.txt");
                Random rand = new Random();

                printWriter.println(size);

                for (int i = 0; i < size; ++i) {
                    int neighbor = rand.nextInt(size) + 1;
                    printWriter.format("%d %d\n",i+1,neighbor);
                }

                printWriter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
