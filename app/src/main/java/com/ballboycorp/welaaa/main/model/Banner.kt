package com.ballboycorp.welaaa.main.model

import androidx.room.*
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by musooff on 06/01/2019.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
class Banner {
    @PrimaryKey
    var id: Int = 0
    var align: Int = 0
    @Embedded
    var images: Image?  = null
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Image {
    @JsonProperty(value = "default")
    var defaultUrl: String? = null
}