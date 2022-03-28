package egovframework.example.sample.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.DeptVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

//DAO는 SQL 연결해주는 파일
@Repository("deptDAO")
public class DeptDAO extends EgovAbstractDAO{

	public String insertDept(DeptVO vo) throws Exception {

		//insert() 부분은 메서드이며 ""안에 부분은 Dept_SQL.xml 의 id부분이다.
		return (String) insert("deptDAO_insertDept",vo);
	}

	public List<?> selectDeptList(DeptVO vo) {

		return (List<?>) list("deptDAO_selectDeptList",vo);
	}

}
