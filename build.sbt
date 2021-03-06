name := """ Learn Akka TDD """

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.4"

organization := "com.mandelag"

libraryDependencies ++= {
    val akkaVersion = "2.4.19"
    Seq(
        "com.typesafe.akka" %% "akka-actor" % akkaVersion,
        "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
        "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
        "com.typesafe.akka" %% "akka-http" % "10.1.5",
        "com.typesafe.akka" %% "akka-stream" % "2.5.12",
        "org.scalatest" %% "scalatest" % "3.0.0" % "test"
    )
}