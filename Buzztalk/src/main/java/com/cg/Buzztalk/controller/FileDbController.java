
package com.cg.Buzztalk.controller;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cg.Buzztalk.model.FileDb;
import com.cg.Buzztalk.repository.UserDao;
import com.cg.Buzztalk.service.FileDbService;


@RestController
@CrossOrigin("http://localhost:4201")
@RequestMapping("/file")
public class FileDbController 
{
	@Autowired
	private FileDbService fds;
	
	@Autowired
	private UserDao userDao;

  //@CrossOrigin("/http://localhost:4200")
  @CrossOrigin("http://localhost:4201")
  @PostMapping
  public FileDb uploadFile(@RequestParam("file") MultipartFile file) throws IOException
  {
	  //User user = regRepository.findUserById(id);
      //user.setId(file.getOriginalFilename());
	 return fds.store(file);
  }
  //@CrossOrigin("/http://localhost:4200")
  @GetMapping("/{id}")
  public FileDb getFile(@PathVariable String id)
  {
	  return fds.getfileById(id);
  }
  @GetMapping("/list")
  public List<FileDb> getFileList()
  {
	  return fds.getFileList();
	
  }
  //@CrossOrigin("/http://localhost:4200")
  @DeleteMapping("/delete/{id}")
   public void deleteFile(@PathVariable("id") String id)
   {
	   fds.delete(id);
	   System.out.println("File deleted successfully...");
	  
   }
  
   //@CrossOrigin("/http://localhost:4200")
   @DeleteMapping("/deleteAll")
   public void deleteAllFile()
   {
	   fds.deleteAll();
	   System.out.println(" All File deleted successfully...");
   }
}
   
