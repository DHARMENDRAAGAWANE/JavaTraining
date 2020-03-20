#!groovy

properties(
    [
        [$class: 'BuildDiscarderProperty', strategy:
          [$class: 'LogRotator', artifactDaysToKeepStr: '14', artifactNumToKeepStr: '5', daysToKeepStr: '30', numToKeepStr: '60']],
        pipelineTriggers(
          [
              pollSCM('H/15 * * * *'),
              cron('@daily'),
          ]
        )
    ]
)
node {
    stage('Checkout') {
        //disable to recycle workspace data to save time/bandwidth
        deleteDir()
        checkout scm

        //enable for commit id in build number
        //env.git_commit_id = sh returnStdout: true, script: 'git rev-parse HEAD'
        //env.git_commit_id_short = env.git_commit_id.take(7)
        //currentBuild.displayName = "#${currentBuild.number}-${env.git_commit_id_short}"
    }

    stage('NPM Install') {
        withEnv(["NPM_CONFIG_LOGLEVEL=warn"]) {
		dir("sonar-demo"){
	    sh 'ls -rt'
            sh 'npm install'
		}
        }
    }

    stage('Test') {
 //withEnv(["CHROME_BIN=/usr/bin/chromium-browser"]) {
withEnv(["NPM_CONFIG_LOGLEVEL=warn"]) {
  dir("sonar-demo"){       
 sh 'ng test --watch=false --browsers=ChromeHeadless'
  }
        }
        //junit '**/test-results.xml'
    }

    stage('Lint') {
       dir("sonar-demo"){
        sh 'ng lint'
}
    }

    stage("sonarqube"){
        dir("sonar-demo"){
            sh 'npm run sonar'
        }

    }

    stage('Build') {
        milestone()
dir("sonar-demo"){        
sh 'ng build --prod --aot  --progress=false'
}    }

    stage('Archive') {
        dir("sonar-demo"){     
        sh 'tar -cvzf dist.tar.gz --strip-components=1 dist'
        archive 'dist.tar.gz'
        }

    }

    stage('Deploy') {
        milestone()
        echo "Deploying..."
    }
}
