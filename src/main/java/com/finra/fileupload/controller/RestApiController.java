package com.finra.fileupload.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.finra.fileupload.model.FileData;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	//Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "C://Files//STS//Uploads//";

	@RequestMapping(value="/filedata/", method=RequestMethod.POST)
    public ResponseEntity<?> singleFileUpload(@RequestBody FileData data) {
		logger.info("<<<Inside ss file data is -->>>" + data);
        if (data == null) {
            //redirectAttributes.addFlashAttribute("message", "Please send file data to save");
            return new ResponseEntity<String>(
            		"File not found", HttpStatus.NOT_FOUND);
        }

        try {

            // Get the file info and save it somewhere
        	
        	logger.info(data.toString());
        	
            byte[] bytes = data.toString().getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + data.getFileName() + ".txt");
            Files.write(path, bytes);
            logger.info("File information saved...");


        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(
            		"File not saved.. ", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<String>(" Successfully saved " + 
        		data.toString(), HttpStatus.CREATED);
    }
	
	@RequestMapping(value="/fileupload/", method=RequestMethod.POST)
    public ResponseEntity<?> singleFileUpload(@RequestBody MultipartFile file) {
		logger.info("Received file = " + file);
        if (file == null || file.isEmpty()) {
            //redirectAttributes.addFlashAttribute("message", "Please send a file to upload");
            return new ResponseEntity<String>(
            		"File not found", HttpStatus.NOT_FOUND);
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);


        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(
            		"File not saved.. ", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<String>(" Successfully uploaded " + 
        		file.getOriginalFilename(), HttpStatus.CREATED);
    }
}