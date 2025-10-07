package com.taxi.Service;

import java.io.FileOutputStream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taxi.DTO.ServiceData;
import com.taxi.Entity.ServiceEntity;
import com.taxi.Repositary.ImageServiceCurd;

import jakarta.transaction.Transactional;
@Service
public class ImageServiceImpl implements ImageService {
	
    @Autowired
	private ModelMapper modelmapper;
    @Autowired
    private ImageServiceCurd imagedao;
	
	@Transactional(rollbackOn = Exception.class)
	@Override
	public Boolean uploadimageDatabase(ServiceData servicedata, MultipartFile multipartfile) {
		
		ServiceEntity serviceEntity= modelmapper.map(servicedata, ServiceEntity.class);
		
		try {
			
			ServiceEntity save = imagedao.save(serviceEntity);
			
			String path="E:\\springboot\\springe\\taxibooking\\src\\main\\resources\\static\\serviceImage\\"+multipartfile.getOriginalFilename();           
			byte[] imgbytes = multipartfile.getBytes();
			
			FileOutputStream fos= new FileOutputStream(path);
			fos.write(imgbytes);
			
			return true;
			
		}catch(Exception e){
		
			e.printStackTrace();
			return false;
		}
		 
	
		
		
		
	}

}
