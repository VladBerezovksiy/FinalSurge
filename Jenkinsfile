pipeline {

    agent any

    tools {
        maven "Maven"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: '$BRANCH', url: 'https://github.com/VladBerezovksiy/FinalSurge.git'

//               sh "mvn clean test -Dmaven.test.failure.ignore=true -Dmaven.compiler.source=11 -Dmaven.compiler.target=11"
            }

            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }

        stage("Run Tests") {
            steps {
                script {
                    docker.image("maven:3.8.5-jdk-11-slim").inside {
                        sh "mvn clean test -Dmaven.test.failure.ignore=true -Dmaven.compiler.source=11 -Dmaven.compiler.target=11"
                    }
                }
            }
        }
    }

        stage('reports') {
            steps {
                script {
                    allure([
                            includeProperties: false,
                            jdk: '',
                            properties: [],
                            reportBuildPolicy: 'ALWAYS',
                            results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
}