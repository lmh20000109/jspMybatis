package com.lmh.mapper;

import com.lmh.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

//    查询所有
     List<Brand> selectAll();
//    查看详情
    Brand selectById(int id);

    /* *条件查询
            *参数接收
            * 1、散装参数：如果方法中有多个参数，需要使用@Param（"SQL参数占位符名称"）
            * 2、对象参数:对象的属性名称要和参数占位符名称要一致
            * 3、map集合参数
    *
    * */
   // List<Brand> selectByCondition(@Param("status") int status,@Param("companyName") String companyName,@Param("brandName") String brnadName);

//    List<Brand> selectByCondition(Brand brand);

    List<Brand> selectByCondition(Map map);

    List<Brand> selectByConditionSingle(Brand brand);

    /*
    * 添加
    * */
    void add(Brand brand);

    /*
    * 修改
    * */
    int update(Brand brand);

    /*
    * 根据id删除
    * */
    void deleteById(int id);

    /*
    * 批量删除
    * */
    void deleteByIds(@Param("ids") int[] ids);
}
