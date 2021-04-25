package eu.noobioh.ttfl_cracker.balldontlie.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class PlayerShort {
	private Long id;
	@JsonAlias("first_name")
	private String firstName;
	@JsonAlias("last_name")
	private String lastName;
	private String position;
	@JsonAlias("team_id")
	private Long teamId;
}
