package com.banque.misr.irrigationsystem.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.banque.misr.irrigationsystem.BaseDataBuilder;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PlotsApiControllerTests extends BaseDataBuilder {

	@LocalServerPort
    private int port;
	
	TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    
    @BeforeEach public void init() {
    	headers.add("authToken", "abcd");
    	headers.setContentType(MediaType.APPLICATION_JSON);
    }
    
    @Order(1)
    @Test
    void testPlotCreation() {
        HttpEntity<String> entity = new HttpEntity<String>(PLOT_REQUEST, headers);
        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/api/v1/plots"), HttpMethod.POST, entity, String.class);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
    
    @Order(2)
    @Test
    void testMissingNameFieldCreatePlot() {
    	HttpEntity<String> entity = new HttpEntity<String>(PLOT_REQUEST_MISSING_NAME, headers);
        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/api/v1/plots"), HttpMethod.POST, entity, String.class);
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
    }
    
    @Order(3)
    @Test
    void testInvalidStatusFieldCreatePlot() {
    	HttpEntity<String> entity = new HttpEntity<String>(PLOT_REQUEST_INVALID_ENUM_VALUE, headers);
        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/api/v1/plots"), HttpMethod.POST, entity, String.class);
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
    }
    
    @Order(4)
    @Test
    void testMissingFieldSensorIdCreatePlot() {
    	HttpEntity<String> entity = new HttpEntity<String>(PLOT_REQUEST_SENSOR_NOT_FOUND, headers);
        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/api/v1/plots"), HttpMethod.POST, entity, String.class);
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
    }
    
    @Order(5)
    @Test
    void testInvalidSensorIdCreatePlot() {
    	HttpEntity<String> entity = new HttpEntity<String>(PLOT_REQUEST_SENSOR_INVALID, headers);
        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/api/v1/plots"), HttpMethod.POST, entity, String.class);
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
    }
    
    @Order(6)
    @Test
    void testDuplicateCreatePlot() {
    	HttpEntity<String> entity = new HttpEntity<String>(PLOT_REQUEST_DUPLICATE_NAME, headers);
        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/api/v1/plots"), HttpMethod.POST, entity, String.class);
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
    }
    
    
    ///
    
    @Order(7)
    @Test
    void testPlotUpdation() {
        HttpEntity<String> entity = new HttpEntity<String>(PLOT_UPDATE_REQUEST, headers);
        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/api/v1/plots/61"), HttpMethod.PUT, entity, String.class);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
    
    @Order(8)
    @Test
    void testMissingNameFieldUpdatePlot() {
    	HttpEntity<String> entity = new HttpEntity<String>(PLOT_REQUEST_MISSING_NAME, headers);
        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/api/v1/plots/61"), HttpMethod.PUT, entity, String.class);
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
    }
    
    @Order(9)
    @Test
    void testInvalidStatusFieldUpdatePlot() {
    	HttpEntity<String> entity = new HttpEntity<String>(PLOT_REQUEST_INVALID_ENUM_VALUE, headers);
        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/api/v1/plots/61"), HttpMethod.PUT, entity, String.class);
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
    }
    
    @Order(10)
    @Test
    void testMissingFieldSensorIdUpdatePlot() {
    	HttpEntity<String> entity = new HttpEntity<String>(PLOT_REQUEST_SENSOR_NOT_FOUND, headers);
        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/api/v1/plots/61"), HttpMethod.PUT, entity, String.class);
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
    }
    
    @Order(11)
    @Test
    void testInvalidSensorIdUpdatePlot() {
    	HttpEntity<String> entity = new HttpEntity<String>(PLOT_REQUEST_SENSOR_INVALID, headers);
        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/api/v1/plots/61"), HttpMethod.PUT, entity, String.class);
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
    }
    
    @Order(12)
    @Test
    void testDuplicateUpdatePlot() {
    	HttpEntity<String> entity = new HttpEntity<String>(PLOT_REQUEST_DUPLICATE_NAME, headers);
        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/api/v1/plots/62"), HttpMethod.PUT, entity, String.class);
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
    }
    
    @Order(13)
    @Test
    void testPlotDeletion() {
    	HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/api/v1/plots/61"), HttpMethod.DELETE, entity, String.class);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
    @Order(14)
    @Test
    void testInvalidPlotIdDeletion() {
    	HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/api/v1/plots/61111"), HttpMethod.DELETE, entity, String.class);
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
    }
    
    @Order(15)
    @ParameterizedTest
    @ValueSource(strings = {"/api/v1/plots",
    		"/api/v1/plots?pageSize=1&name=1st",
    		"/api/v1/plots?pageSize=1&description=First",
    		"/api/v1/plots?pageSize=1&status=ACTIVE",
    		"/api/v1/plots?pageSize=1&cropType=FOOD"})
    void testPlotListingWithAndWithoutFilters(String url) {
    	HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort(url), HttpMethod.GET, entity, String.class);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
    
    @Order(16)
    @ParameterizedTest
    @ValueSource(strings = {"/api/v1/sensors",
    		"/api/v1/sensors?pageSize=1&name=1st",
    		"/api/v1/sensors?pageSize=1&description=First",
    		"/api/v1/sensors?pageSize=1&status=ACTIVE"})
    void testSensorListingWithAndWithoutFilters(String url) {
    	HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort(url), HttpMethod.GET, entity, String.class);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
    
    @Order(17)
    @Test
    void testIrrigationTimingsCreate() {
    	HttpEntity<String> entity = new HttpEntity<String>(IRRIGATION_TIMING_REQUEST, headers);
        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/api/v1/plots/62/timings"), HttpMethod.POST, entity, String.class);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
    
    @Order(18)
    @Test
    void testIrrigationTimingsCreateDuplicateTimings() {
    	HttpEntity<String> entity = new HttpEntity<String>(IRRIGATION_TIMING_REQUEST, headers);
        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/api/v1/plots/62/timings"), HttpMethod.POST, entity, String.class);
        response = restTemplate.exchange(
                createURLWithPort("/api/v1/plots/62/timings"), HttpMethod.POST, entity, String.class);
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
    }
    
    @Order(19)
    @Test
    void testMissingAmountOfWaterFieldCreateTimings() {
    	HttpEntity<String> entity = new HttpEntity<String>(IRRIGATION_TIMING_REQUEST_MISSING_FIELD, headers);
        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/api/v1/plots/62/timings"), HttpMethod.POST, entity, String.class);
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
    }
    
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
