package com.example.camelboothello.processor

import com.example.camelboothello.model.ShipNotice

/**
 * Created by ravipalakodeti on 11/11/17.
 */
class FordAsnProcessor extends DefaultShipNoticeProcessor {

    def processShipNotice(ShipNotice shipNotice) {

        //perform the default processing. additional customer specific processing can be included here
        super.processDefaultShipNotice(shipNotice)
    }
}
