package io.rooftop.agile.service;

import io.rooftop.kpi.repository.KpiRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KpiServiceTest {

    @Autowired
    KpiRepository kpiRepository;


}