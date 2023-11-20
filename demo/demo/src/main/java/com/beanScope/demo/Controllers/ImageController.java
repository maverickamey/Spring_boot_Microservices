package com.beanScope.demo.Controllers;

import com.beanScope.demo.ImageConfig;
import org.springframework.beans.factory.annotation.Autowired;
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
    // the problem with below autowired is if we go to RestTemplate
    // it doesnt have a Component so this will not work as its libarray and we cant modify in
    // the libraray so lets try alternate approach
//    @Autowired
    @Autowired
    private RestTemplate restTemplate;
    //
    @Autowired
    private ImageConfig imageConfig;

    // as we know we have created a constructor for @Component
//    ImageController(@Autowired ImageConfig imageConfig){
//        this.restTemplate = imageConfig.getRestTemplate();
//    }
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
