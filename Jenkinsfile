pipeline {
    agent any

    // 1. Define the schedule for automatic runs
    triggers {
        // Run at 09:00 AM every day
        cron('0 9 * * *')
        // Run at 03:00 PM every day
        cron('0 15 * * *')
    }

    // Parameters for manual triggers
    parameters {
        choice(name: 'RUNNER',
                choices: ['Junit4Runner', 'FailedTestRunner'],
                description: 'Manual selection (Scheduled builds auto-select based on time)')
    }

    stages {
        stage('Determine Runner') {
            steps {
                script {
                    // Logic to auto-select the runner based on the current hour
                    // Calendar.HOUR_OF_DAY uses 24-hour format
                    def currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

                    if (currentHour == 9) {
                        env.SELECTED_RUNNER = "Junit4Runner"
                    } else if (currentHour == 15) {
                        env.SELECTED_RUNNER = "FailedTestRunner"
                    } else {
                        // If triggered manually or via GitHub push, use the UI parameter
                        env.SELECTED_RUNNER = params.RUNNER
                    }
                    echo "Selected Runner for this execution: ${env.SELECTED_RUNNER}"
                }
            }
        }

        stage('Checkout') {
            steps {
                // Pulls the latest code from your GitHub repository
                checkout scm
            }
        }

        stage('Run Cucumber Tests') {
            steps {
                // Executes Maven test using the runner determined in the first stage
                bat "mvn test -Dtest=${env.SELECTED_RUNNER}"
            }
        }
    }

    post {
        always {
            // Processes the XML test results for the Jenkins dashboard
            junit '**/target/surefire-reports/*.xml'
            // Saves the HTML report as an artifact to view in the browser
            archiveArtifacts artifacts: 'target/*.html', allowEmptyArchive: true
        }

        success {
            // Sends email using the Email Extension Plugin
            emailext (
                    subject: "SUCCESS: ${env.SELECTED_RUNNER} - Build #${env.BUILD_NUMBER}",
                    body: """<p>The scheduled run for <b>${env.SELECTED_RUNNER}</b> completed successfully.</p>
                         <p>Build Number: ${env.BUILD_NUMBER}</p>
                         <p>View the full report here: <a href='${env.BUILD_URL}artifact/target/cucumber-report.html'>Cucumber HTML Report</a></p>
                         <p>Check the build logs: <a href='${env.BUILD_URL}'>Jenkins Build Link</a></p>""",
                    to: 'darshanmesta47@hotmail.com', // Your verified recipient
                    mimeType: 'text/html'
            )
        }

        failure {
            emailext (
                    subject: "FAILED: ${env.SELECTED_RUNNER} - Build #${env.BUILD_NUMBER}",
                    body: """<p>The run for <b>${env.SELECTED_RUNNER}</b> has failed.</p>
                         <p>Please check the console output to debug: <a href='${env.BUILD_URL}console'>Console Logs</a></p>""",
                    to: 'darshanmesta47@hotmail.com',
                    mimeType: 'text/html'
            )
        }
    }
}