package com.example.demodb.commons;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Controller
public class ImageController {

//    @ResponseBody // is not only responsible for java --> json conversion but for any type of conversion
    @GetMapping(value = "/images/{imageId}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage(@PathVariable("imageId") int imageId,
                         @RequestParam(value = "length", required = false, defaultValue = "200") int length,
                         @RequestParam(value = "breadth", required = false, defaultValue = "300") int breadth){


        RestTemplate restTemplate = new RestTemplate();
        byte[] result = restTemplate.getForObject("https://picsum.photos/id/" + imageId
                + "/" + length + "/" + breadth, byte[].class);
        return result;

        // axios - js
        // okhttp - java / js / python
        // webclient

    }


//    @ResponseBody
    @GetMapping("/random")
    public int getRandomNumber(){
        return new Random().nextInt();
    }
}
