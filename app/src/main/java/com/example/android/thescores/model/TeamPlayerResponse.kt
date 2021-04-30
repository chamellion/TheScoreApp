package com.example.android.thescores.model

import com.squareup.moshi.Json

data class TeamPlayerResponse(

	@Json(name="area")
	val area: Area? = null,

	@Json(name="venue")
	val venue: String? = null,

	@Json(name="website")
	val website: String? = null,

	@Json(name="address")
	val address: String? = null,

	@Json(name="crestUrl")
	val crestUrl: String? = null,

	@Json(name="tla")
	val tla: String? = null,

	@Json(name="founded")
	val founded: Int? = null,

	@Json(name="lastUpdated")
	val lastUpdated: String? = null,

	@Json(name="clubColors")
	val clubColors: String? = null,

	@Json(name="squad")
	val squad: List<SquadItem>,

	@Json(name="phone")
	val phone: String? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="activeCompetitions")
	val activeCompetitions: List<ActiveCompetitionsItem?>? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="shortName")
	val shortName: String? = null,

	@Json(name="email")
	val email: String? = null
)

data class ActiveCompetitionsItem(

	@Json(name="area")
	val area: TeamPlayerArea? = null,

	@Json(name="lastUpdated")
	val lastUpdated: String? = null,

	@Json(name="code")
	val code: String? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="plan")
	val plan: String? = null
)

data class TeamPlayerArea(

	@Json(name="name")
	val name: String? = null,

	@Json(name="id")
	val id: Int? = null
)

data class SquadItem(

	@Json(name="role")
	val role: String? = null,

	@Json(name="nationality")
	val nationality: String? = null,

	@Json(name="countryOfBirth")
	val countryOfBirth: String? = null,

	@Json(name="shirtNumber")
	val shirtNumber: Any? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="dateOfBirth")
	val dateOfBirth: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="position")
	val position: String? = null
)
