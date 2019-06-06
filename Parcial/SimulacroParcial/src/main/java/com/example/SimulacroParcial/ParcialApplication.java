package com.example.SimulacroParcial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.Properties;

@SpringBootApplication
public class ParcialApplication {

	public static void main(String[] args) {

		try (InputStream input = new FileInputStream("config.properties")) {
			Properties prop = new Properties();
			prop.load(input);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		SpringApplication.run(ParcialApplication.class, args);
	}