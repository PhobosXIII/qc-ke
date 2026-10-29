val host = "http://localhost:8080"

GET("$host/") {
    header("Accept", "application/json")
//    queryParam("param", "value")
}