package com.workers.web;

import com.workers.entities.Worker;
import com.workers.services.WorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Main class of rest controller
 *
 * @Author Legomin Vitaliy
 *
 * TODO 1. Валидацию не делал, т.к. из условия не ясно, как обрабатывать, в каком формате говорить пользователю
 * TODO 2. Обработку исключений в принципе сделал, осталось договориться, в каком формате это возвращать по REST
 * Долго решал, надо ли отдельно выделять сервисы.
 * Решил выделить, хотя для данной задачи необходимости нет
 * Написал тест контроллера, сервис и репозиторий тестировать не стал, там все проще.
 *
 *
 */
@RestController
@RequestMapping("/")
public class MainController {

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @Autowired
    WorkerService workerService;

    /**
     * function get worker by id from services and return JSON serialization it to client
     *
     * @param id
     * @return JSON serialization of gotten worker
     */
    @RequestMapping(value = "/worker")
    public Worker getWorker(@RequestParam(value = "id", required = true) int id) {
        LOG.info("Get by id: {}", id);
        return workerService.getById(id);
    }

    /**
     * get all workers
     *
     * @return JSON serialization of all workers in db
     * WARNING!! NO PAGINATION!!
     */
    @RequestMapping(value = "/workerlist")
    public Collection<Worker> getWorkerList() {
        LOG.info("Get all");
        return workerService.getAll();
    }

    /**
     * function add worker to db
     * @param fio
     * @param occupation
     * @param department
     * @return id of new worker
     */
    @RequestMapping(value = "/addWorker", method = RequestMethod.POST)
    public int addWorker(@RequestParam(value = "fio", required = true) String fio,
                          @RequestParam(value = "occupation", required = true) String occupation,
                          @RequestParam(value = "department", required = true) String department) {
        Worker worker = new Worker(fio, occupation, department);
        LOG.info("Insert: {}", worker);
        return workerService.save(worker);
    }
}
