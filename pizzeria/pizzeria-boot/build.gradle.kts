plugins {
  java
  id("org.springframework.boot") version "2.3.3.RELEASE"
}

tasks.bootJar {
  archiveName = "pizzeria-boot.jar"
  manifest.attributes["Implementation-Version"] = project.version
}

dependencies {
  compile(project(":pizzeria-core"))
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-configuration-processor:")
  implementation("org.springframework.boot:spring-boot-starter-jdbc")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}
