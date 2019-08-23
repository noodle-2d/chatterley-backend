import sbt._

object Dependencies {
  lazy val slf4j = "org.slf4j" % "slf4j-nop" % "1.6.4"
  lazy val slick = "com.typesafe.slick" %% "slick" % "3.2.1"
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
}
