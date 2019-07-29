
# Devops Commands

# Docker

List of images:
`$ docker images`

In your Dockerfile:
 EXPOSE 3000 80 443 22
 

To expose just one port, this is what you need to do:
`$ docker run -p <host_port>:<container_port>`

To expose multiple ports, simply provide multiple -p arguments:
`$ docker run -p <host_port1>:<container_port1> -p <host_port2>:<container_port2>`

In case you would like to expose a range of continuous ports, you can run docker like this:
 `docker run -it -p 7100-7120:7100-7120/tcp `

Eg.
 `$ docker run -p 3001:3000 -p 23:22`

List running docker process:
`$ docker ps`

>Important URL - 
 - [https://stackoverflow.com/questions/34004076/difference-between-docker-registry-and-repository](https://link) 
 - [https://stackoverflow.com/questions/23735149/what-is-the-difference-between-a-docker-image-and-a-container](https://link)
 - [https://stackoverflow.com/questions/31115098/in-docker-what-is-the-difference-between-an-image-and-a-repository](https://link)
 
 
 


#  Kubernates

Deploying the Dashboard UI

`kubectl create -f https://raw.githubusercontent.com/kubernetes/dashboard/master/aio/deploy/recommended/kubernetes-dashboard.yaml`
 
For open Dashboard
`$minikube dashboard` 

For accessing the Dashboard
`$kubectl proxy`

 >Running Kubernetes Locally via Minikube

Starting the app:

`$ minikube start`

Running sample app:

`$ kubectl run hello-minikube --image=k8s.gcr.io/echoserver:1.10 --port=8080`

View the Deployment:
`$ kubectl get deployments`

Exposing the app:
`$ kubectl expose deployment hello-minikube --type=NodePort`

Get the pod list:
`$ kubectl get pods`

View the Service:
`$ kubectl get services`

View service with pritty view:
`$ kubectl get services -o json`

View cluster events:
`$ kubectl get events`

View the kubectl configuration:
`$ kubectl config view`

Get the sample app url by curl:
`$ curl $(minikube service hello-minikube --url)`

>Stopping a Cluster:

`$ minikube stop`

Deleting a Cluster:
`$ minikube delete`
eg. `$ kubectl delete services hello-minikube`
eg. `$ kubectl delete deployment hello-minikube`
eg. `$ minikube stop`

Delete minikube data:
`rm -rf  ~/.minikube`

>Enable addons

List the currently supported addons:
`$ minikube addons list`

Enable an addon, for example, heapster:
`$ minikube addons enable heapster`

View the Pod and Service you just created:
`$ kubectl get pod,svc -n kube-system`

Disable heapster:
`$ minikube addons disable heapster`

Add namespace:
`$ kubectl create namespace istio-system`

Get crds:
`$ kubectl get crd`

 Step to execute CRDs init:
 `$ for i in install/kubernetes/helm/istio-init/files/crd*yaml; do kubectl apply -f $i; done`

>Clean up

Now you can clean up the resources you created in your cluster:
`$ kubectl delete service hello-node`
`$ kubectl delete deployment hello-node`

>Creating sample user

Copy provided snippets to some dashboard-adminuser.yaml file and use kubectl apply -f dashboard-adminuser.yaml to create them.

`apiVersion: v1
kind: ServiceAccount
metadata:
  name: admin-user
  namespace: kube-system`
  
  >Bearer Token
  
  `kubectl -n kube-system describe secret $(kubectl -n kube-system get secret | grep admin-user | awk '{print $1}')`
  
  >Rabbit MQ
  
  https://hub.docker.com/_/rabbitmq/
  
 docker run --name pankoo-rabbit -p 8080:15672 rabbitmq:3-management

 # Mongo Db commands:

# Important linux command

For finding file in folder 

`$ find | grep <any file name>` 

# virtual box

Install virtual box:
`$ sudo apt-get install virtualbox`

Get version details:
`vboxmanage --version`

To remove VirtualBox:
`$ sudo apt-get remove virtualbox-\*`

Remove global configuration files too:
`$ sudo apt-get purge virtualbox-\*`

delete all virtual machines and settings and Virtual Hard Drives:

`sudo rm ~/"VirtualBox VMs" -Rf`
`sudo rm ~/.config/VirtualBox/ -Rf`  

Check virtual box process:
`$ sudo ps aux | grep -i "vbox"`

Kill any "ghost" processes:
`$ sudo pkill VBox*`

# Git Commands

Commit and Push to repo
`$ git commit -m "Added folder structure " && git push origin master`

# Docker commands

Before performing the removal command, you can get a list of all non-running (stopped) containers that will be removed using the following command:
`docker container ls -a --filter status=exited --filter status=created`

For remove:
        - all stopped containers
        - all networks not used by at least one container
        - all dangling images
        - all build cache

`$ sudo docker system prune`

List of all active and inactive container
`$ docker container ls -a`

For removing container:
`$ docker container rm <container_Id 1> <container_id2>`

Remove containers using filters
`$ docker container prune --filter "until=12h"`

To stop all running containers use the docker container stop command followed by a list of all containers IDs.
`$ docker container stop $(docker container ls -aq)`

Once all containers are stopped you can remove them using the docker container stop command followed by the containers ID list.
`$ docker container rm $(docker container ls -aq)`

> Removing Docker Images

For finding images:
`$ docker image ls`

For remove image: 
`$ docker image rm <ImageId_1>  <ImageId_2>`

> Remove dangling images

`$ docker image prune`

Remove all unused images

`$ docker image prune -a`

Remove images using filters

`$ docker image prune -a --filter "until=12h"`

> Removing Docker Volumes

First find the list of docker volume

`$ docker volume ls`

Remove volume:
`$ docker volume rm 4e12af8913af888ba67243dec78419bf18adddc3c7a4b2345754b6db64293163`

Remove all unused volumes:
`$ docker volume prune`

> Removing Docker Networks

Find the network:
`$ docker network ls`

Remove the network:
`$ docker network rm <Network Name>`

open container:
`$ sudo docker exec -it <ContainerId> sh`

# Elastic Search 

1. Start by updating the packages index and installing the apt-transport-https package that necessary to access a repository over HTTPS:

`$ sudo apt update`
`$ sudo apt install apt-transport-https`

2. Import the repository’s GPG using the following wget command:
`$ wget -qO - https://artifacts.elastic.co/GPG-KEY-elasticsearch | sudo apt-key add -`
 Output: `OK`

3. Add the Elasticsearch repository to the system by issuing:
`$ sudo sh -c 'echo "deb https://artifacts.elastic.co/packages/7.x/apt stable main" > /etc/apt/sources.list.d/elastic-7.x.list'`

4. Once the repository is enabled, update the apt package list and install the Elasticsearch engine by typing:
`$ sudo apt update`
`$ sudo apt install elasticsearch`

5. Elasticsearch service will not start automatically after the installation process is complete. To start the service and enable the service run:
`$ sudo systemctl enable elasticsearch.service`
`$ sudo systemctl start elasticsearch.service`
`$ sudo systemctl stop elasticsearch.service`

6. Verify that Elasticsearch
`$ curl -X GET "localhost:9200/"`
Output: 
        ` {
  "name" : "kwEpA2Q",
  "cluster_name" : "elasticsearch",
  "cluster_uuid" : "B-5B34LXQFqDeIYwSgD3ww",
  "version" : {
    "number" : "7.0.0",
    "build_flavor" : "default",
    "build_type" : "deb",
    "build_hash" : "b7e28a7",
    "build_date" : "2019-04-05T22:55:32.697037Z",
    "build_snapshot" : false,
    "lucene_version" : "8.0.0",
    "minimum_wire_compatibility_version" : "6.7.0",
    "minimum_index_compatibility_version" : "6.0.0-beta1"
  },
  "tagline" : "You Know, for Search"
} `

> Note
It will take 5-10 seconds for the service to start. If you see curl: (7) Failed to connect to localhost port 9200: Connection refused, wait for a few seconds and try again.

>Configuring Elasticsearch

Elasticsearch data is stored in the /var/lib/elasticsearch directory, configuration files are located in /etc/elasticsearch and Java start-up options can be configured in the /etc/default/elasticsearch file.

Edit configuration file in your favorite text editor and update it:

`sudo vi /etc/elasticsearch/elasticsearch.yml`

Change the following values:
`network.host: localhost
 cluster.name: myCluster1
 node.name: "myNode1" `