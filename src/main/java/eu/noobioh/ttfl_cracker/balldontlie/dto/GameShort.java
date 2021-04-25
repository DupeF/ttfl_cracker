package eu.noobioh.ttfl_cracker.balldontlie.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import eu.noobioh.ttfl_cracker.utils.MultiLocalDateTimeDeserializer;
import lombok.Data;

@Data
public class GameShort {
	private Long id;
	@JsonDeserialize(using = MultiLocalDateTimeDeserializer.class)
    private LocalDateTime date;
    @JsonAlias("home_team_id")
    private Long homeTeamId;
    @JsonAlias("home_team_score")
    private Integer homeTeamScore;
    @JsonAlias("visitor_team_id")
    private Long visitorTeamId;
    @JsonAlias("visitor_team_score")
    private Integer visitorTeamScore;
    private Integer season;
}