package ServiceSystemAverage;

import java.util.Random;

public class TestProgram {
    public static void main(String[] args) {
        int runs = 5;
        int numberOfCustomers = 10;
        double sumAvg = 0.0;

        for (int i = 1; i <= runs; i++) {
            // Fast mode: no real sleeping
            ServicePoint sp = new ServicePoint(new Random(i), false);
            CustomerGenerator gen = new CustomerGenerator(sp, numberOfCustomers);
            gen.generateCustomers();

            double avg = sp.serveAllAndReturnAverageServiceSeconds();
            System.out.printf("Run %d average service time: %.3f s%n%n", i, avg);
            sumAvg += avg;
        }

        double overall = sumAvg / runs;
        System.out.printf("Mean of run averages over %d runs: %.3f s%n", runs, overall);
    }
}

