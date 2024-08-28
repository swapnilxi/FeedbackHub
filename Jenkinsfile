pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/Added-Jenkins-file']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/saksham000/FeedbackHub-Forked']])
                bat 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    bat 'docker build -t saksham00/saksham-jenkins:feedbackhub-v1 .'
                }
            }
        }
        stage('Push Docker image to Hub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhub-pass-2', variable: 'dockerhubpwd')]) {
}
                    bat 'docker push saksham00/saksham-jenkins:feedbackhub-v1'
                }
            }
        }
    }
}