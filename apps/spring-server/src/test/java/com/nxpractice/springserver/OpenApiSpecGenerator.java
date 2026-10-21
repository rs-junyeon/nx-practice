package com.nxpractice.springserver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

/**
 * 서버를 띄우지 않고 OpenAPI 명세를 파일로 저장한다. Gradle의 generateOpenApi 태스크에서만 실행된다.
 */
@Tag("openapi")
@SpringBootTest(properties = {
		"springdoc.writer-with-default-pretty-printer=true",
		"springdoc.writer-with-order-by-keys=true" })
@AutoConfigureMockMvc
class OpenApiSpecGenerator {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void writeOpenApiSpec() throws Exception {
		String spec = mockMvc.perform(get("/v3/api-docs"))
			.andExpect(status().isOk())
			.andReturn()
			.getResponse()
			.getContentAsString();

		Path output = Path.of(System.getProperty("openapi.output"));
		Files.createDirectories(output.getParent());
		Files.writeString(output, spec);
	}

}
