/**
 * Created by csy99 on 9/15/21.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * L0 → L1 → L2 Workers are given task stages to work on. A task is only “complete” when it reaches
 * the L2 stage. A worker can only work on a task once.
 * 
 * Write a system that simulates the environment and runs until all tasks are completed. Do not
 * worry about runtime, we are looking for correctness. On every timestep where activity happens:
 * Print out the timestep, and all the activities that happened. (worker assignment/completion). At
 * the end, print out the total number of time steps taken to complete the simulation.
 * 
 **/
// Sample input 1: tasks = [Task('A')] workers = [Worker('X'), Worker('Y'), Worker('Z')]
// Sample output 1:
// 0
// Assigning X to Task A for L0
// 1
// Worker X finished Task A for L0
// Assigning Y to Task A for L1
// 2
// Worker Y finished Task A for L1
// Assigning Z to Task A for L2
// 3
// Worker Z finished Task A for L2
// Total time taken: 3 ts


class Task {
    private String name;
    private int stage;

    public Task(String nm) {
        name = nm;
        stage = 0;
    }

    public boolean isDone() {
        return stage >= 3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }
}


class Worker {
    private String name;
    Task current;
    private Set<String> seen;

    public Worker(String nm) {
        name = nm;
        current = null;
        seen = new HashSet();
    }

    public void assign(Task task) {
        String task_name = task.getName();
        seen.add(task_name);
        current = task;
        System.out.printf("Assigning %s to Task %s for L%d\n", name, task_name, task.getStage());
    }

    public void finish() {
        if (!isBusy())
            return;
        int stage = current.getStage();
        System.out.printf("Worker %s finished Task %s for L%d\n", name, current.getName(), stage);
        current.setStage(stage + 1);
        current = null;
    }

    public boolean isBusy() {
        return current != null;
    }

    public boolean hasSeen(Task task) {
        return seen.contains(task.getName());
    }

    public String getName() {
        return name;
    }
}


class Main {
    private static void taskTime(List<Task> tasks, List<Worker> workers) {
        int t = 0;
        int n = workers.size();
        if (n < 3)
            System.out.println("Impossible to finish the work.");
        while (tasks.size() > 0) {
            System.out.println(t);
            for (int j = 0; j < n; j++)
                workers.get(j).finish();
            int i = 0;
            while (i < tasks.size()) {
                Task task = tasks.get(i);
                if (task.isDone()) {
                    tasks.remove(i);
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    Worker worker = workers.get(j);
                    if (!worker.isBusy() && !worker.hasSeen(task)) {
                        worker.assign(task);
                        break;
                    }
                }
                i++;
            }
            t++;
        }
        System.out.printf("Total time taken: %d ts\n", t);
    }

    public static void main(String[] args) {
        String[] task_names = new String[] {"A", "B", "C", "D"};
        String[] worker_names = new String[] {"X", "Y", "Z"};
        List<Task> tasks = new ArrayList();
        List<Worker> workers = new ArrayList();
        for (String name : task_names)
            tasks.add(new Task(name));
        for (String name : worker_names)
            workers.add(new Worker(name));
        taskTime(tasks, workers);
    }
}
