package eu.noobioh.ttfl_cracker.balldontlie.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class Player {
	private Long id;
	@JsonAlias("first_name")
	private String firstName;
	@JsonAlias("last_name")
	private String lastName;
	private String position;
	@JsonAlias("height_feet")
	private Integer heightFeet;
	@JsonAlias("height_inches")
	private Integer heightInches;
	@JsonAlias("weight_pounds")
	private Integer weightPounds;
	private Team team;
}
