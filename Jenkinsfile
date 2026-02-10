pipeline{
    agent any
    tools {
        maven "maven"
    }
    stages{
        stage("SCM Checkout"){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/111-java/testcicd.git']])
            }
        }
        stage("Build Process"){
            steps{
                bat 'mvn clean install'
            }
        }
        stage("Deploy to Container"){
            steps{
               deploy adapters: [tomcat9(alternativeDeploymentContext: '', credentialsId: 'tomcat-pwd1', path: '', url: 'http://localhost:9090/')], contextPath: 'jenkinscicde', war: '**/*.war'
            }
        }
    }
    post{
        always{
            emailext attachLog: true, body: '''<html>
	<body>
		<p>Build Status: ${BUILD_STATUS}</p>
		<p>Build Number: ${BUILD_NUMBER}</p>
		<p>Check the  <a href="${BUILD_URL}">Console output</a>.</p>
	</body>
</html>''', mimeType: 'text/html', replyTo: 'tripleonejava@gmail.com', subject: 'Pipeline Status: ${BUILD_NUMBER}', to: 'tripleonejava@gmail.com'
        }
    }
    
    
    
}
