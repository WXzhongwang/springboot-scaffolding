package com.qlt.tracing.self.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TestMapper {


    @Select( " select count(1) from  user   "  )
    Integer countAll();

    @Update( " update user set age = 12 where id =1  "  )
    Integer updateAge();
}
