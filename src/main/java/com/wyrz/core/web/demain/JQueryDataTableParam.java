package com.wyrz.core.web.demain;

/**
 * JQuery.dataTable 插件属性
 */
public class JQueryDataTableParam {

	// Request sequence number sent by DataTable, same value must be returned in response
	private String sEcho;

	// Text used for filtering
	private String sSearch;

	// Number of records that should be shown in table
	private int iDisplayLength;

	// First record that should be shown(used for paging)
	private int iDisplayStart;

	// Number of columns in table
	private int iColumns;

	// Number of columns that are used in sorting
	private int iSortingCols;

	// Index of the column that is used for sorting
	private int iSortColumnIndex;

	// Sorting direction "asc" or "desc"
	private String sSortDirection;

	// Comma separated list of column names
	private String sColumns;

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public String getsSearch() {
		return sSearch;
	}

	public void setsSearch(String sSearch) {
		this.sSearch = sSearch;
	}

	public int getiDisplayLength() {
		return iDisplayLength;
	}

	public void setiDisplayLength(int iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}

	public int getiDisplayStart() {
		return iDisplayStart;
	}

	public void setiDisplayStart(int iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}

	public int getiColumns() {
		return iColumns;
	}

	public void setiColumns(int iColumns) {
		this.iColumns = iColumns;
	}

	public int getiSortingCols() {
		return iSortingCols;
	}

	public void setiSortingCols(int iSortingCols) {
		this.iSortingCols = iSortingCols;
	}

	public int getiSortColumnIndex() {
		return iSortColumnIndex;
	}

	public void setiSortColumnIndex(int iSortColumnIndex) {
		this.iSortColumnIndex = iSortColumnIndex;
	}

	public String getsSortDirection() {
		return sSortDirection;
	}

	public void setsSortDirection(String sSortDirection) {
		this.sSortDirection = sSortDirection;
	}

	public String getsColumns() {
		return sColumns;
	}

	public void setsColumns(String sColumns) {
		this.sColumns = sColumns;
	}
}
