node{

   stage('SCM Checkout'){
      git credentialsId: 'GitHubCredentials', url: 'https://github.com/saikatmnet/Git-DevOps.git'
   }
   
   stage('Mvn Package'){
     def mvnHome = tool name: 'maven-3', type: 'maven'
     def mvnCMD = "${mvnHome}\\bin\\mvn"
     sh "${mvnCMD} clean package"
    }
   
   stage('Build Docker Image'){
     sh 'docker build -t saikatmnet/devops-microservice:1.0.0 .'
   }
      
   stage('Push Docker Image'){
	withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerHubPwd')]) {
        sh "docker login -u saikatmnet -p ${dockerHubPwd}"
	}
     sh 'docker push saikatmnet/devops-microservice:1.0.0'
   }

   stage('Run Container on Dev Server'){
     def dockerRun = 'docker run -p 8085:8085 -d --name my-devops-microservice saikatmnet/devops-microservice:1.0.0'
	sshagent(['dev-server']) {
     sh "ssh -o StrictHostKeyChecking=no ec2-user@18.216.173.209 ${dockerRun}"
	}
   }

}