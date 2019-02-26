package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.entity.TestEntity;
import com.test.service.TestService;

@Controller
public class TestController
{
	@Autowired
	private TestService testService;
	
	@GetMapping("/")
	@ResponseBody
    public String home()
	{
        return "Test Application";
    }
	
	@GetMapping("/testEntity")
	@ResponseBody
    public TestEntity getTestEntity()
	{
        return testService.getTestEntity();
    }
	
	@PostMapping(value="/setEntity")
	@ResponseBody
    public String setEntity(@RequestBody TestEntity entity)
	{
		System.out.print(entity.getId());
		System.out.print(entity.getName());
        return "Entity Created!";
    }
}
