plugins {
	java
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.s3ich4n.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	// https://mvnrepository.com/artifact/junit/junit
	testImplementation("junit:junit:4.13.2")

	// https://mvnrepository.com/artifact/org.projectlombok/lombok
	// https://projectlombok.org/setup/gradle
	compileOnly("org.projectlombok:lombok:1.18.32")
	annotationProcessor("org.projectlombok:lombok:1.18.32")

	testCompileOnly("org.projectlombok:lombok:1.18.32")
	testAnnotationProcessor("org.projectlombok:lombok:1.18.32")
}

tasks.withType<Test> {
	useJUnitPlatform()
}