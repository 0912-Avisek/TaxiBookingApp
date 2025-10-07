package com.taxi.Service;

import org.springframework.web.multipart.MultipartFile;

import com.taxi.DTO.ServiceData;

public interface ImageService {
    
	public Boolean uploadimageDatabase(ServiceData servicedata,MultipartFile multipartfile);
}
