package com.example.coursework4.controller;

import com.example.coursework4.model.ImgDirModel;
import com.example.coursework4.storage.StorageFileNotFoundException;
import com.example.coursework4.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/img")
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }


    @GetMapping("/list")
    @ResponseBody
    public List<ImgDirModel> listUploadedFiles(@RequestParam(name = "dir-path") String dirPath ) throws IOException {

        return storageService.loadAll(dirPath).map(
                        path -> new ImgDirModel(MvcUriComponentsBuilder
                                .fromMethodName(FileUploadController.class,
                                "serveFile",
                                        path.toString()).build().toUri().toString()))
                .collect(Collectors.toList());

    }

    @GetMapping()
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@RequestParam(name = "path") String filePath) {

        Resource file = storageService.loadAsResource(filePath);

        String contentType = null;
        try {
            contentType = Files.probeContentType(Path.of(file.getFile().getAbsolutePath()));
        } catch (IOException ex) {
            contentType = "application/octet-stream";
        }


        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

//	@PostMapping("/")
//	public String handleFileUpload(@RequestParam("file") MultipartFile file,
//			RedirectAttributes redirectAttributes) {
//
//		storageService.store(file);
//		redirectAttributes.addFlashAttribute("message",
//				"You successfully uploaded " + file.getOriginalFilename() + "!");
//
//		return "redirect:/";
//	}

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
