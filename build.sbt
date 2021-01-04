name := "scalaANDparquet"

version := "0.1"

scalaVersion := "2.13.4"

libraryDependencies ++= Seq(
  "com.github.mjakubowski84" %% "parquet4s-core" % "1.7.0",
  "org.apache.hadoop" % "hadoop-client" % "3.1.1"
)

libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.3.6"

