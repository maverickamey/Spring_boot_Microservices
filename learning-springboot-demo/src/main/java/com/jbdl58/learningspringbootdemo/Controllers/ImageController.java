package com.jbdl58.learningspringbootdemo.Controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
// http://localhost:9090/fetchImage?id=12&height=100&width=200
import java.awt.*;
//IMAGES BLOB
@RestController
public class ImageController {


    @GetMapping(value = "/fetchImage", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] fetchImageFromPicSSum(@RequestParam("id") int id,
                                        @RequestParam(value = "height",
                                                required = false,
                                                defaultValue = "200") int height,
                                        @RequestParam(value = "width",
                                                required = false,
                                                defaultValue = "200") int width){
        //call to a third party server it requires a request factory here
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://picsum.photos/" + "id/" + id + "/" + height + "/" + width;

        //below fnc expects a URI and also expects class
        return restTemplate.getForObject(apiUrl, byte[].class);
//        return new byte[23];
    }
}
