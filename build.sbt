lazy val root = (project in file(".")).
  settings(
    name := "Music Recommendation System",
    version := "1.0",
    publishMavenStyle := true
  )
  
  libraryDependencies += "org.apache.spark" % "spark-core_2.10" % "1.3.0" % "provided"
  libraryDependencies += "org.apache.spark" % "spark-mllib_2.10" % "1.3.0" % "provided"
  