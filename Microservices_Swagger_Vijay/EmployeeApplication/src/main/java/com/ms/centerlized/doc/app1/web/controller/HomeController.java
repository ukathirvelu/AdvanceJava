/**
 * 
 */
package com.ms.centerlized.doc.app1.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kvijayakumar
 *
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public String index() {
		return "redirect:swagger-ui.html";
	}
}
