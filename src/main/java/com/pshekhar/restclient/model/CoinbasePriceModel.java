package com.pshekhar.restclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinbasePriceModel {
	@JsonProperty("data")
	private Data data;

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public class Data {
		@JsonProperty("base")
		private String base;
		@JsonProperty("currency")
		private String currency;
		@JsonProperty("amount")
		private String amount;

		public String getBase() {
			return base;
		}

		public void setBase(String base) {
			this.base = base;
		}

		public String getCurrency() {
			return currency;
		}

		public void setCurrency(String currency) {
			this.currency = currency;
		}

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}
	}
}
