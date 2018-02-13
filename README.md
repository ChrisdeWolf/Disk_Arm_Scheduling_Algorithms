# Disk_Arm_Scheduling_Algorithms
Program which applies the following scheduling algorithms to simulate scheduling a disk arm.
-Main program that calls scheduling algorithms
-First Come First Serve (FCFS) scheduling algorithm
-Shortest Seek Time First (SSF) scheduling algorithm
-Elevator Up and Elevator Down scheduling algorithms

EXAMPLE OF OUTPUT:

Seed is 4919

SET 1 FCFS
Cylinders:       500	 485	 722	 2	 690	 304	 509	 593	 301	 300	 247	 625	 179
Distances:   		 15	 237	 720	 688	 386	 205	 84	 292	 1	 53	 378	 446
FCFS requires 3505 seek moves.

SET 2 SSF
Cylinders: 500 	 509	 485	 593	 625	 690	 722	 304	 301	 300	 247	 179	 2
Distances:   	 9	 24	 108	 32	 65	 32	 418	 3	 1	 53	 68	 177
SSF  requires 990 seek moves.

SET 3 ELEVATOR UP
Cylinders: 500 	 509	 593	 625	 690	 722	 485	 304	 301	 300	 247	 179	 2
Distances:   	 9	 84	 32	 65	 32	 237	 181	 3	 1	 53	 68	 177
Elevator up requires 942 seek moves.

SET 4 ELEVATOR DOWN
Cylinders: 500 	 485	 304	 301	 300	 247	 179	 2	 509	 593	 625	 690	 722
Distances:   	 15	 181	 3	 1	 53	 68	 177	 507	 84	 32	 65	 32
Elevator down requires 1218 moves.
