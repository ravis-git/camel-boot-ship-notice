package com.example.camelboothello.processor

import com.example.camelboothello.model.ShipNotice

/**
 * Created by ravipalakodeti on 11/11/17.
 */
class FordAsnProcessor extends DefaultShipNoticeProcessor {

    // making this method static may give better overall result as the jvm does not have multiple instances.
        // -- This may be a future concern when running multiple instances of the service
    static def processShipNotice(ShipNotice shipNotice) {

        //perform the default processing. additional customer specific processing can be included here
        processDefaultShipNotice(shipNotice)
    }
}
