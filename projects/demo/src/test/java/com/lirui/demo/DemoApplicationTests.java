package com.lirui.demo;

import com.lirui.demo.service.BpmnService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private BpmnService bpmnService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test () {
//		bpmnService.testFindList();
//		bpmnService.testStartProcess("LEAVE_PROCESS");
//		bpmnService.testQueryUserTasks("admin");
		Map<String, String> vars = processVars();
//		bpmnService.testCompleteTask("admin", "62558", "comment task", vars);
//		bpmnService.testQueryUnassignedTasks();
//		bpmnService.testClaimTask("62536", "admin");
		bpmnService.testCreateProcess();
	}

	private Map<String, String> processVars(){
		Map<String, String> vars = new HashMap<>();
		vars.put("startDate","2020-05-07");
		vars.put("endDate","2020-05-07");
		vars.put("reason","lalalalalalalalala");
		return vars;
	}

}
