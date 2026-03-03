pipeline {
    agent any

    // This block ensures the UI parameters match your script
    parameters {
        choice(name: 'RUNNER',
                choices: ['FailedTestRunner', 'Junit4Runner'],
                description: 'Select the runner that needs to be executed')
    }

    stages {
        stage('Checkout') {
            steps {
                // Jenkins pulls code from your GitHub repo
                checkout scm
            }
        }

        stage('Run Cucumber Tests') {
            steps {
                // Executes the Maven command with the parameter selected in Jenkins
                bat "mvn test -Dtest=${params.RUNNER}"
            }
        }
    }

    post {
        always {
            // Processes JUnit XML files for the Jenkins "Test Result Trend" chart
            junit '**/target/surefire-reports/*.xml'

            // Archives the HTML report so it's viewable directly in the Jenkins UI
            archiveArtifacts artifacts: 'target/*.html', allowEmptyArchive: true
        }

        success {
            // Sends email using the Email Extension Plugin
            emailext (
                    subject: "SUCCESS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                    body: """<p>SUCCESS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'</p>
                         <p>The tests passed successfully.</p>
                         <p>View the full report here: <a href='${env.BUILD_URL}artifact/target/cucumber-report.html'>Cucumber HTML Report</a></p>
                         <p>Check the build details: <a href='${env.BUILD_URL}'>${env.JOB_NAME} Build #${env.BUILD_NUMBER}</a></p>""",
                    to: 'darshanmesta47@hotmail.com', // Your verified recipient
                    mimeType: 'text/html'
            )
        }

        failure {
            emailext (
                    subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                    body: """<p>FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'</p>
                         <p>The build failed. Please check the logs to identify the issue.</p>
                         <p>Console Output: <a href='${env.BUILD_URL}console'>View Console Logs</a></p>""",
                    to: 'darshanmesta47@hotmail.com',
                    mimeType: 'text/html'
            )
        }
    }
}