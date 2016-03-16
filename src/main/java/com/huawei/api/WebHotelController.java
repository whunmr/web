package com.huawei.api;

import com.huawei.domain.Hotel;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/hotels")
public class WebHotelController {


    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    public
    @ResponseBody
    Hotel getHotel(@PathVariable("id") Long id,
                   HttpServletRequest request, HttpServletResponse response) throws Exception {


        RestTemplate restTemplate = new RestTemplate();
        Hotel hotel = restTemplate.getForObject("http://localhost:8090/example/v1/hotels/1", Hotel.class);

        return hotel;
    }

}
