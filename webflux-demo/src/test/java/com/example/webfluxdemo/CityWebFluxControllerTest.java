package com.example.webfluxdemo;

import com.example.webfluxdemo.model.City;
import com.example.webfluxdemo.service.CityHandler;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@WebFluxTest
public class CityWebFluxControllerTest {

    @Resource
    private WebTestClient webTestClient;

    @MockBean
    private CityHandler cityHandler;

    private static Map<String, City> cityMap = new HashMap<>();

    private static final String CITY_NAME="Shanghai";

    @BeforeClass
    public static void setup() throws Exception {
        City shanghai = new City();
        shanghai.setId(3L);
        shanghai.setProvinceId(2L);
        shanghai.setCityName(CITY_NAME);
        shanghai.setDescription("welcome to Shanghai");
        cityMap.put("Shanghai", shanghai);
    }

    @Test
    public void testSave() throws Exception {

        Mockito.when(this.cityHandler.save(cityMap.get(CITY_NAME)))
                .thenReturn(Mono.create(cityMonoSink -> cityMonoSink.success(cityMap.get(CITY_NAME))));

        City expectCity = webTestClient.post().uri("/city")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(cityMap.get(CITY_NAME)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(City.class).returnResult().getResponseBody();



        Assert.assertNotNull(expectCity);
        Assert.assertEquals(expectCity.getId(), cityMap.get(CITY_NAME).getId());
        Assert.assertEquals(expectCity.getCityName(), cityMap.get(CITY_NAME).getCityName());
    }

}