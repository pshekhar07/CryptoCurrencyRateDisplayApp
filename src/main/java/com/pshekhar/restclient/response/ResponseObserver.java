package com.pshekhar.restclient.response;

import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pshekhar.restclient.model.CoinbasePriceModel;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class ResponseObserver implements Observer<CloseableHttpResponse> {
	private static final ObjectMapper MAPPER = new ObjectMapper();

	@Override
	public void onSubscribe(Disposable d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onNext(CloseableHttpResponse t) {
		String response = null;
		try {
			response = EntityUtils.toString(t.getEntity());
			if (null != response) {
				CoinbasePriceModel model = MAPPER.readValue(response, CoinbasePriceModel.class);
				System.out.println("[" + LocalDateTime.now() + "] Base=" + model.getData().getBase() + " | Currency="
						+ model.getData().getCurrency() + " | Amount=" + model.getData().getAmount());
			}
		} catch (ParseException | IOException e) {
			System.err.println("Error in parsing model: " + e.getMessage());
		}
	}

	@Override
	public void onError(Throwable e) {
		System.err.println("Error occured while calling service: " + e.getMessage());
	}

	@Override
	public void onComplete() {
		// TODO Auto-generated method stub

	}

}
