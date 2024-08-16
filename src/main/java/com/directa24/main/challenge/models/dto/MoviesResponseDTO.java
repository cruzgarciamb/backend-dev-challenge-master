package com.directa24.main.challenge.models.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MoviesResponseDTO {

	private int page;
	@JsonProperty("per_page")
	private int perPage;
	private int total;
	@JsonProperty("total_pages")
	private int totalPages;
	private List<MovieDTO> data;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<MovieDTO> getData() {
		return data;
	}
	public void setData(List<MovieDTO> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "MoviesResponseDTO [page=" + page + ", perPage=" + perPage + ", total=" + total + ", totalPages="
				+ totalPages + ", data=" + data.size() + "]";
	}

}
