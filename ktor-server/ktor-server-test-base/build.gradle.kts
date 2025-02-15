/*
 * Copyright 2014-2025 JetBrains s.r.o and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

description = ""

val jetty_alpn_boot_version: String? by extra

kotlin.sourceSets {
    commonMain {
        dependencies {
            api(project(":ktor-server:ktor-server-test-host"))
            api(project(":ktor-shared:ktor-test-base"))
        }
    }

    jvmMain {
        dependencies {
            api(project(":ktor-network:ktor-network-tls"))

            api(project(":ktor-client:ktor-client-apache"))
            api(project(":ktor-network:ktor-network-tls:ktor-network-tls-certificates"))
            api(project(":ktor-server:ktor-server-plugins:ktor-server-call-logging"))

            if (jetty_alpn_boot_version != null) {
                api(libs.jetty.alpn.boot)
            }
        }
    }
}
