package com.salman.freecoffeeapijetpackcompose.domain.model

data class GetCoffeeResponse(
	val image: String? = null,
	val description: String? = null,
	val ingredients: List<String?>? = null,
	val id: Int? = null,
	val title: String? = null
)

