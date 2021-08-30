// See README.md for license details.

name := "simplechisel"
version := "1.0.0"
scalaVersion := "2.13.6"
transitiveClassifiers := Seq(Artifact.SourceClassifier)

lazy val scalaReflect = Def.setting { "org.scala-lang" % "scala-reflect" % scalaVersion.value }

libraryDependencies += scalaReflect.value
//resolvers ++= Seq(
//  Resolver.sonatypeRepo("snapshots"),
//  Resolver.sonatypeRepo("releases")
//)
