package com.nefig.lab.mockito.chapter4;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.ArgumentMatcher;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StockBrokerTest {
	@Mock
	MarketWatcher marketWatcher;
	@Mock
	Portfolio portfolio;
	StockBroker broker;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		broker = new StockBroker(marketWatcher);

	}

	@Test
	public void sanity() throws Exception {
		assertNotNull(marketWatcher);
		assertNotNull(portfolio);
	}

	@Test
	public void marketWatcher_returns_current_stock_status() {
		Stock uvsityCorp = new Stock("UV", "University Corporation",
				new BigDecimal("100.00"));

		when(marketWatcher.getQuote(Matchers.anyString())).thenReturn(
				uvsityCorp);

		assertNotNull(marketWatcher.getQuote("UV"));
	}

	@Test
	public void when_ten_percent_gain_then_the_stock_is_sold() {
		when(portfolio.getAvgPrice(isA(Stock.class))).thenReturn(
				new BigDecimal("10.00"));

		Stock stock = new Stock("UV", "University Corporation", new BigDecimal(
				"11.20"));
		when(marketWatcher.getQuote(anyString())).thenReturn(stock);

		broker.perform(portfolio, stock);

		verify(portfolio, atMost(1)).sell(stock, 10);
	}

	@Test
	public void argument_matcher() {
		when(portfolio.getAvgPrice(isA(Stock.class))).thenReturn(
				new BigDecimal("10.00"));

		Stock blueStock = new Stock("FB", "University Corporation",
				new BigDecimal("100.00"));
		Stock otherStock = new Stock("XYZ", "Other Corporation",
				new BigDecimal("5.00"));
		
		when(marketWatcher.getQuote(argThat(new BlueStockMatcher()))).
			thenReturn(blueStock);
		when(marketWatcher.getQuote(argThat(new OtherStockMatcher()))).
			thenReturn(otherStock);
		
		broker.perform(portfolio, blueStock);
		verify(portfolio).sell(blueStock, 10);
		
		
		
	}

}

class BlueStockMatcher extends ArgumentMatcher<String>{

	@Override
	public boolean matches(Object argument) {
		return "FB".equals(argument);
	}
	
}


class OtherStockMatcher extends BlueStockMatcher{

	@Override
	public boolean matches(Object argument) {
		return !super.equals(argument);
	}
	
}
