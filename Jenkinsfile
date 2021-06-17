@Library('jenkins-share-lib') _

// 创建 HTTP 类实例
def http = new org.devops.HTTP()

pipeline {
	agent any

	stages {
		stage("发送 POST 请求") {
			steps {
				println http.post("https://httpbin.org/post")
			}
		}

		stage("获取主机公网 IP") {
			steps {
				println getIP()
			}
		}
	}
}