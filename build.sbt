name := "test-travis-ci"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "org.apache.commons" % "commons-io" % "1.3.2"
)

play.Project.playScalaSettings

mappings in Universal ++=
  (baseDirectory.value / "scripts" * "*" get) map
    (x => x -> ("scripts/" + x.getName))

mappings in Universal ++= Seq(baseDirectory.value / ".build_version" -> ".build_version")
