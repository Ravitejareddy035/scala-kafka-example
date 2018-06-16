object KafkaProducer extends App {

  import org.apache.kafka.clients.producer.{ProducerRecord,KafkaProducer}
  import java.util.Properties

  val props = new Properties()
  props.put("bootstrap.servers","127.0.0.1:9092")
  props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer")

  val producer = new KafkaProducer[String,String](props)

  val TOPIC ="first_topic"

  for(i<-0 to 200){
    val record = new ProducerRecord(TOPIC,"key",s"hello world,it is my $i th message ")
    producer.send(record)
  }
  val record = new ProducerRecord(TOPIC,"Key1","loop is completed"+new java.util.Date())
  producer.send(record)
  producer.close()
}
