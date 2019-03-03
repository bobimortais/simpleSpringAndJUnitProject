package com.test.repo;

import org.springframework.data.repository.CrudRepository;
import com.test.entity.TestEntity;

public interface TestEntityRepo extends CrudRepository<TestEntity, Integer> 
{

}
