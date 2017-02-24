package com.photomicroservice.service.Impl;

import com.photomicroservice.domain.Photo;
import com.photomicroservice.repository.PhotoCustomRepository;
import com.photomicroservice.repository.PhotoRepository;
import com.photomicroservice.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dani on 2017-02-24.
 */
@Transactional
@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoService photoService;

    @Autowired
    private PhotoCustomRepository photoCustomRepository;

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public Photo findPhotoById(long id) {
        return photoService.findPhotoById(id);
    }

    @Override
    public List<Photo> getPhotosByAdId(long adId) {
        return photoCustomRepository.getPhotosByAdId(adId);
    }
    //ska hämta alla bilder efter annons id. Se TransactionRepositoryImpl under repositories/impl mappen för att göra egna querys.


    @Override
    public Photo addPhoto(Photo newPhoto) {
        if(newPhoto != null){
            return photoRepository.save(newPhoto);
        }
        return null;
    }
}
