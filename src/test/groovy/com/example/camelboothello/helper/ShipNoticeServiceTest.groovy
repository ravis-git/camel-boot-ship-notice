package com.example.camelboothello.helper

import com.example.camelboothello.DemoApplicationTests
import groovy.util.logging.Slf4j
import io.restassured.RestAssured
import org.apache.http.HttpStatus
import org.junit.Before
import org.junit.Test

import static io.restassured.RestAssured.put
import static io.restassured.RestAssured.get;

import static org.hamcrest.Matchers.equalTo;

/**
 * Created by ravipalakodeti on 11/9/17.
 */
@Slf4j
class ShipNoticeServiceTest extends DemoApplicationTests{

    static final Random random = new Random()
    private static final String SHIP_NOTICE_BATCH = "/ship-notices";

    @Before
    def void setup() {
        log.info(" ====== Server port assigned is ${serverPort}")
        RestAssured.port = serverPort
    }

    @Test
    def void shipServiceIsUp() {
        get("${SHIP_NOTICE_BATCH}/health")
            .then()
            .statusCode(HttpStatus.SC_OK)

    }


    @Test
    def void initiate_ship_notices_batch() {

        put(SHIP_NOTICE_BATCH)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .assertThat()
                .body('status', equalTo('DONE'))
    }
}
