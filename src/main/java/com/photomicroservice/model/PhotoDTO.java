package com.photomicroservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by dani on 2017-02-24.
 */
public class PhotoDTO {
    private long id;
    private byte[] imgByte;
    private long adId;

    @JsonCreator
    public PhotoDTO(@JsonProperty("id")long id,@JsonProperty("byte") byte[] imgByte,@JsonProperty("adId") long adId) {
        this.id = id;
        this.imgByte = imgByte;
        this.adId = adId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getImgByte() {
        return imgByte;
    }

    public long getAdId() {
        return adId;
    }


}
