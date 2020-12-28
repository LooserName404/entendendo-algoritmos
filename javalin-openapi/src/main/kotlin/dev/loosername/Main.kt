package dev.loosername

import cc.vileda.openapi.dsl.info
import cc.vileda.openapi.dsl.openapiDsl
import dev.loosername.controllers.UserController
import io.javalin.Javalin
import io.javalin.plugin.json.*
import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.http.Context
import io.javalin.http.InternalServerErrorResponse
import io.javalin.http.ServiceUnavailableResponse
import io.javalin.plugin.openapi.*
import io.javalin.plugin.openapi.ui.ReDocOptions
import io.javalin.plugin.openapi.ui.SwaggerOptions
import io.swagger.v3.oas.models.info.Info

@ExperimentalSerializationApi
fun main() {
    JavalinJson.fromJsonMapper = object : FromJsonMapper {
        override fun <T> map(json: String, targetClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            val deserializer = serializer(targetClass) as KSerializer<T>
            return Json.decodeFromString(deserializer, json)
        }
    }
    JavalinJson.toJsonMapper = object : ToJsonMapper {
        override fun map(obj: Any): String {
            val serializer = serializer(obj.javaClass)
            return Json.encodeToString(serializer, obj)
        }
    }

    Javalin.create {
        it.enableWebjars()
        it.registerPlugin(getConfiguredOpenApiPlugin())
        it.defaultContentType = "application/json"
    }.routes {
        @Suppress("UNCHECKED_CAST")
        path("users") {
            get(UserController::getAll as (Context) -> Unit)
            post(UserController::create as (Context) -> Unit)
            path(":userId") {
                get(UserController::getOne as (Context) -> Unit)
                patch(UserController::update as (Context) -> Unit)
                delete(UserController::delete as (Context) -> Unit)
            }
        }
    }.start(7001)

    println("Check out ReDoc docs at http://localhost:7001/redoc")
    println("Check out Swagger UI docs at http://localhost:7001/swagger-ui")
}

fun getConfiguredOpenApiPlugin() = OpenApiPlugin(
    OpenApiOptions {
        openapiDsl {
            info {
                title = "User API"
                description = "Demo API with 5 operations"
                version = "1.0.0"
            }
        }
    }.apply {
        path("/swagger-docs") // endpoint for OpenAPI json
        swagger(SwaggerOptions("/swagger-ui")) // endpoint for swagger-ui
        reDoc(ReDocOptions("/redoc")) // endpoint for redoc
        defaultDocumentation { doc ->
            doc.json("500", ErrorResponse::class.java)
            doc.json("503", ErrorResponse::class.java)
        }
    }
)