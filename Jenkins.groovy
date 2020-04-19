pipeline {
    agent {
        node {
        label 'my-linux'
      }
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
        stage('Push to Master') {
            steps {
                echo 'Pushig to Master....'
                sh"""
                set +x
                git config --global user.name 
                git config --global user.email
                set -x
                git remote set-url origin https://github.com/santhoshvelusamy/Run-Apache.git
                git status
                git add .
                git commit -m "Pushing" | true
                git push -u origin master
                """
            }
        }
    }

}