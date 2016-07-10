package com.workers.repositories;

import com.workers.entities.Worker;

import java.util.Collection;

/**
 * Interface fo DB work
 *
 * @Author Legomin Vitaliy
 */
public interface WorkerRepository {
    /**
     * saving worker to db
     *
     * @param worker
     * @return id of new worker if all good or -1 if not
     */
    int save(Worker worker);

    /**
     * deleting worker from db
     *
     * @param worker
     * @return true, if success, else false
     */
    boolean delete(Worker worker);

    /**
     * search worker by FIO in DB
     *
     * @param fio
     * @return found worker or null
     */
    Worker getByFIO(String fio);

    /**
     * get all workers in DB
     *
     * @return all workers in DB
     */
    Collection<Worker> getAll();

    /**
     * search worker by id in DB
     *
     * @param id
     * @return found worker or null
     */
    Worker getById(int id);

}
