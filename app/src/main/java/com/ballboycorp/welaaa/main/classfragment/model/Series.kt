package com.ballboycorp.welaaa.main.classfragment.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.ballboycorp.welaaa.main.model.Image
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by musooff on 07/01/2019.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
class Series {
    @PrimaryKey
    @NonNull
    var category: String? = null
    @Ignore
    var item: List<Item> = arrayListOf()
    var title: String? = null
}

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
class Item() {
    @JsonProperty(value = "ccode")
    var catCode: String? = null
    var cid: String? = null
    var file_size: Int = 0
    var headline: String? = null
    var hit_count: Int = 0
    @PrimaryKey
    var id: Int = 0
    var image_url: String? = null
    @Embedded
    var images: Images? = null
    @Embedded
    var meta: Meta? = null
    @Embedded(prefix = "teacher_")
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
    @Embedded
    var images: Image?  = null
}