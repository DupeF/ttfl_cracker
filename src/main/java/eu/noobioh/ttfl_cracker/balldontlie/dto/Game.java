package eu.noobioh.ttfl_cracker.balldontlie.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import eu.noobioh.ttfl_cracker.utils.MultiLocalDateTimeDeserializer;
import lombok.Data;

@Data
public class Game {
	private Long id;
	@JsonDeserialize(using = MultiLocalDateTimeDeserializer.class)
    private LocalDateTime date;
    @JsonAlias("home_team_score")
    private Integer homeTeamScore;
    @JsonAlias("visitor_team_score")
    private Integer visitorTeamSscore;
    private Integer season;
    private Integer period;
    private String status;
    private String time;
    private Boolean postseason;
    @JsonAlias("home_team")
    private Team homeTeam;
    @JsonAlias("visitor_team")
    private Team visitorTeam;
}
