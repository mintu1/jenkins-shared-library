def call(String project, String tags){
    withCredentials([usernamePassword(credentialsId: "dockerHubCred", passwordVariable: "dockerHubPass", usernameVariable: "dockerHubUser")]){
    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
    sh "docker image tag ${project}:${tags} ${env.dockerHubUser}/${project}:${tags}"
    sh "docker push ${env.dockerHubUser}/${project}:${tags}"
    }
}


                
