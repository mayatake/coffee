package com.example.web;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class OrderForm {
	@NotNull
	@Size(min=1, max = 127)
	private String firstName;
	@NotNull
	//@Size(min = 1, max = 127)
	@Max(5)
	@Min(1)
	private int volume;
}
