package com.quincy.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quincy.test.auto.FooTemplate;
import com.quincy.test.auto.Template;

@Controller
@RequestMapping("/test")
public class TestController {
	@Template
	@Autowired
	private List<FooTemplate> fooTemplates;
	@Autowired
	private TestService testService;
	
	@RequestMapping("/abc")
	@ResponseBody
	public Result abc() {
		Result r = new Result();
		r.setCode("0x000");
		r.setMsg("Success");
		r.setData("查询结果");
		for(FooTemplate t:fooTemplates) {
			System.out.println("---"+t.getName());
		}
		return r;
	}

	@RequestMapping("/def")
	@ResponseBody
	public Result def() {
		Result r = new Result();
		r.setCode("0x000");
		r.setMsg("Success");
		r.setData(testService.test("b_region", new String[] {"en_name", "cn_name", "en_name"}, new String[] {"Ireland", "卢森堡", "Dominica"}, new String[] {"Ireland-new", "卢森堡-new", "Dominica-new"}));
		return r;
	}

	@RequestMapping("/ghi")
	@ResponseBody
	public Result ghi() {
		Result r = new Result();
		r.setCode("0x000");
		r.setMsg("Success");
		r.setData(testService.test("Ireland", "Ireland-new"));
		return r;
	}

	@RequestMapping("/jkl")
	@ResponseBody
	public Result jkl() {
		Result r = new Result();
		r.setCode("0x000");
		r.setMsg("Success");
		r.setData(testService.test("b_region", new String[] {"en_name", "en_name", "cn_name"}, new String[] {"Ireland", "Dominica", "卢森堡"}, new String[] {"Ireland-new", "Dominica-new", "卢森堡-new"}));
		return r;
	}
}