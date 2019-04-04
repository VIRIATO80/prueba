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
	   	environment {
	        scannerHome = tool 'SonarQube_scanner'
	    }
   
	    steps {
	        withSonarQubeEnv('SonarQube_server') {
	            sh "${scannerHome}/bin/sonar-scanner"
	        }
	        timeout(time: 10, unit: 'MINUTES') {
	            waitForQualityGate abortPipeline: true
	        }
	    }
    }
   
   stage('Email Notification'){
      mail bcc: '', body: '''Hi Welcome to jenkins email alerts
      Thanks
      Hari''', cc: '', from: '', replyTo: '', subject: 'Jenkins Job', to: 'javi.lindo@gmail.com'
   }
}