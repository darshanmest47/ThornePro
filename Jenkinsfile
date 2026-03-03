pipeline {
    agent any

    // 1. Define the schedule
    triggers {
        // Run at 09:00 AM every day
        cron('0 9 * * *')
        // Run at 03:00 PM every day
        cron('0 15 * * *')
    }

    parameters {
        choice(name: 'RUNNER',
                choices: ['Junit4Runner', 'FailedTestRunner'],
                description: 'Manual selection (Scheduled builds auto-select based on time)')
    }

    stages {
        stage('Determine Runner') {
            steps {
                script {
                    // 2. Logic to auto-select the runner based on the current hour
                    def currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

                    if (currentHour == 9) {
                        env.SELECTED_RUNNER = "Junit4Runner"
                    } else if (currentHour == 15) {
                        env.SELECTED_RUNNER = "FailedTestRunner"
                    } else {
                        // If triggered manually, use the parameter
                        env.SELECTED_RUNNER = params.RUNNER
                    }
                    echo "Executing: ${env.SELECTED_RUNNER}"
                }
            }
        }

        stage('Checkout') {
            steps {
                checkout scm //
            }
        }

        stage('Run Cucumber Tests') {
            steps {
                // 3. Use the determined runner
                bat "mvn test -Dtest=${env.SELECTED_RUNNER}"
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml' //
            archiveArtifacts artifacts: 'target/*.html', allowEmptyArchive: true
        }
        success {
            emailext (
                    subject: "SUCCESS: ${env.SELECTED_RUNNER} [${env.BUILD_NUMBER}]",
                    body: "Scheduled run for ${env.SELECTED_RUNNER} passed!",
                    to: 'darshanmesta47@hotmail.com', //
                    mimeType: 'text/html'
            )
        }
    }
}