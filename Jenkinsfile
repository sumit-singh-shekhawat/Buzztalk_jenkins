pipeline{
    agent{label 'master'}
    tools{maven 'M3'}
    stages{
        stage('Checkout'){
            steps{
                git branch: 'master', url: 'https://github.com/akhadepramodini/Buzztalk_jenkins.git'
            }
        }
	 stages
	    {
        stage('build') 
		    {
            steps {
                sh 'mvn --version'
            }
        }
        }
        stage('Test'){
            steps{
                bat 'mvn test'
            }
        }
        stage('Package'){
            steps{
                bat 'mvn package'
            }
        }
    }
}


