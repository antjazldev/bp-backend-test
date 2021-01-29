package com.pichincha.backend.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class AccountDto {

	@SuppressWarnings("unused")
	private final String number;

	@SuppressWarnings("unused")
	private final String type;

	@SuppressWarnings("unused")
	private final LocalDateTime creationDate;

}
