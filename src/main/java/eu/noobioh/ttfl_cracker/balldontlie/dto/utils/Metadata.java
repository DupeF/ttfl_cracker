package eu.noobioh.ttfl_cracker.balldontlie.dto.utils;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class Metadata {
	@JsonAlias("total_pages")
	private Integer totalPages;
	@JsonAlias("current_page")
	private Integer currentPage;
	@JsonAlias("next_page")
	private Integer nextPage;
	@JsonAlias("per_page")
	private Integer perPage;
	@JsonAlias("total_count")
	private Long totalCount;
}
