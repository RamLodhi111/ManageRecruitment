/**
 * 
 */
package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.models.CandidatureDetails;
import com.app.models.EmployeeDetails;
import com.app.repositories.CandidatureDetailsRepository;
import com.app.services.CandidatureDetailsService;
import com.app.services.EmployeeDetailsService;
import com.app.services.ParseExcelFileService;

/**
 * @author Rajasekar.Murugesan
 *
 */
@CrossOrigin("*")
@RestController
public class UploadFileController {
	
	@Autowired
	private ParseExcelFileService parseExcelFileService;
	
	@Autowired
	private EmployeeDetailsService employeeDetailsService;
	
	@Autowired
	private CandidatureDetailsService candidatureDetailsService;
	
	 /*
     * MultipartFile Upload
     */
    @PostMapping("/api/file/upload")
    public String uploadMultipartFile(@RequestParam("file") MultipartFile file) {
    	try {
    		
    		List<EmployeeDetails> empList = parseExcelFileService.readFile(file);
    		employeeDetailsService.updateListOfEmployeeDetails(empList);
    		List<CandidatureDetails> candidateList = parseExcelFileService.readExcelFile(file);
    		candidatureDetailsService.updateListOfCandidatureDetails(candidateList);
    		
    		// save file to PostgreSQL
	    	//FileModel filemode = new FileModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
	    	//fileRepository.save(filemode);
	    	return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
		} catch (	Exception e) {
			return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
		}    
    }

}
