package eu.noobioh.ttfl_cracker.balldontlie.dto.utils;

import java.util.List;

import lombok.Data;

@Data
public class DataWrapper<T> {
	private List<T> data;
}
