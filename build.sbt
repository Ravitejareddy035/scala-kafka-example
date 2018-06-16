name := "SampleKafkaCode"

version := "0.1"

scalaVersion := "2.11.10"
libraryDependencies ++= {
  Seq(
    "org.apache.kafka" %% "kafka" % "0.8.2.2",
    "org.apache.kafka" % "kafka-clients" % "0.8.2.2"
  )
}
