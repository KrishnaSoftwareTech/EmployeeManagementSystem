package com.EmployeeManagmentSystem.Rest.FileService;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import com.EmployeeManagmentSystem.Rest.Model.AdharInformation;
import com.EmployeeManagmentSystem.Rest.Model.StoreAdharByteData;

/**
 * @author krishnakumar
 *
 */
public interface FilesExtractServiceInterface {

	public AdharInformation ExtractFile(Long sapId, MultipartFile file);

	public StoreAdharByteData getByteData(Long sapId);

}
