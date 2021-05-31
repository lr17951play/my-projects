package com.lirui.demo.bpmn;

import java.util.Map;

public interface BpmnService {

    void testFindList();

    void testCreateProcess();

    void testStartProcess(String key);

    void testQueryUnassignedTasks();

    void testClaimTask(String taskId, String user);

    void testCompleteTask(String user, String taskId, String comment, Map<String, String> vars);

    void testQueryUserTasks(String user);
}
