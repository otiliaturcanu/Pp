package org.example

fun main(args: Array<String>) {
    var g = GetRequest("https://www.google.com", mapOf("1" to "Adult"), 1)
    var g2 = GetRequest("www.abc.ro", null, 1)
    var conn1 = CleanGetRequest(g)
    var conn2 = CleanGetRequest(g2)
    var kb = KidsBrowser(conn1, null)
    kb.start()
    println("======================")
    var post1 = PostRequest("www.abc.ro", null)
    var kb2 = KidsBrowser(conn2, post1)
    kb2.start()
}

