An experiment to see how ASN processing does on Apache Camel

The current implementation only uses seda, and this is OK for one instance. 
Use a messaging channel through AMQP when cutting over to multiple instances