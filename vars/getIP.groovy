import groovy.json.JsonSlurper

def call() {
	// 调用 src 目录的类
	def http = new org.devops.HTTP()
	response = http.post('https://httpbin.org/ip')
	def json = new JsonSlurper()
    def response = json.parseText(response)
	return response.origin
}