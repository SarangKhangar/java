Jenkins

It is build automation tool
it helps to automate software development related to building, testing, generating test report, deploying
It facilate to Continuous Integration (CI) and Continuous Delivery (CD).
Jenkins works with the help of plugnis.
It is one of the most popular tool and it has large community supports
-----------------------------------------------------------------------------------------------------------------
DevOps

DevOps is set of practices it combines development and It operations.
Aim of DevOps is to continuous delivery and software quality.
Jenkins one of the important tool for DevOps.
-----------------------------------------------------------------------------------------------------------------
Steps for working with jenkins dashboard

1.Create a job(select type of job)
2.Name a job
3.Optionally we can describe job
4.Configure the job
5.Build the job
-----------------------------------------------------------------------------------------------------------------
Jenkins pipeline

1.pipeline is collection of job which are inter linked with one another in a sequence
2.Output of the pipeline can be viewed using stage view
3.In stage view it will be graphical representation of every stage
if every is green then pipeline is success
4.Example of pipeline

pipeline {
agent any
stages {
stage('Checkout') {
steps {
git 'https://github.com/mohammadazeez963/javaProject.git'
}
}
stage('Compile') {
steps {
echo 'Compiling'
}
}
stage('Run') {
steps {
echo 'Running'
}
}

stage('Test report using jacoco') {
steps {
echo 'jacoco'
}
}

stage('Building Docker Image') {
steps {
echo 'Building Docker Image'
}
}
}
 