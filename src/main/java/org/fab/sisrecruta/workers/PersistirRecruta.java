package org.fab.sisrecruta.workers;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.fab.sisrecruta.entities.RecrutaEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PersistirRecruta {

    @JobWorker(type = "SW_SALVAR_RECRUTA")
    public void handle(ActivatedJob job) {
        var variables = job.getVariablesAsMap();
        

        System.out.println(variables);
    }
}
