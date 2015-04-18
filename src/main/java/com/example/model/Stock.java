package com.example.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Stock implements Serializable {
		 
	private static final long serialVersionUID = -3909239724692228913L;
		private Integer stockId;
		private String stockCode;
		private String stockName;
		private Set<StockDailyRecord> stockDailyRecords = 
					new HashSet<StockDailyRecord>(0);
		
		public Stock() {
			super();
		}
		
		public Stock(String stockCode, String stockName) {
			super();
			this.stockCode = stockCode;
			this.stockName = stockName;
		}
		public Integer getStockId() {
			return stockId;
		}
		public void setStockId(Integer stockId) {
			this.stockId = stockId;
		}
		public String getStockCode() {
			return stockCode;
		}
		public void setStockCode(String stockCode) {
			this.stockCode = stockCode;
		}
		public String getStockName() {
			return stockName;
		}
		public void setStockName(String stockName) {
			this.stockName = stockName;
		}
		public Set<StockDailyRecord> getStockDailyRecords() {
			return stockDailyRecords;
		}
		public void setStockDailyRecords(Set<StockDailyRecord> stockDailyRecords) {
			this.stockDailyRecords = stockDailyRecords;
		}

		@Override
		public String toString() {
			return "Stock [stockId=" + stockId + ", stockCode=" + stockCode
					+ ", stockName=" + stockName + ", stockDailyRecords="
					+ stockDailyRecords + "]";
		}
}

