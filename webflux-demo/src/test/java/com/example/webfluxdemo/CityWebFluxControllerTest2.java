package com.example.webfluxdemo;

import com.example.webfluxdemo.model.City;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CityWebFluxControllerTest2 {

    @Resource
    private WebTestClient webClient;

    private static Map<String, City> cityMap = new HashMap<>();

    @BeforeClass
    public static void setup() throws Exception {
        City bj= new City();
        bj.setId(2L);
        bj.setProvinceId(2L);
        bj.setCityName("BJ");
        bj.setDescription("welcome to beijing");
        cityMap.put("BJ", bj);
    }

    @Test
    public void testSave() throws Exception {
        City expectCity = webClient.post().uri("/city")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(cityMap.get("BJ")))
                .exchange()
                .expectStatus().isOk()
                .expectBody(City.class).returnResult().getResponseBody();

        Assert.assertNotNull(expectCity);
        Assert.assertEquals(expectCity.getId(), cityMap.get("BJ").getId());
        Assert.assertEquals(expectCity.getCityName(), cityMap.get("BJ").getCityName());
    }

}