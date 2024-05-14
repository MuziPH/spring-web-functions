package io.glitchtech.webfunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.glitchtech.TollStation;

@SpringBootApplication
public class WebFunctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebFunctionApplication.class, args);
	}

	private List<TollStation> tollStations;

	public WebFunctionApplication(){
		tollStations = new ArrayList<>();
		tollStations.add(new TollStation("100AA", 112.5f, 2));
		tollStations.add(new TollStation("111C", 124f, 4));
		tollStations.add(new TollStation("112C", 126f, 2));
	}

	@Bean
	public Function<String, TollStation> retrieveStation(){
		return passedId -> {
			System.out.println("received request for station - " + passedId);
			return tollStations.stream()
			.filter(tollStation -> passedId.equals(tollStation.getStationId()))
			.findAny()
			.orElse(null);
		};
	}

}
