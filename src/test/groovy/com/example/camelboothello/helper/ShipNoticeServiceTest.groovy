package com.example.camelboothello.helper

import com.example.camelboothello.DemoApplicationTests
import com.example.camelboothello.model.ShipNoticeBuilder
import groovy.util.logging.Slf4j
import io.restassured.RestAssured
import org.apache.http.HttpStatus
import org.junit.Before
import org.junit.Test

import javax.ws.rs.core.MediaType
import java.time.Instant

import static io.restassured.RestAssured.given
import static io.restassured.RestAssured.get

import static org.hamcrest.Matchers.equalTo

/**
 * Created by ravipalakodeti on 11/9/17.
 */
@Slf4j
class ShipNoticeServiceTest extends DemoApplicationTests{

    private static final Random random = new Random()
    private static final String SHIP_NOTICE_BATCH = "/ship-notices"
    private static final makes = ['FORD', 'CHRYSLER', 'GM', 'TOYOTA', 'BMW']

    @Before
    void setup() {
        RestAssured.port = serverPort
        // use this for checking against a running application instead of a test runtime
        // RestAssured.port = 8080
    }

    @Test
    void shipServiceIsUp() {
        get("${SHIP_NOTICE_BATCH}/health")
            .then()
            .statusCode(HttpStatus.SC_OK)
    }

    @Test
    void initiate_ship_notices_batch() {

        given()
            // request attributes
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            // request body is a collection of ship notices
            .body(
                (1..100000).collect {
                    new ShipNoticeBuilder()
                            .asnNumber(it)
                            .customer(makes[random.nextInt(3)])
                            .messageTime(Instant.now().toString()) // java 8 - this is UTC ISO-8601 format
                            .create()
                }
            )
            .when()
                .put(SHIP_NOTICE_BATCH)
                    .then()
                    .statusCode(HttpStatus.SC_OK)
                    .assertThat()
                        .body('status', equalTo('DONE'))

        // sleep the thread for the test to complete. this is only needed when running in TDD mode
        Thread.sleep(10000)
    }
}
