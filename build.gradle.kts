plugins {
    id("java")
    id("war")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


dependencies {
    implementation("javax.faces:javax.faces-api:2.3")
    implementation("org.glassfish:javax.faces:2.3.9")
    implementation("jstl:jstl:1.2")
    implementation("org.json:json:20230227")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}