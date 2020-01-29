dependencies {
    implementation(project(":chatterley-schema"))
    implementation(project(":chatterley-common"))
}

application {
    mainClassName = "com.ran.chatterley.push.sender.MainKt"
}
