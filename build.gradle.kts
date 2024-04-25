plugins {
	java
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
	id("com.diffplug.spotless") version "6.25.0"
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
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	// https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")

	// https://mvnrepository.com/artifact/org.projectlombok/lombok
	// https://projectlombok.org/setup/gradle
	compileOnly("org.projectlombok:lombok:1.18.32")
	annotationProcessor("org.projectlombok:lombok:1.18.32")
	testCompileOnly("org.projectlombok:lombok:1.18.32")
	testAnnotationProcessor("org.projectlombok:lombok:1.18.32")

	runtimeOnly("com.h2database:h2")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

spotless {
	java {
		// import 순서 정의
		importOrder(
			"java",
			"javax",
			"lombok",
			"org.springframework",
			"",
			"\\#",
			"org.junit",
			"\\#org.junit",
			"com.guide",
			"\\#com.guide"
		)
		// 사용하지 않는 import 제거
		removeUnusedImports()
		// 구글 자바 포맷 적용
		googleJavaFormat()

		indentWithTabs(2)
		indentWithSpaces(4)
		// 공백 제거
		trimTrailingWhitespace()
		// 끝부분 New Line 처리
		endWithNewline()
	}
}
