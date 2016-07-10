package com.workers.web;

import com.workers.services.WorkerService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by vitas on 09.07.16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/test-mvc.xml")
public class MainControllerTest {

    @Autowired
    MainController mainController;

    @Before
    public void testAddWorker() {
       mainController.addWorker("fsg","fbv","vz ");
    }

    @Test
    public void testGetWorker() throws Exception {
        Assert.assertEquals(mainController.getWorker(1).getId() == 1, true);
    }
    @Test
    public void testGetWorkerList() throws Exception {
        Assert.assertEquals(mainController.getWorkerList().size(),1);

    }

}