import net.nmoncho.sbt.dependencycheck.settings._

lazy val commonSettings = Seq(
  organization := "net.vonbuchholtz",
  version := "0.1.0",
  scalaVersion := "2.13.15"
)

lazy val root = (project in file("."))
  .aggregate(core)
  .settings(commonSettings: _*)
  .settings(
    dependencyCheckFailBuildOnCVSS := 0,
    dependencyCheckNvdApi := sys.env.get("NVD_API_KEY").map(key => NvdApiSettings(key)).getOrElse(NvdApiSettings.Default),
  )

lazy val core = (project in file("core"))
  .settings(commonSettings: _*)
  .settings(
    libraryDependencies += "org.apache.commons" % "commons-collections4" % "4.1"
  )

lazy val inScope = (project in file("inScope"))
  .settings(commonSettings: _*)
  .settings(
    libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind"  % "2.9.9"
  )
