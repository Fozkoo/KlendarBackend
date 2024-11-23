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

    @Operation(
        summary = "Retrieve all attachments",
        description = "This endpoint retrieves all attachments stored in the system.",
        method = "GET")
     @GetMapping("/getAllAttachments")
     public ResponseEntity<?> getAllAttachments() {
        return ResponseEntity.ok().build();
    }


    // Cuidado!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    @Operation(
        summary = "Delete all attachments by ID",
        description = "This endpoint deletes all attachments associated with a specific ID from the system.",
        method = "DELETE")
    @DeleteMapping("/deleteAllAttachmentsById")
    public ResponseEntity<?> deleteAllAttachmentsById() {
        return ResponseEntity.ok().build();
    }

    @Operation(
        summary = "Modify an attachment by its ID",
        description = "This endpoint allows modification of an attachment's information by its unique ID.",
        method = "PUT"
    )@PutMapping("/modifyAttachmentById")
    public ResponseEntity<?> modifyAttachmentById() {
        return ResponseEntity.ok().build();
    }


     */




}
