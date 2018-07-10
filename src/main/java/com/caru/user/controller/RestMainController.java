package com.caru.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ConfigServerTestDynamicService
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 07. 10.
 */
@RestController
@RefreshScope
public class RestMainController {
	@Value("${leekyoungil.said.first}")
	private String first;
	@Value("${leekyoungil.said.second}")
	private String second;

	@GetMapping("/config")
	public Map config() {
		Map result = new HashMap();
		result.put("first", first);
		result.put("second", second);
		return result;
	}
}
