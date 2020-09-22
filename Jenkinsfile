pipeline {
    agent any

    stages {
        stage('SCM-Checkout') {
            steps {
                git 'https://github.com/ryanmeoni/Calculator.git'
            }
        }
        stage('Compile-Package') {
            steps {
                sh 'mvn package'
            }
        }
    }
}
