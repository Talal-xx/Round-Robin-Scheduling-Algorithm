/* *********************************************
 \\  Java program for implementation of RR scheduling  //
 
 Name                ID
 Talal AlQurashi     1742925
 Ahmed Balkhair      18
 Firas Mahmoud       1845407
 
 12/7/2020                                       
 ***********************************************/

import java.util.Scanner;

public class RoundRobin {

    public static void input() {
        Scanner sc = new Scanner(System.in); // Scanner to read the user inputs
        System.out.println("***************************************************** CPU Scheduling ***************************************************************************");
        System.out.println("***************************************************** [ Round-Robin ] **************************************************************************");
        System.out.print("Enter the number of processes: ");
        //------------------------------------------------------------------------------
        int numOfProcess = sc.nextInt(); // get num procc from user
        while (true) {
            if (numOfProcess < 1) {
                System.out.println("Please try to enter graeter than 0");
                System.out.print("Enter the number of processes: ");
                numOfProcess = sc.nextInt();
            } else {
                break;
            }
        }
        Process processes[] = new Process[numOfProcess]; // create an array to store all proccess
        //------------------------------------------------------------------------------
        System.out.print("Enter the value of the quantum: ");
        int quantumTime = sc.nextInt(); // get QT from user input
        for (int i = 0; i < numOfProcess; i++) { // start the loop to ask the user to enter arrival and burst time for each proccess
            System.out.println("P" + i + ":");
            System.out.print("\tArrival time: ");
            int arrival = sc.nextInt(); // get arrival time
            System.out.print("\tBurst time: ");
            int burst_time = sc.nextInt(); // get burst time
            processes[i] = new Process("P" + i + ":", arrival, burst_time);
        }
        findavgTime(processes, quantumTime); // Call the method
    }

    static void findavgTime(Process processes[], int quantum) {
        int waitingTime, turnAroundtime; // initilize the waiting and turn around time
        int total_waitingTime = 0, total_turnAroundtime = 0; // initilize the num of the waiting and turn around time
        //----------------------------------------------------------------------
        findWaitingTime(processes, quantum);// Function to find waiting time of all processes
        findTurnAroundTime(processes);// Function to find turn around time for all processes 
        //----------------------------------------------------------------------
        // Display processes along with all details 
        System.out.println("\n******************************[Trace Table]**********************************************");
        System.out.println("Processes " + " Burst time " + " Waiting time " + " Turn around time");
        // Calculate total waiting time and total turn
        for (int i = 0; i < processes.length; i++) {
            total_waitingTime = total_waitingTime + processes[i].getWaitingTime();
            total_turnAroundtime = total_turnAroundtime + processes[i].getTurnAroundTime();
            System.out.println(" " + (i + 1) + "\t\t" + processes[i].getBurstTime() + "\t " + processes[i].getWaitingTime() + "\t\t " + processes[i].getTurnAroundTime());
        }
        System.out.println("**********************************[Analysis]******************************************");
        System.out.printf("Total waiting time       =  %.2f", (float) total_waitingTime);
        System.out.printf("\nAverage waiting time     =  %.2f", (float) total_waitingTime / (float) processes.length);
        System.out.printf("\nTotal turn around time   =  %.2f", (float) total_turnAroundtime);
        System.out.printf("\nAverage turn around time =  %.2f\n", (float) total_turnAroundtime / (float) processes.length);
        System.out.println("*************************************[END]********************************************");
    }

    static void findWaitingTime(Process processes[], int quantum) {
        System.out.println("*************************Gantt chart***********************");

        int time = 0; // Current time
        while (true) { // Keep traversing processes in round robin manner until all of them are not done.
            boolean done = true;
            for (int i = 0; i < processes.length; i++) {// Traverse all processes one by one repeatedly 
                if (processes[i].getRemainingBurst() > 0) { // If burst time of a process is greater than 0 then only need to process further
                    done = false; // There is a pending process 
                    if (processes[i].getRemainingBurst() > quantum) {
                        // Increase the value of t i.e. shows how much time a process has been processed 
                        time += quantum;
                        System.out.print("P" + (i + 1) + "(" + time + ")"); // print gantt chart
                        processes[i].setRemainingBurst(processes[i].getRemainingBurst() - quantum);// Decrease the burst_time of current process by quantum
                    } else { // If burst time is smaller than or equal to quantum. Last cycle for this process 
                        // Increase the value of t i.e. shows how much time a process has been processed
                        time = time + processes[i].getRemainingBurst();
                        System.out.print("P" + (i + 1) + "(" + time + ")"); // print gantt chart
                        // Waiting time is current time minus time used by this process
                        processes[i].setWaitingTime(time - processes[i].getBurstTime() - processes[i].getArrivalTime());
                        if (processes[i].getWaitingTime() < 0) {
                            processes[i].setWaitingTime(0);
                        }
                        // As the process gets fully executed make its remaining burst time = 0 
                        processes[i].setRemainingBurst(0);
                    }
                }
            }
            if (done == true) { // If all processes are done 
                break;
            }
        }
    }

    static void findTurnAroundTime(Process processes[]) {
        // calculating turnaround time by adding burstTime[i] + waitingTime[i]
        for (int i = 0; i < processes.length; i++) {
            processes[i].setTurnAroundTime(processes[i].getBurstTime() + processes[i].getWaitingTime());
        }
    }

    public static void main(String[] args) {

        input();

    }

}
