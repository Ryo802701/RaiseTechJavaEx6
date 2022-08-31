package com.example.RaiseTechJavaEx6;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {

	private MessageSource messageSource;

	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	// 文字列を出力
	@GetMapping("/1")
	public String hello1() {
		return "Hello World!";
	}

	// HTMLを出力
	@GetMapping("/2")
	public void hello2(HttpServletResponse res) throws IOException {
		LocalDateTime ldtNow = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd/ HH:mm:ss.SSS");
		String strNow = dtf.format(ldtNow);

		res.setContentType("text/html; charset=Shift_JIS");
		PrintWriter out = res.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello World</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("Hello World!!</br>");
		out.println("現在日時は " + strNow);
		out.println("</body>");
		out.println("</html>");

		out.close();
	}

	// リクエストで受け取った国（japan、us、france、korea）ごとに出すメッセージを変える
	@GetMapping("/3")
	public String hello3(Locale locale) {
		return messageSource.getMessage("message", null, locale);
	}
}
