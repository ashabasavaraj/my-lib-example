def call(ip,creds,user){
  sshagent(['${creds}']) {
     sh "scp -o StrictHostKeyChecking=no /var/lib/jenkins/workspace/CI-CD-deploy/target/*.war ${user}@${ip}:/opt/tomcat9/webapps/"
        
    sh " ssh ${user}@${ip} /opt/tomcat9/bin/shutdown.sh "   
     sh " ssh ${user}@${ip} /opt/tomcat9/bin/startup.sh " 
               }
            }
    
  
