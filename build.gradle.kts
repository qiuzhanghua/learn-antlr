plugins {
    application
    antlr
}

repositories {
    mavenCentral()
}
version = "0.1.1"

java.sourceCompatibility = JavaVersion.VERSION_17

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
    implementation("com.google.guava:guava:31.1-jre")
    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("commons-io:commons-io:2.11.0")
    antlr("org.antlr:antlr4:4.11.1")
    implementation("org.antlr:stringtemplate:4.0.2")
}

//sourceSets{
//    antlr {
//        java {
//            srcDirs("build/generated-src/antlr")
//        }
//    }
//}

application {
    mainClass.set("cn.com.taiji.learn.App")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}


tasks.generateGrammarSource {
    maxHeapSize = "512m"
    arguments = arguments + listOf("-visitor", "-long-messages")
}

//task("printSrc") {
//    println("hello")
//    sourceSets.forEach { srcSet ->
//        println( "["+srcSet.name+"]")
//        print("-->Source directories: "+srcSet.allJava.srcDirs+"\n")
//        print("-->Output directories: "+srcSet.output.classesDirs.files+"\n")
//        print("-->Compile classpath:\n")
//        srcSet.compileClasspath.files.forEach {
//            print ("  "+it.path+"\n")
//        }
//    }
//}
