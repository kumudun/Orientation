import java.util.Random;

public class AgeDistribution{
    public static void main(String[] args) {
        final int REPEATS = 1000;
        final int[][] distribution = {
                {16, 20},
                {34, 21},
                {52, 22},
                {68, 23},
                {82, 24},
                {89, 25},
                {94, 26},
                {96, 28},
                {98, 30},
                {100, 35}
        };

        int[] generatedAges = new int[40]; // store counts, up to age 35
        Random random = new Random();

        for (int i = 0; i < REPEATS; i++) {
            int r = random.nextInt(100) + 1; // random number 1–100
            int j = 0;
            while (r > distribution[j][0]) {
                j++;
            }
            int age = distribution[j][1];
            generatedAges[age]++;
        }

        System.out.println("Age  Count  %");
        for (int age = 0; age < generatedAges.length; age++) {
            if (generatedAges[age] > 0) {
                double percent = (generatedAges[age] * 100.0) / REPEATS;
                System.out.printf("%-3d  %-5d  %.2f%n", age, generatedAges[age], percent);
            }
        }
    }
}

