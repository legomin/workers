package com.workers.services;

import com.workers.entities.Worker;
import com.workers.repositories.WorkerRepository;
import com.workers.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * service for work with workers throw the repository
 *
 * @Author Legomin Vitaliy
 */
@Service
public class WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    /**
     * save new worker
     *
     * @param worker - worker for saving
     * @return new worker's id
     * @throws RuntimeException if not success
     */
    public int save(Worker worker) {
        int result = workerRepository.save(worker);
        if (result != -1) {
            return worker.getId();
        }
        else {
            throw new RuntimeException("saving the new worker was not success");
        }
    }

    /**
     * gel all workers
     *
     * @return all workers
     */
    public Collection<Worker> getAll() {
        return workerRepository.getAll();
    }

    /**
     * get worker by id
     *
     * @param id - worker's id
     * @return found worker
     * @throws NotFoundException if not found
     */
    public Worker getById(int id) {
        Worker w = workerRepository.getById(id);
        if (w != null) {
            return w;
        }
        else {
            throw new NotFoundException("worker is not found by id "+id);
        }
    }

}
