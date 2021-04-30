package com.example.android.thescores.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

data class TeamResponse(

	@Json(name="teams")
	val teams: List<TeamsItem>,

	@Json(name="count")
	val count: Int? = null,

	@Json(name="season")
	val season: Season? = null,

	@Json(name="competition")
	val competition: Competition? = null,

	@Json(name="filters")
	val filters: TeamFilters? = null
)

data class Competition(

	@Json(name="area")
	val area: Area? = null,

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

@Parcelize
data class TeamArea(

	@Json(name="name")
	val name: String? = null,

	@Json(name="id")
	val id: Int? = null
) : Parcelable

@Parcelize
data class TeamsItem(

	@Json(name="area")
	val area: TeamArea? = null,

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

	@Json(name="phone")
	val phone: String? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="shortName")
	val shortName: String? = null,

	@Json(name="email")
	val email: String? = null
) : Parcelable

data class Season(

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

data class TeamFilters(
	val any: Any? = null
)
