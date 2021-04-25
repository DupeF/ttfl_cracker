package eu.noobioh.ttfl_cracker.balldontlie.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatParams {
	private final List<LocalDate> dates;
	private final List<Integer> seasons;
	private final List<Integer> playerIds;
	private final List<Integer> gameIds;
	private final Boolean postseason;
	private final LocalDate startDate;
	private final LocalDate endDate;
}
