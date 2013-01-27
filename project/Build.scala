import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "BBintegra"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here,
      "com.typesafe" %% "play-plugins-mailer" % "2.0.4",
      "org.apache.camel" % "camel-core" % "2.10.3",
      "org.apache.camel" % "camel-test" % "2.10.3", 
      "org.apache.camel" % "camel-http" % "2.10.3",
      "org.apache.camel" % "camel-mail" % "2.10.3",
      "commons-codec" % "commons-codec" % "1.7"
      
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here      
    )

}
