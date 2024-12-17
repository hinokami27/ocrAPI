package com.example.ocrapi;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OcrApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OcrApiApplication.class, args);
	}
	@Bean
	public Tesseract createTesseract(){
		Tesseract tesseract = new Tesseract();
		tesseract.setLanguage("eng");
		tesseract.setDatapath("src/main/resources/tesseract-engine/tessdata");
		return tesseract;
	}
}
