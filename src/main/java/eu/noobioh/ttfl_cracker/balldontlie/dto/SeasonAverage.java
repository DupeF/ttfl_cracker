package eu.noobioh.ttfl_cracker.balldontlie.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class SeasonAverage {
	@JsonAlias("games_played")
	private Integer gamesPlayed;
	@JsonAlias("player_id")
	private Long playerId;
    private Integer season;
    private String min;
    private BigDecimal fgm;
    private BigDecimal fga;
    private BigDecimal fg3m;
    private BigDecimal fg3a;
    private BigDecimal ftm;
    private BigDecimal fta;
    private BigDecimal oreb;
    private BigDecimal dreb;
    private BigDecimal reb;
    private BigDecimal ast;
    private BigDecimal stl;
    private BigDecimal blk;
    private BigDecimal turnover;
    private BigDecimal pf;
    private BigDecimal pts;
	@JsonAlias("fg_pct")
    private BigDecimal fgPct;
	@JsonAlias("fg3_pct")
    private BigDecimal fg3Pct;
	@JsonAlias("ft_pct")
    private BigDecimal ftPct;
}
