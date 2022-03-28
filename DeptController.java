package egovframework.example.sample.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.sample.service.DeptService;
import egovframework.example.sample.service.DeptVO;

@Controller
public class DeptController {
	@Resource(name="deptService")
	private DeptService deptService;
	
	String a = "DeptController: ";

	@RequestMapping(value = "/test.do")
	public String testing() throws Exception {
		System.out.println(a + "test.do 실행..");
		return "jun/test";
	}

	@RequestMapping(value = "/deptWrite.do")
	public String deptWrite() throws Exception {
		System.out.println(a + "deptWrite.do 실행..");
		return "jun/deptWrite";
	}

	/* 다만 이런식으로 하면 매개변수가 많을 경우 너무 힘듬 그래서 VO 또는 hashmap으로 함 */
	/* 서비스를 태워서 DB에 저장해보자 */
	@RequestMapping(value = "/deptWriteSave.do")
	public String insertDept(DeptVO vo) throws Exception {
		System.out.println(a + "deptWriteSave.do 실행..");
		System.out.println("부서번호: " + vo.getDeptno());
		System.out.println("부서이름: " + vo.getDname());
		System.out.println("부서위치: " + vo.getLoc());
		
		String result = deptService.insertDept(vo);
		//반대!! 이미 DB에 담고나서는 메모리는 null이다.
		if(result == null) {
			System.out.println("저장완료");
		}
		else{
			System.out.println("저장실패");
		}
		return "jun/test";
	}

	@RequestMapping(value = "/deptList.do")
	public String selectDeptList(DeptVO vo, ModelMap model) throws Exception {
		List<?> list = deptService.selectDeptList(vo);
		System.out.println(list);
		//model.addAttribute 앞부분은 이름, 뒷부분은 진짜 값: jsp에서 jstl문법 사용해서 ${resultList}이런식
		model.addAttribute("resultList", list);
		return "jun/deptList";
	}
}
