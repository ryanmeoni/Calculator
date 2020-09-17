pipeline {

    stages {
        stage('SCM Checkout') {
            git 'https://github.com/ryanmeoni/Calculator.git'
        }
        stage('Compile-Package') {
            sh 'mvn package'
        }
    }
}
