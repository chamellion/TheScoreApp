package com.example.android.thescores.model

import com.squareup.moshi.Json

data class CompetitionResponse(

	@Json(name="count")
	val count: Int? = null,

	@Json(name="competitions")
	val competitions: List<CompetitionsItem>,

	@Json(name="filters")
	val filters: Filters? = null
)

data class Winner(

	@Json(name="crestUrl")
	val crestUrl: String? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="tla")
	val tla: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="shortName")
	val shortName: String? = null
)

data class CompetitionsItem(

	@Json(name="area")
	val area: Area? = null,

	@Json(name="lastUpdated")
	val lastUpdated: String? = null,

	@Json(name="emblemUrl")
	val emblemUrl: String? = null,

	@Json(name="currentSeason")
	val currentSeason: CurrentSeason? = null,

	@Json(name="name")
	val name: String,

	@Json(name="id")
	val id: Int,

	@Json(name="numberOfAvailableSeasons")
	val numberOfAvailableSeasons: Int? = null,

	@Json(name="plan")
	val plan: String? = null
)

data class Area(

	@Json(name="countryCode")
	val countryCode: String? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="id")
	val id: Int? = null
)

data class Filters(
	val any: Any? = null
)

data class CurrentSeason(

	@Json(name="winner")
	val winner: Any? = null,

	@Json(name="currentMatchday")
	val currentMatchday: Int? = null,

	@Json(name="endDate")
	val endDate: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="startDate")
	val startDate: String? = null
)
