pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub')
        DOCKER_USER = 'houssem1304'

        FRONT_IMAGE = 'amsfrontend2026'
        BACK_IMAGE  = 'amsbackend2026'

        TAG = 'v1'
    }

    stages {

        stage('Clean Workspace') {
            steps {
                deleteDir()
            }
        }

        stage('Clone Front Repository') {
            steps {
                dir('ams_front') {
                    git branch: 'main',
                    url: 'https://github.com/houssemgit2/ams_front.git'
                }
            }
        }

        stage('Clone Back Repository') {
            steps {
                dir('ams_back') {
                    git branch: 'main',
                    url: 'https://github.com/houssemgit2/ams_back.git'
                }
            }
        }

        stage('Build Front Docker Image') {
            steps {
                dir('ams_front') {
                    bat """
                    docker build -t %DOCKER_USER%/%FRONT_IMAGE%:%TAG% .
                    """
                }
            }
        }

        stage('Build Back Docker Image') {
            steps {
                dir('ams_back') {
                    bat """
                    docker build -t %DOCKER_USER%/%BACK_IMAGE%:%TAG% .
                    """
                }
            }
        }

        stage('Login DockerHub') {
            steps {
                bat """
                docker login -u %DOCKERHUB_CREDENTIALS_USR% -p %DOCKERHUB_CREDENTIALS_PSW%
                """
            }
        }

        stage('Push Images DockerHub') {
            steps {
                bat """
                docker push %DOCKER_USER%/%FRONT_IMAGE%:%TAG%
                docker push %DOCKER_USER%/%BACK_IMAGE%:%TAG%
                """
            }
        }

        stage('Deploy Application') {
            steps {
                dir('ams_back') {
                    bat """
                    docker compose down
                    docker compose pull
                    docker compose up -d
                    """
                }
            }
        }

        stage('Docker Cleanup') {
            steps {
                bat """
                docker image prune -f
                """
            }
        }
    }

    post {

        success {
            echo '✅ AMS déployé avec succès'
        }

        failure {
            echo '❌ Build ou déploiement échoué'
        }

        always {
            bat 'docker logout'
        }
    }
}