package com.photomicroservice.controller;

import com.photomicroservice.domain.Photo;
import com.photomicroservice.model.PhotoDTO;
import com.photomicroservice.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dani on 2017-02-24.
 */
@RestController
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    //photoDTO:n should have ad_id.
    @RequestMapping(value = "/addphoto", method = RequestMethod.POST, consumes={"application/json"})
    public ResponseEntity<PhotoDTO> addPhoto(@RequestBody PhotoDTO photo)
    {

        Photo realPhoto = new Photo();
        realPhoto.setPhotobyte(photo.getImgByte());
        realPhoto.setAdId(photo.getAdId());

        realPhoto = photoService.addPhoto(realPhoto);

        if(realPhoto != null){
          PhotoDTO photoDTO = toPhotoDTO(realPhoto);
          return new ResponseEntity<>(photoDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(photo, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/getadphotos/{adId}", method = RequestMethod.GET)
    public ResponseEntity<List<PhotoDTO>> getImgsOfAd(@PathVariable int adId)
    {
        List<PhotoDTO> resultList = convertToPhotoDTOList(photoService.getPhotosByAdId(adId));
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    private List<PhotoDTO> convertToPhotoDTOList(List<Photo> photoList)
    {
        ArrayList<PhotoDTO> resultList = new ArrayList<>();
        for(Photo photo : photoList)
        {
            resultList.add(toPhotoDTO(photo));
        }
        return resultList;
    }

    private PhotoDTO toPhotoDTO(Photo photo)
    {
        return new PhotoDTO(photo.getId(), photo.getPhotobyte(), photo.getAdId());
    }
}
