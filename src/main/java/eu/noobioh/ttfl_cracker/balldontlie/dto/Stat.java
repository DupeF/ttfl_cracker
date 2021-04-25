package eu.noobioh.ttfl_cracker.balldontlie.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class Stat {
	private Long id;
	private Integer ast;
	private Integer blk;
	private Integer dreb;
	@JsonAlias("fg3_pct")
	private BigDecimal fg3Pct;
	private Integer fg3a;
	private Integer fg3m;
	@JsonAlias("fg_pct")
	private BigDecimal fgPct;
	private Integer fga;
	private Integer fgm;
	@JsonAlias("ft_pct")
	private BigDecimal ftPct;
	private Integer fta;
	private Integer ftm;
    private GameShort game;
    private String min;
    private Integer oreb;
    private Integer pf;
    private PlayerShort player;
    private Integer pts;
    private Integer reb;
    private Integer stl;
    private Team team;
    private Integer turnover;
}
