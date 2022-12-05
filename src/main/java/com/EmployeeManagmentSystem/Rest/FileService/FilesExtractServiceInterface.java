package com.EmployeeManagmentSystem.Rest.FileService;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author krishnakumar
 *
 */
public interface FilesExtractServiceInterface {

	public void ExtractFile(MultipartFile file);

}
