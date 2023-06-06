@file:Repository("https://jcenter.bintray.com")
@file:DependsOn("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")

import kotlinx.serialization.*
import kotlinx.serialization.json.*

val rs = listOf(
    Json.parseToJsonElement("null"),
    Json.parseToJsonElement("42"),
    Json.parseToJsonElement(""" "Hi" """),
    Json.parseToJsonElement("""
      [1,2,3]
      """
    ),
    Json.parseToJsonElement("{}"),
    Json.parseToJsonElement("""
        {
          "n": 42,
          "name": "Fred Flintstone"
        }
        """
    ),
)
rs.forEach{ println(it) }
