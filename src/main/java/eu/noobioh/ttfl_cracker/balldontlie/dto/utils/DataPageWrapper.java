package eu.noobioh.ttfl_cracker.balldontlie.dto.utils;

import java.util.List;

import lombok.Data;

@Data
public class DataPageWrapper<T> {
	private List<T> data;
	private Metadata meta;
}
