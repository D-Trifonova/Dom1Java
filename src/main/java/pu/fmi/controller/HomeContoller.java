package pu.fmi.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller; // <protocol>://[:<prot>]/<path>[?<query-string>] query-string - key=value& (tova e URI = Universal Recourse Identifier(novo ime na URL - vzaimno zamenqemi))
import org.springframework.web.bind.annotation.GetMapping; // CRUD - post, get, put i delete
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletResponse; // https://developer.mozilla.org/en-US/docs/Web/HTTP/Status

@Controller
public class HomeContoller { // Stateless - ne si pomni s1stoqnieto

	@GetMapping(path = "/", produces = MediaType.TEXT_HTML_VALUE) // APPLICATION_OCTET_STREAM_VALUE
	@ResponseBody // Moje i ResController vmesto ResponseBody
	public String sayHello(HttpServletResponse res) {

		// res.setContentType("plain") // res.setCharacterEncoding("ASCII");
		res.setContentType("plain/text;charset=ASCII");
		// StandardCharsets.ISO_8859_1.toString()
		return "Say Hello тест 😀";
	}
	// TODO end
}