import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0"
ThisBuild / organization     := "com.ran"
ThisBuild / organizationName := "chatterley"

lazy val root = (project in file("."))
  .settings(
    name := "chatterley-backend",
    libraryDependencies += scalaTest % Test
  )
