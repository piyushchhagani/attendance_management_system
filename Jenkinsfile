pipeline {

    agent any

    tools {
        jdk 'JDK-21'
        maven 'Maven-3.9.15'
    }

    environment {

        AWS_REGION = 'ap-south-1'

        ECR_REPO = '971586140507.dkr.ecr.ap-south-1.amazonaws.com/attendance-management-system'

        IMAGE_TAG = "${BUILD_NUMBER}"
    }

    stages {

        stage('Clone Repository') {

            steps {

                git branch: 'main',
                url: 'https://github.com/piyushchhagani/attendance_management_system.git'
            }
        }

        stage('Build Application') {

            steps {

                bat 'mvn clean package'
            }
        }

        stage('Run Tests') {

            steps {

                bat 'mvn test'
            }
        }

        stage('Build Docker Image') {

            steps {

                bat 'docker build -t attendance-management-system:%BUILD_NUMBER% .'
            }
        }

        stage('Login to AWS ECR') {

            steps {

                withAWS(credentials: 'aws-credentials', region: 'ap-south-1') {

                    bat '''
                    aws ecr get-login-password --region %AWS_REGION% | docker login --username AWS --password-stdin %ECR_REPO%
                    '''
                }
            }
        }

        stage('Tag Docker Image') {

            steps {

                bat '''
                docker tag attendance-management-system:%BUILD_NUMBER% %ECR_REPO%:%BUILD_NUMBER%
                '''
            }
        }

        stage('Push Docker Image') {

            steps {

                bat '''
                docker push %ECR_REPO%:%BUILD_NUMBER%
                '''
            }
        }
    }

    post {

        success {

            mail to: 'piyushchhagani03@gmail.com',
            subject: "SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
            body: """
Build Successful!

Job Name: ${env.JOB_NAME}
Build Number: ${env.BUILD_NUMBER}

Docker Image Pushed Successfully to AWS ECR.

Console Output:
${env.BUILD_URL}
"""

            echo 'Pipeline executed successfully!'
        }

        failure {

            mail to: 'piyushchhagani03@gmail.com',
            subject: "FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
            body: """
Build Failed!

Job Name: ${env.JOB_NAME}
Build Number: ${env.BUILD_NUMBER}

Check Console Output:
${env.BUILD_URL}
"""

            echo 'Pipeline failed!'
        }
    }
}
