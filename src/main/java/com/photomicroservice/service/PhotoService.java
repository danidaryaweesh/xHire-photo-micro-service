package com.photomicroservice.service;

import com.photomicroservice.domain.Photo;

import java.util.List;

/**
 * Created by dani on 2017-02-24.
 */
public interface PhotoService {
    Photo findPhotoById(long id);
    List<Photo> getPhotosByAdId(long adId);
    Photo addPhoto(Photo newPhoto);
}