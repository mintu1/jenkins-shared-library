def call(String project, String tags, String userName){
    withCredentials([usernamePassword(credentialsId: "dockerHubCred", passwordVariable: "dockerHubPass", usernameVariable: "dockerHubUser")]){
    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
    sh "docker image tag ${project}:${tags} ${userName}/${project}:${tags}"
    sh "docker push ${userName}/${project}:${tags}"
}


                
