package com.nxpractice.springserver.hello;

import io.swagger.v3.oas.annotations.media.Schema;

public record HelloResponse(
		@Schema(requiredMode = Schema.RequiredMode.REQUIRED) String message) {
}
