package com.hugo.feign.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hugo.feign.api.client.BankClient;
import com.hugo.feign.api.dto.BankResponse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;

import javax.net.ssl.HttpsURLConnection;

@SpringBootApplication
@RestController
//@EnableFeignClients
public class BankAppApplication {
	
	/*@Autowired
	private BankClient client;*/
	private static final String HTTPS_URL = "https://www.banamex.com/localizador/jsonP/json5.json";
	
	@GetMapping("/findAllBank")
	public JSONObject getBanks() {
		
		URL url = null;
		HttpsURLConnection connection = null;
		Object jsonObj = null;
		//JSONObject jsonObject = null;
		
		try {
			url = new URL(HTTPS_URL);
			connection = (HttpsURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			//return;
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (InputStream inputStream = connection.getInputStream();
				InputStreamReader isr = new InputStreamReader(inputStream);
				BufferedReader br = new BufferedReader(isr)) {
				//BufferedWriter writer = new BufferedWriter(new FileWriter("prueba.txt"))

			String r = br.readLine();
			String n = r.replace("jsonCallback(", "");
			String f = n.replace(");","");
			
		    //writer.write(f);
		    //writer.close();
			
			JSONParser parser = new JSONParser();
            jsonObj = parser.parse(f);
            //jsonObject =  (JSONObject) jsonObj;
            
            
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
	    
		
		return (JSONObject) jsonObj;
		
	}
	
	/*@GetMapping("/findAllBank")
	public List<BankResponse> getBanks(){
		return client.getBanks();
	}*/
	
	public static void main(String[] args) {
		SpringApplication.run(BankAppApplication.class, args);
	}

}
