import com.google.protobuf.gradle.*

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.50" apply false
    id("com.google.protobuf") version "0.8.10" apply false
}

val applicationModules = setOf(
        module("api"),
        module("idp"),
        module("messenger"),
        module("push-sender")
)

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "com.google.protobuf")
    apply(plugin = "idea")

    if (isApplicationModule(name)) {
        apply(plugin = "application")
    } else {
        apply(plugin = "java-library")
    }

    version = "1.0"

    val kotlinVersion = "1.3.50"
    val grpcVersion = "1.24.0"
    val javaxAnnotationVersion = "1.3.2"
    val protocVersion = "3.9.0"

    repositories {
        jcenter()
    }

    dependencies {
        "implementation"("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
        "implementation"("io.grpc:grpc-netty-shaded:$grpcVersion")
        "implementation"("io.grpc:grpc-protobuf:$grpcVersion")
        "implementation"("io.grpc:grpc-stub:$grpcVersion")
        "implementation"("io.grpc:grpc-services:$grpcVersion")
        "implementation"("javax.annotation:javax.annotation-api:$javaxAnnotationVersion")

        "testImplementation"("org.jetbrains.kotlin:kotlin-test:$kotlinVersion")
        "testImplementation"("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
    }

    protobuf {
        protoc { artifact = "com.google.protobuf:protoc:$protocVersion" }
        plugins {
            id("grpc") {
                artifact = "io.grpc:protoc-gen-grpc-java:$grpcVersion"
            }
        }
        generateProtoTasks {
            ofSourceSet("main").forEach {
                it.plugins {
                    id("grpc")
                }
            }
        }
    }
}

fun module(name: String): String = "chatterley-$name"

fun isApplicationModule(name: String): Boolean = applicationModules.contains(name)
