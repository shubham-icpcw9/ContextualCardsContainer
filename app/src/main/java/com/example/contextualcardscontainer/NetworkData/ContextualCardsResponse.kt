package com.example.contextualcardscontainer.NetworkData

import com.google.gson.annotations.SerializedName

data class ContextualCardsResponse(
    @SerializedName("card_groups") val card_groups: List<CardGroup>
)

data class CardGroup(
    @SerializedName("card_type") val card_type: Int,
    @SerializedName("cards") val cards: List<Card>,
    @SerializedName("design_type") val design_type: String,
    @SerializedName("height") val height: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("is_scrollable") val is_scrollable: Boolean,
    @SerializedName("level") val level: Int,
    @SerializedName("name") val name: String
)

data class Card(
    @SerializedName("bg_color") val bg_color: String,
    @SerializedName("bg_image") val bg_image: BgImage,
    @SerializedName("cta") val cta: List<Cta>,
    @SerializedName("description") val description: String,
    @SerializedName("formatted_description") val formatted_description: FormattedDescription,
    @SerializedName("formatted_title") val formatted_title: FormattedTitle,
    @SerializedName("icon") val icon: Icon,
    @SerializedName("is_disabled") val is_disabled: Boolean,
    @SerializedName("name") val name: String,
    @SerializedName("title") val title: String,
    @SerializedName("url") val url: String
)

data class BgImage(
    @SerializedName("aspect_ratio") val aspect_ratio: Double,
    @SerializedName("image_type") val image_type: String,
    @SerializedName("image_url") val image_url: String
)

data class Cta(
    @SerializedName("bg_color") val bg_color: String,
    @SerializedName("text") val text: String,
    @SerializedName("text_color") val text_color: String,
    @SerializedName("url") val url: String,
    @SerializedName("url_choice") val url_choice: String
)

data class FormattedDescription(
    @SerializedName("align") val align: String,
    @SerializedName("entities") val entities: List<Any>,
    @SerializedName("text") val text: String
)

data class FormattedTitle(
    @SerializedName("align") val align: String,
    @SerializedName("entities") val entities: List<Any>,
    @SerializedName("text") val text: String
)

data class Icon(
    @SerializedName("aspect_ratio") val aspect_ratio: Double,
    @SerializedName("image_type") val image_type: String,
    @SerializedName("image_url") val image_url: String
)