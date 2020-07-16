package com.aforo255.account.domain;
import javax.json.bind.annotation.JsonbProperty;
public class Currency {

	private String id;
	private String name ;
	private String symbol;
	@JsonbProperty("price_usd")
	private String priceUsd;
	
	public String getId()  {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getPriceUsd() {
		return priceUsd;
	}

	public void setPriceUsd(String priceUsd) {
		this.priceUsd = priceUsd;
	}

	public Currency() {}
	
	
}
