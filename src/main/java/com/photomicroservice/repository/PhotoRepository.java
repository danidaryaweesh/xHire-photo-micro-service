package com.photomicroservice.repository;

import com.photomicroservice.domain.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dani on 2017-02-24.
 */
@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
    Photo findById(long id);
}