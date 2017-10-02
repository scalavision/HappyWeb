
lazy val copyIndex = taskKey[Unit]("Copies the index template into main folder of webpack")

lazy val webClientSettings = Seq(
  name := "Happy Web Components",
  organization := "scalavision",
  scalacOptions ++= compileOptions.value,
  scalacOptions in Test ++= Seq("-Yrangepos"),
  mainClass := Some("client.Main"),
  useYarn := true,
  copyIndex := {
    val in = baseDirectory.value / "index.ejs"
    val out = baseDirectory.value / "target"/ "scala-2.12" / "scalajs-bundler" / "main" / "index.ejs"
    IO.copyFile(in, out)  
  },
  webpackBundlingMode := BundlingMode.LibraryOnly(),
//  webpackBundlingMode := BundlingMode.Application,
//  webpackDevServerExtraArgs := Seq("--client-log-level:none", "--inline", "--quite", "--no-info"),
  webpackDevServerExtraArgs := Seq("--inline"),
//  webpackMonitoredDirectories += baseDirectory.value / ,
//  includeFilter in webpackMonitoredFiles ++= Seq("*.js", "*.html", "*.css"),
  webpackConfigFile in fastOptJS := Some(baseDirectory.value / "base.webpack.config.js"),
  npmDevDependencies in Compile ++= Seq(
    "webpack-merge" -> "4.1.0",
    "html-webpack-plugin" -> "2.30.1",
    "html-loader" -> "0.5.0",
    "handlebars-webpack-plugin" -> "1.3.0",
    "jsdom" -> "11.2.0"
  ),
  version in webpack := "2.6.1",
//  artifactPath in(Compile, fastOptJS) := 
//    file("/Users/tomsorlie/IdeaProjects/Training/webpack/tut1/fastOpt.js"),
    npmDependencies in Compile += "jquery" -> "2.1.4",  
  libraryDependencies ++= Seq(
  "com.lihaoyi" %%% "sourcecode" % DefaultDependencies.MetaProgramming.sourceCodeVersion,
    "com.lihaoyi" %%% "pprint" % DefaultDependencies.UtilSettings.pprintVersion
  )  ++ scalaWebRxDependencies.value 
) ++ ScalaJSDefaultsPlugin.scalaJsDefaults

lazy val webClient = project.in(file("./webClient"))
  .enablePlugins(ScalaJSBundlerPlugin)
  .settings(webClientSettings :_*)
  
