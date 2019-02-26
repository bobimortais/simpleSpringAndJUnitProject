package com.test.service;

import org.springframework.stereotype.Service;

import com.test.entity.TestEntity;

@Service
public class TestService
{
	public TestEntity getTestEntity()
	{
		TestEntity testEntity = new TestEntity();
		testEntity.setId(1);
		testEntity.setName("Test Entity");
		return testEntity;
	}
}
