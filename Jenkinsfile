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
   	 def mvnHome =  tool name: 'maven-3', type: 'maven'   
	 withSonarQubeEnv('SonarQube_server') {
	    sh "${mvnHome}/bin/mvn clean package sonar:sonar"
	 }
   }
   
}