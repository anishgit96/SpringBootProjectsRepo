package com.example.WebFlux.WebFlux_Demo;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class HelloWorldHandler {

	public Mono<ServerResponse> helloWorld(ServerRequest request) {      //Mono holds the server response body
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)     //Represents a typed server-side HTTP response.
			.body(BodyInserters.fromObject("Hello World!"));
	}
}
