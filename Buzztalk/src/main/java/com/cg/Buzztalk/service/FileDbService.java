package com.cg.Buzztalk.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cg.Buzztalk.model.FileDb;
import com.cg.Buzztalk.repository.FileDbRepository;



@Service
public class FileDbService
{
	@Autowired
	private FileDbRepository fdr;
	
	public FileDb store(MultipartFile file) throws IOException
	{
		String filename = file.getOriginalFilename();
		FileDb fdb = new FileDb(UUID.randomUUID().toString(),null, null, filename,file.getContentType(),file.getBytes());
		return fdr.save(fdb);
	}
	 public FileDb getfileById(String id)
	 {
		
		 Optional<FileDb> fileOptional= fdr.findById(id);
		 
		 if(fileOptional.isPresent())
		 {
			 return fileOptional.get();
		 }
		 return null;
	 }
	 public List<FileDb> getFileList()
	 {
		 return fdr.findAll();
	 }
	
	 
	public void delete(String id) 
	{
		fdr.deleteById(id);
		//System.out.println("File deleted successfully...");
		
	}
	public void deleteAll() 
	{
		fdr.deleteAll();
		//System.out.println(" All File deleted successfully...");
	}
	

}
