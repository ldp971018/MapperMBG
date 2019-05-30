package com.ldp.crm.test;

import com.ldp.crm.entities.Employee;
import com.ldp.crm.mappers.EmployeeMapper;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/**
 * @author Return
 * @create 2019-05-30 11:36
 */
public class MbgTest {

    public static void main(String[] args) {


        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        InputStream inputStream = MbgTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory factory = builder.build(inputStream);

        SqlSession session = factory.openSession();

        //***********************
        //按照Java方式整合通用Mapper的特殊设置
        //i.创建MapperHelper对象
        MapperHelper mapperHelper = new MapperHelper();

        //ii.通过MapperHelper对象对MyBatis原生的Configuration对象进行处理
        Configuration configuration = session.getConfiguration();
        mapperHelper.processConfiguration(configuration);

        //***********************

        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        //查询所有员工信息
       /* Iterator<Employee> iterator = mapper.selectAll().iterator();

        while (iterator.hasNext()) {
            Employee employee = (Employee) iterator.next();
            System.out.println(employee);
        }*/

       //根据查主键询
      /*  Employee employee = mapper.selectByPrimaryKey(1);
        System.out.println(employee);*/

        Example example = new Example(Employee.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("lastname","%章%");

        List<Employee> employees = mapper.selectByExample(example);
        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }
}
