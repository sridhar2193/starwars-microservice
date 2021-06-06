//version and sleep time can be provided through parameters
node {
        stage('Scm checkout') {
            git credentialsId: 'git_secret', url: 'https://github.com/sridhar2193/starwars-microservice.git'
        }
        stage('Maven') {
            sh 'mvn clean install'
        }
        stage('Build Docker images') {
            echo 'Building discovery-service'
            sh 'docker build -t sridhar2193/discovery-service:${version} ./discovery-service'
            echo 'Building gateway-service'
            sh 'docker build -t sridhar2193/gateway-service:${version} ./gateway-service'
            echo 'Building starwars-service'
            sh 'docker build -t sridhar2193/starwars-service:${version} ./starwars-service'
        }
        stage('Push Docker images') {
            withCredentials([string(credentialsId: 'docker_pwd', variable: 'docker_pwd')]) {
                sh "docker login -u sridhar2193 -p ${docker_pwd}"
            }
            echo 'Pushing discovery-service'
            sh 'docker push sridhar2193/discovery-service:${version}'
            echo 'Pushing gateway-service'
            sh 'docker push sridhar2193/gateway-service:${version}'
            echo 'Pushing starwars-service'
            sh 'docker push sridhar2193/starwars-service:${version}'
        }
        stage('Publish docker images') {
            sh 'docker-compose up'
            sh "sleep ${Sleep}"
            sh 'docker-compose down'
        }
}
