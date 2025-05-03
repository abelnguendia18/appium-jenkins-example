pipeline {
    agent any
    environment {
        JAVA_HOME = "/Library/Java/JavaVirtualMachines/jdk-17.0.2.jdk/Contents/Home"
        ANDROID_HOME = "${HOME}/Library/Android/sdk"
        PATH = "${env.PATH}:${ANDROID_HOME}/platform-tools"
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/abelnguendia18/appium-jenkins-example.git'
            }
        }
        stage('Start Appium') {
            steps {
                sh 'appium --log-level info &'
                sleep 10
            }
        }
        stage('Run Tests') {
            steps {
                sh 'mvn clean test'
            }
        }
    }
}
