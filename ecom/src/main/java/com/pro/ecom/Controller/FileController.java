package com.pro.ecom.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pro.ecom.Model.Product;
import com.pro.ecom.Repo.ProductRepo;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/file")


public class FileController {
	@Autowired
	private Environment env;
	private final String uploadsLocation = "D:\\e-com-backend\\ecom\\src\\main\\resources\\uploads\\";
	@Autowired
    private ResourceLoader resourceLoader;


    
	
	@Autowired
	private ProductRepo productRepo;
	

	    @PostMapping("/upload")
	    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadedFile) {
	        if (uploadedFile.isEmpty()) {
	            return new ResponseEntity<>("Please select a file!", HttpStatus.BAD_REQUEST);
	        }
	        try {
	            byte[] bytes = uploadedFile.getBytes();
	            String uploadsLocation = "D:\\e-com-backend\\ecom\\src\\main\\resources\\uploads\\";
	            String fileLocation = uploadsLocation + UUID.randomUUID() + uploadedFile.getOriginalFilename();
	            Path path = Paths.get(fileLocation);
	            Files.write(path, bytes);

	            File file = new File(fileLocation);
	            return ResponseEntity.status(HttpStatus.OK).body(file.getName());
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	        }
	    }

		@PostMapping("/addfile")
    public ResponseEntity<?> addFile(@RequestBody Product product){
        System.out.println("===Product Details=="+product.getName());
       Product savedEntity = productRepo.saveAndFlush(product);

        
        
        return ResponseEntity.status(HttpStatus.OK)
                .body(savedEntity);
        
    }
		
		@GetMapping("/upload/{imageName:.+}")
	    public ResponseEntity<byte[]> serveFile(@PathVariable String imageName) {
	        try {
	            Path imagePath = Paths.get(uploadsLocation, imageName);
	            if (Files.exists(imagePath) && Files.isReadable(imagePath)) {
	                byte[] imageBytes = Files.readAllBytes(imagePath);
	                return ResponseEntity.ok()
	                        .contentType(MediaType.IMAGE_JPEG) // Assuming JPEG images
	                        .body(imageBytes);
	            } else {
	                return ResponseEntity.notFound().build();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
}
