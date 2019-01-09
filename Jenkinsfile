node{

   stage('SCM Checkout'){
      git credentialsId: 'GitHubCredentials', url: 'https://github.com/saikatmnet/Git-DevOps.git'
   }
   
   stage('Mvn Package'){
     def mvnHome = tool name: 'maven-3', type: 'maven'
     def mvnCMD = "${mvnHome}\\bin\\mvn"
     bat "${mvnCMD} clean package"
    }
   
   stage('Build Docker Image'){
     bat 'docker build -t saikatmnet/devops-microservice:1.0.0 .'
   }
      
   stage('Push Docker Image'){
	withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerHubPwd')]) {
        bat "docker login -u saikatmnet -p ${dockerHubPwd}"
	}
     bat 'docker push saikatmnet/devops-microservice:1.0.0'
   }

   stage('Run Container on Dev Server'){
     def dockerRun = 'docker run -p 8080:8085 -d --name my-devops-microservice saikatmnet/devops-microservice:1.0.0'
	sshagent(['dev-server']) {
     bat "ssh -o StrictHostKeyChecking=no ec2-user@18.216.173.209 ${dockerRun}"
	}
   }

}