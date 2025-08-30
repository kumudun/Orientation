package Queue;

import java.util.LinkedList;
import java.util.Scanner;

public class CustomerQueue {

    public static void main(String[] args) {
        LinkedList<Customer> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;


        System.out.println("Commands: 'queue' to add new customer, 'dequeue' to remove customer");

        while (running) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "queue":
                    Customer newCustomer = new Customer();
                    // Set the entry time using System.nanoTime()
                    newCustomer.setTimeStart(System.nanoTime());
                    queue.addFirst(newCustomer);
                    System.out.println("Customer " + newCustomer.getId() + " added to the queue.");
                    break;

                case "dequeue":
                    if (!queue.isEmpty()) {
                        Customer servedCustomer = queue.removeLast();
                        servedCustomer.setTimeEnd(System.nanoTime());
                        double timeSpentSeconds = (servedCustomer.getTimeEnd() - servedCustomer.getTimeStart()) / 1_000_000_000.0;
                        System.out.printf("Customer %d time in queue: %.2f seconds%n",
                                servedCustomer.getId(), timeSpentSeconds);
                    }
                    break;

                case "exit":
                    running = false;
                    break;


            }
        }

        scanner.close();
    }
}

