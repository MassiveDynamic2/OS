import java.util.Scanner;

public class sjf {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of process:");
        int n = sc.nextInt();
        int processID[] = new int[n];
        int arrivalTime[] = new int[n];
        int burstTime[] = new int[n];
        int completeTime[] = new int[n];
        int turnAroundTime[] = new int[n];
        int waitingTime[] = new int[n];
        boolean isComplete[] = new boolean[n];

        int startTime = 0, total = 0;
        float averageWaiting = 0, averageTurnaround = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("enter process " + (i + 1) + " arrival time:");
            arrivalTime[i] = sc.nextInt();
            System.out.println("enter process " + (i + 1) + " brust time:");
            burstTime[i] = sc.nextInt();
            processID[i] = i + 1;
            isComplete[i] = false;
        }

        while (true) {
            int currentProcess = n, min = 999999; /// currentProcess = current proccess

            if (total == n)
                break;

            for (int i = 0; i < n; i++) {

                if ((arrivalTime[i] <= startTime) && (isComplete[i] == false) && (burstTime[i] < min)) {
                    min = burstTime[i];
                    currentProcess = i;
                }
            }
            if (currentProcess == n)
                startTime++;
            else {
                completeTime[currentProcess] = startTime + burstTime[currentProcess];
                startTime += burstTime[currentProcess];
                turnAroundTime[currentProcess] = completeTime[currentProcess] - arrivalTime[currentProcess];
                waitingTime[currentProcess] = turnAroundTime[currentProcess] - burstTime[currentProcess];
                isComplete[currentProcess] = true;
                processID[total] = currentProcess + 1;
                total++;
            }
        }

        System.out.println("\nprocessId arrival brust complete turnAround waiting");
        for (int i = 0; i < n; i++) {
            averageWaiting += waitingTime[i];
            averageTurnaround += turnAroundTime[i];
            System.out.println(
                    "P" + processID[i] + "        " + arrivalTime[i] + "        " + burstTime[i] + "        "
                            + completeTime[i]
                            + "    "
                            + "        " + turnAroundTime[i] + "        " + waitingTime[i]);
        }
        System.out.println("\naverage turnaround time is " + (float) (averageTurnaround / n));
        System.out.println("average waitingTime is " + (float) (averageWaiting / n));
        sc.close();
        for (int i = 0; i < n; i++) {
            System.out.print(processID[i] + " ");
        }
    }
}