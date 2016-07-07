package com.example.jxw679.mogul.model;

/**
 * Created by jxw679 on 7/6/16.
 */
public class Task {
    public String deadline;
    public String description;
    public String owner;
    public String taskname;
    public boolean completed;
    public int reward;

    public Task() {

    }

    public Task(String deadline, String description, String owner, String taskname, boolean completed, int reward) {
        this.deadline = deadline;
        this.description = description;
        this.owner = owner;
        this.taskname = taskname;
        this.completed = completed;
        this.reward = reward;
    }


    public boolean isCompleted() {
        return completed;
    }

    public int getReward() {
        return reward;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getOwner() {
        return owner;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public String getDescription() {
        return description;
    }

    public String getTaskname() {
        return taskname;
    }

    public String toString() {
        return taskname + ": " + description + ", " + owner + ", " + deadline + ", " + completed + ", " + reward;
    }
}
