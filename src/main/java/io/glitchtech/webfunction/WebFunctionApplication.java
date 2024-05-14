package io.glitchtech.webfunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.glitchtech.model.TollRecord;
import io.glitchtech.model.TollStation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class WebFunctionApplication {
	private static Logger logger = LoggerFactory.getLogger(WebFunctionApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WebFunctionApplication.class, args);
	}

	private List<TollStation> tollStations;

	public WebFunctionApplication(){
		tollStations = new ArrayList<>();
		tollStations.add(new TollStation("100A", 112.5f, 2));
		tollStations.add(new TollStation("111C", 124f, 4));
		tollStations.add(new TollStation("112C", 126f, 2));
	}

	@Bean
	public Function<String, TollStation> retrieveStation(){
		return passedId -> {
			logger.info("Received request for station - " + passedId);
			return tollStations.stream()
			.filter(tollStation -> passedId.equals(tollStation.getStationId()))
			.findAny()
			.orElse(null);
		};
	}

	@Bean
	public Consumer<TollRecord> processTollRecord(){
		return tollRecord -> {
			logger.info("Received toll for car with license plate - " + tollRecord.getLicensePlate());
		};
	}

	@Bean
	public Function<TollRecord, Mono<Void>> processTollRecordReactive(){
		return tollRecord -> {
			logger.info("Received reactive toll for car with license plate - " + tollRecord.getLicensePlate());
			return Mono.empty();
		};
	}

	@Bean
	public Consumer<Flux<TollRecord>> processListTollRecordsReactive(){
		return tollRecords -> {
			tollRecords.subscribe(tollRecord -> logger.info(tollRecord.getLicensePlate()));
		};
	}

	@Bean
	public Supplier<Flux<TollStation>> getTollStations(){
		return () -> Flux.fromIterable(tollStations);
	}

}
