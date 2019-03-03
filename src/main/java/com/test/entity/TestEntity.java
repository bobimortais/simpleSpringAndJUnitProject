package com.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "TEST_ENTITY")
public class TestEntity
{
	@Id
	@Column(name="id")
	@GeneratedValue
	@JsonProperty("id")
	private int id;
	
	@Column(name="name")
	@JsonProperty("name")
	private String name;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
