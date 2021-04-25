package eu.noobioh.ttfl_cracker.web.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.noobioh.ttfl_cracker.balldontlie.BallDontLieCrawler;
import eu.noobioh.ttfl_cracker.balldontlie.dto.Game;
import eu.noobioh.ttfl_cracker.balldontlie.dto.GameParams;
import eu.noobioh.ttfl_cracker.balldontlie.dto.Player;
import eu.noobioh.ttfl_cracker.balldontlie.dto.Stat;
import eu.noobioh.ttfl_cracker.balldontlie.dto.StatParams;
import eu.noobioh.ttfl_cracker.balldontlie.dto.Team;
import eu.noobioh.ttfl_cracker.balldontlie.dto.utils.DataPageWrapper;

@RestController
@RequestMapping("/api/v1/test")
public class TestResource {
	
	@Autowired
	private BallDontLieCrawler ballDontLieCrawler;

	@GetMapping("/players")
	public DataPageWrapper<Player> getPlayers(
			@RequestParam Integer page,
			@RequestParam(required = false) String filter) {
		return ballDontLieCrawler.getPlayers(page, filter);
	}

	@GetMapping("/player/{id}")
	public Player getPlayer(@PathVariable int id) {
		return ballDontLieCrawler.getPlayer(id);
	}

	@GetMapping("/teams")
	public DataPageWrapper<Team> getTeams(
			@RequestParam Integer page) {
		return ballDontLieCrawler.getTeams(page);
	}

	@GetMapping("/team/{id}")
	public Team getTeam(@PathVariable int id) {
		return ballDontLieCrawler.getTeam(id);
	}

	@GetMapping("/games")
	public DataPageWrapper<Game> getGames(
			@RequestParam Integer page,
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			@RequestParam(required = false) List<LocalDate> dates,
			@RequestParam(required = false) List<Integer> seasons,
			@RequestParam(required = false) List<Integer> teamIds,
			@RequestParam(required = false) Boolean postseason,
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			@RequestParam(required = false) LocalDate startDate,
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			@RequestParam(required = false) LocalDate endDate) {
		GameParams params = GameParams.builder()
				.dates(dates)
				.seasons(seasons)
				.teamIds(teamIds)
				.postseason(postseason)
				.startDate(startDate)
				.endDate(endDate)
				.build();
		return ballDontLieCrawler.getGames(page, params);
	}

	@GetMapping("/game/{id}")
	public Game getGame(@PathVariable int id) {
		return ballDontLieCrawler.getGame(id);
	}

	@GetMapping("/stats")
	public DataPageWrapper<Stat> getStats(
			@RequestParam Integer page,
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			@RequestParam(required = false) List<LocalDate> dates,
			@RequestParam(required = false) List<Integer> seasons,
			@RequestParam(required = false) List<Integer> playerIds,
			@RequestParam(required = false) List<Integer> gameIds,
			@RequestParam(required = false) Boolean postseason,
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			@RequestParam(required = false) LocalDate startDate,
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			@RequestParam(required = false) LocalDate endDate) {
		StatParams params = StatParams.builder()
				.dates(dates)
				.seasons(seasons)
				.playerIds(playerIds)
				.gameIds(gameIds)
				.postseason(postseason)
				.startDate(startDate)
				.endDate(endDate)
				.build();
		return ballDontLieCrawler.getStats(page, params);
	}
}
