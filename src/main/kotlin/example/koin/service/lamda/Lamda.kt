package example.koin.service.lamda

class HTML {
    var innerHtml = "innerHtml"
    fun body() { println("<body>$innerHtml</body>") }
}

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()  // レシーバオブジェクトを生成
    html.init()        // そのレシーバオブジェクトをラムダに渡す
    html.innerHtml = "innerHtml2"
    return html
}

fun main(){
    val html = html {       // レシーバ付きラムダがここから始まる
        body()   // レシーバオブジェクトのメソッドを呼んでいる
    }
    html.body()
}