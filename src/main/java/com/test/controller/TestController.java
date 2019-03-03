package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.test.entity.TestEntity;
import com.test.repo.TestEntityRepo;
import com.test.service.TestService;

@Controller
public class TestController
{	
	@Autowired
	private TestService testService;
	
	@Autowired
	private TestEntityRepo testEntityRepo;
	
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
		System.out.println(entity.getId());
		System.out.println(entity.getName());
		
		testEntityRepo.save(entity);
		TestEntity savedEntity = testEntityRepo.findById(entity.getId()).get();
		System.out.println("Name of the saved entity is " + savedEntity.getName());
		testEntityRepo.delete(savedEntity);
		
        return "Entity Created!";
    }
}
