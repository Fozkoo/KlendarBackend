package com.example.ccalendarbackend.Controllers;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attachment")
@Tag(
        name = "Attachment Controller",
        description="Handles operations related to attachments, such as retrieving all available attachments."
)
public class attachmentController {
}
