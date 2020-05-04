// It is possible to import classes
// import [package.name.class.name]

plugins {
  java
  scala
  application
  id("com.github.maiflai.scalatest") version "0.26"
  id("org.scoverage") version "4.0.1"
  // fat jar
  id("com.github.johnrengelman.shadow") version "5.2.0"
}

repositories {
  // is superior to mavenCentral() in terms of performance and memory footprint
  // https://stackoverflow.com/a/50726436/3687018
  jcenter()
}

dependencies {
  implementation("org.scala-lang:scala-library:2.12.8")
  implementation("it.unibo.alice.tuprolog:tuprolog:3.3.0")

  testImplementation("junit:junit:4.12")
  testImplementation("org.scalatest:scalatest_2.12:3.0.8")

  testRuntimeOnly(group = "org.pegdown", name = "pegdown", version = "1.4.2")
  // https://github.com/maiflai/gradle-scalatest/issues/43#issuecomment-584319651
  // testRuntimeOnly("com.vladsch.flexmark:flexmark-all:0.36.8")

  scoverage("org.scoverage:scalac-scoverage-plugin_2.12:1.4.1")
  scoverage("org.scoverage:scalac-scoverage-runtime_2.12:1.4.1")
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8

  withSourcesJar()
  withJavadocJar()
}

application {
  mainClassName = "it.unibo.lab.JavaApp"
}

tasks.withType<ScalaCompile> {
  sourceCompatibility = "1.8"
  targetCompatibility = "1.8"
}

task("allTests") {
  dependsOn(tasks.test)
  dependsOn(tasks.scalatest)
}

task<JavaExec>("runJava") {
  classpath = sourceSets.main.get().runtimeClasspath
  main = "it.unibo.lab.JavaApp"
}

task<JavaExec>("runScala") {
  classpath = sourceSets.main.get().runtimeClasspath
  main = "lab.ScalaApp"
}
