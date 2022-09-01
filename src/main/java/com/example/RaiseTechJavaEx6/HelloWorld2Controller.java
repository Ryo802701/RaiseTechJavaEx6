package com.example.RaiseTechJavaEx6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld2Controller {

	// 文字列を出力
	@RequestMapping("/helloworld2")
	public String hello(Model model) {
		// 現在日時取得
		LocalDateTime ldtNow = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd/ HH:mm:ss.SSS");
		String strNow = dtf.format(ldtNow);

		model.addAttribute("message", "Hello World!(using html file)");
		model.addAttribute("now", strNow);
		return "HelloWorld";
	}
}
