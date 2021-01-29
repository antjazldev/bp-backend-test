package com.pichincha.backend.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class TransactionDto {
	private Long id;

	private String comment;

	private String type;

	private LocalDateTime creationDate;

}
