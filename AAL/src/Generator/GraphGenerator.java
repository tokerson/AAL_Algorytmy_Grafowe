package Generator;

import java.util.Random;

public class GraphGenerator {

    public static void main(String[] args) {

        if(args.length != 0) {

            int size = Integer.parseInt(args[0]);

                Random rand = new Random();

                System.out.println(size);

                for (int i = 0; i < size; ++i) {
                    int neighbor = rand.nextInt(size) + 1;
                    System.out.format("%d %d\n",i+1,neighbor);
                }

        }
    }
}
