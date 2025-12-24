package org.fab.sisrecruta.servicies;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ProcessInstanceEvent;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProcessServce {

    private final ZeebeClient zeebeClient;


    public ProcessServce(ZeebeClient zeebeClient) {
        this.zeebeClient = zeebeClient;
    }

    public ProcessInstanceEvent startProcess(String bpmnProcessId, Map<String, Object> variables) {
        return zeebeClient
                .newCreateInstanceCommand()
                .bpmnProcessId(bpmnProcessId)
                .latestVersion()
                .variables(variables)
                .send().join();
    }
}
