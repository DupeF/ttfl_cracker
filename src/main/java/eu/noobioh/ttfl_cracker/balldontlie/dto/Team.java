package eu.noobioh.ttfl_cracker.balldontlie.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class Team {
	private Long id;
	private String abbreviation;
	private String city;
	private String conference;
	private String division;
	@JsonAlias("full_name")
	private String fullName;
	private String name;
}
