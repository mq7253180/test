package com.quincy.test.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMapper {
	public int update(@Param("tableName")String tableName, @Param("fieldName")String fieldName, @Param("oldFieldParam")String oldFieldParam, @Param("newFieldParam")String newFieldParam);
	public int update2(@Param("oldFieldParam")String oldFieldParam, @Param("newFieldParam")String newFieldParam);
}