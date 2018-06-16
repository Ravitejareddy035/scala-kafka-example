object KafkaConsumer extends App {

  import org.apache.kafka.clients.consumer.KafkaConsumer
  import java.util.Properties
  import scala.collection.JavaConverters._

  val TOPIC = "first_topic"
  val props = new Properties()

  props.put("bootstrap.servers","127.0.0.1:9092")
  props.put("key.deserializer","org.apache.kafka.commom.serialization.StringDeserializer")
  props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer")

  val consumer = new KafkaConsumer[String,String](props)
  consumer.subscribe(TOPIC)

  while(true){
    val records = consumer.poll(200)
    for(record<-records.asScala) println(record)
  }

}
