#!/bin/sh

///bin/true <<EOC 2>/dev/null || true
/*
EOC
kotlinc -script -Xplugin="$(dirname $(realpath $(which kotlinc)))/../lib/kotlinx-serialization-compiler-plugin.jar" "$0" "$@"
exit $?
*/

@file:Repository("https://jcenter.bintray.com")
@file:DependsOn("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")

import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class Num(val n: Int)

val r = Json.decodeFromString<Num>("""
    {
        "n" : 42
    }
    """
)
print(r)
