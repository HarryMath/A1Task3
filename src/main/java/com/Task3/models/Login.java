package com.Task3.models;

public class Login {
    public String Application;
    public String AppAccountName;
    public short IsActive;
    public String JobTitle;
    public String Department;

    public Login(String Application, String AppAccountName,
                   short IsActive, String JobTitle, String Department) {
        this.Application = Application;
        this.AppAccountName = AppAccountName;
        this.IsActive = IsActive;
        this.JobTitle = JobTitle;
        this.Department = Department;
    }
}
