package com.pshekhar.restclient;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.pshekhar.restclient.client.CoinbaseClient;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@Component
public class PricePrinter implements CommandLineRunner {

	@Autowired
	private CoinbaseClient client;

	@Override
	public void run(String... args) throws Exception {
		Observable.interval(3000, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).subscribe(tick -> {
			client.printPrice("BTC-USD");
			client.printPrice("ETH-INR");
		});
	}

}
