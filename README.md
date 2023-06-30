# For Jenkins pipeline for building project and Docker Compose in docker hub.

pipeline{
    agent any
    tools{
        maven 'M3'
    }
    stages{
        stage('Maven Build'){
            steps{
               checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'github_ssh_key', url: 'git@github.com:Gnanesh8/Assignment.git']])
                bat 'mvn clean install'
            }
        }
        stage('Build Docker Image'){
            steps{
                bat 'docker build -t app .'
            }
        }
        stage('run Docker on Jenkins Agent'){
            steps{
                 bat 'docker container run --network api --name assignment-api-container -p 8082:8081 -d assignment'
            }
        }
    }
}
