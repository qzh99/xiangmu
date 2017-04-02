package com.yc.qas.entity;

import java.util.List;

public class EUDataGridList<T> {
		private int total;
		private List<T> rows;
		
		public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}
		public List<T> getRows() {
			return rows;
		}
		public void setRows(List<T> rows) {
			this.rows = rows;
		}
		@Override
		public String toString() {
			return "EUDataGridList [total=" + total + ", rows=" + rows + "]";
		}
		
		
}
