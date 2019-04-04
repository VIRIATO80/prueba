node{
   stage('SCM Checkout'){
     git 'https://github.com/VIRIATO80/prueba'
   }
   stage('Compile-Package'){
      // Get maven home path
      def mvnHome =  tool name: 'maven-3', type: 'maven'   
      sh "${mvnHome}/bin/mvn package"
   }
   
   stage('SonarQube Analysis') {
   	 def scannerHome = tool 'SonarQube_scanner'
	 withSonarQubeEnv('SonarQube_server') {
	    sh 'mvn clean package sonar:sonar'
	 }
   }
   
   stage('Email Notification'){
      mail bcc: '', body: '''Hi Welcome to jenkins email alerts
      Thanks
      Hari''', cc: '', from: '', replyTo: '', subject: 'Jenkins Job', to: 'javi.lindo@gmail.com'
   }
}