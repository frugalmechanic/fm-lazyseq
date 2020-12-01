FMPublic

name := "fm-lazyseq"

description := "LazySeq"

scalaVersion := "2.12.12"

crossScalaVersions := Seq("2.11.11", "2.12.12")

scalacOptions := Seq(
  "-unchecked",
  "-deprecation",
  "-language:implicitConversions",
  "-feature",
  "-Xlint",
  "-Ywarn-unused-import"
) ++ (if (scalaVersion.value.startsWith("2.12")) Seq(
  // Scala 2.12 specific compiler flags
  "-opt:l:inline",
  "-opt-inline-from:<sources>"
) else Nil)

libraryDependencies += "com.frugalmechanic" %% "fm-common" % "0.49.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
