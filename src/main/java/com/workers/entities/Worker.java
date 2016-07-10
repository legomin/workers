package com.workers.entities;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Worker entity class
 *
 * @Author Legomin Vitaliy
 */
@Component("worker")
public class Worker {
    private String fio;
    private String occupation;
    private String department;

    private Integer id;

    private static AtomicInteger countObjects;

    public Worker() {
    }

    public Worker(String fio, String occupation, String department) {
        this.fio = fio;
        this.occupation = occupation;
        this.department = department;

        if (countObjects == null) {
            countObjects = new AtomicInteger(0);
        }
        this.id = countObjects.incrementAndGet();
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
