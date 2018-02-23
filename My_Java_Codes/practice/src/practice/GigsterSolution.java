package practice;

import java.util.*;

class GigsterSolution {
	public static int solution(int[] A, int[] B, int M, int X, int Y) {
	     
	     int TotalWeight = 0; // Total weight per elevator round
	     int TotalStops = 0; // Total elevator stops
	     int TotalPersons = 0; // Total number of persons in elevator
	     int CurrentPerson = 0;
	     boolean isLiftStarted = false;
	      
	     ArrayList<Integer> floorList = new ArrayList<Integer>();
	     
	     while (CurrentPerson < A.length)
	     {
	         // Check if current person in the queue is eligible of not.
	         if ((TotalWeight + A[CurrentPerson]) <= Y && (TotalPersons+1) <= X)
	         {
	         	 // If current person is eligible, increase Total Weight
	             TotalWeight += A[CurrentPerson];
	             // Increase total number of persons that elevator can carry
	             TotalPersons++;
	             floorList.add(B[CurrentPerson]);
	            
	             // Check if is this the last person
	             if (CurrentPerson == A.length - 1){
	                 isLiftStarted = true;
	             }

	             CurrentPerson++;
	         }
	         else
	         {
	             isLiftStarted = true;
	         }

	         if (isLiftStarted)
	         {
	             TotalStops += floorList.stream().distinct().count() + 1;
	            
	             floorList.clear();
	             TotalPersons = 0;
	             TotalWeight = 0;
	             isLiftStarted = false;
	         }
	     }

	     return TotalStops;
	 }
	 
	 public static void main(String[] args)
	{
		 /*
		 int[] A = {60, 80, 40 };
		 int[] B = {2, 3, 5};
		 int M = 5;
		 int X = 2;
		 int Y = 200;
		 */
		 
		 int[] A = {40, 40, 100, 80, 20 };
		 int[] B = {3,3,2,2,3};
		 int M = 3;
		 int X = 5;
		 int Y = 200;
		 
		 int total_stops = solution(A,B,M,X,Y);
		
		 
		 System.out.println("Solution : "+ total_stops);
		 
	}
}