package com.quincy.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quincy.test.mapper.TestMapper;

@Service
public class TestService {
	@Autowired
	private TestMapper testMapper;

	@Transactional
	public int[] test(String tableName, String[] fieldNames, String[] oldFieldParams, String[] newFieldParams) {
		int[] r = new int[fieldNames.length];
		for(int i=0;i<fieldNames.length;i++)
			r[i] = testMapper.update(tableName, fieldNames[i], oldFieldParams[i], newFieldParams[i]);
		return r;
	}

	@Transactional
	public int test(String oldFieldParam, String newFieldParam) {
		return testMapper.update2(oldFieldParam, newFieldParam);
	}

	@Transactional
	public int[] test(String tableName, String fieldName, String[] oldFieldParams, String[] newFieldParams) {
		int[] r = new int[oldFieldParams.length];
		for(int i=0;i<oldFieldParams.length;i++)
			r[i] = testMapper.update(tableName, fieldName, oldFieldParams[i], newFieldParams[i]);
		return r;
	}
}
