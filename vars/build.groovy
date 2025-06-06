def call(String project, String tags){
  echo "this is building the code"
  sh "docker build -t ${project}:${tags} ."
}
