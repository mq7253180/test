package com.quincy.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {
	@GetMapping("/abc")
	@ResponseBody
	public Result abc() {
		Result r = new Result();
		r.setCode("0x000");
		r.setMsg("Success");
		r.setData("查询结果");
		return r;
	}
}