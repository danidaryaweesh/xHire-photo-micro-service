package com.photomicroservice.domain;

import javax.persistence.*;

/**
 * Created by dani on 2017-02-24.
 */
@Entity(name = "Photo")
@Table(name = "photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Lob()
    private byte[] photobyte;

    private long adId;

    public Photo(){}

    public Photo(long id,byte[] photobyte, long adId) {
        this.photobyte = photobyte;
        this.adId = adId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getPhotobyte() {
        return photobyte;
    }

    public void setPhotobyte(byte[] photobyte) {
        this.photobyte = photobyte;
    }

    public long getAdId() {
        return adId;
    }

    public void setAdId(long adId){ this.adId = adId; }
}
