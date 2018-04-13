node {


  stage('Clean-up') {

       try {
        // Stop containers here
        sh 'docker-compose down'
       } catch (error) {} finally {}

       try {
        // Stop containers here
        sh 'docker container stop helix-web'
       } catch (error) {} finally {}

       try {
        // Stop containers here
        sh 'docker container stop helix-mysql'
       } catch (error) {} finally {}

       try {
        // Stop and remove database container here
        sh 'docker container rm helix-web'
       } catch (error) {} finally {}

       try {
        // Stop and remove database container here
        sh 'docker container rm helix-mysql'
       } catch (error) {} finally {}
  }

  stage('Checkout') {
   git url: 'https://therageofpain@bitbucket.org/therageofpain/helix.git', credentialsId: 'bitbucketId', branch: 'master'
  }



   docker.image('maven:3.5.2-jdk-8-alpine').inside("-v $HOME/.m2:/root/.m2") {
    withMaven(maven: 'maven') {
      stage('Build') {
       sh 'mvn clean package -DskipTests'
      }
    }
   }

  stage('Build image') {
    /* This builds the actual image; synonymous to docker build on the command line */
    def app = docker.build("helix-web")
  }

  stage('Run Application') {
    try {
        // sh "docker run -p 3306:3306 --name helix-mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE='helixdatabase' --mount source=helix-mysql-persistent-storage,target=/var/lib/mysql -d mysql:5.7"
        // sh "docker run -p 8081:8081 --name helix-web --link helix-mysql:mysql -d helix-web"
        sh "docker-compose up"
    } catch (error) {
        // Stop and remove database container here
        sh 'docker container stop helix-web helix-mysql'
        sh 'docker container rm helix-web helix-mysql'
    } finally { }
  }
}