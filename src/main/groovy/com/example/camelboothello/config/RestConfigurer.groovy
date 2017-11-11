package com.example.camelboothello.config

import com.example.camelboothello.service.ShipNoticeService
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.stereotype.Component

import javax.ws.rs.ApplicationPath

/**
 * Created by ravipalakodeti on 11/9/17.
 */
@Component
@ApplicationPath('ship-notices')
class RestConfigurer extends ResourceConfig {

    RestConfigurer() {
        register(ShipNoticeService.class)
    }
}
