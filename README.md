# Round-Robin-Scheduling-Algorithm



## 1.Introduction
Round-Robin (RR) is one of the CPU scheduling algorithms, this scheduling algorithm is designed especially for timesharing systems, it is like FCFS scheduling and
SJF scheduling, the time is divided into small slots called quantum. The CPU scheduler goes around the ready queue, allocating the CPU to each process for a time interval of up
to 1-time quantum. The operating system can make the computer more productive by switching the CPU among processes.

So, our job to implement the Round Robin CPU scheduling with Java, that include
certain requirement:

### The user should enter:
- Number of processes in the system.
- CPU-burst times for all the processes.
- Quantum time for the system.


### The output should display:
- Gantt chart that display all the scheduled processes in the system.
- The waiting times for all the processes.
- The turnaround times for all the processes.
- The total waiting time for the entire scheduling.
- The average waiting time for the entire scheduling.
- The total turnaround time for all the scheduled processes.
- The average turnaround time for all the scheduled processes.


## 2.The code explanation
In this part, we will show the most important methods that we have used in our code
and explain each method in detail. Also, we'll take a snapshot to GUI that shows you how
the code works.

**a. findWaitingTime**
Function to find waiting time of all processes, the method starts with a while loop
**while loop:** ensure that no unfinished process remain.
**for loop:** Traverse all processes one by one repeatedly including all calculations
that we need such as:
1. adding the time and quantum to draw the Gantt chart.
2. subtracting quantum time from the remaining burst time.
3. Calculating the waiting time by time subtracted by burst time and we take
the result and subtracted by the arrival time.

**b. findTurnAroundTime**
Simple method not much code here. The main function is to calculate
turnaround time by adding the burst time + waiting time.

**c. findavgTime**
This method calls both previous methods and display the average waiting
time and average turnaround time for all processes in a formatted manner.

---
### GUI
Using the dataset present below and with QT = 5.
Add the required information
Note: quantum time is a constant (once you entered it you cannot change it unless you rerun
the program).
![image](https://user-images.githubusercontent.com/41582209/135684456-af5813f3-f854-42b0-8788-4bf984767ee6.png)
**Then add AT = 1, BT = 8**

![image](https://user-images.githubusercontent.com/41582209/135684468-7bfd8cb5-a29a-4ad6-a451-5ffbabb12147.png)
**After that add AT = 2, BT = 4**

![image](https://user-images.githubusercontent.com/41582209/135684478-12d35f75-6160-445e-8a10-351e578b4136.png)
**Finally, Click proceed**

![image](https://user-images.githubusercontent.com/41582209/135684491-27f6807d-c60f-4d5e-baae-16cc592a328f.png)

-----

## 3. Analyzing the system with 10% increment
For instance, we choose a random dataset to draw the required plots, the quantum time is between 0 to 12 inclusive.

![image](https://user-images.githubusercontent.com/41582209/135684750-23a5152d-7f14-44b6-80c7-eff4679fdc6e.png)


## 4. Plot the graph of average turnaround time as a function of the system quantum time.
![image](https://user-images.githubusercontent.com/41582209/135684799-3f3b242e-8179-4a43-87a6-c1fb1b6b9f03.png)


## 5. Analysis of the system:
Round Robin algorithm depend on chosen time quantum value although the increasing of the quantum time not necessarily improve the turnaround time as shown in
the figure 1. As it is illustrated below in figure 2 and figure 3, the optimal algorithm is shortest-Job-First (SJF), RR algorithm and FCFS is almost with the same average turnaround time in this example.


![image](https://user-images.githubusercontent.com/41582209/135684874-afef8240-e930-4bf6-81f3-47f2d8399778.png)
---

## 6. Enhancement:
We can enhance the system by choosing an appropriate quantum time in which you calculate the quantum time depending on the burst-time exists in the ready queue.
This will effectively improve the performance as compared with the previous Round Robin algorithm.


## 7. Conclusion:
Through the project we used our dataset that we implemented it to different CPU scheduling algorithms to observe the behavior of each algorithm. And we can conclude
that Round Robin algorithm is not the best CPU scheduling algorithm, but it is perfect for the systems that need time sharing.


