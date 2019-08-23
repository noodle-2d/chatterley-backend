import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0"
ThisBuild / organization     := "com.ran"
ThisBuild / organizationName := "chatterley"

lazy val commonDependencies = Seq(
  slf4j,
  scalaTest % Test
)

lazy val chatterleyCore = (project in file("chatterley-core"))
  .settings(
    name := "chatterley-core",
    libraryDependencies ++= commonDependencies ++ Seq(slick)
  )

lazy val chatterleyIdp = (project in file("chatterley-idp"))
  .dependsOn(chatterleyCore)
  .settings(
    name := "chatterley-idp",
    libraryDependencies ++= commonDependencies ++ Seq(slick)
  )

lazy val chatterleyMessenger = (project in file("chatterley-messenger"))
  .dependsOn(chatterleyCore)
  .settings(
    name := "chatterley-messenger",
    libraryDependencies ++= commonDependencies ++ Seq(slick)
  )

lazy val chatterleyImageManager = (project in file("chatterley-image-manager"))
  .dependsOn(chatterleyCore)
  .settings(
    name := "chatterley-image-manager",
    libraryDependencies ++= commonDependencies
  )

lazy val chatterleyPushManager = (project in file("chatterley-push-manager"))
  .dependsOn(chatterleyCore)
  .settings(
    name := "chatterley-push-manager",
    libraryDependencies ++= commonDependencies
  )
