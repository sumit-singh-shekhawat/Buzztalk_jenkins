package com.cg.Buzztalk.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.Buzztalk.model.FileDb;



public interface FileDbRepository extends JpaRepository<FileDb, String>
{

	FileDb save(FileDb fdb);

	Optional<FileDb> findById(String id);

	FileDb findByFileId(String fileId);

	//FileDb delete();

}