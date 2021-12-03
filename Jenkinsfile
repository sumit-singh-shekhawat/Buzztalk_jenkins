pipeline{
    agent{label 'master'}
    tools{maven 'M3'}
    stages{
        stage('Checkout'){
            steps{
                git branch: 'master', url: 'https://github.com/akhadepramodini/Buzztalk_jenkins.git'
            }
        }
	 stage('Build'){
            steps{
                bat 'mvn compile'
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


