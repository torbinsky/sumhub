name := "sumhub"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  cache,
  "org.mongodb" % "mongo-java-driver" % "2.11.3",
  "org.jongo" % "jongo" % "1.0",
  "com.google.inject" % "guice" % "3.0"
)     

javacOptions ++= Seq("-source", "1.7")

play.Project.playJavaSettings
