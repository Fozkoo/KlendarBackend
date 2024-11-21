package com.example.ccalendarbackend.Controllers;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attachment")
@Tag(
        name = "Attachment Controller",
        description="Handles operations related to attachments, such as retrieving all available attachments."
)
public class attachmentController {

    /*
    public ResponseEntity<?> getAllAttachments() {
        return ResponseEntity.ok().build();
    }


    // Cuidado!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public ResponseEntity<?> deleteAllAttachmentsById() {
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> modifyAttachmentById() {
        return ResponseEntity.ok().build();
    }


     */




}
