package org.fab.sisrecruta.controllers;

import io.camunda.zeebe.client.api.response.ProcessInstanceEvent;
import org.fab.sisrecruta.servicies.ProcessServce;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/process")
public class ProcessController {

    private final ProcessServce processServce;

    public ProcessController(ProcessServce processServce) {
        this.processServce = processServce;
    }

    @PostMapping("/{bpmnName}")
    public ResponseEntity<?> start(@PathVariable String bpmnName, @RequestBody Map<String, Object> variables) {
        Map<String, Object> vars = (variables == null) ? Map.of() : variables;

        ProcessInstanceEvent event = processServce.startProcess(bpmnName, vars);
        return ResponseEntity.ok(event);
    }
}
