package com.ballboycorp.welaaa.main.classfragment.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by musooff on 07/01/2019.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
class Series {

    var category: String? = null
    var item: List<Item> = arrayListOf()
    var title: String? = null
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Item{

    @JsonProperty(value = "ccode")
    var catCode: String? = null
    var cid: String? = null
    var file_size: Int = 0
    var headline: String? = null
    var hit_count: Int = 0
    var id: Int = 0
    var image_url: String? = null
    var images: Images? = null
    var meta: Meta? = null
    var teacher: Teacher? = null
}
@JsonIgnoreProperties(ignoreUnknown = true)

class Images {
    var wide: String? = null
}
@JsonIgnoreProperties(ignoreUnknown = true)

class Meta {
    var play_count: Int = 0
    var view_count: Int = 0
}
@JsonIgnoreProperties(ignoreUnknown = true)

class Teacher {
    var headline: String? = null
}