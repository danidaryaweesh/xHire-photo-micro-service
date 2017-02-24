package com.photomicroservice.repository;

import com.photomicroservice.domain.Photo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dani on 2017-02-24.
 */
@Repository
public interface PhotoCustomRepository {
    List<Photo> getPhotosByAdId(long adId);
}

