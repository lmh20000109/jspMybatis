package com.lmh.test;

import com.lmh.mapper.BrandMapper;
import com.lmh.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {


    @Test
    public void testSelectAll() throws IOException {
        //1、获取SQLSessionFactory

        //1、加载mybatis的核心配置文件，获取sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4、执行方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        //5、释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        //接收参数
        int id = 1;

        //1、获取SQLSessionFactory

        //1、加载mybatis的核心配置文件，获取sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4、执行方法
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        //5、释放资源
        sqlSession.close();
    }



    @Test
    public void testSelectByCondition() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";


        //封装对象
//        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);

        Map map = new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
//        map.put("brandName",brandName);

        //1、获取SQLSessionFactory

        //1、加载mybatis的核心配置文件，获取sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4、执行方法
//        List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);
//        List<Brand> brands = brandMapper.selectByCondition(brand);
          List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        //5、释放资源
        sqlSession.close();
    }


    @Test
    public void testSelectByConditionSingle() throws IOException {
        //接收参数
//        int status = 1;
//        String companyName = "华为";
//        String brandName = "华为";

        //处理参数
//        companyName = "%" + companyName + "%";
//        brandName = "%" + brandName + "%";


        //封装对象
        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);

        //1、加载mybatis的核心配置文件，获取sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4、执行方法

        List<Brand> brands = brandMapper.selectByConditionSingle(brand);

        System.out.println(brands);

        //5、释放资源
        sqlSession.close();
    }



    @Test
    public void testAdd() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "苹果手机";
        String brandName = "苹果";
        String description = "手机中的战斗机";
        int orderd = 100;

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrderd(orderd);

        //1、加载mybatis的核心配置文件，获取sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SQLSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        //设置自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4、执行方法
        brandMapper.add(brand);
        int i = brand.getId();
        System.out.println(i);

        //提交事务
        sqlSession.commit();

        //5、释放资源
        sqlSession.close();
    }


    @Test
    public void testupdate() throws IOException {
        //接收参数
        int id = 7;
        int status = 1;
        String companyName = "诺基亚手机";
        String brandName = "诺基亚";
        String description = "手机中的战斗机";
        int orderd = 200;

        //封装对象
        Brand brand = new Brand();
        brand.setId(id);
        brand.setStatus(status);
        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//        brand.setDescription(description);
//        brand.setOrderd(orderd);


        //1、加载mybatis的核心配置文件，获取sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取SQLSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        //设置自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4、执行方法
        int count = brandMapper.update(brand);

        System.out.println(count);

        //提交事务
        sqlSession.commit();

        //5、释放资源
        sqlSession.close();
    }





    @Test
    public void testdeleteById() throws IOException {
        //接收参数
        int id = 7;
        //1、加载mybatis的核心配置文件，获取sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4、执行方法
        brandMapper.deleteById(id);
        //提交事务
        sqlSession.commit();
        //5、释放资源
        sqlSession.close();
    }

    @Test
    public void testdeleteByIds() throws IOException {
        //接收参数
        int[] ids = {6};
        //1、加载mybatis的核心配置文件，获取sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3、获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4、执行方法
        brandMapper.deleteByIds(ids);
        //提交事务
        sqlSession.commit();
        //5、释放资源
        sqlSession.close();
    }
}
