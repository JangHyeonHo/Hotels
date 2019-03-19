package com.hotels.peregrine.command;

public class PageAndQueryCommand {
	
	private String searchSet;
	private String query;
	private int page;
	
	public String getSearchSet() {
		return searchSet;
	}
	public PageAndQueryCommand setSearchSet(String searchSet) {
		this.searchSet = searchSet;
		return this;
	}
	public String getQuery() {
		return query;
	}
	public PageAndQueryCommand setQuery(String query) {
		this.query = query;
		return this;
	}
	public int getPage() {
		return page;
	}
	public PageAndQueryCommand setPage(int page) {
		this.page = page;
		return this;
	}
}
