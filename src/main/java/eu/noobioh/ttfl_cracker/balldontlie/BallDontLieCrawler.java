package eu.noobioh.ttfl_cracker.balldontlie;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.client.WebClient;

import eu.noobioh.ttfl_cracker.balldontlie.dto.Game;
import eu.noobioh.ttfl_cracker.balldontlie.dto.GameParams;
import eu.noobioh.ttfl_cracker.balldontlie.dto.Player;
import eu.noobioh.ttfl_cracker.balldontlie.dto.Team;
import eu.noobioh.ttfl_cracker.balldontlie.dto.utils.DataPageWrapper;
import reactor.core.publisher.Mono;

@Component
public class BallDontLieCrawler {
	
	private static final String BASE_API_URL = "https://www.balldontlie.io/api/v1";
	private static final int MAX_PER_PAGE = 100;
	
	private final WebClient webClient = WebClient.create(BASE_API_URL);
	
	public DataPageWrapper<Player> getPlayers(int pageNumber) {
		return this.getPlayers(pageNumber, MAX_PER_PAGE, null);
	}
	
	public DataPageWrapper<Player> getPlayers(int pageNumber, String nameFilter) {
		return this.getPlayers(pageNumber, MAX_PER_PAGE, nameFilter);
	}
	
	private DataPageWrapper<Player> getPlayers(int pageNumber, int elementsPerPage, String nameFilter) {
		Mono<DataPageWrapper<Player>> request = webClient.get()
				.uri(uriBuilder -> {
					uriBuilder.path("/players")
						.queryParam("page", pageNumber)
						.queryParam("per_page", elementsPerPage);
					if (StringUtils.hasText(nameFilter)) {
						uriBuilder.queryParam("search", nameFilter);
					}
					return uriBuilder.build();
				})
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<DataPageWrapper<Player>>(){});
		DataPageWrapper<Player> body = request.block();
		return body;
	}
	
	public Player getPlayer(int id) {
		Mono<Player> request = webClient.get()
				.uri("/players/" + id)
				.retrieve()
				.bodyToMono(Player.class);
		Player player = request.block();
		return player;
	}
	
	public DataPageWrapper<Team> getTeams(int pageNumber) {
		return this.getTeams(pageNumber, MAX_PER_PAGE);
	}
	
	private DataPageWrapper<Team> getTeams(int pageNumber, int elementsPerPage) {
		Mono<DataPageWrapper<Team>> request = webClient.get()
				.uri(uriBuilder -> {
					uriBuilder.path("/teams")
						.queryParam("page", pageNumber)
						.queryParam("per_page", elementsPerPage);
					return uriBuilder.build();
				})
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<DataPageWrapper<Team>>(){});
		DataPageWrapper<Team> body = request.block();
		return body;
	}
	
	public Team getTeam(int id) {
		Mono<Team> request = webClient.get()
				.uri("/teams/" + id)
				.retrieve()
				.bodyToMono(Team.class);
		Team team = request.block();
		return team;
	}
	
	public DataPageWrapper<Game> getGames(int pageNumber) {
		return this.getGames(pageNumber, MAX_PER_PAGE, null);
	}
	
	public DataPageWrapper<Game> getGames(int pageNumber, GameParams params) {
		return this.getGames(pageNumber, MAX_PER_PAGE, params);
	}
	
	private DataPageWrapper<Game> getGames(int pageNumber, int elementsPerPage, GameParams params) {
		Mono<DataPageWrapper<Game>> request = webClient.get()
				.uri(uriBuilder -> {
					uriBuilder.path("/games")
						.queryParam("page", pageNumber)
						.queryParam("per_page", elementsPerPage);
					if (params != null) {
						if (!CollectionUtils.isEmpty(params.getDates())) {
							uriBuilder.queryParam("dates[]", params.getDates());
						}
						if (!CollectionUtils.isEmpty(params.getSeasons())) {
							uriBuilder.queryParam("seasons[]", params.getSeasons());
						}
						if (!CollectionUtils.isEmpty(params.getTeamIds())) {
							uriBuilder.queryParam("team_ids[]", params.getTeamIds());
						}
						if (params.getPostseason() != null) {
							uriBuilder.queryParam("postseason", params.getPostseason());
						}
						if (params.getStartDate() != null) {
							uriBuilder.queryParam("start_date", params.getStartDate());
						}
						if (params.getEndDate() != null) {
							uriBuilder.queryParam("end_date", params.getEndDate());
						}
					}
					return uriBuilder.build();
				})
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<DataPageWrapper<Game>>(){});
		DataPageWrapper<Game> body = request.block();
		return body;
	}
	
	public Game getGame(int id) {
		Mono<Game> request = webClient.get()
				.uri("/games/" + id)
				.retrieve()
				.bodyToMono(Game.class);
		Game game = request.block();
		return game;
	}

}
