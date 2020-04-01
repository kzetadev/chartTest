package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.EmpManager;
import com.example.demo.vo.DeptEmpVo;
import com.google.gson.Gson;

@RestController
public class EmpController {
	@RequestMapping(value="/listCnt", produces = "application/json; charset=utf-8")
	public String listEmp() {
		String str = "";
		List<DeptEmpVo>list = EmpManager.listCnt();
		Gson gson = new Gson();
		str = gson.toJson(list);
		return str;
	}
}
