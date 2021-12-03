pipeline{
    agent{label 'master'}
    tools{maven 'M3'}
    stages{
        stage('Checkout'){
            steps{
                git branch: 'master', url: 'https://github.com/akhadepramodini/Buzztalk_jenkins.git'
            }
        }
	
        stage('build') 
		    {
            steps {
                bat 'mvn --version'
            }
        
        }
        stage('Test'){
            steps{
                bat 'mvn --version'
            }
        }
        stage('Package'){
            steps{
                bat 'mvn --version'
            }
        }
    }
}


