package com.example.camelboothello.service

import com.example.camelboothello.model.ShipNotice
import groovy.json.JsonBuilder
import groovy.util.logging.Slf4j
import org.apache.camel.Produce
import org.apache.camel.ProducerTemplate
import org.springframework.stereotype.Component

import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

/**
 * Created by ravipalakodeti on 11/9/17.
 */
@Path('')
@Slf4j
@Component
class ShipNoticeService {

    final static JsonBuilder jsonBuilder = new JsonBuilder()

    @Produce(uri = 'seda:newAsnChannel')
    ProducerTemplate producerTemplate

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path('health')
    serviceHealth() {
        return jsonBuilder {
            code '200'
            status 'UP'
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    collectShipNotices(Collection<ShipNotice> shipNotices) {
        producerTemplate.sendBody(shipNotices)
        return jsonBuilder {
            status 'DONE'
        }
    }
}
