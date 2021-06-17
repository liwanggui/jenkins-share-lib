package org.devops

import groovy.json.JsonOutput

/**
* 发送 HTTP GET 请求
 * @param url 请求的网址
 * @return String
 */
def get(url){
    return new URL(url).text
}


/**
 * 发送 HTTP POST 请求
 * @param url 请求的网址
 * @param data 请求所需的参数，可选
 * @param is_json 请求参数类型是否为 json 格式
 * @return String
 */
def http_post(url, data = null, is_json = false) {
    def conn = new URL(url).openConnection()
    conn.setRequestMethod("POST")
    if (data) {
        if (is_json) {
            conn.setRequestProperty("Content-Type", "application/json")
            data = JsonOutput.toJson(data)
        }
        // 输出请求参数
        println(data)
        conn.doOutput = true
        def writer = new OutputStreamWriter(conn.outputStream)
        writer.write(data)
        writer.flush()
        writer.close()
    }
    def result = conn.content.text
    // 输出请求结果
    // result.each({ println it })
    return result
}
