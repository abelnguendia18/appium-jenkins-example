pipeline {
    agent any
    environment {
        JAVA_HOME = "/Library/Java/JavaVirtualMachines/jdk-17.0.2.jdk/Contents/Home"
        ANDROID_HOME = "${HOME}/Library/Android/sdk"
        NODE_PATH = "${HOME}/.nvm/versions/node/v22.14.0/bin"
        PATH = "${NODE_PATH}:/opt/homebrew/bin:${env.PATH}:${ANDROID_HOME}/platform-tools"
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'development', url: 'https://github.com/abelnguendia18/appium-jenkins-example.git'
            }
        }
        stage('Start Appium') {
            steps {
                sh '/Users/abelnguendiat./.nvm/versions/node/v22.14.0/bin/appium --log-level info &'
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