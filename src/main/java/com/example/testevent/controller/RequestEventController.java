package com.example.testevent.controller;

import java.util.UUID;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.testevent.entity.EventTest;

@RestController
@RequestMapping("api/event")
public class RequestEventController {
    // @Value("${api_key.name}")
    // private String api_key;

    @PostMapping("/request")
    public ResponseEntity<String> saveuser(@RequestBody String user){
        String uri = "https://b18hlwsdpi.execute-api.us-east-2.amazonaws.com/prod/sqs";
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-api-key", "ndmgozALnU6l2n16YZrjta01wbXVn2oGQS0MWQe0");
        //headers.add("x-api-key", api_key);
        EventTest event = new EventTest(UUID.randomUUID().toString(), "mensaje");
        HttpEntity<EventTest> entity = new HttpEntity<EventTest>(event,headers); 
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
        
        return response;
    }

    @PostMapping("/response")
    public ResponseEntity<String> saveResponse(@RequestBody String idString){
        
        ResponseEntity<String> response = new ResponseEntity<>("Hello World!", HttpStatus.OK);;
        //String result = restTemplate.getForObject(uri,entityString.class); 
        return response;
    }
}
