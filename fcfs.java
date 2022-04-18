import java.util.Scanner;


public class fcfs {
    public static void main(String[] args) {

        System.out.println("Enter the number of process");
        Scanner console = new Scanner(System.in);
        int numberOfProcesses = console.nextInt();

        int processId[] = new int[numberOfProcesses];
        int burstTime[] = new int[numberOfProcesses];
        int arrivalTime[] = new int[numberOfProcesses];
        int completeTime[] = new int[numberOfProcesses];
        int turnArround[] = new int[numberOfProcesses];
        int waitingTime[] = new int[numberOfProcesses];

        for (int i = 0; i < numberOfProcesses; i++) {
            System.out.println("Enter process " + (i + 1) + " arrival time: ");
            arrivalTime[i] = console.nextInt();
            System.out.println("Enter process " + (i + 1) + " brust time: ");
            burstTime[i] = console.nextInt();
            processId[i] = i + 1;
        }
        int temp;
        for (int i = 0; i < numberOfProcesses; i++) {
            for (int j = i + 1; j < numberOfProcesses; j++) {

                if (arrivalTime[i] > arrivalTime[j]) {
                    temp = arrivalTime[i];
                    arrivalTime[i] = arrivalTime[j];
                    arrivalTime[j] = temp;

                    temp = processId[i];
                    processId[i] = processId[j];
                    processId[j] = temp;
                    temp = burstTime[i];
                    burstTime[i] = burstTime[j];
                    burstTime[j] = temp;
                }
            }
        }

        System.out.println();
        completeTime[0] = burstTime[0] + arrivalTime[0];
        for (int i = 1; i < numberOfProcesses; i++) {
            completeTime[i] = completeTime[i - 1] + burstTime[i];
        }
        for (int i = 0; i < numberOfProcesses; i++) {
            turnArround[i] = completeTime[i] - arrivalTime[i];
            waitingTime[i] = turnArround[i] - burstTime[i];
        }
        System.out.println("Process\t\tAT\t\tBT\t\tCT\t\tTAT\tWT");
        for (int i = 0; i < numberOfProcesses; i++) {
            System.out.println(
                    processId[i] + "\t\t" + arrivalTime[i] + "\t\t" + burstTime[i] + "\t\t" + completeTime[i] + "\t\t" + turnArround[i] + "\t" + waitingTime[i]);
        }

        System.out.println(" chart: ");
        for (int i = 0; i < numberOfProcesses; i++) {
            System.out.print("P" + processId[i] + " ");
        }
    }

}