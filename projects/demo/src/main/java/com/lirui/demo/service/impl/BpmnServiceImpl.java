package com.lirui.demo.service.impl;

import com.lirui.demo.service.BpmnService;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class BpmnServiceImpl implements BpmnService {

    @Autowired
    private ProcessEngine processEngine;

    @Override
    public void testFindList() {
        List<ProcessDefinition> processDefinitions = processEngine.getRepositoryService().createProcessDefinitionQuery().list();
        for (ProcessDefinition pd : processDefinitions) {
            log.info("name is {}, key is {}, detail shows as {}", pd.getName(), pd.getKey(), pd);
        }
    }

    @Override
    public void testCreateProcess() {
        Deployment deploy = processEngine.getRepositoryService()
                .createDeployment()
                .name("My process 2")
                .addClasspathResource("bpmn/my-process.bpmn")
                .key("MY_APP_KEY_2")
                .tenantId("MY_APP_2")
                .deploy();
        log.info(deploy.getId());
    }

    @Override
    public void testStartProcess(String key) {
        Authentication.setAuthenticatedUserId("admin");
        ProcessInstance pi = processEngine.getRuntimeService()
                .createProcessInstanceBuilder()
                .processDefinitionKey(key)
                .name("lalalalalala backend generate")
                .start();
        log.info(pi.getId());
    }

    @Override
    public void testQueryUnassignedTasks() {
        List<Task> tasks = processEngine.getTaskService().createTaskQuery().taskUnassigned().list();
        log.info(tasks.toString());
    }

    @Override
    public void testClaimTask(String taskId, String user) {
        processEngine.getTaskService().claim(taskId, user);
    }

    @Override
    public void testCompleteTask(String user, String taskId, String comment, Map<String, String> vars) {
        Authentication.setAuthenticatedUserId(user);
        processEngine.getTaskService().addComment(taskId, null, comment);
//        processEngine.getFormService().submitTaskFormData(taskId, vars);
        processEngine.getTaskService().complete(taskId);
    }

    @Override
    public void testQueryUserTasks(String user) {
        List<Task> tasks = processEngine.getTaskService().createTaskQuery().taskCandidateOrAssigned(user).list();
        log.info(tasks.toString());
    }

}
