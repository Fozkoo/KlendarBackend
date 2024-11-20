package com.example.ccalendarbackend.Config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Klendar",
                description = "Klendar is a modern calendar and scheduling app designed for both personal and professional use. It includes event management and reminder management.",
                contact = @Contact(
                        name = "Agustin Staats, Ariel Romero, Ivan Rodriguez, Joaquin Rodriguez, Tiziano Martinelli",
                        email= "jarodriguez5@alumnos.unsada.edu.ar"
                ),
                version="1.0.0"
        )
)

public class SwaggerConfig {

}