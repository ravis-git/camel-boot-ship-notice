package com.example.camelboothello.model

import groovy.transform.builder.Builder
import groovy.transform.builder.ExternalStrategy

/**
 * Created by ravipalakodeti on 11/9/17.
 */

class ShipNotice {

    Integer asnNumber
    String customer
    String messageTime
    String processedTime
}

@Builder(builderStrategy = ExternalStrategy, forClass = ShipNotice,
            buildMethodName = 'create', includes = 'asnNumber, customer, messageTime')
class ShipNoticeBuilder{}
