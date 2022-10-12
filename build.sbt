name := "rs.dxt.breakout"

version := "0.1"

scalaVersion := "2.12.10"

libraryDependencies ++= Seq (
  "com.badlogicgames.gdx" % "gdx-backend-lwjgl3" % "1.11.0",
  "com.badlogicgames.gdx" % "gdx-platform" % "1.11.0" classifier "natives-desktop",
)
