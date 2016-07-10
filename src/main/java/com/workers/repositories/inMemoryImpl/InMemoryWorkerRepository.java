package com.workers.repositories.inMemoryImpl;

import com.workers.entities.Worker;
import com.workers.repositories.WorkerRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * In Memory implementation
 *
 * @Author Legomin Vitaliy
 */
@Repository
public class InMemoryWorkerRepository implements WorkerRepository {

    private static Map<Integer, Worker> inMemoryDB = new HashMap<Integer, Worker>();


    public int save(Worker worker) {
        try {
            inMemoryDB.put(worker.getId(), worker);
            return worker.getId();
        }
        catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean delete(Worker worker) {
        if (inMemoryDB.containsValue(worker)) {
            inMemoryDB.remove(worker);
            return true;
        }
        else {
            return false;
        }

    }

    public Worker getByFIO(String fio) {
        for (Worker w : inMemoryDB.values()) {
            if (fio.equals(w.getFio())) {
                return w;
            }
        }
        return null;
    }

    public Collection<Worker> getAll() {
        return inMemoryDB.values();
    }

    public Worker getById(int id) {
        return inMemoryDB.get(id);
    }
}
