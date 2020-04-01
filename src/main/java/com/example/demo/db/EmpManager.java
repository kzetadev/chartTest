package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.DeptEmpVo;
import com.example.demo.vo.EmpVo;

public class EmpManager {
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static List<EmpVo> listAll(){
		SqlSession session = factory.openSession();
		List<EmpVo> list = session.selectList("emp.list");
		session.close();
		return list;
	}
	public static List<DeptEmpVo> listCnt(){
		SqlSession session = factory.openSession();
		List<DeptEmpVo> list = session.selectList("emp.deptEmpCnt");
		session.close();
		return list;
	}
}
