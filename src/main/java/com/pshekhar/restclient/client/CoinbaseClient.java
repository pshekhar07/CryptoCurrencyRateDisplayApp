package com.pshekhar.restclient.client;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

import com.pshekhar.restclient.response.ResponseObserver;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@Component
public class CoinbaseClient {
	private final CloseableHttpClient client = HttpClients.createDefault();

	public void printPrice(final String crypto) {
		final String URI = "https://api.coinbase.com/v2/prices/" + crypto + "/buy";
		HttpGet request = new HttpGet(URI);
		request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		Observable<CloseableHttpResponse> observable = Observable.fromCallable(() -> client.execute(request));

		observable.subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new ResponseObserver());
	}
}
