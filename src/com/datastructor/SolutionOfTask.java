package com.datastructor;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolutionOfTask {
    //Create a nested class of task
    class Task implements Comparable<Task> {

        public long D;
        public long M;

        public Task(long D, long M) {
            this.D = D;
            this.M = M;
        }

        public int compareTo(Task task) {
            if (this.D < task.D)
            {
                return -1;
            }
            else if (this.D > task.D)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
    }

    public static Map<Long, Long> map = new HashMap<>();
    public static long maxSoFar = -1;
    public static long deadlineOfMax = -1;
    static long solve(List tasks, long D, long M, int upIndex) {

        if (maxSoFar >= 0 && D <= deadlineOfMax)
        {
            map.put(deadlineOfMax, map.get(deadlineOfMax) + M);
            maxSoFar += M;
            return Math.max(0, maxSoFar);
        }

        if (!map.containsKey(D))
        {
            map.put(D, M);
        }
        else
        {
            map.put(D, map.get(D) + M);
        }

      //  if (tasks.size() == 0)
        {
            tasks.add(D);
            return Math.max(0, M - D);
        }
        else
        {
            long total = 0;
            int index = 0;
            long max = -1;
            boolean found = false;
            while (index < tasks.size() && tasks.get(index) <= D)
            {
                if (tasks.get(index) == D)
                    found = true;
                total += map.get(tasks.get(index));
                long diff = total - tasks.get(index);
                if (diff > max)
                {
                    max = diff;
                    maxSoFar = max;
                    deadlineOfMax = tasks.get(index);
                }
                index++;
            }
            if (!found)
                tasks.add(index, D);       // linear, can we avoid this?
            while (index < tasks.size())
            {
                total += map.get(tasks.get(index));
                long diff = total - tasks.get(index);
                if (diff > max)
                {
                    max = diff;
                    maxSoFar = max;
                    deadlineOfMax = tasks.get(index);
                }
                index++;
            }
            return Math.max(0, max);
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int t = Integer.parseInt(scanner.nextLine().trim());
        List<Long> tasks = new ArrayList<>(t);
        for (int tItr = 0; tItr < t; tItr++) {
            String[] dm = scanner.nextLine().split(" ");

            int d = Integer.parseInt(dm[0].trim());

            int m = Integer.parseInt(dm[1].trim());

            long result = solve(tasks,d, m, tItr);

            System.out.println(result);
        }

    }
}
